package tn.esprit.spring;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceTest {
	
	@Autowired
	ContratServiceImpl ser ; 
	
	
	@Test
	@Order(1)
	public void testAddContrat() throws ParseException {
		
		
		//Date date = new SimpleDateFormat("yyyy-mm-dd").parse("2021-10-31");
	
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		Contrat contrat = new Contrat(sqlDate ,"test",12);
		Contrat Contratadded = ser.addContrat(contrat);
		Assert.assertEquals(contrat.getTypeContrat(), Contratadded.getTypeContrat());
	}
	
	@Test
	@Order(3)
	public void testRetrieveAllContrat() {
		List<Contrat> listcontrats = ser.getAllContrats();
		// if there are 4 users in DB : 
		Assert.assertEquals(listcontrats.size(), listcontrats.size());
	}
	
	@Test
	@Order(2)
	public void testModifyContrat() throws ParseException   {
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		Contrat con = new Contrat(2,sqlDate ,"test",15);
		Contrat contratModified = ser.updateContrat(con);
		Assert.assertEquals(con.getTypeContrat(), contratModified.getTypeContrat());
	}
	
	@Test
	@AfterAll
	public void testDeleteContrat() {
		ser.remove("1");
		Assert.assertNull(ser.retrieveContrat("1"));
		
		
	}

}