package pkg05_marker_interface;

//먹을 수 있는 음식
public class PineApple implements Food, Eatable {

@Override    //source 가지 않아도 ctrl+space 로도 빠르게 구현가능합니당
public void eat() {
 System.out.println("파인애플 먹는다."); 
 }

}
