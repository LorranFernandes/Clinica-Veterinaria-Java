package br.cefet.clinicaveterinaria.dao;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.clinicaveterinaria.model.Cliente;

public class ClienteDao {
	
	private Connection con = null;
	
	public ClienteDao() {
		con = ConnectionFactory.getConnection();
	}
	
	public void adicionar(Cliente cliente) throws SQLException {
		String sql = "insert cliente(nome, telefone) values (?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getTelefone());
		stmt.execute();
		stmt.close();
		con.close();
	}

	public void alterar(Cliente cliente) throws SQLException {
		String sql = "update cliente set nome = ?, telefone = ? "
				+ "  where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getTelefone());
		stmt.setInt(3, cliente.getId());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void excluir (int id) throws SQLException {
		String sql = "delete from cliente where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,id);
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Cliente listarUm(int id) throws SQLException {
		String sql = "select id, nome from cliente "
				+ " where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		Cliente cliente = null;
		if(rs.next()) {
			cliente = new Cliente();
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
		}
		stmt.close();
		con.close();
		return cliente;
	}
	
	
	public List<Cliente> listarTodos() throws SQLException {
		String sql = "select id, nome from cliente";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		
		Cliente cliente = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		while(rs.next()) {
			cliente = new Cliente();
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
			clientes.add(cliente);
		}
		stmt.close();
		con.close();
		return clientes;
	}
	
	public List<Cliente> listar(String txt) throws SQLException {
		String sql = "select id, nome "
				+ " from cliente where nome like ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		txt = "%" + txt + "%"; 
		stmt.setString(1, txt);
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		ResultSet rs = stmt.executeQuery();
		Cliente cliente = null;
		while(rs.next()) {
			cliente = new Cliente();
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
				
			clientes.add(cliente);
		}
		stmt.close();
		con.close();
		return clientes;
	}
	
}
