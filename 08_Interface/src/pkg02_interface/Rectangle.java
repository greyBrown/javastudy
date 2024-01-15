package pkg02_interface;

public class Rectangle implements Shape { //Rectangle 은 class 작성시 interfaces 에서 입력 후 add 해서 만들어봤습니다! 이렇게 자동화가 되어있어요. 
                                          //인터페이스는 이식받은 클래스는 추상메서드 모두 구현받아야 해요! 그러니까 딱 정해진 형식이 있다 -> 자동화가 된다.

  
  private String name;
  private double x1;
  private double y1;
  private double x2;
  private double y2;
  
  //constructor
  public Rectangle() {
    
  }

  public Rectangle(double x1, double y1, double x2, double y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
  
  
  
  @Override
  public double getArea() {
    return  (x2 - x1) * (y2 - y1);
  }

  @Override
  public double getCircum() {
    return 2 * ((x2 - x1) + (y2 - y1));
  }

  public double getX1() {
    return x1;
  }

  public void setX1(double x1) {
    this.x1 = x1;
  }

  public double getY1() {
    return y1;
  }

  public void setY1(double y1) {
    this.y1 = y1;
  }

  public double getX2() {
    return x2;
  }

  public void setX2(double x2) {
    this.x2 = x2;
  }

  public double getY2() {
    return y2;
  }

  public void setY2(double y2) {
    this.y2 = y2;
  }

 
}
