package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DAO {
	
	//MOLTO SPESSO MI CONVIENE DELEGARE LE OPERAZIONI AL DATABASE COSI NON APPESANTISCO IL CODICE
	public boolean isCorrect(String anagramma) {

		final String sql = "SELECT nome FROM dizionario.parola WHERE nome = ? ";
		
		boolean result;
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				//System.out.println("corretto");
				result =  true;
			}else {
				result =  false;
				//System.out.println("NOT corretto");
			}
			conn.close();
			return result;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore DB", e);
		}
	}
}
