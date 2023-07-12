package com.sp.app.member.notification;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.common.SessionInfo;
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
	public void createNotification(Notification notification, HttpSession session) throws Exception {
		
		try {
				SessionInfo sessionInfo = (SessionInfo)session.getAttribute("sessionInfo");
				if(sessionInfo != null) {
					notificationRepository.insertNotification(notification);
					Long memberId = sessionInfo.getMemberId();		
					int notificationCount = notificationRepository.getNotReadNotificationCount(memberId);
					session.setAttribute("notificationCount", notificationCount);
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

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
	public List<NotificationParse> getNotReadNotificationList(Long memberId) throws Exception {
		LocalDate currentDate = LocalDate.now();
		try {
			List<Notification> list = notificationRepository.getNotReadNotificationList(memberId);

			List<NotificationParse> parseList = new ArrayList<>();



			for (Notification notification : list) {
				String message = "";

				NotificationParse notificationParse = new NotificationParse();

				int type = notification.getType();
				System.out.println("type = " + type);

				if (type == 1) {
					message = "님이 댓글을 남겼어요.";
				} else if (type == 2) {
					message = "님이 답글을 남겼어요.";
				} else if (type == 3) {
					message = "님이 회원님을 언급 했어요.";
				} else if (type == 4) {
					message = "님이 좋아요를 눌렀어요.";
				} else if (type == 5) {
					message = "님 " + notification.getParameter1() + " 포인트가 적립되었어요.";
				} else if (type == 6) {
					message = "님이 팔로우 했어요.";
				}

				notificationParse.setMsg(message);

				if (type == 1 || type == 2 || type == 3 || type == 4) {
					Long commenterId = Long.valueOf(notification.getParameter1());
					Member member = memberManagementRepository.readMemberById(commenterId);

					System.out.println(member);

					Long notificationId = notification.getNotificationId();
					String nickName = member.getNickName();
					String profileImgName = member.getProfileImgName();
					Long userBoardId = Long.valueOf(notification.getParameter2());
					String bodyUri = "/community/picture/picture-article?userBoardId=" + userBoardId;
					// "/profile/memberId";
					String profileUri = "/mypage/" + commenterId;
					String regDate = notification.getRegDate();
					LocalDate targetDate = LocalDate.parse(regDate);
					long daysBetween = ChronoUnit.DAYS.between(targetDate, currentDate);
					regDate = Long.toString(daysBetween);

					notificationParse.setMemberId(commenterId);
					notificationParse.setNickName(nickName);
					notificationParse.setProfileImgName(profileImgName);
					notificationParse.setBodyUri(bodyUri);
					notificationParse.setProfileUri(profileUri);
					notificationParse.setType(type);
					notificationParse.setRegDate(regDate);
					notificationParse.setNotificationId(notificationId);

				} else if (type == 5) {
					Long pointAmount = Long.valueOf(notification.getParameter1());
					Member member = memberManagementRepository.readMemberById(memberId);

					Long notificationId = notification.getNotificationId();
					String nickName = member.getNickName();
					String profileImgName = member.getProfileImgName();
					String bodyUri = "/mypage/point";
					// "/profile/memberId";
					String profileUri = "/mypage/" + memberId;
					String regDate = notification.getRegDate();
					LocalDate targetDate = LocalDate.parse(regDate);
					long daysBetween = ChronoUnit.DAYS.between(targetDate, currentDate);
					regDate = Long.toString(daysBetween);

					notificationParse.setPointAmount(pointAmount);
					notificationParse.setNickName(nickName);
					notificationParse.setProfileImgName(profileImgName);
					notificationParse.setBodyUri(bodyUri);
					notificationParse.setProfileUri(profileUri);
					notificationParse.setType(type);
					notificationParse.setRegDate(regDate);
					notificationParse.setNotificationId(notificationId);

				} else if (type == 6) {

					Long follower = Long.valueOf(notification.getParameter1());
					Member member = memberManagementRepository.readMemberById(follower);

					System.out.println(member);

					Long notificationId = notification.getNotificationId();
					String nickName = member.getNickName();
					String profileImgName = member.getProfileImgName();
					Long followerPage = Long.valueOf(notification.getParameter2());
					String bodyUri = "/mypage/" + followerPage;
					// "/profile/memberId";
					String profileUri = "/mypage/" + follower;
					String regDate = notification.getRegDate();
					LocalDate targetDate = LocalDate.parse(regDate);
					long daysBetween = ChronoUnit.DAYS.between(targetDate, currentDate);
					regDate = Long.toString(daysBetween);

					notificationParse.setMemberId(follower);
					notificationParse.setNickName(nickName);
					notificationParse.setProfileImgName(profileImgName);
					notificationParse.setBodyUri(bodyUri);
					notificationParse.setProfileUri(profileUri);
					notificationParse.setType(type);
					notificationParse.setRegDate(regDate);
					notificationParse.setNotificationId(notificationId);
				}

				parseList.add(notificationParse);
			}

			System.out.println(parseList);

			return parseList;

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

	@Override
	public boolean updateNotification(Long memberId) throws Exception {
		int result = notificationRepository.updateNotification(memberId);
		if (result == 1) {
			return true;

		} else {
			return false;
		}

	}

	@Override
	public void isReadupdateNotification(Long notificationId, HttpSession session) throws Exception {
		try {
			SessionInfo sessionInfo = (SessionInfo)session.getAttribute("sessionInfo");
			if(sessionInfo != null ) {
			 notificationRepository.isReadupdateNotification(notificationId);
			 Long memberId = sessionInfo.getMemberId();
			 int notificationCount = notificationRepository.getNotReadNotificationCount(memberId);
				session.setAttribute("notificationCount", notificationCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		

	}

}
