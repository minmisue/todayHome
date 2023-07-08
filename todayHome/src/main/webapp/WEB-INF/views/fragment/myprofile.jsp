<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<c:choose>
			<c:when test="${sessionScope.sessionInfo.memberId == member.memberId}">
			<div class="myinfo-wrapper">
				<div class="myinfo">
					<div class="myinfo-profile">
						<div class="share-icon">
							<i class="bi bi-share"></i>
						</div>
						<div class="image-wrapper">
							<img alt="" src="${pageContext.request.contextPath}/resources/picture/member/${member.profileImgName}">
						</div>
						<h2>${member.nickName}</h2>
						<dl class="follow-wrapper">
							<dt class="follower">팔로워</dt>
							<dd class="follower-data" onclick="location.href='${pageContext.request.contextPath}/mypage/${member.memberId }/follower'">${followerCount}</dd>
							<dt class="following">팔로잉</dt>
							<dd class="follower-data" onclick="location.href='${pageContext.request.contextPath}/mypage/${member.memberId }/followee'">${followeeCount}</dd>
						</dl>
						<button class="setting" type="button" onclick="location.href='${pageContext.request.contextPath}/mypage/${member.memberId}/edit'">설정</button>
					</div>

					<p class="line"></p>

					<div class="myinfo-history">
						<div class="myinfo-history-scrap myinfo-history-item">
							<i class="bi bi-bookmark-check"></i> <span>스크랩북</span>
							<em>9</em>
						</div>
						<div class="myinfo-history-like myinfo-history-item">
							<i class="bi bi-heart"></i> <span>좋아요</span>
							<em>1</em>
						</div>
						<div class="myinfo-history-coupon myinfo-history-item">
							<i class="bi bi-ticket"></i> <span>내
                           쿠폰</span> <em>${couponCount}</em>
						</div>
					</div>
				</div>

				<a class="reward-box" href="#"> <b>취향 공유하고 </b><strong>리워드
					받기</strong>
				</a>
			</div>
			</c:when>
				<c:otherwise>
			<div class="myinfo-wrapper" style="width: 210px">
				<div class="myinfo" style="width: 210px">
					<div class="myinfo-profile">
						<div class="share-icon">
							<i class="bi bi-share"></i>
						</div>
						<div class="image-wrapper">
							<img alt="" src="${pageContext.request.contextPath}/resources/picture/member/default-profile.png">
						</div>
						<h2>${member.nickName}</h2>
						<dl class="follow-wrapper">
							<dt class="follower">팔로워</dt>
							<dd class="follower-data" onclick="location.href='${pageContext.request.contextPath}/mypage/${member.memberId }/follower'">${followerCount}</dd>
							<dt class="following">팔로잉</dt>
							<dd class="follower-data" onclick="location.href='${pageContext.request.contextPath}/mypage/${member.memberId }/followee'">${followeeCount}</dd>
						</dl>
						<button class="setting" style="border-color: #35c5f0; background-color: #35c5f0; color: #fff;" type="button">팔로우</button>
					</div>
				</div>
			</div>
				</c:otherwise>
			</c:choose>