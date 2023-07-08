<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp" />
<title>Home</title>

<style>
.edit-user-info__form-item {
	display: -webkit-box;
	display: -webkit-flex;
	display: -moz-flex;
	display: -ms-flexbox;
	display: flex;
}
</style>
</head>
<body>
	<script>
		$(function() {
			// 여기에서 메뉴 선택
			// 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
			// 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
			// 두번째 파라미터에 null 입력시 메뉴바 숨김
			selectCurrentMenu(1, 1);

			// 마이페이지일때 메뉴
			// 메인메뉴, 서브메뉴 숫자 입력
			// 첫번째 파라미터에 0 입력시 숨김
			selectMyPage(3, 3);
		});
	</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp" />

	<div class="main-container">
		<div class="content">
			<div class="edit-user-info__header">
				<div class="edit-user-info__header__title">회원정보수정</div>
				<a class="edit-user-info__header__withdrawals"
					href="/withdrawals/new">탈퇴하기</a>
			</div>
			<form action="">
				<div class="edit-user-info__form-item">
					<div class="edit-user-info__form-item__title">
						이메일
						<div class="edit-user-info__form-item__title__require">*
							필수항목</div>
					</div>
					<div class="expert-form-group edit-user-info__form-item__group">
						<div class="expert-form-group__content">
							<div class="expert-form-group__input">
								<div class="edit-user-info__form-item__field">
									<div class="input-group email-input">
										<span class="email-input__local"> <label><input
												class="form-control" placeholder="이메일" size="1"
												value="zz5036"> <span class="form-control-blind">이메일
													앞 주소 입력하기</span> </label></span><span class="email-input__separator">@</span> <span
											class="email-input__domain"> <label> <select
												class="form-control">
													<option value="" disabled="">선택해주세요</option>
													<option value="naver.com">naver.com</option>
													<option value="hanmail.net">hanmail.net</option>
													<option value="daum.net">daum.net</option>
													<option value="gmail.com">gmail.com</option>
													<option value="nate.com">nate.com</option>
													<option value="hotmail.com">hotmail.com</option>
													<option value="outlook.com">outlook.com</option>
													<option value="icloud.com">icloud.com</option>
													<option value="_manual">직접입력</option>
											</select> <span class="form-control-blind">이메일 도메인 선택하기</span>
										</label></span>
									</div>
									<div class="edit-user-info__form-item__field__warning">이메일을
										변경하시려면 운영자에게 이메일을 보내주세요.</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="edit-user-info__form-item">
					<div class="edit-user-info__form-item__title">
						별명
						<div class="edit-user-info__form-item__title__require">*
							필수항목</div>
					</div>
					<div class="expert-form-group edit-user-info__form-item__group">
						<div class="expert-form-group__content">
							<div class="expert-form-group__input">
								<div class="edit-user-info__form-item__field">
									<div class="edit-user-info__input">
										<input class="form-control" value="김성태114">
										<div class="edit-user-info__input__error"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="edit-user-info__form-item">
					<div class="edit-user-info__form-item__title">홈페이지</div>
					<div class="expert-form-group edit-user-info__form-item__group">
						<div class="expert-form-group__content">
							<div class="expert-form-group__input">
								<div class="edit-user-info__form-item__field">
									<input placeholder="https://ohou.se" class="form-control"
										value="">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="edit-user-info__form-item">
					<div class="edit-user-info__form-item__title">성별</div>
					<div class="expert-form-group edit-user-info__form-item__group">
						<div class="expert-form-group__content">
							<div class="expert-form-group__input">
								<div
									class="edit-user-info__form-item__field edit-user-info__form-item__field--sex">
									<ul class="radio-group-input">
										<li><div class="form-radio">
												<label class="form-radio-label"><input
													class="form-radio" type="radio"><span
													class="radio-img"></span><span>남성</span></label>
											</div></li>
										<li><div class="form-radio">
												<label class="form-radio-label"><input
													class="form-radio" type="radio"><span
													class="radio-img"></span><span>여성</span></label>
											</div></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="edit-user-info__form-item">
					<div class="edit-user-info__form-item__title">생년월일</div>
					<div class="expert-form-group edit-user-info__form-item__group">
						<div class="expert-form-group__content">
							<div class="expert-form-group__input">
								<div class="edit-user-info__form-item__field">
									<div class="DayPickerInput">
										<input placeholder="YYYY-MM-DD"
											class="form-control date-input__text" value="">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="edit-user-info__form-item">
					<div class="edit-user-info__form-item__title">프로필 이미지</div>
					<div class="expert-form-group edit-user-info__form-item__group">
						<div class="expert-form-group__content">
							<div class="expert-form-group__input">
								<div
									class="edit-user-info__form-item__field edit-user-info__form-item__field--profile">
									<div class="image-single-input-wrap">
										<ul class="image-single-input">
											<li class="image-single-input__entry"><button
													class="image-single-input__entry__button" type="button">
													<img class="image-single-input__entry__image"
														src="https://image.ohou.se/i/bucketplace-v2-development/uploads/default_images/avatar.png?gif=1&amp;w=640&amp;h=640&amp;c=c"
														srcset="https://image.ohou.se/i/bucketplace-v2-development/uploads/default_images/avatar.png?gif=1&amp;w=960&amp;h=960&amp;c=c 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/default_images/avatar.png?gif=1&amp;w=1280&amp;h=1280&amp;c=c 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/default_images/avatar.png?gif=1&amp;w=1920&amp;h=1920&amp;c=c 3x">
												</button></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="edit-user-info__form-item">
					<div class="edit-user-info__form-item__title">한줄 소개</div>
					<div class="expert-form-group edit-user-info__form-item__group">
						<div class="expert-form-group__content">
							<div class="expert-form-group__input">
								<div class="edit-user-info__form-item__field">
									<input maxlength="41" class="form-control" value="">
								</div>
							</div>
						</div>
					</div>
				</div>
				<button
					class="button button--color-blue button--size-50 button--shape-4 edit-user-info__submit"
					type="submit">회원 정보 수정</button>
			</form>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp" />
</body>
</html>
