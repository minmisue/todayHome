<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
	.state-titleopen{
		font-weight: 700;
		font-size: 15px;
		color: #35c5f0;
	}
	.state-titleclose{
		font-weight: 700;
		font-size: 15px;
		color: #bdbdbd;
	}
	
	.state-date{
		font-size: 13px;
		color: #bdbdbd;
		text-align: right;
		margin-left: auto
	}
    .item-img:hover {
        cursor: pointer;
        transform: scale(1.05);
        transition: transform .2s;
     }	

</style>

<div class="body-container">
    <div class="body-title">
		<h2><i class="fa-brands fa-perbyte"></i> 이벤트 </h2>
    </div>
    
    <div class="body-main">
    	<div style="display: grid;grid-template-columns: repeat(2, 1fr);gap:10px; width:100%">
			<c:forEach var="eventlist" items="${eventlist}" varStatus="status">
				<div style="height: 230px;display: flex;flex-direction: column;" onclick="location.href='${pageContext.request.contextPath}/event/detail?eventBoardId=${eventlist.eventBoardId }'">
					<div style="width: 100%;height: 160px;overflow: hidden;border-radius: 10px"><img style="width: 100%; height: 100%; border-radius: 10px" class="item-img" src="${pageContext.request.contextPath}/uploads/event/${eventlist.eventImg}"> </div>
					<div style="padding: 20px 15px; display: flex;flex-direction: row;">
						<div class="state-title${sysdate < eventlist.endDate ? 'open' : 'close'}">${sysdate < eventlist.endDate ? "진행중" : "종료"}</div>
						<div class="state-date">${eventlist.startDate}~${eventlist.endDate}</div>
					</div>
				</div>
			</c:forEach>
			</div>
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/event/write'">등록하기</button>
	</div>
</div>
