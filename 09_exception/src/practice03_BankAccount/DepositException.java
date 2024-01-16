package practice03_BankAccount;

public class DepositException extends BankException { //필드가 없을땐 generate constructors from superclass 눌러주면 됩니다!

  public DepositException(String message, int erroCode) {
    super(message, erroCode);
  }
  
  public DepositException(int erroCode) {
    super(erroCode);
  }

}
