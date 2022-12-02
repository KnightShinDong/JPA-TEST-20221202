package com.sdhcompany.home;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdhcompany.home.dto.MemberDto;
import com.sdhcompany.home.repository.MemberRepository;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class JpaTest {

	@Autowired
	MemberRepository memberRepository;
	
//	@Test
//	@DisplayName("이름 검색 테스트")
//	public void searchName() {
//		
//		List<MemberDto> dtos = memberRepository.findByNameContaining("일");
//		
//		for(MemberDto memberDto : dtos) {
//			System.out.println(memberDto);
//		}
//	}
//	
////	@Test
////	@DisplayName("회원 삭제 테스트")
////	public void deleteMember() {
////		
////		Long hak =(long) 1;
////		
////		Optional<MemberDto> memberDto = memberRepository.findById(hak);
////		
////		assertTrue(memberDto.isPresent()); //존재여부 체크 -참이면 진행
////		
////		MemberDto dto =memberDto.get();
////		
////		memberRepository.delete(dto);
////		
////		
////		
////		List<MemberDto> dtos = memberRepository.findAll();
////		
////		for(MemberDto Dto : dtos) {
////			System.out.println(Dto);
////		}
////	}
//	@Test
//	@DisplayName("회원 삭제 테스트")
//	public void deleteMember() {
//		
//		Long hak =(long) 2;
//		
//		 memberRepository.deleteById(hak);
//		
//		
//		List<MemberDto> dtos = memberRepository.findAll();
//		
//		for(MemberDto Dto : dtos) {
//			System.out.println(Dto);
//		}
//	}
//	
//	@Test
//	@DisplayName("특정 회원 검색 테스트")
//	public void searchMember() {
//		
//		 List<MemberDto> memberDtos = memberRepository.findByNameLike("%일%"); //%동%, %신%
//		
//		for(MemberDto Dto : memberDtos) {
//			System.out.println(Dto);
//		}
//	}
//	
	@Test
	@DisplayName("특정 회원 삭제 테스트")
	public void deleteMember() {
	
		memberRepository.deleteByName("신동일");
		// memberRepository.deleteByName(3L); <--Long타입 텔리트시 숫자뒤에 L추가
		List<MemberDto> dtos = memberRepository.findAll();
		
		for(MemberDto Dto : dtos) {
			System.out.println(Dto);
		};
	}
	
	@Test
	@DisplayName("회원 정보 수정 테스트")
	public void modifyMember() {
		

	Long hak =(long) 1;
		Optional<MemberDto> memberDto = memberRepository.findById(3L);
	
	assertTrue(memberDto.isPresent()); //존재여부 체크 -참이면 진행
	
	MemberDto dto =memberDto.get();
	
	dto.setName("이순신");// 이름 수정
	
	memberRepository.save(dto);
	
	
	//전부 불러와 확인하기
	List<MemberDto> dtos = memberRepository.findAll();
	
	for(MemberDto Dto : dtos) {
		System.out.println(Dto);
		}
	}
	
}
