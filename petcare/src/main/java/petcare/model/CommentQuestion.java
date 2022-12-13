package petcare.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class CommentQuestion {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long comquestion_id;
	private String content;
	private int grp;
	private int grps;
	private int grpl;
	private String username;
	private Date regdate;
	
	private int bquestionnum;
}
