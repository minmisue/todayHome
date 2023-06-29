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


		try {
			notificationRepository.insertNotification(notification);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public int updateNotification(Notification notification) throws Exception {
		int result = 0;
		try {
			result = notificationRepository.updateNotification(notification);


		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public void deleteNotification(Notification notification) throws Exception {

		try {
			notificationRepository.deleteNotification(notification);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<Notification> getNotReadNotificationList(Long memberId) throws Exception {
		try {
			return notificationRepository.getNotReadNotificationList(memberId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int getNotReadNotificationCount(Long memberId) throws Exception {
		int result = 0;

		try {
			result = notificationRepository.getNotReadNotificationCount(memberId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
}
