<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
        section {
            display: flex;
            justify-content: center;
            align-items: center;
            box-sizing: border-box;
            gap: 8%;
        }

        /*
		----------------
		  myinfo
		----------------
		*/
        .myinfo-wrapper {
            position: sticky;
            top: 0;
            align-self: flex-start;
            min-width: 280px;
            padding: 10px 0;
        }

        .myinfo {
            padding: 30px 25px 18px;
            border: 1px solid #d7d7d7;
            border-radius: 5px;
            box-shadow: 0 0 8px -6px #000000;
        }

        .myinfo .myinfo-profile {
            position: relative;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            gap: 0px;
        }

        .myinfo .share-icon {
            position: absolute;
            top: -10px;
            right: -10px;
            cursor: pointer;
        }

        .myinfo .myinfo-profile .image-wrapper {
            width: 120px;
            height: 120px;
            margin-bottom: 20px;
        }

        .myinfo .myinfo-profile .image-wrapper img {
            display: block;
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 50%;
        }

        .myinfo .myinfo-profile h2 {
            margin: 0;
            margin-bottom: 15px;
        }

        .myinfo .myinfo-profile .follow-wrapper {
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
            margin-bottom: 20px;
        }

        .myinfo .myinfo-profile .follow-wrapper dt,
        .myinfo .myinfo-profile .follow-wrapper dd {
            margin: 0;
            font-size: 13px;
            margin-right: 8px;
            line-height: 1;
        }

        .myinfo .myinfo-profile .follow-wrapper dt {
            color: #828C94;
        }

        .myinfo .myinfo-profile .follow-wrapper dd {
            color: #525B61;
            font-weight: 600;
        }

        .myinfo .myinfo-profile .follow-wrapper dd:nth-of-type(1)::after {
            display: inline-block;
            content: '';
            height: 10px;
            border-right: 1px solid #d1d1d1;
            margin-left: 8px;
        }

        .myinfo .myinfo-profile .follow-wrapper dd:nth-of-type(2) {
            margin-right: 0;
        }

        .myinfo .myinfo-profile .setting {
            background-color: #ffffff;
            color: #292929;
            font-size: 12px;
            padding: 7px 16px 8px;
            border: 1px solid #d1d1d1;
            border-radius: 4px;
            cursor: pointer;
        }

        .myinfo .myinfo-profile .setting:hover {
            opacity: .6;
        }

        .myinfo .line {
            border-bottom: 1px solid #d1d1d1;
            margin: 20px 0;
        }

        .myinfo .myinfo-history {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .myinfo .myinfo-history .myinfo-history-item {
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: center;
            cursor: pointer;
            gap: 5px;
        }

        .myinfo .myinfo-history .myinfo-history-item span {
            color: #424242;
            font-size: 13px;
        }

        .myinfo .myinfo-history .myinfo-history-item em {
            font-style: normal;
            font-weight: 600;
            color: #525B61;
        }

        .myinfo .myinfo-history .myinfo-history-scrap {

        }

        .myinfo-wrapper .reward-box {
            display: block;
            text-decoration: none;

            color: #3F474D;
            font-size: 14px;
            background-color: #EFFBFF;
            padding: 15px 0;
            border-radius: 5px;
            margin-top: 14px;
            text-align: center;
        }

        .myinfo-wrapper .reward-box strong {
            font-weight: 600;
            color: #35C5F0;
        }

        /*
		----------------
		  myinfo-list
		----------------
		*/
        .myinfo-list {
            flex-grow: 1;
        }

        .myinfo-list .myinfo-list-pictures {
            margin-bottom: 100px;
        }

        .myinfo-list .myinfo-list-pictures .picture-header,
        .myinfo-list .myinfo-list-house .house-header {
            display: flex;
            justify-content: flex-start;
            align-items: center;
            margin-bottom: 10px;
        }

        .myinfo-list .myinfo-list-pictures .picture-header h2,
        .myinfo-list .myinfo-list-house .house-header h2 {
            font-size: 18px;
            margin: 0;
            margin-right: 8px;
        }

        .myinfo-list .myinfo-list-pictures .picture-header strong,
        .myinfo-list .myinfo-list-house .house-header strong {
            color: #35C5F0;
            font-size: 18px;
        }

        .myinfo-list .myinfo-list-pictures .picture-list,
        .myinfo-list .myinfo-list-house .house-list {
            text-decoration: none;

            display: flex;
            justify-content: center;
            align-items: center;
            border: 1px dashed #d9d9d9;
            height: 180px;
            color: #757575;
            font-size: 13px;
            font-weight: 600;
        }
        
        .follower-data:hover {
			cursor: pointer;
		}
		
		 .image-category {
		  display: flex;
		  justify-content: flex-start;
		  align-items: flex-start;
		  flex-wrap: wrap;
		  margin-top: 16px;
		  gap : 5px;
		}

.image-category-item {
  width:  25%;
}

.image-category-user {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  gap: 10px;
  margin-bottom: 16px;
}

.image-category-user img {
  width: 36px;
  height: 36px;
  border-radius: 50%;
}

.image-category-user span {
  font-size: 15px;
  font-weight: 600;
}

.image-category-item a {
  text-decoration: none;
  color: inherit;
}

.image-category-user-image {
  width: 100%;
  height: 100%;
  border-radius: 8px;
  overflow: hidden;
}

.image-category-user-image img {
  display: block;
  width: 100%;
  height: 100%;
  object-fit: cover;
  aspect-ratio: 1 / 1;
}

.image-category-user-menu {
  display: flex;
  justify-content: space-around;
  align-items: center;
  gap: 10px;
}

.image-category-user-menu i {
  padding: 13px 0 16px;
}

.image-category-user-content {
  margin: 0;
  font-size: 15px;
}
	</style>
</head>
<body>
<script>
    $(function () {
    	// 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
		// 두번째 파라미터에 null 입력시 메뉴바 숨김
        selectCurrentMenu(0, null);

        // 마이페이지일때 메뉴
		// 메인메뉴, 서브메뉴 숫자 입력
		// 첫번째 파라미터에 0 입력시 숨김
		selectMyPage(1,1);
    });
    
    $(function () {
		$(".myinfo-history-coupon").on("click", function () {
			location.href = "${pageContext.request.contextPath}/mypage/coupon";
		});
	});
</script>

<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

<div class="main-container">
	<div class="content" style="padding: 0 60px">
		<section> 

		<jsp:include page="/WEB-INF/views/fragment/myprofile.jsp"/>
		
			<div class="myinfo-list">
				<div class="myinfo-list-pictures">
					<div class="picture-header">
						<h2>사진</h2>
						<strong>0</strong>
					</div>
					<c:if test="${empty userBoardList}">
						<a class="picture-list" href="${pageContext.request.contextPath}/community/picture/write"> 첫 번째 사진을 올려보세요 </a>
					</c:if>
					
					<c:if test="${not empty userBoardList}">
						<div class="image-category">
					<c:forEach var="userBoardList" items="${userBoardList}" begin="0" end="3">
						    <div class="image-category-item">
						      <a href="${pageContext.request.contextPath}/community/picture/picture-article?userBoardId=${userBoardList.userBoardId}">
						        <div href="" class="image-category-user-image">
						          <img src="${pageContext.request.contextPath}/uploads/housePicture/${userBoardList.imgName}" alt="user upload image">
						        </div>
						      </a>
						    </div>
					</c:forEach>
						  </div>
					</c:if>
				</div>
			</div>
		</section>
	</div>
</div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

<script>

</script>
</body>
</html>