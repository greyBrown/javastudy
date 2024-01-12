package practice07_Fighter;

public class MainClass {

  public static void main(String[] args) {
    
   
  
    

    Fighter elsa = new Fighter("elsa", 200);
    Fighter oolaf = new Fighter("oolaf", 100);
    
    elsa.ShowHp(oolaf);
    
    while(elsa.getHp() > 0 && oolaf.getHp() > 0) {
    elsa.SnowPunch(oolaf, (int) Math.round(Math.random()*100));
    System.out.println(oolaf.getName() + "가 반격합니다!");
    oolaf.SnowPunch(elsa, (int) Math.round(Math.random()*100));
    System.out.println(elsa.getHp() + ":" + oolaf.getHp());}
      
    
    
  }

}
