package petcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import petcare.model.Admin;
import petcare.model.Doctor;
import petcare.model.Member;
import petcare.repository.AdminRepository;
import petcare.repository.DoctorRepository;
import petcare.repository.MemberRepository;
import petcare.service.AdminService;
import petcare.service.DoctorService;
import petcare.service.MemberService;

@Controller
@RequiredArgsConstructor
public class HomeController {
	private final MemberService mService;
	private final MemberRepository mRepository;
	private final DoctorService dService;
	private final DoctorRepository dRepository;
	private final AdminService aService;
	private final AdminRepository aRepository;
	
	@GetMapping("/")
	public String home(){
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("joinForm")
	public String beforeJoin() {
		return("joinForm");
	}
	
	@GetMapping("memberJoin")
	public String memberjoin() {
		return "memberJoin";
	}
	
	@PostMapping("memberJoin")
	@ResponseBody
	public String memberjoin(@RequestBody Member member) {
		if(mRepository.findByUsername(member.getUsername())!=null) {
		return "fail";
		}
		mService.save(member);
		return "success";
	}
	
	@GetMapping("doctorJoin")
	public String doctorjoin() {
		return "doctorJoin";
	}
	
	@PostMapping("doctorJoin")
	@ResponseBody
	public String doctorjoin(@RequestBody Doctor doctor) {
		if(dRepository.findByUsername(doctor.getUsername())!=null) {
		return "fail";
		}
		dService.save(doctor);
		return "success";
	}
	
	@GetMapping("adminJoin")
	public String adminjoin() {
		return "adminJoin";
	}
	
	@PostMapping("adminJoin")
	@ResponseBody
	public String adminjoin(@RequestBody Admin admin) {
		if(aRepository.findByUsername(admin.getUsername())!=null) {
		return "fail";
		}
		aService.save(admin);
		return "success";
	}

}