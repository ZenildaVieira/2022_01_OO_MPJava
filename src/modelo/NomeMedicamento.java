// =======================================================================================
package modelo;

//=======================================================================================
/**
 * As instancias dessa classe representam os nomes dos medicamentos que estao
 * diponiveis para o usuario escolher ao cadastrar um novo episodio de enxaqueca
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 * 
 * 
 */
public class NomeMedicamento implements NomeCaracteristica {
	// ===================================================================================
	private String nomeMedic; // nome de um medicamento que pode ser usado

	// ===================================================================================
	/**
	 * Construtor
	 * 
	 */
	public NomeMedicamento() {
		super();
	}

	// ===================================================================================
	/**
	 * Instancia um novo nome de medicamento para a lista de escolhas do usuario
	 * 
	 * @param nomeMedic representa um novo nome de medicamento a ser instanciado
	 * 
	 */
	public NomeMedicamento(String nomeMedic) {
		this.nomeMedic = nomeMedic;
	}

	// ===================================================================================
	/**
	 * Sobrescreve o metodo toString() da classe Object. Constroi uma String
	 * contendo o valor de todas as variaveis da classe NomeMedicamento.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "NomeMedicamento [nomeMedic=" + nomeMedic + "]";
	}

	// ===================================================================================
	public String getNomeMedic() {
		// usado por BancoDeDadosEpsiodio
		return nomeMedic;
	}

	public void setNomeMedic(String nomeMedic) {
		this.nomeMedic = nomeMedic;
	}

	// ===================================================================================
	/**
	 * Insere nova instancia de nome de medicamento no banco de dados
	 * 
	 * @return indNomeCaracteristica indice do novo nome de medicamento inserido
	 * 
	 * @param nomeCaracteristica nome do medicamento que sera inserido
	 * 
	 */
	@Override
	public int inserirNomeCaracteristica(String nomeCaracteristica) {
		// usado por ControleCadastroNomeCaracteristica
		// usado por ControleCadastroEpisodio
		int indNomeCaracteristica = BancoDeDadosEpisodio.getQtdBDNomeMedic();
		BancoDeDadosEpisodio.setBdNomeMedic(new NomeMedicamento(nomeCaracteristica),
				indNomeCaracteristica);
		BancoDeDadosEpisodio.setQtdBDNomeMedic(indNomeCaracteristica + 1);
		return indNomeCaracteristica;
	}

	// ===================================================================================
	/**
	 * Edita instancia existente do nome de medicamento no banco de dados
	 * 
	 * @return nomeTipoDor nome de medicamento editado
	 * 
	 * @param indiceNomeMedic indice do nome do medicamento que sera editado
	 * @param strNomeMedic    novo nome do medicamento que sera editado
	 * 
	 */
	public static NomeMedicamento editarNomeMedic(int indiceNomeMedic,
			String strNomeMedic) {
		// usado por ControleCadastroNomeCaracteristica
		BancoDeDadosEpisodio.getBdNomeMedic(indiceNomeMedic).setNomeMedic(strNomeMedic);
		return BancoDeDadosEpisodio.getBdNomeMedic(indiceNomeMedic);
	}

	// ===================================================================================
	/**
	 * Exclui instancia existente de nome de medicamento no banco de dados
	 * 
	 * @return boolean retorna verdadeiro se a instancia que foi excluida era a
	 *         ultima
	 * 
	 * @param indiceNomeCaracteristica indice do nome do medicamento que sera
	 *                                 excluido
	 * 
	 */
	@Override
	public boolean excluirNomeCaracteristica(int indiceNomeCaracteristica) {
		// usado por ControleCadastroNomeCaracteristica
		int qtdNomeCaracteristica = BancoDeDadosEpisodio.getQtdBDNomeMedic();
		NomeMedicamento[] bdNomeMedic = BancoDeDadosEpisodio.getBdNomeMedic();
		// o nome nao esta no final do array
		boolean boolean_ultimo = false;
		if (indiceNomeCaracteristica != (qtdNomeCaracteristica - 1)) {
			// apos remover tem q deslocar o array todo
			for (int j = indiceNomeCaracteristica; j < qtdNomeCaracteristica - 1; j++) {
				bdNomeMedic[j] = bdNomeMedic[j + 1];
			}
		} else
			boolean_ultimo = true;
		BancoDeDadosEpisodio.setBdNomeMedic(null, qtdNomeCaracteristica - 1);
		BancoDeDadosEpisodio.setQtdBDNomeMedic(qtdNomeCaracteristica - 1);
		return boolean_ultimo;
	}

	// ===================================================================================
	/**
	 * Metodo para obter um array, com todos os nomes de medicamentos instanciados
	 * do banco de dados.
	 * 
	 * @return strNomeNomeCaracteristica retorna um array com medicamentos
	 */
	@Override
	public String[] gerarArrayNomeCaracteristica() {
		// usado por ControleCadastroNomeCaracteristica
		String[] strNomeNomeCaracteristica = new String[50];
		for (int i = 0; i < BancoDeDadosEpisodio.getQtdBDNomeMedic(); i++) {
			strNomeNomeCaracteristica[i] = BancoDeDadosEpisodio.getBdNomeMedic(i)
					.getNomeMedic();
		}
		return strNomeNomeCaracteristica;
	}

	// ===================================================================================
	/**
	 * Metodo para obter o indice do nome do medicamento do array do banco de dados
	 * 
	 * @return indice retorna o indice no qual se encontra o nome do medicamento
	 * 
	 * @param strNomeMedic nome do medicamento procurado
	 * 
	 */
	public static int buscarIndiceNomeMedic(NomeMedicamento strNomeMedic) {
		// usado por ControleCadastroNomeCaracteristica
		int indice = -1;
		for (int i = 0; i < BancoDeDadosEpisodio.getQtdBDNomeMedic(); i++) {
			if (BancoDeDadosEpisodio.getBdNomeMedic(i) == strNomeMedic) {
				indice = i;
				i = BancoDeDadosEpisodio.getQtdBDNomeMedic();
			}
		}
		return indice;
	}

	// ===================================================================================
}
// Fim da classe NomeMedicamento
// =======================================================================================