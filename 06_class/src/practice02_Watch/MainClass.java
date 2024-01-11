package practice02_Watch;

// 클래스 하나에서 한 메소드가 다른 메소드를 호출하는 연습이였습니다! 이런식으로 해요...
// 아 식을 조금 더 깔끔하게 짤 수 있을 것 같은데 쉽지 않다 ㅠ 내일은 클래스와 클래스간의 관계를 합니다...

public class MainClass {

  public static void main(String[] args) {
    // 생성자
    Watch watch = new Watch(9, 0, 0); //09:00:00
    watch.see();
    
    watch.addHour(3);  //12:00:00
    watch.see();
    watch.addMinute(80); //13:20:00
    watch.see();
    watch.addSecond(3650); //14:20:50
    watch.see();
    
    
    
    
  }
  
 

}
