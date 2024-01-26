package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainClass {

  public static void main(String[] args) {

    String spec = "https://ssl.pstatic.net/melona/libs/1482/1482864/131081445d1f8eb6007d_20240124161628709.jpg";
    
    URL url = null;
    HttpURLConnection con = null;
    
    BufferedInputStream in = null;
    BufferedOutputStream out = null;
    
    try {
      
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
      
      if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(spec + "접속불가");
      }
      
      in = new BufferedInputStream(con.getInputStream());
      
      File dir = new File("\\storage");
      if(!dir.exists()) {
        dir.mkdirs();
      }
      
      File file = new File(dir, "banner.jpg");
      out = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] b = new byte[10];
      
      int readbytes = 0;
      
      while((readbytes = in.read(b)) != -1) {
        out.write(b, 0, readbytes);
      }

      out.close();
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if(con != null)
        con.disconnect();
    }
    
  
    
    
  }
    
    
    
    
    
    
  

}
