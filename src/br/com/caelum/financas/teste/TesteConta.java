package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta conta = new Conta();
		//conta.setId(1);
		conta.setTitular("Robson");
		conta.setAgencia("1526");
		conta.setBanco("Bradesco");
		conta.setNumero("03384");		
	
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		//conta = em.find(Conta.class, 1);
		em.persist(conta);
		//conta.setBanco("Bradesco");
		em.getTransaction().commit();
		em.close();
		
	
	}
	

}
