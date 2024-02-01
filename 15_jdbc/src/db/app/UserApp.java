package db.app;

import java.util.List;

import javax.swing.JOptionPane;

import db.ctrl.UserController;
import db.dao.UserDao;
import db.dto.UserDto;
import db.service.UserService;
import db.service.UserServiceImpl;
import db.view.DeleteView;
import db.view.DetailView;
import db.view.EditView;
import db.view.ListView;
import db.view.RegisterView;
import db.view.View;

// UserApp 동작 흐름(시퀀스 다이어그램)   이런거 노트로 정리해보고 그렇게 공부하는 거 권장해요...여기서 그리기 쉽지 않다 ㅋㅋㅋㅋ
/*
 * UserApp                  UserController                                             UserService                                           UserDAO   
 *  작업 선택          ->   
 *  View 실행 결과     ->   
 *                         String requestHanle(작업 선택, View 실행 결과){ 
 *                          작업에 따른 서비스 호출(View 실행 결과 전달)       ->    
 *  message 반환                 <- 작업결과메시지 반환}
 *                         
 *                                                                                   반환타입 선택된메소드(View 실행 결과) {
 *                                                                                   DAO 메소드 호출(View 실행 결과)                 ->
 *                                                                                   <- 반환값 반환   } 
 *                                                                                                                                         반환타입 선택된메소드(View 실행결과) {
 *                                                                                                                                         DB 처리
 *                                                                                                                                   <-    반환값 반환}
 *                                                                                                                                                              
 *                                                                                                                                                                                      
 */



public class UserApp {

  public static void main(String[] args) { //잘 돌아가나 확인해보는거에요~ 이건 삭제해도 상관없어요.

    UserController userController = new UserController();
    
    while(true) {
      String choice = JOptionPane.showInputDialog("1.전체명단\n2.상세조회\n3.등록\n4.편집\n5.삭제\n0.종료\n원하는 작업 번호를 입력하세요");
      View view = null;
      switch(choice) {
      case "1" : view = new ListView(); break;
      case "2" : view = new DetailView(); break;
      case "3" : view = new RegisterView(); break;
      case "4" : view = new EditView(); break;
      case "5" : view = new DeleteView(); break;
      case "0" : JOptionPane.showMessageDialog(null, "사용자 앱을 종료합니다."); return;
      default : JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 다시 선택하세요");
      }
       if(view != null) {
        String message = userController.requestHandle(choice, view.display());       
        //  모든 뷰는 display 호출로 받아올 수 있다. (인터페이스니까). 이거 좀 정리하기. 이런 전반적인 구성을 이해하는게 중요...
        // 이렇게 패키지들이 엮여서 어떻게 작동하는지 알아야해요
        JOptionPane.showMessageDialog(null, message);
       }
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    // UserController userController = new UserController();
   // System.out.println(userController.requestHandle("3", new UserDto(1, "테스트이름", "테스트연락처", null)));
   // System.out.println(userController.requestHandle("1", null));
   //UserDto userDto = new UserDto(1, "테스트이름", "테스트연락처", null);
    
  // UserDao userDao = UserDao.getInstance();
 //  int result = userDao.saveUser(userDto);
 //  System.out.println(result + "행이 삽입되었습니다");

    //UserService userService = new UserServiceImpl();  //UserServiceImpl 테스트...잘 됩니당. UserService 타입의 Impl 객체라는거 생각하기.
    
   // List<UserDto> users = userService.getUsers();
   //    for(UserDto user : users) {
   //   System.out.println(user);
   //   }
    
 //  UserDto userDto = userDao.getUser(1);
  // System.out.println(userDto);
    
   //userDao.modifyUser(new UserDto(6, "수정이름", "수정연락처", null)); 
   
   // UserDto userDto = userDao.getUser(6);
   // System.out.println(userDao.getUser(6));
   //userDao.removeUser(2);

       //이것저것 해봐서 좀 지저분해졌는데 그래도 이것저것 됐다는건에 만족...^^
      // UserDto userDto = userDao.getUser(6); 이거 한번만 해석 한번 해봅시다..
  }

}
