package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta conta = new Conta();
		conta.setId(1);
		conta.setTitular("Danilo");
		conta.setAgencia("1533");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("03378");		
	
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		conta = em.find(Conta.class, 1);
		em.remove(conta);
		conta.setBanco("Bradesco");
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		em2.merge(conta);
		conta.setTitular("Danilo Nobrega");
		
		em2.getTransaction().commit();
		em2.close();
	}
	

}
