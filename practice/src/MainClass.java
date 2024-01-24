import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class MainClass {

  public static void main(String[] args) {
    method12();
    
    
    
  }
 
      
      
 public static void method5() {
      
      File dir = new File("\\practice");
      if(!dir.exists()) {
        dir.mkdirs();
      }
      File file = new File(dir, "sample5.dat");
      BufferedWriter out = null;
      try {
        out = new BufferedWriter(new FileWriter(file));
        //출력할 객체
        Employee employee = new Employee(1, "홍길동");
        List<Employee> employees = Arrays.asList(new Employee(2, "홍길순"), new Employee(3, "홍순자"));
        
        out.write(employee.getEmpNo());
        out.write(employees.toString());
        
        out.close();
        System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
        
      } catch (Exception e) {
        e.printStackTrace();
      }
 }
 
 public static void method6() {
   
   File dir = new File("\\practice");
   
   File file = new File(dir, "sample5.dat");
   
   StringBuilder builder = new StringBuilder();
   
   try(BufferedReader in = new BufferedReader(new FileReader(file))) {
     
     String line = null;
     while((line = in.readLine()) != null) {
       builder.append(line);
     }
     
     System.out.println(builder.toString());
     
     
     
   } catch (IOException e) {
     e.printStackTrace();
   }
   
   
   
   
   
   
   
 }
 
 
 public static void method11() {
   
   File dir = new File("\\practice");
   if(!dir.exists()) {
     dir.mkdirs();
   }
   
   File file = new File(dir, "sample1011.txt");
   
   BufferedWriter out;
   
   try {
    out = new BufferedWriter(new FileWriter(file));
    
    out.write("복습중입니다. 바질베이글은 그냥 쏘쏘하네요");
    
    
    out.close();
     
     System.out.println("출력되었습니다. 확인해보세요.");
     
  } catch (Exception e) {
      e.printStackTrace();
  }
  
   
 }
 
 public static void method12() {
   
   File dir = new File("\\practice");
   File file = new File(dir, "sample1011.txt");
   
   BufferedReader in;
   
   try {
    
    in = new BufferedReader(new FileReader(file));
    
    String store = null;
    StringBuilder builder = new StringBuilder();
    
    while((store=in.readLine())!= null) {
      builder.append(store);
    }
    
    System.out.println(builder.toString());
    
    in.close();
     
     
  } catch (Exception e) {
    e.printStackTrace();
  }
   
   StringBuilder info = new StringBuilder();
   
   info.append(String.format("%-20s", file.getName().substring(0, Math.min(file.getName().length(), 20))));
   long byteSize = file.isDirectory() ? 0 : file.length();
   long kbSize = (byteSize / 1024) + (byteSize % 1024 !=0 ? 1:0);
   if(byteSize !=0)
     info.append(String.format("%10s", new DecimalFormat("#,##0").format(kbSize)+"KB"));
   
   
   System.out.println(info.toString());
 }
 
}
    
  
  
  

