package br.cefet.clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.clinicaveterinaria.model.Animal;
import br.cefet.clinicaveterinaria.model.Cliente;

public class AnimalDao {
	private Connection con = null;
	
	public AnimalDao() {
		con = ConnectionFactory.getConnection();
	}

	
	public void adicionar(Animal animal) throws SQLException {
		String sql = "insert into animal (nome, especie, raca, idade, idcliente)"
				+ "  values (?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,animal.getNome());
		stmt.setString(2,animal.getEspecie());
		stmt.setString(3,animal.getRaca());
		stmt.setInt(4,animal.getIdade());
		stmt.setInt(5,animal.getCliente().getId());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	
	public void alterar(Animal animal) throws SQLException {
		String sql = "update animal set nome = ?, especie = ?, "
				+ "  raca = ?, idade = ?, idcliente = ?  where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,animal.getNome());
		stmt.setString(2,animal.getEspecie());
		stmt.setString(3,animal.getRaca());
		stmt.setInt(4,animal.getIdade());
		stmt.setInt(5,animal.getCliente().getId());
		stmt.setInt(6,animal.getId());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void excluir (int id) throws SQLException {
		String sql = "delete from animal where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,id);
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Animal listarUm(int id) throws SQLException {
		String sql = "select id, nome, especie, idcliente from animal "
				+ " where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		Animal animal = null;
		if(rs.next()) {
			animal = new Animal();
			animal.setId(rs.getInt("id"));
			animal.setNome(rs.getString("nome"));
			animal.setEspecie(rs.getString("especie"));
			ClienteDao cliDao = new ClienteDao();
			Cliente cliente = cliDao.listarUm(rs.getInt("idcliente"));
			animal.setCliente(cliente);
		}
		stmt.close();
		con.close();
		return animal;
	}
	
	public List<Animal> listarTodos() throws SQLException {
		String sql = "select id, nome, especie, idcliente from animal";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		
		Animal animal = null;
		List<Animal> animais = new ArrayList<Animal>();
		while(rs.next()) {
			animal = new Animal();
			animal.setId(rs.getInt("id"));
			animal.setNome(rs.getString("nome"));
			animal.setEspecie(rs.getString("especie"));
			ClienteDao cliDao = new ClienteDao();
			Cliente cliente = cliDao.listarUm(rs.getInt("idcliente"));
			animal.setCliente(cliente);
			animais.add(animal);
		}
		stmt.close();
		con.close();
		return animais;
	}
	
	public List<Animal> listar(String txt) throws SQLException {
		String sql = "select id, nome, especie, idcliente "
				+ " from animal where nome like ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		txt = "%" + txt + "%"; 
		stmt.setString(1, txt);
		List<Animal> animais = new ArrayList<Animal>();
		
		ResultSet rs = stmt.executeQuery();
		Animal animal = null;
		while(rs.next()) {
			animal = new Animal();
			animal.setId(rs.getInt("id"));
			animal.setNome(rs.getString("nome"));
			animal.setEspecie(rs.getString("especie"));
			ClienteDao cliDao = new ClienteDao();
			Cliente cliente = cliDao.listarUm(rs.getInt("idcliente"));
			animal.setCliente(cliente);
			animais.add(animal);
		}
		stmt.close();
		con.close();
		return animais;
	}
	
}
