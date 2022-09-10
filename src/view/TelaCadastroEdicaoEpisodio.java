//========================================================================================
package view;

//========================================================================================
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleCadastroEpisodio;
import controle.ControleCadastroNomeCaracteristica;
import modelo.Episodio;

// =======================================================================================
/**
 * Tela de cadastro de um novo episodio de enxaqueca com campos para serem
 * preenchidos, listas para escolher valores, radiobuttons para escolher opcoes
 * e botoes para limpar, salvar ou cancelar.
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 *
 */
public class TelaCadastroEdicaoEpisodio implements ActionListener, ListSelectionListener {
	// ===================================================================================
	// Declara e cria um conteiner JFrame chamado jfrmJanela
	static JFrame jfrmJanela = new JFrame(
			"Cadastro de novo episodioTodos de dor de cabeca");
	// ===================================================================================
	// Declara e cria arrays e as caixas de selecao
	// para os valores do campo tipoDor do episodio a ser cadastrado
	private static JList<String> jlstTipoDor;
	private static JScrollPane jscrlpTipoDor;
	private String[] arrayTipoDor = new String[50];
	// para os valores do campo gatilho da dor do episodio a ser cadastrado
	private static JList<String> jlstGatilho;
	private static JScrollPane jscrlpGatilho;
	private String[] arrayGatilho = new String[50];
	// para os valores do campo local da dor do episodio a ser cadastrado
	private static JList<String> jlstLocal;
	private static JScrollPane jscrlpLocal;
	private String[] arrayLocal = new String[50];
	// para os valores do campo gatilho da dor do episodio a ser cadastrado
	private static JList<String> jlstNomeMedic;
	private static JScrollPane jscrlpNomeMedic;
	private String[] arrayNomeMedic = new String[50];
	// ===================================================================================
	// Declara e cria os radioButtons
	// para os valores do campo sintoma da dor do episodioTodos a ser cadastrado
	private static JRadioButton jrbSint1 = new JRadioButton("Nausea", false);
	private static JRadioButton jrbSint2 = new JRadioButton("Aurea", false);
	private static JRadioButton jrbSint3 = new JRadioButton("Vomito", false);
	private static JRadioButton jrbSint4 = new JRadioButton("Nenhum", false);
	// para os valores do campo eficiencia do medicamento usado no episodioTodos
	private static JRadioButton jrbEfic1 = new JRadioButton("Sim", false);
	private static JRadioButton jrbEfic2 = new JRadioButton("Nao", false);
	private static JRadioButton jrbEfic3 = new JRadioButton("Um pouco", false);
	// para agrupar os radio button e permitir somente uma escolha
	private ButtonGroup groupSint = new ButtonGroup();
	private ButtonGroup groupEfic = new ButtonGroup();
	// ===================================================================================
	// Declara e cria os r�tulos contendo os textos explicativos
	private JLabel jlabUsuario = new JLabel("Entre com o usuario:");
	private JLabel jlabDataInicio = new JLabel(
			"Entre com a data de inicio da dor (dd/mm/aaaa):");
	private JLabel jlabDataInicio1 = new JLabel("/");
	private JLabel jlabDataInicio2 = new JLabel("/");
	private JLabel jlabHoraInicio = new JLabel("Hora (hh:mm):");
	private JLabel jlabHoraInicio1 = new JLabel(":");
	private JLabel jlabDuracaoHoras = new JLabel(
			"Entre com a duracao da dor (em horas):");
	private JLabel jlabTipoDor = new JLabel("Escolha o tipo da dor:");
	private JLabel jlabSintoma = new JLabel("Sintoma associado (o mais forte):");
	private JLabel jlabGatilho = new JLabel("Escolha o gatilho da dor:");
	private JLabel jlabLocal = new JLabel("Escolha a localizacao da dor:");
	private JLabel jlabIntensid = new JLabel("Entre com a intensidade da dor (0 a 9):");
	private JLabel jlabNomeMedic = new JLabel("Escolha o medicamento utilizado:");
	private JLabel jlabEfic = new JLabel("O medicamento funcionou?");
	private JLabel jlabNotas = new JLabel("Entre com observacoes:");
	// ===================================================================================
	// Declara e cria os campos de texto para serem preenchidos
	private static JTextField jtfUsuario = new JTextField("Nome do usuario");
	private static JTextField jtfDataInicioDia = new JTextField("01");
	private static JTextField jtfDataInicioMes = new JTextField("01");
	private static JTextField jtfDataInicioAno = new JTextField("2022");
	private static JTextField jtfHoraInicioHora = new JTextField("00");
	private static JTextField jtfHoraInicioMin = new JTextField("00");
	private static JTextField jtfDuracaoHoras = new JTextField("0");
	private static JTextField jtfIntensid = new JTextField("0");
	private static JTextField jtfNotas = new JTextField("Observacoes");
	// ===================================================================================
	// Declara e cria uma mensagem para testes de localizacao
	private JLabel jlabMensagem = new JLabel("", JLabel.CENTER);
	// ===================================================================================
	// Declara e cria os botoes de salvar e cancelar
	private JButton jbtnInserirTipoDor = new JButton("Inserir novo tipo");
	private JButton jbtnInserirGatilho = new JButton("Inserir novo gatilho");
	private JButton jbtnInserirLocal = new JButton("Inserir nova localizacao");
	private JButton jbtnInserirMedic = new JButton("Inserir novo medicamento");
	private JButton jbtnLimpar = new JButton("Limpar");
	private JButton jbtnCadastrarNovo = new JButton("Cadastrar como novo");
	private JButton jbtnSalvarEdicao = new JButton("Salvar dados editados");
	private JButton jbtnCancelarEdicao = new JButton("Ir para tela de episodios");
	private JButton jbtnVoltarPrincipal = new JButton("Ir para tela principal");
	// ===================================================================================
	// Declara e instancia controleCadNome atualizando os dados
	// ===================================================================================
	private static ControleCadastroNomeCaracteristica controleCadNome = new ControleCadastroNomeCaracteristica();
	private ControleCadastroEpisodio controleCadEpisodio = new ControleCadastroEpisodio();
	// ===================================================================================
	// Declara variaveis que vao receber os valores digitados e escolhidos
	private String valorUsuario;
	private String valorDataInicioDia;
	private String valorDataInicioMes;
	private String valorDataInicioAno;
	private String valorDataInicioMesAno;
	private String valorHoraInicioHora;
	private String valorHoraInicioMin;
	private String valorDuracaoHoras;
	private String valorSintoma;
	private String valorEficiencia;
	private String valorIntensid;
	private String valorNotas;
	private int indiceNomeTipoDor;
	private int indiceNomeGatilho;
	private int indiceNomeLocal;
	private int indiceNomeMedic;

	// ===================================================================================
	/**
	 * Configura o frame e adiciona os componentes.
	 * 
	 */
	public TelaCadastroEdicaoEpisodio() {
		// ===============================================================================
		// Configura a janela
		jfrmJanela.setLayout(null); // seta layout como null para posicionar os elementos
		jfrmJanela.setBounds(200, 100, 1070, 480); // local inicial do quadro e o tamanho
		// nao encerra o app so fecha a janela
		jfrmJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// ===============================================================================
		// Captura das instancias do banco de dados em array
		arrayTipoDor = controleCadNome.gerarArrayNomeCaracteristica("Tipo");
		arrayGatilho = controleCadNome.gerarArrayNomeCaracteristica("Gatilho");
		arrayLocal = controleCadNome.gerarArrayNomeCaracteristica("Local");
		arrayNomeMedic = controleCadNome.gerarArrayNomeCaracteristica("Medic");
		// Atribuicao dos arrays aos Jlists
		jlstTipoDor = new JList<String>(arrayTipoDor);
		jlstGatilho = new JList<String>(arrayGatilho);
		jlstLocal = new JList<String>(arrayLocal);
		jlstNomeMedic = new JList<String>(arrayNomeMedic);
		// Atribuicao dos JLists aos JScrollPanes
		jscrlpTipoDor = new JScrollPane(jlstTipoDor);
		jscrlpGatilho = new JScrollPane(jlstGatilho);
		jscrlpLocal = new JScrollPane(jlstLocal);
		jscrlpNomeMedic = new JScrollPane(jlstNomeMedic);
		// Selecao unica para os JLists
		jlstTipoDor.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlstGatilho.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlstLocal.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlstNomeMedic.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		// ===============================================================================
		jlabMensagem.setText(
				"*******    *******    *******    ***** ** *****    *******    *******    ******");
		// ===============================================================================
		// Posiciona e dimensiona os componentes ao frame - x, y, largura, altura
		jlabUsuario.setBounds(30, 20, 240, 20);
		jtfUsuario.setBounds(290, 20, 240, 20);
		jlabDataInicio.setBounds(30, 50, 255, 20);
		jtfDataInicioDia.setBounds(290, 50, 20, 20);
		jlabDataInicio1.setBounds(313, 50, 3, 20);
		jtfDataInicioMes.setBounds(322, 50, 20, 20);
		jlabDataInicio2.setBounds(345, 50, 3, 20);
		jtfDataInicioAno.setBounds(352, 50, 34, 20);
		jlabHoraInicio.setBounds(394, 50, 86, 20);
		jtfHoraInicioHora.setBounds(481, 50, 20, 20);
		jlabHoraInicio1.setBounds(505, 50, 3, 20);
		jtfHoraInicioMin.setBounds(511, 50, 20, 20);
		jlabDuracaoHoras.setBounds(30, 80, 240, 20);
		jtfDuracaoHoras.setBounds(290, 80, 240, 20);
		jlabSintoma.setBounds(30, 110, 205, 20);
		jrbSint1.setBounds(240, 110, 70, 20);
		jrbSint2.setBounds(315, 110, 66, 20);
		jrbSint3.setBounds(386, 110, 70, 20);
		jrbSint4.setBounds(461, 110, 74, 20);
		jlabIntensid.setBounds(30, 140, 240, 20);
		jtfIntensid.setBounds(290, 140, 240, 20);
		jlabNomeMedic.setBounds(30, 170, 240, 20);
		jscrlpNomeMedic.setBounds(290, 170, 240, 90);
		jbtnInserirMedic.setBounds(50, 200, 190, 25);
		jlabEfic.setBounds(30, 270, 240, 20);
		jrbEfic1.setBounds(290, 270, 55, 20);
		jrbEfic2.setBounds(365, 270, 55, 20);
		jrbEfic3.setBounds(440, 270, 90, 20);
		jlabNotas.setBounds(30, 300, 240, 20);
		jtfNotas.setBounds(290, 300, 240, 60);
		jlabTipoDor.setBounds(560, 20, 200, 20);
		jscrlpTipoDor.setBounds(780, 20, 240, 90);
		jbtnInserirTipoDor.setBounds(580, 50, 170, 25);
		jlabGatilho.setBounds(560, 120, 200, 20);
		jscrlpGatilho.setBounds(780, 120, 240, 90);
		jbtnInserirGatilho.setBounds(580, 150, 170, 25);
		jlabLocal.setBounds(560, 220, 200, 20);
		jscrlpLocal.setBounds(780, 220, 240, 90);
		jbtnInserirLocal.setBounds(580, 250, 170, 25);
		jbtnLimpar.setBounds(30, 380, 180, 25);
		jbtnSalvarEdicao.setBounds(230, 380, 180, 25);
		jbtnCadastrarNovo.setBounds(430, 380, 180, 25);
		jbtnVoltarPrincipal.setBounds(630, 380, 180, 25);
		jbtnCancelarEdicao.setBounds(830, 380, 180, 25);
		jlabMensagem.setBounds(560, 330, 450, 20);
		// ===============================================================================
		// Configuracao das mensagens - tipo, cor e tamanho da fonte
		jlabMensagem.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		jlabMensagem.setForeground(Color.red);
		// ===============================================================================
		// Agrupa os radiobutoons de Sintomas para permitir somente uma escolha
		groupSint.add(jrbSint1);
		groupSint.add(jrbSint2);
		groupSint.add(jrbSint3);
		groupSint.add(jrbSint4);
		// ===============================================================================
		// Agrupa os radiobutoons de Eficiencia para permitir somente uma escolha
		groupEfic.add(jrbEfic1);
		groupEfic.add(jrbEfic2);
		groupEfic.add(jrbEfic3);
		// ===============================================================================
		// Adiciona os componentes ao frame
		jfrmJanela.add(jlabUsuario);
		jfrmJanela.add(jtfUsuario);
		jfrmJanela.add(jlabDataInicio);
		jfrmJanela.add(jtfDataInicioDia);
		jfrmJanela.add(jlabDataInicio1);
		jfrmJanela.add(jtfDataInicioMes);
		jfrmJanela.add(jlabDataInicio2);
		jfrmJanela.add(jtfDataInicioAno);
		jfrmJanela.add(jlabHoraInicio);
		jfrmJanela.add(jtfHoraInicioHora);
		jfrmJanela.add(jlabHoraInicio1);
		jfrmJanela.add(jtfHoraInicioMin);
		jfrmJanela.add(jlabDuracaoHoras);
		jfrmJanela.add(jtfDuracaoHoras);
		jfrmJanela.add(jlabTipoDor);
		jfrmJanela.add(jscrlpTipoDor);
		jfrmJanela.add(jlabSintoma);
		jfrmJanela.add(jrbSint1);
		jfrmJanela.add(jrbSint2);
		jfrmJanela.add(jrbSint3);
		jfrmJanela.add(jrbSint4);
		jfrmJanela.add(jlabGatilho);
		jfrmJanela.add(jscrlpGatilho);
		jfrmJanela.add(jlabLocal);
		jfrmJanela.add(jscrlpLocal);
		jfrmJanela.add(jlabIntensid);
		jfrmJanela.add(jtfIntensid);
		jfrmJanela.add(jlabNomeMedic);
		jfrmJanela.add(jscrlpNomeMedic);
		jfrmJanela.add(jlabEfic);
		jfrmJanela.add(jrbEfic1);
		jfrmJanela.add(jrbEfic2);
		jfrmJanela.add(jrbEfic3);
		jfrmJanela.add(jlabNotas);
		jfrmJanela.add(jtfNotas);
		jfrmJanela.add(jbtnInserirMedic);
		jfrmJanela.add(jbtnInserirTipoDor);
		jfrmJanela.add(jbtnInserirGatilho);
		jfrmJanela.add(jbtnInserirLocal);
		jfrmJanela.add(jbtnCadastrarNovo);
		jfrmJanela.add(jbtnSalvarEdicao);
		jfrmJanela.add(jbtnLimpar);
		jfrmJanela.add(jbtnCancelarEdicao);
		jfrmJanela.add(jbtnVoltarPrincipal);
		jfrmJanela.add(jlabMensagem);
		// ===============================================================================
		// Torna visivel o frame configurado
		jfrmJanela.setVisible(true);
		// ===============================================================================
		// escuta os botoes
		jbtnInserirMedic.addActionListener(this);
		jbtnInserirTipoDor.addActionListener(this);
		jbtnInserirGatilho.addActionListener(this);
		jbtnInserirLocal.addActionListener(this);
		jbtnCadastrarNovo.addActionListener(this);
		jbtnSalvarEdicao.addActionListener(this);
		jbtnCancelarEdicao.addActionListener(this);
		jbtnLimpar.addActionListener(this);
		jbtnVoltarPrincipal.addActionListener(this);
		// escuta as listas
		jlstTipoDor.addListSelectionListener(this);
		jlstGatilho.addListSelectionListener(this);
		jlstLocal.addListSelectionListener(this);
		jlstNomeMedic.addListSelectionListener(this);
		// escuta os radios buttons
		jrbSint1.addActionListener(this);
		jrbSint2.addActionListener(this);
		jrbSint3.addActionListener(this);
		jrbSint4.addActionListener(this);
		jrbEfic1.addActionListener(this);
		jrbEfic2.addActionListener(this);
		jrbEfic3.addActionListener(this);
		// ===============================================================================
		limparDadosTela();
	}

	// ===================================================================================
	/**
	 * Atualiza a lista de escolhas do usuario.
	 * 
	 */
	public static void atualizarJList() {
		jlstTipoDor.setListData(controleCadNome.gerarArrayNomeCaracteristica("Tipo"));
		jlstGatilho.setListData(controleCadNome.gerarArrayNomeCaracteristica("Gatilho"));
		jlstLocal.setListData(controleCadNome.gerarArrayNomeCaracteristica("Local"));
		jlstNomeMedic.setListData(controleCadNome.gerarArrayNomeCaracteristica("Medic"));
	}

	// ===================================================================================
	/**
	 * Armazena valores digitados e escolhidos pelo usuario nas variaveis internas.
	 * 
	 */
	public void capturarDadosTela() {
		// ===================================================================================
		// Captura os valores preenchidos nos campos de texto
		valorUsuario = jtfUsuario.getText();
		valorDataInicioDia = jtfDataInicioDia.getText();
		valorDataInicioMes = jtfDataInicioMes.getText();
		valorDataInicioAno = jtfDataInicioAno.getText();
		valorDataInicioMesAno = valorDataInicioMes + "_" + valorDataInicioAno;
		valorHoraInicioHora = jtfHoraInicioHora.getText();
		valorHoraInicioMin = jtfHoraInicioMin.getText();
		valorDuracaoHoras = jtfDuracaoHoras.getText();
		valorIntensid = jtfIntensid.getText();
		valorNotas = jtfNotas.getText();
		indiceNomeTipoDor = jlstTipoDor.getSelectedIndex();
		indiceNomeGatilho = jlstGatilho.getSelectedIndex();
		indiceNomeLocal = jlstLocal.getSelectedIndex();
		indiceNomeMedic = jlstNomeMedic.getSelectedIndex();
		if (jrbSint1.isSelected())
			valorSintoma = "Nausea";
		if (jrbSint2.isSelected())
			valorSintoma = "Aurea";
		if (jrbSint3.isSelected())
			valorSintoma = "Vomito";
		if (jrbSint4.isSelected())
			valorSintoma = "Nenhum";
		if (jrbEfic1.isSelected())
			valorEficiencia = "Sim";
		if (jrbEfic2.isSelected())
			valorEficiencia = "Nao";
		if (jrbEfic3.isSelected())
			valorEficiencia = "Um pouco";
	}

	// ===================================================================================
	/**
	 * Apaga os dados inseridos e retorna para os valores padrao.
	 * 
	 */
	public void limparDadosTela() {
		jtfUsuario.setText("Nome do usuario");
		jtfDataInicioDia.setText("01");
		jtfDataInicioMes.setText("01");
		jtfDataInicioAno.setText("2022");
		jtfHoraInicioHora.setText("00");
		jtfHoraInicioMin.setText("00");
		jtfDuracaoHoras.setText("0");
		jtfIntensid.setText("0");
		jtfNotas.setText("Observacoes");
		jlstTipoDor.setSelectedIndex(0);
		jlstGatilho.setSelectedIndex(0);
		jlstLocal.setSelectedIndex(0);
		jlstNomeMedic.setSelectedIndex(0);
		jrbSint4.setSelected(true);
		jrbEfic1.setSelected(true);
	}

	// ===================================================================================
	/**
	 * Preenche a tela com os dados do episodio que sera editado.
	 * 
	 * @param episodioDia instancia de episodio que sera editada
	 */
	public static void preencherEpisodioDia(Episodio episodioDia) {
		jtfUsuario.setText(episodioDia.getUsuario());
		int dia = episodioDia.getDataInicioDia();
		String strDia = String.valueOf(dia);
		if (dia < 10)
			strDia = "0" + String.valueOf(dia);
		int mes = episodioDia.getDataInicioMes();
		String strMes = String.valueOf(mes);
		if (mes < 10)
			strMes = "0" + String.valueOf(mes);
		int hora = episodioDia.getDataInicioHora();
		String strHora = String.valueOf(hora);
		if (hora < 10)
			strHora = "0" + String.valueOf(hora);
		int min = episodioDia.getDataInicioMinuto();
		String strMin = String.valueOf(min);
		if (min < 10)
			strMin = "0" + String.valueOf(min);
		jtfDataInicioDia.setText(strDia);
		jtfDataInicioMes.setText(strMes);
		jtfDataInicioAno.setText(String.valueOf(episodioDia.getDataInicioAno()));
		jtfHoraInicioHora.setText(strHora);
		jtfHoraInicioMin.setText(strMin);
		jtfDuracaoHoras.setText(String.valueOf(episodioDia.getDuracaoHoras()));
		jtfIntensid.setText(String.valueOf(episodioDia.getCaractDor().getIntensidade()));
		jtfNotas.setText(episodioDia.getObservacao());
		// ===============================================================================
		jlstTipoDor.setSelectedIndex(controleCadNome
				.buscarIndiceNomeTipoDor(episodioDia.getCaractDor().getTipoDor()));
		jlstGatilho.setSelectedIndex(controleCadNome
				.buscarIndiceNomeGatilho(episodioDia.getCaractDor().getGatilho()));
		jlstLocal.setSelectedIndex(controleCadNome
				.buscarIndiceNomeLocal((episodioDia.getCaractDor().getLocal())));
		jlstNomeMedic.setSelectedIndex(controleCadNome
				.buscarIndiceNomeMedic(episodioDia.getCaractMedic().getNomeMedic()));
		// ===============================================================================
		if (episodioDia.getCaractDor().getSintoma() == "Nausea")
			jrbSint1.setSelected(true);
		if (episodioDia.getCaractDor().getSintoma() == "Aurea")
			jrbSint2.setSelected(true);
		if (episodioDia.getCaractDor().getSintoma() == "Vomito")
			jrbSint3.setSelected(true);
		if (episodioDia.getCaractDor().getSintoma() == "Nenhum")
			jrbSint4.setSelected(true);
		if (episodioDia.getCaractMedic().getEficiencia() == "Sim")
			jrbEfic1.setSelected(true);
		if (episodioDia.getCaractMedic().getEficiencia() == "Nao")
			jrbEfic2.setSelected(true);
		if (episodioDia.getCaractMedic().getEficiencia() == "Um pouco")
			jrbEfic3.setSelected(true);

	}

	// ===================================================================================
	/**
	 * Rotinas a serem executadas quando o Listener for ativado por algum evento.
	 * Sobrescrita.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// descobre o botao que foi clicado e armazena em jbtnFonte
		Object jbtnFonte = ae.getSource();
		// se clicar em inserir medicamento abre a tela para CRUD completo
		if (jbtnFonte == jbtnInserirMedic) {
			jfrmJanela.setVisible(false);
			new TelaCadastroNomeCaracteristica("Medic");
		}
		// se clicar em inserir medicamento abre a tela para CRUD completo
		if (jbtnFonte == jbtnInserirTipoDor) {
			jfrmJanela.setVisible(false);
			new TelaCadastroNomeCaracteristica("Tipo");
		}
		// se clicar em inserir medicamento abre a tela para CRUD completo
		if (jbtnFonte == jbtnInserirGatilho) {
			jfrmJanela.setVisible(false);
			new TelaCadastroNomeCaracteristica("Gatilho");
		}
		// se clicar em inserir medicamento abre a tela para CRUD completo
		if (jbtnFonte == jbtnInserirLocal) {
			jfrmJanela.setVisible(false);
			new TelaCadastroNomeCaracteristica("Local");
		}
		// se clicar em algum radio button atualiza variaveis
		if (jbtnFonte == jrbSint1)
			valorSintoma = "Nausea";
		if (jbtnFonte == jrbSint2)
			valorSintoma = "Aurea";
		if (jbtnFonte == jrbSint3)
			valorSintoma = "Vomito";
		if (jbtnFonte == jrbSint4)
			valorSintoma = "Nenhum";
		if (jbtnFonte == jrbEfic1)
			valorEficiencia = "Sim";
		if (jbtnFonte == jrbEfic2)
			valorEficiencia = "Nao";
		if (jbtnFonte == jrbEfic3)
			valorEficiencia = "Um pouco";
		// se clicar em limpar apaga valores escolhidos e digitados e volta para o
		// padrao
		if (jbtnFonte == jbtnLimpar) {
			limparDadosTela();
		}
		// se clicar em cadastrar, verifica entradas e insere novo episodio
		if (jbtnFonte == jbtnCadastrarNovo) {
			// ===================================================================================
			// Captura os valores preenchidos nos campos de texto
			capturarDadosTela();
			// verifica validade dos valores preenchidos nos campos de texto
			if (valorUsuario.isEmpty() || valorDataInicioDia.isEmpty()
					|| valorDataInicioMes.isEmpty() || valorDataInicioAno.isEmpty()
					|| valorHoraInicioHora.isEmpty() || valorHoraInicioMin.isEmpty()
					|| valorDuracaoHoras.isEmpty() || valorIntensid.isEmpty()
					|| groupSint.getSelection() == null
					|| groupEfic.getSelection() == null
					|| jlstTipoDor.getSelectedIndex() == -1
					|| jlstGatilho.getSelectedIndex() == -1
					|| jlstLocal.getSelectedIndex() == -1
					|| jlstNomeMedic.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null,
						"Entre com os dados, nenhum campo pode ficar vazio ou sem selecao",
						null, JOptionPane.ERROR_MESSAGE);
			} else if (!ControleCadastroEpisodio.testeDataValida(valorDataInicioDia,
					valorDataInicioMes, valorDataInicioAno)) {
				JOptionPane.showMessageDialog(null, "Data invalida, digite novamente",
						null, JOptionPane.ERROR_MESSAGE);
			} else if (!ControleCadastroEpisodio.testeHoraValida(valorHoraInicioHora,
					valorHoraInicioMin)) {
				JOptionPane.showMessageDialog(null, "Hora invalida, digite novamente",
						null, JOptionPane.ERROR_MESSAGE);
			} else if (!ControleCadastroEpisodio
					.testeDuracaoHorasValida(valorDuracaoHoras)) {
				JOptionPane.showMessageDialog(null,
						"Duracao em horas invalida, digite um numero inteiro", null,
						JOptionPane.ERROR_MESSAGE);
			} else if (!ControleCadastroEpisodio.testeIntensidadeValida(valorIntensid)) {
				JOptionPane.showMessageDialog(null,
						"Intensidade da dor invalida, digite um numero inteiro", null,
						JOptionPane.ERROR_MESSAGE);
			} else {
				// todos valores validados - insere novo episodio
				String msg = controleCadEpisodio.inserirNovoEpisodio(valorUsuario,
						Integer.parseInt(valorDataInicioDia),
						Integer.parseInt(valorDataInicioMes),
						Integer.parseInt(valorDataInicioAno), valorDataInicioMesAno,
						Integer.parseInt(valorHoraInicioHora),
						Integer.parseInt(valorHoraInicioMin),
						Integer.parseInt(valorDuracaoHoras), indiceNomeTipoDor,
						indiceNomeGatilho, indiceNomeLocal, valorSintoma,
						Integer.parseInt(valorIntensid), indiceNomeMedic, valorEficiencia,
						valorNotas);
				jlabMensagem.setText("Episodio cadastrado com sucesso!");
				System.out.println(msg);

			}
		}
		// se clicar em cancelar a edicao, volta para a listagem de episodios
		if (jbtnFonte == jbtnCancelarEdicao) {
			jfrmJanela.dispose();
			new TelaListagemEpisodios();

		}
		// se clicar em voltar a tela principal, volta para a principal e descarta
		// alteracoes
		if (jbtnFonte == jbtnVoltarPrincipal) {
			jfrmJanela.dispose();
			new TelaPrincipalResumo();
		}
		// se clicar em salvar a edicao, edita episodio e volta para tela de listagem de
		// episodios
		if (jbtnFonte == jbtnSalvarEdicao) {
			// Captura os valores preenchidos nos campos de texto
			capturarDadosTela();
			// edita episodio
			String msg = controleCadEpisodio.editarEpisodioDia(valorUsuario,
					Integer.parseInt(valorDataInicioDia),
					Integer.parseInt(valorDataInicioMes),
					Integer.parseInt(valorDataInicioAno), valorDataInicioMesAno,
					Integer.parseInt(valorHoraInicioHora),
					Integer.parseInt(valorHoraInicioMin),
					Integer.parseInt(valorDuracaoHoras), indiceNomeTipoDor,
					indiceNomeGatilho, indiceNomeLocal, valorSintoma,
					Integer.parseInt(valorIntensid), indiceNomeMedic, valorEficiencia,
					valorNotas);
			JOptionPane.showMessageDialog(null, "Episodio editado com sucesso!", null,
					JOptionPane.INFORMATION_MESSAGE);
			jlabMensagem.setText("");
			System.out.println(msg);
			jfrmJanela.dispose();
			new TelaListagemEpisodios();
		}
	}

	// ===================================================================================
	/**
	 * Captura eventos relacionados ao JList. Sobrescrita.
	 * 
	 */
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		Object src = lse.getSource();

		if (lse.getValueIsAdjusting() && src == jlstTipoDor)
			indiceNomeTipoDor = jlstTipoDor.getSelectedIndex();

		if (lse.getValueIsAdjusting() && src == jlstGatilho)
			indiceNomeGatilho = jlstGatilho.getSelectedIndex();

		if (lse.getValueIsAdjusting() && src == jlstLocal)
			indiceNomeLocal = jlstLocal.getSelectedIndex();

		if (lse.getValueIsAdjusting() && src == jlstNomeMedic)
			indiceNomeMedic = jlstNomeMedic.getSelectedIndex();

	}

	// ======================================================================

}
