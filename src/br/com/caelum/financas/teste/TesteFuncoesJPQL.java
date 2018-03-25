package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				EntityManager em = new JPAUtil().getEntityManager();
				em.getTransaction().begin();

				Conta conta = new Conta();
				conta.setId(2);

				String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta "
						+ "and m.tipo = :pTipo"
						+ " order by m.valor desc";
				
				String jpql2 = "select sum(m.valor) from Movimentacao m where m.conta = :pConta "
						+ "and m.tipo = :pTipo"
						+ " order by m.valor desc";

				Query query = em.createQuery(jpql);
				query.setParameter("pConta", conta);
				query.setParameter("pTipo", TipoMovimentacao.ENTRADA);

				BigDecimal soma = (BigDecimal) query.getSingleResult();
				System.out.println("A soma é: " + soma);
				
				em.getTransaction().commit();
				
				
				em.close();
		
	}

}
