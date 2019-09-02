package common.util;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {

	public static String addMsgLoc(HttpServletRequest req, String msg, String loc) {
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		return "alert/message.jsp";
	}// -------------------------

	public static String addMsgBack(HttpServletRequest req, String msg) {
		req.setAttribute("msg", msg);
		req.setAttribute("loc", "javascript:history.back()");
		return "alert/message.jsp";
	}// -------------------------

}/////////////////////////////////////////
