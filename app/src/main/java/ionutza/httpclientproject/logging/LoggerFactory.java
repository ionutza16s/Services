package ionutza.httpclientproject.logging;

import android.util.Log;

/**
 * <p>Logger implementation which can be configured to filter log messages according to their level.</p>
 * <p/>
 * <p>The current implementation delegates all log events to the native Android {@link android.util.Log logger}.</p>
 *
 * @author cristian.vasilache
 */
@SuppressWarnings("unused")
public class LoggerFactory {

  static final int VERBOSE = 0;
  static final int DEBUG = 1;
  static final int INFO = 2;
  static final int WARNING = 3;
  static final int ERROR = 4;

  /*
   * Disables all logging. If any new logging level is defined the value will be greater to block any other logging option. 
   */
  private static final int NO_LOGGING = VERBOSE;

  /**
   * The default log level (minimum value).
   */
  private static final int LOG_LEVEL = NO_LOGGING;

  static {
    if (DEBUG >= LOG_LEVEL) {
      // Log the HTTP communication.
      java.util.logging.Logger.getLogger("org.apache.http.wire").setLevel(java.util.logging.Level.FINEST);
      java.util.logging.Logger.getLogger("org.apache.http.headers").setLevel(java.util.logging.Level.FINEST);
    }
  }

  /**
   * Creates a logger instance.
   *
   * @param clazz the class where the logger is defined.
   * @return the created instance.
   */
  public static Logger getInstance(Class<?> clazz) {
    return new ConsoleLogger(clazz.getSimpleName());
  }

  /**
   * Logger which dumps all events to the Logcat console.
   */
  private static class ConsoleLogger implements Logger {

    private String loggerName;

    private ConsoleLogger(String loggerName) {
      this.loggerName = loggerName;
    }

    @Override
    public void v(String message) {
      if (VERBOSE >= LOG_LEVEL) {
        Log.v(loggerName, message);
      }
    }

    @Override
    public void d(String message) {
      if (DEBUG >= LOG_LEVEL) {
        Log.d(loggerName, message);
      }
    }

    @Override
    public void d(String message, Object... args) {
      if (DEBUG >= LOG_LEVEL) {
        Log.d(loggerName, String.format(message, args));
      }
    }

    @Override
    public void d(String message, Throwable throwable) {
      if (DEBUG >= LOG_LEVEL) {
        Log.d(loggerName, message, throwable);
      }
    }

    @Override
    public void i(String message) {
      if (INFO >= LOG_LEVEL) {
        Log.i(loggerName, message);
      }
    }

    @Override
    public void w(String message) {
      if (WARNING >= LOG_LEVEL) {
        Log.w(loggerName, message);
      }
    }

    @Override
    public void w(String message, Throwable throwable) {
      if (WARNING >= LOG_LEVEL) {
        Log.w(loggerName, message, throwable);
      }
    }

    @Override
    public void e(String message) {
      if (ERROR >= LOG_LEVEL) {
        Log.e(loggerName, message);
      }
    }

    @Override
    public void e(String message, Throwable throwable) {
      if (ERROR >= LOG_LEVEL) {
        Log.e(loggerName, message, throwable);
      }
    }
  }
}
