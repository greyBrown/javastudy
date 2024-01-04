package pkg04_logical;

public class MainClass {

  public static void main(String[] args) {

    /*
     * 논리 연산
     * 1. boolean 타입의 값을 이용한 연산이다.
     * 2. 종류
     *    1) && : 논리 AND, 두 항이 모두 true 이면 true 나머지 경우는 false 반환
     *    2) || : 논리 OR,  두 항 중 하나로 true 이면 true 나머지 경우는 false 반환
     *    3) !  : 논리 NOT, 전달된 항이 true 이면 false 반환 (반대값을 반환)
     */

    /*
     * 숏 서킷
     * 1. 연산 결과의 빠른 처리를 위한 동작이다.
     * 2. 종류
     *    1) && : false 가 반환되면 최종 결과도 false 이므로 더 이상 동작하지 않는다.
     *    2) || : true 가 반환되면 최종 결과도 true 이므로 더 이상 동작하지 않는다.
     */
   
    int n1 =10;
    int n2 = 20;
    
    boolean a = n1 == 10 && n2 == 20;
    boolean b = n1 == 10 && n2 == 10;
    boolean c = n1 == 20 && ++n2 == 20; //숏 서킷에 의해서 ++n2 == 20 코드는 실행되지 않는다.
  //  System.out.println(n2); -> 여기서 실행해보면, n2는 21이 아니라 20으로 나오게 된다. 왜? 최종 결과가 false이므로 더 이상 동작하지 않는다.
    boolean d = n1 == 20 && n2++ == 20; //숏 서킷에 의해서 n2++ 코드는 실행되지 않는다.
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    
    // =가 대입연산자 ==가 비교연산자죠~~ 
    
    
    boolean f = n1 ==10 || n2++ == 20; // 숏 서킷에 의해서 n2++ == 20 코드는 실행되지 않는다.( 이 문장의 결과가 true -> n2++ 코드는 실행되지 않는다. ||는 true가 나오면 동작 멈추니까!)
    boolean g = n1 ==10 || ++n2 == 10; // 숏 서킷에 의해서 ++n2 == 20 코드는 실행되지 않는다.
    
    System.out.println(f);
    System.out.println(g);
    
    boolean h = !(n1 == 10);  //n1 == 10 은 true 니까 답은 false 아 ! 저따 붙이는구나 어쩐지 안되더라 ㅅㅂ
    System.out.println(h);   //false가 나오게 된다!
    
    //비교연산 논리연산 중요하니까 잘 기억하고 원리 파악하고 계세용
    
    
    
       
        
    
   
    
  
    
 
    
    
    
    
    
  }

}
