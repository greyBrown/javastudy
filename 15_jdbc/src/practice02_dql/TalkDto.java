package practice02_dql;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.sql.Timestamp;



@ToString                 // toString() 
@NoArgsConstructor        // default constructor
@AllArgsConstructor       // constructor using filed
@Getter
@Setter
public class TalkDto {
  
  private int talk_no;
  private String talk_content;
  private String talk_user;
  private Timestamp written_at; 
  
  
  
}
