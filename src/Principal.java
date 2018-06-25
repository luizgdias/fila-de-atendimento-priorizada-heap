public class Principal {

	public static void main(String[] args) {
		TipoAssunto a = new TipoAssunto("a", "pessoa física", 2); 
		TipoAssunto b = new TipoAssunto("b", "pessoa jurídica", 5);
		TipoAssunto c = new TipoAssunto("c", "não correntista", 10);
		
		Assunto saquePf = new Assunto();
		saquePf.setTipoAssunto(a);
		saquePf.setDescricao("saque pf	");
		saquePf.setDuracaoAtendimentoAssunto(40);
		saquePf.setProvidencia("sacar");
		saquePf.setProximoAssunto(null);
		
		Assunto depositoPj = new Assunto();
		depositoPj.setTipoAssunto(b);
		depositoPj.setDescricao("deposito pj");
		depositoPj.setDuracaoAtendimentoAssunto(30);
		depositoPj.setProvidencia("depositar");
		depositoPj.setProximoAssunto(null);
		
		Assunto pagamento = new Assunto();
		pagamento.setTipoAssunto(c);
		pagamento.setDescricao("pagamento nc");
		pagamento.setDuracaoAtendimentoAssunto(20);
		pagamento.setProvidencia("pagar");
		pagamento.setProximoAssunto(null);
		
		ListaAssuntos listaPadrao = new ListaAssuntos();
		listaPadrao.insere(listaPadrao, pagamento);
		listaPadrao.insere(listaPadrao, saquePf);
		listaPadrao.insere(listaPadrao, depositoPj);
		
		
		/*************************************************************************************
		 * Criando clientes(cpf, nome) e suas respectivas listas de assunto
		 *************************************************************************************/
		Cliente LuizC 		= new Cliente(1011, "Luic C	", 49);
		ListaAssuntos assuntosLuizC = new ListaAssuntos();
		assuntosLuizC.insere(assuntosLuizC, saquePf);
		assuntosLuizC.insere(assuntosLuizC, depositoPj);
		assuntosLuizC.insere(assuntosLuizC, pagamento);
		
		Cliente Carlos 		= new Cliente(101, "Carlos	", 25);
		ListaAssuntos assuntosCarlos = new ListaAssuntos();
		assuntosCarlos.insere(assuntosCarlos, saquePf);
		assuntosCarlos.insere(assuntosCarlos, depositoPj);
		
		Cliente Kelli 		= new Cliente(101, "Kelli	",40);
		ListaAssuntos assuntosKelli = new ListaAssuntos();
		assuntosKelli.insere(assuntosKelli, saquePf);
		
		FilaAtendimentoPrioridade fila = new FilaAtendimentoPrioridade(100);
		fila.recepcionar(LuizC, assuntosLuizC, listaPadrao, 11, 12);
		fila.recepcionar(Carlos, assuntosCarlos, listaPadrao, 12, 13);
		fila.recepcionar(Kelli, assuntosKelli, listaPadrao, 13, 14);
		
		
		
		fila.atender();
		fila.gerarEstatistica(listaPadrao);
		//listaPadrao.imprimeListaAssuntos();
		fila.encerrarAtendimento(listaPadrao);
		fila.encerrarAtendimento(listaPadrao);
		fila.gerarEstatistica(listaPadrao);
		c.alterarPrioridadeTipoAssunto(9); //altera a prioridade do tipo de assunto 
		fila.encerrarAtendimento(listaPadrao);
		fila.gerarEstatistica(listaPadrao);
		Backup.mostraHistorico();
		//listaPadrao.imprimeListaAssuntos();
		//assuntosLuizC.imprimeListaAssuntos();
		//assuntosKelli.imprimeListaAssuntos();

	}

}
