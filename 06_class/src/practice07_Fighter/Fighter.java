package practice07_Fighter;

public class Fighter {

  //field
  
  private String name;
  private long hp;
  Fighter fighter;
  
  public Fighter() {
  }

  public Fighter(String name, int hp) {
    super();
    this.name = name;
    this.hp = hp;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHp() {
    return (int) hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }
  
  
  
  //punch() 메소드 만들기 fighter2.punch(fighter1, 20); //파2가 파1한테 20만큼 데미지의 펀치
  
  public void SnowPunch(Fighter fighter, int damage) {
    // 피공격자.1의 hp가 20 아래일때
 
    if(fighter.hp <= 0 || fighter.hp < damage) {
      System.out.println(this.fighter + "가 눈 싸움에서 승리하였습니다!");
      return;
    }
     
    System.out.println(fighter.name + " 가 데미지" + damage + "의 공격을 받았습니다.");
    
    fighter.setHp(fighter.getHp()-damage);
    
    System.out.println(fighter.name + "의 hp가" + fighter.hp + "남았습니다.");
    
    
  }
  
  public void ShowHp(Fighter fighter) {
    System.out.println(this.getHp());
    System.out.println(fighter.getHp());
    
  }

}
