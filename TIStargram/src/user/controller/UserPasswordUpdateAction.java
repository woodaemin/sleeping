package user.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import user.model.UserDAO;
import user.model.UserVO;

public class UserPasswordUpdateAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		try {
			int n = 0;
			HttpSession ses = req.getSession();
			UserVO vo = (UserVO) ses.getAttribute("loginUser");
			String userid = vo.getUserid();
			String oldpassword = req.getParameter("oldpassword");
			String newpassword = req.getParameter("newpassword");
			UserDAO dao = new UserDAO();

			if (oldpassword == null || oldpassword.isEmpty() || newpassword == null || newpassword.isEmpty()) {

				String view = CommonUtil.addMsgBack(req, "잘못 들어온 경로입니다");
				this.setViewPage("../"+view);
				this.setRedirect(false);
				return;
			}

			if (dao.Check3(userid, oldpassword)) {
				String view = CommonUtil.addMsgBack(req, "비밀번호가 일치하지 않습니다.");
				this.setViewPage("../"+view);
				this.setRedirect(false);
				return;
			}

			if (!oldpassword.contentEquals(newpassword))
				n = dao.editPassword(userid, newpassword);

			String str = (n > 0) ? "수정성공" : "수정실패";
			String loc = (n > 0) ? "user.do" : "javascript:history.back()";
			String viewPage = CommonUtil.addMsgLoc(req, str, loc);

			this.setViewPage("../"+viewPage);// 뷰페이지 지정
			this.setRedirect(false);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);

		}
	}
}
