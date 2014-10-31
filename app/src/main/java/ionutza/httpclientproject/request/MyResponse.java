package ionutza.httpclientproject.request;

import java.io.Serializable;

/**
 * @author ioana.morari on 10/29/2014.
 */
public class MyResponse implements Serializable {

  public final static String MY_RESPONSE = "my.response";

  private int statusCode;

  public MyResponse(int statusCode) {
    this.statusCode = statusCode;
  }

  public int getStatusCode() {
    return statusCode;
  }

  @Override
  public String toString() {
    return "MyResponse[Status code: " + statusCode + "]";
  }
}
