package ionutza.httpclientproject.request;

import com.google.gson.Gson;
import ionutza.httpclientproject.logging.Logger;
import ionutza.httpclientproject.logging.LoggerFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * @author ioana.morari on 10/29/2014.
 */
public class Request {

  private final static Logger LOGGER = LoggerFactory.getInstance(Request.class);

  private HttpClient httpClient;
  private Gson gsonParser;

  private static Request instance;

  public static Request getInstance() {

    if (instance == null) {
      instance = new Request();
    }

    return instance;
  }

  private Request() {
    httpClient = new DefaultHttpClient();
    gsonParser = new Gson();
  }

  public void doPost() {
    LOGGER.d("doPost()");

  }

  public MyResponse doGet(String url) {
    LOGGER.d("doGet(url = %s)", url);

    HttpGet httpGet = new HttpGet(url);

    try {
      HttpResponse response = httpClient.execute(httpGet);
      HttpEntity httpEntity = response.getEntity();

      String stringResponse = httpEntity.getContent().toString();

      if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

//        Type type = new TypeToken<T>() {
//        }.getType();
//        return gsonParser.fromJson(stringResponse, type);
      }
      else {
        LOGGER.e("Status code: " + response.getStatusLine().getStatusCode());
      }

      return new MyResponse(response.getStatusLine().getStatusCode());
    }

    catch (IOException e) {
      LOGGER.e("Get method type exception: " + e);
    }

    return null;
  }

  public void doPut() {

  }

  public void doDelete() {

  }
}
