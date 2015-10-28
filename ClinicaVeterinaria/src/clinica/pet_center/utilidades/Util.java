package clinica.pet_center.utilidades;

public class Util {
	
	public static final double SALARIO_BASE_OP = 1250.00;
	public static final double SALARIO_BASE_VETERINARIO = 2500.00;
	public static final int HORAS = 40;
	
	private static final String LOGIN = "ADMIN";
	private static final String SENHA = "123";
	
	public static boolean isADM(String login, String senha) {
		boolean r = false;
		r = login.equals(LOGIN) && senha.equals(SENHA);
		return r;
	}
	
}
