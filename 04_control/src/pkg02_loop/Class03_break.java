package pkg02_loop;

public class Class03_break {

  public static void main(String[] args) {

    //break : loop 문을 종료한다.
    
    // 1 ~ 5 출력하기
    int n;
    
    
    //while 을 이용한 무한 루프 //좋네요 while(true)... 1=2 이렇게 쓰는 것처럼...
    n = 1;
    while(true) {
      if(n > 5)
        break;
      System.out.println(n++);
    }

    //for을 이용한 무한 루프
    n = 1;
    for(;;) {
      if(n == 6)
        break;
      System.out.println(n++);
    }
    //보통 무한루프는 while 문으로 한다.
    //gh 시험에서 주의해야할점....! 이거 답 6이라고 쓰면 틀리는 거임 ㅋㅋㅋ break 위치가 중요하다!!!
  }

}