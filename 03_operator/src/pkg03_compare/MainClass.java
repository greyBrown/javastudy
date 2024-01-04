package pkg03_compare;

public class MainClass {

  public static void main(String[] args) {

    //비교 연산자
    //연산 결과는 boolean 타입으로 결과가 나온다. -> true 또는 false
    
    int a = 10;
    int b = 20;
    
    System.out.println(a > b);  // a > b 이면 true
    System.out.println(a >= b); // a >=b 이면 true
    System.out.println(a < b);  // a < b 이면 true
    System.out.println(a <= b); // a <= b 이면 true
    System.out.println(a == b); // a와 b가 같으면 true
    System.out.println(a != b); // a와 b가 다르면 true
    
    //문자열의 동등 비교는 사용을 금지한다. 되는 것 같겠지만 사실은 아니니까 쓰면 안돼욥!!
    String s1 = "hello";
    String s2 = "world";
    System.out.println(s1 == s2);
    
    

  }

}
