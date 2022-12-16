package petcare.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public class MemberController {
		private final MemberService mService;
		private final MemberRepository mRepository;

		

		
		
		
		
		@GetMapping("/member/memberlist")
		public String list(Model model,
				@PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable) {
			Page<Member> lists = mService.findAll(pageable);
			model.addAttribute("count", mService.count());
			model.addAttribute("members", lists);
			return "list";
		}
	}
