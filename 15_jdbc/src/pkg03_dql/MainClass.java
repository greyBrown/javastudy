package pkg03_dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import oracle.jdbc.proxy.annotation.Pre;
/*java.sql.ResultSet
 * 1. SELECT 문의 실행 결과를 처리하는 인터페이스이다.
 * 2. SLELCT 문의 결과 행(Row)을 하나씩 조회하는 포인터 역할을 수행한다.
 * 3. 주요 메소드
 *   1) boolean next() : 결과 행(Row)이 있으면 해당 행(Row)을 선택하고 true 를 반환한다.
 *   2) int getInt(String columnLabel) : ResultSet 포인터가 선택한 결과 행(Row)의 칼럼 중 이름이 columnLabel 이고 타입이 int 인 값을 반환한다.
 *      int getInt(int columnIndex) : ResultSet 포인터가 선택한 결과 행(Row)의 칼럼 중 순번이 columnIndex 이고 타입이 int 인 값을 반환한다.
 */

//  ResultSet rs; select 결과를 조회할 때 사용하는  인터페이스로 행단위를 한줄씩 읽는다. rs.next(); -> 다음행으로 간다. 이 메소드를 쓰면 결과를 한줄씩 찾는다. 
//   메소드 한번 호출하면 결과의 첫번째줄, 두번 호출하면 두번째줄을 확인. 하나당 한행.
//  내용의 전체조회를 위해서는 행수만큼 사용해줘야함. 반환값은 true 와 false. true 는 행을 찾았음. false는 행이없음.
//  행수만큼 쓴다 -> 반복문돌린다. while(rs.next()){} -> 목록뽑기

//  만약 pk를 where 절로 찾을때(결과를 하나로 예상할 때) if(rs.next()){} 를 쓰면 된다. 결과 하나인데 반복문 돌릴 필요 없음. -> 상세조회
//  rs.get(name or number 로 데이터 지정 가능. 열이름이나 열넘버...)
//   Dto의 setter 를 호출해서 저 열이름을 한땀한땀 옮깁니다.

public class MainClass {
  
  
  public static void method1() { //어제 한 거에서 ResultSet을 추가해봅시다. 전체목록 조회
    
 
    Connection con = null;
    PreparedStatement ps  = null;
    ResultSet rs = null;
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      
      con = DriverManager.getConnection(url, user, password);
      
      String sql = "SELECT SAMPLE_NO, SAMPLE_CONTENT, SAMPLE_EDITOR, SAMPLE_DT FROM SAMPLE_T ORDER BY SAMPLE_NO DESC";
      
      ps = con.prepareStatement(sql);
      
     //여기서부터 다름!
     //SELECT 문의 실행 결과는 ResultSet 이 처리한다.
      rs = ps.executeQuery();
      
      
     // 결과를 저장할 List<SampleDto> 를 생성한다.
      List<SampleDto> samples = new ArrayList<SampleDto>();
      
     //SELECT 문의 실행 결과를 행 단위로 조회한다.
      while(rs.next()) {
        
     // rs 포인터가 조회한 행을 SampleDto 객체로 만든다.
      
      SampleDto sampleDto = new SampleDto(); 
      sampleDto.setSample_no(rs.getInt("SAMPLE_NO"));
      sampleDto.setSample_content(rs.getString("SAMPLE_CONTENT"));
      sampleDto.setSample_editor(rs.getString("SAMPLE_EDITOR"));
      sampleDto.setSample_dt(rs.getDate("SAMPLE_DT"));
      
     // samples 리스트에 sampleDto 객체를 저장한다.
      
      List<SampleDto> dto = Arrays.asList(new SampleDto());
      samples.add(sampleDto);
      
      // 결과확인
      for(int i=0, size = samples.size(); i<size; i++) {
         System.out.println(samples.toString());
      }
      
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(rs != null) rs.close();
        if(ps != null) ps.close();
        if(con != null) con.close();
        
      } catch (Exception e) {
      }
    }
  }
  
  public static void method2() { //전체목록조회가 아니라 하나 골라서 상세조회
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      con = DriverManager.getConnection(url, user, password);
      
      String sql = "SELECT SAMPLE_NO, SAMPLE_CONTENT, SAMPLE_EDITOR, SAMPLE_DT FROM SAMPLE_T WHERE SAMPLE_NO = ?";
      
      ps = con.prepareStatement(sql);
      
      // 변수 처리
      Scanner sc = new Scanner(System.in);
      System.out.println("조회할 SAMPLE_NO 입력하세요");
      int sampleNo = sc.nextInt();
      sc.close();
      
      ps.setInt(1, sampleNo);  // 쿼리문의 1번째 물음표에 sampleNo 를 전달한다.
      
      // 쿼리문 실행
      rs = ps.executeQuery();
     
     // 결과를 저장할 SampleDto 객체 선언
      SampleDto sampleDto = null;
      
      // 결과 조회
      
      if(rs.next()) { 
        
        // 결과 행을 sampleDto 객체로 만든다.
        sampleDto = new SampleDto();
        sampleDto.setSample_no(rs.getInt(1));
        sampleDto.setSample_content(rs.getString(2));
        sampleDto.setSample_editor(rs.getString(3));
        sampleDto.setSample_dt(rs.getDate(4));
        //결과 확인
        System.out.println(sampleDto);
      } else {System.out.println("조회할 수 없습니다."); }
      
      
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
      try {
        if(rs != null) {rs.close();}
        if(ps != null) ps.close();
        if(con != null) con.close();

      } catch (Exception e) {
          e.printStackTrace();
      }
    }
    // 오 됐다 원인은 뭐죠? 오타....^ㅜ
  }
  
  public static void method3() { 
    
    String sql = "SELECT COUNT(*) AS CNT FROM SAMPLE_T";
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      con = DriverManager.getConnection(url, user, password);
      
      ps = con.prepareStatement(sql);
     
      
      rs = ps.executeQuery();
      
     
      // 결과를 저장할 변수
      int cnt = 0;
      
      
      if(rs.next()) {
        cnt = rs.getInt("CNT");}

      System.out.println(cnt);
      
      
      
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
      
      try {
        
        if(rs != null) {rs.close();}
        if(ps != null) ps.close();
        if(con != null) con.close();
        
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    
    
    
    
  }
  
  
  public static void main(String[] args) {

    method3();
    
    
  }

}
