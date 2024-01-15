package pkg01_abstract;

/*
 * 추상클래스
 * 1. 추상 메소드를 가지고 있는 클래스이다.
 * 2. 추상 클래스는 객체 생성이 불가능하다.     //추상 클래스는 객체생성 Shape shape = new Shape(); 이거 안됨!
 *    -> 1) 익명 내부 타입(Anonymous Inner Type)으로 생성할 수 있다.
 *       2) 객체를 생성할 때 추상 메서드를 곧바로 오버라이드해서 만드는 것을 의미한다.
 * 3. 형식
 *    abstract class 클래스명 {}
 */

public abstract class Shape {
  
  //field
  private String name;
  
  //constructor
  public Shape() {
  }

  public Shape(String name) {
    super();
    this.name = name;
  }

  //method
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  //넓이를 반환하는 메소드

//  public double getArea() {
//    return 0;  //컴파일 오류를 막기위해 리턴 뭐라도 넣어줘야 함. 안그러면 빨간줄이 직직 가죠... double 이라매!! void 아니라매!!
//  }
//                                           //이렇게 작성해놓고, @Override해서 써라! 메소드명만 같고 내용은 다르게! 부모의 메서드를 자식이 다시 만드는 것 이게 오버라이드였죠~
//  //둘레를 반환하는 메소드
//  public double getCircum() {
//    return 0;
//  }
  
  
  //위처럼 본문이 필요하지 않은 메소드를 추상메소드라고 한다.
  
  /*
   * 추상 메소드
   * 1. 본문이 없는 메소드이다.
   * 2. 형식
   *    abstract 반환타입 메소드명(매개변수); <-{}이 중괄호도 없음!
   */

  //위 return0을 형식상 넣었던 메소드 2개를 추상 메소드를 변환
  public abstract double getArea();
  
  public abstract double getCircum();
  
  
  
  
}
