package practice03_BankAccount;

public class WithdrawalException extends BankException {
  
  public WithdrawalException(String message, int errorCode) {
    super(message, errorCode);
   
  }
  
  public WithdrawalException(int errorCode) {
    super(errorCode);
   
  }

  
  

}
