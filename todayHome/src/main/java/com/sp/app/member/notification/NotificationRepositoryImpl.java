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
		commonDAO.insertData("management.createNotification",notification);
	}

	@Override
	public int updateNotification(Notification notification) throws Exception {
		return commonDAO.updateData("management.updateNotification",notification);
		
	}

	@Override
	public void deleteNotification(Notification notification) throws Exception {
		commonDAO.deleteData("management.deleteNotification",notification);

		
	}

	@Override
	public int getNotReadNotificationCount(Long memberId) throws Exception {
		return commonDAO.selectOne("management.getNotReadNotificationCount", memberId);
	}

	@Override
	public List<Notification> getNotReadNotificationList(Long memberId) throws Exception {
		List<Notification> list = commonDAO.selectList("management.getNotReadNotificationList",memberId);
		return list;
	}

	
}
