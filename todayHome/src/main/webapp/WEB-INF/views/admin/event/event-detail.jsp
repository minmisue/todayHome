<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
		.event-detail-container{
			width: 600px;
			display: flex;
			flex-direction: column;
			margin: 0 auto;
		}
		
		.event-detail-img{
			width: 100%;
		}
		
		.event-reply-text {
		    display: inline-block;
		    height: 40px;
 	  	    width: 545px;
 		    margin-top: 9px;
 		    border: 1px solid rgb(218, 221, 224);
 		    border-radius: 4px
		}
		
		.event-btn {
			position: absolute;
 		    top: 18;
		    right: 6px;
		    background-color: transparent;
		    border: none;
		    font-size: 16px;
            line-height: 20px;
            color: rgb(53, 197, 240);
            font-weight: 700
		}

		.bold-1 {
		    font-size: 18px;
    font-weight: 700;
    margin-left: 11px;
		}
		
		.eventwin-2{
		    padding-left: 8px;
    color: rgb(53, 197, 240);
    font-weight: 700;
    font-size: 18px;
	text-align: center;
		}
		
	.eventimg img{
	height: 1100px;
	width: 600px;
	}
	</style>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
    $(function () {
        // 여기에서 메뉴 선택
		// 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
		// 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        selectCurrentMenu(1, 5)
    });
    
    function ajaxFun(url, method, query, dataType, fn) {
    	$.ajax({
    		type:method,
    		url:url,
    		data:query,
    		dataType:dataType,
    		success:function(data) {
    			fn(data);
    		},
    		beforeSend:function(jqXHR) {
    			jqXHR.setRequestHeader("AJAX", true);
    		},
    		error:function(jqXHR) {
    			if(jqXHR.status === 403) {
    				login();
    				return false;
    			} else if(jqXHR.status === 400) {
    				alert("요청 처리가 실패 했습니다.");
    				return false;
    			}
    	    	
    			console.log(jqXHR.responseText);
    		}
    	});
    }
    
    $(function(){
    	listPage(1);
    });

     function listPage(page) {
    	let url = "${pageContext.request.contextPath}/admin/event/listReply";
    	let query = "eventBoardId=${eventBoard.eventBoardId}&pageNo="+page;
    	let selector = "#listReply";
    	const fn = function(data){
    		$(selector).html(data);
    	};
    	// ajaxFun(url, "get", query, "html", fn);
    	ajaxFun(url, "get", query, "text", fn);
    } 
    
    $(function () {
    	$("button[class='event-btn']").on("click", function () {
    		let eventBoardId = "${eventBoard.eventBoardId}";
    		let content = $("#content").val();
    		if(! content) {
    			$("#content").focus();
    			return false;
    		}
    		content = encodeURIComponent(content);
    		
    		let url = "${pageContext.request.contextPath}/admin/event/insertReply";
    		let query = "eventBoardId=" + eventBoardId + "&content=" + content;

    		const fn = function(){
    			$("#content").val("");
    			listPage(1);
    		};
    		ajaxFun(url, "post", query, "html", fn);
    	});
	});
</script>

	<div class="main-container">
		<div class="content">
			<div class="event-detail-container">
			<form name="eventForm">
				<div class="eventimg">${eventBoard.content }</div>
				<div><span class="eventwin-2">발표 일자는 : ${eventBoard.winningDate}</span></div>
			<c:if test="${eventBoard.winningDate <= sysdate }">
			<table>
					<tr>
						<td colspan="2" align="center">
							<c:if test="${eventBoard.winnerNumber != 0}">
								<button type="button" class="btn btnEventWinnerInsert">이벤트 당첨자 발표</button>	
								<input type="hidden" name="eventBoardId" value="${eventBoard.eventBoardId}">	
								<input type="hidden" name="winnerNumber" value="${eventBoard.winnerNumber}">	
							</c:if>
							<c:if test="${eventBoard.winnerNumber != 0}">
								<button type="button" class="btn btnEventWinnerList">이벤트 당첨자 확인</button>		
							</c:if>								
						</td>
					</tr>
			</table>
			
			</c:if>
			</form>
			<div class="reply">
				<form name="replyForm" method="post">
					
					<div style="display: flex;">
						<div>
							<img style="border-radius:50%;padding: 10px " alt="" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/users/profile_images/1686126806_kakao_1955084745.jpg?gif=1&w=36&webp=1">
						</div>  
						<div style="position: relative;">
							<textarea class="event-reply-text" name="content" id="content"></textarea>
							<button class="event-btn" type="button"> 입력</button>
						</div>
					</div>
				</form>
				
				<div id="listReply"></div>
			</div>
			</div>


		</div>
	</div>

	<script type="text/javascript">
		$(function(){
			$(".btnEventWinnerList").click(function(){
				$("#eventWinnerModal").modal("show");	
			});
			
			$(".btnEventWinnerInsert").click(function () {
				const f = document.eventForm;
				if(confirm("담청자를 추첨하시겠습니까 ? ")) {
					f.action = '${pageContext.request.contextPath}/admin/event/winner';
					f.method = 'POST';
			    	f.submit();
			    }
			});
		});
		
		
	</script>
	
<c:if test="${eventWinnerlist.size() != 0}">
	<div class="modal fade" id="eventWinnerModal" tabindex="-1" aria-labelledby="eventWinnerModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="eventWinnerModalLabel">이벤트 당첨자 리스트</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body pt-1 text-center">
	                 <div class="row row-cols-4 g-1">
	                 	<c:forEach var="winner" items="${eventWinnerlist}" varStatus="status">
	                 		<div class="col">
	                 			<div class="border">
									<span style="font-weight: 500;">
										${winner.nickName}
									</span>
								</div>
	                 		</div>
	                 	</c:forEach>
	                 </div>
				</div>
			</div>
		</div>
	</div>
</c:if>

</body>
</html>
