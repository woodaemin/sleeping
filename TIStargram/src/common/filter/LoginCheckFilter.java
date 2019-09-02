package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.util.CommonUtil;
import user.model.UserVO;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("/user/*")
public class LoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req2 = (HttpServletRequest)req;
		HttpSession ses = req2.getSession();
		Object loginUser = ses.getAttribute("loginUser");
		if(loginUser == null) {
			String msg = "로그인이 필요합니다.";
			String loc = "../index.do";
			String viewPage = CommonUtil.addMsgLoc(req2, msg, loc);
			RequestDispatcher dispatcher = req2.getRequestDispatcher(viewPage);
			dispatcher.forward(req2, res);
			return;
		}
		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
