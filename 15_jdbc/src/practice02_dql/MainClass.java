package practice02_dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.proxy.annotation.Pre;
import pkg03_dql.SampleDto;

public class MainClass {

  /*
   * TALK_T 테이블의 TALK_NO의 내림차순으로 정렬한 뒤 11~30번째 행을 조회하여 List에 가져오시오.
   * dto 만들어서 List에 저장하세요.
   * 
   * DB 서버 환경
   * 192.168.0.214
   *  GD/1111
   * 
   */
  
  public static void method1() { // 오늘 블로그정리할거는 이걸로 정했다...
    
    
 
     Connection con = null;
     PreparedStatement ps = null;
     ResultSet rs = null;
    
     try {
       
       Class.forName("oracle.jdbc.OracleDriver");
       
       String url = System.getProperty("jdbc.url");
       String user = System.getProperty("jdbc.user");
       String password = System.getProperty("jdbc.password");
       
       con = DriverManager.getConnection(url, user, password);
       
       String sql = "SELECT TALK_NO, TALK_CONTENT, TALK_USER, WRITTEN_AT"
           + "  FROM (SELECT ROW_NUMBER() OVER(ORDER BY TALK_NO DESC) RN, TALK_NO, TALK_CONTENT, TALK_USER, WRITTEN_AT"
           + "          FROM TALK_T)"
           + " WHERE RN BETWEEN ? AND ?";
       
       //자꾸 TALK_NO 를 식별할 수 없다고 떠서 깃 긁어왔는데 된다...그럼 오타라는 건데...어디서...ㅠ....
       
       ps = con.prepareStatement(sql);
       
       int begin = 11;
       int end = 20;
       ps.setInt(1, begin);
       ps.setInt(2, end);
       rs = ps.executeQuery();
       
       List<TalkDto> talks = new ArrayList<TalkDto>();
       
       while(rs.next()) {
         TalkDto talkDto = new TalkDto();
         talkDto.setTalk_no(rs.getInt("TALK_NO"));
         talkDto.setTalk_content(rs.getString("TALK_CONTENT"));
         talkDto.setTalk_user(rs.getString("TALK_USER"));
         talkDto.setWritten_at(rs.getTimestamp("WRITTEN_AT"));

         talks.add(talkDto);}
         
        
       for(int i=0, size = talks.size(); i<size; i++) {
           System.out.println(talks.get(i));}
       
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
      
      try {
       if(rs != null) rs.close();
       if(ps != null) ps.close();
       if(con != null) con.close();
        
      } catch (Exception e) {
          e.printStackTrace();
      }
      
    }
     
     
     
    
    
  }
  
  
  public static void main(String[] args) {

    
      method1();
  }

}
