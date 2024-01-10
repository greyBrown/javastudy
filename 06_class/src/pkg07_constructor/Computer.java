package pkg07_constructor;

public class Computer {
  
  //field
  String model;
  int price;
  Calculator calculator;
  
  
  
  
  
  
  
  
  //필드 초기화를 위해 생성자를 사용할 수 있다. 생성자를 만드는 이유는 보통 필드 초기화 때문임! 아니라면 굳이 만들 필요가 없으니까...!
  //생성자가 n개다 -> 객체를 생성하는 방법도 n개다.
  
  
  
  
  // constructor
  Computer(){  //->mc의 new computer() 거기서 호출됨. 확인해봐용
    System.out.println("Computer()");
  } //우리가 직접 만들어본 디폴트 생성자. 실행하면 자바가 만든거 대신 이걸 쓴다.
  
  Computer(String _model, int _price){
    model = _model;
    price = _price;
  }
  Computer(String _model, int _price, Calculator _calculator) {
    model = _model;
    price = _price;
    calculator = _calculator;
  }
  
  //method
  void develop() {
    System.out.println(model + "이용해서 개발중");
  }
  
  void danggeun() {
    System.out.println(price / 100 * 60 + "원에 쿨거래");
  }
  
 
  
  
  
}
