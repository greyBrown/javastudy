package pkg06_throws;
//이게 중요해요~ 메소드가 예외를 던질때! 메소드 예외가 중요!! 메서드가 예외를 메서드 호출한 곳으로 던지는 것.


public class MainClass {
  
  public static void main(String[] args) {
    
    int a = 5;
    int b = 0;
    
    try {
      Calculator calculator = new Calculator();
      calculator.add(a, b);
      calculator.substraction(a, b);
      calculator.multiplication(a, b);
      calculator.division(a, b);
    } catch (ArithmeticException e) {
      System.out.println("산술 연산 예외가 발생했습니다.");
    }
    
  }

}
