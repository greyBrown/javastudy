package pkg02_interface;

public class MainClass {
  
  public static void main(String[] args) {
    
   //구현클래스 생성
   Shape shape1 = new Circle(0, 0, 1.5);
   
   //추상메소드
   System.out.println(shape1.getArea());
   System.out.println(shape1.getCircum());
  
   // 디폴트 메소드 (구현 클래스 타입의 객체로 호출 가능하다)
   shape1.whoami("원");
   
   // 클래스 메소드  -> 객체명으로 호출 불가. 클래스메소드는 인퍼테이스명(클래스명)으로 호출 가능하다. static 은 클래스명으로 호출 하니까!
   Shape.whoami2("원");
   
   Shape shape2 = new Rectangle(0, 0, 5, 5);
   System.out.println(shape2.getArea());
   System.out.println(shape2.getCircum());
   shape2.whoami("네모");
   Shape.whoami2("네모");
   
    
    
  }

}
