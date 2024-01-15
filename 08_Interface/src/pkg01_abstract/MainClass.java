package pkg01_abstract;

public class MainClass {

  public static void main(String[] args) {
    
    //업캐스팅(자식 객체는 부모 타입으로 자동 변환된다.)
    Shape shape1 = new Circle("원", 0, 0, 1.5);
    
    //업캐스팅된 객체는 부모의 메소드만 호출할 수 있다.
    System.out.println(shape1.getName());

    //업캐스팅된 객체의 메소드는 다운캐스팅 후 호출할 수 있다.
    if (shape1 instanceof Circle) {
      System.out.println(((Circle)shape1).getX()); //앞에 가로쳐주는거 shape1을 circle로 바꾸는 걸 먼저 하라 그런뜻이에요. 이런식으로 다운캐스팅 할 일은 별로 없지만~
      System.out.println(((Circle)shape1).getY());
      System.out.println(((Circle)shape1).getRadius());
    }
    System.out.println("넓이 :" + shape1.getArea());
    System.out.println("둘레 :" + shape1.getCircum());
    
    
    
    Shape shape2 = new Rectangle("사각형", 0, 0, 5, 5);
    
    System.out.println(shape2.getName());
    
    if(shape2 instanceof Rectangle) {
      System.out.println(((Rectangle)shape2).getX1());
      System.out.println(((Rectangle)shape2).getX2());
      System.out.println(((Rectangle)shape2).getY1());
      System.out.println(((Rectangle)shape2).getY2());
    }
    
    System.out.println("넓이 :" + shape2.getArea());
    System.out.println("둘레 :" + shape2.getCircum());
    
    //Shape shape = new Shape(); //shape이 추상클래스가 되어서 이제 객체 생성이 안됨! 하지만 shape 생성자의 익명 내부타입을 이용해 생성할 수는 있음. 객체 생성시 메소드를 채우면 생성할 수 있게 해줌...
                               //보통 임시 객체에서 많이 쓰는 방법임(여기서는 별로 안쓰고 안드로이드 이런데에서...) 누르면 추상화한 메소드가 아래에 주르륵 뜸.
    
    
    
    
    
    
    
    

  }

}
