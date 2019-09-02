package reply.model;

import java.io.Serializable;
import java.util.Date;

public class ReplyVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idx;
	private int rp_post_idx;
	private String rp_post_id;
	private String rp_contents;
	private java.util.Date rp_date;

	public ReplyVO() {
	}

	public ReplyVO(int idx, int rp_post_idx, String rp_post_id, String rp_contents, Date rp_date) {
		super();
		this.idx = idx;
		this.rp_post_idx = rp_post_idx;
		this.rp_post_id = rp_post_id;
		this.rp_contents = rp_contents;
		this.rp_date = rp_date;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getRp_post_idx() {
		return rp_post_idx;
	}

	public void setRp_post_idx(int rp_post_idx) {
		this.rp_post_idx = rp_post_idx;
	}

	public String getRp_post_id() {
		return rp_post_id;
	}

	public void setRp_post_id(String rp_post_id) {
		this.rp_post_id = rp_post_id;
	}

	public String getRp_contents() {
		return rp_contents;
	}

	public void setRp_contents(String rp_contents) {
		this.rp_contents = rp_contents;
	}

	public java.util.Date getRp_date() {
		return rp_date;
	}

	public void setRp_date(java.util.Date rp_date) {
		this.rp_date = rp_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
