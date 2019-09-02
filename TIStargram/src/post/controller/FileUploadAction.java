package post.controller;

import java.io.File;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.controller.AbstractAction;
import post.model.PostDAO;
import post.model.PostVO;
import user.model.NotUserException;
import user.model.UserVO;

public class FileUploadAction extends AbstractAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ServletContext app=req.getServletContext();
		String upDir=app.getRealPath("/PostImage");
		System.out.println(upDir);
		File dir=new File(upDir);
		if(upDir == null) {
			dir = new File(app.getRealPath("/")+File.pathSeparator+"/PostImage");
		} else {
			dir = new File(upDir);
		}
		
		if(!dir.exists()) {
			//디렉토리 만들기
			dir.mkdir();
			System.out.println("만듬");
		}
		System.out.println("만들?");
		MultipartRequest mr=
				new MultipartRequest(req,upDir,10*1024*1024,"UTF-8",new DefaultFileRenamePolicy());
		System.out.println("업로드 성공");
		
		String contents = mr.getParameter("text-contents");
		System.out.println(contents);
		
		String filenames = mr.getFilesystemName("filename1") +" "+mr.getFilesystemName("filename2")+" "+ mr.getFilesystemName("filename3");
		System.out.println(filenames);
		
		filenames = filenames.replaceAll("null", "");
		filenames = filenames.trim();
		
		System.out.println(filenames);
		
		String tags = mr.getParameter("tags");
		tags = tags.trim();
		System.out.println(tags);
		UserVO user = (UserVO)req.getSession().getAttribute("loginUser");
		
		String writer = user.getUserid();
		String[] filenamesarr = new String[1];
		filenamesarr[0] = filenames;
		PostVO vo = new PostVO(0, writer, filenamesarr, contents, tags, null);
		
		PostDAO PDao = new PostDAO();
		int n = PDao.insertPost(vo);
		if(n<=0) {
			throw new NotUserException("글쓰기 실패.");
		}
		this.setViewPage("main.do");
		this.setRedirect(true);
	}

}
