package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Consulta;

public class RepositorioConsultas {

	private static RepositorioConsultas repositorioConsultas;
	private ArrayList<Consulta> consultas;
	
	private RepositorioConsultas() {
		consultas = new ArrayList<Consulta>();
	}
	
	public static RepositorioConsultas getInstancia() {
		if(repositorioConsultas == null)
			repositorioConsultas = new RepositorioConsultas();
		return repositorioConsultas;
	}
	
	public boolean insere(Consulta c) {
		boolean r = false;
		r = consultas.add(c);
		return r;
	}
	
	public Consulta busca(String idConsulta) {
		Consulta r = null;
		for(Consulta c : consultas) {
			if(c.getIdConsulta().equals(idConsulta)) {
				r = c;
				break;
			}
		}
		return r;
	}
	
	public ArrayList<Consulta> lista() {
		return consultas;
	}
	
	public boolean remove(String idConsulta) {
		boolean r = false;
		for(int i=0; i<consultas.size(); i++) {
			if(consultas.get(i).getIdConsulta().equals(idConsulta)) {
				consultas.remove(i);
				r = true;
				break;
			}
		}
		return r;
	}
}
