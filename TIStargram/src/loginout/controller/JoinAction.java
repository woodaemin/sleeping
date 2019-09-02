package loginout.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import user.model.NotUserException;
import user.model.UserDAO;
import user.model.UserVO;

public class JoinAction extends AbstractAction {

   @Override
   public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
      try {
         // 아이디, 비번 , 아이디 저장 파라미터 값 받기
         String email = req.getParameter("email");
         String name = req.getParameter("name");
         String id = req.getParameter("userid");
         String pw = req.getParameter("password");
         if (email == null || name == null || id == null || pw == null || email.trim().isEmpty()
               || name.trim().isEmpty() || id.trim().isEmpty() || pw.trim().isEmpty()) {
            String loc = "index.do";
            String viewPage = CommonUtil.addMsgLoc(req, "회원가입실패", loc);
            this.setViewPage(viewPage);
            this.setRedirect(false);
            return;
         } else {
            UserVO user = new UserVO(email, name, id, pw);
            UserDAO dao = new UserDAO();

            boolean tf = dao.idCheck(id, email);
            if (tf) {
               int n = dao.createUser(user);
               String str = (n > 0) ? "등록성공" : "등록실패";
               String loc = (n > 0) ? "index.do" : "javascript:history.back()";
               String viewPage = CommonUtil.addMsgLoc(req, str, loc);
               System.out.println("success");
               this.setViewPage(viewPage);// 뷰페이지 지정
               this.setRedirect(false);
            } else {
               String viewPage = CommonUtil.addMsgBack(req, "중복된 아이디나 이메일입니다.");
               this.setViewPage(viewPage);
               this.setRedirect(false);
            }
         }

         // 6.그 결과 메시지 처리 및 페이지 이동

      } catch (Exception e) {
         String msg = e.getMessage();
         this.setViewPage(CommonUtil.addMsgBack(req, msg));
         this.setRedirect(false);
      }
   }

}