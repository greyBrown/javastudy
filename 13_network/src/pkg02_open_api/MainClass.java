package pkg02_open_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainClass {

  public static void main(String[] args) {

    StringBuilder builder = new StringBuilder();
    builder.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
    builder.append("?serviceKey=").append("Ey838Ex4vbl3nnmdT%2FqDPRbqU8Qh9R0I9oSuImdTG0MsEmY1Lv51hNXQTf6l9zzeqoZyhIvonnH%2B10OjPn5Fdg%3D%3D");
    builder.append("&searchYear=").append(2022);
    builder.append("&siDo=").append(1100);
    builder.append("&guGun=").append(1125);
    builder.append("&type=").append("json");
    builder.append("&numOfRows=").append(10);
    builder.append("&pageNo=").append(1);

    
  //저 뒤쪽 append에도 인코딩하기도 해요. 활용범위 좋아짐...
    
    String spec = builder.toString();
    URL url = null;
    HttpURLConnection con = null;
    
    //텍스트로 넘어오는 정보이기때문에 reader로 합니당.
    BufferedReader in = null;
    
    try {
      
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
      if(con.getResponseCode() != 200) {
        System.out.println("접속불가");
      }
      
      in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String Line = null;
      
      StringBuilder sd = new StringBuilder();
      
      while((Line = in.readLine()) != null) {
        sd.append(Line);
      }
      
      /*JSON object -> {} 객체 처리용
      JSON Array  -> [] 배열 처리용

      JSONObjetct obj = {name:value} 
      obj.get
      -> value가 int인 경우 obj.getInt(name)
      -> value가 String인 경우 obj.getString(name)
      -> value가 {}객체인 경우 obj.getJSONObject(name)
      -> value가 []배열인 경우 obj.getJSONArray(name)

      String responseData = sb.toString();
      JSONObject obj = new JSONObject(responseData);
      obj.getString("resultCode") == "00"
      obj.getString("resultMsg") == "NORMAL_CODE"
      obj.getJSONObject("items").getJSONArray("item") 
      //item에 배열이 들어있는 구조. 여기까지 해야 원하는 뒷부분 배열 데이터들을 쫙 가져옴.
     ++ JSON에서 name 이라고 부르는거 이 API에서는 자바처럼 key라고 부르네요. 그럼 다음부턴 저희도 key 라고 봐요~   
     ++ 외부 API 쓸 때 중요한거 요청하란대로 요청하는거...! 오타 이런거 신경써야함 ㅋㅋㅋㅋㅋ 컴파일오류가 나는 것도 아니라서...  
     */ 
      
        
      JSONObject obj = new JSONObject(sd.toString());
      JSONArray items = obj.getJSONObject("items").getJSONArray("item");
      for(int i = 0, length = items.length(); i < length; i++) {
        Map<String, Object> map= items.getJSONObject(i).toMap();        // Map 으로 바꿔주는 메소드를 지원함!! 그라시아스...        
        System.out.println(map.get("occrrnc_dt") + " : " + map.get("dth_dnv_cnt"));
        }  //이렇게 원하는 정보를 뽑아냅니다!
        
        
        
      
      in.close();
      
      
      
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
      
      con.disconnect();
      
    }
    
    
   
    
    
    
    
  }

}
