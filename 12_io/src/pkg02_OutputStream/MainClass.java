package pkg02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class MainClass {
  /*
   * java.io.FileOutputStream
   * 1. 바이트 기반의 파일 출력 스트림이다. (=바이트 데이터를 파일로 보낸다)
   * 2. 출력 단위 
   *    1) int             (하나만 내보낼 때 int 를 사용) 
   *    2) byte[]          (여러개를 내보낼 때 byte 배열을 사용)
   */
  
  /*
   * java.io.BufferedOutputStream
   * 1. 버퍼링을 지원하는 바이트 출력 스트림이다.
   * 2. 보조 스트림으로 메인 스트림과 함께 사용해야 한다.
   * 3. 버퍼링을 지원하므로 출력 속도가 향상된다.
   * 
   * + 버퍼를 끼워서 속도가 빠름...필수적으로 써야할 때도 있음.
   * 
   * java.io.DataOutputStream
   * 1. 자바 변수 값을 출력하는 바이트 출력 스트림이다.
   * 2. 보조 스트림으로 메인 스트림과 함께 사용해야 한다.
   * 3. 타입 별로 전용 메소드가 존재한다.
   * 
   * java.io.ObjectOutputStream
   * 1. 객체를 출력하는 바이트 출력 스트림
   * 2. 보조 스트림으로 메인 스트림과 함께 사용해야 한다.
   * 3. 객체를 출력 스트림으로 전송하기 위해서는 직렬화 과정이 필요하다. (=객체를 byte[] 로 바꾸는걸 직렬화라고 함)
   * 4. 직렬화 방법
   *    1) 직렬화할 클래스는 java.io.Serializable 인터페이스를 구현
   *    2) long serialVersionUID 필드 값을 임의로 생성한다.
   *    
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
    //추가모드에서 크기가 계속 쌓임을 알 수있음 32byte 64byte...로그파일들이 이렇게 추가하는 식으로 만들어요. 내용이 계속 추가되니까!
   }

  public static void method3() { //버퍼버전. 이거 단한줄도 안보고 다 작성할 수 있으면...그정도면 오늘목표로 만족스럽다...중요하니까요! 
    
     
    
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "sample3.dat");
    
    //버퍼 출력 스트림 선언
    BufferedOutputStream out = null;
    
    try {
      //버퍼 출력 스트림 생성(기존 코드에서 이것만 추가되었다고 생각하면 됩니다!) -> 간단하니까 안할이유가 딱히 없음. 그래서 거의 디폴트...
      out = new BufferedOutputStream(new FileOutputStream(file));
      
      String str1 = "finally 처리 안해도 보통 따악히 큰 문제는 없어요.\n";
      String str2 = "I'm fine thank you";
      
      
      out.write(str1.getBytes());       //위에서는 풀어 썼지만 그냥 이렇게 메서드체이닝처럼 씁니다.
      out.write(str2.getBytes());
      
      out.close();
      
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
      
    } catch (Exception e) {
      e.getStackTrace();
      
    }
  }
  
  public static void method4() {
    
    File dir = new File("\\storage");
    
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "sample4.dat");
    
    // 데이터 출력 스트림 선언
    DataOutputStream out = null;
    
    try {
      
      //데이터 출력 스트림 생성
      out = new DataOutputStream(new FileOutputStream(file));
      
      //출력할 데이터(이거 나중에 읽어올때도 같은 순서로 읽어와요. String int 순서이니까 읽을때도 이렇게!)
      String name = "홍길동";
      int age = 10;
      //double height = 140.5;
      //boolean isAdult = (age >= 20);
      //char gender = '남';
      
      // 출력
      out.writeUTF(name);
      //out.write(age);
      //out.writeDouble(height);
      //out.writeBoolean(isAdult);
      //out.writeChar(gender);     //int(4byte)가 남(2byte)보다 커서 자동형변환이 됩니당.
      
      out.close();
      
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
      
      
    } catch (Exception e) {
        e.getStackTrace();
    }
    
    
  }
  
  public static void method5() {
    
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "sample5.dat");
    
    //객체 출력 스트림 선언
    ObjectOutputStream out = null;
    
    try {
      
      //객체 출력 스트림 생성
      out = new ObjectOutputStream(new FileOutputStream(file));
      
      //출력할 객체
      Employee employee = new Employee(1, "홍길동");
      List<Employee> employees = Arrays.asList(new Employee(2, "홍길순"), new Employee(3, "홍순자"));
      
      //객체 출력
      out.writeObject(employee);
      out.writeObject(employees);
      
      //객체 출력 스트림 닫기
      out.close();
      
      //확인
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
      
      
    } catch (Exception e) {

          e.printStackTrace();
    }
    
    
    
    
  }
  
  
  public static void main(String[] args) {

    
    method4();
    
  }

  public static void practice1() {
    
    //FileOutputStream으로 애국가 1절 파일로 보내기 : 시간 재기
   
    long start = System.nanoTime();
    
    File dir = new File("\\storage");
    if(dir.exists() == false) {
      dir.mkdirs();}
   
    
    File file = new File(dir, "song1.txt");
    FileOutputStream out = null;
    
    try {
      
      out = new FileOutputStream(file);
      String song = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 무궁화 삼천리 화려강산 우리 강산 우리 마음으로 길이 보존하세";
      out.write(song.getBytes());
      
      out.close();
      
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
      
      
    } catch (Exception e) {

    e.getStackTrace();
    
    }
    
    long end = System.nanoTime();
    
    System.out.println(end - start + "초 걸렸습니다.");
    
  }
  
  
  public static void practice2() {
    
    //BufferedOutputStream 으로 애국가 1절 파일로 보내기 : 시간 재기
    
    long start = System.nanoTime();
    
    File dir = new File("\\storage");
    
    if(dir.exists() == false) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "song2.txt");
    BufferedOutputStream out = null;
    
    try {
      
      out = new BufferedOutputStream(new FileOutputStream(file));
      String str1 = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 무궁화 삼천리 화려강산 우리 강산 우리 마음으로 길이 보존하세";
      
      out.write(str1.getBytes());
      
      out.close();
      
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
      
      
      long end = System.nanoTime();
      
      System.out.println(end - start + "초 걸렸습니다.");
      
      
    } catch (Exception e) {
        e.getStackTrace();
    }
    
    
  }
  
  
}
