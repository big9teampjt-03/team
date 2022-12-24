package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.config.auth.PrincipalUser;
import hello.model.Doctor;
import hello.model.User;
import hello.service.DoctorService;

@Controller
public class DoctorController {
	
	@Autowired
	private DoctorService dService;
	
	@GetMapping("docinsert/{userid}")
	public String docinsert() {
		return "docinsert";
	}
	
	@PostMapping("docinsert/{userid}")
	@ResponseBody
	public ResponseEntity<String> docinsert(@PathVariable Long userid, 
			@RequestBody Doctor doctor,
			@AuthenticationPrincipal PrincipalUser principal) {
		User u = new User();
		u.setUserid(userid);
		doctor.setUser(u);
		doctor.setUser(principal.getUser());
		dService.insert(doctor);
		return new ResponseEntity<String>("success",HttpStatus.OK);
		}
	
	@GetMapping("docview/{doctorid}")
	public String docview(@PathVariable Long doctorid, Model model) {
		model.addAttribute("doctor", dService.docdetail(doctorid));
		return "docview";
		}
	
	@GetMapping("docupdate/{doctorid}")
	public String docupdate(@PathVariable Long doctorid, Model model) {
		model.addAttribute("doctor", dService.docdetail(doctorid));
		return "docupdate";
	}
	
	@PutMapping("docupdate")
	@ResponseBody
	public String docupdate(@RequestBody Doctor doctor) {
		dService.docupdate(doctor);
		return "success";
	}
	
}


