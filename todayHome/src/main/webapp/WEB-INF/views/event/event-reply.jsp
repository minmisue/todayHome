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
</style>
<div class='reply-info'>
	<span class="bold-1">댓글</span><span class="bold-2">${replyCount}</span>
	<span>[목록, ${pageNo}/${total_page} 페이지]</span>
</div>

<table class='table table-borderless'>
	<c:forEach var="listReply" items="${listReply}">
		<tr class='border bg-light'>
			<td width='50%'>
				<div class='row reply-writer'>
					<div class='col-1'><i class='bi bi-person-circle text-muted icon'></i></div>
					<div class='col-auto align-self-center'>
						<div class='name'>${listReply.name}</div>
						<div class='date'>${listReply.regDate}</div>
					</div>
				</div>
			</td>
			<td width='50%' align='right' class='align-middle'>
				<span class='reply-dropdown'><i class='bi bi-three-dots-vertical'></i></span>
				<div class="reply-menu">
					<c:if test="${sessionScope.member.memberId==listReply.memberId}">
						<div class='deleteReply reply-menu-item' data-replyNum='${listReply.replyNum}' data-pageNo='${pageNo}'>삭제</div>
					</c:if>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan='2' valign='top' >${listReply.content}</td>
		</tr>
	</c:forEach>
</table>

<div class="page-navigation">
	${paging}
</div>			
