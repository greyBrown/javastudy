package practice02_BankAccount;

public class MainClass {

  public static void main(String[] args) {

 
    BankAccount account1 = new BankAccount();
    

    account1.setAccNo("01098765432");
    account1.setBalance(100000);
    

    BankAccount account2 = new BankAccount("01012345678", 50000);
  
    
    
    /////////
   try {    
     //자동으로 됩니다...^^ exception e 까지 해줌 ㅋㅋㅋㅋ
    account1.deposit(100000); 
    //account1.deposit(-50000);   ///이것만 뜨는게 맞습당. //하면서 하나씩 확인해봐여
    
    long money;
    money = account1.withdrawal(100000); 
    System.out.println(money);         
    money = account1.withdrawal(200000); 
    System.out.println(money);           
    account1.transfer(account2, 50000); 
    account1.transfer(account2, 100000);

  } catch (Exception e) {
    System.out.println(e.getMessage());
  }
    
   
   account1.showBalance();

    
    
    
 
    
    
    
  }

}
