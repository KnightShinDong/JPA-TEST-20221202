package com.sdhcompany.home.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA
@Entity    //MemberDto 클래스를 엔티티로 선언
@Table(name = "jpa_table")  //엔티티와 매핑 할 테이블 이름을 지정
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
   
   @Id    //매핑된 테이블의 기본키로 설정
   @Column(name = "hakbun")   //테이블의 필드와 매핑
   @GeneratedValue(strategy = GenerationType.AUTO)  //기본키 생성전략
   private Long hakbun;      //학번 기본키 --기본키는 Long을 보편적으로 사용한다
   
   @Column(name = "name", nullable = false, length = 20 )   //nullable null값 허용 여부
   private String name;   //이름
   
   @Column(name = "age")
   private int age;      //나이
   
   @Column(name = "grade")
   private int grade;      //학년
   
   @Column(name = "etc", length = 50)
   private String etc;      //기타 학생 비고 설명
   
}