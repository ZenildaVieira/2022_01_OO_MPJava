// =======================================================================================
package modelo;

// =======================================================================================
/**
 * As instancias dessa classe representam todas as informacoes de cada episodio
 * cadastrado. Tem como subclasse a classe EpisodioDiaOuMesEspecifico
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 * 
 */
public class Episodio {
	// ===================================================================================
	// Atributos da classe - 11 no total
	protected String usuario; // nome do usuario que teve o episodio de enxaqueca
	protected int dataInicioDia; // dia da data e hora da ocorrencia
	protected int dataInicioMes; // mes da data e hora da ocorrencia
	protected int dataInicioAno; // ano da data e hora da ocorrencia
	protected String dataInicioMesAno; // mes e ano da data e hora da ocorrencia usado em
										// filtros e buscas
	protected int dataInicioHora; // hora da data e hora da ocorrencia
	protected int dataInicioMinuto; // minutos da data e hora da ocorrencia
	protected int duracaoHoras; // duracao da dor de cabeca em horas
	protected CaracteristicaDor caractDor; // associacao - classe 5 atributos
	protected CaracteristicaMedicamento caractMedic; // associacao - classe 2 atributos
	protected String observacao; // notas adicionais que o usuario quiser registrar

	// ===================================================================================
	/**
	 * Construtor
	 * 
	 */
	public Episodio() {
		super();
	}

	// ===================================================================================
	/**
	 * Sobrecarga do construtor com todos os atributos como parametros
	 * 
	 * @param usuario                   nome do usuario que teve o episodio de
	 *                                  enxaqueca
	 * @param dataInicioDia             dia da data e hora da ocorrencia
	 * @param dataInicioMes             mes da data e hora da ocorrencia
	 * @param dataInicioAno             ano da data e hora da ocorrencia
	 * @param dataInicioMesAno          mes e ano da data e hora da ocorrencia usado
	 *                                  em filtros e buscas
	 * @param horas                     hora da data e hora da ocorrencia
	 * @param minutos                   minutos da data e hora da ocorrencia
	 * @param duracaoHoras              duracao da dor de cabeca em horas
	 * @param caracteristicaDor         Classe CaracteristicaDor - caracteristicas
	 *                                  da dor
	 * @param caracteristicaMedicamento Classe CaracteristicaMedicamento -
	 *                                  caracteristicas do medicamento utilizado
	 * @param observacoes               notas adicionais que o usuario quiser
	 *                                  registrar
	 * 
	 */
	public Episodio(String usuario, int dataInicioDia, int dataInicioMes,
			int dataInicioAno, String dataInicioMesAno, int horas, int minutos,
			int duracaoHoras, CaracteristicaDor caracteristicaDor,
			CaracteristicaMedicamento caracteristicaMedicamento, String observacoes) {
		super();
		this.usuario = usuario;
		this.dataInicioDia = dataInicioDia;
		this.dataInicioMes = dataInicioMes;
		this.dataInicioAno = dataInicioAno;
		this.dataInicioMesAno = dataInicioMesAno;
		this.dataInicioHora = horas;
		this.dataInicioMinuto = minutos;
		this.duracaoHoras = duracaoHoras;
		this.caractDor = caracteristicaDor;
		this.caractMedic = caracteristicaMedicamento;
		this.observacao = observacoes;
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
		return "Episodio [usuario=" + usuario + ", dataInicioDia=" + dataInicioDia
				+ ", dataInicioMes=" + dataInicioMes + ", dataInicioAno=" + dataInicioAno
				+ ", dataInicioMesAno=" + dataInicioMesAno + ", dataInicioHora="
				+ dataInicioHora + ", dataInicioMinuto=" + dataInicioMinuto
				+ ", duracaoHoras=" + duracaoHoras + ", caractDor=" + caractDor
				+ ", caractMedic=" + caractMedic + ", observacao=" + observacao + "]";
	}

	// ===================================================================================
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	// ===================================================================================
	public int getDataInicioDia() {
		return dataInicioDia;
	}

	public void setDataInicioDia(int dataInicioDia) {
		this.dataInicioDia = dataInicioDia;
	}

	// ===================================================================================
	public int getDataInicioMes() {
		return dataInicioMes;
	}

	public void setDataInicioMes(int dataInicioMes) {
		this.dataInicioMes = dataInicioMes;
	}

	// ===================================================================================
	public int getDataInicioAno() {
		return dataInicioAno;
	}

	public void setDataInicioAno(int dataInicioAno) {
		this.dataInicioAno = dataInicioAno;
	}

	// ===================================================================================
	public String getDataInicioMesAno() {
		return dataInicioMesAno;
	}

	public void setDataInicioMesAno(String dataInicioMesAno) {
		this.dataInicioMesAno = dataInicioMesAno;
	}

	// ===================================================================================
	public int getDataInicioHora() {
		return dataInicioHora;
	}

	public void setDataInicioHora(int dataInicioHora) {
		this.dataInicioHora = dataInicioHora;
	}

	// ===================================================================================
	public int getDataInicioMinuto() {
		return dataInicioMinuto;
	}

	public void setDataInicioMinuto(int dataInicioMinuto) {
		this.dataInicioMinuto = dataInicioMinuto;
	}

	// ===================================================================================
	public int getDuracaoHoras() {
		return duracaoHoras;
	}

	public void setDuracaoHoras(int duracaoHoras) {
		this.duracaoHoras = duracaoHoras;
	}

	// ===================================================================================
	public CaracteristicaDor getCaractDor() {
		return caractDor;
	}

	public void setCaractDor(CaracteristicaDor caractDor) {
		this.caractDor = caractDor;
	}

	// ===================================================================================
	public CaracteristicaMedicamento getCaractMedic() {
		return caractMedic;
	}

	public void setCaractMedic(CaracteristicaMedicamento caractMedic) {
		this.caractMedic = caractMedic;
	}

	// ===================================================================================
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	// ===================================================================================
	/**
	 * Insere nova instancia de episodio no banco de dados
	 * 
	 * @return Episodio episodio inserido em um determinado indice do banco de dados
	 * 
	 * @param indEpis  indice da nova instancia
	 * @param episodio instancia episodio a ser armazenado
	 * 
	 */
	public static Episodio inserirEpisodio(int indEpis, Episodio episodio) {
		// usado por ControleCadastroEpisodio
		BancoDeDadosEpisodio.setBdEpisodio(episodio, indEpis);
		BancoDeDadosEpisodio.setQtdBDEpisodio(indEpis + 1);
		return BancoDeDadosEpisodio.getBdEpisodio(indEpis);
	}

	// ===================================================================================
	/**
	 * Edita instancia existente de episodio no banco de dados
	 * 
	 * @return Episodio episodio editado
	 * 
	 * @param usuario                   nome do usuario que teve o episodio de
	 *                                  enxaqueca
	 * @param dataInicioDia             dia da data e hora da ocorrencia
	 * @param dataInicioMes             mes da data e hora da ocorrencia
	 * @param dataInicioAno             ano da data e hora da ocorrencia
	 * @param dataInicioMesAno          mes e ano da data e hora da ocorrencia usado
	 *                                  em filtros e buscas
	 * @param horas                     hora da data e hora da ocorrencia
	 * @param minutos                   minutos da data e hora da ocorrencia
	 * @param duracaoHoras              duracao da dor de cabeca em horas
	 * @param caracteristicaDor         Classe CaracteristicaDor - caracteristicas
	 *                                  da dor
	 * @param caracteristicaMedicamento Classe CaracteristicaMedicamento -
	 *                                  caracteristicas do medicamento utilizado
	 * @param observacoes               notas adicionais que o usuario quiser
	 *                                  registrar
	 * 
	 */
	public static Episodio editarEpisodioDeUmIndiceEspecifico(int indEpis, String usuario,
			int dataInicioDia, int dataInicioMes, int dataInicioAno,
			String dataInicioMesAno, int horas, int minutos, int duracaoHoras,
			CaracteristicaDor caracteristicaDor,
			CaracteristicaMedicamento caracteristicaMedicamento, String observacoes) {
		// usado por ControleCadastroEpisodio
		BancoDeDadosEpisodio.getBdEpisodio(indEpis).setUsuario(usuario);
		BancoDeDadosEpisodio.getBdEpisodio(indEpis).setDataInicioDia(dataInicioDia);
		BancoDeDadosEpisodio.getBdEpisodio(indEpis).setDataInicioMes(dataInicioMes);
		BancoDeDadosEpisodio.getBdEpisodio(indEpis).setDataInicioAno(dataInicioAno);
		BancoDeDadosEpisodio.getBdEpisodio(indEpis).setDataInicioMesAno(dataInicioMesAno);
		BancoDeDadosEpisodio.getBdEpisodio(indEpis).setDataInicioHora(horas);
		BancoDeDadosEpisodio.getBdEpisodio(indEpis).setDataInicioMinuto(minutos);
		BancoDeDadosEpisodio.getBdEpisodio(indEpis).setDuracaoHoras(duracaoHoras);
		BancoDeDadosEpisodio.getBdEpisodio(indEpis).setCaractDor(caracteristicaDor);
		BancoDeDadosEpisodio.getBdEpisodio(indEpis)
				.setCaractMedic(caracteristicaMedicamento);
		BancoDeDadosEpisodio.getBdEpisodio(indEpis).setObservacao(observacoes);
		return BancoDeDadosEpisodio.getBdEpisodio(indEpis);
	}

	// ===================================================================================
	/**
	 * Exclui instancia existente de episodio no banco de dados de um determinado
	 * indice
	 * 
	 * @return boolean retorna verdadeiro se a instancia que foi excluida era a
	 *         ultima
	 * 
	 * @param indiceEpisodioExcluir indice da caracteristica a ser excluida
	 * 
	 */
	public static boolean excluirEpisodioDeUmIndiceEspecifico(int indiceEpisodioExcluir) {
		int qtdEpisodio = BancoDeDadosEpisodio.getQtdBDEpisodio();
		Episodio[] bdEpisodio = BancoDeDadosEpisodio.getBdEpisodio();
		// o nome nao esta no final do array
		boolean boolean_ultimo = false;
		if (indiceEpisodioExcluir != (qtdEpisodio - 1)) {
			// apos remover tem q deslocar o array todo
			for (int j = indiceEpisodioExcluir; j < qtdEpisodio - 1; j++) {
				bdEpisodio[j] = bdEpisodio[j + 1];
			}
		} else
			boolean_ultimo = true;
		BancoDeDadosEpisodio.setBdEpisodio(null, qtdEpisodio - 1);
		BancoDeDadosEpisodio.setQtdBDEpisodio(qtdEpisodio - 1);
		return boolean_ultimo;
	}

	// ===================================================================================
	/**
	 * Exclui instancia existente de episodio filtrado por usuario e data especifica
	 * do banco de dados
	 * 
	 * @return apagou retorna verdadeiro se o episodio foi encontrado e excluido
	 * 
	 * @param usuarioFiltro usuario a ser usado na busca
	 * @param dia           dia a ser usado na busca
	 * @param mesAnoFiltro  mes e ano a ser usado na busca
	 * 
	 */
	public boolean excluirEpisodioFiltradoPorDia(String usuarioFiltro, int dia,
			String mesAnoFiltro) {
		// usado por ControleDados
		boolean achou = false, apagou = false;
		int qtdEpisodio = BancoDeDadosEpisodio.getQtdBDEpisodio();
		Episodio[] bdEpisodio = BancoDeDadosEpisodio.getBdEpisodio();
		int indiceEpisodioDiaExcluir = 0;
		for (int i = 0; i < qtdEpisodio; i++) {
			if (bdEpisodio[i].getUsuario().compareTo(usuarioFiltro) == 0
					&& bdEpisodio[i].getDataInicioDia() == dia
					&& bdEpisodio[i].getDataInicioMesAno().compareTo(mesAnoFiltro) == 0) {
				indiceEpisodioDiaExcluir = i;
				achou = true;
				i = qtdEpisodio;
			}
		}
		if (achou == true) {
			excluirEpisodioDeUmIndiceEspecifico(indiceEpisodioDiaExcluir);
			apagou = true;
		}
		return apagou;
	}

	// ===================================================================================
	/**
	 * Metodo para obter um array, apos comparar todos os usarios do banco de dados,
	 * contendo somente os usuarios que nao forem repetidos
	 * 
	 * @return usuariosUnicos retorna um array com usuarios nao repetidos
	 */
	public static String[] gerarArrayComUsuariosUnicos() {
		// array usuarios - todos instanciados inclusive repetidos
		String[] usuarios = new String[100];
		// array usuariosUnicos - todos instanciados retirando repetidos
		String[] usuariosUnicos = new String[100];
		int k = 0;
		boolean achou_igual = false;
		// array como todos episodios instanciados
		int qtdBDEpisodio = BancoDeDadosEpisodio.getQtdBDEpisodio();
		Episodio[] bdEpisodio = BancoDeDadosEpisodio.getBdEpisodio();
		// rotina para tirar repetidos
		usuariosUnicos[0] = "/0";
		for (int i = 0; i < qtdBDEpisodio; i++) {
			usuarios[i] = bdEpisodio[i].getUsuario();
			achou_igual = false;
			for (int j = 0; j <= k; j++) {
				if (usuariosUnicos[j] == usuarios[i])
					achou_igual = true;
			}
			if (achou_igual == false) {
				usuariosUnicos[k] = usuarios[i];
				k = k + 1;
			}
		}
		return usuariosUnicos;
	}
}
//Fim da classe Episodio
//=======================================================================================