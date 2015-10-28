package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;

import clinica.pet_center.dados.RepositorioAnimais;
import clinica.pet_center.negocio.basicas.Animal;

public class CadastroAnimal {
	
	private RepositorioAnimais repositorioAnimal;
	
	public CadastroAnimal() {
		repositorioAnimal = RepositorioAnimais.getInstancia();
	}
	
	public boolean cadastraAnimal(Animal animal) {
		boolean r = false;
		if(animal != null && repositorioAnimal.insere(animal))
			r = true;
		return r;
	}
	
	public Animal buscaAnimalId(String id) {
		Animal r = null;
		if(checkIdAnimal(id))
			r = repositorioAnimal.busca(id);
		return r;
	}
	
	public ArrayList<Animal> listaAnimais() {
		return repositorioAnimal.lista();
	}
	
	public boolean removeAnimal(String id){
		boolean r = false;
		if(checkIdAnimal(id))
			r = repositorioAnimal.remove(id);
		return r;
	}
	
	public boolean alteraAnimal(String id, Animal novo) {
		boolean r = false;
		if(checkIdAnimal(id))
			r = repositorioAnimal.atualiza(novo, id);
		return r;
	}
	
	private boolean checkIdAnimal(String id) {
		boolean r = false;
		if(id != null && !id.equals("") && id.startsWith("ANM"))
			r = true;
		return r;
	}
	
//	@Override
//	public String toString(){
//		return String.format("EXISTEM %d ANIMAIS NO SISTEMA", repositorioAnimal.lista().size());
//	}
}
