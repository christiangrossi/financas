package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public abstract class TesteTodasMovimentacoesDasContas {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
		Query query = em.createQuery(jpql);
		
		List<Conta> todasAsContas = query.getResultList();
		for (Conta conta : todasAsContas) {
			System.out.println(conta.getTitular());
			System.out.println("Moviemntacoes");
			System.out.println(conta.getMovimentacoes());
		}
		
		em.getTransaction().commit();
		em.close();

	}

}
