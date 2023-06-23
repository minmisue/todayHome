<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>

	</style>
</head>
<body>
<script>
    $(function () {
        // 여기에서 메뉴 선택
        // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)
        // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
        // 두번째 파라미터에 null 입력시 메뉴바 숨김
        selectCurrentMenu(1, 5);

    });
</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content">
    <div class="body-main">
		<div id="tab-content" style="padding: 15px 10px 5px; clear: both;">
			<form name="eventForm" method="post">
				<table class="table table-border border-top2 table-form">
					<tr> 
						<td>제&nbsp;&nbsp;&nbsp;&nbsp;목</td>
						<td> 
							<input type="text" name="title" maxlength="100" class="form-control" value="${dto.title}">
						</td>
					</tr>
	
					<tr>
						<td>시작일자</td>
						<td> 
							<input type="date" name="startDate" class="form-control" value="${dto.sday}">
						</td>
					</tr>
	
					<tr>
						<td>종료일자</td>
						<td> 
							<input type="date" name="endDate" class="form-control" value="${dto.eday}">
						</td>
					</tr>
	
					<tr>
						<td>당첨인원</td>
						<td> 
							<p> <input type="text" name="winnerNumber" class="form-control" value="${dto.winnerNumber}"> </p>
							<p class="help-block">당첨 인원이 0이면 당첨자가 없습니다.</p>
						</td>
					</tr>
					<tr>
						<td>발표일자</td>
						<td>
							<p> 
								<input type="date" name="winningDate" class="form-control" value="${dto.wday}">
							</p>
							<p class="help-block">당첨 인원이 0이면 발표일자는 저장되지 않습니다.</p>
						</td>
					</tr>
					
					<tr> 
						<td>출력여부</td>
						<td> 
							<input type="checkbox" name="showEvent" id="showEvent" class="form-check-input" value="1" ${mode=="write" || dto.showEvent==1 ? "checked='checked' ":"" }>
							<label for="showEvent" class="form-check-label">표시</label>
						</td>
					</tr>
					
					<tr> 
						<td>대표이미지</td>
						<td> 
							<input type="file" name="eventImg" id="showEvent" class="form-check-input">
						</td>
					</tr>
				
					<tr> 
						<td valign="top">내&nbsp;&nbsp;&nbsp;&nbsp;용</td>
						<td valign="top"> 
							<textarea name="content" id="ir1" class="form-control"></textarea>
						</td>
					</tr>
				  
				</table>
					
				<table class="table">
					<tr> 
						<td align="center">
							<button type="button" class="btn btn-dark" onclick="submitContents(this.form);">${mode=='update'?'수정완료':'등록하기'}</button>
							<button type="reset" class="btn">다시입력</button>
							<button type="button" class="btn" onclick="location.href='${pageContext.request.contextPath}/admin/eventManage/${category}/list';">${mode=='update'?'수정취소':'등록취소'}</button>
								<input type="hidden" name="num" value="${dto.num}">
								<input type="hidden" name="page" value="${page}">
						</td>
					</tr>
				</table>
			</form>
		</div>		
		    	
	</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "ir1",
	sSkinURI: "${pageContext.request.contextPath}/resources/vendor/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
});

function submitContents(elClickedObj) {
	 oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
	 try {
		if(! check()) {
			return;
		}
		
		elClickedObj.submit();
		
	} catch(e) {
	}
}

function setDefaultFont() {
	var sDefaultFont = '돋움';
	var nFontSize = 12;
	oEditors.getById["ir1"].setDefaultFont(sDefaultFont, nFontSize);
}
</script>