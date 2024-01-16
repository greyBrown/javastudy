package practice02_BankAccount;

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
  
  public void deposit(long money) throws RuntimeException{
    if(money <= 0) {
      throw new RuntimeException(money + "원 입금 불가");
    }
      balance += money;
  }
  
  public long withdrawal(long money) throws RuntimeException {
    if(money <= 0) {
      throw new RuntimeException(money + "원 입금 불가");
    }
    if(money > balance) {
     throw new RuntimeException("잔액 부족");
    }
      
    balance -= money;
    return money;
  }
    

  
  public void transfer(BankAccount account, long money) throws RuntimeException {  //중요한 부분. transfer의 예외처리 역시 필요해진다!! 왜?? 메서드의 호출부로 던진다고 했으니까 여기로도 던짐!!
                                                             //하지만 여기서 처리하진 않음. 어케? 메인으로 다시 던진다 ㅎㅎ transfer 호출하는 곳으로...예외를 던지고 던지고 던지고...
                                                              //최종적으로 try-catch는 메인으로만 들어가게 됨. transfer 은 throws 만 하면 되죠! 아무래도 실무에선 이런 깔끔한 방법(지금 2번 방법) 을 많이 씁니다.
                                                             //메소드 다 던진거 모아서 메인에서 한번 샥-! 이렇게 많이들 써요. 정답이란건 아니지만!
    account.deposit(withdrawal(money));
      
  }
  
  public void showBalance() {
    System.out.println(this.balance);
  }
  
  
  
  
  
  
  
  
  
  
  

  
  
  
  
  

}
