package pkg02_loop;

public class Class01_while {

  public static void main(String[] args) {

    /*
     * while
     * 1. 조건식을 만족하면 반복해서 실행한다.
     * 2. 형식
     *    while(조건식) {
     *       실행문
     *    }
     */
    
    //1, 2, 3, 4, 5 출력하기
    
    int n =1; // 초기값
    while(n <= 5) {  //반복 조건
      System.out.println(n);
      n++;           //상태 변화
      }
    
    //초기값, 반복 조건, 상태 변화 셋 중 하나라도 누락되면 수열은 못만듦.
    
    // 1 ~ 5 모두 더하기
    
    // 자바는 변수 재선언 안됨. 하지만 자바 스크립트는 허용 됨.
    
    int total = 0;
    n = 1;
    
    while (n <= 5) {
      total += n;
      System.out.println(n + "번째 계산은 " + total);
      n++;
    }
    
      System.out.println("전체 합은 " + total + " 입니다.");
      
      
    
    
    
    
    
    
    
    
    
  }

}
