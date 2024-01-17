package practice02_Cup;

public class MainClass {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Cup cup1 = new Cup();
    cup1.fill(new Americano());
    
    Cup cup2 = new Cup();
    cup2.fill(new CafeLatte());
    

    
    Carrier carrier = new Carrier(2);
    carrier.addCup(cup1);
    carrier.addCup(cup2);
    carrier.whoami();
    
    carrier.whoami();
    
    
  }

}
