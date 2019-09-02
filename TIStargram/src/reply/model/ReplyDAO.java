package reply.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.util.DAOBase;

public class ReplyDAO extends DAOBase {

	public ReplyDAO() {
		System.out.println("ReplyDAO create...");
	}

	public int insertReply(ReplyVO reply) throws SQLException {
		con = ds.getConnection();

		pt = con.prepareStatement("insert into reply values(reply_seq.nextval, ?, ?, ?, sysdate)");

		pt.setInt(1, reply.getRp_post_idx());
		pt.setString(2, reply.getRp_post_id());
		pt.setString(3, reply.getRp_contents());

		return pt.executeUpdate();
	}

	public int deleteReply(int idx) throws SQLException {
		con = ds.getConnection();

		pt = con.prepareStatement("delete from reply where idx=?");
		pt.setInt(1, idx);

		return pt.executeUpdate();

	}

	public void updateReply() {

	}

	public List<ReplyVO> getListReply(int post_idx) throws SQLException {
		con = ds.getConnection();

		pt = con.prepareStatement("select * where idx=? order by rp_date desc");
		pt.setInt(1, post_idx);
		rt = pt.executeQuery();
		ArrayList<ReplyVO> list = new ArrayList<ReplyVO>();

		while (rt.next())
			list.add(new ReplyVO(rt.getInt(1), rt.getInt(2), rt.getString(3), rt.getString(4), rt.getDate(5)));

		return list;
	}
}
