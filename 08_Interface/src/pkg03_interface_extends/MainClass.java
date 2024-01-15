package pkg03_interface_extends;

public class MainClass {

  public static void main(String[] args) {

    //각자 호출할 수 있는 메서드들
    
    Elec elec = new SmartPhone(); //자기 메소드 3개 elec 타입 1개
    elec.powerOn();
    ((SmartPhone)elec).game();
    ((SmartPhone)elec).call();
    System.out.println();
    
    
    
    Computer computer = new SmartPhone(); //자기 메소드 3개 computer 타입 1개 elec 타입 1개
    computer.powerOn();
    computer.game();
    ((SmartPhone)computer).call();
    System.out.println();
    
    Phone phone = new SmartPhone();  //자기 메소드 3개 phone 타입 1개
    phone.call();
    ((SmartPhone)phone).powerOn();
    ((SmartPhone)phone).game();
    System.out.println();
    
    //업캐스팅 안하면 다~ 부를 수 있죠! 인터페이스는 공통기능만 정의하는거라서 구현클래스들이 인터페이스의 메소드만 가지고 있는건 아님. 
    //인터페이스(공통) + 자기꺼. 많은 부분 상속과 비슷한 면이 있음... 업캐스팅하면 부모꺼밖에 못쓴다는 그런것처럼... 
    //하지만 기본 타입은 인터페이스타입으로 갑니다. 필요하면(구현클래스 메소드를 호출하는 등 etc) 다운캐스팅! 스프링에서 객체가 인터페이스를 보고 만들어지기때문.
    SmartPhone smartphone = new SmartPhone(); 
    smartphone.powerOn();
    smartphone.game();
    smartphone.call();
    
    
    
    
  }

}
