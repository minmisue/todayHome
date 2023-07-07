package com.sp.app.member.notification;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sp.app.domain.member.Notification;
import com.sp.app.domain.member.NotificationParse;
import com.sp.app.member.management.MemberManagementRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class NotificationServiceImplTest {

	@Autowired
	NotificationService notificationService;

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	MemberManagementRepository memberManagementRepository;

	@Test
	public void createCommentNotification() throws Exception {
		Long memberId = 1L;
		int type = 1;
		String msg = "님이 댓글을 남겼어요.";
		String param1 = "62"; // 댓글 남긴 멤버 아이디
		String param2 = "1"; // 댓글 남긴 유저 보드 아이디.

		Notification notification = new Notification(memberId, type, msg, param1, param2, null);

		//notificationService.createNotification(notification);
	}

	@Test
	public void createCommentCommentNotification() throws Exception {
		Long memberId = 1L;
		int type = 2;
		String msg = "님이 답글을 남겼어요.";
		String param1 = "62"; // 댓글 남긴 멤버 아이디
		String param2 = "1"; // 댓글 남긴 유저 보드 아이디.


		Notification notification = new Notification(memberId, type, msg, param1, param2, null);

		//notificationService.createNotification(notification);
	}

	@Test
	public void createMentionNotification() throws Exception {
		Long memberId = 1L;
		int type = 3;
		String msg = "님이 회원님을 언급 했어요.";
		String param1 = "62"; // 댓글 남긴 멤버 아이디
		String param2 = "1"; // 댓글 남긴 유저 보드 아이디.

		Notification notification = new Notification(memberId, type, msg, param1, param2, null);

		//notificationService.createNotification(notification);
	}
	
	@Test
	public void likedNotification() throws Exception {
		Long memberId = 1L;
		int type = 4;
		String msg = "님이 좋아요를 눌렀어요.";
		String param1 = "2"; // 댓글 남긴 멤버 아이디
		String param2 = "1"; // 댓글 남긴 유저 보드 아이디.

		Notification notification = new Notification(memberId, type, msg, param1, param2, null);

		//notificationService.createNotification(notification);
	}

	@Test
	public void pointNotification() throws Exception {
		Long memberId = 1L;
		int type = 5;
		String msg = "님 포인트가 적립되었어요.";
		String param1 = "1000"; // 남은 포인트
		String param2 = "1"; // 댓글 남긴 유저 보드 아이디.

		Notification notification = new Notification(memberId, type, msg, param1, param2, null);

		//notificationService.createNotification(notification);
	}

	@Test
	public void followerNotification() throws Exception {
		Long memberId = 1L;
		int type = 6;
		String msg = "님이 팔로우 했어요.";
		String param1 = "62"; // 팔로우한 멤버 아이디
		String param2 = "10"; // 팔로우한 유저의 마이페이지

		Notification notification = new Notification(memberId, type, msg, param1, param2, null);

		//notificationService.createNotification(notification);
	}

	@Test
	public void updateNotification() {
	}

	@Test
	public void deleteNotification() {
	}

	@Test
	public void getNotReadNotificationList() throws Exception {
		Long memberId = 1L;

		List<NotificationParse> list = notificationService.getNotReadNotificationList(memberId);
		
		
		for (NotificationParse notificationParse : list) {
			System.out.println("--------------------------------------");
			String msg = notificationParse.getMsg();
			String nickName = notificationParse.getNickName();
			String bodyUri = notificationParse.getBodyUri();
			String profileImgName = notificationParse.getProfileImgName();
			String profileUri = notificationParse.getProfileUri();

			System.out.println(nickName + msg);

			System.out.println("profileUri = " + profileUri);
			System.out.println("bodyUri = " + bodyUri);
			System.out.println("profileImgName = " + profileImgName);
			System.out.println("--------------------------------------");
		}

	}

	@Test
	public void getNotReadNotificationCount() {


	}
}