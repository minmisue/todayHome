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
			Long memberId = memberManagementRepository.getMemberSeq();
			member.setMemberId(memberId);
			
			
			memberManagementRepository.insertMember(member);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void insertMemberDetail(Member member) throws Exception {
		memberManagementRepository.insertMemberDetail(member);
		
	}

	@Override
	public void insertMemberAll(Member member) throws Exception {
		memberManagementRepository.insertMemberAll(member);
		
	}

	@Override
	public boolean emailCheck(String email) throws Exception {
		int result = memberManagementRepository.emailCheck(email);	
//		boolean check;
//		if(result == 1 ) {
//			check = true;
//		} else {
//			check = false;
//		}
//		
//	
//		return check;
		
		if(result == 1 ) {
			return true;
		} 
		
		return false;
		
	}

	@Override
	public Member readMemberById(Long memberId) throws Exception {
		return memberManagementRepository.readMemberById(memberId);
		
	}

	@Override
	public Member readMemberByEmail(String email) throws Exception {
		return memberManagementRepository.readMemberByEmail(email);
	}

	@Override
	public boolean updateMemberEnabled(Long memberId, int enabled) throws Exception {
		
		return true;
	}

	@Override
	public boolean updateMember(Member member) throws Exception {
		
		 int result = memberManagementRepository.updateMember(member);
		
			 return true;
		 }
		
		
	

	@Override
	public boolean updateMemberDetail(Member member) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateAddress(Member member) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void insertAddress(Member member) throws Exception {

	}


}
