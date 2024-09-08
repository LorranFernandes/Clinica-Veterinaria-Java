package br.cefet.clinicaveterinaria.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import org.junit.jupiter.api.Test;

import br.cefet.clinicaveterinaria.dao.ConsultaDao;
import br.cefet.clinicaveterinaria.model.Animal;
import br.cefet.clinicaveterinaria.model.Consulta;
import br.cefet.clinicaveterinaria.model.Veterinario;

class ConsultaTest {

	private ConsultaDao consultaDao;
	
	@Test
	void test() throws SQLException {
		
		// Inserir consultas para agosto de 2024
		consultaDao = new ConsultaDao();
		Consulta consulta1 = new Consulta();
        consulta1.setData(Date.valueOf("2031-08-10"));
        consulta1.setHora(Time.valueOf("10:00:00"));
        consulta1.setValor(150.0f);
        consulta1.setAnimal(new Animal(49)); // animal com ID 49
        consulta1.setVeterinario(new Veterinario(897)); // veterinário com ID 897
        consultaDao.adicionar(consulta1);

        consultaDao = new ConsultaDao();
        Consulta consulta2 = new Consulta();
        consulta2.setData(Date.valueOf("2031-08-15"));
        consulta2.setHora(Time.valueOf("11:00:00"));
        consulta2.setValor(200.0f);
        consulta2.setAnimal(new Animal(48));
        consulta2.setVeterinario(new Veterinario(896));
        consultaDao.adicionar(consulta2);
 

        
        
        
        // Testar a função somarValoresPorMes
        consultaDao = new ConsultaDao();
        float totalEsperado = 150.0f + 200.0f;
        float totalCalculado = consultaDao.somarValoresPorMes(8, 2031); // Mês 8 é agosto de 

        // Verificar se o valor calculado é igual ao esperado
        assertEquals(totalEsperado, totalCalculado, 0.001);
    }
	

}
