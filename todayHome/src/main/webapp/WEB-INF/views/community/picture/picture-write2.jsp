<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menubar.css">
	<title>Home</title>
	

	<style>
        .selected-sub-item {
            font-weight: bold;
            color: #303438;
            border-bottom: 2px solid #303438;
        }

		.follow-user-item-img:hover .picture-content-container {
            color: #A0A0A0;
        }

        .upload-img-container {
			width: 40%;
			aspect-ratio: 1/1;
			background-color: #F8F9FA;
			border-radius: 4px;
			justify-content: center;
			align-items: center;
        }

        .disabledButton {
            padding: 10px 45px;
            background-color: #EBEDEF;
            color: #C3C7CC;
            border-radius: 4px
        }

        .abledButton {
            padding: 10px 45px;
            background-color: #35c5f0;
            color: white;
            border-radius: 4px;
            border-style: none;
        }

        .sub-menubar-write {
            justify-content: center;
            color: #848B93
        }
        
        .photointroduction{
      	    font-size: 15px; 
      	    padding: 10px 15px; 
      	    border: 1px solid rgb(218, 221, 224); 
      	    border-radius: 4px; 
      	    min-height: 150px;
      	    resize: none;
        }
        
        .photoAttach{
      	    font-size: 14px; 
      	    font-weight: 350; 
      	    border-radius: 4px; 
      	    padding: 8px 20px; 
      	    border: none; 
      	    background-color: rgb(53, 197, 240); 
      	    color: white;
      	   }
      	    
      	.custom-file-input {
		  position:  relative;
		  display: inline-block;
		  cursor: pointer;
		}
		
		.custom-file-input input[type="file"] {
		  position: absolute;
		  left: -9999px;
		}
		
		.custom-file-input label {
		  display: inline-block;
		  padding: 8px 20px;
		  background-color: #ccc;
		  color: #fff;
		  cursor: pointer;
		
        }
        
		#uploadedImagesContainer > img {
		width: 300px; /* 원하는 고정 가로 크기 */
		height: 300px; /* 원하는 고정 세로 크기 */
		overflow: hidden;
		position: relative;
		}
		
		.contentCategory {
		margin-top: 15px; 
		padding: 10px 15px; 
		border: 1px solid rgb(218, 221, 224); 
		border-radius: 4px; 
		font-size: 15px
		}
		 .image-container {
            position: relative;
            display: inline-block;
             cursor: pointer;
        }
        
          /* 이미지 스타일 */
        .image-container img {
            width: 300px; /* 원하는 고정 가로 크기 */
		height: 300px; /* 원하는 고정 세로 크기 */
        }

	      .marker {
            position: absolute;
            width: 5px;
            height: 5px;
            background-color: #35c5f0;
            border-radius: 50%;
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

<div class="main-container" >

	<div class="content" style="max-width: 970px; ">
		<div id="formContainer">
			<form name="housePictureBoardForm" method="post" enctype="multipart/form-data">
				
				<div class="flex-row sortable">
					<div class="flex-col upload-img-container" id="uploadContainer">
						<img class="img-add" style="width: 25px; height: 25px" src="${pageContext.request.contextPath}/resources/picture/camera.png">
						<div style="font-weight: 700; color: rgb(130, 140, 148); margin-bottom: 4px; margin-top: 10px;">사진을 끌어다 놓으세요</div>
						<div style="font-size: 14px; font-weight: 500; color: rgb(130, 140, 148); margin-bottom: 15px;">10장까지 올릴 수 있어요.</div>
						<div class="custom-file-input">
							<input type="file" name="selectFile" id="selectFile" accept="image/*" class="photoAttach">
							<label for="selectFile">PC에서 불러오기</label>
							<div id="uploadedImagesContainer"></div>
						</div>
					</div>
					
					<div class="flex-col" style="flex: 1; padding-left: 20px;">
						<textarea class="photointroduction" name="content" id="content" placeholder="어떤 사진인지 짧은 소개로 시작해보세요.">${boardContent.content}</textarea>
						<select class="contentCategory" name="userBoardContentCategoryId" id="userBoardContentCategoryId">
							<option style="color: rgb(194, 200, 204)">공간 정보 추가</option>
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
					  <input type="text" id="coordinateOutput" name="coordinateOutput">
					  <input type="text" name="numbers" value="1">
					</div>
					  <div class="flex-col" style="padding-left: 20px;"> </div>
				</div>
			</form>
		</div>
		<div class="image-footer">
			<button type="button" class="btn btnContentPlus" title="추가"> <i class="fa-solid fa-plus"></i> </button>
			<button type="button" class="btn btnContentMinus" disabled="disabled" title="삭제"> <i class="fa-solid fa-minus"></i> </button>
			<button type="button" class="btn btnImageInit" title="이미지 제거"> <i class="fa-solid fa-arrows-rotate"></i> </button>
		</div>	
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script type="text/javascript">

function sendOk() {
    const f = document.housePictureBoardForm;
	let str;

    str = f.content.value.trim();
    if(!str) {
        alert("내용을 입력하세요. ");
        f.content.focus();
        return;
    }	

    if(!f.selectFile.value) {
    	alert("이미지 파일을 추가하세요.");
    	f.selectFile.focus();
    	return;
    }

    f.action = "${pageContext.request.contextPath}/community/picture/${mode}";
    f.submit();
}

$(function(){
	$("form").on("click", ".img-add", function(event){
		let $inputFile = $(this).closest(".flex-col upload-img-container").find("input[name=selectFile]");
		$inputFile.trigger("click"); 
	});
	
	$("form").on("change", "input[name=selectFile]", function(event){
		let $viewer = $(this).closest(".flex-col upload-img-container").find(".uploadedImagesContainer");
		let $add = $(this).closest(".flex-col upload-img-container").find(".img-add");
		
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


$(document).ready(function() {
	  var coordinates = []; // 좌표를 저장할 배열
	  var markerCounter = 1; // 마커 개수를 저장할 변수

	  
	  // 이미지 클릭 이벤트 리스너 등록
	  $('#uploadedImagesContainer').on('click', 'img', function(event) {
	    var offsetX = event.offsetX; // 클릭된 위치의 x좌표
	    var offsetY = event.offsetY; // 클릭된 위치의 y좌표

	    // 좌표를 배열에 추가
		 coordinates.push({
				id: markerCounter,
				x: offsetX,
				y: offsetY
			});
	    
	
	    // 배열 출력
	    outputCoordinates();
	    
	    // 마커 추가
        addMarker(offsetX, offsetY);

        // 마커 개수 증가
        markerCounter++;
	  });

	  // 좌표 배열을 출력하는 함수
	  function outputCoordinates() {
	    var outputElement = $('#coordinateOutput');
	    outputElement.empty(); // 기존 내용 초기화

	    var coordinateText = coordinates.map(function(coordinate) {
	      return 'x:' + coordinate.x + ' y:' + coordinate.y;
	    }).join(', ');

	    outputElement.val(coordinateText);
	  }
	  
	  function addMarker(x, y) {
		    var marker = document.createElement('div');
            marker.className = 'marker';
            marker.style.left = x + 'px';
            marker.style.top = y + 'px';

            var imageContainer = document.createElement('div');
            imageContainer.className = 'image-container';
            var uploadedImage = document.querySelector('#uploadedImagesContainer img');
            imageContainer.appendChild(uploadedImage.cloneNode(true));
            imageContainer.appendChild(marker);

            uploadedImage.parentNode.replaceChild(imageContainer, uploadedImage);
	  }
	});
	
$(function(){
	$("form").on("click", ".btnContentPlus", function(){
		// 컨텐츠 추가
		let $newRows = $(this).closest(".flex-row").clone(true);
		
		let $viewer = $newRows.find(".uploadedImagesContainer");
		
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
		
		let inputEls = document.querySelectorAll("form input[name=numbers]");
		for(let el of inputEls) {
			el.value = n++;
		}
	}
});
</script>
</body>
</html>
