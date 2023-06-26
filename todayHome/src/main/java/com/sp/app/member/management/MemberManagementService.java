package com.sp.app.member.management;


import com.sp.app.domain.member.Member;

public interface MemberManagementService {
	
	void insertMember(Member member) throws Exception;
	
	void insertMemberDetail(Member member) throws Exception;
	
	void insertMemberAll(Member member) throws Exception;
	
	boolean emailCheck(String email) throws Exception;
	
	boolean nickNameCheck(String nickName) throws Exception;
	
	Member readMemberById(Long memberId) throws Exception;
	
	Member readMemberByEmail(String email) throws Exception;
	
	boolean updateMemberEnabled(Long memberId, int enabled) throws Exception;
	
	boolean updateMember(Member member) throws Exception;
	
	boolean updateMemberDetail(Member member) throws Exception;
	
	boolean updateAddress(Member member) throws Exception;

	void insertAddress(Member member) throws Exception;
	
	Member login(String email, String password);
}
