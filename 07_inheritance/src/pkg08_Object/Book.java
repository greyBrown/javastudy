package pkg08_Object;
/*
 * Object 클래스
 * 1. 모든 클래스들의 최상위 부모 클래스이다.
 * 2. extends 키워드를 명시하지 않은 클래스들은 모두 Object 클래스를 상속한다.
 * 3. 주요 메서드
 *  1) boolean equals(Object another) {} (모든 클래스들은 equals을 통해 동등비교 가능)
 *  2) String toString() {}  (모든 클래스들은 문자열로 변환 가능)
 * 4. 역할
 *  1) 모든 것(값, 객체)을 저장할 수 있는 만능 타입이다.
 *    -> Object 타입으로 저장한 객체는 해당 객체 타입으로 캐스팅해야(다운캐스팅) 메소드를 호출할 수 있다.  //다운캐스팅 문법을 알아놔야하는 이유! 이미 만들어져있는 Object 내에 소스코드를 건드릴 수 없음.
 *  2) 모든 클래스들의 공통 기능을 지원한다.
 *    -> 대부분의 경우 Object 클래스의 메소드를 오버라이드해서 원하는 기능으로 바꿀 수 있다.
 *  
 */

import java.util.Objects;

public class Book {
  
  //field
  private String isbn;
  private String title;
  
  public Book() {
  }

  public Book(String isbn, String title) {
    super();            //Object{} 생성자를 호출, 생략할 수 있다.
    this.isbn = isbn;
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {   //이렇게....이클립스가 어어어엄청 꼼꼼하게 만들어줍니다. source에 equal~~
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Book other = (Book) obj;
    if (isbn == null) {
      if (other.isbn != null)
        return false;
    } else if (!isbn.equals(other.isbn))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Book [isbn=" + isbn + ", title=" + title + "]";
  }


 
  
  
  
  

}
