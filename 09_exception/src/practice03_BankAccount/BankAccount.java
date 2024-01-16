package practice03_BankAccount;

public class BankAccount { //try-catch 와 throws 가 모두 사용된 예제.
  
  BankAccount( ){ 
  }
  
 
 BankAccount(String accNo, long balance){  
 }

  //field
  private String accNo;
  private long balance;
  
  public void setAccNo(String accNo) {
    this.accNo = accNo;
  }
  
  public void setBalance(long balance) {
    this.balance = balance;
  }
  
  //1. 각 메소드에서 try - catch를 직접 처리하는 방법
  //2. 메소드가 호출한 곳으로 예외처리를 하는 방법
   
 
  public void deposit(long money) throws RuntimeException {  //메서드 내부에서 처리하는 try - catch 방법
    try {
      
      if(money <= 0) {
        //catch 블록으로 던진다.
        throw new DepositException(1001);
      }
    
      balance += money;
      
    } catch(DepositException e) {      //DepositException e : 예외 원인 객체(cause)
      
      //메소드 호출한 곳으로 던진다.(try 문 밖에 있기 때문에!) -> 메소드 명 뒤에 throws 처리해줌.
      throw new RuntimeException(money + "원 입금 불가", e);
     
    }
  }
  
  public long withdrawal(long money) throws RuntimeException {   //return 문 어떻게 처리할 것인가!
   

    try {
     
     if(money <= 0) {
      throw new WithdrawalException(2001);
     }
     
     if(money > balance) {
      throw new WithdrawalException(2002);
     }
     
     balance -= money;
   
     
   } catch(WithdrawalException e) {  //예외 원인 객체
    
     String message = null;
     switch(e.getErrorCode()) {
     case 2001 : message = (money + "원 출금 불가");
     break;
     case 2002 : message = "잔액 부족";
     break;
     }
     
     throw new RuntimeException(message, e);
     
   }
    return money;  //예외시 자동으로 0이 반환됨. 그런..코드에요..그렇대요...
  }
    
  //이렇게 입금의 예외처리는 입금이 스스로, 출금의 예외처리는 출금이 스스로 하게됨.
  //transfer는 여전히 예외처리가 필요없음. 저 위 메소드에서 모두 처리됨. 

  
  public void transfer(BankAccount account, long money) throws RuntimeException{
  
   account.deposit(withdrawal(money));
   
      
  }
  
  public void showBalance() {
    System.out.println(this.balance);
  }
  
  
  
  
  
  
  
  
  
  
  

  
  
  
  
  

}
