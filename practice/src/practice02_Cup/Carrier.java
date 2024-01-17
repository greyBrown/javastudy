package practice02_Cup;

import java.util.ArrayList;
import java.util.List;

public class Carrier {   
  
  private List<Cup> cups;
  
  
  public Carrier(int cupCount) {
     cups = new ArrayList<Cup>(cupCount); 
}
  
  public List<Cup> getCups() {
    return cups;
  }
  
  public void setCups(List<Cup> cups) {
    this.cups = cups;
  }
  
  //컵 담기
  public void addCup(Cup cup) {
     cups.add(cup);
    System.out.println("현재 컵 : " + cups.size() + "개");
  }
  
  //캐리어 확인
  public void whoami() {
    for(int i = 0, n = cups.size(); i < n ; i++) {
      
      cups.get(i).whoami();
    }
  }

  
  
  
  
}


/*잠깐 배열...ㅎ...
 * int[] arr;
 * arr = new int[3];
 * 그...선언 방식만 좀 달라진거지 평소에 쓰는 그 배열이에요.
 * 
*/
