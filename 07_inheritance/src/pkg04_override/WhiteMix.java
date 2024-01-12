package pkg04_override;

//메소드 오버라이드
//1. 자식 클래스가 부모 클래스의 메소드를 다시 만드는 것이다.
//2. @Override annotation 을 추가한다. (거의 필수적!)
//3. 똑같이(반환타입, 메소드명, 매개변수)

//+오버로딩과 단어가 비슷한 관계로...가끔 기술면접에서 둘 차이점 물어보지만 이름 빼고 같은게 없는 친구예요~

public class WhiteMix extends Kanu{

  @Override //일반적으로 Override 에 이렇게 한줄 줍니다. 오버라이드한 메소드라고 JVM에게 알려준다. 안알려줘도 자바가 알긴 하는데 사람이 모르죠???? 그리고 이래야 문법 체크가 가능.
   public void color() {
   System.out.println("커피색");
  }
  
  //이것도 source 메뉴에서 자동화가 됩니다! 오버라이딩도 자동추가 가능 override/implement methods
  
}
