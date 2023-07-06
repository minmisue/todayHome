<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/review.css">
<title>Home</title>

<style>
.main-container.review-home {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

.select-btn {
	width: 100px;
    margin-right: 3px;
    display: inline-block;
    box-sizing: border-box;
    font-weight: 700;
    text-align: center;
    padding: 4px 0;
    cursor: pointer;
    border-radius: 4px;
	font-size: 15px;

    color: #dbdbdb;
    background-color: #ffffff;
    border: 1px solid #dbdbdb;
}

.selected {
    color: #35c5f0;
    background-color: #ffffff;
    border: 1px solid #3fc5f0;
}

.product-text-container {
	display: flex;
	flex-direction: column;
	gap: 5px;
}

.product-text {
	font-weight: 400;
	color: #333;
}

.subject {
	font-size: 15px;
	font-weight: bold;
}

.name {
	font-size: 12px;
}

.star-rating i {
	color: #35c5f0;
}

.date {
	font-size: 12px;
	color: #dbdbdb;
    margin-left: 10px;
}

.review {
	font-size: 12px;
}

.flex-row {
	margin-bottom: 20px;
}


.edit-btn:hover {
    cursor: pointer;
	color: #c5c5c5;
}
</style>
<script>

</script>

</head>
<body>
	<script>
		$(function() {
			// 여기에서 메뉴 선택
	        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
	        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
			// 두번째 파라미터에 null 입력시 메뉴바 숨김
	        selectCurrentMenu(0, null);

	        // 마이페이지일때 메뉴
			// 메인메뉴, 서브메뉴 숫자 입력
			// 첫번째 파라미터에 0 입력시 숨김
			selectMyPage(3,2);
		});
	</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp" />

	<div class="main-container">
		<div class="content review-home">
			<div class="review-home-search">
				<button class="select-btn selected" onclick="bestPage(this)"> 베스트순</button>
				<button class="select-btn" onclick="recentPage(this)"> 최신순</button>
					<div class="flex-col" style="margin-top: 30px; gap: 10px">
						<c:forEach items="${reviewList}" var="review">
							<div class="product-container flex-row"
								style="justify-content: space-between; width: 100%">
								<div class="flex-row" style="gap: 15px; align-items: center;">
									<div class="product-text-container">
										<div class="product-text subject">${review.productName}</div>
										<div class="product-text name">${review.stockString}</div>
										<input class="review-rating" type="hidden" value="${review.rating}">
										<input class="review-orderItemId" type="hidden" value="${review.orderItemId}">
										<input class="review-productId" type="hidden" value="${review.productId}">

										<div class="star-rating">
											<c:set var="rating" value="${review.rating}"/>
											<c:set var="first" value="${fn:substringBefore(rating, '.')}"/>
											<c:set var="second" value="${fn:substringAfter(rating, '.')}"/>

											<!-- 3.4라면 1~3자리까지 꽉찬 별로 채움 -->
											<c:if test="${!first.equals('0')}">
												<c:forEach begin="1" end="${first}">
													<i class="fa-solid fa-star"></i>
												</c:forEach>
											</c:if>

											<c:if test="${!first.equals('5')}">
												<!-- 소숫점 숫자가 0이 아니라면 반별 -->
												<c:if test="${!second.equals('0')}">
													<i class="fa-solid fa-star-half-stroke"></i>
												</c:if>
												<!-- 0이라면 빈별 -->
												<c:if test="${second.equals('0')}">
													<i class="fa-regular fa-star"></i>
												</c:if>

												<!-- 5 - (앞자리+1) -->
												<c:if test="${!first.equals('4')}">
													<c:forEach begin="1" end="${4-first}">
														<i class="fa-regular fa-star"></i>
													</c:forEach>
												</c:if>
											</c:if>
											<span class="date"> ${review.regDate} | 오늘의집 리뷰</span>
										</div>

										<div class="product-text review">${review.content}</div>
									</div>
								</div>

								<div class="flex-col"
									style="padding-right: 5px; gap: 5px; justify-content: center; text-align: center">
									<div class="edit-btn" style="font-size: 14px" onclick="openReviewModal(this)">수정</div>
								</div>
							</div>
						</c:forEach>
					</div>
			</div>
		</div>

		<div class="modal fade" id="reviewModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" style="">
				<div class="modal-content modal-dialog-centered" style="padding: 10px; ">
					<div style="text-align: center; position: relative; width: 100%; padding: 30px 0">
						<h5 class="modal-title" id="staticBackdropLabel">리뷰 쓰기</h5>
						<button style="position: absolute; right: 10px; top: 10px" type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<form class="modal-body flex-col" action="${pageContext.request.contextPath}/reviews/edit" method="post" id="reviewForm" style="width: 100%;" enctype="multipart/form-data">
						<div id="reviewModalProduct"></div>

						<div style="margin-top: 40px;">
							<div style="text-align: center">별점 평가</div>
							<div class="rating-container-bundle " style="margin-top: 10px" id="rate-container">
								<input type="hidden" name="rating" id="rating" value="0">
								<input type="hidden" name="productId" id="product-id" value="">
								<input type="hidden" name="orderItemId" id="order-item-id" value="">
								<div class="rating-container starBundle" style="margin: 0 auto;"></div>
							</div>
						</div>

						<div class="review-picture-container">
							<input type="file" name="reviewImg" id="reviewImg" accept="image/*" class="photoAttach">
							<label for="reviewImg" class="" style="width: 100%; border: 1px solid #63BDE6; border-radius: 4px; background-color: white; padding: 7px 0; color: #63BDE6; text-align: center">사진 첨부하기</label>
						</div>
						<textarea class="form-control" id="content" name="content" style="height: 150px; width: 100%; margin-top: 30px;" placeholder="20자 이상 입력해주세요."></textarea>
						<div class="review-content"></div>
					</form>

					<div class="modal-footer-custom">
						<button type="button" class="comment-submit-btn" onclick="submitComment()">수정 완료</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp" />
<script>
	let selectBtn = $('.select-btn');

    function selectBtnClass(obj) {
        for (const x of selectBtn) {
            if (x === obj) {
                $(x).addClass('selected')
            } else {
                $(x).removeClass('selected')
            }
        }
    }

    function recentPage(obj) {
        selectBtnClass(obj)
    }

    function bestPage(obj) {
        selectBtnClass(obj)
    }
</script>


<script>
	// 리뷰 수정 모달 설정
	function openReviewModal(obj) {

        let reviewElement = obj.closest('.product-container');
        let rating = reviewElement.querySelector('.review-rating').value;
        let brandName = reviewElement.querySelector('.product-text.name').textContent;
        let stockString = reviewElement.querySelector('.product-text.name').textContent;
        let content = reviewElement.querySelector('.product-text.review').textContent;
        let productName = reviewElement.querySelector('.product-text.subject').textContent;
        let orderItemId = reviewElement.querySelector('.review-orderItemId').value;
        let productId = reviewElement.querySelector('.review-productId').value;

        let $reviewModalProduct = $('#reviewModalProduct');
		let tag = `<div class="flex-row" style="gap: 15px; align-items: center;">
						<div class="picture-img-container">
							<img class="follow-user-item-img"
								 src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/161866122047151511.jpeg?w=1440">
						</div>
						<div class="picture-text-container">
							<div class="picture-text brand">` + brandName + `</div>
							<div class="picture-text name">` + productName + `</div>
							<div class="picture-text option">` + stockString + `</div>
						</div>
					</div>`

		$reviewModalProduct.empty();
		$reviewModalProduct.html(tag)
		setRatingValue(rating)
		let first = setStarByRating()

        let starBundle = starBundles.getElementsByTagName('i');
        for (let i = 0; i < 5; i++) {
            starBundle[i].addEventListener('mousemove', function (e) {
                // 별 원상복구
                resetStar(starBundle)

                for (let j = 0; j <= i; j++) {
                    starBundle[j].classList.replace('fa-regular', 'fa-solid')
                    starBundle[j].style.color = STAR_COLOR_HOVER
                }

                let rect = starBundle[i].getBoundingClientRect();
                // 클릭한 x좌표
                let x = e.clientX - rect.left;

                if (x < rect.width / 2) {
                    // 왼쪽 클릭한 경우
                    starBundle[i].classList.replace('fa-star', 'fa-star-half-stroke');
                } else {
                    // 오른쪽 클릭한 경우
                    starBundle[i].classList.replace('fa-regular', 'fa-solid')
                }
            });

            // 마우스 땠을때 초기화
            starBundle[i].addEventListener('mouseout', function (e) {
                resetStar(starBundle)

                if (first === -1) return;

                for (let j = 0; j <= first; j++) {
                    starBundle[j].classList.replace('fa-regular', 'fa-solid')
                }

                // lastStarIsFull이 true라면 마지막 별을 변경
                if (!lastStarIsFull) {
                    starBundle[first].classList.replace('fa-star', 'fa-star-half-stroke');
                }
            });

            // 실제로 클릭했을 때 이벤트
            starBundle[i].addEventListener('click', function (e) {
                // 현재 별 등급을 유지
                // i가 눌렸다면 i+1점
                // i-1까지 꽉찬 별, i번째 별이 반별인지 꽉찬 별인지만 적용한다.
                first = i
                lastStarIsFull = true
                lastStarIsFull = !starBundle[i].classList.contains('fa-star-half-stroke')

                getRating();
            });
        }


		$('#product-id').val(productId);
		$('#order-item-id').val(orderItemId);
		$('#reviewModal').modal('toggle');
        $('#content').text(content)

	}

</script>

<script>
	let ratingValue = ''; // 초기값 설정
    let lastStarIsFull = false

	// rating 값을 동적으로 설정하는 함수
	function setRatingValue(value) {
		ratingValue = value;
	}

	function setStarByRating() {
        let ratingContainer = document.getElementsByClassName('rating-container')[0];
        $(ratingContainer).children().remove()

        let first = ratingValue.split('.')[0];
        let second = ratingValue.split('.')[1];

		if (second !== '5') {
            lastStarIsFull = true;
		}

        if (first !== '0') {
            for (let i = 1; i <= parseInt(first); i++) {
                $(ratingContainer).append('<i class="fa-solid fa-star rate"></i>');
            }
        }

        if (first !== '5') {
            if (second !== '0') {
                $(ratingContainer).append('<i class="fa-solid fa-star-half-stroke rate"></i>');
            } else {
                $(ratingContainer).append('<i class="fa-regular fa-star rate"></i>');
            }

            for (let i = 1; i <= 4 - parseInt(first); i++) {
                $(ratingContainer).append('<i class="fa-regular fa-star rate"></i>');
            }
        }

        return first
	}
</script>


<script>
	let starBundles = document.getElementsByClassName('starBundle')[0];
	let STAR_COLOR_DEFAULT = '#63BDE6'
	let STAR_COLOR_HOVER = '#95D9F1'
	let commentForm = document.getElementById('reviewForm');

	// let starBundle = document.getElementsByClassName('rate');
	// let rating=0, lastStarIsFull

	function submitComment() {

		// 평점 댓글일 때,
		if (ratingValue === '0') {
			alert('점수를 입력해주세요.')
			return
		}

		if (!commentForm.content.value) {
			if (!confirm('내용이 없습니다. 평점만 등록하시겠습니까?')) {
				return
			}
		} else {
			if (!confirm('리뷰를 등록하시겠습니까?')) {
				return
			}
		}

		commentForm.submit();
	}

	function getRating() {
        ratingValue = rating + (lastStarIsFull ? 1 : 0.5);
		$('#rating').val(ratingValue);
	}



	function resetStar(starBundle) {
		for (const star of starBundle) {
			star.classList.replace('fa-solid', 'fa-regular')
			star.classList.replace('fa-star-half-stroke', 'fa-star');
			star.style.color = STAR_COLOR_DEFAULT
		}
	}

</script>


</body>
</html>
