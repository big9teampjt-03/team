package petcare.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import petcare.model.Member;
import petcare.repository.MemberRepository;


@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	
	
	public Member detail(Long member_id) {
		return memberRepository.findById(member_id).get();
	}
	
	/*
	 * public List<User>list(){ return userRepository.findAll();//findAll은 전체를 보게하는
	 * 함수 이름. 내장되어있음 } }
	 */
	 
	
	  public Page<Member> findAll(Pageable pageable) {  
	Page<Member> member = memberRepository.findAll(pageable);// 아무 검색 없을때
	  return member; 
	  }
	 
}
