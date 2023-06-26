<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
		
		.bold-2{
		    padding-left: 8px;
    color: rgb(53, 197, 240);
    font-weight: 700;
    font-size: 18px;
		}
		
		

	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
		// 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
		// 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        selectCurrentMenu(1, 5)
    });
</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content">
			<div class="event-detail-container">
				${eventBoard.content }
			
			<div class="reply">
				<form name="replyForm" method="post">
					<div class='form-header'>
						<span class="bold-1">댓글</span><span class="bold-2">394</span>
					</div>
					
					<div style="display: flex;">
						<div>
							<img style="border-radius:50%;padding: 10px " alt="" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/users/profile_images/1686126806_kakao_1955084745.jpg?gif=1&w=36&webp=1">
						</div>  
						<div style="position: relative;">
							<input class="event-reply-text" style="" type="text">
							<button class="event-btn" type="button"> 입력</button>
						</div>
					</div>
				</form>
				
				<div id="listReply"></div>
			</div>
			</div>


		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
