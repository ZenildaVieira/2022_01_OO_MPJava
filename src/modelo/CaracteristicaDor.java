// =======================================================================================
package modelo;

//=======================================================================================
/**
 * As instancias dessa classe representam as caracteristicas da dor de cada
 * episodio que sera cadastrado
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 * 
 */
public class CaracteristicaDor {
	// ===================================================================================
	// Atributos da classe - 5 no total
	private NomeTipoDor tipoDor; // tipo da dor se latejante, pulsante, constante, etc
	private NomeGatilho gatilho; // gatilho que provocou o episodio de enxaqueca
	private NomeLocalizacao local; // qual o local que doi na cabeca
	private String sintoma; // sintoma que acompanha o episodio: vomito, aurea, nausea etc
	private int intensidade; // qual a intensidade da dor de 1 a 9

	// ===================================================================================
	/**
	 * Construtor
	 * 
	 */
	public CaracteristicaDor() {
		super();
	}

	// ===================================================================================
	/**
	 * Sobrecarga do construtor com todos os atributos como parametros
	 * 
	 * @param tipoDor     tipo da dor, se latejante, pulsante, constante, etc
	 * @param gatilho     gatilho que provocou o episodio de enxaqueca
	 * @param local       qual o local que doi na cabeca
	 * @param sintoma     sintoma que acompanha o episodio: vomito, aurea, nausea,
	 *                    etc
	 * @param intensidade qual a intensidade da dor de 1 a 9
	 * 
	 */
	public CaracteristicaDor(NomeTipoDor tipoDor, NomeGatilho gatilho,
			NomeLocalizacao local, String sintoma, int intensidade) {
		super();
		this.tipoDor = tipoDor;
		this.gatilho = gatilho;
		this.local = local;
		this.sintoma = sintoma;
		this.intensidade = intensidade;
	}

	// ===================================================================================
	/**
	 * Sobrescrita do metodo toString da classe Object(). Constroi uma String
	 * contendo o valor de todas as variaveis da classe CaracteristicaDor.
	 * 
	 * @return String
	 * 
	 */
	@Override
	public String toString() {
		return "CaracteristicaDor [tipoDor=" + tipoDor + ", gatilho=" + gatilho
				+ ", local=" + local + ", sintoma=" + sintoma + ", intensidade="
				+ intensidade + "]";
	}

	// ===================================================================================
	public NomeTipoDor getTipoDor() {
		return tipoDor;
	}

	public void setTipoDor(NomeTipoDor nomeTipoDor) {
		tipoDor = nomeTipoDor;
	}

	public void setTipoDor(String nomeTipoDor) {
		tipoDor.setNomeTipoDor(nomeTipoDor);
	}

	// ===================================================================================
	public NomeGatilho getGatilho() {
		return gatilho;
	}

	public void setGatilho(NomeGatilho nomeGatilho) {
		gatilho = nomeGatilho;
	}

	public void setGatilho(String nomeGatilho) {
		gatilho.setNomeGatilho(nomeGatilho);
	}

	// ===================================================================================
	public NomeLocalizacao getLocal() {
		return local;
	}

	public void setLocal(NomeLocalizacao nomeLocal) {
		local = nomeLocal;
	}

	public void setLocal(String nomeLocal) {
		local.setNomeLocal(nomeLocal);
	}

	// ===================================================================================
	public String getSintoma() {
		return sintoma;
	}

	public void setSintoma(String nomeSintoma) {
		sintoma = nomeSintoma;
	}

	// ===================================================================================
	public int getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(int valorIntensidade) {
		intensidade = valorIntensidade;
	}

	// ===================================================================================
	/**
	 * Insere nova instancia de caracteristicas da dor no banco de dados
	 * 
	 * @return CaracteristicaDor instancia de caracteristicas da dor inserida
	 * 
	 * @param indDor    indice da nova instancia
	 * @param caractDor instancia caracteristica da dor a ser armazenada
	 * 
	 */
	public static CaracteristicaDor inserirCaractDor(int indDor,
			CaracteristicaDor caractDor) {
		// usado por ControleCadastroEpisodio
		BancoDeDadosEpisodio.setBdCaractDor(caractDor, indDor);
		BancoDeDadosEpisodio.setQtdBDCaractDor(indDor + 1);
		return BancoDeDadosEpisodio.getBdCaractDor(indDor);
	}

	// ===================================================================================
	/**
	 * Edita instancia existente de caracteristicas da dor no banco de dados
	 * 
	 * @return CaracteristicaDor caracteristicas da dor editada
	 * 
	 * @param indDor      indice da caracteristica a ser editada
	 * @param tipoDor     tipo da dor, se latejante, pulsante, constante, etc
	 * @param gatilho     gatilho que provocou o episodio de enxaqueca
	 * @param local       qual o local que doi na cabeca
	 * @param sintoma     sintoma que acompanha o episodio: vomito, aurea, nausea,
	 *                    etc
	 * @param intensidade qual a intensidade da dor de 1 a 9
	 * 
	 */
	public static CaracteristicaDor editarCaractDor(int indDor, NomeTipoDor tipoDor,
			NomeGatilho gatilho, NomeLocalizacao local, String sintoma, int intensidade) {
		// usado por ControleCadastroEpisodio
		BancoDeDadosEpisodio.getBdCaractDor(indDor).setTipoDor(tipoDor);
		BancoDeDadosEpisodio.getBdCaractDor(indDor).setGatilho(gatilho);
		BancoDeDadosEpisodio.getBdCaractDor(indDor).setLocal(local);
		BancoDeDadosEpisodio.getBdCaractDor(indDor).setSintoma(sintoma);
		BancoDeDadosEpisodio.getBdCaractDor(indDor).setIntensidade(intensidade);
		return BancoDeDadosEpisodio.getBdCaractDor(indDor);
	}

	// ===================================================================================
	/**
	 * Exclui instancia existente de caracteristicas da dor no banco de dados
	 * 
	 * @return boolean retorna verdadeiro se a instancia que foi excluida era a
	 *         ultima
	 * 
	 * @param indiceCaractDorExcluir indice da caracteristica a ser excluida
	 * 
	 */
	public static boolean excluirCaractDor(int indiceCaractDorExcluir) {
		int qtdCaractDor = BancoDeDadosEpisodio.getQtdBDCaractDor();
		CaracteristicaDor[] bdCaractDor = BancoDeDadosEpisodio.getBdCaractDor();
		// o nome nao esta no final do array
		boolean boolean_ultimo = false;
		if (indiceCaractDorExcluir != (qtdCaractDor - 1)) {
			// apos remover tem q deslocar o array todo
			for (int j = indiceCaractDorExcluir; j < qtdCaractDor - 1; j++) {
				bdCaractDor[j] = bdCaractDor[j + 1];
			}
		} else
			boolean_ultimo = true;
		BancoDeDadosEpisodio.setBdCaractDor(null, qtdCaractDor - 1);
		BancoDeDadosEpisodio.setQtdBDCaractDor(qtdCaractDor - 1);
		return boolean_ultimo;
	}
	// ===================================================================================

}
// Fim da classe CaracteristicaDor
// =======================================================================================