package com.sp.app.member.notification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		// commonDAO.insertData("management.insertProduct", notification);
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("productId", 1L);
		map.put("imgName", "img1");
		
		commonDAO.insertData("management.insertProductImg",map);
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
	public int getNotReadNotificationCount(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Notification> getNotReadNotificationList(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
