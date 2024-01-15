package pkg05_marker_interface;

public class MainClass {  //마커인터페이스 public interface A {} 이렇게 본문이 아예 없는 인터페이스 예시로 Cloneable 처럼...본문이 없음!

  public static void main(String[] args) {
  

  Person person = new Person();
  
  person.eat(new AppleMango());
  person.eat(new PineApple());
  person.eat(new Durian());
  
  DurianHatePerson durianHatePerson = new DurianHatePerson();
  durianHatePerson.eat(new AppleMango());
  durianHatePerson.eat(new PineApple());
  //durianHatePerson.eat(new Durian());    //컴파일오류
  
  

  
  
  
  
  
  
  }  

}
