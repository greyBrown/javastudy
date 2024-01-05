package pkg02_loop;

public class Class02_for {

  public static void main(String[] args) {
  //while 보다 for 문이 더 널리쓰이니까 이걸 위주로 공부하는 게 좋아요!
    
    /*for
     * 1. 조건식을 만족하면 반복해서 실행한다.
     * 2. 형식
     *    for( 초기상태 ; 반복조건 ; 상태변화 ; ){
     *    실행문
     *    }
     * 3. 실행순서
     *  초기상태 -> 반복조건 -> 실행문 -> 상태변화 -> 반복조건 -> 실행문 -> 상태변화 -> ...  
     *  //초기상태에서 변수의 선언까지 동시에 할 수 있다는게 편한점! while 은 조건을 강조할때...시작점 종착점 모를 때(별로 없음) 이런 경우나 좀 써요 개수 지정 안할 때
     *  // 특정 값이 정해져 있을 때는 for문은 정답이라고 봄.
     */
    
    
    // n번 반복하기의 가이드라인
    // 1, 2, 3, 4, 5 출력하기
    
    for(int n = 1; n<=5; n++)
    {System.out.println(n);}
    
    
  
    
    
    //gh...이 방법 맞지? 맞다!
    for(int i = 1; i <= 9 ; i++) {
      for(int j = 1; j <= 9 ; j++) {
      System.out.println(i+"*"+j+"="+i*j);}
    }
    
    //아하 그렇다...sop 두번 나올 이유가 없음.
      
    //gh 아 줄바꿈 \n 이렇게...저런 위치로 들어가는군요...for1{(for2){for2}{for1}} 요런느낌 for1{{1}{1}{1}} 요게 저런식으로 쓰여진 넉낌.
    for(int i = 1; i <= 5 ; i++) {
      for(int j = 1; j <= 5 ; j++) {
      System.out.print("*");} 
      System.out.println("\n");}
    
    //tmi for문의 중첩은 현실상으로는 3개정도입니다. 이론상으로는 더 넣을 수 있지만....나중엔 갸갸갸갸된다.....얘가 어디의 누군지... 보통 2개 많이 씀
    
    
    //for 중첩
    for(int day = 1; day <= 5; day++) {
      System.out.println(day + "일차"); 
      for(int hour = 1; hour <= 8; hour++) {
        System.out.println(hour + "교시");
      }
    }
    
    
    
    
    
    
    
    
    
    
    
    
  
  }
}
