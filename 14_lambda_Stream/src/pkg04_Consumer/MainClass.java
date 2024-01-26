package pkg04_Consumer;

import java.util.function.Consumer;

public class MainClass {
  /*
   * java.util.function.Consumer
   * 
   * 1. 형식
   *   public interface Consumer<T> {
   *      void accept(T t);
   *   }
   *   
   * 2. 파라미터 O, 반환 X 형식의 accept() 메소드를 지원하는 함수형 인터페이스이다.     
   */

  public static void method1() {
    
    Consumer<String> consumer = (name) -> System.out.println(name + "님");
    consumer.accept("tom");
  }
  
  
  public static void method2(Consumer<String> consumer) { // 이것도 이게 중요! 람다를 전달하면 함수형 인터페이스가 받는다!
    
    consumer.accept("tom");;        // byConsumer 도 있어요. 이 친구는 매개변수를 2개 받을 때~
  }
  
  public static void main(String[] args) {

    method2((name) -> System.out.println(name + "님"));

  }

}
