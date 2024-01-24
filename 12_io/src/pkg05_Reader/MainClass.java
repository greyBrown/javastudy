package pkg05_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
  
  /*
   * java.io.FileReader (아주 소중한 친구...나처럼 한글이 아작이 나는 경우를 방지해주는...)
   * 1. 문자 기반의 파일 입력 스트림이다.
   * 2. 입력 단위
   *    1) int
   *    2) String
   */
  
  /* 
   * java.io.BufferedReader (이게 중요함!!) 
   * 1. 버퍼링을 지원하는 문자 입력 스트림이다.
   * 2. 보조 스트림으로 메인 스트림과 함께 사용해야 한다.   
   * 3. 버퍼링을 지원하므로 입력 속도가 향상된다.
   * 4. 한 줄 씩 읽는 readLine() 메소드가 있다.   
   *    
   */
  
  /*
   * java.io.InputStreamReader
   * 1. 바이트 입력 스트림을 문자 입력 스트림으로 변환한다.
   * 2. 바이트 입력 스트림으로 문자 데이터가 전달되는 경우 사용한다.
   */
  
 public static void method1() {
   
   File dir = new File("\\storage");
   File file = new File(dir, "sample1.txt");
   
   
   // 파일 입력 스트림 선언
   FileReader in = null;
   
   try {
     
     // 파일 입력 스티림 생성
     in = new FileReader(file);
     
     // 읽는 단위(chr[]로(char 보다 성능이 좋음. byte 랑 원리 같아요)~ String 은 버퍼 쪽에서 합시다)
     char[] cbuf = new char[2];
     
     // 읽은 데이터 저장소(글자 단위로 가져왔으니 배열은 필요없어요. String 으로)
     StringBuilder builder = new StringBuilder();
     
//     // 배열과는 달리 실제 읽은 글자수가 상이할때(2짜리 배열인데 나머지 1글자 남은 경우.  반환값이  2 2 1 -1 로 바뀌는 거 유의)
//     System.out.println(in.read(cbuf)); //2
//     System.out.println(in.read(cbuf)); //2
//     System.out.println(in.read(cbuf)); //1
//     System.out.println(in.read(cbuf)); //-1
     
     //읽은 글자수
     int readChar = 0;
     
     //읽기
     while(true) {
       readChar = in.read(cbuf);
       if(readChar == -1) {
         break;
       }
       builder.append(cbuf, 0, readChar);  // cbuf[0]부터 readChar만큼 builder에 추가. 계속 2글자 가져오면 안되고 마지막에는 1글자만 가져와야 하니까 해주는 처리!
     }
  
     
     // 확인
     System.out.println(builder.toString());
     
     // 파일 입력 스트림 닫기
     in.close();
     
     //하지만 이 방법보다는 Buffer에 다른 메소드 껴서 쓰는게 더 추천해요. method2 추천!!
     
     
  } catch (IOException e) {
      e.getStackTrace();
  }
   
 }

 public static void method2() { //중요한 친구~~
   
   File dir = new File("\\storage");
   File file = new File(dir, "sample2.txt");
   
   // 버퍼 입력 스트림 선언
   BufferedReader in =null;
   
   try {
    
     // 버퍼 입력 스트림 생성
     in = new BufferedReader(new FileReader(file));
     
     // 읽는 단위
     String line = null;
     
     // 읽은 데이터 모으기
     StringBuilder builder = new StringBuilder();
     
     // readLine() 메소드는 파일에 끝에 도달하면 null 을 반환함(String 이라서 -1 반환못함!!!)
//     while(true) {
//       line = in.readLine();                   //line 은 글자만 카운트한 5글자가 있을까 줄바꿈이 포함된 6글자일까...? 과연! -> 안들어있음.
//       if(line == null) {                     //실무에선 그닥 중요하진 않아요. 줄바꿈이 되든 안되든 그닥...기분상 줄바꿈 넣어줄 순 있음.
//         break;
//       }
//       builder.append(line).append("\n");      //미관상의 줄바꿈 추가...데이터 자체에는 차이 없어용.
//     }
     
     //위 루프문의 보다 깔끔하고...발전된 코드
     while((line = in.readLine())!= null) {  // 어제 한 코드 그대로죠~ 0이 null 로 바뀌었을뿐! 루프문 이해했으면 이제 이렇게 써줘욥
       builder.append(line).append("\n");
     }
    
     // 확인
     System.out.println(builder.toString());
     
     // 버퍼 입력 스트림 닫기
     in.close();
     
     // 자바는 서버에 있죠. 출력 스트림을 쓴다는 건 데이터를 사용자한테 내보내겠다는 것. 바이트스트림(그림, 동영상) 있고 문자출력스트림(텍스트)이 있음.
     // 하지만 서버는 출력스트림이 하나밖에 없음. byte출력스트림(output출력스트림) 밖에 지원하지 않음...서버는 기본이 바이트스트림...한글로 데이터 보낼 때 작살 날 확률이 올라감 ㅎ;
     // 그래서!!!!!! 이걸 바꿔주는 스트림이 있어요. output -> writer input -> reader로 바꿔주는 변환스트림을 써줘야함! 그리고 이걸 알아야 함^^ 
     // 이름 간단함 InputStreamReader ㅋㅋㅋㅋㅋㅋㅋ 이거 써주면 글자 안깨짐! 서버측에서는 input이 중요해서 위주로~
     /*InputStream에 포함된 문자를 안 깨지고 잘 받기
    1. InputStreamReader 를 사용한다.  //보통 이거 씁니다.
    2. DataInputStream 을 사용한다.
      */
     
   } catch (IOException e) {
    e.getStackTrace();
  }
   
 }
  
  public static void method3() { //InputStreamReader에 껴서 가져오는 방법.
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample3.html");
    
    //BufferedReader 선언
    BufferedReader in = null;
    
    try {
      
      // BufferedReader 생성
      // 바이트 입력 스트림(FileInputStream) -> 문자 입력 스트림(InputStreamReader) -> 버퍼 입력 스트림(BufferedReader)
      
      in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));  // 아하 이렇게...
      
      // 읽는 단위
      String line = null;
      
      // 읽은 데이터 모으기
      StringBuilder builder = new StringBuilder();
      
      // 읽기
      while ((line = in.readLine()) != null) {
        builder.append(line).append("\n");
      }
      
      // 확인
      System.out.println(builder.toString());
      
      // BufferedReader 닫기
      in.close();
      
      
      
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
 
 
  public static void main(String[] args) {
    
    method3();
    
  }

}
