package pkg01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

public class MainClass {

  
  /*
   * method1
   * oracle.jdbc.OracleDriver
   * 1. 오라클 데이터베이스에 접속하기 위해서 필요한 드라이버 클래스이다.
   * 2. 오라클에서 만들어서 배포한다.                                        //모든 DB에 접속을 위해서는 드라이버 클래스가 필요한데, 모든 드라이버 클래스는 DB vendor(회사측)에서 제공한다. -> 사용하는 DB에 따라 다 다름. 드라이버 클래스 준비가 첫시작.
   * 3. 18c XE 버전의 경우 C:\app\GD\product\18.0.0\dbhomeXE\jdbc\lib 파일을 프로젝트의 build path 에 등록해야 한다.       ( + 오라클 홈 jdbc lib(라이브러리) 폴더에  각종 jar 파일들이 모여있음.) 
   *     (3rd party library는 build path에 추가해서 사용한다. openapi 할 때 한 그것임) configure buildpath 로 등록했음~
   *     (oracle.jdbc 패키지에 있는 oracelDriver.class 를 씀! 아래 jdbc.driver 여기에는 똑같은 클래스 있는데 그냥 같은거 두개가 있는건가 싶음...앞에걸로 쓸게요~)
   */
  
  /*method2
   * java.sql.Connection
   * 1. 데이터베이스 접속 객체를 생성하는 인터페이스이다.
   * 2. java.sql.DriverManager 클래스가 데이터베이스 접속 객체를 생성한다. (생성을 이 클래스가 한다. 접속은 Connection 인터페이스가. 나눠서 함)
   * 3. 형식
   *    Connection con = DriverManager.getConnection();
   */
  
  /*method3
   * 프로퍼티(Property, 속성)
   * 1. 운영체제의 정보나 자바 실행 정보 등을 가지고 있는 값이다.
   * 2. 사용자가 프로퍼티를 추가해서 사용할 수 있다.
   * 3. 프로퍼티 추가 방법
   *   1) [Run] - [Run Configurations] - [Arguments] - [VM arguments]
   *   2) 프로퍼티 앞에 prefix 값으로 -D 를 사용한다.
   *   //실행은 되야함. 하지만 코드는 남아있으면 안됨 -> 인자값으로 넘김. 보안상 중요상 것들은 이렇게 올린다.. method2번은 좋은 방법이 아님!
   * 4. github.com 에 올릴 수 없는 민감 정보를 처리하는 용도로 사용한다.     (*.properties 파일로 빼는 방법도 있지만 나중에 깃 통해서 배포하고 내려받을때 실행이 안되는 문제가 있어서 배제. vm argument 방식으로 할게요)
   * 5. 프로퍼티로 등록한 값은 System.getProperty() 메소드를 이용해서 가져온다.
   * 
   */

  public static void method1() {
    
    // oracle.jdbc.OracleDiver 클래스 로드하기(메모리에 올리기)
    
    try {
      Class.forName("oracle.jdbc.OracleDriver"); //예외처리를 해줘야함. ClssNotFoundException. 그 클래스 없으면 어쩔건데?!?
      System.out.println("oracle.jdbc.OracleDriver 클래스가 메모리에 로드되었습니다.");
    } catch (Exception e) {
      System.out.println("오타든 3rd party 삽입을 안했든 둘 중 하나");
    } //오타였다 쏴리;
  }

  public static void method2() {
    //k270
    
    //접속을 위해서 필요한 정보(주소, 계정정보)
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "GD";
    String password = "1111";
    
   //+oracle xe 버전은 개발을 위해 사용하는 light 버전.(상용버전보다 얇다고 표현한다.) 나중에 @뒤 주소가 바뀔 수 있음. DB가 다른 컴퓨터로 가거나...저 @뒤의 주소가 달라지는 것임.
    //127.0.0.1(local host 대신 적기도 하는 ip주소. localhost 라는 뜻임)
    
    // Connection 객체 선언
    Connection con = null;   //생성은 아래에서 예외처리(sqlException)
    
    try {
    // Connection 객체 생성
      con = DriverManager.getConnection(url, user, password);     //상기한 것처럼 선언과 생성 담당이 다름.
      System.out.println("데이터베이스에 접속되었습니다.");
      
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {                     //안전한 DB 접속 종료를 위해 finally 처리
      //Connection 객체 닫기. 
      try {
         if( con !=null)             
        con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    }
  
  public static void method3() {
    
    Properties props = System.getProperties();                 //등록된 모든 property 가져오기
    
    Enumeration enumeration = props.propertyNames();
    
    while(enumeration.hasMoreElements()) {
     String property = (String) enumeration.nextElement();
     System.out.println(property + "=" + props.getProperty(property));  //등록된 property 들의 이름과 값이 출력
    }
    
    // 다음시간에 추가해서 가져다 쓰는 방법 합시다. 
    
    // 서버에 등록해서 배포할 때 프로퍼티가 중요하게 쓰임. 코드의 공개없이 민감정보를 처리함. 이 개념을 이해하기~
    // 깃허브에 정보 잘못올리면 스팸이 어우 말도못해요.
  }
  
  public static void method4() {
    
    // 사용자 프로퍼티 등록(jdbc.url, jdbc.user, jdbc.password
    // -Djdbc.url=jdbc:oracle:thin:@localhost:1521:xe
    // -Djdbc.user=GD
    // -Djdbc.password=1111
    //공백 안들어가게 조심해요!! 등호 앞뒤 주의 ㅋㅋㅋㅋ 그리고 등록시에는 -D 앞에 붙여주기(등록시에만!)
    //Run configuration argument 에 가장 최근 실행한 메인(높은번호)에 위에 적은거 등록! 실행해보면 출력문에 내가 등록한(jdbc.ㅕ기~~) 프로퍼티 들이 뜬다.
    
    //데이터베이스 접속 정보(사용자 프로퍼티 가져오기)
    String url = System.getProperty("jdbc.url");
    String user = System.getProperty("jdbc.user");
    String password = System.getProperty("jdbc.password");
    
    Connection con = null;
    
    try {
      
      con = DriverManager.getConnection(url, user, password);
      System.out.println("데이터베이스에 접속되었습니다.");
      
      
    } catch (Exception e) {
          e.printStackTrace();
    } finally {
      try {
        if(con != null) con.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
    
    
    // 이제 깃에 올려도 되는 상태! 프로퍼티에 내가 등록한 비밀번호 등등이 들어가서 그걸 con으로 불러와서 쓰니까 코드로 남기지 않아도 실행된다.
    // getConnction 은 쿼리 하나 끝나면 닫아야함. 모듈화가 중요한 이유. 쿼리 하나가 끝날때마다 close 됨. db.dao pkg로 만들어서 수업
  }
  
  public static void main(String[] args) {
    method4();
    
  }

}
