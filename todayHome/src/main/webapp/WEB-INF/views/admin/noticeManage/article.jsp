<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css" type="text/css">
<style type="text/css">
.body-main {
	max-width: 900px;
}
</style>

<script type="text/javascript">
	function deleteOk() {
		let url = "${pageContext.request.contextPath}/admin/noticeManage/delete?noticeBoardId=${noticedto.noticeBoardId}";
	
		if(confirm("위 자료를 삭제 하시 겠습니까 ? ")) {
			location.href = url;
		}
	}
</script>

<div class="body-container">
    <div class="body-title">
		<h2><i class="fas fa-clipboard-list"></i> 공지사항 </h2>
    </div>
    
    <div class="body-main">

		<table class="table table-border table-article">
			<thead>
				<tr>
					<td colspan="2" align="center">
						${noticedto.subject}${noticedto.notice == 1 ? "" : " [숨김]" }
					</td>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td width="50%" align="left">
						이름 : ${noticedto.nickName}
					</td>
					<td width="50%" align="right">
						조회 ${noticedto.hitCount}
					</td>
				</tr>
				
				<tr>
					<td colspan="2" valign="top" height="200">
						${noticedto.content}
					</td>
				</tr>
				
				
			</tbody>
		</table>
			
		<table class="table">
			<tr>
				<td width="50%" align="left">
			    	<button type="button" class="btn" onclick="javascript:location.href='${pageContext.request.contextPath}/admin/noticeManage/update?noticeBoardId=${noticedto.noticeBoardId}';">수정</button>
			    	
	    			<button type="button" class="btn" onclick="deleteOk();">삭제</button>
				</td>
			
				<td align="right">
					<button type="button" class="btn" onclick="javascript:location.href='${pageContext.request.contextPath}/admin/noticeManage/list';">리스트</button>
				</td>
			</tr>
		</table>
		
	</div>
</div>
