package com.sp.app.member.notification;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.member.Notification;

@Repository 
public class NotificationRepositoryImpl implements NotificationRepository {

	@Autowired
	CommonDAO commonDAO;
	
	@Override
	public void createNotification(Notification notification) throws Exception {
		commonDAO.insertData("notification.createNotification",notification);
	}

	@Override
	public int updateNotification(Notification notification) throws Exception {
		return commonDAO.updateData("notification.updateNotification",notification);
		
	}

	@Override
	public void deleteNotification(Notification notification) throws Exception {
		commonDAO.deleteData("notification.deleteNotification",notification);

		
	}

	@Override
	public int getNotReadNotificationCount(Long memberId) throws Exception {
		return commonDAO.selectOne("notification.getNotReadNotificationCount", memberId);
	}

	@Override
	public List<Notification> getNotReadNotificationList(Long memberId) throws Exception {
		List<Notification> list = commonDAO.selectList("notification.getNotReadNotificationList",memberId);
		return list;
	}

	
}
