<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>category edit</title>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<style>
        .add-btn, .remove-btn, .edit-btn{
            /*font-size: 18px;*/
        }

        .add-btn {
            color: #6D90E0
        }

        .remove-btn {
            color: indianred;
        }

        .add-btn:hover, .remove-btn:hover, .edit-btn:hover{
            filter: brightness(80%);
            cursor: pointer;
        }

		.category {
			/*border: 1px solid black;*/
			padding: 8px;
		}
	</style>
</head>
<body style="padding: 30px; text-align: center">
	<h3 style="margin-top: 40px;">카테고리 수정</h3>
	<div style="width: 500px; margin: 50px auto; padding: 30px; border-radius: 5px" class="shadow">

		<div id="selectContainer">
			<div class="flex-row category" style="gap: 10px">
				<div>카테고리 목록</div>
				<i class="bi bi-plus-square-fill add-btn" onclick="addCategory(this, 'add')"></i>
				<input type="hidden" value="">
			</div>

			<c:forEach items="${allCategories}" var="category">
				<div class="flex-row category" style="gap: 10px; align-content: center; align-items: center">
					<c:forEach begin="1" step="1" end="${category.categoryLevel}">
					  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach>

					<c:if test="${category.categoryLevel == 1}">
						<i class="bi bi-circle-fill" style="font-size: 8px; color: #676767"></i>
					</c:if>
					<c:if test="${category.categoryLevel != 1}">
						<i class="bi bi-caret-right-fill" style="color: #676767"></i>
					</c:if>
					<div class="category-name">${category.categoryName}</div>
					<i class="bi bi-plus-square-fill add-btn" onclick="addCategory(this, 'add')"></i>
					<i class="bi bi-dash-square-fill remove-btn" onclick="addCategory(this, 'delete')"></i>
					<i class="bi bi-pencil-square edit-btn" onclick="addCategory(this, 'edit')"></i>
					<input type="hidden" class="product-category-id" value="${category.productCategoryId}"/>
					<input type="hidden" class="category-level" value="${category.categoryLevel}"/>
				</div>
			</c:forEach>

		</div>
	</div>

<!-- Modal -->
<div class="modal fade" id="categoryInputModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modalLabel">카테고리 추가</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body flex-col" style="">
				<div style="margin-bottom: 15px;">상위 카테고리 : <span id="parentCategoryName"></span></div>
				<input class="form-control" type="text" id="categoryName" placeholder="카테고리 이름">
				<input type="hidden" id="parentCategoryId">
				<input type="hidden" id="type">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
				<button type="button" class="btn btn-primary" onclick="addCategoryAjax()">확인</button>
			</div>
		</div>
	</div>
</div>

<script>
    function addCategory(obj, type) {
        let selectedValue = $(obj).parent().find('.product-category-id').val();
        let categoryLevel = $(obj).parent().find('.category-level').val();
        let selectedName = $(obj).parent().find('.category-name').text();


        console.log(selectedValue)

        if (selectedValue === '' || selectedValue === null || typeof selectedValue === 'undefined') {
            selectedValue = null
			selectedName = '최상위 카테고리'
		} else {
            if (categoryLevel >= 4 && type === 'add') {
                alert('하위 카테고리의 깊이는 4 이하만 가능합니다.')
				return
			}
		}

        $('#parentCategoryName').text(selectedName)
        $('#parentCategoryId').val(selectedValue)
		$('#type').val(type)

		// 삭제라면 모달창 생략
		if (type === 'delete') {
            if (confirm('하위카테고리가 있거나 이 카테고리에 등록된 상품이 있다면 삭제할 수 없습니다.\n삭제를 진행하시겠습니까?')) {
                addCategoryAjax()
			}
            return;
		} else if (type === 'edit') {
            $('#modalLabel').text('카테고리 수정')
		}

        // alert(selectedValue + " " + selectedName)

		let inputModal = $('#categoryInputModal');

        let modal = new bootstrap.Modal(inputModal);
        modal.toggle()
    }

    function addCategoryAjax() {

        let categoryName = $('#categoryName').val();
        let parentCategoryId = $('#parentCategoryId').val();
        let type = $('#type').val();

        let query = 'categoryName=' + categoryName + '&parentCategoryId=' + parentCategoryId

		if (type === 'add') {
            if (parentCategoryId === null || parentCategoryId === '' || typeof parentCategoryId === 'undefined') {
                query = 'categoryName=' + categoryName
            }
		}

		$.ajax({
			url: "${pageContext.request.contextPath}/category/" + type,
			type: 'POST',
			data: query,
			dataType: 'text',
			success: function(response) {
				if (response === 'true') {
					alert('요청이 완료되었습니다.')
                    location.reload();
				} else {
					alert('요청이 실패하였습니다.')
				}

			},
			error: function(xhr, status, error) {
                alert('요청이 실패하였습니다.')
			}
		});

    }

</script>
</body>
</html>
