package oop.filesys;

public class FSException extends Exception {
  static final long serialVersionUID = 7818375828146090155L;

  /**
   * Constructs an {@code FSException}.
   * @param cause: the message describing the cause for which this exception is thrown.
   */
  public FSException(String message) {
    super(message);
  }

  /**
   * Constructs an {@code FSException} with the specified detail message
   * and cause.
   * @param message explaining the cause of the exception
   * @param the throwable exception that caused this file-system exception
   *        to be thrown.
   */
  public FSException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs an {@code FSException}.
   * @param cause: the throwable exception that is the cause for which 
   *               this exception is thrown.
   */
  public FSException(Throwable cause) {
    super(cause);
  }
}
