package pkg01_java_net;

import java.net.MalformedURLException;
import java.net.URL;

public class Class02_URL {

  public static void main(String[] args) {

    try {
      //URL이 중요해요!! 여기서부터 중요!!
      
      URL url = new URL("https://www.example.com:9090/webtoon/list?page=1&id=100#memo");
      
      //이 주소 구성에 대해 이해 확실히 해야 해요!( + 주소는 공백없이 완전히 붙여 쓸것. 공백도 글자로 취급함)
      //경로는 시퀀스 다이어그램이라는 이름으로 엑셀파일로 만들어 둡니다...뭐는 이름이 뭐다 뭐는 뭐고!! 이런거...
      
      System.out.println(url.getProtocol());
      System.out.println(url.getHost());
      System.out.println(url.getPort());
      System.out.println(url.getPath());
      System.out.println(url.getQuery());
      System.out.println(url.getFile());  //path, query 합쳐서 나옴.
      System.out.println(url.getRef());
      
      //몇몇 메소드 preview 살짝...
      
     // url.openConnection(); //접속관련
     // url.openStream();     //접속해서 InputStream을 쓰는 메소드..이따 해봅시다 ^~^
      
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
  }

}
