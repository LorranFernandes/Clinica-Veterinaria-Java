package br.cefet.clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.clinicaveterinaria.model.Veterinario;

public class VeterinarioDao {

private Connection con = null;
	
	public VeterinarioDao() {
		con = ConnectionFactory.getConnection();
	}
	
	public void adicionar(Veterinario veterinario) throws SQLException {
		String sql = "insert veterinario(nome, especialidade) values (?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, veterinario.getNome());
		stmt.setString(2, veterinario.getEspecialidade());
		stmt.execute();
		stmt.close();
		con.close();
	}

	public void alterar(Veterinario veterinario) throws SQLException {
		String sql = "update veterinario set nome = ?, especialidade = ? "
				+ "  where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, veterinario.getNome());
		stmt.setString(2, veterinario.getEspecialidade());
		stmt.setInt(3, veterinario.getId());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void excluir (int id) throws SQLException {
		String sql = "delete from veterinario where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,id);
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Veterinario listarUm(int id) throws SQLException {
		String sql = "select id, nome from veterinario "
				+ " where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		Veterinario veterinario = null;
		if(rs.next()) {
			veterinario = new Veterinario();
			veterinario.setId(rs.getInt("id"));
			veterinario.setNome(rs.getString("nome"));
		}
		stmt.close();
		con.close();
		return veterinario;
	}
	
	public List<Veterinario> listarTodos() throws SQLException {
		String sql = "select id, nome from veterinario";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		
		Veterinario veterinario = null;
		List<Veterinario> veterinarios = new ArrayList<Veterinario>();
		while(rs.next()) {
			veterinario = new Veterinario();
			veterinario.setId(rs.getInt("id"));
			veterinario.setNome(rs.getString("nome"));
			veterinarios.add(veterinario);
		}
		stmt.close();
		con.close();
		return veterinarios;
	}
	
	public List<Veterinario> listar(String txt) throws SQLException {
		String sql = "select id, nome "
				+ " from veterinario where nome like ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		txt = "%" + txt + "%"; 
		stmt.setString(1, txt);
		List<Veterinario> veterinarios = new ArrayList<Veterinario>();
		
		ResultSet rs = stmt.executeQuery();
		Veterinario veterinario = null;
		while(rs.next()) {
			veterinario = new Veterinario();
			veterinario.setId(rs.getInt("id"));
			veterinario.setNome(rs.getString("nome"));
				
			veterinarios.add(veterinario);
		}
		stmt.close();
		con.close();
		return veterinarios;
	}
}
