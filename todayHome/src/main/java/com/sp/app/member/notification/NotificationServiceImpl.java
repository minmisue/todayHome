package com.sp.app.member.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.member.Notification;



@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	NotificationRepository notificationRepository;
	

	@Override
	public void createNotification(Notification notification) throws Exception {
		// commonDAO.insertData("managemnt.insert", noficaiton);
		
		//notificationRepository.createNotification(notification);
		
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
	public List<Notification> getNotificationList(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNotificationCount(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNotReadNotificationCount(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
