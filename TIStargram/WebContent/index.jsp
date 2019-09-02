<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
    
    </script>
<jsp:include page="/top.jsp"/>
    <div class="section" style="padding-top: 65px;">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <img src="${pageContext.request.contextPath }/Images/iphone.png" class="img-responsive">
          </div>
          <div class="col-md-6">
            <img src="${pageContext.request.contextPath }/Images/logo.png" class="center-block img-responsive">
            <form action="<%=request.getContextPath()%>/login.do" method="POST">
              <p></p>
              <div class="form-group">
                <div class="form-group">
                  <input class="form-control" id="_userid" name="userid" placeholder="아이디" type="text">
                </div>
                <div class="form-group">
                  <input class="form-control" id="_password" name="password" placeholder="비밀번호" type="password">
                </div>
                <button type="submit" class="btn btn-block btn-info">로그인</button>
                <p></p>              
              </div>
            </form>
            <form action="<%=request.getContextPath()%>/create.do" method="POST">
            <button type="submit" class="btn btn-block btn-default" id="Join">회원가입</button>
            <p></p>
            </form>
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
    </body>
    </html>