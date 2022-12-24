package hello.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hello.config.auth.PrincipalUser;
import hello.model.Pet;
import hello.model.User;
import hello.repository.PetRepository;
import hello.service.PetService;
import hello.service.UserService;

@Controller
public class PetController {

	@Autowired
	private PetRepository pRepository;
	@Autowired
	private PetService pService;
	@Autowired
	private UserService uService;

	// 애완동물 등록폼
	@GetMapping("pet/{userid}")
	@PreAuthorize("isAuthenticated()")
	public String pet(@PathVariable Long userid, Model model) {
		// model.addAttribute("petid",pService.insert(pet));
		return "pet";
	}

	// 등록생성
	@PostMapping("pet")
	public String petjoin(Pet pet, @AuthenticationPrincipal PrincipalUser principal, HttpSession session)
			throws ParseException {
		String uploadFolder = session.getServletContext().getRealPath("/") + "\\resources\\img";
		User user = principal.getUser();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date to = format.parse(pet.getPetbirths());
		pet.setPetbirth(to);
		System.out.println("pet.getPetbirth() :" + pet.getPetbirth());
		pet.setUser(user);
		pService.insert(pet, uploadFolder);
		return "redirect:/petlist/";
	}

//	@GetMapping("petlist/{puser}")
//	@PreAuthorize("isAuthenticated()")
//	public String petlist(@PathVariable Long puser ,Model model) {
//	  List<User> user =   uService.list(puser);
//	  model.addAttribute("user",user);
//		return "petlist";
//	}

	@GetMapping("petlist/{petid}")
	public String petlist(@PathVariable Long petid, Model model) {
		model.addAttribute("pet", pService.petdetail(petid));
		return "petlist";
	}

}
