package pkg02_generic_type;

public class MainClass {

  public static void main(String[] args) {

    //Integer 저장용 Container. 객체 만드는 문법은 약간 색달라요!
    
    Container<Integer> container1 = new Container<Integer>();
    container1.setItem(10); //파라미터가  Integer라고 템플릿이라고 미리 보여줌!
    System.out.println(container1.getItem());
    
    Container<String> container2 = new Container<>(); //생성자에서는 꺽쇠내부 생략가능! 앞부분 말고 생성자에서만!
    container2.setItem("hello");
    System.out.println(container2.getItem());
    
    
    
    
    
    
    
    
  }

}
