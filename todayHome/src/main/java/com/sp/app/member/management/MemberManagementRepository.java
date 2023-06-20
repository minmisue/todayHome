package com.sp.app.member.management;


import com.sp.app.domain.member.Member;

public interface MemberManagementRepository {

	Long getMemberSeq() throws Exception;
	
	void insertMember(Member member) throws Exception;
	
	void insertMemberDetail(Member member) throws Exception;
	
	void insertMemberAll(Member member) throws Exception;
	
	int emailCheck(String email) throws Exception;
	
	Member readMemberById(Long memberId) throws Exception;
	
	Member readMemberByEmail(String email) throws Exception;
	
	void updateMemberEnabled(Long memberId, int enabled) throws Exception;
	
	int updateMember(Member member) throws Exception;
	
	int updateMemberDetail(Member member) throws Exception;
	
	int updateAddress(Member member) throws Exception;

}
