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
public class BoardCounsel {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long counsel_id;
	private String title;
	private String content;
	private String username;
	private Date regdate;
	private int hitcount;
	private int replycnt;
	private int like;
	private boolean secret;
	
	@Transient
	private MultipartFile uploadcounsel;
	private String counselimage;

}
