// =======================================================================================
package modelo;

// =======================================================================================
/**
 * As instancias dessa classe representam os nomes dos tipos de dores diponiveis
 * para o usuario escolher ao cadastrar um novo episodio de enxaqueca
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 * 
 */
public class NomeTipoDor implements NomeCaracteristica {
	// ===================================================================================
	private String nomeTipoDor; // nome de um tipo de dor que pode ocorrer

	// ===================================================================================
	/**
	 * Construtor
	 * 
	 */
	public NomeTipoDor() {
		super();
	}

	// ===================================================================================
	/**
	 * Instancia um novo nome de tipo de dor para a lista de escolhas do usuario.
	 * 
	 * @param nomeTipoDor representa um novo nome de tipo de dor a ser instanciado.
	 * 
	 */
	public NomeTipoDor(String nomeTipoDor) {
		this.nomeTipoDor = nomeTipoDor;
	}

	// ===================================================================================
	/**
	 * Sobrescreve o metodo toString() da classe Object. Constroi uma String
	 * contendo o valor de todas as variaveis da classe NomeTipoDor.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "NomeTipoDor [nomeTipoDor=" + nomeTipoDor + "]";
	}

	// ===================================================================================
	public String getNomeTipoDor() {
		// usado por BancoDeDadosEpsiodio
		return nomeTipoDor;
	}

	public void setNomeTipoDor(String nomeTipoDor) {
		this.nomeTipoDor = nomeTipoDor;
	}

	// ===================================================================================
	/**
	 * Insere nova instancia de nome de tipo de dor no banco de dados
	 * 
	 * @return indNomeCaracteristica indice do novo nome de tipo de dor inserido
	 * 
	 * @param nomeCaracteristica nome do tipo de dor que sera inserido
	 * 
	 */
	@Override
	public int inserirNomeCaracteristica(String nomeCaracteristica) {
		// usado por ControleCadastroNomeCaracteristica
		// usado por ControleCadastroEpisodio
		int indNomeCaracteristica = BancoDeDadosEpisodio.getQtdBDNomeTipoDor();
		BancoDeDadosEpisodio.setBdNomeTipoDor(new NomeTipoDor(nomeCaracteristica),
				indNomeCaracteristica);
		BancoDeDadosEpisodio.setQtdBDNomeTipoDor(indNomeCaracteristica + 1);
		return indNomeCaracteristica;
	}

	// ===================================================================================
	/**
	 * Edita instancia existente de nome do tipo de dor no banco de dados
	 * 
	 * @return nomeTipoDor nome do tipo de dor editado
	 * 
	 * @param indiceNomeTipoDor indice do nome do tipo de dor que sera editado
	 * @param strNomeTipoDor    novo nome do tipo de dor que sera editado
	 * 
	 */
	public static NomeTipoDor editarNomeTipoDor(int indiceNomeTipoDor,
			String strNomeTipoDor) {
		// usado por ControleCadastroNomeCaracteristica
		BancoDeDadosEpisodio.getBdNomeTipoDor(indiceNomeTipoDor)
				.setNomeTipoDor(strNomeTipoDor);
		return BancoDeDadosEpisodio.getBdNomeTipoDor(indiceNomeTipoDor);
	}

	// ===================================================================================
	/**
	 * Exclui instancia existente de nome de tipo de dor no banco de dados
	 * 
	 * @return boolean retorna verdadeiro se a instancia que foi excluida era a
	 *         ultima
	 * 
	 * @param indiceNomeCaracteristica indice do nome do tipo de dor que sera
	 *                                 excluido
	 * 
	 */
	@Override
	public boolean excluirNomeCaracteristica(int indiceNomeCaracteristica) {
		// usado por ControleCadastroNomeCaracteristica
		int qtdNomeCaracteristica = BancoDeDadosEpisodio.getQtdBDNomeTipoDor();
		NomeTipoDor[] bdNomeTipoDor = BancoDeDadosEpisodio.getBdNomeTipoDor();
		// o nome nao esta no final do array
		boolean boolean_ultimo = false;
		if (indiceNomeCaracteristica != (qtdNomeCaracteristica - 1)) {
			// apos remover tem q deslocar o array todo
			for (int j = indiceNomeCaracteristica; j < qtdNomeCaracteristica - 1; j++) {
				bdNomeTipoDor[j] = bdNomeTipoDor[j + 1];
			}
		} else
			boolean_ultimo = true;
		BancoDeDadosEpisodio.setBdNomeTipoDor(null, qtdNomeCaracteristica - 1);
		BancoDeDadosEpisodio.setQtdBDNomeTipoDor(qtdNomeCaracteristica - 1);
		return boolean_ultimo;
	}

	// ===================================================================================
	/**
	 * Metodo para obter um array, com todos os nomes de tipos de dor instanciados
	 * do banco de dados.
	 * 
	 * @return strNomeNomeCaracteristica retorna um array com tipos de dor
	 */
	@Override
	public String[] gerarArrayNomeCaracteristica() {
		// usado por ControleCadastroNomeCaracteristica
		String[] strNomeNomeCaracteristica = new String[50];
		for (int i = 0; i < BancoDeDadosEpisodio.getQtdBDNomeTipoDor(); i++) {
			strNomeNomeCaracteristica[i] = BancoDeDadosEpisodio.getBdNomeTipoDor(i)
					.getNomeTipoDor();
		}
		return strNomeNomeCaracteristica;
	}

	// ===================================================================================
	/**
	 * Metodo para obter o indice do tipo de dor do array do banco de dados
	 * 
	 * @return indice retorna o indice no qual se encontra o nome do tipo de dor
	 * 
	 * @param strNomeTipoDor nome do tipo de dor procurado
	 * 
	 */
	public static int buscarIndiceNomeTipoDor(NomeTipoDor strNomeTipoDor) {
		// usado por ControleCadastroNomeCaracteristica
		int indice = -1;
		for (int i = 0; i < BancoDeDadosEpisodio.getQtdBDNomeTipoDor(); i++) {
			if (BancoDeDadosEpisodio.getBdNomeTipoDor(i) == strNomeTipoDor) {
				indice = i;
				i = BancoDeDadosEpisodio.getQtdBDNomeTipoDor();
			}
		}
		return indice;
	}

	// ===================================================================================
}
// Fim da classe NomeTipoDor
// =======================================================================================