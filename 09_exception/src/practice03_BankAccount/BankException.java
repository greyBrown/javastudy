package practice03_BankAccount;

public class BankException extends Exception {
  
  private int errorCode;
  
  public BankException(String message, int erroCode) {
    super(message);
    this.errorCode = erroCode;
  }
  
  public BankException(int erroCode) {
    super();
    this.errorCode = erroCode;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

}
