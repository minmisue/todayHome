package com.sp.app.member.management;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.member.Member;

@Service
public class MemberManagementServiceImpl implements MemberManagementService{

	
	@Autowired
	MemberManagementRepository memberManagementRepository;
	
	@Override
	public Member login(String email, String password) {
		Member member;
		
		try {
			member = memberManagementRepository.readMemberByEmail(email);
			
			if(member == null) {
				return null;
			} 
			
			if(! password.equals(member.getPassword())) {
				return null;
			}
			return member;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public void insertMember(Member member) throws Exception {
		
		
		try {
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertMemberDetail(Member member) throws Exception {
		
		
	}

	@Override
	public void insertMemberAll(Member member) throws Exception {
		
		
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
	public void updateMemberEnabled(Long memberId, int enabled) throws Exception {
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

	@Override
	public void insertAddress(Member member) throws Exception {

	}


}
