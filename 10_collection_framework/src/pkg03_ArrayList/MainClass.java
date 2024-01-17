package pkg03_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
  /*
   * ArrayList 클래스
   * 1. 배열 리스트를 구현한 클래스이다.
   * 2. 실무에서는 배열 대신 사용한다.
   * 3. 배열의 특지을 그대로 가지고 있다.
   *   1) 순서대로 데이터가 저장된다.
   *   2) 인덱스를 가지고 있다.
   * 
   *   
   * 배열과 달리 크기 제한이 없다. (쓰고싶은대로 쓴다! 사이즈차면 알아서 늘려주고...꽉 차지 않는다. 그런거 신경쓸 필요가 없음!)
   * 삭제를 알아서 해준다.(Arraycopy 써서 땡겨서 붙이고 자르고 이럴 필요가 없다!!)
   * 자바개발에서 배열을 쓸 필요 없는 이유가 ArrayList 덕분임...^^! 알아서 이것저것 됨
   */
  

  public static void method1() {
    //ArrayList 선언 (사용 가능 타입 : Collection<E>, List<E>, ArrayList<E> (Element의 E입니당. List를 많이 써요. 직속인터페이스가 List. 스프링가서 인터페이스 타입이 기본이라고 했으니까!!))
    //임폴트(보라색I) 자주 쓸거라서 이제 컨스 잘 써야해요!(컨스가 위에 임포트문 자동으로 넣어준다!!! 이것때문에!! 이거 안까먹을라고!!!) 참고로 컬렉션 프레임워크는 전부 java.util.
    List<Integer> numbers; //int[] numbers; 의...환생이라고 생각해요....
    
    //ArrayList 생성
    numbers = new ArrayList<>();  //컨스에서 컬렉션에서 만들어진 걸로 가져와서 만들수도 있죠. 생성자에서 Interger 지우고 싶으면 지워요~
                                  // number = new int[]; 이거를 이제...ArrayList로 만든거죠!
    
    //요소 추가하기
    numbers.add(5); //순서대로 넣는다. 리스트의 끝 부분에 추가한다= 순서대로 넣겠다는 뜻. 인덱스0에 5넣겠다는 의미임...병이라고 생각하면 병 밑바닥에 깔겠다. 이말임... 
    numbers.add(4); 
    numbers.add(3); 
    numbers.add(2); 
    numbers.add(1); 
    
    //요소 가져오기
    System.out.println(numbers.get(0));
    
    
    
    
  }
  
  public static void method2() {
    
    //ArrayList 선언 및 생성
    List<String> hobbies = new ArrayList<String>();
    
    //요소 추가하기
    hobbies.add("게임");
    hobbies.add("여행");
    hobbies.add("수영");
    hobbies.add("레고");
    hobbies.add("모임");
    
    //저장된 요소의 개수 확인
    System.out.println(hobbies.size());
    
    
    //저장된 데이터 확인
    for(int i = 0, size = hobbies.size(); i < size; i++) {  //advanced for 문도 어케하는지 다시 보기..헷갈려...int a = 1, b = 2 이거됨. size도 int 라는 뜻...
      System.out.println(hobbies.get(i));
    }
    
    
    
    
    
  }
  
  public static void method3() {
  
    //배열을 ArrayList로 바꾸기
    Integer[] arr = new Integer[]{10, 20, 30};   //int는 ArrayList로 못바꾸니까 Integer로 해야죱. 이런걸 생각해줘야 함!
    
    //배열을 List로 바꿔서 반환하는 java.util.Arrays 클래스의 asList 메소드
    //Arrays.asList(arr); 이렇게 변환 후 아래처럼 완성.
    List<Integer> numbers = Arrays.asList(arr);   //ArrayList가 됩니다. 타입 List
    
    //주의!
    //numbers는 길이를 변경할 수 없다. (추가, 삭제 불가)
    
    //간단히 데이터 확인 
    System.out.println(numbers); //toString 메소드 생략. 
    System.out.println(numbers.toString()); //원래 @참조값이 떠야하는데 아님...!!! 내용이 나온다!! ArrayList가 toString도 이렇게 만들어둔거에요^^ 사실 for문 돌려서 내용 확인할 필요없어요 ㅎ
    
  }
  
  public static void method4() {
    
  List<String> seasons = new ArrayList<String>();
  
    seasons.add("봄");
    seasons.add("여름");
    seasons.add("파인애플");
    seasons.add("피자");
    seasons.add("겨울");

    // 요소 수정
    seasons.set(2, "가을");
    
    // 요소 삭제 (remove int(인덱스번호 - 3 반환3), object(내용 - "피자" boolean타입 반환 지웠으면 true 못지웠으면 false. 템플릿 해석하자면 이래요)
    //System.out.println(seasons.remove(3)); //오 이러니까 3번째 인덱스 출력한다...이후 sop에는 안나오는 걸 보니 출력후 삭제되는듯
    
    seasons.remove(3);
    
    System.out.println(seasons);
    
    
    
    
    
    
    
    
  }
  
  public static void main(String[] args) {
    
    method4();

  }

}
