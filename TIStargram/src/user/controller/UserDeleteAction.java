package user.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import user.model.UserDAO;
import user.model.UserVO;


public class UserDeleteAction extends AbstractAction{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//1.글번호, 비밀번호  파라미터 값 받기
		HttpSession ses = req.getSession();
		UserVO vo = (UserVO) ses.getAttribute("loginUser");
		String userid = vo.getUserid();
		String oldpassword = req.getParameter("oldpassword");
		
		UserDAO dao= new UserDAO();
			if(userid==null||oldpassword==null) {
			this.setViewPage("../index.do");
			this.setRedirect(true);
			return;
		}
		
			if (dao.Check3(userid, oldpassword)) {
				String view = CommonUtil.addMsgBack(req, "비밀번호가 일치하지 않습니다.");
				this.setViewPage("../"+view);
				this.setRedirect(false);
				return;
			}
		
			
		
		
		try {
			if(userid.equals(vo.getUserid())) {
			int n=dao.deleteUser(userid);
			//res.sendRedirect("index.do");
						
			String msg=(n>0)?"삭제성공":"삭제실패";
			String loc = (n > 0) ? "../index.do" : "javascript:history.back()";
			String view = CommonUtil.addMsgLoc(req, msg, loc);
			//String viewPage = CommonUtil.addMsgLoc(req, msg, loc);
			System.out.println(view);
			this.setViewPage("../"+view);// 뷰페이지 지정
			this.setRedirect(false);
			}
					
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.setRedirect(false);

	}
	
}
