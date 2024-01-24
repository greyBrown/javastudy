import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class MainClass {

  public static void main(String[] args) {
    
    
    
    
  }
 
      
      
 public static void method5() {
      
      File dir = new File("\\storage");
      if(!dir.exists()) {
        dir.mkdirs();
      }
      File file = new File(dir, "sample5.dat");
      ObjectOutputStream out = null;
      try {
        out = new ObjectOutputStream(new FileOutputStream(file));
        //출력할 객체
        Employee employee = new Employee(1, "홍길동");
        List<Employee> employees = Arrays.asList(new Employee(2, "홍길순"), new Employee(3, "홍순자"));
        
        out.writeObject(employee);
        out.writeObject(employees);
        
        out.close();
        System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
        
      } catch (Exception e) {
        e.printStackTrace();
      }
 }
}
    
  
  
  

