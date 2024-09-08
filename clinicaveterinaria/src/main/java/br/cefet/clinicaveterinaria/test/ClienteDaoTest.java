package br.cefet.clinicaveterinaria.test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.cefet.clinicaveterinaria.dao.ClienteDao;
import br.cefet.clinicaveterinaria.model.Cliente;

class ClienteDaoTest {

	private ClienteDao clienteDao;   

    @Test
    public void test() throws SQLException {
        Cliente cliente = new Cliente("TEST", "123456789");
        clienteDao = new ClienteDao();
        
        System.out.println("Adicionando cliente...");
        clienteDao.adicionar(cliente); 
        
        clienteDao = new ClienteDao();
		List<Cliente> clientes = null;
		clientes = clienteDao.listar("TEST");

		Cliente clienteAdicionado = clientes.get(0);

	    assertEquals("TEST", clienteAdicionado.getNome());
	    
	    clienteDao = new ClienteDao();
        Cliente clienteInserido = clientes.get(0);
        clienteInserido.setNome("UPDATED");
        clienteInserido.setTelefone("987654321");
        
        System.out.println("Alterando Cliente...");
        clienteDao.alterar(clienteInserido);
        
        clienteDao = new ClienteDao();
        Cliente clienteAtualizado = clienteDao.listarUm(clienteInserido.getId());
        System.out.println("Listando cliente...");
        assertEquals("UPDATED", clienteAtualizado.getNome());
        
        
		clienteDao = new ClienteDao();
		Cliente clienteExcluido = clientes.get(0);
		
		System.out.println("Excluindo Cliente...");
		clienteDao.excluir(clienteExcluido.getId());
		
		clienteDao = new ClienteDao();
		assertEquals(null, clienteDao.listarUm(clienteExcluido.getId()));
		
		
		clienteDao = new ClienteDao();
	    // Tenta excluir um cliente com um ID que provavelmente não existe
	    int idInexistente = 9999;
	    System.out.println("Tentando excluir um cliente com id inexistente...");
	    clienteDao.excluir(idInexistente);
	    
	    // Verifica se nenhum cliente com esse ID existe
	    clienteDao = new ClienteDao();
	    Cliente clienteEncontrado = clienteDao.listarUm(idInexistente);
	    assertNull(clienteEncontrado);
		
    }

}
