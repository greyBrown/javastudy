package Lotto;

import java.util.ArrayList;
import java.util.List;

public class test2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    List<String> papers = new ArrayList<String>();
    
    int count =5;
    
    for(int i = 0; i < count; i++) {
      papers.add(((int)((Math.random() * 49)+1)) + "");
      }
    
    System.out.println(papers);
    
  }

}
