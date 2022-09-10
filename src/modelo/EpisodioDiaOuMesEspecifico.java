package modelo;

import java.util.Arrays;

//=======================================================================================
/**
 * Essa classe contem as informacoes e calculos de determinados grupos de
 * episodio, agrupados por mes e usuario de acordo com o filtro do aplicativo.
 * Contem tambem os resultados da manipulacao dos dados cadastrados. É subclasse
 * da classe Episodio.
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 * 
 */
public class EpisodioDiaOuMesEspecifico extends Episodio {
	// ===================================================================================
	private Episodio episodioDia = new Episodio();
	private int indiceEpisodioDia;
	// ===================================================================================
	private Episodio[] episodioMes = new Episodio[100];
	private int qtdEpisodioMes;
	// ===================================================================================
	private Episodio[] episodioTotal = new Episodio[100];
	private int qtdEpisodioTotal;
	// ===================================================================================
	private String tipoDorMaisComum;
	private int qtdTipoDorMaisComum;
	// ===================================================================================
	private String gatilhoMaisComum;
	private int qtdGatilhoMaisComum;
	// ===================================================================================
	private String medicMaisComum;
	private int qtdMedicMaisComum;
	// ===================================================================================
	private String localMaisComum;
	private int qtdLocalMaisComum;
	// ===================================================================================
	private String sintomaMaisComum;
	private int qtdSintomaMaisComum;
	// ===================================================================================

	// ===================================================================================
	/**
	 * Construtor
	 * 
	 */
	public EpisodioDiaOuMesEspecifico() {
		super();
	}

	// ===================================================================================
	/**
	 * Sobrescrita do metodo toString da classe Object(). Constroi uma String
	 * contendo o valor de todas as variaveis da classe Episodio.
	 * 
	 * @return String
	 * 
	 */
	@Override
	public String toString() {
		return "EpisodioDiaOuMesEspecifico [episodioDia=" + episodioDia
				+ ", indiceEpisodioDia=" + indiceEpisodioDia + ", episodioMes="
				+ Arrays.toString(episodioMes) + ", qtdEpisodioMes=" + qtdEpisodioMes
				+ ", episodioTotal=" + Arrays.toString(episodioTotal)
				+ ", qtdEpisodioTotal=" + qtdEpisodioTotal + ", tipoDorMaisComum="
				+ tipoDorMaisComum + ", qtdTipoDorMaisComum=" + qtdTipoDorMaisComum
				+ ", gatilhoMaisComum=" + gatilhoMaisComum + ", qtdGatilhoMaisComum="
				+ qtdGatilhoMaisComum + ", medicMaisComum=" + medicMaisComum
				+ ", qtdMedicMaisComum=" + qtdMedicMaisComum + ", localMaisComum="
				+ localMaisComum + ", qtdLocalMaisComum=" + qtdLocalMaisComum
				+ ", sintomaMaisComum=" + sintomaMaisComum + ", qtdSintomaMaisComum="
				+ qtdSintomaMaisComum + "]";
	}

	// ===================================================================================
	/**
	 * Busca e armazena em uma string de episodios os episodios que atendem ao
	 * filtro especifico de usuario e mes.
	 * 
	 * @param usuarioFiltro usuario a ser usado na busca
	 * @param mesAnoFiltro  mes e ano a ser usado na busca
	 * 
	 */
	public void buscarEpisodiosMesEspecifico(String usuarioFiltro, String mesAnoFiltro) {
		// usado por ControleDados
		episodioTotal = BancoDeDadosEpisodio.getBdEpisodio();
		qtdEpisodioTotal = BancoDeDadosEpisodio.getQtdBDEpisodio();
		qtdEpisodioMes = 0;
		for (int i = 0; i < qtdEpisodioTotal; i++) {
			if (episodioTotal[i].getUsuario() == usuarioFiltro
					&& episodioTotal[i].getDataInicioMesAno() == mesAnoFiltro) {
				episodioMes[qtdEpisodioMes] = episodioTotal[i];
				qtdEpisodioMes = qtdEpisodioMes + 1;
			}
		}
		setEpisodioMes(episodioMes);
		setQtdEpisodioMes(qtdEpisodioMes);
	}

	// ===================================================================================
	/**
	 * Busca e armazena um episodio que atende ao filtro especifico de usuario, dia
	 * e mes.
	 * 
	 * @param usuarioFiltro usuario a ser usado na busca
	 * @param dia           dia a ser usado na busca
	 * @param mesAnoFiltro  mes e ano a ser usado na busca
	 * 
	 * @return achou retorna verdadeiro se o episodio foi encontrado
	 * 
	 */
	public boolean buscarEpisodioDia(String usuarioFiltro, int dia, String mesAnoFiltro) {
		// usado por ControleDados
		boolean achou = false;
		episodioTotal = BancoDeDadosEpisodio.getBdEpisodio();
		qtdEpisodioTotal = BancoDeDadosEpisodio.getQtdBDEpisodio();
		episodioDia = episodioTotal[0];
		indiceEpisodioDia = 0;
		// System.out.println(usuarioFiltro + dia + mesAnoFiltro);
		for (int i = 0; i < qtdEpisodioTotal; i++) {
			if (episodioTotal[i].getUsuario().compareTo(usuarioFiltro) == 0
					&& episodioTotal[i].getDataInicioDia() == dia && episodioTotal[i]
							.getDataInicioMesAno().compareTo(mesAnoFiltro) == 0) {
				episodioDia = episodioTotal[i];
				indiceEpisodioDia = i;
				i = qtdEpisodioTotal;
				achou = true;
				// System.out.println(episodioDia);
			} else
				achou = false;
		}
		setIndiceEpisodioDia(indiceEpisodioDia);
		setEpisodioDia(episodioDia);
		return achou;
	}

	// ===================================================================================
	/**
	 * Busca e armazena um episodio de um indice especifico
	 * 
	 * @param indiceEpisodio indice do episodio que se quer buscar
	 * 
	 * 
	 */
	public void buscarEpisodioDia(int indiceEpisodio) {
		// usado por ControleDados
		episodioTotal = BancoDeDadosEpisodio.getBdEpisodio();
		qtdEpisodioTotal = BancoDeDadosEpisodio.getQtdBDEpisodio();
		episodioDia = episodioTotal[indiceEpisodio];
		indiceEpisodioDia = indiceEpisodio;
		setIndiceEpisodioDia(indiceEpisodioDia);
		setEpisodioDia(episodioDia);
	}

	// ===================================================================================
	/**
	 * Calcula a duracao media dos episodios de enxaqueca do grupo de episodios
	 * filtrados por mes e usuario.
	 * 
	 * @return duracaoMedia duracao media dos episodios de enxaqueca
	 * 
	 */
	public double calcularDuracaoMedia() {
		double duracaoMedia = 0;
		for (int i = 0; i < qtdEpisodioMes; i++)
			duracaoMedia = duracaoMedia + episodioMes[i].getDuracaoHoras();
		duracaoMedia = duracaoMedia / qtdEpisodioMes;
		duracaoMedia = Math.round(duracaoMedia * 100.0) / 100.0;
		return duracaoMedia;
	}

	// ===================================================================================
	/**
	 * Calcula a intensidade media dos episodios de enxaqueca do grupo de episodios
	 * filtrados por mes e usuario.
	 * 
	 * @return intensidadeMedia intensidade media dos episodios de enxaqueca
	 * 
	 */
	public double calcularIntensidadeMedia() {
		double intensidadeMedia = 0;
		for (int i = 0; i < qtdEpisodioMes; i++) {
			intensidadeMedia = intensidadeMedia
					+ episodioMes[i].getCaractDor().getIntensidade();
		}
		intensidadeMedia = intensidadeMedia / qtdEpisodioMes;
		intensidadeMedia = Math.round(intensidadeMedia * 100.0) / 100.0;
		return intensidadeMedia;
	}

	// ===================================================================================
	/**
	 * Gera um array com todos os tipo de dor armazenados sem repetidos
	 * 
	 * @return tipoDorUnicos array de string com tipos de dor sem repeticao
	 * 
	 */
	public String[] gerarArrayTipoDorUnicos() {
		String[] tipoDor = new String[100];
		String[] tipoDorUnicos = new String[100];
		int k = 0;
		boolean achou_igual = false;
		tipoDorUnicos[0] = "/0";
		for (int i = 0; i < qtdEpisodioMes; i++) {
			tipoDor[i] = episodioMes[i].getCaractDor().getTipoDor().getNomeTipoDor();
			achou_igual = false;
			for (int j = 0; j <= k; j++) {
				if (tipoDorUnicos[j] == tipoDor[i])
					achou_igual = true;
			}
			if (achou_igual == false) {
				tipoDorUnicos[k] = tipoDor[i];
				k = k + 1;
			}
		}
		return tipoDorUnicos;
	}

	// ===================================================================================
	/**
	 * Calcula o tipo de dor mais comum e quantas vezes ele aparece em um
	 * determinado grupo de episodios filtrados por usuario e mes.
	 * 
	 */
	public void calcularTipoDorMaisComum() {
		// usado por ControleDados
		String[] tipoDor = new String[100];
		String[] tipoDorUnicos = gerarArrayTipoDorUnicos();
		String auxOrdena = new String();
		int auxOrdenaQtd = 0;
		int[] qtdTipoDorUnicos = new int[100];
		int k = tipoDorUnicos.length;

		for (int i = 0; i < qtdEpisodioMes; i++) {
			tipoDor[i] = episodioMes[i].getCaractDor().getTipoDor().getNomeTipoDor();
			for (int w = 0; w < k; w++) {
				if (tipoDorUnicos[w] == tipoDor[i])
					qtdTipoDorUnicos[w] = qtdTipoDorUnicos[w] + 1;
			}
		}
		for (int w = 1; w < k; w++) {
			if (qtdTipoDorUnicos[w] >= qtdTipoDorUnicos[w - 1]) {
				auxOrdenaQtd = qtdTipoDorUnicos[w - 1];
				qtdTipoDorUnicos[w - 1] = qtdTipoDorUnicos[w];
				qtdTipoDorUnicos[w] = auxOrdenaQtd;
				auxOrdena = tipoDorUnicos[w - 1];
				tipoDorUnicos[w - 1] = tipoDorUnicos[w];
				tipoDorUnicos[w] = auxOrdena;
			}
		}
		tipoDorMaisComum = tipoDorUnicos[0];
		qtdTipoDorMaisComum = qtdTipoDorUnicos[0];
	}

	// ===================================================================================
	/**
	 * Gera um array com todos os gatilhos armazenados sem repetidos
	 * 
	 * @return gatilhoUnicos array de string com gatilhos sem repeticao
	 * 
	 */
	public String[] gerarArrayGatilhoUnicos() {
		String[] gatilho = new String[100];
		String[] gatilhoUnicos = new String[100];
		int k = 0;
		boolean achou_igual = false;
		gatilhoUnicos[0] = "/0";
		for (int i = 0; i < qtdEpisodioMes; i++) {
			gatilho[i] = episodioMes[i].getCaractDor().getGatilho().getNomeGatilho();
			achou_igual = false;
			for (int j = 0; j <= k; j++) {
				if (gatilhoUnicos[j] == gatilho[i])
					achou_igual = true;
			}
			if (achou_igual == false) {
				gatilhoUnicos[k] = gatilho[i];
				k = k + 1;
			}
		}
		return gatilhoUnicos;
	}

	// ===================================================================================
	/**
	 * Calcula o gatilho mais comum e quantas vezes ele aparece em um determinado
	 * grupo de episodios filtrados por usuario e mes.
	 * 
	 */
	public void calcularGatilhoMaisComum() {
		// usado por ControleDados
		String[] gatilho = new String[100];
		String[] gatilhoUnicos = gerarArrayGatilhoUnicos();
		String auxOrdena = new String();
		int auxOrdenaQtd = 0;
		int[] qtdGatilhoUnicos = new int[100];
		int k = gatilhoUnicos.length;

		for (int i = 0; i < qtdEpisodioMes; i++) {
			gatilho[i] = episodioMes[i].getCaractDor().getGatilho().getNomeGatilho();
			for (int w = 0; w < k; w++) {
				if (gatilhoUnicos[w] == gatilho[i])
					qtdGatilhoUnicos[w] = qtdGatilhoUnicos[w] + 1;
			}
		}
		for (int w = 1; w < k; w++) {
			if (qtdGatilhoUnicos[w] >= qtdGatilhoUnicos[w - 1]) {
				auxOrdenaQtd = qtdGatilhoUnicos[w - 1];
				qtdGatilhoUnicos[w - 1] = qtdGatilhoUnicos[w];
				qtdGatilhoUnicos[w] = auxOrdenaQtd;
				auxOrdena = gatilhoUnicos[w - 1];
				gatilhoUnicos[w - 1] = gatilhoUnicos[w];
				gatilhoUnicos[w] = auxOrdena;
			}
		}
		gatilhoMaisComum = gatilhoUnicos[0];
		qtdGatilhoMaisComum = qtdGatilhoUnicos[0];
	}

	// ===================================================================================
	/**
	 * Gera um array com todos os nomes de medicamentos armazenados sem repetidos
	 * 
	 * @return medicUnicos array de string com nomes de medicamento sem repeticao
	 * 
	 */
	public String[] gerarArrayMedicUnicos() {
		String[] medic = new String[100];
		String[] medicUnicos = new String[100];
		int k = 0;
		boolean achou_igual = false;
		medicUnicos[0] = "/0";
		for (int i = 0; i < qtdEpisodioMes; i++) {
			medic[i] = episodioMes[i].getCaractMedic().getNomeMedic().getNomeMedic();
			achou_igual = false;
			for (int j = 0; j <= k; j++) {
				if (medicUnicos[j] == medic[i])
					achou_igual = true;
			}
			if (achou_igual == false) {
				medicUnicos[k] = medic[i];
				k = k + 1;
			}
		}
		return medicUnicos;
	}

	// ===================================================================================
	/**
	 * Calcula o nome de medicamento mais comum e quantas vezes ele aparece em um
	 * determinado grupo de episodios filtrados por usuario e mes.
	 * 
	 */
	public void calcularMedicMaisComum() {
		// usado por ControleDados
		String[] medic = new String[100];
		String[] medicUnicos = gerarArrayMedicUnicos();
		String auxOrdena = new String();
		int auxOrdenaQtd = 0;
		int[] qtdMedicUnicos = new int[100];
		int k = medicUnicos.length;

		for (int i = 0; i < qtdEpisodioMes; i++) {
			medic[i] = episodioMes[i].getCaractMedic().getNomeMedic().getNomeMedic();
			for (int w = 0; w < k; w++) {
				if (medicUnicos[w] == medic[i])
					qtdMedicUnicos[w] = qtdMedicUnicos[w] + 1;
			}
		}
		for (int w = 1; w < k; w++) {
			if (qtdMedicUnicos[w] >= qtdMedicUnicos[w - 1]) {
				auxOrdenaQtd = qtdMedicUnicos[w - 1];
				qtdMedicUnicos[w - 1] = qtdMedicUnicos[w];
				qtdMedicUnicos[w] = auxOrdenaQtd;
				auxOrdena = medicUnicos[w - 1];
				medicUnicos[w - 1] = medicUnicos[w];
				medicUnicos[w] = auxOrdena;
			}
		}
		medicMaisComum = medicUnicos[0];
		qtdMedicMaisComum = qtdMedicUnicos[0];
	}

	// ===================================================================================
	/**
	 * Gera um array com todos os locais armazenados sem repetidos
	 * 
	 * @return localUnicos array de string com locais sem repeticao
	 * 
	 */
	public String[] gerarArrayLocalUnicos() {
		String[] local = new String[100];
		String[] localUnicos = new String[100];
		int k = 0;
		boolean achou_igual = false;
		localUnicos[0] = "/0";
		for (int i = 0; i < qtdEpisodioMes; i++) {
			local[i] = episodioMes[i].getCaractDor().getLocal().getNomeLocal();
			achou_igual = false;
			for (int j = 0; j <= k; j++) {
				if (localUnicos[j] == local[i])
					achou_igual = true;
			}
			if (achou_igual == false) {
				localUnicos[k] = local[i];
				k = k + 1;
			}
		}
		return localUnicos;
	}

	// ===================================================================================
	/**
	 * Calcula o local mais comum e quantas vezes ele aparece em um determinado
	 * grupo de episodios filtrados por usuario e mes.
	 * 
	 */
	public void calcularLocalMaisComum() {
		String[] local = new String[100];
		String[] localUnicos = gerarArrayLocalUnicos();
		String auxOrdena = new String();
		int auxOrdenaQtd = 0;
		int[] qtdLocalUnicos = new int[100];
		int k = localUnicos.length;

		for (int i = 0; i < qtdEpisodioMes; i++) {
			local[i] = episodioMes[i].getCaractDor().getLocal().getNomeLocal();
			for (int w = 0; w < k; w++) {
				if (localUnicos[w] == local[i])
					qtdLocalUnicos[w] = qtdLocalUnicos[w] + 1;
			}
		}
		for (int w = 1; w < k; w++) {
			if (qtdLocalUnicos[w] >= qtdLocalUnicos[w - 1]) {
				auxOrdenaQtd = qtdLocalUnicos[w - 1];
				qtdLocalUnicos[w - 1] = qtdLocalUnicos[w];
				qtdLocalUnicos[w] = auxOrdenaQtd;
				auxOrdena = localUnicos[w - 1];
				localUnicos[w - 1] = localUnicos[w];
				localUnicos[w] = auxOrdena;
			}
		}
		localMaisComum = localUnicos[0];
		qtdLocalMaisComum = qtdLocalUnicos[0];
	}

	// ===================================================================================
	/**
	 * Gera um array com todos os sintomas armazenados sem repetidos
	 * 
	 * @return sintomaUnicos array de string com os sintomas sem repeticao
	 * 
	 */
	public String[] gerarArraySintomaUnicos() {
		String[] sintoma = new String[100];
		String[] sintomaUnicos = new String[100];
		int k = 0;
		boolean achou_igual = false;
		sintomaUnicos[0] = "/0";
		for (int i = 0; i < qtdEpisodioMes; i++) {
			sintoma[i] = episodioMes[i].getCaractDor().getSintoma();
			achou_igual = false;
			for (int j = 0; j <= k; j++) {
				if (sintomaUnicos[j] == sintoma[i])
					achou_igual = true;
			}
			if (achou_igual == false) {
				sintomaUnicos[k] = sintoma[i];
				k = k + 1;
			}
		}
		return sintomaUnicos;
	}

	// ===================================================================================
	/**
	 * Calcula o sintoma mais comum e quantas vezes ele aparece em um determinado
	 * grupo de episodios filtrados por usuario e mes.
	 * 
	 */
	public void calcularSintomaMaisComum() {
		String[] sintoma = new String[100];
		String[] sintomaUnicos = gerarArraySintomaUnicos();
		String auxOrdena = new String();
		int auxOrdenaQtd = 0;
		int[] qtdSintomaUnicos = new int[100];
		int k = sintomaUnicos.length;

		for (int i = 0; i < qtdEpisodioMes; i++) {
			sintoma[i] = episodioMes[i].getCaractDor().getSintoma();
			for (int w = 0; w < k; w++) {
				if (sintomaUnicos[w] == sintoma[i])
					qtdSintomaUnicos[w] = qtdSintomaUnicos[w] + 1;
			}
		}
		for (int w = 1; w < k; w++) {
			if (qtdSintomaUnicos[w] >= qtdSintomaUnicos[w - 1]) {
				auxOrdenaQtd = qtdSintomaUnicos[w - 1];
				qtdSintomaUnicos[w - 1] = qtdSintomaUnicos[w];
				qtdSintomaUnicos[w] = auxOrdenaQtd;
				auxOrdena = sintomaUnicos[w - 1];
				sintomaUnicos[w - 1] = sintomaUnicos[w];
				sintomaUnicos[w] = auxOrdena;
			}
		}
		sintomaMaisComum = sintomaUnicos[0];
		qtdSintomaMaisComum = qtdSintomaUnicos[0];
	}

	// ===================================================================================
	/**
	 * Metodo para obter um array, apos comparar todos os meses do banco de dados,
	 * contendo somente os meses que nao forem repetidos
	 * 
	 * @return mesesAnosUnicos array com meses nao repetidos
	 */
	public static String[] gerarArrayComMesAnoUnicos() {
		// array mesAno - todos instanciados inclusive repetidos
		String[] mesAno = new String[100];
		// array mesAnoUnicos - todos instanciados retirando repetidos
		String[] mesAnoUnicos = new String[100];
		int k = 0;
		boolean achou_igual = false;
		// array como todos episodios instanciados
		int qtdBDEpisodio = BancoDeDadosEpisodio.getQtdBDEpisodio();
		Episodio[] bdEpisodio = BancoDeDadosEpisodio.getBdEpisodio();
		// rotina para tirar repetidos
		mesAnoUnicos[0] = "/0";
		for (int i = 0; i < qtdBDEpisodio; i++) {
			mesAno[i] = bdEpisodio[i].getDataInicioMesAno();
			achou_igual = false;
			for (int j = 0; j <= k; j++) {
				if (mesAnoUnicos[j] == mesAno[i])
					achou_igual = true;
			}
			if (achou_igual == false) {
				mesAnoUnicos[k] = mesAno[i];
				k = k + 1;
			}
		}
		return mesAnoUnicos;
	}

	// ===================================================================================
	public Episodio getEpisodioDia() {
		return episodioDia;
	}

	public void setEpisodioDia(Episodio episodioDia) {
		this.episodioDia = episodioDia;
	}

	public int getIndiceEpisodioDia() {
		return indiceEpisodioDia;
	}

	public void setIndiceEpisodioDia(int indiceEpisodioDia) {
		this.indiceEpisodioDia = indiceEpisodioDia;
	}

	public Episodio[] getEpisodioMes() {
		return episodioMes;
	}

	public void setEpisodioMes(Episodio[] episodioMes) {
		this.episodioMes = episodioMes;
	}

	public int getQtdEpisodioMes() {
		return qtdEpisodioMes;
	}

	public void setQtdEpisodioMes(int qtdEpisodioMes) {
		this.qtdEpisodioMes = qtdEpisodioMes;
	}

	public Episodio[] getEpisodioTotal() {
		return episodioTotal;
	}

	public void setEpisodioTotal(Episodio[] episodioTotal) {
		this.episodioTotal = episodioTotal;
	}

	public int getQtdEpisodioTotal() {
		return qtdEpisodioTotal;
	}

	public void setQtdEpisodioTotal(int qtdEpisodioTotal) {
		this.qtdEpisodioTotal = qtdEpisodioTotal;
	}

	public String getTipoDorMaisComum() {
		return tipoDorMaisComum;
	}

	public void setTipoDorMaisComum(String tipoDorMaisComum) {
		this.tipoDorMaisComum = tipoDorMaisComum;
	}

	public int getQtdTipoDorMaisComum() {
		return qtdTipoDorMaisComum;
	}

	public void setQtdTipoDorMaisComum(int qtdTipoDorMaisComum) {
		this.qtdTipoDorMaisComum = qtdTipoDorMaisComum;
	}

	public String getGatilhoMaisComum() {
		return gatilhoMaisComum;
	}

	public void setGatilhoMaisComum(String gatilhoMaisComum) {
		this.gatilhoMaisComum = gatilhoMaisComum;
	}

	public int getQtdGatilhoMaisComum() {
		return qtdGatilhoMaisComum;
	}

	public void setQtdGatilhoMaisComum(int qtdGatilhoMaisComum) {
		this.qtdGatilhoMaisComum = qtdGatilhoMaisComum;
	}

	public String getMedicMaisComum() {
		return medicMaisComum;
	}

	public void setMedicMaisComum(String medicMaisComum) {
		this.medicMaisComum = medicMaisComum;
	}

	public int getQtdMedicMaisComum() {
		return qtdMedicMaisComum;
	}

	public void setQtdMedicMaisComum(int qtdMedicMaisComum) {
		this.qtdMedicMaisComum = qtdMedicMaisComum;
	}

	public String getLocalMaisComum() {
		return localMaisComum;
	}

	public void setLocalMaisComum(String localMaisComum) {
		this.localMaisComum = localMaisComum;
	}

	public int getQtdLocalMaisComum() {
		return qtdLocalMaisComum;
	}

	public void setQtdLocalMaisComum(int qtdLocalMaisComum) {
		this.qtdLocalMaisComum = qtdLocalMaisComum;
	}

	public String getSintomaMaisComum() {
		return sintomaMaisComum;
	}

	public void setSintomaMaisComum(String sintomaMaisComum) {
		this.sintomaMaisComum = sintomaMaisComum;
	}

	public int getQtdSintomaMaisComum() {
		return qtdSintomaMaisComum;
	}

	public void setQtdSintomaMaisComum(int qtdSintomaMaisComum) {
		this.qtdSintomaMaisComum = qtdSintomaMaisComum;
	}

}
