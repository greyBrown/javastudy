package pkg05_marker_interface;

public class DurianHatePerson {
  
//  public void eat(Food food) {    //두리안 싫어하는 사람이 있어서 두리안은 안먹는다면?!
//    if(food instanceof Durian) {  //해결방법 1. if 를 쓴다. 
//      return;
//    }
//    food.eat();
//  }
  
  public void eat(Eatable eatable) {                        //아예 안받고 싶다. 컴파일오류가 뜨게하고 싶다. 해결방법 2. marker interface를 사용한다.
  ((Food)eatable).eat();  //무슨 구조인지 헷갈리는데요...이따 좀 정리해봅시다...
  }

}
