package com.sp.app.member.management;

import java.util.Map;

import com.sp.app.domain.member.Member;

public interface MemberManagementRepository {
	
	void insertMember(Member member) throws Exception;
	
	void insertMemberDetail(Member member) throws Exception;
	
	void insertMemberAll(Member member) throws Exception;
	
	int emailCheck(String email) throws Exception;
	
	Member readMemberById(Long memberId) throws Exception;
	
	Member readMemberByEmail(String email) throws Exception;
	
	void updateMemberEnabled(Map<String, Object> map) throws Exception;
	
	Member updateMember(Member member) throws Exception;
	
	Member updateMemberDetail(Member member) throws Exception;
	
	Member updateAddress(Member member) throws Exception;

}
