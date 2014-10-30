package ionutza.httpclientproject.request;

import ionutza.httpclientproject.logging.Logger;
import ionutza.httpclientproject.logging.LoggerFactory;

/**
 * @author ioana.morari on 10/29/2014.
 */
public abstract class BaseRequest<T> {

  protected Logger logger = LoggerFactory.getInstance(getClass());

  protected final static String BASE_URL = "http://www.google.com";

  protected abstract T execute();

}
