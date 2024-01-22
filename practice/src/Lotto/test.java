package Lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class test {

	public static void main(String[] args) {
		
	// 5000원 어치씩 로또를 뽑는 메소드 (중복 정렬 처리 아직 안됨)
	  
	  List<String> papers = new ArrayList<String>();
	  
	    for(int i = 0; i < 7; i++ ) {
	  papers.add(((int)((Math.random() * 49)+1)) + "");
	  }
	    
	    for(int i =1, size = papers.size(); i < size; i ++)
	    System.out.print(papers.get(i) );
	    
	  
	     int count=0;
	     for(int i = 0; i < money/1000; i++) {
	       for(int j=0; j<7 ; j++) {
	        System.out.print(papers.get(count) + " ");
	        count++;
	       } 
	       System.out.println();
  	      }
  	
	    	 
	    	 //지금 문제 : 메소드에서 배열 처음 부터 끝까지 형식 정해서 뽑으니까 후정렬이 안됨...
	    	 //메소드 -> 일단 배열에는 로또 번호만 들어가게 변경? 몇장 뽑는지는 메인클래스에서 정하고 여기서는 배열에 들어가는 번호만 결정...

	   
	   /*
	    *  for(int i = 0; i < money/1000; i++) {
      papers.add("0" + ((i%5)+1 + "") + " :");  
	    * 
	    * 
	    */
	
	}

	
}