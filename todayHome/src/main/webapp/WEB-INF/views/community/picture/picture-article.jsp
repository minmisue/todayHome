<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>집사진</title>

	<style>
        .article-item-container {
            width: 100%;
        }

        .subject-container {
            align-items: center;
            margin-top: 50px;
            margin-bottom: 10px;
        }

        .border-line {
            width: 100%;
            border-bottom: #F5F5F5 1px solid;
        }

        .article-contain-item-container {
			gap: 10px;
			overflow-x: auto;
			width: 100%;
            margin-top: 15px;
        }

        .content-text {
            margin-top: 15px;
        }
        
        .picture-btn {
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
		
			.picture-reply-text {
		    display: inline-block;
		    height: 40px;
 	  	    width: 670px;
 		    margin-top: 9px;
 		    border: 1px solid rgb(218, 221, 224);
 		    border-radius: 4px;
 		    resize: none;
		}
		
			.reply-answer { 
			display: none; 
		}
		
	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택, 서브메뉴는 첫번째 메뉴 선택시 자동으로 변경됨)
        // 0 이면 아무것도 하이리이팅 X
        // 두번째 파라미터에 null 입력시 서브메뉴 없앰
        selectCurrentMenu(1, 3)
    });
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container " >
	<div class="content" style="position: relative">
		<div class="flex-col" style="max-width: 720px; position: relative; margin: 0 auto">
			<c:forEach var="boardContentList" items="${userBoardContent}" varStatus="status">
				<div class="flex-row subject-container">
					<div class="flex-row" style="gap: 5px; align-items: center; font-weight: 350; font-size: 16px; color: rgb(130, 140, 148); margin-bottom: 5px;">
						<div>20평대</div>
						<div style="color: #DBDBDB">|</div>
						<div>${boardContentList.categoryName }</div>
					</div>
				</div>
	
					<div class="flex-col article-item-container" style="margin-bottom: 30px;">
						<div class="flex-col" style="gap: 10px;">
							<img style="width: 100%; aspect-ratio: 1/1; object-fit: cover" src="${pageContext.request.contextPath}/uploads/housePicture/${boardContentList.imgName}">
							<div class="article-contain-item-container flex-row">
								<c:forEach step="1" begin="1" end="15">
									<div style="width: 100px; height: 100px; border-radius: 20px">
										<img style="width: 100px; height: 100px; border: 1px solid #C5C2BB; border-radius: 30px" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/161866122047151511.jpeg?w=1440">
									</div>
								</c:forEach>
							</div>
	
							<div class="content-text" >
								${boardContentList.content}
							</div>
						</div>
					</div>
			</c:forEach>
			<div>
			<c:choose>
				<c:when test = "${sessionScope.sessionInfo.memberId==userBoard.memberId}">
  					<button type="button" class="btn btn-light" onclick="deleteBoard();">삭제</button>
  				</c:when>
  			</c:choose>
		</div>
		
			<div class="reply">
					<form name="replyForm" method="post">
						
						<div style="display: flex;">
							<div>
								<img style="width: 50px; height:50px; border-radius:50%;padding: 10px "  src="${pageContext.request.contextPath}/resources/picture/member/${sessionInfo.profileImgName}">
							</div>  
							<div style="position: relative;">
								<textarea class="picture-reply-text" name="content" id="content" placeholder="칭찬과 격려의 댓글은 작성자에게 큰 힘이 됩니다:)"></textarea>
								<button class="picture-btn" type="button"> 입력</button>
							</div>
						</div>
					</form>
					
					<div id=listReply></div>
		    </div>
		</div>
		
		
		<div style="position:absolute; top: 50px; right: 120px; padding-left: 20px; padding-top: 20px; margin-top: 40px; height: 100%">
			<div class="flex-col" style="position: sticky; top: 180px; text-align: center">
				<div>
					<div class="flex-col shadow-sm" style="border: 1px solid #C2C8CB; border-radius: 50%; width: 60px; height: 60px; justify-content: center; align-items: center">
					<button type="button" class="btn btn-outline-secondary btnSendBoardLike" title="좋아요">	<i class="bi ${userBoardLiked ? 'bi-heart-fill':'bi-heart'}" style="font-size: 22px"></i></button>
					</div>
					<div style="font-size: 14px; color: rgb(130, 140, 148); margin-top: 3px;" id="boardLikeCount" >${userBoard.boardLikeCount}</div>
				</div>

				<div>
					<div class="flex-col shadow-sm" style="border: 1px solid #C2C8CB; border-radius: 50%; width: 60px; height: 60px; justify-content: center; align-items: center; margin-top: 20px;">
					<button type="button" class="btn btnSendBoardScrap" title="북마크">	<i class="bi ${userBoardScraped ? 'bi-bookmark-fill':'bi-bookmark'}" style="font-size: 22px"></i></button>
					</div>
					<div style="font-size: 14px; color: rgb(130, 140, 148); margin-top: 3px;" id="boardScrapCount">${userBoard.boardScrapCount}</div>
				</div>

				<div class="border-line" style="margin-top: 20px; margin-bottom: 10px;"></div>

				<div>
					<div class="flex-col shadow-sm" style="border-radius: 50%; width: 60px; height: 60px; justify-content: center; align-items: center; margin-top: 20px; background-color: #F8F9FA">
						<i class="bi bi-chat" style="font-size: 22px"></i>
					</div>
					<div style="font-size: 14px; color: rgb(130, 140, 148); margin-top: 3px;" id="replyCount">${userBoard.replyCount}</div>
				</div>

		

			</div>
			<%--			<div class="following-feed-btn-container">--%>
			<%--				<div style="width: 100%;">--%>
			<%--					<div class="flex-col" style="border: 1px solid #ededed; width: 100%; background-color: white; border-radius: 6px; padding: 30px 20px;margin-bottom: 20px; gap: 10px">--%>
			<%--						<div class="flex-row" style="justify-content: space-between; font-size: 15px; font-weight: 400; color: #424242" >--%>
			<%--							<div style="font-weight: 400">총 상품 금액</div>--%>
			<%--							<div style="font-weight: 700;"><span>92,000</span>원</div>--%>
			<%--						</div>--%>

			<%--						<div class="flex-row" style="justify-content: space-between; font-size: 15px; font-weight: 400; color: #424242" >--%>
			<%--							<div style="font-weight: 400">총 배송비</div>--%>
			<%--							<div style="font-weight: 700;"><span>+ 62,000</span>원</div>--%>
			<%--						</div>--%>

			<%--						<div class="flex-row" style="justify-content: space-between; font-size: 15px; font-weight: 400; color: #424242" >--%>
			<%--							<div style="font-weight: 400">총 할인 금액</div>--%>
			<%--							<div style="font-weight: 700;"><span>- 122,000</span>원</div>--%>
			<%--						</div>--%>

			<%--						<div class="flex-row" style="justify-content: space-between; font-size: 15px; font-weight: 700; align-items: center; margin-top: 30px;" >--%>
			<%--							<div style="">결제금액</div>--%>
			<%--							<div style="font-size: 24px"><span>242,000</span>원</div>--%>
			<%--						</div>--%>
			<%--					</div>--%>
			<%--				</div>--%>

			<%--				<div class="purchase-btn" onclick="location.href='${pageContext.request.contextPath}/payment'">--%>
			<%--					1개 상품 구매하기--%>
			<%--				</div>--%>
			<%--			</div>--%>
		</div>
		
	</div>
</div>	

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	function deleteBoard() {
	    if(confirm("게시글을 삭제 하시 겠습니까 ? ")) {
		    let query = "userBoardId=${userBoard.userBoardId}";
		    let url = "${pageContext.request.contextPath}/community/picture/deleteBoard?" + query;
	    	location.href = url;
	    }
	}

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

	// 게시글 공감 여부
	$(function(){
		$(".btnSendBoardLike").click(function(){
			const $i = $(this).find("i");
			let userBoardLiked = $i.hasClass("bi-heart-fill");
			
			let url = "${pageContext.request.contextPath}/community/picture/insertBoardLike";
			let userBoardId = "${userBoard.userBoardId}";
			let query = "userBoardId="+userBoardId+"&userBoardLiked="+userBoardLiked;
			
			const fn = function(data){
				let state = data.state;
				if(state === "true") {
					if( userBoardLiked ) {
						$i.removeClass("bi-heart-fill").addClass("bi-heart");
						
					} else {
						$i.removeClass("bi-heart").addClass("bi-heart-fill");
					}
					
					var count = data.boardLikeCount;
					$("#boardLikeCount").text(count);
				} else if(state === "liked") {
					alert("게시글 좋아요는 한번만 가능합니다. !!!");
				} else if(state === "false") {
					alert("게시물 좋아요 여부 처리가 실패했습니다. !!!");
				}
			};
			
			ajaxFun(url, "post", query, "json", fn);
		});
	});
	
	$(function(){
		$(".btnSendBoardScrap").click(function(){
			const $i = $(this).find("i");
			let userBoardScraped = $i.hasClass("bi-bookmark-fill");
			
			let url = "${pageContext.request.contextPath}/community/picture/insertBoardScrap";
			let userBoardId = "${userBoard.userBoardId}";
			let query = "userBoardId="+userBoardId+"&userBoardScraped="+userBoardScraped;
			
			const fn = function(data){
				let state = data.state;
				if(state === "true") {
					if( userBoardScraped ) {
						$i.removeClass("bi-bookmark-fill").addClass("bi-bookmark");
					} else {
						$i.removeClass("bi-bookmark").addClass("bi-bookmark-fill");
					}
					
					var count = data.boardScrapCount;
					$("#boardScrapCount").text(count);
				} else if(state === "liked") {
					alert("게시글 좋아요는 한번만 가능합니다. !!!");
				} else if(state === "false") {
					alert("게시물 좋아요 여부 처리가 실패했습니다. !!!");
				}
			};
			
			ajaxFun(url, "post", query, "json", fn);
		});
	});
	
	 $(function(){
	    	listPage(1);
	    });

	     function listPage(page) {
	    	let url = "${pageContext.request.contextPath}/community/picture/listReply";
	    	let query = "userBoardId=${userBoard.userBoardId}&pageNo="+page;
	    	let selector = "#listReply";
	    	const fn = function(data){
	    		$(selector).html(data);
	    	};
	    	ajaxFun(url, "get", query, "html", fn);
	    } 
	    
	    $(function () {
	    	$("button[class='picture-btn']").on("click", function () {
	    		let userBoardId = "${userBoard.userBoardId}";
	    		let content = $("#content").val();
	    		if(! content) {
	    			$("#content").focus();
	    			return false;
	    		}
	    		content = encodeURIComponent(content);
	    		
	    		let url = "${pageContext.request.contextPath}/community/picture/insertReply";
	    		let query = "userBoardId=" + userBoardId + "&content=" + content + "&userBoardMemberId=" + ${userBoard.memberId} ;

	    		const fn = function(){
	    			$("#content").val("");
	    			listPage(1);
	    		};
	    		ajaxFun(url, "post", query, "html", fn);
	    	});
		});
	    
	    $(function(){
	    	$("body").on("click", ".deleteReply", function(){
	    		if(! confirm("댓글을 삭제하시겠습니까 ? ")) {
	    		    return false;
	    		}
	    		
	    		let userBoardCommentId = $(this).attr("data-userBoardCommentId");
	    		let page = $(this).attr("data-pageNo");
	    		
	    		let url = "${pageContext.request.contextPath}/community/picture/deleteReply";
	    		let query = "userBoardCommentId=" + userBoardCommentId + "&mode=reply";
	    		
	    		const fn = function(data){
	    			listPage(page);
	    		};
	    		
	    		ajaxFun(url, "post", query, "json", fn);
	    	});
	    });
	    
	  
	    
		$(function(){
			$("body").on("click", ".btnSendReplyLike", function(){
				const $i = $(this).find("i");
				let commentLiked = $i.hasClass("bi-heart-fill");
				
				let url = "${pageContext.request.contextPath}/community/picture/insertCommentLike";
				let userBoardCommentId = "${comment.userBoardCommentId}";
				let query = "userBoardCommentId="+userBoardCommentId;
				
				const fn = function(data){
					let state = data.state;
					if(state === "true") {
						if( commentLiked ) {
							$i.removeClass("bi-heart-fill").addClass("bi-heart");
							
						} else {
							$i.removeClass("bi-heart").addClass("bi-heart-fill");
						}
						
						var count = data.replyLikeCount;
						$("#likeCount").text(count);
					} else if(state === "liked") {
						alert("게시글 좋아요는 한번만 가능합니다. !!!");
					} else if(state === "false") {
						alert("게시물 좋아요 여부 처리가 실패했습니다. !!!");
					}
				};
				
				ajaxFun(url, "post", query, "json", fn);
			});
		});
		
		
		function listReplyAnswer(parentCommentId) {
			let url = "${pageContext.request.contextPath}/community/picture/listReplyAnswer";
			let query = "parentCommentId=" + parentCommentId;
			let selector = "#listReplyAnswer" + parentCommentId;
			
			const fn = function(data){
				$(selector).html(data);
			};
			ajaxFun(url, "get", query, "text", fn);
		}
		
		// 답글 버튼(댓글별 답글 등록폼 및 답글리스트)
		$(function(){
			$("body").on("click", ".btnReplyAnswerLayout", function(){
				const $trReplyAnswer = $(this).closest("tr").next();
				
				let isVisible = $trReplyAnswer.is(':visible');
				let userBoardCommentId = $(this).attr("data-userBoardCommentId");
					
				if(isVisible) {
					$trReplyAnswer.hide();
				} else {
					$trReplyAnswer.show();
		            
					// 답글 리스트
					listReplyAnswer(userBoardCommentId);
					
				}
			});
			
		});
		
		// 댓글별 답글 등록
		$(function(){
		$("body").on("click", ".btnSendReplyAnswer", function(){
			let userBoardId = "${userBoard.userBoardId}";
			let userBoardCommentId = $(this).attr("data-userBoardCommentId");
			const $td = $(this).closest("td");
			
			let content = $td.find("textarea").val().trim();
			if(! content) {
				$td.find("textarea").focus();
				return false;
			}
			content = encodeURIComponent(content);
			
			let url = "${pageContext.request.contextPath}/community/picture/insertReply";
			let query = "userBoardId=" + userBoardId + "&content=" + content + "&parentCommentId=" + userBoardCommentId;
			
			const fn = function(data){
				$td.find("textarea").val("");
				
				var state = data.state;
				if(state === "true") {
					listReplyAnswer(userBoardCommentId);
				}
			};
			
			ajaxFun(url, "post", query, "json", fn);
		});
	});
		
		// 댓글별 답글 삭제
		  $(function(){
		    	$("body").on("click", ".deleteReplyAnswer", function(){
		    		if(! confirm("댓글을 삭제하시겠습니까 ? ")) {
		    		    return false;
		    		}
		    		
		    		let userBoardCommentId = $(this).attr("data-userBoardCommentId");
		    		let parentCommentId = $(this).attr("data-parentCommentId");
		    		
		    		let url = "${pageContext.request.contextPath}/community/picture/deleteReply";
		    		let query = "userBoardCommentId=" + userBoardCommentId + "&mode=answer";
		    		
		    		const fn = function(data){
		    			listReplyAnswer(answer);
		    		};
		    		
		    		ajaxFun(url, "post", query, "json", fn);
		    	});
		    });

</script>

</html>
