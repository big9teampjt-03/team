package hello.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.config.auth.PrincipalUser;
import hello.model.BoardCounsel;
import hello.model.Doctor;
import hello.service.BoardCounselService;
import hello.service.BoardService;
import hello.service.DoctorService;

@RequestMapping("/board/*")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService bservice;
	@Autowired
	private BoardCounselService bcservice;

	// 추천 수의사 목록 보기
	@GetMapping("boardDocList")
	public String boardDocList(Model model) {
	List<Doctor> dlist = bservice.list();
	model.addAttribute("lists", dlist);
		return"/board/boardDocList";
	}
	
	// 수의사 상세 정보
	@GetMapping("boardDocInfo/{doctorid}")
	public String boardDocInfo(@PathVariable Long doctorid, Model model) {
		model.addAttribute("doctor", bservice.docdetail(doctorid));
		return "/board/boardDocInfo";
	}

	// 지도 API
	@GetMapping("boardDocMap/{doctorid}")
	public String boardDocMap(@PathVariable Long doctorid, Model model) {
		model.addAttribute("doctor", bservice.docdetail(doctorid));
		return "/board/boardDocMap";
	}
	
}