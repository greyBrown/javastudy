package pkg03_inputStream;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import pkg02_OutputStream.Employee;

public class MainClass {

  /*
   * java.io.FileInputStream
   * 1. 바이트 기반
   * 2. 입력 단위
   *    1) int
   *    2) byte[]
   */
  
  /* java.io.BufferedInputStream (여기서부터 정리)
   * 1. 버퍼링을 지원하는 바이트 입력 스트림이다.
   * 2. 보조 스트림이므로 메인스트림과 함께 사용해야 한다.
   * 3. 버퍼링을 지원하므로 입력 속도가 향상된다.
   * 
   * java.io.DataInputStream
   * 1. 자바 변수로 구성된 데이터를 읽는 바이트 입력 스트림이다.
   * 2. 보조 스트림이므로 메인 스트림과 함께 사용해야 한다.
   * 3. 타입 별로 전용 메소드가 존재한다.(Int 따로 String 따로...)
   * 
   *java.io.ObjectInputStream
   * 1. 객체로 구성된 데이터를 읽는 바이트 입력 스트림이다.
   * 2. 보조 스트림으로 메인 스트림과 함께 사용해야 한다.
   * 3. 읽은 객체는 Object 타입으로 반환되므로 객체 타입으로 캐스팅 해서 사용한다.
   *  -> IOException과 ClassNotFoundException/ClassCastException 예외가 발생할 수 있다.
   *  (IO랑 Class 는 직속 부모가 다르다. 모두의 부모인 Exception 처리할거 아니면 따로 해줘야 함. (=> 부모자식이 아니니까 catch 예외처리시 순서 없음! 어제 ???아!! 하다가 순서바꾼 그거! ㅋㅋㅋㅋ)
   *  (checked 는 Exception 으로 퉁칠 수 없나봄...? 알아보기)  
   * 
   */
  
  
  public static void method1() {  // int 단위로 데이터 읽어들여 보기. 읽어들일 때 for 문 보다는 while 문이 적합한 형태. (while c == -1 일떄 종료. while 에 if 넣어서 c == -1 일 때 종료 하는것도 ㄱㅊ)
    
   
    
    File dir = new File("\\storage");   //만드는게 아니라 읽는거니까 없으면 만든다 이런건 없죠~ 그냥 없으면 오류....
    
    File file = new File(dir,"sample1.dat");
    
    // 파일 입력 스트림 선언
    FileInputStream in = null;
    
    try {
      
      // 파일 입력 스트림 생성
    in = new FileInputStream(file);          
    
      // 읽은 데이터를 보관할 배열(바이트를 읽어오니까 바이트 배열. int 도 사실상은 바이트로 읽어오니까)
     byte[] b = new byte[(int)file.length()];   //length 의 반환값이 long 이어서 생기는 반환값 오류. -> int 로 변환해줘야 함. 혹은 List 를 사용하는 것도 가능!
     int idx = 0; 
     
     // 읽을 단위 (int 변수로 1바이트씩 읽는다.)
     int c;
     
     // 읽기
     // c = in.read(); while으로 바꾸면서 주석처리 아 이게 문제였네 이거때문에 A 안뜸...     // 하나 읽어라. 그리고 int로 가져와라. read 메서드가 발생하는 메서드는 FileNotFoundException 이 받아내지 못한다. 그래서 컴파일 오류
                          // 컨스로 확인해 보면 IOException 처리가 필요하다는 걸 확인할 수 있음. 컨스 자주 확인해봐요!       
     
     
     while(true) {
       c = in.read();
     if(c == -1) {
       break;
     }
     b[idx++] = (byte) c;
    }
    
    for(int i =0; i < b.length; i++) 
     System.out.println(b[i]);
    
    // 확인
    // System.out.println(new String(b)); 이걸로 for 문 없이 한번에 해볼 수도 있어요! Sting 클래스가 알아서 변환해줌...
    
    // 파일 입력 스트림 닫기
    in.close();
      
    } catch (FileNotFoundException e) { //FileNotFoundException 예외 발생 체크(어제는 없으면 만드는 상황이니까 이 예외가 제외되었죵)
      System.out.println("파일의 경로를 확인하세요.");
    } catch (IOException e) {
      System.out.println("입출력 예외가 발생했습니다.");
    } 
  }
  
  
  public static void method2() { //읽을 단위가 달라짐. 디테일!
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample2.dat");
    
    // 파일 입력 스트림 선언
    FileInputStream in = null;
    
    try {
      
     // 파일 입력 스트림
      in = new FileInputStream(file);
      
     // 읽은 데이터를 보관할 배열
      byte[] b = new byte[(int)file.length()];  
      
      // 읽을 단위 (byte[] 배열로 읽는다.)
      byte[] bytes = new byte[5];  //5개씩 읽어보아요
      int idx = 0;
      
      
      // 읽기
      while(true) {
        int readByte = in.read(bytes);    // 읽은게 없으면 -1 이라고 했죠!!~~ read 메서드의 약속입니다 문법문법 
        if(readByte == -1) {
          break;
        }
        System.arraycopy(bytes, 0, b, idx, readByte);       // b 배열에 차곡차곡 5씩 채웠다. 마지막에 1~2개짜리 남은 데이터 어떻게 할 것인가? 5개가 아니라 1개만 복사해야함. 이거 누가 담당한다? readByte가 담당한다.
        idx += bytes.length;  //5만큼 증가한다 보다는 아까 설정한 바이트 배열만큼 증가한다고 적어주는게 좋은 코드 혹은 idx += readBytes;
      }
      //System.arraycopy(bytes, 0, b, 0, readByte);  //5개 복사. 출력하면 맨 위에 5개는 데이터를 읽는 걸 볼 수 있음. 마이너스 값인 이유 : 오버플로한 값이겠져...한글이 바이트 범위 벗어나서...
      
      // 확인
       System.out.println(new String(b));

      // 파일 입력 스트림 닫기
       in.close();
      
      // 이렇게 bytes를 읽어보았습니다...사실 뒤에 배우는 String들을 읽는 메소드 등등은 훨씬 쉬워요! 하지만 원리가 이렇다는거~~~
      // 읽기부분...읽기부분 좀 공부하기. 원리가 뭔지 내가 아 이런 원리야~ 할 수 있을 만큼! ㅎ ㅏ 까다롭네....마지막 1 2씩 남은거 read 가 남은거 가져올때...오류 안나??? 복사한 배열에 비해 가져오는게 부족한데 오류 안나????? 어어엉 아니다 아니다 그지 붙여넣는 곳을 지정하는 거지!!! 그봐 블로그 복습하면 생각이 금방금방 난다 ^_^ 
      // 누누이 말하지만 io 중요!!
       
       
      // 그냥 int c = in.read(bytes)  일 경우의 예시.
      //21바이트면 5개씩 4번 하고 1바이트 한개 읽겠죠? 이때 실제로 읽어들일 수 있는 값은 5이하가 된다. 아래는 그 사례. 
      //read 컨스로 들어가보면 어떤게 반환되는게 잘 보여준다. int값을 반환하고 있음. 5가 반환되다가 4...그리고 -1
      
//     System.out.println(in.read(bytes));
//     System.out.println(in.read(bytes));
//     System.out.println(in.read(bytes));
//     System.out.println(in.read(bytes));
//     System.out.println(in.read(bytes));
//     System.out.println(in.read(bytes));
//     System.out.println(in.read(bytes));
//     System.out.println(in.read(bytes));
//     System.out.println(in.read(bytes));
//     System.out.println(in.read(bytes));
//     System.out.println(in.read(bytes));
//     System.out.println(in.read(bytes)); //여기서        4 가 출력
//     System.out.println(in.read(bytes)); //여기서부터는 -1 가 출력
      
    } catch (FileNotFoundException e) {
      System.out.println(file.getPath() + "파일이 존재하지 않습니다.");
    } catch (IOException e) {
      System.out.println("입출력 오류가 발생했습니다.");
    }
    
  }
  
  public static void method3() { //버퍼! 입력도 사실 버퍼로 합니다...코드 한줄 추가해서 빨라지니까...안쓸 이유가 없다!
    
    File dir = new File("\\storage");
    File file  = new File(dir, "sample3.dat");
    
    //버퍼 입력 스트림 선언
    BufferedInputStream in = null;
    
    try {
      
    //버퍼 입력 스트림 생성
      in = new BufferedInputStream(new FileInputStream(file));
      byte[] s = new byte[(int)file.length()]; //저장소 이름을 s라고 하겠음. 여기다 bytes 배열 복사한거 readbytes 만큼 떼다 붙일것임! arraycopy 순서 알겠지~~
      byte[] bytes = new byte[5];
      int ix =0;
      
      
      int readbytes = 0; // 변수 선언은 반복문 안에 안들어오게 이렇게 위로 빼주기~ 저 문장 통째로 빼주면 대차게 오류가 납니다 ^^! read 메소드가 작동을 못하기 때문이 아닐까 함. 어디까지 읽었고 여기서 다시 읽어야지 그런게 안되니까...
      
      while((readbytes = in.read(bytes)) != -1) {  //if 의 조건을 이렇게 while 안에 넣어서! 코드 스타일의 차이...성능은 딱히 크게 문제 없어요.
                                                  // 변수 선언은 반복문 안에 안들어오게 이렇게 위로 빼주기~
        System.arraycopy(bytes, 0, s, ix, readbytes);   //이상하게 출력되는 원인 : ix 안넣고 0 넣었음...증가가 안되니까 배열의 첫번째에 값이 이상하게 고정됐겠지?? 바이트 배열 크기 30으로 하면 멀쩡히 나온것도 값이 크게 고정되어서 멀쩡히 나온거... 그랬군요~~
        ix += bytes.length;
      }
      
      System.out.println(new String(s));
      
      in.close();
      
      
      
    } catch (IOException e) {      //사실 FileNotFound 는 IO 의 자식입니다...그래서 IO 만 적어줘도 되요 ㅋㅋㅋㅋㅋㅋ
     System.out.println("다음과 같은 문제가 있으니 해결 바람");
      e.printStackTrace();
    }
    
    
  }
  
  public static void method4() {
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample4.dat");
    
    // 데이터 입력 스트림 선언. 스트림은 생성부부터 트라이캐치가 필요하니까 아래부터 트라이
    DataInputStream in = null;
    
    try {
      // 데이터 입력 스트림 생성
      in = new DataInputStream(new FileInputStream(file));
      
      // 입력
      String name = in.readUTF();            // 출력 시 out.writeUTF(name) 사용
     // int age = in.readInt();                // 출력 시 out.wirteInt(age) 사용
      //double height = in.readDouble();       // 출력 시 out.wirteDouble(height) 사용
      //boolean isAdult = in.readBoolean();    // 출력 시 out.wirteBoolean(isAdult) 사용  
      //char gender = in.readChar();           // 출력 시 out.wirteChar(gender) 사용
      
      
      System.out.println(name);
      //System.out.println(age);
      //System.out.println(height);
      //System.out.println(isAdult);
      //System.out.println(gender);
      
      // 데이터 입력 스트림 닫기
      in.close();
      
    } catch (Exception e) {
      e.getStackTrace();
    }
    
    
    
  }
  
  public static void method5() {
    File dir = new File("\\storage");
    File file = new File(dir, "sample5.dat");
    
    //객체 입력 스트림 선언
    ObjectInputStream in = null;
    
    try {
      
      // 객체 입력 스트림 생성
      in = new ObjectInputStream(new FileInputStream(file));
      List<Employee> empList = (List<Employee>)in.readObject();
      
      
      //객체 입력
      Employee emp1 = (Employee)in.readObject();  //패키지 다르니까 import 해주기~~ 컨스컨스
      Employee emp2 = (Employee)in.readObject();  
      Employee emp3 = (Employee)in.readObject();  
      
      
     System.out.println(emp1.toString());   //이걸 보기 위한 toString 오버라이딩이었죠
     System.out.println(emp2.toString());
     System.out.println(emp3.toString());
     
     //객체 입력 스트림 닫기
     in.close();
     
     
    } catch (IOException | ClassNotFoundException e) {   //|가 하나라는 거에 주의! || 아님!
      e.printStackTrace();
    }
    
    
    
    
    
  }
    
    
    
  
  public static void main(String[] args) {

    //서버에서 파일이 있죠! 그걸 자바로 in 한다. 그걸 다시 자바에서 디렉터리로 out 한다. => 파일 다운로드 코드! 여기서 "서버에서 파일" 부분만 제외하면 파일 복사코드.
    //복사 할 줄 알면 이동도 할 수 있어요. 복사 끝나고 delete 하면 그게 이동이죱. 
    method4();
    
  }
    
}