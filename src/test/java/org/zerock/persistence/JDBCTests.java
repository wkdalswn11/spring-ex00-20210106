package org.zerock.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		String url = "jdbc:oracle:thin:@db202101040921_high?TNS_ADMIN=/home/opc/wallet";
		String user = "admin";
		String password = "Wkdalswn123!@";
		
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			assertNotNull(con);
		} catch (Exception e) {
			fail(e.getMessage());
			log.info(e);
		}
		
	}
	
}
