package ionutza.httpclientproject.presentation;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;
import ionutza.httpclientproject.R;
import ionutza.httpclientproject.broadcast_receiver.ResponseListener;
import ionutza.httpclientproject.broadcast_receiver.ResponseReceiver;
import ionutza.httpclientproject.logging.Logger;
import ionutza.httpclientproject.logging.LoggerFactory;
import ionutza.httpclientproject.request.RequestType;
import ionutza.httpclientproject.service.RequestService;


public class MainActivity extends Activity implements ResponseListener {

  public final static String RESPONSE_ACTION = "com.ioana.ResponseAction";

  private final static Logger LOGGER = LoggerFactory.getInstance(MainActivity.class);

  private ResponseReceiver responseReceiver;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);

    responseReceiver = new ResponseReceiver(this);

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
  }

  @Override
  public void onResponseReceived(Bundle response) {
    LOGGER.d("onResponseReceived()");

    Toast.makeText(getApplicationContext(), "ResponseReceived!", Toast.LENGTH_LONG).show();
  }
}
