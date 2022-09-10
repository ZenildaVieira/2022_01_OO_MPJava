// =======================================================================================
package modelo;

// =======================================================================================
/**
 * As instancias dessa classe representam os nomes dos gatilhos diponiveis para
 * o usuario escolher ao cadastrar um novo episodio de enxaqueca
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 * 
 */
public class NomeGatilho implements NomeCaracteristica {
	// ===================================================================================
	private String nomeGatilho; // nome de um tipo de gatilho que pode ocorrer

	// ===================================================================================
	/**
	 * Construtor
	 * 
	 */
	public NomeGatilho() {
		super();
	}

	// ===================================================================================
	/**
	 * Instancia um novo nome de gatilho para a lista de escolhas do usuario.
	 * 
	 * @param nomeGatilho representa um novo nome de gatilho a ser instanciado.
	 * 
	 */
	public NomeGatilho(String nomeGatilho) {
		this.nomeGatilho = nomeGatilho;
	}

	// ===================================================================================
	/**
	 * Sobrescreve o metodo toString() da classe Object. Constroi uma String
	 * contendo o valor de todas as variaveis da classe NomeGatilho.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "NomeGatilho [nomeGatilho=" + nomeGatilho + "]";
	}

	// ===================================================================================
	public String getNomeGatilho() {
		// usado por BancoDeDadosEpsiodio
		return nomeGatilho;
	}

	public void setNomeGatilho(String nomeGatilho) {
		this.nomeGatilho = nomeGatilho;
	}

	// ===================================================================================
	/**
	 * Insere nova instancia de nome de gatilho no banco de dados
	 * 
	 * @return indNomeCaracteristica indice do novo nome de gatilho inserido
	 * 
	 * @param nomeCaracteristica nome do gatilho que sera inserido
	 * 
	 */
	@Override
	public int inserirNomeCaracteristica(String nomeCaracteristica) {
		// usado por ControleCadastroNomeCaracteristica
		// usado por ControleCadastroEpisodio
		int indNomeCaracteristica = BancoDeDadosEpisodio.getQtdBDNomeGatilho();
		BancoDeDadosEpisodio.setBdNomeGatilho(new NomeGatilho(nomeCaracteristica),
				indNomeCaracteristica);
		BancoDeDadosEpisodio.setQtdBDNomeGatilho(indNomeCaracteristica + 1);
		return indNomeCaracteristica;
	}

	// ===================================================================================
	/**
	 * Edita instancia existente de nome de gatilho no banco de dados
	 * 
	 * @return nomeTipoDor nome de gatilho editado
	 * 
	 * @param indiceNomeGatilho indice do nome do gatilho que sera editado
	 * @param strNomeGatilho    novo nome do gatilho que sera editado
	 * 
	 */
	public static NomeGatilho editarNomeGatilho(int indiceNomeGatilho,
			String strNomeGatilho) {
		// usado por ControleCadastroNomeCaracteristica
		BancoDeDadosEpisodio.getBdNomeGatilho(indiceNomeGatilho)
				.setNomeGatilho(strNomeGatilho);
		return BancoDeDadosEpisodio.getBdNomeGatilho(indiceNomeGatilho);
	}

	// ===================================================================================
	/**
	 * Exclui instancia existente de nome de gatilho no banco de dados
	 * 
	 * @return boolean retorna verdadeiro se a instancia que foi excluida era a
	 *         ultima
	 * 
	 * @param indiceNomeCaracteristica indice do nome do gatilho que sera excluido
	 * 
	 */
	@Override
	public boolean excluirNomeCaracteristica(int indiceNomeCaracteristica) {
		// usado por ControleCadastroNomeCaracteristica
		int qtdNomeCaracteristica = BancoDeDadosEpisodio.getQtdBDNomeGatilho();
		NomeGatilho[] bdNomeCaracteristica = BancoDeDadosEpisodio.getBdNomeGatilho();
		// o nome nao esta no final do array
		boolean boolean_ultimo = false;
		if (indiceNomeCaracteristica != (qtdNomeCaracteristica - 1)) {
			// apos remover tem q deslocar o array todo
			for (int j = indiceNomeCaracteristica; j < qtdNomeCaracteristica - 1; j++) {
				bdNomeCaracteristica[j] = bdNomeCaracteristica[j + 1];
			}
		} else
			boolean_ultimo = true;
		BancoDeDadosEpisodio.setBdNomeGatilho(null, qtdNomeCaracteristica - 1);
		BancoDeDadosEpisodio.setQtdBDNomeGatilho(qtdNomeCaracteristica - 1);
		return boolean_ultimo;
	}

	// ===================================================================================
	/**
	 * Metodo para obter um array, com todos os nomes de gatilhos instanciados do
	 * banco de dados.
	 * 
	 * @return strNomeNomeCaracteristica retorna um array com gatilhos
	 */
	@Override
	public String[] gerarArrayNomeCaracteristica() {
		// usado por ControleCadastroNomeCaracteristica
		String[] strNomeNomeCaracteristica = new String[50];
		for (int i = 0; i < BancoDeDadosEpisodio.getQtdBDNomeGatilho(); i++) {
			strNomeNomeCaracteristica[i] = BancoDeDadosEpisodio.getBdNomeGatilho(i)
					.getNomeGatilho();
		}
		return strNomeNomeCaracteristica;
	}

	// ===================================================================================
	/**
	 * Metodo para obter o indice do gatilho do array do banco de dados
	 * 
	 * @return indice retorna o indice no qual se encontra o nome do gatilho
	 * 
	 * @param strNomeGatilho nome do gatilho procurado
	 * 
	 */
	public static int buscarIndiceNomeGatilho(NomeGatilho strNomeGatilho) {
		// usado por ControleCadastroNomeCaracteristica
		int indice = -1;
		for (int i = 0; i < BancoDeDadosEpisodio.getQtdBDNomeGatilho(); i++) {
			if (BancoDeDadosEpisodio.getBdNomeGatilho(i) == strNomeGatilho) {
				indice = i;
				i = BancoDeDadosEpisodio.getQtdBDNomeGatilho();
			}
		}
		return indice;
	}

	// ===================================================================================
}
// Fim da classe NomeGatilho
// =======================================================================================