package com.sp.app.member.management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.member.Member;

@Repository("MemberRepository")
public class MemberManagementRepositoryImpl implements MemberManagementRepository {

	@Autowired
	CommonDAO commonDAO;

	@Override
	public Long getMemberSeq() throws Exception {
		return commonDAO.selectOne("management.getMemberSeq");
	}

	@Override
	public void insertMember(Member member) throws Exception {
		commonDAO.insertData("management.insertMember", member);
		
	}

	@Override
	public void insertMemberDetail(Member member) throws Exception {
		commonDAO.insertData("management.insertMemberDetail", member);
		
	}

	@Override
	public void insertMemberAll(Member member) throws Exception {
		commonDAO.insertData("management.insertMemberAll", member);
		
	}

	@Override
	public int emailCheck(String email) throws Exception {
		return commonDAO.selectOne("management.emailCheck", email);
	}

	@Override
	public Member readMemberById(Long memberId) throws Exception {
		return commonDAO.selectOne("management.readMemberById", memberId);
	}

	@Override
	public Member readMemberByEmail(String email) throws Exception {
		return commonDAO.selectOne("management.readMemberByEmail", email);

	}

	@Override
	public int updateMemberEnabled(Long memberId, int enabled) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("enabled", enabled);
		
		return commonDAO.updateData("management.updateMemberEnabled",map);
	}

	@Override
	public int updateMember(Member member) throws Exception {
	
		return commonDAO.updateData("management.updateMember", member);
		 
	}

	@Override
	public int updateMemberDetail(Member member) throws Exception {
		return commonDAO.updateData("management.updateMemberDetail", member);
	}

	@Override
	public int updateAddress(Member member) throws Exception {
		return commonDAO.updateData("management.updateAddress", member);
	}

	@Override
	public void insertAddress(Member member) throws Exception {
		commonDAO.updateData("management.insertAddress",member);
	}

	@Override
	public int nickNameCheck(String nickName) throws Exception {
		return commonDAO.selectOne("management.nickNameCheck",nickName );
		
	}

	@Override
	public List<Member> findMembersByNickname(String nickName) throws Exception {
		return commonDAO.selectList("management.findMembersByNickname", nickName);
	}

	@Override
	public List<Member> findMembersByCondition(List<Integer> memberRoleIdList, String keyword, String condition ,String sort)
			throws Exception {
		Map<String, Object> map = new HashMap<>();
		
		map.put("memberRoleIdList", memberRoleIdList);
		map.put("keyword", keyword);
		map.put("condition", condition);
		map.put("sort", sort);
		
		return commonDAO.selectList("management.findMembersByCondition", map);
	
	}

	@Override
	public void updateMemberPwd(Member member) throws Exception {
		commonDAO.updateData("management.updateMemberPwd", member);
	}
}
