package br.cefet.clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.cefet.clinicaveterinaria.model.Administrador;

public class AdministradorDao {
	private Connection con = null;
	
	public AdministradorDao() {
		con = ConnectionFactory.getConnection();
	}
	
	public void cadastrar(Administrador admin) throws SQLException {
		String sql = "INSERT INTO administrador(nome,login,senha) VALUES (?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, admin.getNome());
		stmt.setString(2, admin.getLogin());
		stmt.setString(3, admin.getSenha());
		
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Administrador logar(String login, String senha) throws SQLException {
		String sql = "Select id,nome,login,senha from administrador where login = ? and senha = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, senha);
		
		ResultSet rs = stmt.executeQuery();
		
		Administrador admin = null;
		if(rs.next()) {
			admin = new Administrador();
			admin.setId(rs.getInt("id"));
			admin.setLogin(rs.getString("login"));
			admin.setNome(rs.getString("nome"));
			admin.setSenha(rs.getString("senha"));
		}
		
		stmt.close();
		con.close();
		
		return admin;
	}
}
