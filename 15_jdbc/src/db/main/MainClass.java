package db.main;

import java.util.List;

import db.dao.UserDao;
import db.dto.UserDto;

public class MainClass {

  public static void main(String[] args) { //잘 돌아가나 확인해보는거에요~ 이건 삭제해도 상관없어요.

   //UserDto userDto = new UserDto(1, "테스트이름", "테스트연락처", null);
    
   UserDao userDao = UserDao.getInstance();
 //  int result = userDao.saveUser(userDto);
 //  System.out.println(result + "행이 삽입되었습니다");
    
    List<UserDto> users = userDao.getUsers();
       for(UserDto user : users) {
      System.out.println(user);
      }
    
 //  UserDto userDto = userDao.getUser(1);
  // System.out.println(userDto);
    
   //userDao.modifyUser(new UserDto(6, "수정이름", "수정연락처", null)); 
   
 //  UserDto userDto = userDao.getUser(6);
   // System.out.println(userDao.getUser(6));
   //userDao.removeUser(2);

       //이것저것 해봐서 좀 지저분해졌는데 그래도 이것저것 됐다는건에 만족...^^
       
  }

}
