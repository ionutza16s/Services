package ionutza.httpclientproject.logging;

/**
 * Logger interface which abstracts the actual logging mechanism used.
 *
 * @author cristian.vasilache
 */
public interface Logger {

  /**
   * Logs the given message using the verbose level.
   *
   * @param message the message to be logged.
   */
  void v(String message);

  /**
   * Logs the given message using the debug level.
   *
   * @param message the message to be logged.
   */
  void d(String message);

  /**
   * Logs the given message using the debug level.
   *
   * @param message the message to be logged.
   */
  void d(String message, Object... args);

  /**
   * Logs the given message and throwable using the debug level.
   *
   * @param message   the message to be logged.
   * @param throwable the throwable.
   */
  void d(String message, Throwable throwable);

  /**
   * Logs the given message using the info level.
   *
   * @param message the message to be logged.
   */
  void i(String message);

  /**
   * Logs the given message using the warning level.
   *
   * @param message the message to be logged.
   */
  void w(String message);

  /**
   * Logs the given message and throwable using the warning level.
   *
   * @param message   the message to be logged.
   * @param throwable the throwable.
   */
  void w(String message, Throwable throwable);

  /**
   * Logs the given message using the error level.
   *
   * @param message the message to be logged.
   */
  void e(String message);

  /**
   * Logs the given message and throwable using the error level.
   *
   * @param message   the message to be logged.
   * @param throwable the throwable.
   */
  void e(String message, Throwable throwable);
}
