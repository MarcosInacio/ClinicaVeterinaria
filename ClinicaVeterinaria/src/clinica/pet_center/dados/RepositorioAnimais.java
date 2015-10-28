package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Animal;

public class RepositorioAnimais {

	private static RepositorioAnimais repositorioAnimais;
	private ArrayList<Animal> animais;
	
	private RepositorioAnimais() {
		animais = new ArrayList<Animal>();
	}
	
	public static RepositorioAnimais getInstancia() {
		if(repositorioAnimais == null)
			repositorioAnimais = new RepositorioAnimais();
		return repositorioAnimais;
	}
	
	public boolean insere(Animal animal) {
		boolean r = false;
		if(!jaExiste(animal)) {
			animais.add(animal);
			r = true;
		}
		return r;
	}
	
	public Animal busca(String id) {
		Animal r = null;
		for(Animal a: animais){
			if(a.getId().equals(id)) {
				r = a;
				break;
			}
		}
		return r;
	}
	
	public ArrayList<Animal> lista() {
		return animais;
	}
	
	public boolean remove(String id) {
		boolean r = false;
		
		for(int i=0; i<animais.size(); i++){
			if(animais.get(i).getId().equals(id)){
				animais.remove(i);
				r = true;
				break;
			}
		}
		return r;	
	}
	
	public boolean atualiza(Animal novo, String idVelho) {
		boolean r = false;
		if(remove(idVelho) && insere(novo))
			r = true;
		return r;
	}
	
	private boolean jaExiste(Animal animal) {
		boolean r = false;
		for(Animal a : animais) {
			if(a.equals(animal)) {
				r = true;
				break;
			}
		}
		return r;
	}
	
	//crud
	//create, read, update, delete
}
