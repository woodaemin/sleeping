package post.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import post.model.PostVO;

public class PostShowAction extends AbstractAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<PostVO> list = (List<PostVO>) req.getSession().getAttribute("List");
		System.out.println(list);
		String idxStr = req.getParameter("idx");
		int idx = Integer.parseInt(idxStr);
		PostVO vo = list.get(idx);
		req.setAttribute("vo", vo);
		this.setViewPage("../test.jsp");
		this.setRedirect(false);
	}

}
