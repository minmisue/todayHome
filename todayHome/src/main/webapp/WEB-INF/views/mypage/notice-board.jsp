<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
	
.css-1garijz {
    max-width: 850px;
    margin: 0px auto;
}

.css-1r412mj {
    font-size: 16px;
    line-height: 28px;
    list-style: none;
    color: rgb(47, 52, 56);
    margin: 0;
}

.css-axiq8h {
    color: rgb(47, 52, 56);
    border-bottom: 1px solid rgb(234, 237, 239);
    padding: 8px 0px;
    font-size: 16px;
    line-height: 28px;
    font-weight: inherit;
}

.css-gtmo6i {
    display: inline-block;
    margin: 0px;
    border: none;
    background: none;
    font: inherit;
    color: rgb(47, 52, 56);
    width: 100%;
    position: relative;
    text-align: left;
    padding: 10px 40px 10px 36px;
}

.css-axiq8h .faq-mark {
    position: absolute;
    left: 0px;
    top: 8px;
}

.css-q6kosl {
    width: 28px;
    height: 28px;
    display: inline-flex;
    -webkit-box-align: center;
    align-items: center;
    -webkit-box-pack: center;
    justify-content: center;
    border-radius: 50%;
    font-size: 16px;
    line-height: 20px;
    color: rgb(53, 197, 240);
    border: 1px solid rgb(234, 237, 239);
    box-shadow: rgba(63, 71, 77, 0.05) 0px 2px 6px;
}

.css-axiq8h .chevron {
    position: absolute;
    right: 10px;
    top: 10px;
    transition: all 0.2s ease 0s;
}

.css-cwcsvq {
    display: inline-block;
    font-size: 24px;
    line-height: 1;
}

.css-cwcsvq::before {
    font-family: OhouseIcon;
    vertical-align: top;
}

.css-1nxzveq.open {
    opacity: 1;
    padding: 16px;
    display: block;
    height: auto;
}

.css-1nxzveq {
    background-color: #F7F9FA;
    border-radius: 4px;
    -webkit-transition: all 0.2s ease;
    transition: all 0.2s ease;
    box-sizing: border-box;
    padding: 0 16px;
    opacity: 0;
    height: 0;
}

.css-axiq8h.open .question-text {
    font-weight: 700;
}

.accordion-button:not(.collapsed) {
	background-color : white;
	border-color: white;
}

.accordion-button:focus {
    border-color: white;
}

.css-yxjd3y {
    font-size: 20px;
    line-height: 28px;
    font-weight: 700;
    margin-top: 44px;
    margin-bottom: 20px;
}
	</style>
	
<script type="text/javascript">
$(".css-gtmo6i").on("click",function () {
	alert("테스트");
});

</script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content">
			<section class="css-1garijz">
			<h5 class="css-yxjd3y">무엇을 도와드릴까요 ? </h5>
			<div class="accordion" id="accordionExample">
			<c:forEach var="notice" items="${noticelist}" varStatus="status">
			  <div class="accordion-item">
			    <h2 class="accordion-header">
			      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#notice${notice.noticeBoardId}" aria-expanded="false" aria-controls="notice${notice.noticeBoardId}">
					<span class="css-axiq8h css-q6kosl">Q</span>&nbsp;
					<span class="question-textquestion-text">${notice.subject }</span>
			      </button>
			    </h2>
			    <div id="notice${notice.noticeBoardId}" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
			      <div class="accordion-body">
			      ${notice.content }
			      </div>
			    </div>
			  </div>
			 </c:forEach>
			</div>
			</section>
		</div>
	</div>
	
	

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
