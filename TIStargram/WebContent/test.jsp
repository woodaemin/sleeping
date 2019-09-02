<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${vo != null }">
<script>
	$(function(){
		$("#bt1").click(function(){
			
		})
			
	})
</script>
	<div class='modal-dialog modal-dialog-centered modal-xl'>
		<div class='modal-body'>
			<table class='table' style='background-color: white; height: 600px'>
				<tr>
					<td rowspan='4' style='width: 70%'><img
						src='${pageContext.request.contextPath }/Images/iphone.png'> <!--사진위치--></td>
					<td style='height: 10%' id="Ptop"> ${vo.getWriter_id() }, 팔로우상태, 설정</td>
				</tr>
				<tr>
					<td style='height: 60%' id="Pmsg">${vo.getText_contents()}</td>
				</tr>
				<tr>
					<td style='height: 20%' id="Pdata">포스팅 정보(좋아요 버튼, 좋아요 수, 업로드 후 경과된 시간)</td>
				</tr>
				<tr>
					<td style='height: 10%' id="Preply"><input type='text' id = "PreplyeCreate"><button class="button" id="bt1">텍스트 입력</button></td>
				</tr>
			</table>
		</div>
	</div>
</c:if>