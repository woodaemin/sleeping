package reply.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import reply.model.ReplyDAO;
import user.model.UserVO;

public class DeleteReplyAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession ses = req.getSession();
		UserVO userVo = (UserVO) ses.getAttribute("loginUser");
		// 삭제할 때 지울 post의 idx로 접근(작성자ID과 접속자ID가 같은지 체크????)
		ReplyDAO dao = new ReplyDAO();

		// int post_idx = Integer.parseInt(req.getAttribute("post_idx"));

		// int n = dao.deleteReply(post_idx);

	}

}
