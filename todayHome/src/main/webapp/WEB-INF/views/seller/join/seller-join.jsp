<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp" />
<title>Home</title>

<style>
.seller-layout_header {
	text-align: center;
	margin-bottom: 80px;
}

.seller-layout_header_title {
	display: block;
	font-size: 40px;
	font-weight: 700;
	color: black;
}

.seller-layout_header_explain {
	text-align: left;
	display: flex;
	flex-wrap: wrap;
	box-sizing: border-box;
}

.seller-layout_header_explain_list {
	margin: 60px auto -30px;
	list-style-type: disc;
	font-size: 15px;
	color: black;
	line-height: 38px;
}

::marker {
	unicode-bidi: isolate;
	font-variant-numeric: tabular-nums;
	text-transform: none;
	text-indent: 0px !important;
	text-align: start !important;
	text-align-last: start !important;
}

.seller-layout_divider {
	margin-top: 60px;
	margin-bottom: 60px;
	border-bottom: 1px solid #dbdbdb;
}

.seller-layout_hr {
	margin: 0;
	border: none;
}

.col-10 {
	position: relative;
	min-height: 1px;
	box-sizing: border-box;
}

.container {
	
}

.row {
	display: flex;
	flex-wrap: wrap;
	box-sizing: border-box;
	margin-right: -10px;
	margin-left: -10px;
}

.offset-1 {
	margin-left: 8.33%
}

.sales-form_section_title {
	font-size: 20px;
	color: #000;
	margin-bottom: 40px;
	font-weight: 700;
}

.sales-form_form-group {
	margin-bottom: 20px;
}

.col-2 {
	position: relative;
	width: 20%; min-height : 1px;
	box-sizing: border-box;
	min-height: 1px;
}

.sales-form_form-label {
	font-weight: 700;
	line-height: 40px;
}

.sales-form_form-group_required {
	color: #f77;
}

.col-8 {
	position: relative;
	min-height: 1px;
	box-sizing: border-box;
	padding-right: 10px;
	padding-left: 10px;
}

.sales-form_form-control-wrap {
	width: 360px;
	display: flex;
	flex-flow: wrap;
	align-items: center;
}

.sales-form_form-description {
	font-size: 12px;
	line-height: 16px;
	color: #757575;
	margin-top: 8px;
}

.sales-form_divider {
	margin: 0 5px;
}

.btn {
	box-sizing: border-box;
	display: inline-block;
	border-width: 1px;
	border-style: solid;
	text-align: center;
	border-radius: 4px;
	font-weight: bold;
}

.btn-sm {
	line-height: 1;
	height: 40px;
	padding: 12px 0 13px;
	font-size: 15px;
}

.btn-priority {
	background-color: #35c5f0;
	border-color: #35c5f0;
	color: #ffffff;
}

.form-control {
	width: 20%;
}

.form-control::placeholder {
	color: #ccc;
}
.textarea.form-control{
	resize: none;
	line-height: 20px;
	padding-top: 9px;
	padding-bottom: 9px;
	height: auto;
}
.sales-form_private-policy{
	text-align: center;
}
.sales-form_private-policy_caption{
	font-size: 12px;
	line-height: 18px;
	margin-bottom: 20px;
	text-align: left;
}
.sales-form_private-policy_info{
	width: 100%;
	margin-bottom: 40px;
	line-height: 21px;
}
table{
	border-collapse: collapse;
	border-spacing: 0;
}
thead{
	display: table-header-group;
	vertical-align: middle;
	border-color: inherit;
}
tr{
	display: table-row;
	vertical-align: inherit;
	border-color: inherit;
}
td{
	display: table-cell;
	vertical-align: inherit;
	text-align: center;
}
tbody{
	display: table-row-group;
	vertical-align: middle;
	border-color: inherit;
	text-align: middle;
}
.sales-form_private-policy_info thead{
	background-color: #fafafa;
}
.sales-form_private-policy_info td{
	width: 33.33%;
	border: 1px solid #dbdbdb;
	margin-top: 40px;
	padding: 10px 13px;
}
.sales-form_private-policy_agree{
	font-size: 18px;
	display: inline-block;
}
.form-check-label{
	cursor: pointer;
	display: block;
	margin-bottom: 10px;
	padding-left: 32px;
	min-height: 22px;
	line-height: 22px;
	position: relative;
}
.check-img{
	box-sizing: border-box;
	height: 22px;
	width: 22px;
	border-radius: 4px;
	background-color: #ffffff;
	border: solid 1px #dbdbdb;
	display: block;
	position: absolute;
	left: 0;
	top: 0;
}
.check-img:after{
	content: "";
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%,-50%);
	box-sizing: border-box;
	display: block;
	width: 14px;
	height: 14px;
	background-size: 14px;
	background-image: url(/resources/images/ic-checkbox.png);
	opacity: 0;
}
.sales-form_private-policy_agree_require{
	color: #35c5f0;
	font-weight: 700;
}
.sales-form_btn-apply{
	margin-top: 60px;
	text-align: center;
}
.sales-form_btn-apply>button{
	width: 360px;
	display: inline-block;
}
.btn-lg{
	line-height: 1;
	height: 70px;
	padding: 26px 0;
	font-size: 18px;
}
.btn:hover{
	background-color: #469DCA;
    color: white;
}
</style>
</head>
<body>
	<script>
		
	</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp" />

	<div class="main-container">
		<div class="content">
			<div class="container">
				<div class="seller-layout_header">
					<h1 class="seller-layout_header_title">입점신청</h1>
					<div class="seller-layout_header_explain">
						<ul class="seller-layout_header_explain_list">
							<li>입점 신청 관련 궁금한 사항은 오늘의집 파트너 센터 가이드와 FAQ에서 확인하실 수 있습니다.</li>
							<li>자주 사용하는 메일 주소를 올바르게 입력해 주세요. 한 달 내에 기재해 주신 메일 주소로 입점
								결과를 보내드립니다.</li>
							<li>입점 검토 중에는 중복 신청이 불가합니다.</li>
							<li>기존 신청 건 수정/철회 및 해외 사업자 입점은 오늘의집 파트너센터>문의하기로 요청해 주세요.</li>
							<li>입점 거절 시 재입점 신청은 최고 6개월 후 가능합니다.</li>
						</ul>
					</div>
				</div>
				<div class="seller-layout_divider">
					<hr class="col-10 seller-layout_hr">
				</div>
			</div>
			<div class="container seller-layout_body">
				<form class="" method="post">
					<div class="sales-form_section">
						<div class="row">
							<div class="offset-1 col-10">
								<p class="sales-form_section_title">회사 정보</p>
							</div>
						</div>
						<div class="row sales-form_form-group">
							<div class="offset-1 col-2">
								<label class="sales-form_form-label"> 회사 이름 <span
									class="sales-form_form-group_required">*</span>
								</label>
							</div>
							<div class="col-8">
								<div class="sales-form_form-control-wrap">
									<input type="text" id="" name="" class="form-control"
										placeholder="오늘의집" style="width: 100%;">
									<p class="sales-form_form-description">※사업자등록증의 법인명 또는 상호명을
										입력하세요.</p>
								</div>
							</div>
						</div>
						<div class="row sales-form_form-group">
							<div class="offset-1 col-2">
								<label class="sales-form_form-label"> 사업자 등록번호 <span
									class="sales-form_form-group_required">*</span>
								</label>
							</div>
							<div class="col-8">
								<div class="sales-form_form-control-wrap">
									<input type="tel" id="" name="" class="form-control"
										placeholder="123"> <span class="sales-form_divider">-</span>
									<input type="tel" id="" name="" class="form-control"
										placeholder="45"> <span class="sales-form_divider">-</span>
									<input type="tel" id="" name="" class="form-control"
										placeholder="67890">
									<button class="btn btn-sm btn-priority"
										style="margin-left: 5px; width: 90px;" type="button">사업자
										확인</button>
								</div>
							</div>
						</div>
					<div class="row sales-form_form-group">
						<div class="offset-1 col-2">
							<label class="sales-form_form-label"> 대표브랜드 이름 <span
								class="sales-form_form-group_required">*</span>
							</label>
						</div>
						<div class="col-8">
							<div class="sales-form_form-control-wrap">
								<input type="text" id="" name="" class="form-control"
									placeholder="오늘의집 가구" style="width: 100%;">
							</div>
						</div>
					</div>
						
						<div class="seller-layout_divider">
							<hr class="col-10 seller-layout_hr">
						</div>

						<div class="offset-1 col-10">
							<p class="sales-form_section_title">영업담당자 정보</p>
						</div>
					</div>
					<div class="row sales-form_form-group">
						<div class="offset-1 col-2">
							<label class="sales-form_form-label"> 이름 <span
								class="sales-form_form-group_required">*</span>
							</label>
						</div>
						<div class="col-8">
							<div class="sales-form_form-control-wrap">
								<input type="text" id="" name="" class="form-control"
									placeholder="집냥이" style="width: 100%;">
							</div>
						</div>
					</div>
					<div class="row sales-form_form-group">
						<div class="offset-1 col-2">
							<label class="sales-form_form-label"> 전화번호 <span
								class="sales-form_form-group_required">*</span>
							</label>
						</div>
						<div class="col-8">
							<div class="sales-form_form-control-wrap">
								<input type="tel" id="" name="" class="form-control"
									placeholder="010" style="width: 30%;"> <span
									class="sales-form_divider">-</span> <input type="tel" id=""
									name="" class="form-control" placeholder="1234"
									style="width: 30%;"> <span class="sales-form_divider">-</span>
								<input type="tel" id="" name="" class="form-control"
									placeholder="5678" style="width: 30%;">
							</div>
						</div>
					</div>
					<div class="row sales-form_form-group">
						<div class="offset-1 col-2">
							<label class="sales-form_form-label"> 이메일 <span
								class="sales-form_form-group_required">*</span>
							</label>
						</div>
						<div class="col-8">
							<div class="sales-form_form-control-wrap">
								<input type="text" id="" name="" class="form-control"
									placeholder="zipnyang@ohou.se" style="width: 100%;">
							</div>
						</div>
					</div>
					<div class="row sales-form_form-group">
						<div class="offset-1 col-2">
							<label class="sales-form_form-label"> 비밀번호 <span
								class="sales-form_form-group_required">*</span>
							</label>
						</div>
						<div class="col-8">
							<div class="sales-form_form-control-wrap">
								<input type="text" id="" name="" class="form-control"
									placeholder="6자이상" style="width: 100%;">
							</div>
						</div>
					</div>	
					<div class="row sales-form_form-group">
						<div class="offset-1 col-2">
							<label class="sales-form_form-label"> 판매자 소개 <span
								class="sales-form_form-group_required">*</span>
							</label>
						</div>
						<div class="col-8">
							<textarea class="form-control" placeholder="판매자에 대한 설명을 입력해주세요."  style="width: 100%;"></textarea>
						</div>
					</div>
									
					<div class="seller-layout_divider">
						<hr class="col-10 seller-layout_hr">
					</div>
					<div class="sales-form_section">
						<div class="row">
							<div class="offset-1 col-10">
								<p class="sales-form_section_title">개인정보 수집 및 이용 동의
							</div>
						</div>
						<div class="row sales-form_private-policy">
							<div class="offset-1 col-10">
								<p class="sales-form_private-policy_caption">
								㈜버킷플레이스는 개인정보보호법, 정보통신망 이용촉진 및 정보보호 
								등에 관한 법률 등 관련 법령상의 개인정보보호 규정을 준수하며, 
								판매자님이 입점신청 시 필요한 최소한의 개인 정보를 수집합니다. 
								개인정보 수집에 동의를 거부할 수 있으나 거부 시 입점 신청이 제한될 수 있습니다.
								</p> 
								<table class="sales-form_private-policy_info">
									<thead>
										<tr>
											<td>목적</td>
											<td>항목</td>
											<td>보유기간</td>
										</tr>
									</thead>
									<tbody> 
										<tr>
											<td>판매자 식별,입점 검토,공지사항의 전달</td>
											<td>영업담당자의 이름/전화번호/이메일</td>
											<td>
												<strong>입점 처리 종료 시까지(입점 심사 탈락 시 결정일로부터 6개월 이내)</strong>
											</td>
										</tr>
									</tbody>
								</table>
								
								<div class="form-check sales-form_private-policy_agree">
									<label class="form-check-label">
										<input type="checkbox" class="check-img">
										"입점신청을 위한 개인정보 수집 및 이용에 동의&nbsp;"
										<span class="sales-form_private-policy_agree_require">(필수)</span>
									</label>
								</div>		
							</div>
						</div>
					</div>
					
					<div class="sales-form_btn-apply">
						<button class="btn btn-lg btn-priority" type="submit">입점신청 완료</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<jsp:include page="/WEB-INF/views/fragment/footer.jsp" />
</body>
</html>
