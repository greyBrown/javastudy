package practice03_Member;

public class MainClass {

  public static void main(String[] args) {

    //임의의 정보를 가지는 Member 1명을 만들고, 정보 출력하기
    
    //디폴트 형식 생성자 + setter
    
    Member exampleMember = new Member("id_example", new Contact(), new Address());
    Contact exampleContact = new Contact("02-123-4567", "010-1234-5678");
    Address exampleAddress = new Address("postcode", "roaddress", "jibunaddress", "detailAddress", "extraAddress", true);
    exampleMember.setContact(exampleContact);
    exampleMember.setAddress(exampleAddress);
    
  
    
    
    //위에가 내가 한거
    //아래 선생님 예시. setter 써서 하면 어떻게 하는지도 눈여겨 보기!
    //sop 입력할때!! 일일치 치는게 아니라 ctrl+space 랑 자동으로 뜨는 걸로 타고 들어가는걸로 연습해버릇 해야해요...
    //sop 안에서는 메소드 ; 안친다... 반환값이라서? 미적으로도 별로기도 하고....쨋든 그런거같다...

    
    //필드를 이용한 생성자
    Address address = new Address("12345", "a", "b", "c", "d", true);
    Contact contact = new Contact("02", "010");
    
    //디폴트 형식 생성자 + setter
    Member member = new Member();
    member.setId("elsa");
    member.setAddress(address);
    member.setContact(contact);
    
    System.out.println("아이디 : " + member.getId());
    System.out.println("우편번호 : " + member.getAddress().getPostCode());
    System.out.println("도로명 : " + member.getAddress().getRoadAddress() );
    System.out.println("지번 : " + member.getAddress().getJibunAddress());
    System.out.println("상세 : " + member.getAddress().getDetailAddress());
    System.out.println("추가 : " + member.getAddress().getExtraAddress());
    System.out.println("기본 주소 여부 : " + member.getAddress().isIsbasicAddress());
    System.out.println("집 : " + member.getContact().getTel());
    System.out.println("휴대전화: " + member.getContact().getMobile());
    
    
 
 
    
    
    
  
    
    
    
    
    
    
    
    
    
    
    
  }

}
