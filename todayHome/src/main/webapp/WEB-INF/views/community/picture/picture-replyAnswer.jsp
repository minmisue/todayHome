<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach var="replyAnswer" items="${listReplyAnswer}">
	<div class='border-bottom m-1'>
		<div class='row p-1'>
			<div class='col-auto'>
				<div class='row reply-writer'>
					<div class='col-1'><i class='bi bi-person-circle text-muted icon'></i></div>
					<div class='col ms-2 align-self-center'>
						<div class='name'>${replyAnswer.nickName}</div>
						<div class='date'>${replyAnswer.regDate}</div>
					</div>
				</div>
			</div>
			<div class='col align-self-center text-end'>
				<span class='reply-dropdown'><i class='bi bi-three-dots-vertical'></i></span>
				<div class='reply-menu'>
						<c:if test="${ssessionScope.sessionInfo.memberId==userBoard.memberId}">
							<div class='deleteReplyAnswer reply-menu-item' data-replyNum='${replyAnswer.replyNum}' data-answer='${vo.answer}'>삭제</div>
						</c:if>
				</div>
			</div>
		</div>

		<div class='p-2'>
			${replyAnswer.content}
		</div>
	</div>
</c:forEach>
