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
	</style>

<body>
<div class="main-container">
	<div class="content shadow" style="width: 80%; padding-top: 50px; padding-bottom: 50px;">

<%--		<div class="input-object">카테고리</div>--%>
<%--		<div class="input-object">상품 이름</div>--%>
<%--		<div class="input-object">상품 설명</div>--%>
<%--		<div class="input-object">기본 가격</div>--%>
<%--		<div class="input-object">할인율</div>--%>
<%--		<div class="input-object">배달비</div>--%>

<%--		<div>옵션 설정</div>--%>
<%--		<div>옵션 이름</div>--%>

		<div class="sub-menu">
			<div style="display: flex; flex-direction: row; gap: 5px" >
				<button type="button" class="btn btn-outline-secondary" style="width: 90px" onclick="location.href='#'">뒤로가기</button>
			</div>
		</div>

		<div class="content-container" style="flex: 1;">
			<%-- enctype="multipart/form-data" --%>
			<form method="post" class="main-content-card" enctype="multipart/form-data" action="${pageContext.request.contextPath}/seller/${mode}-product" id="form">
				<%-- 임시 데이터 --%>
				<input type="hidden" name="sellerId" value="1"/>

				<div style="display: flex; flex-direction: row; gap: 10px; justify-content: space-between;">
					<div class="input-group">
						<div class="input-group-text" style="width: 85px;"><span style="margin: auto">상품명</span></div>
						<input class="form-control product-info" name="productName" id="productName" value="${mode == "post" ? "" : product.name}">
						<button class="btn btn-outline-secondary" type="button" id="productNameCheckBtn">중복 검사</button>
					</div>
				</div>
				<input type="hidden" name="id" value="${mode.equals("post") ? "" : product.productId}">

				<div style="display: flex; flex-direction: row; margin-top: 35px; gap: 10px; justify-content: space-between;">
					<div class="input-group">
						<div class="input-group-text" style="width: 85px;"><span style="margin: auto">카테고리</span></div>
						<select class="form-select form-control product-info" name="productCategoryId" id="category">
							<option selected value="0">카테고리 선택</option>
							<option value="1">가구</option>
							<option value="2">디지털</option>
							<option value="3">잡화</option>
						</select>
					</div>

					<div class="input-group">
						<div class="input-group-text" style="width: 85px;"><span style="margin: auto">상세</span></div>
						<select class="form-select form-control product-info" disabled>
							<option selected value="0">카테고리 선택</option>
							<option value="1">가구</option>
							<option value="2">디지털</option>
							<option value="3">잡화</option>
						</select>
					</div>

					<div class="input-group">
						<div class="input-group-text" style="width: 85px;"><span style="margin: auto">상세 2</span></div>
						<select class="form-select form-control product-info" disabled>
							<option selected value="0">카테고리 선택</option>
							<option value="1">가구</option>
							<option value="2">디지털</option>
							<option value="3">잡화</option>
						</select>
					</div>

					<div class="input-group">
						<div class="input-group-text" style="width: 85px;"><span style="margin: auto">상세 3</span></div>
						<select class="form-select form-control product-info" disabled>
							<option selected value="0">카테고리 선택</option>
							<option value="1">가구</option>
							<option value="2">디지털</option>
							<option value="3">잡화</option>
						</select>
					</div>
				</div>


				<div style="display: flex; flex-direction: row; gap: 10px; justify-content: space-between; margin-top: 35px;">
					<div class="input-group">
						<div class="input-group-text" style="width: 85px;"><span style="margin: auto">기본 가격</span></div>
						<input type="number" class="form-control product-info" id="defaultPrice" name="price" value="${mode == "post" ? "" : product.remainQuantity}">
					</div>

					<div class="input-group">
						<div class="input-group-text" style="width: 85px;"><span style="margin: auto">할인율</span></div>
						<input type="number" class="form-control product-info" id="discountPercent" name="discountPercent" value="${mode == "post" ? "" : product.remainQuantity}">
					</div>

					<div class="input-group">
						<div class="input-group-text" style="width: 85px;"><span style="margin: auto">배달비</span></div>
						<input type="number" class="form-control product-info" id="deliveryCost" name="deliveryCost" value="${mode == "post" ? "" : product.remainQuantity}">
					</div>
				</div>

<%--				<div class="input-group" style="flex: 1">--%>
<%--					<input type="file" class="form-control" aria-label="Upload" accept="image/jpeg,image/png,image/gif" name="picture" id="productImgInput">--%>
<%--				</div>--%>

				<div class="input-group" style="flex: 1; margin-top: 35px;">
					<input type="file" class="form-control" id="imgInput"
						   aria-label="Upload" accept="image/jpeg,image/png,image/gif" name="picture" multiple="multiple" >
				</div>

				<div style="width: 100%; border-bottom: 1px solid #DFE2E6; margin-top: 35px;"></div>

				<%-- 이미지 미리보기 --%>
				<div style="margin-top: 35px;">
					<div style="height: 210px; display: flex; flex-direction: row; border-radius: 4px">
						<img src="${pageContext.request.contextPath}/resources/picture/default.png"
							 style="height: 100%; width: 210px; object-fit: cover; border: 1px solid #DFE2E6; border-radius: 4px"
							 id="productImg">
					</div>

					<div class="selected-product" id="imgPool"></div>
				</div>

				<div style="width: 100%; border-bottom: 1px solid #DFE2E6; margin-top: 35px;"></div>

				<div style="margin-top: 35px;">옵션 설정</div>
				<input type="hidden" name="mainOptionName" id="mainOptionName">
				<input type="hidden" name="subOptionName" id="subOptionName">

				<div class="form-container" style="margin-top: 35px;" >
<%--					<div id="formContainer" class="form-box">--%>
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
<%--					</div>--%>
<%--					<i class="bi bi-plus-square-fill" id="addSchoolName"></i>--%>
					<button type="button" id="addSchoolName" class="plus-btn">옵션 추가</button>
				</div>
				<div style="margin-top: 10px; display: flex; flex-direction: row; justify-content: right">
					<div class="option-submit-btn" onclick="displayOptions();">등록 완료</div>
				</div>
				<div style="margin-top: 35px;">옵션별 재고 설정</div>

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

				<div style="width: 100%; border-bottom: 1px solid #DFE2E6; margin-top: 35px;"></div>

				<label style="margin-top: 35px;">
					상품 설명
					<textarea class="form-control" style="margin-top: 5px;" name="content"></textarea>
				</label>

				<div style="text-align: right; margin-top: 10px;">
					<button type="submit" class="btn btn-success" style="width: 100px; margin-top: 20px">${mode.equals('post') ? '등록 완료' : '수정 완료'}</button>
				</div>
			</form>
			<button onclick="getValueMap()">test</button>
		</div>
	</div>
</div>

<script>
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
    let productImgInput = document.getElementById('imgInput');

    // 이미지 미리보기
    productImgInput.addEventListener('change', function () {
        $(imgPool).empty()

        for (const file of productImgInput.files) {
            const reader = new FileReader();
            reader.onload = ({ target }) => {
                let img = document.createElement('img');
                img.src = target.result;
                imgPool.appendChild(img)
                // productImg.src = target.result;
            };

            reader.readAsDataURL(file);
        }
    });
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
    let addMainOptionBtn = document.getElementById('addSchoolName');

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

    // addQualificationBtn.addEventListener('click', function () {
	function addSubOption(obj) {
        // let tag = $('#qualificationsFormContainer').find(':first').clone()
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

    function deleteObject(obj) {
        console.log('삭제')
        // let formBox = $(obj).closest('.form-box')
        // let cnt = formBox.children().length

        $(obj).parent().parent().remove()

        // if (cnt === 2) {
        //     formBox.find(':first').children('i').remove()
        // }
    }

    function deleteSubObject(obj) {
        console.log('삭제')
        // let formBox = $(obj).closest('.form-box')
        // let cnt = formBox.children().length

        $(obj).parent().remove()

        // if (cnt === 2) {
        //     formBox.find(':first').children('i').remove()
        // }
    }
</script>
</body>
</html>

