package pkg04_random;

public class Class01_Math {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    /*
     * Math.random()                            0.0 <= 난수 < 1.0
     * Math.random() * 5                        0.0 <= 난수 < 5.0
     *(int)(Math.random() * 5)                  0   <= 난수 < 5          //0, 1, 2, 3, 4, 
     *(int)(Math.random() * 5 + 1)              1   <= 난수 < 6          //1, 2, 3, 4, 5
     */
    
    
    
    // 5% 확률로 "대박"...연타 눌러서 대박 띄웠다 ^_^ 어쨌든 나왔죠???? 대박이죠???
    if(Math.random() < 0.05) {
      System.out.println("대박");
    } else {
      System.out.println("대박은 무슨");
    }
      
    // 주사위 던지기
    int dice = (int)(Math.random() * 6 + 1); //1부터 6개 수 중(1~6) 하나가 발생한다.
    System.out.println(dice);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }

}
