package ionutza.httpclientproject.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

/**
 * Super service to execute requests to server :)
 *
 * @author ioana.morari on 10/28/2014.
 */
public class BaseService extends Service {

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

    return Service.START_NOT_STICKY;
  }

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onDestroy() {
    super.onDestroy();

    Toast.makeText(getApplicationContext(), "Stopping service!", Toast.LENGTH_LONG).show();
  }

  private static class RequestHandler extends Handler {

    public RequestHandler(Looper looper) {
      super(looper);
    }

    @Override
    public void handleMessage(Message msg) {
      super.handleMessage(msg);
    }
  }
}
