
package common.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "*.do" }, initParams = {
		@WebInitParam(name = "config", value = "C:\\Users\\user\\git\\repository\\TIStargram\\WebContent\\WEB-INF\\Command.properties") })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> cmdMap = new HashMap<>();
	/*
	 * 서블릿 실행 시 콧 요청이 있을 때 딱 한번 호출되는 메소드 init-prarm에 기술되어 있는config에 해당하는
	 * value값(Command.properties) 을 얻어온다. web.xml기술, 최근에는 어노테이션으로 대치됨
	 */
	public void init(ServletConfig conf) throws ServletException {
		// 초기 파라메터값(conf)을 읽어옴
		String props = conf.getInitParameter("config");
		System.out.println("init() props = " + props);
		Properties p = new Properties();
		// Command.properties파일에 있는 매핑정보를 Properties로 옮기기
		try {
			FileInputStream fis = new FileInputStream(props);
			p.load(fis);
			if (fis != null) {
				fis.close();
			}
			// "/hello.do"라는 key값에 해당하는 value값을 가져온다.
			
			//p에서 key값들만 추출하고, 그에 해당하는 value값도
			//추출하여, 해당 액션클래스들을 메모리에 올려
			//HashMap에 저장할 예정
			
			Set<Object> set = p.keySet();
			
			for (Object key : set) {
				String cmd = key.toString();
				String className = p.getProperty(cmd);
				System.out.println(cmd + "\n" + className);
				if(className!=null) {
					className = className.trim();
					Class cmdClass = Class.forName(className);
					Object cmdInstance = cmdClass.newInstance();
					//클래스 객체화 + 메모리올리기
					cmdMap.put(cmd, cmdInstance);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		requestProcess(req,res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		requestProcess(req,res);
	}

	private void requestProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		//1. 클라이언트 요청을 분석해서 SubController(xxxAction)
		// 에게 요청을 처리하도록 위임한다.
		String uri = req.getRequestURI(); // "/MyMVC/hello.do
		//System.out.println(uri);
		
		String myctx = req.getContextPath(); //"/MyMVC"
		int len = myctx.length();
		String cmd = uri.substring(len); // "/hello.do"
		Object instanse= cmdMap.get(cmd);
		if(instanse==null) {
			System.out.println("action is null");
			throw new ServletException(cmd + " is null");
		}
		AbstractAction action = (AbstractAction)instanse;
		//서브 컨트롤러의 execute()호출
		try {
			action.execute(req, res);
			String viewPage = action.getViewPage();
			
			if(viewPage==null) {
				System.out.println("viewPage is null");
				viewPage="test.html";
				//default = test.html
			}
			//이동방식에 따라 뷰페이지 이동
			if(action.isRedirect()) { //true : redirect / false : foward
				res.sendRedirect(viewPage);
			} else {
				RequestDispatcher dispatch = req.getRequestDispatcher(viewPage);
				dispatch.forward(req, res); 
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
