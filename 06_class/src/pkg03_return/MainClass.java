package pkg03_return;

public class MainClass {

  public static void main(String[] args) {

    // calculator 타입의 calculator 객체 선언 및 생성
    Calculator calculator = new Calculator();
    
    //반환 값의 잘못된 호출이라고 볼 수 있음. 그냥 =10인 상태
    calculator.method1();
   
    //반환값의 호출 예시들. 반환값을 확인하거나...etc
    System.out.println(calculator.method1()); 
    System.out.println(calculator.method1() == 10 ? "십이다" : "십이아니다");
    int a = calculator.method1();
    System.out.println(a);
    
    //int[] 반환받기
    int[] arr = calculator.method2();
    for(int n : arr) {
      System.out.println(n);
    }
    
    for(int n : calculator.method2()) {
      System.out.println(n);  //for문 두개다 똑같은 원리, 결과 근데 아까 method1=10 인 상태라고 했죠? 그러니까 method2는 arr인 상태 method2=arr 
    }
    
    //Adder 객체 반환 받기
    System.out.println(calculator.method3().add(1, 2, 3 ));
    //메서드 내용(=반환값이 객체 생성) -> 메서드가 객체가 됨
    //객체가 된 메서드.add.. 객체가 된 메서드로부터 결과(덧셈)을 호출함
    //이런걸 "메서드 체이닝"이라고 합니다.
    //호출 후...반환값이 바뀐다! 그게 반환값의 핵심! 그 자리를 치우고 거기에 반환값이 들어간다.
    
    
    
  }

}
