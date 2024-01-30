package db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.dto.UserDto;
import pkg03_dql.SampleDto;
import practice02_dql.TalkDto;

public class UserDao { //이런식으로 모듈화를 합니다! private 을 하는 이유 : 외부에서는 안 쓸 것이다.
                       // 그때 안했던 모듈화 지금 한다. 앞서 배운 DML DQL 5가지 쿼리문을 모듈화함. (UPDATE INSERT DELETE SELECT(상세조회) SELECT(전체조회))
  
  /* DAO
   * 1. Database Access Object
   * 2. 데이터베이스에 접근해서 쿼리문을 실행하고 쿼리문의 실행 결과를 받는 객체이다.
   * 3. 하나의 객체만 만들어서 사용하는 Singleton pattern 으로 DAO 객체를 생성한다.
   */
  /*
   * Singleton pattern
   * 1. 오직 하나의 객체만 만들어서 사용하는 패턴이다.
   * 2. 클래스 내부에서 객체를 미리 만든 뒤 해당 객체를 가져다 사용할 수 있도록 메소드를 제공한다.
   * 3. 클래스 외부에서는 객체를 생성할 수 없도록 생성자를 private 처리한다. 
   * + static 으로 구현합니다. 객체생성을 private 처리하였기 때문에 클래스로 메소드호출해야함.
   */ // DAO는 싱글톤 처리한다. 이 개념은 알고 있어야함~ 싱글톤처리 하는 이유 -> 일을 한명씩 해야한다...INSERT 중인데 SELECT 하면 이게 삽입이 된거야 만거야...이런 이유들 때문.
  
 /* 다른데 적어놨지만 다시 적어보는 DTO... DAO DTO 개념 알아놔용.
 * DTO
 * 1. Data Transfer Object
 * 2. 데이터베이스의 데이터를 자바와 주고 받을 때 사용하는 객체이다.
 * 3. 기본적으로 테이블 하나당 DTO 하나를 만든다.
 * 4. 필드는 칼럼에 매칭하고 생성자와 Getter/Setter 를 만든다.  <- "lombok" 외부 라이브러리가 수행.
 */
 
  //singleton pattern
  private  UserDao() {}
  private static UserDao userDao = new UserDao();                    //1
  public static UserDao getInstance() {                              //2  => 1, 2 둘다 static 처리해줘야 한다. 클래스 멤버는 클래스 멤버만 호출할 수 있으니까!
    return userDao;
  }
  
  //field
  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
  
  //private 메소드 (UserDao 내부에서 호출 메소드)

  private void connection() {
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      con = DriverManager.getConnection(url, user, password);
 
    } catch(ClassNotFoundException e) {
        System.out.println("OracleDriver 클래스 로드 실패");
    } catch (SQLException e) {
        System.out.println("데이터베이스 접속 실패");}
  }

  private void close() {
    
    try {
      if(con != null) con.close();
      if(rs != null) rs.close();
      if(ps != null) ps.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }  

  // public 메소드 (실제 기능을 담당하는 메소드)
  
  // 모든 사용자 조회하기 : getUsers, getUserList 등
  public List<UserDto> getUsers() {
    
    List<UserDto> users = new ArrayList<UserDto>();
    try {
      connection();
      String sql = "SELECT USER_NO, USER_NAME, USER_TEL, JOIN_DT FROM USER_T ORDER BY USER_NO DESC";

      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        UserDto userDto = new UserDto();
        userDto.setUser_no(rs.getInt(1));
        userDto.setUser_name(rs.getString(2));
        userDto.setUser_tel(rs.getString(3));
        userDto.setJoin_dt(rs.getString(4));
        users.add(userDto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();                        //connection close 는 지금은 메소드마다 해주는게 좋아요. 물론 메소드마다 이게 열렸다 닫히니까 overhead 가 있어서 나중에는 더 발전된 connection pull(커넥션을 당겨쓰는 방식)을 사용하지만 지금은 쿼리문이 무사히 돌아가야 하니까...!
    }
    return users;
  }
  
  
  // 특정 사용자 조회하기 : getUser, getUserByNo 등
  public UserDto getUser(int user_no) { //원래는 파라미터 안에 begin end 값이 들어있는게 보통이지만 지금은 제외하신다고 함.(practice2에 있었던 그 값)
                                  
    UserDto userDto = null;               //무조건 new 하는게 아니라 처음엔 null 로 초기화시켜놓는게 좋아요!!! 이걸 new 를 치면서 들었죠 ^~^
    try {
      connection();
      String sql = "SELECT USER_NO, USER_NAME, USER_TEL, JOIN_DT FROM USER_T WHERE USER_NO = ?";  //? 없이 문자열로 user_no 빼도 돌아가긴 잘 돌아가요. 하지만 이렇게 쓰지 말아요! SQLinjection에 취약할 수 있어요.... 물음표 써주는게 방어가 됩니당.
      ps = con.prepareStatement(sql);
      ps.setInt(1, user_no);
      rs = ps.executeQuery();
      if(rs.next()) {
        userDto = new UserDto();
        userDto.setUser_no(rs.getInt(1));
        userDto.setUser_name(rs.getNString(2));
        userDto.setUser_tel(rs.getString(3));
        userDto.setJoin_dt(rs.getString(4));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return userDto;  //UNIT TEST : DB단 잘 돌아가는지 테스트 해보는 거에요. 우린 아직 해볼 데이터가 없어요...하지만 이런게 있음....
  }
  
  
  // 사용자 등록 : insertUser, saveUser, regiterUser 등
  public int saveUser(UserDto userDto){
    
    int result = 0;                        // 이렇게 삽입시 실패될 경우를 대비한 값을 초기화값으로 주면 좋아요.
    
    try {
      
      connection();
      String sql = "INSERT INTO USER_T (USER_NO, USER_NAME, USER_TEL, JOIN_DT) VALUES(USER_SEQ.NEXTVAL, ?, ?, TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') )";
      ps = con.prepareStatement(sql);
      ps.setString(1, userDto.getUser_name());
      ps.setString(2, userDto.getUser_tel());
      
     result = ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return result;                         // 맨 처음에 이렇게 반환값 먼저 만들어놓는 습관 들여요!
  }
  
  
  // 사용자 수정 : updateUser, modifyUser 등
  
  
  
  // 사용자 삭제 : deleteUser, removeUser 등
  
  
  
  
  


}




