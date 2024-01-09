package pkg02_parameter;

public class Calculator {

  /*
   * 메소드의 구성
   * 1. 반환타입 : 메소드 실행 결과 값의 타입
   * 2. 메소드명
   * 3. 매개변수 : parameter라고 함. 메소드로 전달되는 값(인수, 인자, argument)
   */
  /**
   *  @param 파라미터
   *  @return 반환값
   * tmi 이런 파란색 주석 annotation(주석)이라고 부릅니다. 나중가서 많이씀
   */
  
  void method1() {  //()가 비어있다. 파라미터가 없다는 것을 알 수 있음
    System.out.println("method1");
  }

  void method2(int a) { //long double...자동형변환 가능범위까지 가능하지만, 보통 int로 주면 int로 받습니다. 
                        //그리고 int a 가 아니라 int b 라고 적어도 되요! 숫자만 오면 되는 거니까 근데 현실은 어떻다?? 안맞추면 나중에 헷갈린다...^^!
                        //아하아하 어차피 줄 때 () 안에 주니까 abc 뭐가 오든 상관없구나. 사람이 보기에 좋게 맞춰주는거!
    System.out.println("method2 : " + a);
    
  }
  
  void method3(String str ) {  //char 한글자...^^!! 이렇게 깨닫는 거져...^^!
    System.out.println("method3 : " + str);
  }
  
  void method4(double a, double b) {
    System.out.println("method4 :" + a +", " + b);
  }
    
  void method5(int a) {  //메소드 안에 메소드를 넣기. 주고주고 받기.
     method5_2(a);
  }
  
  void method5_2(int a) {
    System.out.println("method5 : " + a);
  }
  
  
   //가변 매개변수
    void method6(int... params) { //파라미터 몇개를 전달하든 상관하지 않겠다! 괜찮다! params는 사실 배열이기 때문임!
      System.out.println("method6");
      for(int i= 0; i < params.length; i++) {
        System.out.println(params[i]);  //사실상 배열이나 나름 없게 출력된다. 사실 배열형식으로 저장되는 거라서 그럼!
      }
      String.format("%4d", 10);
      String.format("%4d%4d", 10, 20);
    }
    
   //배열 매개변수 
    void method7(int[] arr) {
      System.out.println("method7");
      for(int a : arr) {
        System.out.println(a);
      }
    }
   
    //객체 매개변수 <- 이게 핵심!
    void method8(Adder adder) {
      adder.add(4, 5, 6);
    }
    
}
