package reply.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import reply.model.ReplyDAO;
import reply.model.ReplyVO;

public class ShowReplyAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ReplyDAO dao = new ReplyDAO();

		int post_idx = Integer.parseInt(req.getParameter("post_idx"));

		List<ReplyVO> list = dao.getListReply(post_idx);

		req.setAttribute("replyList", list);
	}

}
