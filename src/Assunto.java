public class Assunto {
	TipoAssunto 	tipoAssunto;
	String 			descricao;
	String 			providencia;
	int 			duracaoAtendimentoAssunto;
	Assunto			proximoAssunto;
	int				cont;

public void setTipoAssunto(TipoAssunto tipoAssunto){
		this.tipoAssunto = tipoAssunto;
	}
	
	public TipoAssunto getTipoAssunto() {
		return this.tipoAssunto;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setProvidencia(String providencia) {
		this.providencia = providencia;
	}
	
	public String getProvidencia() {
		return this.providencia;
	}
	
	public void setDuracaoAtendimentoAssunto(int duracaoAtendimentoAssunto) {
		this.duracaoAtendimentoAssunto = duracaoAtendimentoAssunto;
	}
	
	public int getDuracaoAtendimentoAssunto() {
		return this.duracaoAtendimentoAssunto;
	}
	
	public void setProximoAssunto(Assunto proximoAssunto) {
		this.proximoAssunto = proximoAssunto;
	}
	
	public Assunto getProximoAssunto() {
		return this.proximoAssunto;
	}
	
	public void setCont(int cont) {
		this.cont = cont;
	}
	
	public int getCont() {
		return this.cont;
	}
}
