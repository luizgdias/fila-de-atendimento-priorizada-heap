public class Backup {
	private static int 		qtdAtendimentos;
	private static Atendimento primeiro;
	private static Atendimento ultimo;
	
	public static int getQtdAtendimentos() {
		return qtdAtendimentos;
	}

	public static void setQtdAtendimentos(int qtdAtendimentos) {
		Backup.qtdAtendimentos = qtdAtendimentos;
	}

	public static Atendimento getPrimeiro() {
		return primeiro;
	}

	public static void setPrimeiro(Atendimento primeiro) {
		Backup.primeiro = primeiro;
	}

	public static Atendimento getUltimo() {
		return ultimo;
	}

	public static void setUltimo(Atendimento ultimo) {
		Backup.ultimo = ultimo;
	}
	
	public static void insereBackup(Atendimento backup) {
		if (getQtdAtendimentos() == 0) {
			setPrimeiro(backup);
			setUltimo(backup);
			
		}else {
			getPrimeiro().proximo 	= backup;
			setUltimo(backup);
			
		}
		
		setQtdAtendimentos(getQtdAtendimentos() + 1);	
	}

	public static void mostraHistorico() {
		System.out.println("\ncomando: **Ver Histórico**\nAtendimentos do dia: "+getQtdAtendimentos()+":");
		Atendimento aux = primeiro;
		for (int i = 0; i < qtdAtendimentos; i++) {
			System.out.println("\nCliente:"+ aux.cliente.nome);
			aux = aux.proximo;
		}
		
	}
}
