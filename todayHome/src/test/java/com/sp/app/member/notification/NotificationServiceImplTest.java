package com.sp.app.member.notification;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class NotificationServiceImplTest {

	@Autowired
	NotificationService notificationService;

	@Test
	public void createNotification() {


	}

	@Test
	public void updateNotification() {
	}

	@Test
	public void deleteNotification() {
	}

	@Test
	public void getNotReadNotificationList() {
	}

	@Test
	public void getNotReadNotificationCount() {
	}
}