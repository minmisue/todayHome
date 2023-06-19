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
	public void insertMemberDetail(Member member) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertMemberAll(Member member) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int emailCheck(String email) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member readMemberById(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member readMemberByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMemberEnabled(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member updateMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member updateMemberDetail(Member member) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member updateAddress(Member member) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
