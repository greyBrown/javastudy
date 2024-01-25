package pkg01_java_net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Class01_InetAddress {
  
  public static void main(String[] args) {
    
    try {
      InetAddress address1 = InetAddress.getByName("gdu.co.kr");
      // 컴파일 오류 : 예외처리 안해서. UnknownHostException
      
      System.out.println("IP주소 : " + address1.getHostAddress());
      System.out.println("도메인 : " + address1.getHostName());
     
      //112.175.247.163 ip
      
      InetAddress address2 = InetAddress.getByAddress(new byte[] {112, (byte)175, (byte)247, (byte)163});
      //위처럼 바이트로 캐스팅해서 처리해주면 됩니다!
      
      System.out.println("IP주소 : " + address2.getHostAddress());
      System.out.println("도메인 : " + address2.getHostName());
      
      //도메인 넣었어도 ip 주소가 나오지만...꼭 내가 아는 도메인 나오리란 법 없음. 신경안써도 됨. 그냥 이런 개념이 있다~
      //구글쳐도 도메인 구글안나올수 있어요. 내가 하는 도메인이랑 실제로 쓰는 내부주소랑은 다를 수 있기 때문. 
      
      //자바는 위처럼 확인만 하는 조회하는 정도... 다 돈주고 사는거라서 자바로 뭐 어떻게 하는건 아니에요 ㅎ
      //나중에 다른 클래스로 접속자 ip는 따로 꺼내봅니다. 지금은 그냥 이런 조회 등등이 있다~ 이정도만.
      
    } catch (UnknownHostException e) {
           e.printStackTrace();
    }
    
    
    
    
    
    
    
    
    
  }

}
