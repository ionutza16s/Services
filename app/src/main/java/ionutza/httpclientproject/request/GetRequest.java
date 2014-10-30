package ionutza.httpclientproject.request;

/**
 * @author ioana.morari on 10/29/2014.
 */
public class GetRequest extends BaseRequest {

  @Override
  public Object execute() {

    Request request = Request.getInstance();
    request.doGet(BASE_URL);

    return null;
  }
}
