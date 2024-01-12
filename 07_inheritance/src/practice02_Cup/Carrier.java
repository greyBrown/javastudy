package practice02_Cup;

public class Carrier {   
  
  private Cup[] cups;
  private int idx;  //cups 배열의 인덱스
  
  public Carrier(int cupCount) {
    cups = new Cup[cupCount];
}
  
  //컵 담기
  public void addCup(Cup cup) {
    if(idx >= cups.length) {
      System.out.println("캐리어가 꽉 찼습니다.");
    return; 
    }
    
    cups[idx++] = cup;
    System.out.println("현재 컵 : " + idx + "개, 앞으로" + (cups.length - idx) + "개 추가 가능");
  }
  
  //캐리어 확인
  public void whoami() {
    for(int i = 0; i < idx; i++) {
      
      cups[i].whoami();
    }
  }
  
  
  
  
  
}


/*잠깐 배열...ㅎ...
 * int[] arr;
 * arr = new int[3];
 * 그...선언 방식만 좀 달라진거지 평소에 쓰는 그 배열이에요.
 * 
*/
