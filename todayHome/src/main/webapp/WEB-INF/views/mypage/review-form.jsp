<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
        .main-container.review-home {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .review-home-search-title {
            font-size: 18px;
            font-weight: 700;
            margin-bottom: 10px;
        }

        .review-home-search-form-input {
            flex: 1;
            height: 40px;
            line-height: 40px;
            font-size: 15px;
        }

        .review-home-search-form-input::placeholder {
            color: #999;
        }

        .form-control {
            width: 900px;
            display: inline-block;
        }

        .review-home-button {
            width: 120px;
            margin-left: 8px;
            display: inline-block;
            box-sizing: border-box;
            font-weight: 700;
            text-align: center;
            color: #ffffff;
            cursor: pointer;
            padding: 7px 9px;
            background: #35c5f0;
            border-color: #ffffff;
            border-style: solid;
            border-radius: 4px;
        }

        .picture-content-flex {
            display: flex;
            align-items: center;
        }

        .picture-img-container {
            width: 86px;
            height: 86px;
            border-radius: 4px;
            overflow: hidden;
        }

        .follow-user-item-img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .picture-text-container {
            display: flex;
            flex-direction: column;
            gap: 5px;
        }

        .picture-text {
            font-weight: 400;
            color: #333;
        }

        .brand {
            font-size: 12px;
            color: #b7b7b7;
        }

        .name {
            font-size: 15px;
            font-weight: bold;
        }

        .option {
            font-size: 15px;
        }

        .point {
            font-size: 14px;
            font-weight: bold;
            color: #35c5f0;
        }

        .review-home-search-form-wrap {
            align-items: center;
        }

        .picture-container {

        }
	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        selectCurrentMenu(1, 1)
    });
</script>

<jsp:include page="/WEB-INF/views/fragment/mypage-menubar.jsp"/>

<div class="main-container">
	<div class="content review-home">
		<div class="review-home-search">
			<div class="review-home-search-title"> 내가 사용하는 상품 리뷰 쓰기</div>
			<form class="review-home-search-form">
				<div class="review-home-search-form-wrap flex-row">
					<input placeholder="브랜드명 혹은 상품명 입력" class="form-control review-home-search-form-input">
					<button class="review-home-button" type="submit">검색</button>
				</div>
			</form>

			<div class="flex-col" style="margin-top: 30px; gap: 10px">
				<% for (int i = 0; i < 15; i++) { %>
					<div class="picture-container flex-row" style="justify-content: space-between; width: 100%">
						<div class="flex-row" style="gap: 15px; align-items: center;">
							<div class="picture-img-container">
								<img class="follow-user-item-img"
									 src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/161866122047151511.jpeg?w=1440">
							</div>
							<div class="picture-text-container">
								<div class="picture-text brand">고리아</div>
								<div class="picture-text name">단열용품 맞춤 두꺼운 방풍비닐 벨크로</div>
								<div class="picture-text option">벨크로 색상:흰색벨크로/ 사이즈:100 x 220cm</div>
								<div class="picture-text point">포토 500P 일반 100P</div>
							</div>
						</div>

						<div class="flex-col" style="padding-right: 5px; gap: 5px; justify-content: center; text-align: center">
							<div style="font-size: 14px">오늘의집 구매</div>
							<div style="padding: 8px 30px; border: 1px solid #64C2EB; color: #64C2EB; border-radius: 4px">리뷰쓰기</div>
						</div>
					</div>
				<% } %>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
