<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sp.app.domain.product.ProductCategory" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Category List</title>
	<script>
        function toggleSubcategories(parentCategoryId) {
            var subcategories = document.getElementsByClassName('subcategory-' + parentCategoryId);
            for (var i = 0; i < subcategories.length; i++) {
                if (subcategories[i].style.display === 'none') {
                    subcategories[i].style.display = 'block';
                } else {
                    subcategories[i].style.display = 'none';
                }
            }
        }
	</script>
</head>
<body>

<form>
	<select class="category-select" name="categoryLevel1" onchange="fetchSubcategories(this.value, 1)">
		<option value="">전체</option>
		<c:forEach items="${categories}" var="category">
			<option value="${category.productCategoryId}">
					${category.categoryName}
			</option>
		</c:forEach>
	</select>

	<div id="subcategoriesContainer"></div>
</form>

<button onclick="findSubcategories(1)">hello</button>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    let categories = ${jsonCategories};
    let currentCategories = ${jsonCategories};


    function fetchSubcategories(parentCategoryId, level) {
        let container = document.getElementById("subcategoriesContainer");

        if (parentCategoryId !== "") {

            let select = document.createElement("select");
            select.className = "category-select";
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


            let elements = $(container).children()
            let find = $(container).find('select:gt(' + (level-2) + ')');

            console.log('level = ' + level)
            for (const x of find) {
                console.log('value = ' + $(x).html())
            }

            $(find).remove()

            if (categories === null) {
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
</script>


</body>
</html>