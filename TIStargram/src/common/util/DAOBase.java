package common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.*;
import javax.sql.*;

public class DAOBase {
	protected DataSource ds; // DataSource통해 얻기(DBCP)
	protected Connection con;
	protected PreparedStatement pt;
	protected ResultSet rt;

	public DAOBase() {
		try {
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/snsMaster");
		System.out.println("DataSource LookUp success");
		}catch (NamingException e) {
			// TODO: handle exception
		}
	}

	public void close() {
		try {
			if (rt != null)
				rt.close();
			if (pt != null)
				pt.close();
			if (con != null)
				con.close();
			//dbcp는 con.close()하면 연결을 끊는 것이 아니라 풀에 자원을 반납한다.
			// if(con!=null) con.close();
			//if (con != null)pool.returnConnection(con);
		} catch (Exception e) {
			System.out.println("error:" + e);
		}
	}
}