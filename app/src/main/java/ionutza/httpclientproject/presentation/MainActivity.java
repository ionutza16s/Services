package ionutza.httpclientproject.presentation;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;
import ionutza.httpclientproject.R;
import ionutza.httpclientproject.broadcast_receiver.ResponseBroadcastReceiver;
import ionutza.httpclientproject.broadcast_receiver.ResponseListener;
import ionutza.httpclientproject.logging.Logger;
import ionutza.httpclientproject.logging.LoggerFactory;
import ionutza.httpclientproject.request.MyResponse;
import ionutza.httpclientproject.request.RequestType;
import ionutza.httpclientproject.service.RequestService;


public class MainActivity extends Activity implements ResponseListener {

  public final static String RESPONSE_ACTION = "com.ioana.ResponseAction";

  private final static Logger LOGGER = LoggerFactory.getInstance(MainActivity.class);

  private ResponseBroadcastReceiver responseReceiver;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);

    responseReceiver = new ResponseBroadcastReceiver(this);

    Intent intent = new Intent(this, RequestService.class);
    intent.putExtra(RequestService.REQUEST_TYPE, RequestType.GOGGLE_GET);
    startService(intent);
  }

  @Override
  protected void onResume() {
    super.onResume();

    registerReceiver(responseReceiver, new IntentFilter(RESPONSE_ACTION));
  }

  @Override
  protected void onPause() {
    super.onPause();

    unregisterReceiver(responseReceiver);
  }

  @Override
  public void onResponseReceived(Bundle response) {
    LOGGER.d("onResponseReceived()");

    MyResponse receivedResponse = (MyResponse) response.getSerializable(MyResponse.MY_RESPONSE);
    LOGGER.d("response.bundle: %s", receivedResponse.toString());

    Toast.makeText(getApplicationContext(), "ResponseReceived! Status was: " + receivedResponse.getStatusCode(),
        Toast.LENGTH_LONG).show();
  }
}
