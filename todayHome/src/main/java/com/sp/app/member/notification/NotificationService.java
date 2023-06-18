package com.sp.app.member.notification;

import com.sp.app.domain.member.Notification;

import java.util.List;

import com.sp.app.domain.member.Notification;

public interface NotificationService {
	void createNotification(Notification notification) throws Exception;
	void updateNotification(Notification notification) throws Exception;
	void deleteNotification(Notification notification) throws Exception;
	List<Notification> getNotificationList(Long memberId) throws Exception;
	// 회원의 알림 개수
	int getNotificationCount(Long memberId) throws Exception;
	// 회원의 안읽은 알림 개수
	int getNotReadNotificationCount(Long memberId) throws Exception;
}
