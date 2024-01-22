package pkg02_OutputStream;

import java.io.File;
import java.io.FileOutputStream;

public class MainClass {
  /*
   * java.io.FileOutputStream
   * 1. 바이트 기반의 파일 출력 스트림이다. (=바이트 데이터를 파일로 보낸다)
   * 2. 출력 단위 
   *    1) int             (하나만 내보낼 때 int 를 사용) 
   *    2) byte[]          (여러개를 내보낼 때 byte 배열을 사용)
   */
  
  public static void method1() {
    
    // 무조건 생성 모드 : 기존에 파일이 있으면 지우고 다시 만든다.
    
    // 디렉터리
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    // 파일
    File file = new File(dir, "sample1.dat");
    
    // 파일 출력 스트림 선언
    FileOutputStream out = null;
    
    try {
      // 파일 출력 스트림 생성(무조건 생성 모드) <-기존에 파일 있으면 덮어써버림! 무조건 만들어
      out = new FileOutputStream(file);
      
      // 출력할 데이터
      int c = 'A';           //(영어 하나쓰면 1byte에 딱이에요...^-^)
      String str = "pple";
      byte[] b = str.getBytes();
      
      // 출력
      out.write(c);
      out.write(b);
      
      // 플러싱(선택) <- 혹시 스트림에 남아있는 데이터가 있으면 내보내는 것. 선택작업인 이유는 스트림 닫기 할때...알아서? 잘 되는 거 아닐까
      out.flush();
      
      
      // 확인 (전반에 걸쳐 파일객체를 스트림과 함께 쓰는 걸 권장. 파일에 유용한 메서드가 많음)
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
      
    } catch (Exception e) {
        e.printStackTrace();
    
    } finally{ 
      try {
        // 파일 출력 스트림 닫기(종료)
        if(out != null)             //out 이 null(초기화상태) 인 경우로 여기까지 오는경우 널값참조오류가 뜨는 것을 방지.
        out.close();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
      
    }
     
      // 출력 도중 문제가 생기면 그대로 try - catch 로 오게되면서 close 를 안하고 예외출력문으로 오는 문제가 생김.
      // 그래서 close 위치를 바꿀게요~~ 어디에? try - catch 의 선택구문인 final(항상 실행됨)에!
      // 하지만 오류가 나죠 왜? try 밖으로 나오면서 예외처리(try 블록 내에서만 가능)가 불가능한 영역으로 나와버렸기 때문에.
      // 그래서 finally 에서 try - catch 를 한번 더 해주게 됨...
      // 그냥 try 문 마지막에 두는 경우도 많아요. 이렇게해서 IO 오류 잘 안나기 때문에...
  }
  
  public static void method2() {
    
    //추가 모드 : 기존에 파일이 없으면 새로 만들고 있으면 내용만 추가한다.
    
    //안녕하세요 반갑습니다 -> sample2.dat 파일로 보내기
    
 // 디렉터리
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    // 파일
    File file = new File(dir, "sample2.dat");
    
    // 파일 출력 스트림 선언
    FileOutputStream out = null;
    
    try {
      // 파일 출력 스트림 생성(추가 모드)
      out = new FileOutputStream(file, true);
      
      // 출력할 데이터
      String str = "안녕하세요 반갑습니다\n";
      byte[] b = str.getBytes();
      
      // 출력
      out.write(b);
      
      // 플러싱(선택)
      out.flush();
      
      
      // 확인
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
      
    } catch (Exception e) {
        e.printStackTrace();
    
    } finally{ 
      try {
        // 파일 출력 스트림 닫기(종료)
        if(out != null)             
        out.close();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
   }

     //추가모드에서 크기가 계속 쌓임을 알 수있음 32byte 64byte...로그파일들이 이렇게 추가하는 식으로 만들어요. 내용이 계속 추가되니까!
  
  public static void main(String[] args) {

    method2();
    
  }

}
