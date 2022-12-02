package com.sdhcompany.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdhcompany.home.dto.MemberDto;
import com.sdhcompany.home.repository.MemberRepository;

@Controller
public class HomeController {

	@Autowired
	MemberRepository memberRepository;
	
	@RequestMapping(value = "/join")
	public String join() {
	
		return "join";
	}
	
	
	@RequestMapping(value = "/joinOk")
	public String join(HttpServletRequest request, Model model) {
		
		String name =  request.getParameter("name");
		int age =  Integer.parseInt(request.getParameter("age"));
		int grade = Integer.parseInt(request.getParameter("grade"));
		String etc =  request.getParameter("etc");
		
		MemberDto memberDto = new MemberDto();
		
		memberDto.setName(name);
		memberDto.setAge(age);
		memberDto.setGrade(grade);
		memberDto.setEtc(etc);
		
		MemberDto mDto = memberRepository.save(memberDto);
		
		System.out.println(mDto.toString());
		
		model.addAttribute("mDto", mDto);
		
		return "joinOk";
	}
	
	@RequestMapping(value = "/searchOk")
	public String search(Model model, HttpServletRequest request) {
		
		
		// List<MemberDto> memberDtos =  memberRepository.findByName(request.getParameter("searchName"));
		List<MemberDto> memberDtos =  memberRepository.findByNameOrderByHakbunDesc(request.getParameter("searchName"));
			
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		model.addAttribute("searchDtos", memberDtos);
		
		return "searchResult";
	}
	@RequestMapping(value = "/search")
	public String search() {
	
		return "search";
	}
	
	@RequestMapping(value = "allmember")
	public String allmember(Model model) {
		
		List<MemberDto> dtos = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "hakbun"));
		
		List<MemberDto> dtos2 = memberRepository.findAllByOrderByHakbunDesc();
		
		model.addAttribute("allmember", dtos2);
		
		return "allmember";
	}
	
	@RequestMapping(value = "memberOr")
	public String memberOr() {
		
		List<MemberDto> memberDtos = memberRepository.findByNameOrGrade("신동헌", 100);
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		return "";
	}
	@RequestMapping(value = "lessthan")
	public String lessthan() {
		
		List<MemberDto> memberDtos = memberRepository.findByAgeLessThan(100);
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		
		return "";
	}
	@RequestMapping(value = "between")
	public String between() {
		
		List<MemberDto> memberDtos = memberRepository.findByAgeBetween(10,100);
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		
		return "";
	}
	@RequestMapping(value = "like")
	public String like() {
		
		List<MemberDto> memberDtos = memberRepository.findByNameStartingWith("신");
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		
		return "";
	}
}
