package pkg06_Predicate;

import java.util.function.Predicate;

public class MainClass {
  
  /*
   * java.util.function.Predicate
   * 
   * 1. 형식
   *   public interface Function<T> {
   *       boolean  test(T t);
   *   }
   *   
   * 2. 파라미터 O, 반환 boolean 형식의 test() 메소드를 지원하는 함수형 인터페이스이다.
   * 
   * true/false 를 반환하는 if문 등에 주로 쓰이는 조건을 검사해주는 인터페이스임.
   */
  
  public static void method1() {
    
    Predicate<Integer> isEvenNumber = (number) ->  number % 2 == 0;     //return은 생략할게요. true false를 반환하는 논리연산자 ㅇㅇ
    if(isEvenNumber.test(10)) {
      System.out.println("짝수");
    } else {
      System.out.println("홀수");
    }
  
  }
  
  public static void method2(Predicate<Integer> predicate, int number) { //이게 중요
    
    if(predicate.test(number)) {
      System.out.println("짝수");
    } else {
      System.out.println("홀수");
    }
  }
  
  public static void main(String[] args) {
    
    method2((number) -> number%2 == 0, 35);
    
  }

}
