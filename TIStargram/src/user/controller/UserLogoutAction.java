package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import user.model.UserVO;

public class UserLogoutAction extends AbstractAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession ses= req.getSession();
		UserVO vo= (UserVO)ses.getAttribute("loginUser");
		if(vo!=null) {
			ses.removeAttribute("loginUser");
		} else {
			String str="로그인중이 아닙니다";
			String loc="/index.do";
			String viewPage=CommonUtil.addMsgLoc(req, str, loc);
			this.setViewPage("../"+viewPage);
			this.setRedirect(false);
			
		}
		this.setViewPage("./index.do");
		this.setRedirect(true);
		
	}
}
