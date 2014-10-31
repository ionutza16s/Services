package ionutza.httpclientproject.request;

/**
 * @author ioana.morari on 10/29/2014.
 */
public class GetRequest extends BaseRequest {

  @Override
  public MyResponse execute() {

    Request request = Request.getInstance();
    return request.doGet(BASE_URL);
  }
}
