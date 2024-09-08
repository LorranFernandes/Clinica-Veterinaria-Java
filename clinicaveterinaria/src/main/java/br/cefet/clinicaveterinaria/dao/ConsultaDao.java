package br.cefet.clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.clinicaveterinaria.model.Animal;
import br.cefet.clinicaveterinaria.model.Consulta;
import br.cefet.clinicaveterinaria.model.Veterinario;

public class ConsultaDao {
	private Connection con = null;
	
	public ConsultaDao() {
		con = ConnectionFactory.getConnection();
	}
	
	
	public void adicionar(Consulta consulta) throws SQLException {
		String sql = "insert into consulta (data, hora, valor, idanimal, idveterinario)"
				+ "  values (?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setDate(1, new java.sql.Date(consulta.getData().getTime()));
		stmt.setTime(2, new java.sql.Time(consulta.getHora().getTime()));
		stmt.setFloat(3,consulta.getValor());
		stmt.setInt(4,consulta.getAnimal().getId());
		stmt.setInt(5,consulta.getVeterinario().getId());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	
	public void alterar(Consulta consulta) throws SQLException {
		String sql = "update consulta set data = ?, hora = ?, "
				+ "  valor = ?, idanimal = ?, idveterinario = ?  where id = ?";;
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setDate(1, new java.sql.Date(consulta.getData().getTime()));
		stmt.setTime(2, new java.sql.Time(consulta.getHora().getTime()));
		stmt.setFloat(3,consulta.getValor());
		stmt.setInt(4,consulta.getAnimal().getId());
		stmt.setInt(5,consulta.getVeterinario().getId());
		stmt.setInt(6,consulta.getId());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void excluir (int id) throws SQLException {
		String sql = "delete from consulta where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,id);
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Consulta listarUm(int id) throws SQLException {
		String sql = "select id, data, hora, valor, idanimal, idveterinario from consulta "
				+ " where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		Consulta consulta = null;
		if(rs.next()) {
			consulta = new Consulta();
			consulta.setId(rs.getInt("id"));
			consulta.setData(rs.getDate("data"));
			consulta.setHora(rs.getTime("hora"));
			consulta.setValor(rs.getFloat("valor"));
			AnimalDao aniDao = new AnimalDao();
			Animal animal = aniDao.listarUm(rs.getInt("idanimal"));
			consulta.setAnimal(animal);
			VeterinarioDao vetDao = new VeterinarioDao();
			Veterinario veterinario = vetDao.listarUm(rs.getInt("idveterinario"));
			consulta.setVeterinario(veterinario);
		}
		stmt.close();
		con.close();
		return consulta;
	}
	
	public List<Consulta> listarTodos() throws SQLException {
		String sql = "select id, data, hora, valor, idanimal, idveterinario from consulta ";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		Consulta consulta = null;
		List<Consulta> consultas = new ArrayList<Consulta>();
		while(rs.next()) {
			consulta = new Consulta();
			consulta.setId(rs.getInt("id"));
			consulta.setData(rs.getDate("data"));
			consulta.setHora(rs.getTime("hora"));
			consulta.setValor(rs.getFloat("valor"));
			AnimalDao aniDao = new AnimalDao();
			Animal animal = aniDao.listarUm(rs.getInt("idanimal"));
			consulta.setAnimal(animal);
			VeterinarioDao vetDao = new VeterinarioDao();
			Veterinario veterinario = vetDao.listarUm(rs.getInt("idveterinario"));
			consulta.setVeterinario(veterinario);
			consultas.add(consulta);
		}
		stmt.close();
		con.close();
		return consultas;
	}
	
	
	public List<Consulta> listar(String txt) throws SQLException {
		String sql = "select id, data, hora, valor, idanimal, idveterinario "
				+ " from consulta where data like ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		txt = "%" + txt + "%"; 
		stmt.setString(1, txt);
		List<Consulta> consultas = new ArrayList<Consulta>();
		
		ResultSet rs = stmt.executeQuery();
		Consulta consulta = null;
		while(rs.next()) {
			consulta = new Consulta();
			consulta.setId(rs.getInt("id"));
			consulta.setData(rs.getDate("data"));
			consulta.setHora(rs.getTime("hora"));
			consulta.setValor(rs.getFloat("valor"));
			AnimalDao aniDao = new AnimalDao();
			Animal animal = aniDao.listarUm(rs.getInt("idanimal"));
			consulta.setAnimal(animal);
			VeterinarioDao vetDao = new VeterinarioDao();
			Veterinario veterinario = vetDao.listarUm(rs.getInt("idveterinario"));
			consulta.setVeterinario(veterinario);
			consultas.add(consulta);
		}
		stmt.close();
		con.close();
		return consultas;
	}
	
	public float somarValoresPorMes(int mes, int ano) throws SQLException {
	    String sql = "SELECT SUM(valor) as total FROM consulta WHERE MONTH(data) = ? AND YEAR(data) = ?";
	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setInt(1, mes);
	    stmt.setInt(2, ano);
	    
	    ResultSet rs = stmt.executeQuery();
	    float total = 0;
	    
	    if (rs.next()) {
	        total = rs.getFloat("total");
	    }
	    
	    stmt.close();
	    con.close();
	    
	    return total;
	}
	
}
