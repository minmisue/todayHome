package com.sp.app.member.notification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.member.Member;
import com.sp.app.domain.member.Notification;
import com.sp.app.domain.member.NotificationParse;
import com.sp.app.member.management.MemberManagementRepository;



@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	NotificationService notificationService;

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	MemberManagementRepository memberManagementRepository;
	
	
	
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
			List<Notification> list = notificationRepository.getNotReadNotificationList(memberId);

			List<NotificationParse> parseList = new ArrayList<>();

			for (Notification notification : list) {
				NotificationParse notificationParse = new NotificationParse();

				int type = notification.getType();
					
				if(type == 1) {
					String message = "님이 댓글을 남겼어요.";
					notificationParse.setMsg(message);
				}
				if(type == 2) {
					String message = "님이 답글을 남겼어요.";
					notificationParse.setMsg(message);
				}
				if(type == 3) {
					String message = "님이 회원님을 언급 했어요.";
					notificationParse.setMsg(message);
				}
				if(type == 4) {
					String message = "님이 좋아요를 눌렀어요.";
					notificationParse.setMsg(message);
				}
				if(type == 5) {
					String message = "님 포인트가 적립되었어요.";
					notificationParse.setMsg(message);
				}
				if(type == 6) {
					String message = "님이 팔로우 했어요.";
					notificationParse.setMsg(message);
				}
					
				if (type == 1 || type == 2 || type == 3 || type == 4) {
					Long commenterId = Long.valueOf(notification.getParameter1());
					Member member = memberManagementRepository.readMemberById(commenterId);

					System.out.println(member);

					String nickName = member.getNickName();
					String profileImgName = member.getProfileImgName();
					Long userBoardId = Long.valueOf(notification.getParameter2());
					String message = notification.getMessage();
					String bodyUri = "/board/" + userBoardId;
					// "/profile/memberId";
					String profileUri = "/profile/" + commenterId;

					notificationParse.setMemberId(commenterId);
					notificationParse.setMsg(message);
					notificationParse.setNickName(nickName);
					notificationParse.setProfileImgName(profileImgName);
					notificationParse.setBodyUri(bodyUri);
					notificationParse.setProfileUri(profileUri);
					notificationParse.setType(type);
				}

			}

			for (Notification notification : list) {
				NotificationParse notificationParse = new NotificationParse();

				int type = notification.getType();

				if (type == 5) {
					Long poinAmount = Long.valueOf(notification.getParameter1());
					Member member = memberManagementRepository.readMemberById(memberId);

					System.out.println(member);

					String nickName = member.getNickName();
					String profileImgName = member.getProfileImgName();
					Long pointPage = Long.valueOf(notification.getParameter2());
					String message = notification.getMessage();
					String bodyUri = "/board/" + pointPage;
					// "/profile/memberId";
					String profileUri = "/profile/" + poinAmount;

					notificationParse.setPointAmount(poinAmount);
					notificationParse.setMsg(message);
					notificationParse.setNickName(nickName);
					notificationParse.setProfileImgName(profileImgName);
					notificationParse.setBodyUri(bodyUri);
					notificationParse.setProfileUri(profileUri);
					notificationParse.setType(type);
				}

			}

			for (Notification notification : list) {
				NotificationParse notificationParse = new NotificationParse();

				int type = notification.getType();

				if (type == 6) {
					Long follower = Long.valueOf(notification.getParameter1());
					Member member = memberManagementRepository.readMemberById(follower);

					System.out.println(member);

					String nickName = member.getNickName();
					String profileImgName = member.getProfileImgName();
					Long followerPage = Long.valueOf(notification.getParameter2());
					String message = notification.getMessage();
					String bodyUri = "/board/" + followerPage;
					// "/profile/memberId";
					String profileUri = "/profile/" + follower;

					notificationParse.setMemberId(follower);
					notificationParse.setMsg(message);
					notificationParse.setNickName(nickName);
					notificationParse.setProfileImgName(profileImgName);
					notificationParse.setBodyUri(bodyUri);
					notificationParse.setProfileUri(profileUri);
					notificationParse.setType(type);
				}
				parseList.add(notificationParse);
			}

			for (NotificationParse notificationParse : parseList) {
				System.out.println("--------------------------------------");
				String msg = notificationParse.getMsg();
				String nickName = notificationParse.getNickName();
				String bodyUri = notificationParse.getBodyUri();
				String profileImgName = notificationParse.getProfileImgName();
				String profileUri = notificationParse.getProfileUri();

				System.out.println(nickName + msg);

				System.out.println("profileUri = " + profileUri);
				System.out.println("bodyUri = " + bodyUri);
				System.out.println("profileImgName = " + profileImgName);
				System.out.println("--------------------------------------");
			}
			
			return list;
			
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
