<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
		.product-img {
			width: 100%;
			height: 150px;
			object-fit: cover;
			border-radius: 5px;
		}

		.main-container {
			padding-bottom: 40px;
		}

		.sub-menu button {
			border-radius: 5px;
		}

		.sub-menu {
			width: 100%;
			height: 40px;
			display: flex;
			flex-direction: row;
			gap: 5px;
			justify-content: space-between;
			margin-bottom: 30px;
		}

		.main-content-card {
			text-align: left;
			background: white;
			border-radius: 20px;
			/*min-height: 400px;*/
			width: 100%;
			display: flex;
			flex-direction: column;
			/*gap: 35px;*/
		}

		textarea {
			height: 200px;
		}

		.product-card {
			width: 100%;
			height: 50px;
			display: grid;
			grid-template-columns: 45% 40% 15%;
			border-radius: 5px;
			text-align: center;
			padding: 0 5px;
			align-items: center;
			border: 1px solid #eaeaea;
			transition: 0.5s;
		}

		.product-card-menu {
			width: 100%;
			height: 50px;
			display: grid;
			grid-template-columns: 45% 40% 15%;
			border-radius: 5px;
			text-align: center;
			padding: 0 5px;
			align-items: center;
			border: 1px solid #eaeaea;
			transition: 0.5s;
			color: white;
		}

		.product-card-container {
			display: flex;
			flex-direction: column;
			gap: 10px;
			width: 100%;
		}

		.product-card:hover {
			background: #e7e7e7;
			cursor: pointer;
		}

		.selected-product {
			height: 100px;
			border: 1px solid #DFE2E6;
			border-radius: 8px;
		}

		.product-info {
			text-align: center;
		}

		.input-group {
		}

		.product-name-preview {
			font-weight: 600; font-size: 20px
		}

		input[type="number"]::-webkit-outer-spin-button,
		input[type="number"]::-webkit-inner-spin-button {
			-webkit-appearance: none;
			margin: 0;
		}

        .form-container {
            border: 1px solid #DFE2E6;
            padding: 20px;
            display: flex;
            flex-direction: column;
            gap: 5px;
			border-radius: 4px;
        }

        h3 {
            margin-top: 30px;
        }

        input {
            padding: 10px;
        }

        #default input {
            margin-bottom: 10px;
        }

        .fa-trash-can:hover {
            cursor: pointer;
            color: #919191;
        }

        .fa-trash-can {
            margin-left: 8px;
            font-size: 23px
        }

        .form-object {
            width: 100%;
            display: flex;
            flex-direction: row;
            gap: 5px;
            align-items: center;
        }

        .form-box {
            display: flex;
            flex-direction: column;
            margin-bottom: 10px;
            width: 100%;
        }

		.plus-btn {
            padding: 8px;
            border: none;
            background-color: #64C2EB;
            border-radius: 4px;
			color: white;
		}

        .add-btn, .remove-btn {
            margin: 0 8px;
            font-size: 30px;
        }

		.add-btn {
            color: #6D90E0
		}

		.remove-btn {
			color: indianred;
		}

		.add-btn:hover, .remove-btn:hover {
			filter: brightness(80%);
            cursor: pointer;
        }

        .selected-product {
            height: 100px;
            border: 1px solid #DFE2E6;
            border-radius: 4px;
            margin-top: 20px;
            display: flex;
            flex-direction: row;
            overflow: auto;
			/*gap: 5px;*/
			/*padding: 5px;*/
        }

        .selected-product img {
            height: 100%;
            width: 93px;
            object-fit: cover;
            padding: 5px 0px 5px 5px;
            cursor: pointer;
        }

        .option-submit-btn {
            background-color: #6D90E0;
            padding: 10px 15px;
            border-radius: 4px;
            color: white;
        }

		.option-submit-btn:hover, .plus-btn:hover {
			filter: brightness(95%);
            cursor: pointer;
		}

        .stock-object {
			/*flex: 1;*/
			line-height: 30px;
			width: 150px;
        }

        .stock-input-container {
			margin-top: 20px;
			justify-content: space-between;
			align-items: center;
			text-align: center;
        }

        .stock-input {

        }

        #mainOptionNames {
			background-color: #f5f5f5;
			padding: 8px 0;
			border-radius: 4px;

        }

        #categoryConfirmBtn {
            background-color: #dedede;
            padding: 7px 12px;
            border-radius: 4px;
        }

		#categoryConfirmBtn:hover {
            cursor: pointer;
			background-color: #c5c5c5;
		}
	</style>

<body>
<div class="main-container">
	<div class="content shadow" style="width: 80%; padding-top: 50px; padding-bottom: 50px;">
		<div class="sub-menu">
			<div style="display: flex; flex-direction: row; gap: 5px" >
				<button type="button" class="btn btn-outline-secondary" style="width: 90px" onclick="location.href='#'">뒤로가기</button>
			</div>
		</div>

		<div class="content-container" style="flex: 1;">
			<%-- enctype="multipart/form-data" --%>
			<form method="post" class="main-content-card" enctype="multipart/form-data" action="${pageContext.request.contextPath}/seller/${mode}-product" id="form">
				<%-- 임시 데이터 --%>
				<input type="hidden" name="sellerId" value="${sellerId}"/>

				<div style="display: flex; flex-direction: row; gap: 10px; justify-content: space-between;">
					<div class="input-group">
						<div class="input-group-text" style="width: 85px;"><span style="margin: auto">상품명</span></div>
						<input class="form-control product-info" name="productName" id="productName" value="${mode.equals("post") ? "" : product.productName}">
						<button class="btn btn-outline-secondary" type="button" id="productNameCheckBtn">중복 검사</button>
					</div>
				</div>
				<input type="hidden" name="id" value="${mode.equals("post") ? "" : product.productId}">

<%--				<div style="display: flex; flex-direction: row; margin-top: 35px; gap: 10px; justify-content: space-between;">--%>
				<div class="flex-row" style="gap: 15px; align-items: center; justify-content: space-between; align-content: center; margin-top: 35px; ">
					<div style="display: grid; grid-template-columns: 1fr 0.7fr 0.7fr 0.7fr; gap: 10px;" id="subcategoriesContainer">
						<div class="input-group">
							<div class="input-group-text" style="width: 85px;"><span style="margin: auto">카테고리</span></div>
							<select class="form-select form-control product-info category-select" name="productCategoryId" id="category" onchange="fetchSubcategories(this.value, 1)">
								<option selected value="">카테고리 선택</option>
								<c:forEach items="${categories}" var="category">
									<option value="${category.productCategoryId}">
										${category.categoryName}
									</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div id="categoryConfirmBtn">확인</div>
				</div>

				<div style="display: flex; flex-direction: row; gap: 10px; justify-content: space-between; margin-top: 35px;">
					<div class="input-group">
						<div class="input-group-text" style="width: 85px;"><span style="margin: auto">할인율</span></div>
						<input type="number" class="form-control product-info" id="discountPercent" name="discountPercent" value="${mode == "post" ? "" : product.discountPercent}">
					</div>

					<div class="input-group">
						<div class="input-group-text" style="width: 85px;"><span style="margin: auto">배달비</span></div>
						<input type="number" class="form-control product-info" id="deliveryCost" name="deliveryCost" value="${mode == "post" ? "" : product.deliveryCost}">
					</div>
				</div>

<%--				<div class="input-group" style="flex: 1">--%>
<%--					<input type="file" class="form-control" aria-label="Upload" accept="image/jpeg,image/png,image/gif" name="picture" id="productImgInput">--%>
<%--				</div>--%>

				<div style="width: 100%; border-bottom: 1px solid #DFE2E6; margin-top: 35px;"></div>

				<div style="margin-top: 35px; font-weight: 700;">상품 이미지</div>
				<div class="input-group" style="flex: 1; margin-top: 10px;">
					<input type="file" class="form-control" id="productImgInput"
						   aria-label="Upload" accept="image/jpeg,image/png,image/gif,image/avif" name="productImg" multiple="multiple" >
				</div>

				<%-- 이미지 미리보기 --%>
				<div style="margin-top: 35px;">
					<div id="presentationPreviewImg" style="height: 210px; display: flex; flex-direction: row; border-radius: 4px">
						<img src="${pageContext.request.contextPath}/resources/picture/default.png"
							 style="height: 100%; width: 210px; object-fit: cover; border: 1px solid #DFE2E6; border-radius: 4px"
							 id="productImg">
					</div>

					<div class="selected-product" id="imgPool"></div>
				</div>

				<c:if test="${mode.equals('post')}">

					<div style="width: 100%; border-bottom: 1px solid #DFE2E6; margin-top: 35px;"></div>

					<div style="margin-top: 35px; font-weight: 700;">옵션 설정</div>
					<input type="hidden" name="mainOptionName" id="mainOptionName">
					<input type="hidden" name="subOptionName" id="subOptionName">

					<div class="form-container" style="margin-top: 15px;" >
							<div class="form-object option-container" style="flex-direction: column;">
								<div class="flex-col main-option" style="width: 100%; align-items: end">
									<div class="flex-row" style="width: 100%; align-items: center; margin-bottom: 15px;">
										<i class="bi bi-dash-square-fill remove-btn" onclick="deleteObject(this)"></i>
										<input style=" padding: 10px 10px; " class="form-control main-option-input" type="text" placeholder="상위 옵션명">
									</div>
									<div class="flex-col sub-option-container" style="width: 95%; text-align: right; justify-content: center">
										<div id="sub-option" style="flex-direction: row; align-items: center" class="form-box">
											<i class="bi bi-plus-square-fill add-btn" onclick="addSubOption(this)"></i>
											<input class="form-control" style="flex: 1; padding: 10px 10px" type="text" placeholder="하위 옵션명">
										</div>
									</div>
								</div>
							</div>
						<button type="button" id="addMainOption" class="plus-btn">옵션 추가</button>
					</div>
					<div style="margin-top: 10px; display: flex; flex-direction: row; justify-content: right">
						<div class="option-submit-btn" onclick="displayOptions();">등록 완료</div>
					</div>

					<div style="margin-top: 35px; font-weight: 700;">옵션별 재고 설정</div>
					<div class="stock-container">
						<div class="flex-row stock-input-container" id="mainOptionNames">
							<div class="flex-row"></div>
							<div class="flex-row" style="gap: 5px">
								<div class="stock-object" style="width: 120px;">가격</div>
								<div class="stock-object" style="width: 120px;">재고</div>
							</div>
						</div>

						<div class="flex-row stock-input-container">
							<%-- 옵션명 --%>
							<div class="flex-col" id="subOptionNameContainer" style="gap: 10px"></div>

							<%-- 재고 정보 --%>
							<div class="flex-col" id="subOptionInputContainer" style="gap: 10px"></div>
						</div>
					</div>
				</c:if>

				<div style="width: 100%; border-bottom: 1px solid #DFE2E6; margin-top: 35px;"></div>

				<label style="margin-top: 35px;">
					<div style="margin-top: 35px; font-weight: 700;">상품 상세 이미지 및 설명</div>
					<div class="input-group" style="flex: 1; margin-top: 10px;">
						<input type="file" class="form-control" id="contentImgInput"
							   aria-label="Upload" accept="image/jpeg,image/png,image/gif,image/avif" name="contentImg" multiple="multiple" >
					</div>

					<textarea class="form-control" style="margin-top: 5px;" name="content">${product.content}</textarea>
				</label>

				<div style="text-align: right; margin-top: 10px;">
					<button type="button" class="btn btn-success" style="width: 100px; margin-top: 20px" onclick="sendImageToServer()">${mode.equals('post') ? '등록 완료' : '수정 완료'}</button>
				</div>
			</form>
		</div>
	</div>
	<button onclick="sendImageToServer()">test</button>
</div>

<script>
    let nameCheckStatus = false

    function displayOptions() {
        let optionCombine = generateOptionCombine();
		let mainOptionList = optionCombine[0];
        let subOptionList = optionCombine[1];

        let combineList = combineSubOptions(subOptionList)

		displayCombine(mainOptionList, combineList);
    }

    function getValueMap() {
        let valueMap = []

        let children = $('#subOptionInputContainer').children();

        for (const x of children) {
			valueMap.push([$(x).find(':nth-child(1)').children().val(),$(x).find(':nth-child(2)').children().val()])
        }

        console.log(valueMap)
		sendStockMap(valueMap)

	}


    function sendStockMap (valueMap) {
        console.log(JSON.stringify(valueMap))

        $.ajax({
            url: "${pageContext.request.contextPath}/seller/get-map-test",
            type: 'POST',
            data: JSON.stringify(valueMap),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function(response) {
                // 요청이 성공적으로 처리될 때 실행되는 코드
            },
            error: function(xhr, status, error) {
                // 요청이 실패했을 때 실행되는 코드
            }
        });
    }


	// 옵션 경우의 수 생성
    function generateOptionCombine() {
        let options = [];
        let mainOptionContainer = $('.option-container').children();
		let subOptionListList = [];
        let mainOptionList = [];

        // 메인 옵션 리스트
        for (const x of mainOptionContainer) {
            let subOptionList = [];
            console.log($(x).children().first().find('input').val())

			mainOptionList.push($(x).children().first().find('input').val())

            let subOptionContainers = $(x).find('.sub-option-container').children()

            for (const subOption of subOptionContainers) {
				subOptionList.push($(subOption).find('input').val())
            }
            subOptionListList.push(subOptionList);
        }

        $('#mainOptionName').val(mainOptionList)
        $('#subOptionName').val(JSON.stringify(subOptionListList))

        console.log('subOptionListList to json' + JSON.stringify(subOptionListList))

		options.push(mainOptionList, subOptionListList)
		return options
    }


    function displayCombine(mainOptionList, combineList) {
        let stockContainer = $('.stock-container');
		let subOptionNameContainer = $('#subOptionNameContainer');
        let subOptionInputContainer = $('#subOptionInputContainer')
		let mainOptionNames = $('#mainOptionNames')

		mainOptionNames.children().remove();
        subOptionNameContainer.children().remove()
        subOptionInputContainer.children().remove()

        let generatedSubjectMenu = ''

        for (const x of mainOptionList) {
			generatedSubjectMenu += '<div class="stock-object">' + x + '</div>'
        }

        let mainOptionTag = generateMainOptionTag(generatedSubjectMenu);

		mainOptionNames.append(mainOptionTag)

        console.log('combineList = ' + combineList)

        for (const combine of combineList) {
            let subOptionNameTag = generateNameTag(combine);
            $(subOptionNameContainer).append(subOptionNameTag)

			$(subOptionInputContainer).append(
                `
					<div class="flex-row" style="gap: 5px">
						<div class="stock-input">
							<input type="text" name="stockPrice" style="width: 120px; height: 30px">
						</div>
						<div class="stock-input">
							<input type="text" name="stockQuantity" style="width: 120px; height: 30px">
						</div>
					</div>
                `
			)
        }
	}

    function generateMainOptionTag(generatedSubjectMenu) {
        return `
				<div class="flex-row">` +
					generatedSubjectMenu
					+
				`</div>
				<div class="flex-row" style="gap: 5px">
					<div class="stock-object" style="width: 120px;">가격</div>
					<div class="stock-object" style="width: 120px;">재고</div>
				</div>
			`;
    }

    function generateNameTag(combine) {
        let genName = ''

        for (const x of combine) {
            genName += '<div class="stock-object">' + x[0] + '</div>'
        }

        return `<div class="flex-row">` + genName + `</div>`;
    }

</script>

<script>
    let imgPool = document.getElementById('imgPool');
    let productImgInput = document.getElementById('productImgInput');
    let productImg = document.getElementById('presentationPreviewImg');

    // 이미지 미리보기
    productImgInput.addEventListener('change', function () {
        // $(imgPool).empty()

        for (const file of productImgInput.files) {
            const reader = new FileReader();
            reader.onload = ({ target }) => {
                // let img = document.createElement('img');
                // img.src = target.result;
                // img.className = 'preview-img'

				let imgTag = `
								<img src="` + target.result + `" onclick="clickImg(this)"/>
							`



                $(imgPool).append($(imgTag))
                // imgPool.appendChild(imgTag)
                // productImg.src = target.result;
            };

            reader.readAsDataURL(file);
        }
    });

    function clickImg(obj) {
        let currentImg = $(productImg).find('img')

        console.log($(currentImg).attr('id'))

		if ($(currentImg).attr('id') !== 'productImg') {
             $(imgPool).append(currentImg);
		}

        $(productImg).empty()
		$(productImg).append(obj)
    }

    // 이미지 전송 함수
    function sendImageToServer() {
        let productImgList = [];
        let presentImg = $(productImg).find('img');
        if (presentImg === null || presentImg === '' || typeof presentImg === 'undefined') {
            alert('대표 이미지를 설정해주세요.')
			return
		}

        productImgList.push(presentImg.src)

        let children = $(imgPool).children();
        for (const x of children) {
            productImgList.push(x.src)
        }

        let form = document.getElementById('form');


        productImgInput.files = productImgList

		form.submit();
		//
        // let formData = new FormData();
        // for (let i = 0; i < productImgList.length; i++) {
        //     formData.append('productImg', productImgList[i]);
        // }
		//
        // for (const file of productImgList) {
        //     const field = document.createElement('input');
        //     field.setAttribute('type', 'file');
        //     field.setAttribute('name', 'images');
        //     form.appendChild(field);
        //     formData.append('images', file);
        // }




        // FormData 객체 생성
        // const formData = new FormData();

        // 이미지 데이터를 FormData에 추가
        // formData.append('image', );

        // AJAX 요청을 통해 FormData를 서버로 전송

        // $.ajax({
        //     url: '서버 URL',
        //     method: 'POST',
        //     data: formData,
        //     processData: false,
        //     contentType: false,
        //     success: function (response) {
        //         // 성공적으로 이미지가 서버에 저장된 경우에 수행할 작업
        //         console.log('이미지가 성공적으로 서버에 저장되었습니다.');
        //     },
        //     error: function (xhr, status, error) {
        //         // 이미지 전송 중에 발생한 에러 처리
        //         console.log('이미지 전송 중에 에러가 발생했습니다.');
        //         console.log('에러 상태:', status);
        //         console.log('에러 내용:', error);
        //     }
        // });


    }



</script>

<script>

	// 서브 옵션 리스트를 받고 모든 경우의 수를 반환
    function combineSubOptions(subOptionIdListList) {
        let totalSize = 1;
        let subOptionCount = subOptionIdListList.length;

        // 각 하위 옵션 리스트의 길이를 저장할 배열
        let subOptionLengths = [];

        for (let i = 0; i < subOptionCount; i++) {
            let subOptionList = subOptionIdListList[i];
            totalSize *= subOptionList.length;
            subOptionLengths.push(subOptionList.length);
        }

        let resultList = [];

        for (let i = 0; i < totalSize; i++) {
            let result = [];
            let temp = i;

            for (let j = 0; j < subOptionCount; j++) {
                let subOptionList = subOptionIdListList[j];
                let index = temp % subOptionLengths[j];
                result.push([subOptionList[index], index]);
                temp = Math.floor(temp / subOptionLengths[j]);
            }

            resultList.push(result);
        }

        // 결과 리스트를 왼쪽에서부터 오름차순으로 정렬
        resultList.sort((a, b) => {
            for (let i = 0; i < subOptionCount; i++) {
                if (a[i][1] !== b[i][1]) {
                    return a[i][1] - b[i][1];
                }
            }
            return 0;
        });

        return resultList;
    }
</script>


<script>
    let addMainOptionBtn = document.getElementById('addMainOption');

    addMainOptionBtn.addEventListener('click', function () {
        let tag =
            `
				<div class="flex-col main-option" style="width: 100%; align-items: end">
					<div class="flex-row" style="width: 100%; align-items: center; margin-bottom: 15px;">
						<i class="bi bi-dash-square-fill remove-btn" onclick="deleteObject(this)"></i>
						<input style=" padding: 10px 10px; " class="form-control" type="text" placeholder="상위 옵션명">
					</div>
					<div class="flex-col sub-option-container" style="width: 95%; text-align: right; justify-content: center">
						<div id="sub-option" style="flex-direction: row; align-items: center" class="form-box">
							<i class="bi bi-plus-square-fill add-btn" onclick="addSubOption(this)"></i>
							<input class="form-control" style="flex: 1; padding: 10px 10px" type="text" placeholder="하위 옵션명">
						</div>
					</div>
				</div>
			`

        addMainOption(tag, $('.option-container'))
    });


	function addSubOption(obj) {
        let tag =
            `
				<div id="sub-option" style="flex-direction: row; align-items: center" class="form-box">
					<i class="bi bi-dash-square-fill remove-btn" onclick="deleteSubObject(this)"></i>
					<input class="form-control" style="flex: 1; padding: 10px 10px" type="text" placeholder="하위 옵션명">
				</div>
			`

        addBtn(tag, $(obj).parent().parent())
    }

    function addBtn(tag, obj) {
        obj.append(tag)
    }

    function addMainOption(tag, obj) {
        if (obj.children().length === 2) {
            alert("상위 옵션은 두개 까지만 등록 가능합니다.")
            return
        }

        addBtn(tag, obj);
	}

    // 메인 옵션 삭제
    function deleteObject(obj) {
		if (!confirm('해당 옵션을 삭제합니다.')) {
            return
		}
        let cnt = $('.main-option').length

        if (cnt === 1) {
            alert('옵션은 한개 이상 존재해야 합니다.')
			return;
        }

        $(obj).parent().parent().remove()
    }

	// 서브옵션 삭제
    function deleteSubObject(obj) {

        if (!confirm('해당 옵션을 삭제합니다.')) {
            return
        }
        console.log('삭제')

        $(obj).parent().remove()
    }

    let nameCheckBtn = $('#productNameCheckBtn');

    // 상품 이름 중복 체크
    nameCheckBtn.click(function () {
        let productNameInput = $('#productName')
        let productName = $(productNameInput).val()

        if (nameCheckStatus === true) {
            productNameInput.attr('readOnly', false);
            productNameInput.css('background-color', 'white')

            nameCheckBtn.text('중복 검사')
            nameCheckStatus = false

            alert('변경 할 상품명을 입력하고 다시 중복확인을 해주세요.')
			return;
		}

        // 상품명이 빈 문자열일때 리턴
        if (productName.trim() === '') {
            alert('상품명을 입력해 주세요.')
            productName.focus()
            return
        }

        $.ajax({
            url: "${pageContext.request.contextPath}/product/validation-product-name",
            type: 'POST',
            data: "productName=" + productName,
            dataType: 'json',
            success: function(response) {
                let state = response.result;
                if (state === true) {
                    alert('이미 존재하는 상품명입니다.')
                } else {
                    productNameInput.attr('readOnly', true);
                    productNameInput.css('background-color', '#F8F9FA')

					nameCheckBtn.text('이름 변경')

                    nameCheckStatus = true
                    alert('사용 가능한 상품명입니다.')
                }
            },
            error: function(xhr, status, error) {
                // 요청이 실패했을 때 실행되는 코드
                alert('이미 존재하는 상품명입니다.')
            }
        });
    });

</script>

<script>
    // 카테고리 선택 스크립트

    let wholeCategories = ${jsonCategories};
    let currentCategories = ${jsonCategories};
	let selectedCategoriesList = []
	let isFirst = true;

    function fetchSubcategories(parentCategoryId, level) {
        let container = document.getElementById("subcategoriesContainer");

        if (parentCategoryId !== "") {
            console.log('current = ' + selectedCategoriesList[level-2])
            console.log('a' + level)

                if (Number(level) === 1) {
                    currentCategories = wholeCategories;
                } else {
                    currentCategories = selectedCategoriesList[level - 2];
                }

            let find = $(container).find('select:gt(' + (level-1) + ')');
            $(find).remove()
			selectedCategoriesList.splice(level)

            console.log('selectedCategoryList = ' + selectedCategoriesList)
            console.log('길이 = ' + selectedCategoriesList.length)

            let select = document.createElement("select");
            select.className = "form-select form-control product-info category-select";
            select.name = level;
            select.onchange = function () {
                fetchSubcategories(this.value, level+1);
            };

            console.log(parentCategoryId)

            let defaultOption = document.createElement("option");
            defaultOption.value = "";
            defaultOption.text = "카테고리 선택";
            select.appendChild(defaultOption);

            let categories = findSubcategories(currentCategories, parentCategoryId);

            if (categories === null || typeof categories === 'undefined') {
                return
            }

            if (categories.length === 0) {
                return;
            }

            let levelName = level + 1

            // if (a !== null) {
            //     $(a).remove()
            // }

            currentCategories = categories;
            selectedCategoriesList.push(categories)
            // parentCategoryId = currentCategories.productCategoryId

            for (let i = 0; i < categories.length; i++) {
                let category = categories[i];

                let option = document.createElement("option");
                option.value = category.productCategoryId;
                option.text = category.categoryName;
                select.appendChild(option);
            }

            container.appendChild(select);


            // let find = $(elements).find('select:gt(' + level-2 + ')');
            // console.log('find = ' + $(container).find('div:gt(' + 0 + ')'))



            // $(elements).find('div:gt(' + level-1 + ')').remove();
            // console.log('level = ' + level-2)
        }
    }

    function findSubcategories(currentCategories, parentCategoryId) {

        console.log(currentCategories)

        let subcategories = [];

        subcategories = currentCategories.find(function (item) {
            return parseInt(item.productCategoryId) === parseInt(parentCategoryId);
        })

        if (typeof subcategories !== 'undefined') {
            return subcategories.subCategoryList;
        } else {
            return null;
        }
    }

    $('#categoryConfirmBtn').click(function () {
        let categoryList = $('.category-select');
        let len = categoryList.length;
        let finalValue = $(categoryList[len-1]).val();

		if (finalValue === null || finalValue === '') {
            alert('옵션을 모두 선택해주세요.')
		} else {
            alert('옵션이 모두 선택되었습니다.')
		}
    });
</script>
</body>
</html>

