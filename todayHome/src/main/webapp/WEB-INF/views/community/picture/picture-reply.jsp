<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
		.bold-1 {
		    font-size: 18px;
    font-weight: 700;
    margin-left: 11px;
		}
		
		.bold-2{
		    padding-left: 8px;
		    color: rgb(53, 197, 240);
		    font-weight: 700;
		    font-size: 18px;
		}
		
	   .profile-img {
     	width: 55px;
      	height: 30px;
       	border-radius: 50%;
        }
        
        .reply-menu-item {
		align-self: flex-end;
		margin-left: auto;
		}
		
		.btn-delete, .btnReplyAnswerLayout {
		font-size: 13px;
		}
</style>
<div class='reply-info'>
	<span class="bold-1">댓글</span><span class="bold-2">${replyCount}</span>
</div>

<table class='table table-borderless'>
	<c:forEach var="listReply" items="${listReply}">
		<tr class='bg-light' style="border:none">
			<td width='100%'>
				<div class='row reply-writer'>
					<img class="profile-img"
								 src="${pageContext.request.contextPath}/resources/picture/member/${listReply.profileImgName}">
					<div class='col-auto align-self-center'>
						<div class='name' style="font-size: 16px; font-weight: bold; padding: 0 0 5px">${listReply.nickName}</div>
						<div class='content' style="padding: 0 0 5px">${listReply.content}</div>
							<div class='date' style="font-size: 12px;">${listReply.regDate}
							<button type="button" class="btn btn-outline-secondary btnSendReplyLike" style= "border: none;" title="좋아요"><i class="bi ${listReply.commentLiked ==	 1 ? 'bi-heart-fill':'bi-heart'}" style="font-size: 15px;"></i></button>
							<span id="likeCount">${listReply.likeCount}&nbsp;&nbsp;</span>
							<button type='button' class='btn btnReplyAnswerLayout' data-userBoardCommentId='${listReply.userBoardCommentId}'>답글 달기 </button>
							<c:if test="${sessionScope.sessionInfo.memberId==listReply.memberId}">
								<button type="button" class="btn btn-delete" onclick="deleteReply();">삭제</button>
							</c:if>
							</div>
						</div>
				</div>
			</td>
		</tr>
		
	
		
		 <tr class='reply-answer'>
	        <td colspan='2'>
	        	<div style = "display:flex;">
		            <div id='listReplyAnswer${listReply.userBoardCommentId}' class='answer-list'></div>
		            <div>
						<img style="width: 50px; height:50px; border-radius:50%;padding: 10px "  src="${pageContext.request.contextPath}/resources/picture/member/${listReply.profileImgName}">
					</div>
		            <div style="position: relative">
		                <textarea class="form-control m-2" style="resize: none"></textarea>
		            </div>
					<div class='text-end pe-2 pb-1'>
		            </div>
						<button type='button' class='btn btn-light btnSendReplyAnswer' data-replyNum='${listReply.userBoardCommentId}'>답글 등록</button>
	            </div>
			</td>
	    </tr>
	</c:forEach>
</table>

<div class="page-navigation">
	${paging}
</div>			




