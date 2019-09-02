package user.model;

import java.sql.SQLException;

import common.util.DAOBase;
import user.model.UserVO;

public class UserDAO extends DAOBase {

	public UserDAO() {
		System.out.println("userDao() create");
	}

	public UserVO loginUser(String userid, String pwd) throws SQLException {

		try {
			UserVO uv = null;
			String userid2 = userid;
			con = ds.getConnection();
			pt = con.prepareStatement("select * from member where (email = ? or userid = ?) and pwd = ?");
			pt.setString(1, userid);
			pt.setString(2, userid2);
			pt.setString(3, pwd);
			rt = pt.executeQuery();

			if (rt.next()) {
				uv = new UserVO(rt.getString("email"), rt.getString("name"), rt.getString("userid"), null);
			}
			return uv;
		} finally {
			close();
		}
	}//
	
	

	/**아이디 생성*/
	public int createUser(UserVO user) throws SQLException {
		try {
			// con = DBUtil.getCon();
			// con=this.getPool().getConnection();
			con = ds.getConnection();
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";// insert臾�
																// �옉�꽦�븯湲�
			pt = con.prepareStatement(sql);
			pt.setString(1, user.getUserid());
			pt.setString(2, user.getPwd());
			pt.setString(3, user.getName());
			pt.setString(4, user.getEmail());

			// ? setting
			int n = pt.executeUpdate();
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}// -----------------------

	/** 아이디 중복체크 처리 메소드 */
	public boolean idCheck(String userid, String email) throws SQLException {
		try {
			// con = DBUtil.getCon();
			// con=this.getPool().getConnection();
			con = ds.getConnection();
			String sql = "select userid, email from member where userid=? or email =?";
			pt = con.prepareStatement(sql);
			pt.setString(1, userid);
			pt.setString(2, email);
			rt = pt.executeQuery();
			boolean isExists = rt.next();
			// 커서 이동해서 회원아이디가 있으면 true,없으면false를 반환
			return !isExists;
			// 사용 가능하면 true,사용 불가능하면 false를 반환하자.
		} finally {
			close();
		}
	}// --------------

	public boolean Check(String userid) throws SQLException {
		try {
			// con = DBUtil.getCon();
			// con=this.getPool().getConnection();
			con = ds.getConnection();
			String email = userid;
			String sql = "select userid from member where userid=? or email=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, userid);
			pt.setString(2, email);

			rt = pt.executeQuery();
			boolean isExists = rt.next();

			return !isExists;

		} finally {
			close();
		}
	
	}
	public boolean Check2(String email) throws SQLException {
		try {
			con=ds.getConnection();
			String sql = "select email from member where email=? ";
			pt = con.prepareStatement(sql);
			pt.setString(1, email);
			
			rt = pt.executeQuery();
			boolean isExists = rt.next();
			System.out.println(isExists);
			return !isExists;
			
		} finally {
			close();
		}
	}
		public boolean Check3(String userid, String pwd) throws SQLException {
			try {
				
				con=ds.getConnection();
				String sql = "select pwd from member where userid=? and pwd=? ";
				pt = con.prepareStatement(sql);
				pt.setString(1, userid);
				pt.setString(2, pwd);
				
				
				rt = pt.executeQuery();
				boolean isExists = rt.next();
				
				return !isExists;
				
			} finally {
				close();
			}
	}// 이메일
	//회원정보를 수정
		public int editUser(UserVO user) throws SQLException {
			try {
				//con = DBUtil.getCon();
				con=ds.getConnection();
				String sql = "update member set  NAME=?, email=? WHERE userid=?";
				pt = con.prepareStatement(sql);
				pt.setString(1, user.getName());
				pt.setString(2, user.getEmail());
				pt.setString(3, user.getUserid());
				int n = pt.executeUpdate();
				return n;
				
			} finally {
				close();
			}
		}//
		public int editPassword(String userid, String pwd) throws SQLException{
			try {
				con=ds.getConnection();
				String sql="update member set pwd=? where userid=?";
				pt=con.prepareStatement(sql);
				pt.setString(1,pwd);
				pt.setString(2, userid);
				int n=pt.executeUpdate();
				return n;
			}finally {
				close();
			}
		}//비밀번호 수정하는 메소드
		
		// 회원정보를 삭제하는 메소드 
		public int deleteUser(String id) throws SQLException {
			try {
				//con = DBUtil.getCon();
				con=ds.getConnection();
				String sql = "delete from member where userid=?";
				pt = con.prepareStatement(sql);
				pt.setString(1, id);
				int n = pt.executeUpdate();
				return n;

			} finally {
				close();
			}
		}// -----
}