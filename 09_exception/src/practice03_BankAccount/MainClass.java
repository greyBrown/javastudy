package practice03_BankAccount;

public class MainClass {

  public static void main(String[] args) {

    BankAccount account1 = new BankAccount();
    
    account1.setAccNo("01098765432");
    account1.setBalance(100000);
    
 
    BankAccount account2 = new BankAccount("01012345678", 50000);
  
    
    
    /////////
    try {
       account1.deposit(100000); 
       account1.deposit(-50000);   //주석처리 하면서 예외가 나는걸 하나씩..하나씩...봅시다 ^^
      
      long money;
      money = account1.withdrawal(100000); 
         System.out.println(money);          
      money = account1.withdrawal(200000); 
         System.out.println(money);            
      
      
      account1.transfer(account2, 50000); 
      account1.transfer(account2, 100000); 
      
    } 
    
     catch (RuntimeException e) {   //Runtime임!!! with deposit 그런얘들 아님! 잘 봐야해..!!
       
       //catch 블록의 e 로 전달되는 인자들
       //1. catch ( DepositException e) { throws new RuntimeException(money+ "원 입금불가", e);}
       //2. catch (WithdrawalException e) { throws new RumtimeException (money+ "원 입금불가", e);}
       //3. catch (WithdrawalException e) { throws new RumtimeException ("잔액부족", e);}
       
       String message = e.getMessage();
       System.out.println(message);                //예외메세지 확인
       
       BankException cause = (BankException) e.getCause();
       System.out.println(cause.getClass().getName());  //예외클래스이름확인
       System.out.println(cause.getErrorCode());        //에러코드확인
    }     
    
    
    //트라이의 throw는 catch로 던지고 트라이 영역 밖의 throw는 메서드 호출영역으로 던진다(이때는 메서드명 옆에도 써줘야 함)!! 구분 잘 해줘야 함.
  }

}
