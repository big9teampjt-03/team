package hello.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import hello.model.Pet;
import hello.repository.PetRepository;

@Service
@Transactional
public class PetService {

	@Autowired
	private PetRepository pRepository;
	
	public void insert(Pet pet,String uploadFolder) {
		UUID uuid = UUID.randomUUID();
		MultipartFile p = pet.getUploadpet();
		String uploadFileName="";
		if(!p.isEmpty()) {
			uploadFileName=uuid.toString()+"_"+p.getOriginalFilename();
			File saveFile=new File(uploadFolder,uploadFileName);
			try {
				p.transferTo(saveFile);
				pet.setImagepet(uploadFileName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		pRepository.save(pet);
	}


	public void insert(Pet pet) {
		pRepository.save(pet);	
	}

	public List<Pet> list(Long userid) {
	      return pRepository.findAll();
	   }
	
	public Pet petdetail(Long petid) {
		return pRepository.findById(petid).get();
	}
}
