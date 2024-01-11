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
  
  public void deposit(long money) {
    if(money <= 0) {
      System.out.println(money + "원 입금 불가");
      return;
    }
      balance += money;
  }
  
  public long withdrawal(long money) {
    if(money <= 0) {
      System.out.println(money + "원 입금 불가");
      return 0L;
    }
    if(money > balance) {
      System.out.println("잔액 부족");
      return 0L;
    }
      
    balance -= money;
    return money;
  }
    
//    if (money > balance) {
//     return 0;
//    }else if (money <= balance ) {
//      balance -= money;
//    } 
//    return money;
      //내가 한 버전 남겨놔용 한번 리뷰 해보기~
  
  
  public void transfer(BankAccount account, long money){
    // 내 통장에서 출금 -> 출금된 금액이 반환 -> 네 통장에 반환
    //long a = withdrawal(money); a b 둘 다 가능하죠.
    // 네 통장에 입금
    // account.deposit(a);
   
   account.deposit(withdrawal(money));
   
   //!!!!!!!! 오...이렇게....오....이따 리뷰할때 다시 봐주기! 굳이 반환이 계속 들어간 이유 = 송금을 위해!
      
  }
  
  public void showBalance() {
    System.out.println(this.balance);
  }
  
  
  
  
  
  
  
  
  
  
  

  
  
  
  
  

}
