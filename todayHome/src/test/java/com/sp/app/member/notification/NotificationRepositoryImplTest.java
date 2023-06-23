package com.sp.app.member.notification;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sp.app.domain.member.Notification;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/appServlet/servlet-context.xml",
		"classpath:spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class NotificationRepositoryImplTest {

	@Autowired
	NotificationRepository notificationRepository;

	@Test
	public void createNotification() throws Exception{

		Long memberId = 62L;
		Notification notification = new Notification(null, memberId,1,"안녕안녕나는수댕이야","1","2","3");
		notification.setMemberId(memberId);
		notificationRepository.insertNotification(notification);
	}

	@Test
	public void updateNotification() throws Exception {
		Long notificationId = 1L;
		Notification notification = new Notification(notificationId, null,0,"안녕안녕", "3","2","1");
		notificationRepository.updateNotification(notification);
	}

	@Test
	public void deleteNotification() throws Exception{
		Long notificationId = 1L;
		Notification notification = new Notification(notificationId);
		notificationRepository.deleteNotification(notification);
	}

	@Test
	public void getNotReadNotificationCount() throws Exception {
		// 필요한 값 
		Long memberId = 1L;
		
		
		// 테스트 할 메서드 
		int result = notificationRepository.getNotReadNotificationCount(memberId);
		
		
		
		// 결과 (int 갯수?)
		Assert.assertEquals(5, result);
		
	}

	@Test
	public void getNotReadNotificationList() throws Exception {
		// 필요한 값 
		Long memberId = 62L;
				
				
		// 테스트 할 메서드 
		List<Notification> list = notificationRepository.getNotReadNotificationList(memberId);
		
		
		// 결과
		for(Notification notification : list) {
			System.out.println(notification);
		}
		
		
		
		
	}
}