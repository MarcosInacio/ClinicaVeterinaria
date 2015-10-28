package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;

import clinica.pet_center.dados.RepositorioConsultas;
import clinica.pet_center.negocio.basicas.Consulta;

public class CadastroConsulta {

	private RepositorioConsultas repositorioConsulta;
	
	public CadastroConsulta() {
		repositorioConsulta = RepositorioConsultas.getInstancia();
	}
	
	public boolean cadastraConsulta(Consulta c) {
		boolean r = false;
		if(isConsulta(c))
			r = repositorioConsulta.insere(c);
		return r;
	}
	
	public Consulta buscaConsulta(String idConsulta) {
		Consulta r = null;
		if(checkIdConsulta(idConsulta))
			r = repositorioConsulta.busca(idConsulta);
		return r;
	}
	
	public ArrayList<Consulta> listaConsultas() {
		return repositorioConsulta.lista();
	}
	
	public boolean removeConsulta(String idConsulta) {
		boolean r = false;
		if(checkIdConsulta(idConsulta))
			r = repositorioConsulta.remove(idConsulta);
		return r;
	}
	
	private boolean checkIdConsulta(String idConsulta) {
		boolean r = false;
		if(idConsulta != null && !idConsulta.isEmpty())
			r = idConsulta.startsWith("CONSULTA|");
		return r;
	}
	
	//será uma consulta se todos parametros de consulta forem != null
	private boolean isConsulta(Consulta c) {
		boolean r = false;
		if(c != null)
			r = c.getCliente() != null && c.getAnimal() != null && c.getVeterinario() != null 
				&& c.getDiagnostico() != null && c.getMotivoVisita() != null && c.getReceita() != null
				&& c.getData() != null && c.getIdConsulta() != null;
		return r;
	}
	
//	@Override
//	public String toString(){
//		return String.format("EXISTEM %d CONSULTAS NO SISTEMA",  repositorioConsulta.lista().size());
//	}
}