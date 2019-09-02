package main.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import post.model.PostDAO;
import post.model.PostVO;
import user.model.UserVO;

public class ShowListAction extends AbstractAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession ses = req.getSession();
		PostDAO dao = new PostDAO();
		UserVO userVo = (UserVO)ses.getAttribute("loginUser");
		List<PostVO> List = dao.getPostList(userVo.getUserid());
		ServletContext svc = req.getServletContext();
		ses.setAttribute("List", List);
		System.out.println(List.get(1).getPictures());
		this.setViewPage("/main.jsp");
		this.setRedirect(false);
	}

}
