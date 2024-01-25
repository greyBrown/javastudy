package pkg01_java_net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.plaf.synth.SynthOptionPaneUI;


public class Class03_HttpURLConnection { //URL 클래스의 자식 클래스
  
  // 이 부분은 코드보다는 용어가 좀 더 중요해요! 용어 익숙해지는 게 중요. 응답 컨텐트타입 이게 이거고 저게 저거고...

  public static void main(String[] args) {

    //disconnect(); 작업이 있습니다. 이건 finally 에 주는게 좋아요. 예외가 발생해도 잘 닫히도록~
    // 이것도 선언부만 밖으로 빼는 게 좋아요. 선언부만 빼는 이유는 스코프조정을 넓게 하려고... 쨌든 그런거...
    
    String spec = "https://www.naver.com/";
    URL url = null;     //URL 있어야 Con 불러와요
    HttpURLConnection con = null;
    
    try {
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();         //업캐스팅은 자동이지만 다운캐스팅(부모타입->자식타입)은 강제! 다형성은 곳곳에서 나온다...
      
      /*
       * 접속 상태 확인(HTTP Response Code : 응답 코드)   NOT FOUND 404같은거...접속코드는 200이에요!
       * 1. 200 : 정상
       * 2. 4xx : 요청 문제(클라이언트 문제)  //니탓이다. 주소를 잘못적었거나...접속불가로 판단하거나...
       * 3. 5xx : 서버 문제                   //내탓이다. 코드를 잘못 짯거나...Exception 나오면 다 500번대...
       */
      
      
      
      //서버->클라이언트  이 -> 화살표가 응답. 서버가 클라이언트로 보내는게 '응답'
      //클라이언트->서버  이 -> 화살표가 요청. 클라이언트가 서버로 보내는게 '요청'
      
      int responseCode = con.getResponseCode();
      // 200 300 번호가 외우기 어려우니까 이것도 문자로 바꿔놓은게 있죠. 
      //다 HttpsURLConnection에 상수값으로 들어있어요. Not Found 같은거!
      if(responseCode == HttpURLConnection.HTTP_OK) { //(reponseCode == 200 도 되긴 해요. 200은 다들 알기도 하고...)
        System.out.println("정상 접속");
      } else {
        System.out.println("접속 불가");
      }
      
      /*
       * Content - Type
       * 1. 컨텐트 타입
       * 2. 종류
       *   1) 문서 타입   : text/xxx
       *   2) 이미지 타입 : image/xxx
       *   3) 데이터 타입 : application/xxx
       */
     String contentType = con.getContentType();
     System.out.println(contentType); //text 라고 뜸.
     
     /*
      * 요청 메소드 (Request Method, 요청 방법) //자바의 그 메소드가 아니라 방법에 가까운 의미
      * 1. GET   : 주소창(URL)을 이용한 요청. 기본 요청 방식. (요청을 주소창으로 한다. get 방식이 디폴트방식!)
      * 2. POST  : 본문(Body)을 이용한 요청 (아이디 비밀번호...이렇게 주소창에 찍히면 안되는 것들이 post 방식)
      * 용어용어용어 확실히 알아야 해요! 확-쉴히!!!
      */
      String requestMethod = con.getRequestMethod();  //메소드가 다 잘 되어있어요 ^~^
      System.out.println(requestMethod);  //Get 이라고 출력
      
      /*
       * 요청 헤더
       * 1. 요청 정보가 저장된다.
       * 2. 종류
       *    1) User-Agent     : 무엇으로 접속하였는지에 관한 정보 (매크로 탐지하거나 그럴때도 쓰고...익스플로러 시절엔 이걸로 확인해서 코드 나누고...)
       *    2) Referer        : 이전 접속 주소 정보t. (물건살때 로그인하라그래서 했는데 메인가면 빡치겠죠. 리퍼럴 주소로 가게 안내해주는 그런거.. 근데 요새는 아예 주소가 넘어가요. 로그인 후 어디로 넘어갈지 URL 에 찍어놓음) 
       *    3) Content-Type   : 컨텐트 타입
       *    4) Content-Length : 컨텐트 크기 
       */
      //Map<String, List<String>> requestHeader = con.getRequestProperties(); //Properties 데이터 모두 보여줌. 하나씩 골라 보는건 Property
      //for(Entry<String, List<String>> entry : requestHeader.entrySet()) {
      //  System.out.println(entry.getKey() + " : " + entry.getValue());      //컬렉션도 실제로 쓸 때는 생략되는 생성-선언이 많음! 요거 참고가 될 거 같아요. EntrySet 이 별도로 선언되지 않고 for 문 내에서 이루어짐!
      // }  이건 안되서...아마 인증과정이 없어서 막힌듯? 코드만 그냥 두겠심
      String userAgent = con.getRequestProperty("User-Agent");
      System.out.println(userAgent);  // 원하는 것만 찝어서 요청. 이건되네요! 자바 17로 접속했다는걸 출력해줌
      String referer = con.getRequestProperty("Referer");
      System.out.println(referer); //이건 없다고(null) 나옴 ㅋㅋㅋㅋ
      
      
      
      
      
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {  //부모가 아래로 가도록...캐치 2개인데 오류나면 높은 확률로 이거
      e.printStackTrace();
      //IOException 은 HttpsURLConnection 이게 IOException을 내보내기 때문
    } finally {
      if(con != null)
      con.disconnect();  //con 이 초기화에 대해 무방비함. URL 생성하다가 오류나면 con이 null인 상태에서 disconnect 하다가 오류(널포인트참조오류)날때 조건을 달아줘야함.
    }
    
    
    
  }

}
