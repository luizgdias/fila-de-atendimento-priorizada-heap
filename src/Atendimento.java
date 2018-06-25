public class Atendimento {
	Cliente 		cliente;
	ListaAssuntos	assuntos;
	int 			horaChegada;
	int				duracaoAtendimento;
	float				urgencia;
		
	public Atendimento(Cliente cliente, ListaAssuntos assuntos, int horaChegada) {
		this.cliente 				= cliente;
		this.assuntos 				= assuntos;
		this.horaChegada 			= horaChegada;
		this.duracaoAtendimento 	= 0;
		this.urgencia 				= 0;
	}
}