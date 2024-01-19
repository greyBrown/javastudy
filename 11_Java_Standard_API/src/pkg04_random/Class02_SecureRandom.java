package pkg04_random;

import java.security.SecureRandom;

public class Class02_SecureRandom {
  
  public static void main(String[] args) {
    
    
    //기본 시드 사용 : new SecureRandom()
    //시드 전달 가능 : new SecureRandom(byte[] seed)
    
    SecureRandom secureRandom = new SecureRandom("홍길동".getBytes()); //이렇게 시드를 줄 수 도 있습니다. getBytes 스트링 관련 메소드인데..넣어봤어요 그냥.
    
    
    
    
    // nextDouble() : 0.0 <= 난수 < 1.0
    
    
   
    
    //SecureRandom secureRandom = new SecureRandom();
    
    //5% 확률 대박
    if(secureRandom.nextDouble() < 0.05) {
      System.out.println("대박");
    } else {
      System.out.println("대박은 무슨");
    }
    
    // nextInt() : int 범위 중 하나
    // nextInt(5) : 0 ~ 4 중 하나
    // nextInt(5) + 1 : 1 ~ 5 중 하나
    
    int yut = secureRandom.nextInt(5) + 1;
    System.out.println(yut);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }

}
