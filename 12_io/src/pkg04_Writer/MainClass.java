package pkg04_Writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainClass { //write 를 기반으로 만들어짐. 편하게 쓰라고....

  /*
   *  java.io.FileWriter
   *  1. 문자 기반의 파일 출력 스트림이다.
   *  2. 출력 단위
   *     1) int       (한 글자를 주고받음)
   *     2) char[]    (여러 글자를 주고받음)
   *     3) String    (여러 글자를 주고받음)
   * 
   * java.io.BuffereWriter
   * 1. 버퍼링을 지원하는 문자 출력 스트림이다.
   * 2. 보조 스트림으로 메인 스트림과 함께 사용해야 한다.
   * 3. 버퍼링을 지원하므로 출력 속도가 향상된다.
   * 4. 줄 바꿈을 위한 newLine() 메소드가 있다. (LF/CRLF 플랫폼 종속 문제가 좀 있는데...내가 알아서 해주겠다는 그런 좋은 메소드~)
   * 
   * java.io.PrintWriter
   * 1. print 메소드(print, println, printf)를 지원하는 문자 출력 스트림이다.  <- 주고받는 내용이 많이 없어 Buffer를 안써도 될 때 이게 더 나을 수 있어요! newline 일일이 안넣어줘도 되고...
   * 2. 메인 스트림 또는 보조 스트림으로 사용할 수 있다.
   */
  
  public static void method1() {
    
    File dir = new File("\\storage");
     if(!dir.exists()) {
       dir.mkdirs();
     }
     
     File file = new File(dir, "sample1.txt");
     
     // 파일 출력 스트림 선언
     FileWriter out = null;
     
     try {
       
       // 파일 출력 스트림 생성
       out = new FileWriter(file);
       
       // 출력할 데이터
       int ch = '대';
       char[] chArr = {'한', '민'};
       String str = "국";
       
       // 출력
       out.write(ch);
       out.write(chArr);
       out.write(str);
       
       // 파일 출력 스트림 닫기
       out.close();
       
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static void method2() {
    
    File dir = new File("\\storage");
    if(!dir.exists());{
    dir.mkdirs();}
    
    File file = new File(dir, "sample2.txt");
    
    // 버퍼 출력  스트림 선언
    BufferedWriter out = null;
    
    try {
      
      // 버퍼 출력 스트림 생성, 추가모드(파일이 있으면 내용만 추가한다. 없으면 새로 만든다!) 
      out = new BufferedWriter(new FileWriter(file, true));   //FileWriter 에서 true 값 주면 추가 생성모드! 컨스컨스~~
      //혹시 메소드 밖으로 꺼내셔 변수 하나 더 생기면 그 변수는 닫지 않아요.(보조스트림 쓸 때 보조스트림만 닫음. 연결된 메인스트림이 알아서 닫힘.) 분리를..안하면 되는 문제!
      //그냥 메소드안에 메소드넣으면 간단해지는 문제...
      
      //안녕하세요
      //반갑습니다
      
      out.write("안녕하세요");
      out.newLine(); // 줄 바꿔주는 전용 메소드!
      out.write("반갑습니다");
      out.newLine();
      out.write("날씨가 춥네요");
      out.newLine();
      out.write("건강 유의하세요");
      out.newLine();
      out.write("추가잘되나확인~~"); //잘됐네용!
      out.newLine();
      
      //버퍼 출력 스트림 닫기
      out.close();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static void method3() {
    
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "sample3.html");   //txt를 html 로 바꾸면 웹창에서 안녕 뜨는거 볼 수 있어요
    
    // PrintWriter 선언
   PrintWriter out = null;
   
   try {
    
     // PrintWriter 생성
     out = new PrintWriter(file); //다양한 생성을 지원하는 것을 볼 수 있음.
     
     // 출력
    // out.println("안녕하세요");
    // out.println("반갑습니다");
     out.println("<script>");        ///이런식으로 찍어서 서버로 보내서 메시지를 찍는 그런거예요. 예를 들어봤습니다. 서버에서 쓰는게 자바이기 때문에 자바 배우는 거죱. 사용자측 언어는 자스.
     out.println("alert('안녕');");
     out.println("</script>");
     
     // PrintWriter 닫기 (이거 제대로 안닫으면 또 뭐시기뭐시기 그거 뜬다...)
     out.close();
     
  } catch (IOException e) {
    e.printStackTrace();
  }
  }
  
  
  public static void main(String[] args) {

    
    method3();
    
    
    
    
    
    
  }

}
