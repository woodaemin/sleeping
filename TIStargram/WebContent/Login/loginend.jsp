<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
    
    </script>
<jsp:include page="/top.jsp"/>


<html><head>
   <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
    rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath }/CSS/login.css" 
	rel="stylesheet" type="text/css">
  </head><body>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="panel-body">
              <div class="section">
                <div class="container">
                  <div class="row">
                    <div class="col-md-6">
                      <img src="${pageContext.request.contextPath }/Login/insta.PNG" class="center-block img-responsive">
                      <form action="<%=request.getContextPath()%>/join.do" method="POST">
                        <p></p>
                        <div class="form-group">
                          <div class="form-group">
                            <input class="form-control" id="email" name="email" placeholder="휴대폰 또는 이메일 주소" type="email">
                          </div>
                          <div class="form-group">
                            <input class="form-control" id="name" name="name" placeholder="성명" type="text">
                          </div>
                          <div class="form-group">
                            <input class="form-control" id="userid" name="userid" placeholder="아이디" type="text">
                          </div>
                          <div class="form-group">
                            <input class="form-control" id="password" name="password" placeholder="비밀번호" type="password">
                          </div>
                          <button type="submit" class="btn btn-block btn-info">회원가입</button>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="section">
        <div class="container">
          <div class="row">
            <h3 class="text-primary">INSTAGRAM정보&nbsp;&nbsp;&nbsp;지원&nbsp;&nbsp;&nbsp;홍보&nbsp;센터&nbsp;&nbsp;&nbsp;&nbsp;API
              &nbsp;&nbsp;&nbsp;채용&nbsp;정보&nbsp;&nbsp;개인정보처리방법&nbsp;&nbsp;약관&nbsp;&nbsp;&nbsp;
              디랙터리&nbsp;&nbsp;&nbsp;프로필&nbsp;&nbsp;해시태그&nbsp;&nbsp;&nbsp;언어</h3>
          </div>
        </div>
      </div>
    </div>
  

</body></html>