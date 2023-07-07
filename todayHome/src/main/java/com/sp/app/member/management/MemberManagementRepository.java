package com.sp.app.member.management;


import java.util.List;

import com.sp.app.domain.member.Member;

public interface MemberManagementRepository {

	Long getMemberSeq() throws Exception;
	
	void insertMember(Member member) throws Exception;
	
	void insertMemberDetail(Member member) throws Exception;
	
	void insertMemberAll(Member member) throws Exception;
	
	int emailCheck(String email) throws Exception;
	
	int nickNameCheck(String nickName) throws Exception;
	
	Member readMemberById(Long memberId) throws Exception;
	
	Member readMemberByEmail(String email) throws Exception;
	
	int updateMemberEnabled(Long memberId, int enabled) throws Exception;
	
	int updateMember(Member member) throws Exception;
	
	int updateMemberDetail(Member member) throws Exception;
	
	int updateAddress(Member member) throws Exception;

	void insertAddress(Member member) throws Exception;
	
	List<Member> findMembersByNickname(String nickName) throws Exception; 
	
	List<Member> findMembersByCondition(List<Integer> memberRoleIdList, String keyword, String condition, String sort) throws Exception; 
	
	
}
