package pkg05_void_return;

public class Calculator {

  /*
   * 반환타입이 void인 경우에는 return; 코드로 메소드 실행을 중지할 수 있다. 각종 예외처리에 흔히 쓰입니다!
   * (void 아니라면 못씀!!)
   */
  
  
  
  void root(int number) { //기능이 동작하지 않는 경우만 if 처리, 아래쪽에서 기능구현만. 실무에서는 이런걸 추구해욥. if만 있으면 안되는거 if랑 sop를 두번 거칠테니 아래처럼 return을 사용해서 아래처럼!
    if(number <=0) {
      System.out.println(number + "는 제곱근은 계산할 수 없습니다.");
      return;
    } 
    
    System.out.println(number + "의 제곱근은" + Math.sqrt(number) + "입니다.");
    
    
  }
  
  
  
}
