package user.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import user.model.NotUserException;
import user.model.UserDAO;
import user.model.UserVO;


public class UserUpdateActionEnd extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		try {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		HttpSession ses = req.getSession();
		UserVO vo = (UserVO)ses.getAttribute("loginUser");
		String id= vo.getUserid();		//String pwd=req.getParameter("pwd");
	
		if(id==null) {
			String view = CommonUtil.addMsgBack(req, "잘못 들어온 경로입니다");
			this.setViewPage(view);
			this.setRedirect(false);
			return;
		}
		
		
		UserVO	user= new UserVO(email, name, id, null);
		UserDAO dao=new UserDAO();
		if(!dao.Check2(email)) {
		    String viewPage = CommonUtil.addMsgBack(req, "중복된 아이디나 이메일입니다.");
            this.setViewPage(viewPage);
            this.setRedirect(false);
         
		}else {
			int n=0;
			n= dao.editUser(user);
			if (user != null) {
				ses.removeAttribute("loginUser");
				ses.setAttribute("loginUser", user);
				System.out.println(user);
				this.setViewPage("user.do");
				this.setRedirect(true);
		
			//6.그 결과 메시지 처리 및 페이지 이동
			String str=(n>0)?"수정성공":"수정실패";
			String loc=(n>0)?"user.do":"javascript:history.back()";
			String viewPage=CommonUtil.addMsgLoc(req, str, loc);
			this.setViewPage("../"+viewPage);
			this.setRedirect(false);
			
				/*
				 * String viewPage = CommonUtil.addMsgLoc(req, str, loc);
				 * this.setViewPage(viewPage);// 뷰페이지 지정 this.setRedirect(false);
				 */
		}//if
		}//else
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}//try
		
          
		
	}	//excute
	
	
		
	}//

