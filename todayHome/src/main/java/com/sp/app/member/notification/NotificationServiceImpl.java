package com.sp.app.member.notification;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.app.domain.member.Notification;



@Service
public class NotificationServiceImpl implements NotificationService {

	@Override
	public void createNotification(Notification notification) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNotification(Notification notification) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNotification(Notification notification) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Notification> getNotReadNotificationList(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNotReadNotificationCount(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
