package ionutza.httpclientproject.request;

import ionutza.httpclientproject.logging.Logger;
import ionutza.httpclientproject.logging.LoggerFactory;
import org.apache.http.client.HttpClient;

/**
 * @author ioana.morari on 10/29/2014.
 */
public class BaseRequest {

  private final static Logger LOGGER = LoggerFactory.getInstance(BaseRequest.class);

  private HttpClient httpClient;

  public void doPost() {

  }

  public void doGet() {

  }
}
