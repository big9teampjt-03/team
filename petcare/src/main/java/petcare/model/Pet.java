package petcare.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pet_id;
	private String petbirth;
	private String petname;
	private String petgender;
	private String petweight;
	private String petbreed;

	@Transient
	private MultipartFile uploadpet;
	private String petimage;

	private String petneutering;
	private String petvaccination;
}
