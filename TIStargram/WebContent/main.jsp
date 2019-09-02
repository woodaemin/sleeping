<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="post.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/top.jsp" />
<script>
	
	$(function() {
		//ie6 이하의 버전일 경우 실행불가
		var msie6 = $.browser == 'msie' && $.browser.version < 7;

		if (!msie6) {
			var top = $('#comment').position().top
					- (parseFloat($('#comment').css('margin-top').replace(
							/auto/, 0))) + 80;

			$(window).scroll(function(event) {
				// what the y position of the scroll is
				var y = $(this).scrollTop();
				console.log("top : " + top);
				// whether that's below the form
				if (y >= top) {
					// if so, ad the fixed class
					$('#comment').addClass('fixed');
				} else {
					// otherwise remove it
					$('#comment').removeClass('fixed');
				}
			});
		}

		$('.targetImg').click(function() {
			var idx = $(this).attr("id");
			$.ajax({

			    url: "show.do?idx="+idx,

			    type: "get",

			    dataType: "html",

			    //data: {"idx":idx}, post방식

			    success: function(result){
			    	$('#postModal').html(result)
			    },

			    error: function (error){   
			    	alert(error)
			    }

			  });			
			$('#postModal').modal('show');
		})
		//스크롤이 맨 밑일 때
		$(window).scroll(function() {
					if ($(window).scrollTop() + $(window).height() == $(document).height()) {
						$('#comments>ul').append('<li><h1>하!</h1></li>');
					}
				});
		$('#createPost').click(function(){
			$.ajax({

			    url: "createPost.do",

			    type: "get",

			    dataType: "html",

			    //data: {"idx":idx}, post방식

			    success: function(result){
			    	$('#postModal').html(result)
			    },

			    error: function (error){   
			    	alert(error)
			    }

			  });			
			$('#postModal').modal('show');
		})
	})
</script>
<div class="container" style="padding-top: 60px;">
	<div id="comment-wrapper">
		<div id="comments">
			<ul>
			<!-- 글이 있는지 없는지 확인 -->
			<c:if test="${List.size() > 0 }">
				<!-- 표시할 글 반복문 시작 -->
				<c:forEach var="i" begin="0" end="${List.size()-1 }" step="1">
					<li>
						<div class="comment targetImg" id="${i }" style="width: 500px">
							<table class="table">
								<tr>
									<td><a href="#">${List[i].writer_id }</a></td>
								</tr>
								<tr>
									<td style="width: 300px; height: 200px; overflow: hidden">
										<%-- <img src="/${List[i].pictures }" --%>
										<img src="${pageContext.request.contextPath }/PostImage/${List[i].pictures}"
										style="width: auto; height: auto; margin-left: 30px;">
									</td>
								</tr>
								<tr>
									<td>${List[i].text_contents }</td>
								</tr>
								<tr>
									<td>버튼 1234</td>
								</tr>
								<tr>
									<td>댓글</td>
								</tr>
							</table>
						</div>
					</li>
				</c:forEach>
				<!-- 끝 -->
				</c:if>
			</ul>
		</div>

		<!--고정영역-->
		<div id="commentWrapper" class="hidden-sm section">
			<div id="comment">
				<form>
					<p class="formrow">
						<label for="yourname">${loginUser.userid }</label>
					</p>
					<p class="formrow">
						<label for="yoururl">${loginUser.name }</label>
					</p>
					<p class="formrow">
						<textarea rows="10" cols="35" name="body"></textarea>
					</p>
					<p>
						<a type="button" id="createPost">글쓰기</a>
					</p>
				</form>
			</div>
		</div>
		<!--고정영역--> 
	</div>
</div>


<!-- JSP로 빼고 AJAX 사용 필요 -->
<div class='modal' aria-hidden="true" id='postModal'>

</div>
</body>
</html>