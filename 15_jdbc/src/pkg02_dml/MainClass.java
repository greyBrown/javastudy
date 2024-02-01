package pkg02_dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import oracle.net.aso.c;

public class MainClass {//pkg 01 02 모듈화는 없어요. 기존 코드 계속 쓸겁니다~ 모듈화는 좀따 배우고 적용해봐요.
  /*java.sql.PreparedStatement
   * 1. 쿼리문을 실행하는 역할을 가진다.
   * 2. PreparedStatement 객체 생성 이전에 쿼리문이 완성되어 있어야 한다.
   * 3. 미리 작성한 쿼리문에 변수 처리가 필요한 경우 "?"를 활용한다.
   * 4. PreparedStatement 객체는 Connection 객체가 생성한다.
   *     PreparedStatement ps = con.prepareStatement(쿼리문);
   * 
   * +Statement 도 있지만 Prepared 씁니다. Statement 보안상 문제 가능성이 있음... 
   */
  
  
  public static void method1() {
    
    // Connection, PreparedStatement 객체 선언
    Connection con = null;
    PreparedStatement ps = null;
    
    try {
      
      // oracle.jdbc.OracleDriver 클래스 로드
       Class.forName("oracle.jdbc.OracleDriver");
       
       // 데이터베이스 접속 정보
       String url = System.getProperty("jdbc.url");
       String user = System.getProperty("jdbc.user");
       String password = System.getProperty("jdbc.password");        //접속정보 없으면 객체 생성 안되욥
       
       //connection 객체 생성
       con = DriverManager.getConnection(url, user, password);
       
       //쿼리문(미리 만들어두란게 아래처럼 작성해놓으란 뜻임!)
       String sql = "INSERT INTO SAMPLE_T(SAMPLE_NO, SAMPLE_CONTENT, SAMPLE_EDITOR, SAMPLE_DT) VALUES(SAMPLE_SEQ.NEXTVAL, '콘텐츠', '에디터', CURRENT_DATE)";
       //쿼리문 마지막에세미콜론 안붙임!!!!! 
       
       // PreparedStatement 객체 생성
       ps = con.prepareStatement(sql);
      
       // 쿼리문 실행. 삽입된 행의 개수가 반화됨.
       int result = ps.executeUpdate();
       System.out.println(result + "행 이(가) 삽입되었습니다.");
      
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
     //Connection, PreparedStetement 객체 닫기(반환)
      try {
       if(con != null) con.close();
       if(ps != null) ps.close();
    } catch (Exception e) {
          e.printStackTrace();
    }
   }
    
  }
  
  public static void method2() { //이게 공부해야할 버전! method1이 아니에요. 변수 들어가는 버전!
    
    Connection con = null;
    PreparedStatement ps = null;
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      con = DriverManager.getConnection(url, user, password);
      
      
      String sql = "INSERT INTO SAMPLE_T(SAMPLE_NO, SAMPLE_CONTENT, SAMPLE_EDITOR, SAMPLE_DT) VALUES(SAMPLE_SEQ.NEXTVAL, ?, ?, CURRENT_DATE)"; 
      // 미리 쿼리문을 만들 때 변수처리할 부분이 있으면 ?
      // 쿼리문에서 변수 처리할 부분은 ?로 처리한다.
      
      ps = con.prepareStatement(sql);
      
      // 변수 입력 받기
      Scanner sc = new Scanner(System.in);
      System.out.println("내용 입력하세요 >>>");
      String content = sc.next();
      System.out.println("편집자 입력하세요 >>>");
      String editor = sc.next();
      sc.close();
      
      // 변수를 쿼리문에 전달하기(실행전에 변수처리가 되어야 합니다. 쿼리문을 미리 준비해야 하니까!)
      ps.setString(1, content);   //쿼리문의 1번째 물음표에 String content 전달하기
      ps.setString(2, editor);    //쿼리문의 2번째 물음표에 String editor  전달하기
      
      int result = ps.executeUpdate();
      System.out.println(result + "행 이(가) 삽입되었습니다.");
      
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
      try { //ps con 닫는 순서는 상관없지만 조립은 분해의 역순이니까 그것대로 해주기...
        if(ps != null)
          ps.close();
        if(con != null)
        con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    // DB 프레임워크가 많은 자동기능을 지원해서 이렇게 코드를 쓸 필요는 없는 경우도 있지만, 이 코드들은 프로그램 버전을 따지지 않고 프레임워크가 안되도 돌아감.
    // 이런거 잘 알아둬용. IO..네트워크 입출력...웹이랑 데이터 주고받는거 웹개발에 중요!
    // method2번이 공부해야할 버전이에요! insert 는 ? 처리하지(사용자 입력) 아닌 경우는 없다시피합니다.
    // 오늘 목표도 IO와 같음..ㅎ...메소드 2번 안보고 다 쓸 수 있으면 된다! 안보고 처음부터 끝까지 쓴다 이러면 오늘 굿굿.
    // 외운다는 좀 막연한 목표니까 간식먹으면서 5번정도 따라치고 얼마까지 외웠나 체크하면서 해보기...간식먹기...
    // 상담끝나고 복습정리하고 이거 다 외워보기...~~
    // 설날 전날까지 HTML, css 마무리 목표 설 이후에 자바스크립 시작하는게 목표 내일 jdbc 끝난다고 보면 됩니다.
  }

  public static void method3() {
    
    Connection con = null;
    PreparedStatement ps = null;
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      con = DriverManager.getConnection(url, user, password);
      
      String sql = "UPDATE SAMPLE_T SET SAMPLE_EDITOR = SAMPLE_EDITOR || 2, SAMPLE_DT = CURRENT_DATE  WHERE SAMPLE_NO = ?";   /// 오라클 ||연산자! 기존의 컨텐츠 뒤에 2를 붙이겠다. WHERE 절이 없으므로 모든 데이터에 반영됨.
      ps = con.prepareStatement(sql);
      // 기존 변경사항 + SAMPLE_DT = CURRENT_DATE 작성으로 수정한 날짜를 추가로 삽입함.
      
      // 수정할 SAMPLE_NO 입력
      Scanner sc = new Scanner(System.in);
      System.out.println("수정할 SAMPLE_NO 입력하세요 >>>");
      int sampleNO = sc.nextInt();
      sc.close();
      
      // 입력값을 쿼리문에 전달
      ps.setInt(1, sampleNO);    //쿼리문의 1번째 물음표에 sampleNo 전달하기
      
      int result = ps.executeUpdate();
      System.out.println(result + "행 이(가) 수정되었습니다.");
      
      
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
      try {
        if (ps != null) ps.close();
        if(con != null) con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }
  
 public static void method4() {
    
    Connection con = null;
    PreparedStatement ps = null;
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      con = DriverManager.getConnection(url, user, password);
      
      String sql = "DELETE FROM SAMPLE_T WHERE SAMPLE_NO = ?";
      
      ps = con.prepareStatement(sql);
      
      Scanner sc = new Scanner(System.in);
      System.out.println("삭제할 SAMPLE_NO 입력하세요 >>>");
      int sampleNo = sc.nextInt();
      sc.close();
      
      ps.setInt(1, sampleNo);
      
      int result = ps.executeUpdate();
      System.out.println(result + " 행 이(가) 삭제되었습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(ps != null)  ps.close();
        if(con != null) con.close();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    
  }
  public static void main(String[] args) {

    method3();
    
    
  }

}
