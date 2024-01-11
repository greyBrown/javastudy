package practice03_Member;

public class Address {
  
  // field
  private String postCode;
  private String roadAddress;
  private String jibunAddress;
  private String detailAddress;
  private String extraAddress;
  private boolean isbasicAddress;  //boolean 타입은 변수 이름자체가 is로 시작하는 경우 많음. 알기쉽죠
  
  //필드에서 피해야 하는 이름 :  aNumber 이런 소문자 하나 직후에 대문자 나오는거. 이런거 피해야 함! getter/setter 만들때 문제가 생길 가능성 있음(카멜케이스 때문에...) 금지~~
  //변수명 과도하게 줄임말 쓰는 거 지양...혼자할 땐 그래도 되는데 사실 혼자해도 나중에 내가 헷갈릴듯 어 이거?????
  //좋은코드 = 주석을 달지 않는 코드 = 코드 자체가 주석인 코드
  
  //constructor 만약 초기화값에 필드 추가하고 싶으면...추가하지 말고 그냥 삭제했다 새로 만들어요! 다시 뽑기를 권장...
  //G/S는 지울 필요는 없어요! 그냥 다시 추가하면 더 만들어줌...
  public Address() {
    //이거 디폴트 안만들면 기본생성이 안됨...그렇구나 기본생성 할려면 기본은 만들어줘야 하는거임.... 난 아래거가 다 커버해주는 줄 알았네 ㅋㅋㅋㅋ 아님!!!
  }

  public Address(String postCode, String roadAddress, String jibunAddress, String detailAddress, String extraAddress,
      boolean basicAddress) {
    super();
    this.postCode = postCode;
    this.roadAddress = roadAddress;
    this.jibunAddress = jibunAddress;
    this.detailAddress = detailAddress;
    this.extraAddress = extraAddress;
    this.isbasicAddress = basicAddress;
  }



  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public String getRoadAddress() {
    return roadAddress;
  }

  public void setRoadAddress(String roadAddress) {
    this.roadAddress = roadAddress;
  }

  public String getJibunAddress() {
    return jibunAddress;
  }

  public void setJibunAddress(String jibunAddress) {
    this.jibunAddress = jibunAddress;
  }

  public String getDetailAddress() {
    return detailAddress;
  }

  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }

  public String getExtraAddress() {
    return extraAddress;
  }

  public void setExtraAddress(String extraAddress) {
    this.extraAddress = extraAddress;
  }

  public boolean isIsbasicAddress() {
    return isbasicAddress;
  }

  public void setIsbasicAddress(boolean isbasicAddress) {
    this.isbasicAddress = isbasicAddress;
  }

  
  //이런 데이터전송용, 저장용 객체들...VO, DTO, bean 상황에 따라 이렇게들 불러요
//boolean 타입은 getter가 get이 아니라 is로 시작하는거! 이렇게 확인하네요~ 약속 잊지마요.. -> 그렇게 isIs가 됨 ㅋㅋㅋㅋ
  //set은 Is로 변수명이 바뀌었죠! boolean만 이렇게 예외가 살짝 있죠. 아마 boolean이랑 맞춰줄려고...?
  
  
  
  

}
