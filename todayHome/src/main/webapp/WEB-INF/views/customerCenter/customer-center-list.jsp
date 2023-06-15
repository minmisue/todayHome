<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp" />
<title>Home</title>

<style>
.flex-col {
	display: flex;
	flex-direction: column;
}

.flex-row {
	display: flex;
	flex-direction: row;
}

.a-font {
	text-decoration: none;
	font-size: 15px;
	line-height: 24px;
	font-weight: 500;
	color: #2F3438;
	margin-bottom: 13px
}

.span-font {
	font-size: 16px;
	line-height: 20px;
	color: rgb(53, 197, 240);
	margin-right: 8px;
}

.h2-font {
	font-size: 20px;
	line-height: 28px;
	font-weight: 700;
}

.detail-font {
	font-size: 14px;
	line-height: 20px;
	color: rgb(130, 140, 148);
	position: relative;
	padding-left: 20px;
}

.customer-title-items button {
	flex: auto;
	text-align: center;
	height: 38px;
	border-radius: 19px;
	padding-left: 14px;
	padding-right: 14px;
	background-color: white;
	font-size: 14px;
	border: none;
}

.customer-title-items button:hover {
	background-color: #DAD7D5
}

.customer-center-btn {
	flex: auto;
	max-height: 44px;
	border: none;
	background: none rgb(53, 197, 240);
	font-style: inherit;
	font-weight: 400;
	box-sizing: border-box;
	text-align: center;
	color: rgb(255, 255, 255);
	border-radius: 4px;
	margin-top: 10px;
	line-height: 40px;
	font-size: 14px;
	
}

.acd-font {
	font: inherit;
    color: #2F3438;
    font-size: 16px
}

</style>

<script type="text/javascript">
$(function() {
	$(".a-font").click(function() {
		
	});
})

</script>
</head>
<body>
	<script>
		$(function() {
			// 여기에서 메뉴 선택
			// 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
			// 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
			selectCurrentMenu(1, null)
		});
	</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp" />

	<div class="main-container">
		<div class="content">
			<div class="flex-col" style="width: 850px; margin: 0 auto;">
				<div class="flex-row"
					style="margin-bottom: 60px">
					<div class="flex-col">
						<h2 class="h2-font">무엇을 도와 드릴까요?</h2>
						<div style="margin-bottom: 6px;">
							<a class="a-font" href="#"> <span class="span-font">Q
							</span>배송은 얼마나 걸리나요?
							</a>
						</div>
						<div style="margin-bottom: 6px;">
							<a class="a-font" href="#"> <span class="span-font">Q
							</span>주문 취소는 어떻게 하나요??
							</a>
						</div>
						<div style="margin-bottom: 6px;">
							<a class="a-font" href="#"> <span class="span-font">Q
							</span>제품의 자세한 정보를 알고 싶어요.
							</a>
						</div>
						<div style="margin-bottom: 6px;">
							<a class="a-font" href="#"> <span class="span-font">Q
							</span>제품이 불량일 때는?
							</a>
						</div>
						<div style="margin-bottom: 6px;">
							<a class="a-font" href="#"> <span class="span-font">Q
							</span>카카오 계정으로 로그인하면 이미 가입되었다고 합니다.
							</a>
						</div>
					</div>

					<div style="margin-left: 60px; width: 375px" class="flex-col">
						<div class="flex-row"
							style="font-size: 20px; line-height: 28px; font-weight: 700; margin-bottom: 6px;">
							<div style="margin-right: 10px">고객센터</div>
							<div style="color: rgb(53, 197, 240);">09:00 ~ 18:00</div>
						</div>

						<div class="detail-font">평일: 전체문의 상담가능</div>

						<div class="detail-font" style="margin-bottom: 40px">주말/공휴일
							: 오늘의집 직접배송 및 이사/시공/수리 문의에 한해 전화 상담 가능</div>

						<div
							style="font-size: 20px; line-height: 28px; font-weight: 700; margin-bottom: 6px; color: rgb(53, 197, 240);">
							<i class="bi bi-telephone"></i>1670-0876
						</div>
							
						
					</div>
				</div>

				<div>
					<div class="flex-row customer-title-items"
						style="align-items: center;gap: 8px;margin-bottom:50px ">
						<button>전체</button>
						<button>주문/결제</button>
						<button>배송관련</button>
						<button>취소/환불</button>
						<button>반품/교환</button>
						<button>증빙서류발급</button>
						<button>로그인회원정보</button>
						<button>서비스/기타</button>
					</div>
				</div>

				<div class="accordion accordion-flush" id="accordionFlushExample">
					<div class="accordion-item">
						<h2 class="accordion-header" id="flush-headingOne">
							<button class="accordion-button collapsed acd-font" type="button"
								data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
								aria-expanded="false" aria-controls="flush-collapseOne">
								<span class="span-font">Q</span>주문 내역은 어떻게 확인할 수 있나요 ?</button>
						</h2>
						<div id="flush-collapseOne" class="accordion-collapse collapse"
							aria-labelledby="flush-headingOne"
							data-bs-parent="#accordionFlushExample">
							<div class="accordion-body">
								우측 상단 프로필 사진을 클릭 후 [나의쇼핑]을 통해 확인 가능합니다
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp" />
</body>
</html>
