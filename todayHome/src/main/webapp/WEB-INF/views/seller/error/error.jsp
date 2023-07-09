<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="body-container">
    <div class="body-main">
		<div class="info-continer">
			<div class="info-title">
				<h3>${title}</h3>
			</div>
			<div class="info-box">
				<div class="info-message">
					판매자 상태를 확인해주세요.
				</div>
				<div class="info-footer">
					<button type="button" class="btnConfirm" onclick="javascript:history.back();">이전화면으로 이동</button>
				</div>
			</div>
		</div>
    </div>
</div>
