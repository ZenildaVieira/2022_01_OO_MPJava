//==========================================================================
package controle;

//==========================================================================
import modelo.BancoDeDadosEpisodio;
import modelo.Episodio;
import modelo.EpisodioDiaOuMesEspecifico;

//==========================================================================
/**
 * Classe que contem os metodos que permitem calcular informacoes de quais os
 * tipo de dor mais comum, gatilho mais comum, local mais comum e medicamento
 * mais comum, assim como a duracao media e a intensidade media dos episodios
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 *
 */
public class ControleDados {
	// ===================================================================================
	private Episodio episodioDia;
	private int indiceEpisodioDia;
	private int qtdEpisodioTotal;
	private int qtdEpisodiosMes;
	private double duracaoMedia;
	private double intensidadeMedia;
	private String tipoDorMaisComum;
	private String gatilhoMaisComum;
	private String medicMaisComum;
	private String localMaisComum;
	private String sintomaMaisComum;
	private int qtdTipoDorMaisComum;
	private int qtdGatilhoMaisComum;
	private int qtdMedicMaisComum;
	private int qtdLocalMaisComum;
	private int qtdSintomaMaisComum;
	// ===================================================================================
	private EpisodioDiaOuMesEspecifico episodioDiaOuMesEspecifico = new EpisodioDiaOuMesEspecifico();

	// ===================================================================================
	/**
	 * Construtor
	 * 
	 */
	public ControleDados() {
		super();
	}

	// ===================================================================================
	/**
	 * Instancia varios exemplos para simular um banco de dados
	 * 
	 */
	public void carregarBancoDeDados() {
		// usado por TelaPrincipalResumo
		new BancoDeDadosEpisodio();
	}

	// ===================================================================================
	/**
	 * Metodo para calcular quantidade de episodios, duracao media, intensidade
	 * media por usuario e mes.
	 * 
	 * @param usuario usuario a ser usado na busca
	 * @param mesAno  mes e ano a ser usado na busca
	 * 
	 */
	public void calcularDadosResumo(String usuario, String mesAno) {
		// usado por TelaPrincipalResumo
		// usado por TelaListagemEstudoDaDor
		// usado aqui
		// ===============================================================================
		// gera os dados da tela principal
		episodioDiaOuMesEspecifico.buscarEpisodiosMesEspecifico(usuario, mesAno);

		qtdEpisodioTotal = episodioDiaOuMesEspecifico.getQtdEpisodioTotal();
		qtdEpisodiosMes = episodioDiaOuMesEspecifico.getQtdEpisodioMes();

		duracaoMedia = episodioDiaOuMesEspecifico.calcularDuracaoMedia();
		intensidadeMedia = episodioDiaOuMesEspecifico.calcularIntensidadeMedia();
	}

	// ===================================================================================
	public int getQtdEpisodios() {
		return qtdEpisodioTotal;
	}

	public int getQtdEpisodiosMes() {
		// usado por TelaPrincipalResumo
		// usado por TelaListagemEstudoDaDor
		return qtdEpisodiosMes;
	}

	public double getDuracaoMedia() {
		// usado por TelaPrincipalResumo
		// usado por TelaListagemEstudoDaDor
		return duracaoMedia;
	}

	public double getIntensidadeMedia() {
		// usado por TelaPrincipalResumo
		// usado por TelaListagemEstudoDaDor
		return intensidadeMedia;
	}

	// ===================================================================================
	public String[] gerarArrayUsuariosUnicos() {
		// usado por TelaPrincipalResumo
		return Episodio.gerarArrayComUsuariosUnicos();
	}

	public String[] gerarArrayMesesAnosUnicos() {
		// usado por TelaPrincipalResumo
		return EpisodioDiaOuMesEspecifico.gerarArrayComMesAnoUnicos();
	}

	// ===================================================================================
	/**
	 * Metodo para calcular as informacoes de quais os tipo de dor mais comum,
	 * gatilho mais comum, local mais comum e medicamento mais comum, assim como a
	 * duracao media e a intensidade media dos episodios.
	 * 
	 * @param usuario usuario a ser usado na busca
	 * @param mesAno  mes e ano a ser usado na busca
	 * 
	 */
	public void calcularDadosRelatorioEstudoDaDor(String usuario, String mesAno) {
		// ===============================================================================
		// usado por TelaListagemEstudoDaDor
		// gera os dados da tela estudo da dor
		calcularDadosResumo(usuario, mesAno);

		episodioDiaOuMesEspecifico.calcularTipoDorMaisComum();
		tipoDorMaisComum = episodioDiaOuMesEspecifico.getTipoDorMaisComum();
		qtdTipoDorMaisComum = episodioDiaOuMesEspecifico.getQtdTipoDorMaisComum();

		episodioDiaOuMesEspecifico.calcularGatilhoMaisComum();
		gatilhoMaisComum = episodioDiaOuMesEspecifico.getGatilhoMaisComum();
		qtdGatilhoMaisComum = episodioDiaOuMesEspecifico.getQtdGatilhoMaisComum();

		episodioDiaOuMesEspecifico.calcularLocalMaisComum();
		localMaisComum = episodioDiaOuMesEspecifico.getLocalMaisComum();
		qtdLocalMaisComum = episodioDiaOuMesEspecifico.getQtdLocalMaisComum();

		episodioDiaOuMesEspecifico.calcularMedicMaisComum();
		medicMaisComum = episodioDiaOuMesEspecifico.getMedicMaisComum();
		qtdMedicMaisComum = episodioDiaOuMesEspecifico.getQtdMedicMaisComum();

		episodioDiaOuMesEspecifico.calcularSintomaMaisComum();
		sintomaMaisComum = episodioDiaOuMesEspecifico.getSintomaMaisComum();
		qtdSintomaMaisComum = episodioDiaOuMesEspecifico.getQtdSintomaMaisComum();
	}

	// ===================================================================================
	/**
	 * Busca episodio que atende ao filtro especifico de usuario, dia e mes.
	 * 
	 * @param usuario usuario a ser usado na busca
	 * @param dia     dia a ser usado na busca
	 * @param mesAno  mes e ano a ser usado na busca
	 * 
	 * @return achou retorna verdadeiro se o episodio foi encontrado
	 * 
	 */
	public boolean buscarEpisodioFiltradoPorDia(String usuario, int dia, String mesAno) {
		// usado por ControleDados
		// usado por TelaListagemEpisodios
		// ===============================================================================
		// gera os dados da tela principal
		boolean achou = episodioDiaOuMesEspecifico.buscarEpisodioDia(usuario, dia,
				mesAno);
		qtdEpisodioTotal = episodioDiaOuMesEspecifico.getQtdEpisodioTotal();
		episodioDia = episodioDiaOuMesEspecifico.getEpisodioDia();
		indiceEpisodioDia = episodioDiaOuMesEspecifico.getIndiceEpisodioDia();
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
	public void buscarEpisodioFiltradoPorIndice(int indiceEpisodio) {
		// ===============================================================================
		// usado por ControleDados
		// usado por TelaListagemEpisodios
		// gera os dados da tela principal
		episodioDiaOuMesEspecifico.buscarEpisodioDia(indiceEpisodio);
		qtdEpisodioTotal = episodioDiaOuMesEspecifico.getQtdEpisodioTotal();
		episodioDia = episodioDiaOuMesEspecifico.getEpisodioDia();
		indiceEpisodioDia = indiceEpisodio;
	}

	// ===================================================================================
	/**
	 * Exclui instancia existente de episodio filtrado por usuario e data especifica
	 * do banco de dados
	 * 
	 * @return apagou retorna verdadeiro se o episodio foi encontrado e excluido
	 * 
	 * @param usuario usuario a ser usado na busca
	 * @param dia     dia a ser usado na busca
	 * @param mesAno  mes e ano a ser usado na busca
	 * 
	 */
	public boolean excluirEpisodioFiltradoPorDia(String usuario, int dia, String mesAno) {
		// usado por TelaListagemEpisodios
		boolean apagou = episodioDiaOuMesEspecifico.excluirEpisodioFiltradoPorDia(usuario,
				dia, mesAno);
		qtdEpisodioTotal = episodioDiaOuMesEspecifico.getQtdEpisodioTotal();
		episodioDiaOuMesEspecifico.setIndiceEpisodioDia(0);
		episodioDiaOuMesEspecifico.buscarEpisodioDia(0);
		episodioDia = episodioDiaOuMesEspecifico.getEpisodioDia();
		indiceEpisodioDia = episodioDiaOuMesEspecifico.getIndiceEpisodioDia();
		return apagou;
	}

	// ===================================================================================
	public int getIndiceEpisodioDia() {
		// usado por TelaListagemEpisodios
		// usado por ControleCadastroEpisodio
		indiceEpisodioDia = episodioDiaOuMesEspecifico.getIndiceEpisodioDia();
		return indiceEpisodioDia;
	}

	public void setIndiceEpisodioDia(int indiceEpisodiosDia) {
		// usado por TelaListagemEpisodios
		this.indiceEpisodioDia = indiceEpisodiosDia;
		episodioDiaOuMesEspecifico.setIndiceEpisodioDia(indiceEpisodiosDia);
	}

	public Episodio getEpisodioDia() {
		// usado por TelaListagemEpisodios
		episodioDia = episodioDiaOuMesEspecifico.getEpisodioDia();
		return episodioDia;
	}

	public void setEpisodioDia(Episodio episodioDia) {
		// usado por ControleCadastroEpisodio
		this.episodioDia = episodioDia;
		episodioDiaOuMesEspecifico.setEpisodioDia(episodioDia);
	}

	// ===================================================================================
	public int getQtdTipoDorMaisComum() {
		// usado por TelaListagemEstudoDaDor
		return qtdTipoDorMaisComum;
	}

	public int getQtdGatilhoMaisComum() {
		// usado por TelaListagemEstudoDaDor
		return qtdGatilhoMaisComum;
	}

	public int getQtdMedicMaisComum() {
		// usado por TelaListagemEstudoDaDor
		return qtdMedicMaisComum;
	}

	public int getQtdLocalMaisComum() {
		// usado por TelaListagemEstudoDaDor
		return qtdLocalMaisComum;
	}

	public int getQtdSintomaMaisComum() {
		// usado por TelaListagemEstudoDaDor
		return qtdSintomaMaisComum;
	}

	public String getTipoDorMaisComum() {
		// usado por TelaListagemEstudoDaDor
		return tipoDorMaisComum;
	}

	public String getGatilhoMaisComum() {
		// usado por TelaListagemEstudoDaDor
		return gatilhoMaisComum;
	}

	public String getMedicMaisComum() {
		// usado por TelaListagemEstudoDaDor
		return medicMaisComum;
	}

	public String getLocalMaisComum() {
		// usado por TelaListagemEstudoDaDor
		return localMaisComum;
	}

	public String getSintomaMaisComum() {
		// usado por TelaListagemEstudoDaDor
		return sintomaMaisComum;
	}
	// ===================================================================================

}
// =======================================================================================
