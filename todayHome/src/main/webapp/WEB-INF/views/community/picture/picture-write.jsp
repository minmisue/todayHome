<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menubar.css">
	<link rel="icon" href="data:;base64,iVBORw0KGgo=">
	<title>Home</title>


<style type="text/css">
* { padding: 0; margin: 0; }
*, *::after, *::before { box-sizing: border-box; }

body {
	font-family:"Malgun Gothic", "맑은 고딕", NanumGothic, 나눔고딕, 돋움, sans-serif;
	font-size: 14px;
	color: #222;
}

a { color: #222; text-decoration: none; cursor: pointer; }
a:active, a:hover { color: #f28011; text-decoration: underline; }

/* form-control */
.btn {
	color: #333;
	border: 1px solid #999;
	background-color: #fff;
	padding: 5px 10px;
	border-radius: 4px;
	font-weight: 500;
	cursor:pointer;
	font-size: 14px;
	font-family: "맑은 고딕", 나눔고딕, 돋움, sans-serif;
	vertical-align: baseline;
}
.btn:active, .btn:focus, .btn:hover {
	background-color: #f8f9fa;
	color:#333;
}
.btn[disabled], fieldset[disabled] .btn {
	pointer-events: none;
	cursor: default;
	opacity: .65;
}

.form-control {
	border: 1px solid #999; border-radius: 4px; background-color: #fff;
	padding: 5px 5px; 
	font-family: "맑은 고딕", 나눔고딕, 돋움, sans-serif;
	vertical-align: baseline;
}

     .photointroduction{
      	    font-size: 15px; 
      	    padding: 10px 15px; 
      	    border: 1px solid rgb(218, 221, 224); 
      	    border-radius: 4px; 
      	    min-height: 150px;
      	    resize: none;
      	    width: 100%;
        }
        
.form-control[readonly] { background-color:#f8f9fa; }

textarea.form-control { height: 170px; resize : none; }

.form-select {
	border: 1px solid #999; border-radius: 4px; background-color: #fff;
	padding: 4px 5px; 
	font-family: "맑은 고딕", 나눔고딕, 돋움, sans-serif;
	vertical-align: baseline;
}
.form-select[readonly] { background-color:#f8f9fa; }

textarea:focus, input:focus { outline: none; }
input[type=checkbox], input[type=radio] { vertical-align: middle; }

/* table */
.table { width: 100%; border-spacing: 0; border-collapse: collapse; }
.table th, .table td { padding-top: 10px; padding-bottom: 10px; }

.table-border thead > tr { border-top: 2px solid #212529; border-bottom: 1px solid #ced4da; }
.table-border tbody > tr { border-bottom: 1px solid #ced4da; }
.table-border tfoot > tr { border-bottom: 1px solid #ced4da; }
.td-border td { border: 1px solid #ced4da; }

.clear { clear: both; }
.clear:after { content:''; display:block; clear: both; }

.mx-auto { margin-left: auto; margin-right: auto; }

.container {
	max-width: 900px;
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
}

.body-container {
	min-height: 500px;
}

.body-title {
    color: #424951;
    padding-top: 35px;
    padding-bottom: 7px;
    margin: 0 0 25px 0;
    border-bottom: 2px solid #e0f0fe;
}
.body-title h2 {
    font-size: 24px;
    min-width: 300px;
    font-family:"Malgun Gothic", "맑은 고딕", NanumGothic, 나눔고딕, 돋움, sans-serif;
    color: #023b6d;
    font-weight: 700;
    padding-bottom: 10px;
    display: inline-block;
    margin: 0 0 -7px 0;
    border-bottom: 3px solid #002e5b;
}

.body-main {
	display: block;
	padding-bottom: 15px;
}

form .form-control {
	width: 99%;
}

.content-row {
	display: flex;
	width: 100%;
	height: 400px;
	padding: 5px;
	border: 1px solid #ccc;
	margin-bottom: 5px;
	align-items: center;
	justify-content: space-between;
}



.left-item, .right-item {
	width: 50%;
	height: 330px;
	padding: 5px;
}

.image-main {
	border: none;
    flex-direction: column;
	height: 400px;
	background-color: #F8F9FA;
	display: flex;
	align-items: center;
	justify-content: center;
    text-align: center;
	
}
.image-footer {
	padding: 5px;
}

.image-main .img-add {
	cursor: pointer;
	border: 1px solid #ccc;
	width: 65px;
	height: 65px;
	border-radius: 5px;
	background-image: url("${pageContext.request.contextPath}/resources/images/add_photo.png");
}

.image-main .img-viewer {
	width: 0%;
	height: 0%;
	position: relative;
	z-index: 9999;
	background-repeat : no-repeat;
	background-size : cover;
}

.icon-area {
	position: absolute;
	height: 15px;
	width: 15px;
	z-index: 99999;
	color: #F06571;
}

 .abledButton {
   padding: 10px 45px;
   background-color: #35c5f0;	
   color: white;
   border-radius: 4px;
   border-style: none;
}

.contentCategory {
	width: 100%;
	margin-top: 15px; 
	padding: 10px 15px; 
	border: 1px solid rgb(218, 221, 224); 
	border-radius: 4px; 
	font-size: 15px
}	

.content-row.ui-state-default.ui-sortable-handle {
	border: none;
}
</style>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.4.0/css/all.css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/smoothness/jquery-ui.css" type="text/css">

<style type="text/css">
.ui-state-default { 
	background: none;
}
</style>



</head>
<body>
<header>
	<div class="menubar-container">
		<div class="menubar-item-bundle" style="gap: 30px">
			<img class="logo" src="${pageContext.request.contextPath}/resources/picture/logo.png" onclick="location.href='${pageContext.request.contextPath}/home'">
		</div>

		<div class="menubar-item-bundle" style="gap: 18px">
			<button type="button" class="abledButton" onclick="sendOk();">올리기</button>
			<input type="hidden" name="boardTypeId" id="boardTypeId" value="1">
		</div>
	</div>
</header>
<main>
	<div class="container body-container">
	    <div class="body-title">
			<h2><i class="far fa-image"></i> </h2>
	    </div>
	    
	    <div class="body-main mx-auto">
			<form name="postsForm" method="post" enctype="multipart/form-data">
				
				<div class="content-area sortable">
					<div class="content-row ui-state-default">
						<div class="left-item">
							<div class="image-main">
								<img class="img-add" style="width: 25px; height: 25px" src="${pageContext.request.contextPath}/resources/picture/camera.png">
								<div style="font-weight: 700; color: rgb(130, 140, 148); margin-bottom: 4px; margin-top: 10px;">사진을 끌어다 놓으세요</div>
								<div style="font-size: 14px; font-weight: 500; color: rgb(130, 140, 148); margin-bottom: 15px;">10장까지 올릴 수 있어요.</div>
								<input type="file" name="selectFile" accept="image/*" style="display: none;">
								<label for="selectFile">PC에서 불러오기</label>
								<div class="img-viewer"></div>
							</div>
							<div class="image-footer">
								<button type="button" class="btn btnContentPlus" title="추가"> <i class="fa-solid fa-plus"></i> </button>
								<button type="button" class="btn btnContentMinus" disabled="disabled" title="삭제"> <i class="fa-solid fa-minus"></i> </button>
								<button type="button" class="btn btnImageInit" title="이미지 제거"> <i class="fa-solid fa-arrows-rotate"></i> </button>
							</div>
						</div>
						<div class="right-item">
							<div>
								<textarea name="contents" class="photointroduction" placeholder="어떤 사진인지 짧은 소개로 시작해보세요."></textarea>
							</div>
							<div>
							<select class="contentCategory" name="userBoardContentCategoryIds" id="userBoardContentCategoryId">
									<option value="0" style="color: rgb(194, 200, 204)">공간 정보 추가</option>
									<option value="1">원룸</option>
									<option value="2">거실</option>
									<option value="3">침실</option>
									<option value="4">주방</option>
									<option value="5">욕실</option>
									<option value="6">아이방</option>
									<option value="7">드레스룸</option>
									<option value="8">서재,작업실</option>
									<option value="9">베란다</option>
									<option value="10">사무공간</option>
									<option value="11">상업공간</option>
									<option value="12">가구,소품</option>
									<option value="13">현관</option>
									<option value="14">외관,기타</option>
							</select>
							</div>
							<div>
								<input type="text" name="contentSequences" value="1">
								<input type="text" name="positions">
								<input type="text" name="productIds" value="421">
								
								<!-- Modal -->
								<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
								  <div class="modal-dialog">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
								        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
								      </div>
								      <div class="modal-body">
								        ...
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
								        <button type="button" class="btn btn-primary">Save changes</button>
								      </div>
								    </div>
								  </div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>	    
	</div>

</main>
	
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<script type="text/javascript">
function sendOk() {
	const f = document.postsForm;
	let str;
	
	str = f.selectFile.value.trim();
	if(!str){
		alert("사진을 등록하세요.");
		return false;
	}
	

	
	f.action = "${pageContext.request.contextPath}/community/picture/${mode}";
	f.submit();
}

$(function(){
	$("form").on("click", ".img-add", function(event){
		let $inputFile = $(this).closest(".image-main").find("input[name=selectFile]");
		$inputFile.trigger("click"); 
	});
	
	$("form").on("change", "input[name=selectFile]", function(event){
		let $viewer = $(this).closest(".image-main").find(".img-viewer");
		let $add = $(this).closest(".image-main").find(".img-add");
		
		let file = this.files[0];
		if(! file) {
			$viewer.css({"width":"0", "height":"0"})
			$viewer.hide();
			$add.show();

			$viewer.empty();
			$viewer.css("background-image", "");
			
			return false;
		}
		
		let reader = new FileReader();
		reader.onload = function(e) {
			$viewer.css({"width":"100%", "height":"100%"})
			$viewer.show();
			$add.hide();
			
			$viewer.empty();
			$viewer.css("background-image", "url("+e.target.result+")");
			
		}
		reader.readAsDataURL(file);
	});
});
 
$(function(){
	$("form").on("click", ".btnContentPlus", function(){
		// 컨텐츠 추가
		let $newRows = $(this).closest(".content-row").clone(true);
		
		let $viewer = $newRows.find(".img-viewer");
		
		let $add = $newRows.find(".img-add");
		let $inputFile = $newRows.find("input[name=selectFile]");
		
		$viewer.css({"width":"0", "height":"0"})
		$viewer.hide();
		$add.show();

		$viewer.empty();
		$viewer.css("background-image", "");
		
		
		$inputFile.val("");
		$newRows.find("textarea[name=contents]").val("");
		$newRows.find("input[name=titles]").val("");
		$newRows.find("input[name=positions]").val("");
		
		$(".content-area").append($newRows);
		numberSetting();
		
		$(".content-area").find(".btnContentMinus").prop("disabled", false);
	});

	$("form").on("click", ".btnContentMinus", function(){
		// 컨텐츠 삭제
		let cnt = $(".content-area").find(".content-row").length;
		if(cnt === 1) {
			return false;
		} else if(cnt === 2) {
			$(".content-area").find(".btnContentMinus").prop("disabled", true);
		}
		
		$(this).closest(".content-row").remove();
		numberSetting();
	});
	
	$("form").on("click", ".btnImageInit", function(){
		// 이미지 초기화
		let $viewer = $(this).closest(".left-item").find(".img-viewer");
		let $add = $(this).closest(".left-item").find(".img-add");
		let $inputFile = $(this).closest(".left-item").find("input[name=selectFile]");
		
		$viewer.css({"width":"0", "height":"0"})
		$viewer.hide();
		$add.show();

		$viewer.empty();
		$viewer.css("background-image", "");
		
		$inputFile.val("");
		$(this).closest(".content-row").find("input[name=positions]").val("");
	});
	
	function numberSetting() {
		let n = 1;
		
		let inputEls = document.querySelectorAll("form input[name=contentSequences]");
		for(let el of inputEls) {
			el.value = n++;
		}
	}
	
	$('form').on('click', '.img-viewer', function(e){
		let $row = $(this).closest('.content-row');
		let inputEL = $row.find('input[name=positions]');
		let positions = inputEL.val();
		
		let x = e.offsetX;
		let y = e.offsetY;
		let pos = x + ':' + y;
		
		let $icon = $('<div>', {'html':'<i class="fa-solid fa-location-pin img-icon"></i>', 
						'class':'icon-area', 'data-position':pos});
		
		// $icon.css({left:x+'px', top:y+'px'});
		$icon.offset( {left:x, top:y} );
		
		$(this).append($icon);
		
		if(positions) {
			positions += ',' + pos;
		} else {
			positions = pos;
		}
		
		inputEL.val(positions);
	});
	
	$('form').on('click', '.img-icon', function(e){
		// 아이콘 제거
		e.stopPropagation();

		let $row = $(this).closest('.content-row');
		let $iconArea = $(this).closest('.icon-area');
		let inputEL = $row.find('input[name=positions]');
		let positions = inputEL.val();
		
		let pos = $iconArea.attr('data-position');
		pos = positions.indexOf(pos+',') === -1 ? pos : pos + ',';
		positions = positions.replace(pos, '');
		if(positions.length > 0 && positions.charAt(positions.length - 1) === ',') {
			positions = positions.slice(0, positions.length - 1);
		}
			
		inputEL.val(positions);
		
		$iconArea.remove();
	});

	// 드래그로 순서 변경
    $( ".sortable" ).sortable({
    	 update : function(e,ui){
    		 // 순서 변경후
    		 numberSetting();
    	 }
    });
});
</script>
	
</body>
</html>