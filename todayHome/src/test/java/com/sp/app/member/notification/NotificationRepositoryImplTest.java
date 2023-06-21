package com.sp.app.member.notification;

import com.sp.app.domain.member.Member;
import com.sp.app.domain.member.Notification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/appServlet/servlet-context.xml",
		"classpath:/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class NotificationRepositoryImplTest {

	@Autowired
	NotificationRepository notificationRepository;

	@Test
	public void createNotification() throws Exception{

		Long memberId = 62L;
		Notification notification = new Notification(memberId,1,"안녕안녕나는수댕이야","1","2","3");
		notificationRepository.createNotification(notification);
	}

	@Test
	public void updateNotification() throws Exception {
		Long memberId = 62L;
		Notification notification = new Notification(memberId,0,"안녕안녕","20201010",true,"3","2","1");
		notificationRepository.updateNotification(notification);
	}

	@Test
	public void deleteNotification() throws Exception{

	}

	@Test
	public void getNotReadNotificationCount() {
	}

	@Test
	public void getNotReadNotificationList() {
	}
}