package practice01_bite_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileUtils {
  
  // 파일 복사 메소드
  
  
  public static void fileCopy(String src, String dest) { //src 원본위치 //des복사위치  //요렇게 작업해 두는걸 모듈화라고 해요~
    
 // 파일 복사 메소드
    
 // 원본 파일 객체
    File srcFile = new File(src);
    
 // 복사본 파일 객체
    File destFile = new File(dest);
    
 // 원본을 읽는 버퍼 입력 스트림 선언
    BufferedInputStream in = null;
    
 // 복사본 파일을 만드는 버퍼 출력 스트림 선언
    BufferedOutputStream out = null;
    
    try {
      // 원본을 읽는 버퍼 입력 스트림 생성
      in = new BufferedInputStream(new FileInputStream(srcFile));
      
      // 복사본을 만드는 버퍼 출력 스트림 생성
      out = new BufferedOutputStream(new FileOutputStream(destFile));
      
      // 원본을 5바이트씩 읽어온다.
      byte[] bytes = new byte[5];
      
      // 원본을 끝까지 읽는다. 읽은 내용을 복사본으로 보낸다.
      int readByte = 0;
      while((readByte = in.read(bytes)) != -1) {
        out.write(bytes, 0, readByte);       //첫 시도시 arraycopy의 readbyte가 해주는 일이 빠져서 바이트 크기가 달라짐. 그래서 디테일을 추가해줘야 함
      }
      
      //버퍼 출력 스트림 닫기 (분해는 조합의 역순...출력나중에 열었으니 출력 먼저 닫는다)
      out.close();
      
      //버퍼 입력 스트림 닫기  
      in.close();
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
  }
  
  
  public static void fileMove(String src, String dest) {
    
    // 파일 이동 메소드
    fileCopy(src, dest);                 // 메소드가 있으면...써먹어야죠!!
    new File(src).delete();
    
    
    
    
  }
  

}
