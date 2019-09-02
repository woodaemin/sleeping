package post.model;

import java.io.Serializable;
import java.sql.Date;

public class PostVO implements Serializable {
	private int idx;
	private String writer_id;
	private String[] pictures;
	private String text_contents;
	private String tag;
	private Date post_date;

	public PostVO() {

	}

	public PostVO(int idx, String writer_id, String[] pictures, String text_contents, String tag, Date post_date) {
		super();
		this.idx = idx;
		this.writer_id = writer_id;
		this.pictures = pictures;
		this.text_contents = text_contents;
		this.tag = tag;
		this.post_date = post_date;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public String getPictures() {
		String pic = "";
		for (String string : pictures) {
			pic += string + " ";
		}
		return pic.trim();
	}

	public String getPictures(int num) {
		return pictures[num];
	}
	
	public void setPictures(String[] pictures) {
		this.pictures = pictures;
	}

	public String getText_contents() {
		return text_contents;
	}

	public void setText_contents(String text_contents) {
		this.text_contents = text_contents;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
}
