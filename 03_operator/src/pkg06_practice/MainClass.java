package pkg06_practice;

public class MainClass {

  public static void method1() {
    
    int second = 90;
    int m = second/60; //1  분
    int s = second%60;   //30 초 gh 분초도 붙여줘봐여...문자열연결은 + 이죠!

       System.out.println(m +"분");
       System.out.println(s +"초");
       
       
    
  }
  
  public static void method2() {
   
    //x와 y의 값을 교환하기
    
    int x = 10;
    int y = 20;
    int temp;
    
    temp = x;
    x = y;
    y = temp;
    
    
    System.out.println(x); //20
    System.out.println(y); //10
    
  }
  
  public static void method3() {
    
    //점수가 90점대이면 true 아니면 false
    int score = 90;
    
    String result3 = 90<=score && score<100 ? "true" : "false" ;
    System.out.println(result3);
    
   //방법2.
   //boolean result1 = score >= 90 && score < 100;
    
   //방법3.
   //boolean result2 = (score / 10) == 9; score가 int 인 걸 이용한거죠! 이런저런 방법을 생각해보는게 좋아요
 
  }
  
  public static void method4() {
    
    //짝수/홀수 판단
    //짝수 : 2로 나눈 나머지가 0인 수
    //홀수 : 2로 나눈 나머지가 1인 수 
    
    int n = 3;
    
    String result4 = n%2 == 0 ? "짝수" : "홀수" ;
    System.out.println(result4);
    
    
    
    
  }
  
  public static void main(String[] args) {
   //메인 메서드가 아닌 메서드는 인간이 메서드를 호출해줘야 함. JVM이 해주지 않음!
    method1(); //메서드1 실행하겠다.
    method2(); //메서드2 실행하겠다.
    method3();
    method4();
  }

}
