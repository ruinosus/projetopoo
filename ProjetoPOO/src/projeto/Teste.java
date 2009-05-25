package projeto;

import projeto.contrato.Contrato;
import projeto.excecao.ExcecaoNegocio;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Fachada f = Fachada.obterInstancia();
		
		Contrato c = new Contrato(1,"Eu sou o responsável",300);
		
		
		try {
			f.inserirContrato(c);
		} catch (ExcecaoNegocio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
