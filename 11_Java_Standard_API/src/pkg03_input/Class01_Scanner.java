package pkg03_input;

import java.util.Scanner;

public class Class01_Scanner {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    /*
     * java.util.Scanner
     * 1. 데이터를 읽을 때 사용한다.
     * 2. 주로 표준 입력 스트림(System.in - 키보드를 의미함)으로부터 데이터를 입력 받는다.  // 여태 익숙해진 System.Out은 표준 출력 스트림이었습니다~ 모니터를 의미!
     * 3. 데이터 타입에 따라 사용하는 메소드가 다르다.
     *    1) next()            : 문자열 입력 (공백 없는 문자열)
     *    2) nextLine()        : 공백 포함된 문자열 입력 (공백 있는 문자열)
     *    3) nextInt()         : int 입력
     *    4) nextLong()        : long 입력
     *    5) nextDouble()      : double 입력
     *    6) nextBoolean()     : boolean 입력 (직접 true false 적을 일이 별로 없다보니 그닥 안씀)
     *    7) next().charAt(0)  : char 입력 (1번 메소드를 쓰되 한글자만 뽑아내주겠다...)
     * 
     *  //Scanner 는 웹개발로 넘어가면 웹에서 입력을 받기 때문에 그닥 쓸일은 없는 친구...그래도 기본적인 툴은 알아둬야 여기저기 자바 쓸 때 써요.   
     */
   
     // Scanner 객체 선언 및 생성
    Scanner sc = new Scanner(System.in);
    
     // String 입력
    System.out.println("이름을 입력하세요 >>>");
    String name =  sc.next();  //이 부분이 입력하는 곳
    
    // int 입력
    System.out.println("나이를 입력하세요 >>>");
    int age = sc.nextInt();
    
    // double 입력
    System.out.println("키를 입력하세요 >>>");
    double height = sc.nextDouble();
    
    // char 입력
    System.out.println("성별을 입력하세요(남/여) >>>");
    char gender = sc.next().charAt(0);
    
    //확인
    System.out.println(name);
    System.out.println(age);
    System.out.println(height);
    System.out.println(gender);
    
    //입력이 끝난 후 스트림을 닫아주는 역할을 해야 함. (지금 오류 표시가 그걸 의미함) 닫는걸 close 라는 인터페이스로 구현함. AutoCloseable 이 있어서 안닫아줘도 문제는 없음
    //=> 자바가 잘 해줘서 안닫아줘도 가능하다 ^_^ 그래도 아래처럼 닫아주면 경고표시 안뜸
    
    
    //닫기(생략가능)
    sc.close();
    
    //IoException은 Stream 사용할 때 발생하는 입출력예외. checked Exception. 그래서 Stream 작업할 때 try catch 작업 계속 해줘야함.
    //checked Exception 이란게 체크 안해주면 실행 안하겠다는 거라서 계속 try catch를 해줘야 함. 지금은 그냥...닫아주니 안해줘도 됐지만 이제 곧 해주는 진도를 나간다 그런 이야기...
    
    
  }

}
