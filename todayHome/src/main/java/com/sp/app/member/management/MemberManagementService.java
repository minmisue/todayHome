package com.sp.app.member.management;

import java.util.Map;

import com.sp.app.domain.member.Member;

public interface MemberManagementService {
	
	public void insertMember(Member member) throws Exception;
	
	public void updateLastLogin(Long memberId) throws Exception;
	
	public void updateMember(Member member) throws Exception;
	
	public Member readMember(String email);
	
	public void deleteMember(Map<String, Object> map) throws Exception;
	
	public void generatePwd(Member member) throws Exception;
	//임시 10자리 패스워드 생성 

	Member loginMember(String email);
}
