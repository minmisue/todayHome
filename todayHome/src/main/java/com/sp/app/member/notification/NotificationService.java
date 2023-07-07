package com.sp.app.member.notification;

import java.util.List;

import com.sp.app.domain.member.Notification;
import com.sp.app.domain.member.NotificationParse;

public interface NotificationService {
	
	void createNotification(Notification notification) throws Exception;
	boolean updateNotification(Long memberId) throws Exception;
	void deleteNotification(Notification notification) throws Exception;
	List<NotificationParse> getNotReadNotificationList(Long memberId) throws Exception;
	// 회원의 안읽은 알림 개수
	int getNotReadNotificationCount(Long memberId) throws Exception;
	void isReadupdateNotification(Long notificationId) throws Exception;
}
