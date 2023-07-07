package com.sp.app.member.management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.member.Member;

@Service
public class MemberManagementServiceImpl implements MemberManagementService {

	@Autowired
	MemberManagementRepository memberManagementRepository;

	@Override
	public Member login(String email, String password) {
		Member member;

		try {
			member = memberManagementRepository.readMemberByEmail(email);

			if (member == null) {
				return null;
			}

			if (!password.equals(member.getPassword())) {
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
			throw e;
		}

	}

	@Override
	public void insertMemberDetail(Member member) throws Exception {

		memberManagementRepository.insertMemberDetail(member);

	}

	@Override
	public void insertMemberAll(Member member) throws Exception {
		try {
			Long memberId = memberManagementRepository.getMemberSeq();
			member.setMemberId(memberId);

			memberManagementRepository.insertMemberAll(member);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
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

		if (result == 1) {
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
		int result = memberManagementRepository.updateMemberEnabled(memberId, enabled);

		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateMember(Member member) throws Exception {

		int result = memberManagementRepository.updateMember(member);

		if (result == 1) {
			return true;
		}
		return false;

	}

	@Override
	public boolean updateMemberDetail(Member member) throws Exception {
		int result = memberManagementRepository.updateMemberDetail(member);

		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAddress(Member member) throws Exception {
		int result = memberManagementRepository.updateMemberDetail(member);

		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public void insertAddress(Member member) throws Exception {
		memberManagementRepository.insertAddress(member);
	}

	@Override
	public boolean nickNameCheck(String nickName) throws Exception {
		int result = memberManagementRepository.nickNameCheck(nickName);
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<Member> findMembersByNickname(String nickName) throws Exception {
		List<Member> result = null;
		try {
			result = memberManagementRepository.findMembersByNickname(nickName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}



	@Override
	public List<Member> findMembersByCondition(List<Integer> memberRoleIdList, String keyword, String condition, String sort)
			throws Exception {
		List<Member> result = null;
		try {
			result = memberManagementRepository.findMembersByCondition(memberRoleIdList, keyword, condition, sort);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	
}
