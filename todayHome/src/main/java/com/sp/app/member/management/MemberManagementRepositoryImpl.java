package com.sp.app.member.management;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sp.app.domain.member.Member;

@Repository
public class MemberManagementRepositoryImpl implements MemberManagementRepository {

	@Override
	public void insertMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLastLogin(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member readMember(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMember(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generatePwd(Member member) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
