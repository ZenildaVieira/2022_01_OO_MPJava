// =======================================================================================
package modelo;

// =======================================================================================
/**
 * As instancias dessa classe representam o nome do medicamento que foi tomado
 * no episodio de enxaqueca cadastrado e se funcionou ou nao
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 * 
 */
public class CaracteristicaMedicamento {
	// ===================================================================================
	// Atributos da classe - 2 no total
	private NomeMedicamento nomeMedic; // nome do medicamento utilizado
	private String eficiencia; // se o medicamento funcionou ou não

	// ===================================================================================
	/**
	 * Construtor
	 * 
	 */
	public CaracteristicaMedicamento() {
		super();
	}

	// ===================================================================================
	/**
	 * Sobrecarga do construtor com todos os atributos como parametros
	 * 
	 * @param nomeMedic  nome do medicamento utilizado
	 * @param eficiencia se o medicamento funcionou ou não
	 *
	 */
	public CaracteristicaMedicamento(NomeMedicamento nomeMedic, String eficiencia) {
		super();
		this.nomeMedic = nomeMedic;
		this.eficiencia = eficiencia;
	}

	// ===================================================================================
	/**
	 * Sobrescrita do metodo toString da classe Object(). Constroi uma String
	 * contendo o valor de todas as variaveis da classe CaracteristicaMedicamento.
	 * 
	 * @return String
	 * 
	 */
	@Override
	public String toString() {
		return "CaracteristicaMedicamento \n[nomeMedic=" + nomeMedic + ",\neficiencia="
				+ eficiencia + "]";
	}

	// ===================================================================================
	public NomeMedicamento getNomeMedic() {
		return nomeMedic;
	}

	public void setNomeMedic(NomeMedicamento nomeMedic) {
		this.nomeMedic = nomeMedic;
	}

	public void setNomeMedic(String nomeMedic) {
		this.nomeMedic.setNomeMedic(nomeMedic);
	}

	// ===================================================================================
	public String getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(String eficiencia) {
		this.eficiencia = eficiencia;
	}

	// ===================================================================================
	/**
	 * Insere nova instancia de caracteristicas do medicamento no banco de dados
	 * 
	 * @return CaracteristicaMedicamento instancia de caracteristicas da dor
	 *         inserida
	 * 
	 * @param indMedic indice da nova instancia
	 * @param bdMedic  instancia caracteristica da medicamento a ser armazenada
	 * 
	 */
	public static CaracteristicaMedicamento inserirCaractMedic(int indMedic,
			CaracteristicaMedicamento bdMedic) {
		// usado por ControleCadastroEpisodio
		BancoDeDadosEpisodio.setBdCaractMedic(bdMedic, indMedic);
		BancoDeDadosEpisodio.setQtdBDCaractMedic(indMedic + 1);
		return BancoDeDadosEpisodio.getBdCaractMedic(indMedic);
	}

	// ===================================================================================
	/**
	 * Edita instancia existente de caracteristicas do medicamento no banco de dados
	 * 
	 * @return CaracteristicaMedicamento caracteristicas do medicamento editada
	 * 
	 * @param indMedic   indice do nome do medicamento utilizado a ser editado
	 * @param nomeMedic  nome do medicamento utilizado
	 * @param eficiencia se o medicamento funcionou ou não
	 *
	 */
	public static CaracteristicaMedicamento editarCaractMedic(int indMedic,
			NomeMedicamento nomeMedic, String eficiencia) {
		// usado por ControleCadastroEpisodio
		BancoDeDadosEpisodio.getBdCaractMedic(indMedic).setNomeMedic(nomeMedic);
		BancoDeDadosEpisodio.getBdCaractMedic(indMedic).setEficiencia(eficiencia);
		return BancoDeDadosEpisodio.getBdCaractMedic(indMedic);
	}

	// ===================================================================================
	/**
	 * Exclui instancia existente de caracteristicas do medicamento no banco de
	 * dados
	 * 
	 * @return boolean retorna verdadeiro se a instancia que foi excluida era a
	 *         ultima
	 * 
	 * @param indiceCaractMedicExcluir indice da caracteristica a ser excluida
	 * 
	 */
	public static boolean excluirCaractMedic(int indiceCaractMedicExcluir) {
		int qtdCaractMedic = BancoDeDadosEpisodio.getQtdBDCaractMedic();
		CaracteristicaMedicamento[] bdCaractMedic = BancoDeDadosEpisodio
				.getBdCaractMedic();
		// o nome nao esta no final do array
		boolean boolean_ultimo = false;
		if (indiceCaractMedicExcluir != (qtdCaractMedic - 1)) {
			// apos remover tem q deslocar o array todo
			for (int j = indiceCaractMedicExcluir; j < qtdCaractMedic - 1; j++) {
				bdCaractMedic[j] = bdCaractMedic[j + 1];
			}
		} else
			boolean_ultimo = true;
		BancoDeDadosEpisodio.setBdCaractMedic(null, qtdCaractMedic - 1);
		BancoDeDadosEpisodio.setQtdBDCaractMedic(qtdCaractMedic - 1);
		return boolean_ultimo;
	}
	// ===================================================================================

}
// Fim da classe CaracteristicaMedicamento
// =======================================================================================