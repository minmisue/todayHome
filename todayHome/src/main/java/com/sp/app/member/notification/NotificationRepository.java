package com.sp.app.member.notification;

import java.util.List;

import com.sp.app.domain.member.Notification;

public interface NotificationRepository {
	
	void insertNotification(Notification notification) throws Exception;
	int updateNotification(Long memberId) throws Exception;
	void deleteNotification(Notification notification) throws Exception;
	List<Notification> getNotReadNotificationList(Long memberId) throws Exception;
	// 회원의 안읽은 알림 개수
	int getNotReadNotificationCount(Long memberId) throws Exception;
	void isReadupdateNotification(Long notificationId) throws Exception;
	
	
	
}
