package main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import user.model.UserVO;

public class MainFormAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession ses=req.getSession();
		UserVO user = (UserVO)ses.getAttribute("loginUser");
		if(user==null || user.getUserid().toString().trim().isEmpty()) {
	         String viewPage=CommonUtil.addMsgBack(req, "잘못들어온 경로입니다.");
	         this.setViewPage("../"+viewPage);
	         this.setRedirect(false);
	         return;
		}	
		this.setViewPage("/user/mainList.do");
		this.setRedirect(false);
	}

}
