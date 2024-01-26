package pkg03_Supplier;

import java.util.function.Supplier;

public class MainClass {
  /*
   * java.util.function.Supplier
   * 1. 형식
   *    public interface Supplier<T>{
   *       T get();
   *     }
   * 2. 파라미터 X, 반환 O 형식의 get() 메소드를 지원하는 함수형 인터페이스이다.   
   * /Myinterface2번 같은게 Supplier임...get 메소드를 통해서 항상 무슨 값이 나옴. Supplier 는 그런 용도로 씁니다. 값을 반환하는 람다를 전달할것. 값을 쓸때는 get으로 가져다 쓴다.
   */
  public static void method1() {
    
    Supplier<String> supplier = () -> "hello world";
    System.out.println(supplier.get());
    //이러면 이 supplier는  항상 hello world 를 반환하는 메소드가 됨.
  }
  
  public static void method2(Supplier<String> supplier) { // 이게 쓰고자하는 supplier 쓰는 방식!
    
    System.out.println(supplier.get());
    
  }
  
  public static void method3(Supplier<Integer> supplier) {
  
  //호출할 때마다 1~ 10 사이 난수를 출력하는 method3
    System.out.println(supplier.get());
  
    
  }
  
  
  public static void main(String[] args) {

   // method2(() -> "hello world");   //이렇게도 할 수 있습니다. 들어간게 람다식이지 하는건 아 이걸 메소드 안에 넣어요?? 아 이걸 생략해요???? 그거임
                                    //supplier 를 직접 적는 경우는 별로 없음...println(int a) = println(10) 이거랑 또오옥같은 거에요. 낯설어서 다르게 보일뿐...
                                    //람다 쓰는거는 이게 목적이에요! 왜 "hello world" 줬어요? 매개변수 String supplier 니까...
                                    //이거 지향해야하는 코드에요. 열심히 연습할 코드... 이런걸 만들어서 전달할 줄 알아야 함.
    
   method3(() -> (int)(Math.random()*10+1));
    
    
  }

}
