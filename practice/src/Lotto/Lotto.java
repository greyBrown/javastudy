package Lotto;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lotto {
  
  /**
   * 로또 구매<br>
   * 로또 구매를 위해서 사용자로부터 money를 입력 받는 메소드<br>
   * 로또 구매 비용은 최소 1000, 최대 100000이다.<br>
   * @return money   사용자가 입력한 로또 구매 비용에서 1000 미만 단위는 버리고 반환. ex) 5999 입력 시 5000 반환
   * @return 0       로또 구매 실패 시 반환
   */
	
	int money = 0;
	int change = 0;
	
	
	
	
	
  public int buyLotto() throws RuntimeException {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("구매할 금액을 입력하세요.");
      money = sc.nextInt();
      change = (money)%1000;
      if(money < 1000) {
    	  throw new RuntimeException("외상은 받지 않습니다. 안녕히가세요");
      }
    
    System.out.println("거스름돈" + change + "원 입니다. 감사합니다");
    sc.close();
    
    return money; 
    
  }
  
  /**
   * 로또 번호 생성<br>
   * 로또 구매 비용만큼 로또 번호를 생성하는 메소드<br>
   * 5게임씩 끊어서 생성된 로또 번호를 출력한다.<br>
   * @param money   로또 구매 비용
   */
  public List<String> generateLotto(int money) {
    
    /*
     * 예시) 5000원 구매
     * 
     * 01 : 1  2  3  4  5  6
     * 02 : 1  2  3  4  5  6
     * 03 : 1  2  3  4  5  6
     * 04 : 1  2  3  4  5  6
     * 05 : 1  2  3  4  5  6
     */
    /*
     * 예시) 10000원 구매
     * 
     * 01 : 1  2  3  4  5  6
     * 02 : 1  2  3  4  5  6
     * 03 : 1  2  3  4  5  6
     * 04 : 1  2  3  4  5  6
     * 05 : 1  2  3  4  5  6
     * 
     * 01 : 1  2  3  4  5  6
     * 02 : 1  2  3  4  5  6
     * 03 : 1  2  3  4  5  6
     * 04 : 1  2  3  4  5  6
     * 05 : 1  2  3  4  5  6
     */
    
    List<String> papers = new ArrayList<String>();
    
    
    int count = money/1000;
    
    for(int i = 0; i < count; i++) {
      for(int j = 0; j < 7; j++) {
  papers.add(((int)((Math.random() * 49)+1)) + "");
     }
   }
   
   
	 /*
	  * 문제 1) 중복
	  * if(i-1 == i) {papers.add((i*j)+j, ((int)((Math.random() * 49)+1)) + "");;}
	    	}
	  * 이 방법은 직전 중복만 피함....중복을 피할 다른 방법이 필요함
	  * 
	  * 
	  * 
	  * 문제 2 ) 정렬
	  * 로또는 작은 수부터 큰 수가 나옴.
	  * 정렬문제를 어떻게 해결할 것인가?
	  * 
	  * 
	  * 답 : 스트림
	  * 문제점 : 아직 스트림 진도 안나감
	  * 해결책 : 다른 방법으로 중복과 정렬문제를 해결한다.
	  * 중복은 그렇다치고 정렬은 어케..어케..oderby oderby...응답하라 orderby....
	  * 
	  */
	 
	 
    return null;
    
  }
  
}