package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import user.model.UserDAO;

public class UserEmailChcekAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String result ="";
		String email=req.getParameter("email");
		UserDAO dao=new UserDAO();
		boolean emailCheck=dao.Check2(email);
		if(emailCheck) {
			result = "사용가능한 이메일입니다.";
		} else {
			result = "사용중인 이메일입니다.";
		}
		req.setAttribute("result", result);
		this.setViewPage("../User/userResult.jsp");
		this.setRedirect(false);
		
	}

}
