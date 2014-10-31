package ionutza.httpclientproject.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.lang.ref.WeakReference;

/**
 * @author ioana.morari on 10/30/2014.
 */
public class ResponseBroadcastReceiver extends BroadcastReceiver {

  private WeakReference<ResponseListener> responseListener;

  public ResponseBroadcastReceiver() {

  }

  public ResponseBroadcastReceiver(ResponseListener listener) {
    this.responseListener = new WeakReference<ResponseListener>(listener);
  }

  @Override
  public void onReceive(Context context, Intent intent) {

    if (responseListener != null) {
      if (responseListener.get() != null) {
        responseListener.get().onResponseReceived(intent.getExtras());
      }
    }
  }
}
