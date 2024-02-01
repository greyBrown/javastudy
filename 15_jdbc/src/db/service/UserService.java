package db.service;

import java.util.List;

import db.dto.UserDto;

public interface UserService { //DAO 에서 쓰는 메소드명과 맞출 것.
                               //Class UserServiceImpl <- 인터페이스 구현하는 클래스 이름은 이렇게 지정되어있음.
  
  List<UserDto> getUsers();     //전체조회
  UserDto getUser(int user_no);  //상세조회
  int saveUser(UserDto userDto);  
  int modifyUser(UserDto userDto); 
  int removeUser(int user_no);
}
