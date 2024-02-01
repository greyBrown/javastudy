package db.service;

import java.util.List;

import db.dao.UserDao;
import db.dto.UserDto;

/*
 * Business Layer
 * 1. 핵심 로직을 처리하는 부분
 * 2. Persistence Layer(DAO) 와 통신하는 레이어이다. 
 * 3. DAO 로 전달할 데이터를 가공하거나, DAO 로부터 전달 받은 데이터를 가공한다.
 */

//API 코드를 서비스에서 받아서 핵심 jSON으로 통합가공하는 일을 처리하는 등...핵심로직을 처리한다! 지금은 기능이 없어서 텅 비어보이지만 중요한 파트임.

public class UserServiceImpl implements UserService {

  //field
  private UserDao userDao;
  
  //constructor
  public UserServiceImpl() {
    userDao = UserDao.getInstance();
  }
  
  
  @Override
  public List<UserDto> getUsers() {
    return userDao.getUsers();
  }

  @Override
  public UserDto getUser(int user_no) {
    return userDao.getUser(user_no);
  }

  @Override
  public int saveUser(UserDto userDto) {
    return userDao.saveUser(userDto);
  }

  @Override
  public int modifyUser(UserDto userDto) {
    return userDao.modifyUser(userDto);
  }

  @Override
  public int removeUser(int user_no) {
    return userDao.removeUser(user_no);
  }

}
