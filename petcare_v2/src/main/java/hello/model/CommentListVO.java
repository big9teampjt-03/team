package hello.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommentListVO {
	private List<CommentPetStory> carr;
	private int count;
	
	public CommentListVO(List<CommentPetStory> carr, int count) {
		this.carr = carr;
		this.count = count;
	}

}
