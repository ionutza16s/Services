package ionutza.httpclientproject.result_receiver;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * TBD: implement Response from server using ResultReceiver mechanism
 *
 * @author ioana.morari on 10/28/2014.
 */
public class RequestResultReceiver extends ResultReceiver {

  public RequestResultReceiver(Handler handler) {
    super(handler);
  }

  @Override
  protected void onReceiveResult(int resultCode, Bundle resultData) {
    super.onReceiveResult(resultCode, resultData);
  }
}
