package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
public class UserUpdateAction extends AbstractAction{
	
@Override	
public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
	this.setViewPage("/User/t.jsp");
	this.setRedirect(false);
	}
}
