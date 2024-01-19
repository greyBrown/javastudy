package pkg03_input;

import javax.swing.JOptionPane;

public class Class02_JOptionpane {

  public static void main(String[] args) {
    
    //이 친구는 중요한 클래스는 아니에요. 자바 넘어가면 쓸일이 없기 때문에...
    
    String name = JOptionPane.showInputDialog("이름을 입력하세요"); //모두 스트링으로 반환한다는 특징.
    String strAge = JOptionPane.showInputDialog("나이를 입력하세요");
    String strHeight = JOptionPane.showInputDialog("키를 입력하세요");
    String strGender = JOptionPane.showInputDialog("성별을 입력하세요");
  
    int age = Integer.parseInt(strAge);                   //그래서 이렇게 타입 바꾸줘야함.
    double height = Double.parseDouble(strHeight);
    char gender = strGender.charAt(0);
    
    JOptionPane.showMessageDialog(null, name + "," + age + "," + height + "," + gender);
    
  }

}
