package pkg06_downcasting;

public class MainClass {
  
  public static void main(String[] args) {
    
  
  
  /*
   * 다운캐스팅
   * 1. (업캐스팅 된)부모타입의 객체를 자식타입으로 바꿀 수 있다.
   * 2. 강제로 변환해야 한다.
   * 3. 잘못된 캐스팅을 방지하기 위해서 instanceof 연산자를 사용할 수 있다.
   * +업캐스팅으로 못쓰게되었던 서브의 메소드를 다시 쓸 수 있어짐.
   */
  
  //업캐스팅 된 부모 타입의 자식 객체
  Computer computer = new Tablet();
  
  //Tablet 타입으로 변환
  if (computer instanceof Tablet) {
    ((Tablet) computer).screenTouch();
    ((Tablet) computer).portable();
  }
  
  //잘못된 다운캐스팅(Wearable 타입으로 변환)
  ((SmartWatch) computer).wearable(); //자바 : 또 택도 없는 소리한다. 컴파일 오류는 없으나 실행에서 ClassCastException 예외발생.
  
  
  
 
  
  
  
  
  
  
  

}
}