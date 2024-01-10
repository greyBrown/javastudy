package pkg08_this;

public class Computer {
  
  String model;
  int price;
  
  
  //this(): 생성자를 호출하는 것
  Computer(){
    this(null, 0); //이러면 3번 생성방법을 호출함. 개수보고 맞춰서 불러줌...
  }
  
  Computer(String model) {
    this(model, 0); //마찬가지로 3번 생성방법을 호출.
  }
  
  Computer(String model, int price){ //기본이 바로 이 생성자이기 때문. 생성자체는 이 친구가 다함.
    this.model = model;    //이제_를 써줄 필요가 없음. this가 바로 이렇게 쓰여용!
    this.price = price;
  }
  //컴퓨터를 생성하는 3가지 방법
  
  
  public void showThis() {
    System.out.println(this); //현재 객체(showThis() 메소드를 호출한 객체)를 의미함
  }
  
  public void showModel() {
    System.out.println(this.model);
    
  }
  
  //this() : 생성자를 호출하는 것
  //this.멤버 : 멤버(필드, 메소드)를 호출하는 것
  
  
}
