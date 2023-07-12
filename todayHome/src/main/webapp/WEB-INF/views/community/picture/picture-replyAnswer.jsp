<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach var="replyAnswer" items="${listReplyAnswer}">
	<div class='border-bottom m-1'>
		<div class='row p-1'>
			<div class='col-auto'>
				<div class='row reply-writer'>
					<img class="profile-img"
								 src="${pageContext.request.contextPath}/resources/picture/member/${replyAnswer.profileImgName}">
					<div class='col ms-2 align-self-center'>
						<div class='name' style="font-size: 16px; font-weight: bold; padding: 0 0 5px">${replyAnswer.nickName}</div>
						<div class='content' style="padding: 0">${replyAnswer.content}</div>
						<div class='date' style="font-size: 12px;">${replyAnswer.regDate}
							<button type="button" class="btn btn-outline-secondary btnSendReplyLike" style= "border: none;" title="좋아요"><i class="bi ${replyAnswer.commentLiked ==	 1 ? 'bi-heart-fill':'bi-heart'}" style="font-size: 15px;"></i></button>
							<span id="likeCount">${replyAnswer.likeCount}&nbsp;&nbsp;</span>
							<c:if test="${sessionScope.sessionInfo.memberId==replyAnswer.memberId}">
								<div class='deleteReplyAnswer reply-menu-item' style="display: inline" data-userBoardCommentId='${replyAnswer.userBoardCommentId}' data-parentCommentId='${replyAnswer.parentCommentId}'>삭제</div>							
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:forEach>
