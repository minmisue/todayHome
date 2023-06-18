package com.sp.app.member.management;

import java.util.Map;

import com.sp.app.domain.member.Member;

public interface MemberManagementRepository {
	
	public void insertMember(Member member) throws Exception;
	
	public void updateLastLogin(Long memberId) throws Exception;
	
	public void updateMember(Member member) throws Exception;
	
	public Member readMember(String email);
	
	public void deleteMember(Map<String, Object> map) throws Exception;
	
	public void generatePwd(Member member) throws Exception;

}
