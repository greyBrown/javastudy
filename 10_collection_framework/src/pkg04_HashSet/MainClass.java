package pkg04_HashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainClass {
  
  
  public static void method1() {
    
    // HashSet 타입 선언
    Set<String> hobbies;
    
    // HashSet 객체 생성
    hobbies = new HashSet<String>();
    
    // 요소 추가하기 (순서없이 저장되고, 중복 저장이 불가능하다)
    hobbies.add("수영");
    hobbies.add("수영");
    hobbies.add("수영");
    hobbies.add("여행");
    hobbies.add("레고");
    hobbies.add("운전");
    hobbies.add("게임");
    
    //get 메서드가 없다. 이 집합 전체가 하나의 데이터 형식으로 쓰이는 구조이기 때문에 보통 이런식으로 꺼낼필요가 없기 때문.
    //advanced for문을 통해 확인할 수 있다.
    for(String hobby : hobbies) {
    System.out.println(hobby);}
    
    
    
       
        
        
    
    
    
    
  }

  public static void method2() {
    
    // 교집합
    Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));  //List를 set로 만들어주는 걸 지원함. 해봅시다. (collection에서 List와 Set가 비중있죠)
    Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5)); //12345를 List로 만들면 그걸 다시 Set로 만들어줌.
    
    // set1이 교집합 결과로 변환된다.
    set1.retainAll(set2);
    System.out.println(set2); //set도 알아서 toString 처리 되어 있어요~
  }
  
public static void method3() {
    
    // 합집합
    Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));  
    Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5)); 
    
    // set1이 합집합 결과로 변환된다.
    set1.addAll(set2);
    System.out.println(set1); 
    
}

public static void method4() {
  
  // 차집합
  Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));  
  Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(6, 7, 8, 4, 5)); 
  
  // set1이 차집합 결과로 변환된다.
  set1.removeAll(set2);
  System.out.println(set1); 
  
}
  public static void main(String[] args) {

    method4();
    
    
    
    
  }
}
