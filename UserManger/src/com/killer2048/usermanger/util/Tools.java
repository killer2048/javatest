package com.killer2048.usermanger.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.killer2048.usermanger.Main;
import com.killer2048.usermanger.sql.WithPreparedStatement;

public class Tools {
	// ������
	public static void horizontalLine() {
		// ��ʾ�ָ���
		System.out.println("==============================");// length=30
	}

	//�ַ����Ƿ�Ϊ����
		public static boolean isNumeric(String str) {
			for (int i = 0; i < str.length(); i++) {
				if (!Character.isDigit(str.charAt(i))) {
					return false;
				}
			}
			return true;
		}
		
		
		public static boolean checkNameUsed(String name) throws SQLException {
			int count = 1;
			ResultSet rs = null;
			WithPreparedStatement ps = new WithPreparedStatement(Main.getInstance().getConn().prepareStatement("select count(id) as count from users where name= ?"));
			ps.set(1, name);
			rs = ps.query();
//			rs = Main.getInstance().query("select count(id) as count from users where name='" + name + "'");
			if (rs.next()) {
				count = rs.getInt("count");
			}
			rs.close();
			ps.close();

			if (count == 0) {
				return false;
			}
			return true;
		}
}
