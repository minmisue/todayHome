<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css" type="text/css">
<style type="text/css">
.body-main {
	max-width: 900px;
}

.badge {
	display: inline-block; padding:2px 3px; background: #0d6efd; color: #fff; font-weight: 500;
	font-size: 11px;
}
</style>

<script type="text/javascript">
function searchList() {
	const f = document.searchForm;
	f.submit();
}
</script>

<div class="body-container">
    <div class="body-title">
		<h2><i class="fas fa-clipboard-list"></i> 공지사항 </h2>
    </div>
    
    <div class="body-main">

		<table class="table">
			<tr>
				<td align="left" width="50%">
				</td>
				<td align="right">
					&nbsp;
				</td>
			</tr>
		</table>
		
		<table class="table table-border table-list">
			<thead>
				<tr>
					<th class="wx-60">번호</th>
					<th>제목</th>
					<th class="wx-120">작성자</th>
					<th class="wx-50">조회수</th>
					<th class="wx-100">등록일</th>
					<th class="wx-50">표시</th>
				</tr>
			</thead>
		 
		 	<tbody>
				<c:forEach var="noticelist" items="${noticelist}">
					<tr> 
						<td><span class="badge">공지</span></td>
						<td class="left">
							<a href="${pageContext.request.contextPath}/admin/noticeManage/article?noticeBoardId=${noticelist.noticeBoardId}">${noticelist.subject}</a>
						</td>
						<td>관리자</td>
						<td>${noticelist.hitCount}</td>
						<td>${noticelist.createdDate}</td>
						<td>${noticelist.notice == 1 ? "표시" : "숨김" }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		 
		
		<table class="table">
			<tr>
				<td align="right" width="100">
					<button type="button" class="btn" onclick="location.href='${pageContext.request.contextPath}/admin/noticeManage/write';">글올리기</button>
				</td>
			</tr>
		</table>

	</div>
</div>
