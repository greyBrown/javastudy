package pkg08_this;

public class MainClass {

  public static void main(String[] args) {
    
    Computer computer = new Computer();
    
    System.out.println(computer); //이러면 this.conputer~~~주소값이 나온다.
    computer.showThis();// 위와 같은 값이 나옵니다. 이 시점에선 computer 가 this 값이다.
    
    
    System.out.println(computer.model);
    computer.showModel();
    
    
  }

}
