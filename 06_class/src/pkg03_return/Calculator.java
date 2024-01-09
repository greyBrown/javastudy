package pkg03_return;

public class Calculator {

  // 반환값 : 메소드 실행 결과값
  // void : 반환값이 없음

  // int 반환 메소드
  int method1() {
    return 10;  //int가 아닌 다른 값이 오면 오류남. return 값과 반환값을 일치시킬것!
    //반환값이 2개 이상이다? 타입은 같다? 그러면 배열로 반환합니다...
  }
  
  
  // int[] 반환 메소드
    int[] method2() {
      //int [] arr = {10, 20}; 이렇게 할 수도 있지만 한번에 할 수도 있어요
      return new int[] {10, 20};
    }

    //Adder 타입 객체 반환 메소드
    Adder method3() {
//    Adder adder = new Adder();
//    return adder;  이 2줄 코드를 아래처럼 1줄로 쓸 수 있어요
      return new Adder();
      
    

}

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
  
  
  
  
 