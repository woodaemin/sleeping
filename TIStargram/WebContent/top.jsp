<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.form.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
    rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath }/CSS/login.css" 
	rel="stylesheet" type="text/css">
	<style>
#cont {
	width: 900px;
	height: 900px;
	border: 1px solid blue;
}

     #textArea{
            resize: none;
            border: 1px solid red;
            margin:40px;
            width:100%;
            height:100;
            overflow:visible;
            text-overflow:ellipsis;
         
        }

.imgs_wrap {
	width: 600px;
	margin-top: 50px;
}

.imgs_wrap img {
	max-width: 350px;
}


</style>
  	<script type="text/javascript">
	
 	$(function(){
		$('#logout').click(function(){
			var logoutConfirm=confirm("로그아웃 하시겠습니까?")
			if(logoutConfirm){
				alert("로그아웃")
				$("#flogout").submit()
			}else{
				alert("로그아웃 취소")
			}
		})//--------
		$("#Property").click(function(){
			$("#fProperty").submit()
		
 		})
 	
 	})
	
	
	</script>
  <body>
    <div class="navbar navbar-default navbar-static-top navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><span>Brand</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active">
              <a href="#">Home</a>
            </li>
            <li>
              <a href="javascript:" id="Property">Property</a>
            </li>
            <li>
              <a href="javascript:" id="logout">Logout</a>
            </li>
          </ul>
          <form action="<%=request.getContextPath()%>/user/user.do" method="POST" id="fProperty"></form>
          <form action="<%=request.getContextPath()%>/logout.do" method="POST" id="flogout">
          </form>
          <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
          </form>
        </div>
      </div>
    </div>