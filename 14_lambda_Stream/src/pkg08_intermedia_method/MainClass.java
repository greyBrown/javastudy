package pkg08_intermedia_method;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainClass {

  public static void method1() {
    
    // filter() 메소드
    // Stream<T> filter(Predicate<T> predicate) {}         //쉽게 말하면 if같은 일을 하는 친구...필터의 결과에 forEach 를 끼우는 방식으로 합니다.        
    // 필터 많으써요~! 체크해놔야해요.

   List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
   Stream<Integer> numbers = list.stream();
   numbers.filter((number) -> number % 2 == 0).forEach((number) -> System.out.println(number));
   
   
   // 이것도 보통은 이런식으로 씁니다. 
   list.stream().filter((number) -> number % 2 == 0).forEach((number) -> System.out.println(number));
    
    
    
    
  }
  
  public static void main(String[] args) {

      
      method1();
      
      
    
    
    
  }

}
