package pkg02_FunctionalInterface;

public class MainClass {

  public static void main(String[] args) {
    //interface MyInterface1 { void method(); }
    MyInterface1 my1 = () -> System.out.println("hello world");  
    my1.method();                      //람다식으로 객체 생성한거죠?? 메소드 호출하는 거 잊지말기!!
     
    //interface MyInterface2 { String method(); }
    
    /*
    MyInterface2 my2 = () -> {
      return "hello world";
    }; 생략없이 풀어쓰는 버전
    */
    
    
    MyInterface2 my2 = () -> "hello world";            //본문이 1개면 이렇게 생략할 수 있죠! 헷갈리면 식 정리한거 다시 보기. 반환타입만 적어주니까 SOP는 못적죠.
    System.out.println(my2.method());                  //반환타입있으니까 이렇게 출력~ 이런거 오랜만...그동안 IO 하느라 ㅜ ㅋㅋㅋㅋㅋㅋ
    
    //interface MyInterface3 { void method(String name); }
    MyInterface3 my3 = (name) -> System.out.println(name + "님");
    my3.method("jessica");
    
    //interface MyInterface4 { String method(String name); } 
    MyInterface4 my4 = (name) -> name + "님";
    System.out.println(my4.method("Alex"));
    
    
    
    
    
    
    
    
    
  }

}
