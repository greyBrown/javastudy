package pkg10_static;

public class MainClass {

  public static void main(String[] args) {
      
    // 클래스 멤버 호출 : 클래스.멤버
    System.out.println(Calculator.maker); //sop의 out도 static 멤버일 것이다. 문법이 그렇잖아용? static 멤버 = 클래스 멤버
    
    //static 멤버는 static만 호출할 수 있다. 같은 클래스에 method 불러올려면 static 붙어야 하는 이유!
    //JVM은 main만 열심히 찾아서 실행한다. main은 static이므로 인스턴스화 하지 않아도 실행될 수 있다. 여태 실행된 것들의 원리... 
    
    int num = Integer.parseInt("100");
    System.out.println(num);
    
    Calculator.add(4, 5); //클래스.메소드 호출하기!
    
    
    
    
    
    
    

  }

}
