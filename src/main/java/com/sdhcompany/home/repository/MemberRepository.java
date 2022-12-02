package com.sdhcompany.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdhcompany.home.dto.MemberDto;

public interface MemberRepository extends JpaRepository<MemberDto, Long>{ //< 엔티티 클래스 타입, 기본키의 타입

	public List<MemberDto> findByName(String memberName);
	public List<MemberDto> findByHakbun(Long hakbun);
	public List<MemberDto> findByNameOrderByHakbunDesc(String memberName);

	public List<MemberDto> findAllByOrderByHakbunDesc();
	
	public List<MemberDto> findByNameOrGrade(String memberName, int grade);
	
	public List<MemberDto> findByAgeLessThan(int age);//미만 <
	public List<MemberDto> findByAgeLessThanEqual(int age);//이하 <=
	public List<MemberDto> findByAgeGreaterThan(int age);//초과 >
	public List<MemberDto> findByAgeGreaterThanEqual(int age);//이상 >=
	public List<MemberDto> findByAgeBetween(int age, int age2);// a 와 b 사이
	public List<MemberDto> findByNameStartingWith(String namekey); //특정문자 시작
	public List<MemberDto> findByNameEndingWith(String namekey); //특정문자 끝남
	public List<MemberDto> findByNameContaining(String namekey); //특정문자 포함
	public List<MemberDto> findByNameLike(String namekey); //특정문자 포함
	
	//데이터 삭제(delete)
	public void deleteByName(String name); //이름으로 조회 삭제
}
