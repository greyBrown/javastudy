package pkg02_interface;

/*
 * 인터페이스
 * 1. public final static 상수만 선언할 수 있다.
 *      -> public final static 은 생략할 수 있다.
 * 2. public abstract 추상 메소드만 선언할 수 있다. (디폴트와 static도 사용할 수 있도록 추가되어서 사용할 수 있게 되었지만 많은 경우 여전히 이렇게 사용된다) 
 *      -> public abstract 는 생략할 수 있다.
 * 3. jdk 1.8 이후로 추가된 메소드
 *    1) 디폴트 메소드
 *      public default 반환타입 메소드명(매개변수) {
 *      }
 *    2) 클래스 메소드
 *      public static 반환타입 메소드명(매개변수) {
 *      }    
 *         
 *  //인터페이스라는 super(부모)를 하나 만든 느낌...여기저기 쓸 수 있는 인터페이스...CS 적으로는 느슨합 결합...
 *  //현실적, 실무적으로 봤을 때는 일종의 '작업지시서'역할을 하게됨. 인터페이스 나눠주고 이거 참고해서 만들어주세요~ 하는 거 메소드 이름이 뭐고 매개변수는 뭐고 반환타입은 뭐다!! 이런 지침이 됨
 */ 
 


public interface Shape {
  
  // 상수
  /*public final static */ double PI = 3.141592;
  
  // 추상 메소드
  /*public abstract*/ double getArea();
  /*public abstract*/ double getCircum();
  
  //디폴트 메소드
  public default void whoami(String name) {
    System.out.println(name);
  }
  
  //클래스 메소드
  public static void whoami2(String name) {
    System.out.println(name);
  }
  
  
  
  

}
