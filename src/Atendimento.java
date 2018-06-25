public class Atendimento {
	Cliente 		cliente;
	ListaAssuntos	assuntos;
	int 			horaChegada;
	int				horaAtendimento;
	int				duracaoAtendimento;
	float			urgencia;
	Atendimento		proximo;
		
	public Atendimento(Cliente cliente, ListaAssuntos assuntos, int horaChegada, int horaAtendimento) {
		this.cliente 				= cliente;
		this.assuntos 				= assuntos;
		this.horaChegada 			= horaChegada;
		this.horaAtendimento		= horaAtendimento;
		this.duracaoAtendimento 	= 0;
		this.urgencia 				= 0;
		this.proximo				= null;
	}
}