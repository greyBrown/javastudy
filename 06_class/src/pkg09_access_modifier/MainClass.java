package pkg09_access_modifier;

public class MainClass {

  public static void main(String[] args) {
    
    //default는 현실에선 거의 쓰지 않고, protected는 상속관계에서 제한적으로 씁니다. 가장 일반적인게 public과 private.
    //private는 주로 필드에, public은 주로 메서드에 할당됩니다. 특이한 경우 아니면 거의 이렇게 가요.
    //필드에 직접적으로는 접근을 못하게 하겠다! 이게 오늘 access modifier에서 배울거예요.

    // computer 객체 선언 및 생성
    Computer computer = new Computer("galaxybook", 400, new Calculator());
  
    
    // 필드로 값을 전달하는 메소드(set, get 이런건 약속되어 있는 거에요~ 틀리면 나중에 동작안함;)
    computer.setModel("gram");
    computer.setPrice(200);
    computer.setCalculator(new Calculator());
    // 필드값을 가져오는 메소드 //반환값 어떻게 작성하는지 잘 보기~ 
    System.out.println(computer.getModel());
    System.out.println(computer.getPrice());
    computer.getCalculator().add(4, 5, 6);
    
    //gh sop 안에 sop 안들어가네 ㅎ ; 그렇구나...
    
  
    
    
    
  }

}
