package ionutza.httpclientproject.request;

/**
 * @author ioana.morari on 10/29/2014.
 */
public class MyResponse {

  private int statusCode;

  public MyResponse(int statusCode) {
    this.statusCode = statusCode;
  }

  public int getStatusCode() {
    return statusCode;
  }
}
