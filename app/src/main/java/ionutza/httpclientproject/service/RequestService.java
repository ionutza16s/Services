package ionutza.httpclientproject.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import ionutza.httpclientproject.logging.Logger;
import ionutza.httpclientproject.logging.LoggerFactory;
import ionutza.httpclientproject.presentation.MainActivity;
import ionutza.httpclientproject.request.GetRequest;
import ionutza.httpclientproject.request.MyResponse;
import ionutza.httpclientproject.request.RequestType;


/**
 * Super service to execute requests to server :)
 *
 * @author ioana.morari on 10/28/2014.
 */
public class RequestService extends Service {

  public final static String REQUEST_TYPE = "request.type";
  private final static Logger LOGGER = LoggerFactory.getInstance(RequestService.class);

  private RequestHandler handler;

  @Override
  public void onCreate() {
    super.onCreate();

    HandlerThread thread = new HandlerThread("ServiceRequestThread");
    thread.start();

    handler = new RequestHandler(thread.getLooper());
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    LOGGER.d("onStartCommand(intent = %s, flags = %d, startId = %d)", intent.toString(), flags, startId);

    Message message = Message.obtain();
    message.setData(intent.getExtras());

    handler.sendMessage(message);

    return Service.START_NOT_STICKY;
  }

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onDestroy() {
    super.onDestroy();

    LOGGER.d("Stopping service!");
  }

  private class RequestHandler extends Handler {

    public RequestHandler(Looper looper) {
      super(looper);
    }

    @Override
    public void handleMessage(Message msg) {
      super.handleMessage(msg);

      LOGGER.d("handleMessage(message = %s)", msg.toString());

      RequestType requestType = (RequestType) msg.getData().getSerializable(REQUEST_TYPE);

      if (requestType == RequestType.GOGGLE_GET) {
        GetRequest request = new GetRequest();
        MyResponse response = request.execute();

        Bundle bundle = new Bundle();
        bundle.putSerializable(MyResponse.MY_RESPONSE, response);

        Intent intent = new Intent(MainActivity.RESPONSE_ACTION);
        intent.putExtras(bundle);
        sendBroadcast(intent);
      }
    }
  }
}
