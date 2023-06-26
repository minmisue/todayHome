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
    
	function isValidDateFormat(data){
		if(data.length !== 8 && data.length !== 10) return false;
			
		let p = /(\.)|(\-)|(\/)/g;
		data = data.replace(p, "");
		if(data.length !== 8) return false;
		
		let format = /^[12][0-9]{7}$/;
		if(! format.test(data)) return false;
	    
		let y = parseInt(data.substr(0, 4));
		let m = parseInt(data.substr(4, 2));
		let d = parseInt(data.substr(6));
	
		if(m<1 || m>12) return false;
		let lastDay = (new Date(y, m, 0)).getDate();
		if(d<1 || d>lastDay) return false;
		
		return true;
	}

    function check() {
        const f = document.eventForm;
        let mode = "${mode}";

    	let str = f.title.value;
        if(!str) {
            alert("제목을 입력하세요. ");
            f.title.focus();
            return false;
        }

    	if(! isValidDateFormat(f.sday.value)) {
    		alert("날짜를 입력하세요.");
    		f.sday.focus();
    		return false;
    	}
    	
    	if(! /^[0-2][0-9]:[0-5][0-9]$/.test(f.stime.value)) {
    		alert("시간을 입력하세요.");
    		f.stime.focus();
    		return false;
    	}


    	if(! isValidDateFormat(f.eday.value)) {
    		alert("날짜를 입력하세요.");
    		f.eday.focus();
    		return false;
    	}
    	
    	if(! /^[0-2][0-9]:[0-5][0-9]$/.test(f.etime.value)) {
    		alert("시간을 입력하세요.");
    		f.etime.focus();
    		return false;
    	}
    	
    	let sd = new Date(f.sday.value + " " + f.stime.value);
    	let ed = new Date(f.eday.value + " " + f.etime.value);
    	
    	if( sd.getTime() >= ed.getTime() ) {
    		alert("시작날짜는 종료날짜보다 크거나 같을 수 없습니다.");
    		f.sday.focus();
    		return false;
    	}

    	if( mode === "write" && new Date().getTime() > ed.getTime() ) {
    		alert("종료날짜는 현재 시간보다 작을수 없습니다.");
    		f.eday.focus();
    		return false;
    	}
    	
    	if(!/^(\d)+$/.test(f.winnerNumber.value)) {
    		alert("당첨인원을 입력 하세요.");
    		f.winnerNumber.focus();
    		return false;
    	}
    	
    	if(f.winnerNumber.value !== "0") {
        	if(! isValidDateFormat(f.wday.value)) {
        		alert("날짜를 입력하세요.");
        		f.wday.focus();
        		return false;
        	}
        	
        	if(! /^[0-2][0-9]:[0-5][0-9]$/.test(f.wtime.value)) {
        		alert("시간을 입력하세요.");
        		f.wtime.focus();
        		return false;
        	}
        	
    		let wd = new Date(f.wday.value + " " + f.wtime.value);
    		
        	if( wd.getTime() < ed.getTime() ) {
        		alert("당첨일자는 종료날짜보다 작을수 없습니다.");
        		f.wday.focus();
        		return false;
        	}    		
    	}
        
    	str = f.content.value;
    	if( !str || str === "<p><br></p>" ) {
            alert("내용을 입력하세요. ");
            f.content.focus();
            return false;
        }

    	f.action = "${pageContext.request.contextPath}/event/write";

        return true;
    }
</script>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content">
		    <div class="body-main">
				<div id="tab-content" style="padding: 15px 10px 5px; clear: both;">
					<form name="eventForm" method="post" enctype="multipart/form-data">
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
									<input type="date" name="sday" class="form-control" value="${dto.sday}">
									<input type="time" name="stime" class="form-control" value="${dto.stime}">
								</td>
							</tr>
			
							<tr>
								<td>종료일자</td>
								<td> 
									<input type="date" name="eday" class="form-control" value="${dto.eday}">
									<input type="time" name="etime" class="form-control" value="${dto.etime}">
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
										<input type="date" name="wday" class="form-control" value="${dto.wday}">
										<input type="time" name="wtime" class="form-control" value="${dto.wtime}">
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
								<td>대표 이미지</td>
								<td> 
									<input type="file" name="selectFile" class="form-check-input">
								</td>
							</tr>
						
							<tr> 
								<td valign="top">내&nbsp;&nbsp;&nbsp;&nbsp;용</td>
								<td valign="top"> 
									<textarea name="content" id="ir1" class="form-control">${dto.content}</textarea>
								</td>
							</tr>
						  
						</table>
							
						<table class="table">
							<tr> 
								<td align="center">
									<button type="button" class="btn btn-dark" onclick="submitContents(this.form);">${mode=='update'?'수정완료':'등록하기'}</button>
									<button type="reset" class="btn">다시입력</button>
									<button type="button" class="btn" onclick="location.href='${pageContext.request.contextPath}/event/list';">${mode=='update'?'수정취소':'등록취소'}</button>
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