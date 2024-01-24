package practice02_text_copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileUtils {

  
  public static void fileCopy(File src, File dest) {
    
    
    //원본파일
    
    
    File srcfile = src;
    
    //복사할 파일
    File destfile = dest;
    
    
    
    //원본을 읽은 버퍼리더
    BufferedReader in = null;
    
    //복사를 출력할 버퍼라이터
    BufferedWriter out = null;
    
    try {
      
      //리더 스트림 생성
      in = new BufferedReader(new FileReader(srcfile));
      
      //라이터 스트림 생성
      out = new BufferedWriter(new FileWriter(destfile));
      
      //읽는 단위 생성
      String str = null;
      
      while((str = in.readLine())!= null) {
        out.write(str);
      }
      
      out.close();
      in.close();
      
      
    } catch (IOException e) {
          e.getStackTrace();
    }
    
  }
  
  
  public static void fileMove(File src, File dest) {
    fileCopy(src, dest);
    src.delete();
    //이거 실습은 조심히...그...그냥 폴더 하나 만들어서 하는게 나아요 자바 사혼의 구슬조각 만들지 말고 ㅠ
    
    
    
    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
