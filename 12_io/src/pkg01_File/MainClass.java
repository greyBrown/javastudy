package pkg01_File;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class MainClass {
//out 에 비해 in 이 더 어렵지만...out 을 잘 알아야 in 도 잘 됩니다. 중요한 파트에요!
  
  
  /*
   * java.io.File
   * 1. 디렉터리, 파일을 관리하는 클래스이다.
   * 2. 디렉터리, 파일을 만들고 삭제할 수 있다.
   * 3. 디렉터리, 파일의 정보(이름, 경로, 크기, 최종수정일 등)를 확인할 수 있다.
   */
  
  /*
   * 경로 작성 방법
   * 1. 경로 구분자 (separator)
   *  1) 윈도우       : 역슬래시(\\ 이스케이프시퀀스 처리)
   *  2) 리눅스, Mac  : 슬래시(/)
   *  3) File.separator 필드를 사용하면 플랫폼에 따른 경로 구분자가 자동 삽입된다. (코드가 너무 길어짐...약간 비추)
   *  + 사실 요새 윈도우는 슬래시(/)도 지원이 됩니다 ㅎ 그냥 / 해도 돼요. 
   *    애초에 리눅시 기반 서버가 많으니까 그냥 /해도...뭐....지금은 이제 막 배우니까 이론 지켜서 해봅시당
   *
   * 2. 디렉터리
   *  1) 루트 : 경로 구분자로 시작하는 경로는 루트에서 시작하는 경로(생략가능)   //최상위 디렉터리
   *  2) 상위 : ..
   *  3) 현재 : .
   */
  
  public static void method1() {
    
    //디렉터리(폴더) 만들기/삭제하기
    
    // File 객체 선언
    File dir; 
    
    // File 객체 생성 //parent:dir<-> child:file
    dir = new File("\\storage");   //맨앞에 c: 는 생략가능. 루트는 생략가능 하니까!
    
    // 디렉터리 유무에 따른 생성 및 삭제(그냥 통으로 외우는 거 권장. 완전 필수!)
    if(!dir.exists()) { //디렉터리가 없으면 (방법 1. ! 연산자 방법2. ==false 첫번째 좀 지양됨...그렇지...잘 안보이겠지..그래도 연습으로 해봐요)
      dir.mkdirs();  //항상 s로 씁시다. 하나짜리냐 두개짜리냐 문제지만 mkdirs 쓰면 알아서 잘 만들어 준다
      //->만약 디렉터리가 없다면, 생성하겠다.
    
    } else {                         //디렉터리가 있으면
      //dir.deleteOnExit();          //JVM 실행이 종료된 후 삭제
      dir.delete();                  //JVM 실행 중에 삭제 (보통 이거 쓰는게 일반적. 서비스종료될때 삭제할거 아니면...)
    // -> 만약 디렉터리가 있다면, 삭제하겠다.
    } //-> if 디렉터리 없으면 생성하고 else 있으면 삭제한다.
      
      
    //오 생겼다! c: 바로 하위에 만들어진 것을 확인할 수 있다.
    //오 없어졌다!
  }
  
  public static void method2(){
    
    // 파일 만들기/삭제하기     <- 폴더만들기(method1)이 선행된 후 이뤄짐. 디렉토리 따로 고정해주는게 아니라 method1 코드 그대로 쓰는건 추천...
    
    // 파일이 저장될 디렉터리 작업
    File dir = new File("\\storage");        
    if (!dir.exists()) {
      dir.mkdirs();
    } 
      
    // 파일을 File 객체로 생성
    File file = new File(dir, "sample.txt");
    
    // 파일 유무에 따른 생성/삭제
    if(file.exists()) {                        //파일이 있으면
      file.delete();                           //삭제하겠다.
      } else {
        try {
          file.createNewFile();              //처음 코드 넣으면 안된다. 왜? checked Exception(IOException) 인데 예외처리를 안했으니까!
        } catch (Exception e) {              //이렇게 IOException 은 예외처리가 반드시 필요함.
          e.printStackTrace();
        }
      }
  }
  
  public static void method3() {  //이런거 찍어내는거 많이 연습해보는거 추천해요~
    /*
     * File 클래스 주요 메소드
     * 1. listFiles()    : 디렉터리 내의 모든 File 객체를 File[] 배열로 반환
     * 2. getName()      : 이름반환
     * 3. getParent()    : 저장된 디렉터리 반환
     * 4. getPath()      : getParent() + getName()
     * 5. lastModified() : 최종수정일을 long 타입으로 반환 -> timeStamp 값을 반환한다는 뜻
     * 6. length()       : 파일 크기를 long 타입으로 반환 (바이트 단위)
     * 7. isDirectory()  : 디렉터리이면 true 반환.(아니면 false)
     * 8. isFile()       : 파일이면 true 반환.
     */
    
    //JAVA_HOME 을 File 객체로 생성
    File javaHome = new File("\\Program Files\\Java\\jdk-17");
    
    //JAVA_HOME 에 있는 모든 디렉터리와 파일을 File 객체로 가져오기
    File[] files = javaHome.listFiles();
    
    //하나씩 확인
    for(File file : files) {
      
      StringBuilder builder = new StringBuilder();
      
      // 이름
      builder.append(String.format("%-20s", file.getName().substring(0, Math.min(file.getName().length(), 20)))); //만약 이름이 20자리 넘어간다면 20과 파일이름 둘 중 작은걸로 쓰겠다.
      
      // 최종수정일
      String lastModified = new SimpleDateFormat("yyyy-MM-dd a h:mm").format(file.lastModified());
      builder.append(String.format("%-20s", lastModified));   //위에서 20자리 폭으로 맞춰줬으니까 여기도~
      
      // 유형
      builder.append(String.format("%-10s", file.isDirectory() ? "파일 폴더" : "파일"));
      
      // 크기
      long byteSize = file.isDirectory() ? 0 : file.length();    //디렉토리는 파일크기가 0임
      long kbSize = (byteSize / 1024) + (byteSize % 1024 !=0 ? 1 :0);
      if(byteSize !=0)
         builder.append(String.format("%10s", new DecimalFormat("#,##0").format(kbSize)+"KB"));
      

      //출력 <- 스트링빌더 쓸 때 toString 등으로 문자열로 바꾸는거 꼭 기억하기~
      System.out.println(builder.toString());
    }
    
  }
  
  
  public static void main(String[] args) {

   
    method3();
    
    
  }

}
