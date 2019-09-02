<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/top.jsp"/>
<style type="text/css">
body {
	background: #fff;
	font-family: verdana;
	padding-top: 50px;
}

#vtab {
	margin: auto;
	width: 800px;
	height: 100%;
}

#vtab>ul>li {
	width: 110px;
	height: 76px;
	/*  background-color: #fff !important; */
	list-style-type: none;
	display: block; 
	text-decoration: none;
	margin: auto;
	padding-bottom: 10px;
	border: 1px solid #fff;
	position: relative;
	border-right: none;
	opacity: 1;
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=30)";
	filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=30);
}

#vtab>ul>li>a {
	text-decoration: none;
	color: black;
}

#vtab>ul>li.home {
	background: url('') no-repeat center center;
}

#vtab>ul>li.selected {
	opacity: 1;
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=100)";
	filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=100);
	border: 1px solid #ddd;
	border-right: none;
	z-index: 10;
	background-color: #fafafa !important;
	position: relative;
}

#vtab>ul {
	float: left;
	width: 110px;
	text-align: center;
	display: block;
	margin: auto 0;
	padding: 0;
	position: relative;
	top: auto;
}

#vtab>div {
	/*  background-color: #fafafa; */
	margin-left: 110px;
	border: 1px solid #ddd;
	min-height: 502px;
	padding: 12px;
	position: relative;
	z-index: 9;
}

#vtab>div>h3 {
	color: #800;
	font-size: 1.2em;
	border-bottom: 1px dotted #800;
	padding-top: 5px;
	margin-top: 0;
}

#tabProfile label {
	width: 100px;
	text-align: left;
	clear: left;
	margin-right: 15px;
}

#tabProfile fieldset {
	border: none;
}

#tabProfile fieldset>div {
	padding-top: 3px;
	padding-bottom: 3px;
}

#tabProfile #change {
	margin-left: 115px;
}
</style>
<script type="text/javascript">
        $(function() {
            var $items = $('#vtab>ul>li');
            $items.click(function() {
                
                $items.removeClass('selected');
                $(this).addClass('selected');

                var index = $items.index($(this));
                $('#vtab>div').hide().eq(index).show();
            }).eq(0).click(); 
         
            $('#emailCheckbutton').click(function(){
            	var email = $("#email").attr("id");
            	$.ajax({
            		url:"email.do",
            		type:"post",
            		data:{"email":$('#email').val()},
            		datatype:"html",
            		success:function(res){
        				$("#emailcheck").append(res)
        			},
        			error:function(err){
        				alert('error: '+err.status)
        			}
            	})//ajax
            })//$email
           $('#confirmpassword').blur(function(){
            if($('#newpassword').val() != $('#confirmpassword').val()){
            	alert("새로운 비밀번호가 일치하지 않습니다.")
            	$('#newpassword').select()
            }
            })//$confim 
          });//$function
    </script>
<div class="section" style="padding-top: 60px;">
	<div id="vtab">
		<ul class="tab">
			<li>프로필 편집</li>
			<li>비밀번호 변경</li>
			<li>회원탈퇴</li>
			<li>공개범위 및 보안</li>
		</ul>

		<div id="tab1" name="tab1">		
			<form action="<%=request.getContextPath()%>/user/emailUpdate.do" method="POST">
			
			<table style="border: 1px solid red">
				<tr>
					<td rowspan="2"><a href="#"><img src="./Images/logo.png"></a></td>
					<td>mckgun1</td>
				</tr>
				<tr>
					<td><a href="#">프로필사진 바꾸기</a></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" class="form-control" id="name" name="name"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" class="form-control" id="email" name="email"></td><!--req.getparameter은 name값으로 받아온다  -->
				</tr>
				<tr>
					<td colspan="2" style="text-align: center" id="emailcheck">
						<button type="button" id="emailCheckbutton">이메일 확인</button>
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>모달에 라디오박스걸어서 셀렉티드 해야함</td>
				</tr>
				<tr>
					<td>비슷한 계정 추천</td>
					<td><input type="checkbox">팔로우할 만한 비슷한 계정을<br>추천할
						때 회원님의 계정을<br>포함합니다.</td>
				</tr>
				<tr>
					<td>
						<button type="submit">제출</button>
					</td>
					<td><a href="#" style="text-decoration: none">계정을 일시적으로
							비활성화</a></td>
				</tr>
			</table>			
			</form>
		</div>

		<div id="tab2" name="tab2">
			<form id="tabProfile" action="<%=request.getContextPath()%>/user/passwrodupdate.do" method="POST">
			<a href="#"><img src="./Images/logo.png"></a> mckgun1
				<div>
					<label for="password">old password</label> <input type="text"
						class="form-control" id="oldpassword" name="oldpassword">
				</div>
				<div>
					<label for="password">new password</label> <input type="text"
						class="form-control" id="newpassword" name="newpassword">
				</div>
				<div>
					<label for="password">confirm password</label> <input type="text"
						class="form-control" id="confirmpassword" name="confirmpassword">
				</div>
				<div>
					<!--  <input type=button value="비밀번호 변경" id="change" name="change"> -->
					<button type="submit" id="change" name="change">비밀번호 변경</button>
					
				</div>	
			</form>
		</div>
				<div id="tab3" name="tab3">
			<form id="tabProfile" action="<%=request.getContextPath()%>/user/userdelete.do" method="POST">
			<a href="#"><img src="./Images/logo.png"></a> mckgun1
				<div>
					<label for="password">old password</label> <input type="text"
						class="form-control" id="oldpassword" name="oldpassword">
				</div>
				<div>
					<button type="submit" id="delete" name="delete" >비밀번호 변경</button>
					
				</div>	
			</form>
			
		</div>
		
		<div id="tab4" name="tab4">
			<section class="aaa">
				<h2 class="aba">계정 공개 범위</h2>
				<div class="1">
					<div class="2">
						<div class="3">
							<label> <input type="checkbox">
								<div class=""></div> "비공계 계정"
							</label>
						</div>
					</div>
					<p>계정이 비공개 상태인 경우 회원님이 승인한 사람만 Instagram에서 회원님의 사진과 동영상을 볼수있습니다
						기존 팔로워는 영향을 받지 않습니다.</p>
				</div>
			</section>
			<section class="aaa">
				<h2 class="aba">활동상태</h2>
				<div class="1">
					<div class="2">
						<div class="3">
							<label> <input type="checkbox">
								<div class=""></div> "활동상태표시"
							</label>
						</div>
					</div>
					<p>Instagram 앱에서 최근 활동한 시간 정보가 회원님이 팔로우하는 계정및 메시지를 보낸 모든 사람에게
						표시됩니다. 이설정을 해제하면 다른계정의 활동 상태를 볼 수 없습니다.</p>
				</div>
			</section>
			<section class="aaa">
				<h2 class="aba">스토리 공유</h2>
				<div class="1">
					<div class="2">
						<div class="3">
							<label> <input type="checkbox">
								<div class></div> "공유허용"
							</label>
						</div>
					</div>
					<p>사람들이 회원님의 스토리를 메시지로 공유할 수있습니다.</p>
				</div>
			</section>
			<section class="aaa">
				<h2 class="aba">댓글</h2>
				<a href="#">댓글 설정 수정</a>
			</section>
			<section class="aaa">
				<h2 class="aba">내가 나온 사진</h2>
				<div class="1">
					<fildset>
						 <label> 
						 <input type="radio" value="automatic" checked> "자동으로 추가"
						 </label> 
						 <label> 
						 	<input type="radio" value="manual"> "수동으로	추가"
						 </label> 
					</fildset>
					<p>
						<span>회원님이 나온 사진을 프로필에 추가할 방법을 선택하세요</span>
					</p>
				</div>
			</section>
		</div>
	</div>

    </div>
   
</body>
</html>
