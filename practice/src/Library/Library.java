package Library;

import java.util.List;

public class Library { 

  private List<Book> inBooks;
  private List<Book> outBooks;
  private Book book;
  
  Book book1 = new Book("이방인", "알베르 카뮈");
  Book book2 = new Book("어느 인생", "기 드 모파상");
  Book book3 = new Book("잃어버린 시간을 찾아서", "마르셸 프루스트");
  Book book4 = new Book("야간 비행", "생텍쥐페리");
  Book book5 = new Book("", "알베르 카뮈");
  
  
  
  
  public Library(List<Book> inBooks, List<Book> outBooks) {
    super();
    this.inBooks = inBooks;
    this.outBooks = outBooks;
  }

  public void loanBook(String bookname) {
    // 책을 빌리는 메소드. 
  }
  
  public void returnBook(String bookname) {
    // 책을 돌려주는 메소드.
  }

  public void booklist() {
    //inBooks 배열을 보여주는 메소드
  }
  
  
  /* 5권의 책이 있는 1인 전용 도서관이다. 
   * 3권은 에세이 2권은 소설이다
   * 에세이 대출기간 7일 소설은 대출기간 14일
   * 대출기간 연장은 7일씩 한번만 가능합니다.
   * 책의 상태는 둘 중 하나임. 대출되어 있거나 아니거나 -> boolean
   * 책의 배열이 2개 필요함. 대출중인 책(inBooks). 소장중인 책(outBooks).
   * 
   * 
   */
  
  
}
