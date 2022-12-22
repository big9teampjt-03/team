package hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Doctor;
import hello.repository.DoctorRepository;
import hello.repository.UserRepository;
import hello.service.DoctorService;
import hello.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {
	private final UserService uService;
	private final UserRepository uRepository;
	private final DoctorService dService;
	private final DoctorRepository dRepository;

	@GetMapping("/admin/userlist")
	public String userlist(Model model) {
		List<hello.model.User> lists = uService.list();
		model.addAttribute("lists", lists);
		return "/admin/userlist";
	}

	@GetMapping("/admin/userdetail/{userid}")
	public String userdetail(@PathVariable Long userid, Model model) {
		model.addAttribute("user", uService.detail(userid));
		return "/admin/userdetail";
	}

	@GetMapping("/admin/doctorlist")
	public String doctorlist(Model model) {
		// Long doctorid = doctor.getDoctorid();
		List<Doctor> lists = dService.list();
		model.addAttribute("lists", lists);
		return "/admin/doctorlist";
	}

	@GetMapping("/admin/docdetail/{doctorid}")
	public String docdetail(@PathVariable Long doctorid, Model model) {
		model.addAttribute("doctor", dService.detail(doctorid));
		return "/admin/docdetail";
	}

	@PutMapping("/admin/successappr")
	@ResponseBody
	public String successappr(@RequestBody Doctor doctor) {
		// System.out.println(doctor);
		dService.successappr(doctor);
		return "success";
	}

	@PutMapping("/admin/failappr")
	@ResponseBody
	public String failappr(@RequestBody Doctor doctor) {
		dService.failappr(doctor);
		return "success";
	}

	@PutMapping("/admin/drop")
	@ResponseBody
	public String drop(@RequestBody Doctor doctor) {
		dService.drop(doctor);
		return "success";
	}

	@DeleteMapping("/admin/delete/{userid}")
	@ResponseBody
	public Long delete(@PathVariable Long userid) {
		uService.delete(userid);
		return userid;
	}

}
