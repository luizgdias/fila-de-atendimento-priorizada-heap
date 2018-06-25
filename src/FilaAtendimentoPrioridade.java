import java.util.PrimitiveIterator;

public class FilaAtendimentoPrioridade {
	Atendimento[] atendimentos;
	int tamanhoFila;
	
	public FilaAtendimentoPrioridade(int tamanhoFila) {
		this.atendimentos = new Atendimento[tamanhoFila];
		this.tamanhoFila = -1;
	}

	public void recepcionar(Cliente cliente, ListaAssuntos assuntosCliente, ListaAssuntos AssuntosPadrao, int horaChegada, int horaAtendimento) {
		Atendimento novo = new Atendimento(cliente, assuntosCliente, horaChegada, horaAtendimento);
		System.out.println("\nComando: ***Recepcionar Cliente***\n");
		if (tamanhoFila == atendimentos.length-1) {
			System.out.println("A fila de clientes est� cheia!");
		}else {
			tamanhoFila++;
			novo.urgencia = calculaPriridade(novo);
			atendimentos[tamanhoFila] = novo;
			imprimeAtendimentos(atendimentos[tamanhoFila]);
		}
	}

	private float calculaPriridade(Atendimento novo) {
		float prioridade = 0, prioridadeAssuntos = 0;
		for (int i = 0; i < novo.assuntos.qtdAssuntos; i++) {
			prioridadeAssuntos = prioridadeAssuntos+novo.assuntos.primeiroAssunto.tipoAssunto.urgencia;
			novo.assuntos.primeiroAssunto = novo.assuntos.primeiroAssunto.proximoAssunto;
		}
		
		prioridade = (novo.cliente.idade/65)+((prioridadeAssuntos)/novo.assuntos.qtdAssuntos)/10;
		return prioridade;
	}

	private void imprimeAtendimentos(Atendimento atendimento) {
		if (tamanhoFila < 0) {
			System.out.println("N�o existem atendimentos!");
		}else {
			for (int i = 0; i <= tamanhoFila; i++) {
				System.out.println("Cliente: "+atendimentos[i].cliente.nome+ " Urg. Atendimento: "+atendimentos[i].urgencia);
			}
		}
	}

	public void atender() {
		System.out.println("\nComando: ***Atender Cliente***");
		System.out.println("\n***Lista em ordem de atendimento***");
		
		for (int i = tamanhoFila; i >= 0; i--) {
			descer(i);
		}
		imprimeAtendimentos(atendimentos[tamanhoFila]);
		
	}

	private void descer(int i) {
		int filho = 2*i+1;
		if (filho <= tamanhoFila ) {
			if (filho <= tamanhoFila - 1) {
				
				if (atendimentos[i].urgencia > atendimentos[filho].urgencia) {
					filho = filho + 1;
				}
				
				if (atendimentos[i].urgencia < atendimentos[filho].urgencia) {
					//System.out.println("i: "+atendimentos[i].urgencia+"� menor que "+"filho: "+ atendimentos[filho].urgencia);
					Atendimento aux = atendimentos[i];
					atendimentos[i] = atendimentos[filho];
					atendimentos[filho] = aux;
					descer(filho);
					
				}
			}
			
		}
	}

	public void encerrarAtendimento(ListaAssuntos listaPadrao) {
			System.out.println("\nComando: ***Encerrar Atendimento***");
			if (tamanhoFila < 0) {
				System.out.println("Todos os clientes j� foram atendidos!");
			}else {
				incrementaEstatistica(atendimentos[0], listaPadrao);
				//Atendimento backup = atendimentos[0];
				//Backup.insereBackup(backup);
				atendimentos[0] = null;
				
				for(int x = 0; x < tamanhoFila; x++) {
					atendimentos[x] = atendimentos[x+1];
				}
				atendimentos[tamanhoFila] = null;
				--tamanhoFila;
				
			}	
	}

	private void incrementaEstatistica(Atendimento atendimento, ListaAssuntos listaPadrao) {
		System.out.println("Cliente atendido:  "+atendimento.cliente.nome);
		for (int i = 0; i < atendimento.assuntos.qtdAssuntos; i++) {
			System.out.println("Demandas atendidas: "+atendimento.assuntos.primeiroAssunto.descricao);
			
			for (int j = 0; j < listaPadrao.qtdAssuntos; j++) {
				if (atendimento.assuntos.primeiroAssunto.descricao == listaPadrao.primeiroAssunto.descricao) {
					listaPadrao.primeiroAssunto.cont++;
					//System.out.println("assuntos padrao: "+ listaPadrao.primeiroAssunto.descricao+"*");
				}
				
				//System.out.println("assuntos padrao: "+ listaPadrao.primeiroAssunto.descricao);
				listaPadrao.primeiroAssunto = listaPadrao.primeiroAssunto.proximoAssunto;
				
			}
			atendimento.assuntos.primeiroAssunto = atendimento.assuntos.primeiroAssunto.proximoAssunto;
			
		}
		
	}

	public void gerarEstatistica(ListaAssuntos listaPadrao) {
		if (listaPadrao.qtdAssuntos == 0) {
			System.out.println("N�o existem assuntos cadastrados!");
		}else {
			System.out.println("\ncomando: ***Gerar Estat�stica*** "+listaPadrao.qtdAssuntos);
			
			for (int i = 0; i < listaPadrao.qtdAssuntos; i++) {
	
				//tempoMedio = ((listaPadrao.primeiroAssunto.duracaoAtendimentoAssunto)/listaPadrao.primeiroAssunto.cont);
				System.out.println("Atendimento: "+listaPadrao.primeiroAssunto.descricao+ "		| Urg�ncia: "+ listaPadrao.primeiroAssunto.tipoAssunto.urgencia +
						"	| Qtd atendimentos realizados: "+listaPadrao.primeiroAssunto.cont+ "	| Tempo M�dio: "+ listaPadrao.primeiroAssunto.duracaoAtendimentoAssunto);
				listaPadrao.primeiroAssunto = listaPadrao.primeiroAssunto.proximoAssunto;
			}
		}
		
	}
}
