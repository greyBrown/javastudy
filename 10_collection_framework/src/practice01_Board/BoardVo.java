package practice01_Board;

public class BoardVo {

  private int boarNO;
  private String title;
  private String writer;
  private String createdAt;
  
  public BoardVo() {
  }

  public BoardVo(int boarNO, String title, String writer, String createdAt) {
    super();
    this.boarNO = boarNO;
    this.title = title;
    this.writer = writer;
    this.createdAt = createdAt;
  }

  public int getBoarNO() {
    return boarNO;
  }

  public void setBoarNO(int boarNO) {
    this.boarNO = boarNO;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  @Override //generate에서 toString 오버라이딩~~ 참조값말고 내용보여줘! 이렇게 다 오버라이딩 한다고 Object 때 배웠죠~
  public String toString() {
    return "BoardVo [boarNO=" + boarNO + ", title=" + title + ", writer=" + writer + ", createdAt=" + createdAt + "]";
  }
  
  
  
  
  
  
}
