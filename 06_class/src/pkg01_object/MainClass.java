package pkg01_object;

public class MainClass {
  
  public static void main(String[] args) {
    
    //객체 선언
    Calculator calculator;
    
    //객체 생성
    calculator = new Calculator();
    
    //클래스 멤버(데이터, 기능 등)를 사용하기 위해서는? 객체가 필요하다!(static을 위시한 몇몇 방법 제외하고..)
    
    //객체를 이용해서 클래스의 멤버(필드, 메소드)를 사용할 수 있다.
    //객체.멤버
    
    calculator.number = 100;
    System.out.println(calculator.number);
    
   // calculator.method();
    //this.method(); 이렇게도 원래는 가능하지만 지금은 static때문에 안됨
    
    
    
    
    
  }

}
