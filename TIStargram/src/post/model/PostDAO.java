package post.model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.util.DAOBase;

public class PostDAO extends DAOBase {

	public PostDAO() {
		System.out.println("PostDAO create...");
	}

	public List<PostVO> getPostList(String user) throws SQLException {
		List<PostVO> list = new ArrayList<PostVO>();
		con = ds.getConnection();
		pt = con.prepareStatement("select * from post where writer_id = ? order by idx desc");
		pt.setString(1, user);
		rt = pt.executeQuery();
		while (rt.next()) {
			int idx = rt.getInt("idx");
			String writer_id = rt.getString("writer_id");
			String pictures = rt.getString("pictures");
			String text_contents = rt.getString("text_contents");
			String tag = rt.getString("tag");
			Date post_date = rt.getDate("post_date");
			String[] pic = pictures.split(" ");
			PostVO VO = new PostVO(idx, writer_id, pic, text_contents, tag, post_date);
			list.add(VO);
		} 
		System.out.println(list.size());
		return list;
	}
	
	public int insertPost(PostVO post) throws SQLException {
		con = ds.getConnection();
		pt = con.prepareStatement("insert into post values(post_seq.nextval,?,?,?,?,sysdate)");
		pt.setString(1, post.getWriter_id());
		pt.setString(2, post.getPictures());
		pt.setString(3, post.getText_contents());
		pt.setString(4, post.getTag());
		int n = pt.executeUpdate();
		return n;
	}
	
	public PostVO showPost(int idx) throws SQLException {
		PostVO vo = null;
		con = ds.getConnection();
		pt = con.prepareStatement("select * from post where idx = ?");
		pt.setInt(1, idx);
		rt = pt.executeQuery();
		if(rt.next()) {
			String writer_id = rt.getString("writer_id");
			String pictures = rt.getString("pictures");
			String text_contents = rt.getString("text_contents");
			String tag = rt.getString("tag");
			Date post_date = rt.getDate("post_date");
			String[] pic = pictures.split(" ");
			vo = new PostVO(idx, writer_id, pic, text_contents, tag, post_date);
			return vo;
		}
		return vo;
	}
}
