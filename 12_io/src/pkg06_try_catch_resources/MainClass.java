package pkg06_try_catch_resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass {

  public static void main(String[] args) {
    
    /*
     * try - catch - resources
     * 1. 생성한 자원(resource, 대표적으로 입출력 스트림)을 자동으로 close 하는 try 문이다.
     * 2. 형식
     *    try(자원 생성) {
     *    
     *    } catch() {
     *    
     *    }
     * 이걸 이용하면 마지막 작업 close 를 안해도 됨!
     */  
    
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "sample4.txt");
    
    try(BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      
      out.write("안녕하세요");
      out.newLine();
      out.write("반갑습니다");
      out.newLine();
      
    } catch (IOException e) {
        e.printStackTrace();
    }
    //이렇게 하면 try 문 안에 출력문만 깔끔하게 딱 나올 수 있죠! 아주 간단...하지만 그 전 것들(원리) 중요! 이것만 외우는 그런 불상사...없길 바래요...쪼끔만 변형해야 하는 상황오면 저건 못써요!
    // 예를 들면 파일 지울 때...저 try 문 안에 delete 이런거 못들어옴. 스트림이 열려있는데 지운다는 코드가 되어버려서; 쫌 복잡해지면 못쓸수 있어요. 상황별로 선택해서써요.
    // 하지만 일반적인 경우는 resources 가 짧고 쓰기 좋음!
  }
  

}
