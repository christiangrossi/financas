package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setNome("Josiano");
		cliente.setEndereco("Rua Beutrano 12");
		cliente.setProfissao("Professor");
		
		Conta conta = new Conta();
		conta.setId(2);
		conta.setTitular(cliente.getNome());
		cliente.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();

	}

}
