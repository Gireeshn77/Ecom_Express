package com.Ecom_Express.utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginRepository {

	public LoginData getLoginData(int agentId) throws Exception {

		Connection con = DBUtility.getConnection();

		String query = "select username,passwd " + "from LoginCredentilas " + "where Agent_id=?";

		PreparedStatement pstmt = con.prepareStatement(query);

		pstmt.setInt(1, agentId);

		ResultSet rs = pstmt.executeQuery();

		LoginData login = null;

		if (rs.next()) {

			login = new LoginData(rs.getString("username"), rs.getString("passwd"));
		}

		rs.close();
		pstmt.close();

		return login;
	}
}