package pkg03_constructor;

/*
 * 자식 클래스의 생성자
 * 1. 반드시 부모 클래스를 가장 먼저 생성해야 한다. //(지금까지는...자바가 알아서 했음! 자바가 못하는 경우도 있으니 이따 그것도 해봅시다)
 *   -> 부모 클래스의 생성자를 호출해야 한다. 
 * 2. 부모 클래스의 생성자를 호출하지 않는 경우 JVM이 부모 클래스의 디폴트 생성자를 자동으로 호출한다.
 * 3. 부모 클래스에 디폴트 형식의 생성자가 없는 경우에는 개발자가 직접 부모 클래스의 생성자를 호출해 줘야 한다. 
 * //이거..그거임 아무 생성자도 없으면 디폴트가 기본으로 있는데 뭐가 생기면 디폴트가 사라짐. 
 *  차라리 아무것도 없으면 자바가 해주는데 초기화값 만들려고 생성자 만들었는데 디폴트 없으면 이 클래스의 자식이 가져올 생성자가 없어서 오류난다. 실무에서도 디폴트생성자는 계속 만들어줌! 아하 이런이유였군요...
 * 4. 부모 클래스 생성자를 호출하는 방식
 *   super()   //person() 아니에요!! 방금 한 짓이네^^ ; ㅋㅋㅋㅋㅋㅋㅋ
 */



public class Student extends Person{
  
  //field
  private String school;
  
  //constructor  <- 지금 person 디폴트 생성자 없음. 그래서 super()로 부모 생성자를 호출해줄거임. 실제로 super(name);이럴 필요는 없어요 자바가  field name 가지고 알아서 넣고 뽑아줌
  public Student() {
    super(null); //전달할 name이 없으니 null값으로! 
  }
  
  public Student(String name) {
    super(name); //person(name)
  }
  
  public Student(String name, String school) {
    super(name);
    this.school = school;
  }
  
  //method
  public String getSchool() {
    return school;
  }
  public void setSchool(String school) {
    this.school = school;
  }
  
  
  
  
  
  
  
}
