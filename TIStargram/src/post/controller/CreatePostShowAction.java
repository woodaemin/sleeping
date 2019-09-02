package post.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class CreatePostShowAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
			this.setViewPage("../Post/PostInsert.jsp");
			this.setRedirect(false);
	}

}
