package petcare.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class BoardPetstory {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long petstory_id;
	private String title;
	private String content;
	private String username;
	private Date regdate;
	private int hitcount;
	private int replycnt;
	private int like;
	
	@Transient
	private MultipartFile uploadpetstory;
	private String petstoryimage;
}
