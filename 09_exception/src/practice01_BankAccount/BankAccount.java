package practice01_BankAccount;

public class BankAccount {
  
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
  
  //1. 각 메소드 내에서 try - catch로 직접 처리하는 방법 - 예제 1번
  //2. 메소드가 호출한 곳으로 예외처리를 하는 방법 (throws사용) - 예제 2번
  //3. 둘 다 쓴게 3번
   
 
  public void deposit(long money) {  //메서드 내부에서 처리하는 try - catch 방법
    try {
      
      if(money <= 0) {
        throw new RuntimeException(money + "원 입금 불가");
      }
    
      balance += money;
      
    } catch(RuntimeException e) { 
      System.out.println(e.getMessage());
    }
  }
  
  public long withdrawal(long money) {   //return 문 어떻게 처리할 것인가!
   
    long retValue = 0L;  //그냥 이렇게 리턴용 밸류를 하나 만들어준다. 이걸 마지막에 다시 붙여줌.

    try {
     
     if(money <= 0) {
      throw new RuntimeException(money + "원 출금 불가");
     }
     if(money > balance) {
      throw new RuntimeException("잔액 부족");
     }
     
     balance -= money;
     retValue = money;
     
   } catch(RuntimeException e) {
     System.out.println(e.getMessage());
   }
    return retValue;
  }
    
  //이렇게 입금의 예외처리는 입금이 스스로, 출금의 예외처리는 출금이 스스로 하게됨.
  //transfer는 여전히 예외처리가 필요없음. 저 위 메소드에서 모두 처리됨. 

  
  public void transfer(BankAccount account, long money){
  
   account.deposit(withdrawal(money));
   
      
  }
  
  public void showBalance() {
    System.out.println(this.balance);
  }
  
  
  
  
  
  
  
  
  
  
  

  
  
  
  
  

}
