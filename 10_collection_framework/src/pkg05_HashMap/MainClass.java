package pkg05_HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

//Map! key-value로 다니는게 객체(변수명 - 변수값)랑 완전 비슷하지 않나요? 그래서 대신 씁니다.. key를 이용해 value를 꺼냄
//key 찾을 때 hash 알고리즘을 씁니다. 그래서 hashmap. 키 자체도 set로 되어있음.(중복x 순서x) 키값도 중복 없고 순서 없음. 밸류는 뭐 아무 제한사항없어요.
//List<MAP<V, K>> 이 조합이 엄청 유용해요!

public class MainClass {
  
  /*
   * HashMap
   * 1. 객체(인스턴스)를 대신할 수 있는 자료구조이다.
   * 2. 구성
   *    1) Key   : 데이터 식별자, Set으로 구성되어 있다. (순서 없고 중복 없다.)
   *    2) Value : 데이터 자체
   *    3) Entry : Key 와 - Value 를 합쳐서 부르는 말이다.
   */

  public static void method1() {
    
    // Mutable 객체 (값이 변할 수 있는 객체)
    
    //HashMap 선언
    Map<String, Object> book;                             //가장 많이 쓰이는 조합 String - Object
    
    //HashMap 생성
    book = new HashMap<String, Object>();
    
    //Key, Value 추가 (Entry 추가)
    book.put("title", "어린왕자");
    book.put("author", "생텍쥐페리");
    book.put("isBestSeller", true);
    book.put("price", 10000);
    
    // key 를 이용해서 value 확인하기
    System.out.println(book.get("title"));
    System.out.println((boolean)book.get("isBestSeller") ? "베스트셀러" : "일반서적"); //Object라서 boolean으로 캐스팅해줘야함. 바로 이런 번거로움 때문에 Object에 다른 데이터타입 저장하는 거 잘 안해요...
    System.out.println(book.get("price"));                         
    System.out.println(book.get("author"));                        
    
    //tmi..여기서 확실히 알 수 있는거...get으로 value값 얻는 거임 적는게 key라고 헷갈리면 안됨!! 타입!! 밸류 타입!!!
    // 매개변수가 key고 메소드 반환값은 value임 그러니까 (boolean) true false 할 수 있겠죠???
    // get은 key 값 넣어서 value값 얻는다. put은 "key", "value" 넣어주는 메소드다. 
  }
  
  public static void method2() {
    
    //Immutable 객체 (값을 바꿀 수 없는 객체)  <- 값의 변조를 막기 위함임. 대개 어디론가 전달할때...이렇게 하면 안전하기 때문!
    
    Map<String, Object> map = Map.of("name", "홍길동");  //immutable 객체는 보통 반환값으로 쓰면 좋아요~ 이 of 메서드 인터페이스에서 호출하는 static 메서드져! 업데이트되어서 이제 static도 들어갈 수 있다 했었죠
    
    //값을 바꾸려는(추가, 삭제 등) 시도...해보자고
    // map.put("age", 10); //오류남. 못바꿈!
    
    
    System.out.println(map.get("name")); //넣어진 값(홍길동) 출력됨
    
  }
  
  public static void method3() {
    
    // key 는 Set 으로 되어있다.
    
    Map<String, Object> map = Map.of("name", "홍길동"
                                    , "age", "10"
                                    , "isMarried", false);
    
    Set<String> keys = map.keySet();  //set는 인덱스가 없기 때문에 advanced for 문으로 뽑는다. 
    
    for(String key : keys) {
      System.out.println(key);             //key 값 출력
      System.out.println(map.get(key));    //value 값 출력
      System.out.println(key + " : " +map.get(key));    //예쁘게 출력
     
      //map은 iterable 자식이 아니니까 for문 못돌린단 말이에요? 그런데 key 는 set 이니까 set 은 iterable 자식이라 for문 돌릴 수 있단 말이예요? key 찾으면 value 찾을 수 있음 -> 그렇게 value 찾음!
      
    }    
    
    
    
    
    
    
  }
  
  public static void method4() {
    
    //Entry 전체를 Set 로 만들 수 있다.  (map이 iterable을 못하니까 set에 넣어줄려는 그런..그런거예요. 이것도 이클립스가 잘 해줍니다.)
    
    Map<String, Object> map = Map.of("name", "홍길동"
                                           , "age", "10"
                                           , "isMarried", false);
    
     Set<Entry<String, Object>>  entrySet = map.entrySet();
    
     for(Entry<String, Object> entry : entrySet) {
      System.out.println(entry.getKey() + " : " + entry.getValue());   // map을 보여주는 방법이 몇가지 있지만 이 method4번 방법..추천합니다. 다른 방법으로 할 수 있으면 되지만 그래도 추천을 하자면~
    } 
    //import java.util.Map.Entry; 이거 이상한데 들어가서 안되는 거였음...컬렉션은 import문 주의해야함 컨트스페를 잘 쓰기....^^
     
     
  }
 
  public static void method5() {
    
    Map<String, Object> map = new HashMap<String, Object>();
   
    
    //처음 입력되는 key 는 추가된다.    
    map.put("name", "홍길동");
    map.put("age", "10");
    map.put("isMarried", false);
    
    //다시 입력되는 key 는 수정을 의미한다.
    map.put("age", 20);
    
    map.remove("isMarried");
    
    
    System.out.println(map); //map도 toSring 처리가 잘 되어 있습니다.
    
  }
  
  public static void main(String[] args) {
    
    method5();
    
  } 

}
