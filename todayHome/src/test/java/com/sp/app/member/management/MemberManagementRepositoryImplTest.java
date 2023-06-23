package com.sp.app.member.management;

import com.sp.app.domain.member.Member;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class MemberManagementRepositoryImplTest {

	@Autowired
	MemberManagementRepository memberManagementRepository;

	@Before
	public void hello() {

	}

	@After
	public void after() {

	}

	@Test
	public void getMemberSeq() throws Exception {
		Long seq = memberManagementRepository.getMemberSeq();

		System.out.println(seq);
	}

	@Test
	public void insertMember() throws Exception {
		Long seq = memberManagementRepository.getMemberSeq();

		Member member = new Member(seq, "example@gmail.com", "John Doe", "123456789", "johndoe", "password123", "profile.jpg", "Some info");

		memberManagementRepository.insertMember(member);
	}

	@Test
	public void insertMemberDetail() throws Exception {
//		Long seq = memberManagementRepository.getMemberSeq();
//
//		Member member = new Member(seq, "example@gmail.com", "John Doe", "123456789", "johndoe", "password123", "profile.jpg", "Some info");
//
//		memberManagementRepository.insertMemberDetail(member);
	}

	@Test
	public void insertMemberAll() throws Exception {
		Long seq = memberManagementRepository.getMemberSeq();
		Member member = new Member(seq, "example@gmail.com2", "John Doe2", "123456789", "johndoe", "password123", "profile.jpg", "Some info");

		memberManagementRepository.insertMemberAll(member);

	}

	@Test
	public void comInsert() throws Exception {
		Long seq = memberManagementRepository.getMemberSeq();

		Member member = new Member(seq, "example@gmail.com3", "John Doe3", "123456789", "johndoe", "password123", "profile.jpg", "Some info");

		memberManagementRepository.insertMemberDetail(member);
	}

	@Test
	public void emailCheck() throws Exception {
		int result = memberManagementRepository.emailCheck("ss@");
		Assert.assertEquals(1, result);
	}

	@Test
	public void readMemberById() throws Exception {
		Long memberId = 62L;

		Member member = memberManagementRepository.readMemberById(memberId);

		System.out.println(member);
	}

	@Test
	public void readMemberByEmail() throws Exception {
		String email = "abc;";
		String pwd = "123";

		Member member = memberManagementRepository.readMemberByEmail(email);

		// 무슨뜻이야
		// 디비에 입력받은 이메일 존재하지 않음
		if (member == null) {
			// 여기선 그냥 끝냄
			System.out.println("로그인 실패");
			return;
		}

		// 입력받은 패스워드와 이메일로 찾은 멤버의 패스워드가 같으면
		if (member.getPassword().equals(pwd)) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}

	@Test
	public void updateMemberEnabled() throws Exception {

		memberManagementRepository.updateMemberEnabled(62L, 1);

	}


	@Test
	public void updateMember() throws Exception {
		Long memberId = 62L;
		Member member = new Member(memberId, 0, "01012341234", "12341234");
		memberManagementRepository.updateMember(member);

	}

	@Test
	public void updateMemberDetail() throws Exception {
		Long memberId = 62L;
		Member member = new Member(memberId, "수댕이", "1234", "미ㅏㄴㅇ", "하이하잏");
		memberManagementRepository.updateMemberDetail(member);

	}

	@Test
	public void insertAddress() throws Exception {
		Long memberId = 62L;
		Member member = new Member(memberId, "1234","12","34");
		memberManagementRepository.insertAddress(member);


	}
	@Test
	public void updateAddress() throws Exception {
		Long memberId = 62L;
		Member member = new Member(memberId, "12","34","56");
		memberManagementRepository.updateAddress(member);
	}
}