package pkg05_etc;

import java.util.Optional;

public class Class01_Optional {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    //Optional<T> : T 타입의 데이터를 감싸는 클래스
    
    //1. null 값이 없는 데이터
    String str1 = "사과";
    Optional<String> opt1 = Optional.of(str1);    //사과를 봉지로 싸는 것 처럼...str1 을 opt1로 싸서 전달
    System.out.println(opt1.get());               //이렇게 opt 안의 내용을 본다.
    //매개체 역할을 많이 하는 클래스. 원래 데이터를 한번 싸서 주고받는다. 여러개의 데이터가 있을 때 주로 씁니다...
    
    
    //2. null 값이 있는 데이터 (배우는 목적) -> ofNullable
    String str2 = null;
    Optional<String> opt2 = Optional.ofNullable(str2);
    System.out.println(opt2.orElse("바나나")); //안에 아무것도 없다면 "바나나"를 꺼낼 것. 안에 뭐가 있다면 있는거 나온다 있는거!! 도입된지 얼마 안된 기능 중 하나. 이 옵션을 통해 null 처리가 가능해짐.
    //나중에 목록보기 구현할 때(페이징 처리할때) 이거 쓸 거예욥!! 무슨 페이지 보고 싶은지 입력하지 않으면 1페이지 보여주겠다. 이런거!
   
    //아무것도 안줬어도 감싸는게 가능...그리고 orElse를 사용할 경우 입력한대로 꺼낼 수 있다. 신기
  
    
    
    
  }

}
