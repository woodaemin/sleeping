package reply.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import reply.model.ReplyDAO;
import reply.model.ReplyVO;
import user.model.UserVO;

public class InsertReplyAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// ajax로 처리
		// post방식으로 받아올듯

		HttpSession ses = req.getSession();
		ReplyDAO dao = new ReplyDAO();
		UserVO userVo = (UserVO) ses.getAttribute("loginUser");

		int rp_post_idx = Integer.parseInt(req.getParameter("rp_post_idx"));
		String rp_contents = req.getParameter("rp_contents");

		ReplyVO reply = new ReplyVO(0, rp_post_idx, userVo.getUserid(), rp_contents, null);
		int n = dao.insertReply(reply);

		String msg = (n > 0) ? "삽입 성공" : "삽입 실패";

		// 후 처리
	}

}
