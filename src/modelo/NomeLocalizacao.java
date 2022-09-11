// =======================================================================================
package modelo;

//=======================================================================================
/**
 * As instancias dessa classe representam os nomes dos locais da dor que estao
 * diponiveis para o usuario escolher ao cadastrar um novo episodio de enxaqueca
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 * 
 */
public class NomeLocalizacao implements NomeCaracteristica {
	// ===================================================================================
	private String nomeLocal; // nome de uma localizacao da dor que pode ocorrer

	// ===================================================================================
	/**
	 * Construtor
	 * 
	 */
	public NomeLocalizacao() {
		super();
	}

	// ===================================================================================
	/**
	 * Instancia um novo nome de local da dor para a lista de escolhas do usuario
	 * 
	 * @param nomeLocal representa um novo nome de local da dor a ser instanciado
	 * 
	 */
	public NomeLocalizacao(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}

	// ===================================================================================
	/**
	 * Sobrescreve o metodo toString() da classe Object. Constroi uma String
	 * contendo o valor de todas as variaveis da classe NomeLocal.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "NomeLocalizacao [nomeLocal=" + nomeLocal + "]";
	}

	// ===================================================================================
	public String getNomeLocal() {
		// usado por BancoDeDadosEpsiodio
		return nomeLocal;
	}

	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}

	// ===================================================================================
	/**
	 * Insere nova instancia de nome de local no banco de dados
	 * 
	 * @return indNomeCaracteristica indice do novo nome de local inserido
	 *
	 * @param nomeCaracteristica nome do local que sera inserido
	 * 
	 */
	@Override
	public int inserirNomeCaracteristica(String nomeCaracteristica) {
		// usado por ControleCadastroNomeCaracteristica
		// usado por ControleCadastroEpisodio
		int indNomeCaracteristica = BancoDeDadosEpisodio.getQtdBDNomeLocal();
		BancoDeDadosEpisodio.setBdNomeLocal(new NomeLocalizacao(nomeCaracteristica),
				indNomeCaracteristica);
		BancoDeDadosEpisodio.setQtdBDNomeLocal(indNomeCaracteristica + 1);
		return indNomeCaracteristica;
	}

	// ===================================================================================
	/**
	 * Edita instancia existente de nome do local no banco de dados
	 * 
	 * @return nomeLocal[] - NomeLocal nome do local editado
	 * 
	 * @param indiceNomeLocal indice do nome do local que sera editado
	 * @param strNomeLocal    novo nome do local que sera editado
	 * 
	 */
	public static NomeLocalizacao editarNomeLocal(int indiceNomeLocal,
			String strNomeLocal) {
		// usado por ControleCadastroNomeCaracteristica
		BancoDeDadosEpisodio.getBdNomeLocal(indiceNomeLocal).setNomeLocal(strNomeLocal);
		return BancoDeDadosEpisodio.getBdNomeLocal(indiceNomeLocal);
	}

	// ===================================================================================
	/**
	 * Exclui instancia existente de nome do local no banco de dados
	 * 
	 * @return boolean retorna verdadeiro se a instancia que foi excluida era a
	 *         ultima
	 * 
	 * @param indiceNomeCaracteristica indice do nome do local que sera excluido
	 * 
	 */
	@Override
	public boolean excluirNomeCaracteristica(int indiceNomeCaracteristica) {
		// usado por ControleCadastroNomeCaracteristica
		int qtdNomeCaracteristica = BancoDeDadosEpisodio.getQtdBDNomeLocal();
		NomeLocalizacao[] bdNomeLocal = BancoDeDadosEpisodio.getBdNomeLocal();
		// o nome nao esta no final do array
		boolean boolean_ultimo = false;
		if (indiceNomeCaracteristica != (qtdNomeCaracteristica - 1)) {
			// apos remover tem q deslocar o array todo
			for (int j = indiceNomeCaracteristica; j < qtdNomeCaracteristica - 1; j++) {
				bdNomeLocal[j] = bdNomeLocal[j + 1];
			}
		} else
			boolean_ultimo = true;
		BancoDeDadosEpisodio.setBdNomeLocal(null, qtdNomeCaracteristica - 1);
		BancoDeDadosEpisodio.setQtdBDNomeLocal(qtdNomeCaracteristica - 1);
		return boolean_ultimo;
	}

	// ===================================================================================
	/**
	 * Metodo para obter um array, com todos os nomes de locais instanciados do
	 * banco de dados.
	 * 
	 * @return strNomeNomeCaracteristica retorna um array com locais
	 */
	@Override
	public String[] gerarArrayNomeCaracteristica() {
		// usado por ControleCadastroNomeCaracteristica
		String[] strNomeNomeCaracteristica = new String[50];
		for (int i = 0; i < BancoDeDadosEpisodio.getQtdBDNomeLocal(); i++) {
			strNomeNomeCaracteristica[i] = BancoDeDadosEpisodio.getBdNomeLocal(i)
					.getNomeLocal();
		}
		return strNomeNomeCaracteristica;
	}

	// ===================================================================================
	/**
	 * Metodo para obter o indice do local do array do banco de dados
	 * 
	 * @return indice retorna o indice no qual se encontra o nome do local
	 * 
	 * @param strNomeLocal nome do local procurado
	 * 
	 */
	public static int buscarIndiceNomeLocal(NomeLocalizacao strNomeLocal) {
		// usado por ControleCadastroNomeCaracteristica
		int indice = -1;
		for (int i = 0; i < BancoDeDadosEpisodio.getQtdBDNomeLocal(); i++) {
			if (BancoDeDadosEpisodio.getBdNomeLocal(i) == strNomeLocal) {
				indice = i;
				i = BancoDeDadosEpisodio.getQtdBDNomeLocal();
			}
		}
		return indice;
	}

	// ===================================================================================
}
// Fim da classe NomeLocalizacao
// =======================================================================================