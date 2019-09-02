package loginout.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import user.model.NotUserException;
import user.model.UserDAO;
import user.model.UserVO;

public class LoginAction extends AbstractAction {

	   @Override
	   public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	      try {
	         // 아이디, 비번 , 아이디 저장 파라미터 값 받기
	         String id = req.getParameter("userid");
	         String pw = req.getParameter("password");
	         if (id == null || pw == null || id.trim().isEmpty() || pw.trim().isEmpty()) {
	            String loc = "index.do";
	            String viewPage = CommonUtil.addMsgLoc(req, "로그인실패.", loc);
	            this.setViewPage(viewPage);
	            this.setRedirect(false);
	            return;
	         }
	         System.out.println(id + " : " + pw);
	         UserDAO dao = new UserDAO();
	         if(dao.Check(id)) {
	            throw new NotUserException("없는 아이디입니다.");
	         }
	         UserVO uv = dao.loginUser(id, pw);
	         if (uv != null) {
	            HttpSession ses = req.getSession();
	            ses.setAttribute("loginUser", uv);
	            this.setViewPage("user/main.do");
	            this.setRedirect(true);
	         } else {
	            throw new NotUserException("비밀번호가 일치하지 않아요");
	         }
	      } catch (NotUserException e) {
	         String msg=e.getMessage();
	            this.setViewPage(CommonUtil.addMsgBack(req, msg));
	            this.setRedirect(false);
	      }
	   }
	}