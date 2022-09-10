package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controle.ControleDados;

//=======================================================================================
/**
 * Tela com informacoes sobre os episodios cadastrados. Traz informacoes de
 * quais os tipo de dor mais comum, gatilho mais comum, local mais comum e
 * medicamento mais comum, assim como a duracao media e a intensidade media dos
 * episodios. Permite filtrar por usuario e mes.
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 *
 */
public class TelaListagemEstudoDaDor implements ActionListener {
	// ===================================================================================
	// Declara e cria um conteiner JFrame chamado jfrmJanela
	private static JFrame jfrmJanela = new JFrame("Estudo da Dor");
	// ===================================================================================
	// Declara e cria os botoes
	private JButton jbtnVoltar = new JButton("Voltar");
	private JButton jbtnAtualizarFiltro = new JButton("Atualizar filtro");
	// ===================================================================================
	// Declara e cria mensagens da tela
	private JLabel jlabFiltro = new JLabel("Escolha");
	private JLabel jlabUsuarioFiltro = new JLabel("Usuario:");
	private JLabel jlabMesesAnosFiltro = new JLabel("Mes_Ano:");
	private JLabel jlabMsgUsuario = new JLabel("Usuario:");
	private JLabel jlabValorUsuario = new JLabel();
	private JLabel jlabMsgMesAno = new JLabel("Mes_Ano:");
	private JLabel jlabValorMesAno = new JLabel();
	private JLabel jlabMsgQtdEpisodiosMes = new JLabel("Dores de cabeca esse mes:");
	private JLabel jlabMsgDuracaoMedia = new JLabel("Duracao media:");
	private JLabel jlabMsgIntensidadeMedia = new JLabel("Intensidade media:");
	private JLabel jlabMsgTipoDorMaisComum = new JLabel("Tipo de dor mais comum:");
	private JLabel jlabValorTipoDorMaisComum = new JLabel();
	private JLabel jlabValorQtdTipoDorMaisComum = new JLabel();
	private JLabel jlabMsgGatilhoMaisComum = new JLabel("Gatilho mais comum:");
	private JLabel jlabValorGatilhoMaisComum = new JLabel();
	private JLabel jlabValorQtdGatilhoMaisComum = new JLabel();
	private JLabel jlabMsgMedicMaisComum = new JLabel("Medic mais comum:");
	private JLabel jlabValorMedicMaisComum = new JLabel();
	private JLabel jlabValorQtdMedicMaisComum = new JLabel();
	private JLabel jlabMsgLocalMaisComum = new JLabel("Local mais comum:");
	private JLabel jlabValorLocalMaisComum = new JLabel();
	private JLabel jlabValorQtdLocalMaisComum = new JLabel();
	private JLabel jlabMsgSintomaMaisComum = new JLabel("Sintoma mais comum:");
	private JLabel jlabValorSintomaMaisComum = new JLabel();
	private JLabel jlabValorQtdSintomaMaisComum = new JLabel();
	private static JLabel jlabValorQtdEpisodioMes = new JLabel();
	private static JLabel jlabValorDuracaoMedia = new JLabel();
	private static JLabel jlabValorIntensidadeMedia = new JLabel();
	// ===================================================================================
	// para os valores do filtro da consulta
	private static String[] arrayMesesAnos = new String[100];
	private static JList<String> jlstMesesAnos = new JList<String>(arrayMesesAnos);
	private static JScrollPane jscrlpMesesAnos = new JScrollPane(jlstMesesAnos);
	private static String[] arrayUsuarios = new String[100];
	private static JList<String> jlstUsuarios;
	private static JScrollPane jscrlpUsuarios;
	// ===================================================================================
	// Declara e instancia controleDados
	private static ControleDados controleDados = new ControleDados();

	// ===================================================================================
	/**
	 * Configura o frame e adiciona os componentes.
	 * 
	 */
	public TelaListagemEstudoDaDor() {
		// ===============================================================================
		// Configura a janela
		jfrmJanela.setLayout(null); // seta layout como null para posicionar os elementos
		jfrmJanela.setBounds(200, 100, 800, 430); // local inicial do quadro e o tamanho
		// nao encerra o app so fecha a janela
		jfrmJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// ===============================================================================
		// Captura das instancias do banco de dados em array
		arrayUsuarios = controleDados.gerarArrayUsuariosUnicos();
		arrayMesesAnos = controleDados.gerarArrayMesesAnosUnicos();
		// Atribuicao dos arrays aos Jlists
		jlstUsuarios = new JList<String>(arrayUsuarios);
		jlstMesesAnos = new JList<String>(arrayMesesAnos);
		// Atribuicao dos JLists aos JScrollPanes
		jscrlpUsuarios = new JScrollPane(jlstUsuarios);
		jscrlpMesesAnos = new JScrollPane(jlstMesesAnos);
		// ===============================================================================
		// Configuracao das JList - unica selecao por vez
		jlstUsuarios.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlstMesesAnos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlstUsuarios.setSelectedIndex(0);
		jlstMesesAnos.setSelectedIndex(0);
		// ===============================================================================
		// Posiciona e dimensiona os componentes ao frame - x, y, largura, altura
		jlabFiltro.setBounds(30, 20, 150, 20);
		jlabUsuarioFiltro.setBounds(30, 50, 150, 20);
		jscrlpUsuarios.setBounds(30, 80, 150, 75);
		jlabMesesAnosFiltro.setBounds(30, 165, 150, 20);
		jscrlpMesesAnos.setBounds(30, 195, 150, 75);
		jbtnAtualizarFiltro.setBounds(30, 290, 150, 25);
		jbtnVoltar.setBounds(30, 335, 150, 25);
		jlabMsgUsuario.setBounds(250, 20, 220, 20);
		jlabValorUsuario.setBounds(480, 20, 240, 20);
		jlabMsgMesAno.setBounds(250, 55, 220, 20);
		jlabValorMesAno.setBounds(480, 55, 240, 20);
		jlabMsgQtdEpisodiosMes.setBounds(250, 90, 220, 20);
		jlabValorQtdEpisodioMes.setBounds(480, 90, 240, 20);
		jlabMsgDuracaoMedia.setBounds(250, 125, 220, 20);
		jlabValorDuracaoMedia.setBounds(480, 125, 240, 20);
		jlabMsgIntensidadeMedia.setBounds(250, 160, 220, 20);
		jlabValorIntensidadeMedia.setBounds(480, 160, 240, 20);
		jlabMsgTipoDorMaisComum.setBounds(250, 195, 220, 20);
		jlabValorQtdTipoDorMaisComum.setBounds(480, 195, 30, 20);
		jlabValorTipoDorMaisComum.setBounds(520, 195, 240, 20);
		jlabMsgGatilhoMaisComum.setBounds(250, 230, 220, 20);
		jlabValorQtdGatilhoMaisComum.setBounds(480, 230, 30, 20);
		jlabValorGatilhoMaisComum.setBounds(520, 230, 240, 20);
		jlabMsgMedicMaisComum.setBounds(250, 265, 220, 20);
		jlabValorQtdMedicMaisComum.setBounds(480, 265, 30, 20);
		jlabValorMedicMaisComum.setBounds(520, 265, 240, 20);
		jlabMsgLocalMaisComum.setBounds(250, 300, 220, 20);
		jlabValorQtdLocalMaisComum.setBounds(480, 300, 30, 20);
		jlabValorLocalMaisComum.setBounds(520, 300, 240, 20);
		jlabMsgSintomaMaisComum.setBounds(250, 335, 220, 20);
		jlabValorQtdSintomaMaisComum.setBounds(480, 335, 30, 20);
		jlabValorSintomaMaisComum.setBounds(520, 335, 240, 20);
		// ===============================================================================
		// Configuracao das mensagens - tipo, cor e tamanho da fonte
		jlabFiltro.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		jlabFiltro.setForeground(Color.blue);
		jlabUsuarioFiltro.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jlabUsuarioFiltro.setForeground(Color.blue);
		jlabMesesAnosFiltro.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jlabMesesAnosFiltro.setForeground(Color.blue);
		jlabMsgUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jlabMsgUsuario.setForeground(Color.blue);
		jlabMsgMesAno.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jlabMsgMesAno.setForeground(Color.blue);
		jlabMsgQtdEpisodiosMes.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jlabMsgQtdEpisodiosMes.setForeground(Color.blue);
		jlabMsgDuracaoMedia.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jlabMsgDuracaoMedia.setForeground(Color.blue);
		jlabMsgIntensidadeMedia.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jlabMsgIntensidadeMedia.setForeground(Color.blue);
		jlabMsgTipoDorMaisComum.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jlabMsgTipoDorMaisComum.setForeground(Color.blue);
		jlabMsgGatilhoMaisComum.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jlabMsgGatilhoMaisComum.setForeground(Color.blue);
		jlabMsgMedicMaisComum.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jlabMsgMedicMaisComum.setForeground(Color.blue);
		jlabMsgLocalMaisComum.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jlabMsgLocalMaisComum.setForeground(Color.blue);
		jlabMsgSintomaMaisComum.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jlabMsgSintomaMaisComum.setForeground(Color.blue);
		// ===============================================================================
		// Adiciona os componentes ao frame
		jfrmJanela.add(jlabFiltro);
		jfrmJanela.add(jlabUsuarioFiltro);
		jfrmJanela.add(jscrlpUsuarios);
		jfrmJanela.add(jlabMesesAnosFiltro);
		jfrmJanela.add(jscrlpMesesAnos);
		jfrmJanela.add(jlabMsgUsuario);
		jfrmJanela.add(jlabValorUsuario);
		jfrmJanela.add(jlabMsgMesAno);
		jfrmJanela.add(jlabValorMesAno);
		jfrmJanela.add(jlabMsgQtdEpisodiosMes);
		jfrmJanela.add(jlabValorQtdEpisodioMes);
		jfrmJanela.add(jlabMsgDuracaoMedia);
		jfrmJanela.add(jlabValorDuracaoMedia);
		jfrmJanela.add(jlabMsgIntensidadeMedia);
		jfrmJanela.add(jlabValorIntensidadeMedia);
		jfrmJanela.add(jbtnAtualizarFiltro);
		jfrmJanela.add(jlabMsgTipoDorMaisComum);
		jfrmJanela.add(jlabValorTipoDorMaisComum);
		jfrmJanela.add(jlabValorQtdTipoDorMaisComum);
		jfrmJanela.add(jlabMsgGatilhoMaisComum);
		jfrmJanela.add(jlabValorGatilhoMaisComum);
		jfrmJanela.add(jlabValorQtdGatilhoMaisComum);
		jfrmJanela.add(jlabMsgMedicMaisComum);
		jfrmJanela.add(jlabValorMedicMaisComum);
		jfrmJanela.add(jlabValorQtdMedicMaisComum);
		jfrmJanela.add(jlabMsgLocalMaisComum);
		jfrmJanela.add(jlabValorLocalMaisComum);
		jfrmJanela.add(jlabValorQtdLocalMaisComum);
		jfrmJanela.add(jlabMsgSintomaMaisComum);
		jfrmJanela.add(jlabValorSintomaMaisComum);
		jfrmJanela.add(jlabValorQtdSintomaMaisComum);
		jfrmJanela.add(jbtnVoltar);
		// ===============================================================================
		// Torna visivel o frame configurado
		jfrmJanela.setVisible(true);
		// ===============================================================================
		// escuta os botoes
		jbtnAtualizarFiltro.addActionListener(this);
		jbtnVoltar.addActionListener(this);
		// ===============================================================================
		atualizaDados();
	}

	// ===================================================================================
	/**
	 * Metodo para calcular e atualizar os valores apresentados em tela - quantidade
	 * de episodios, duracao media, intensidade media por usuario e mes, alem de
	 * tipo de dor mais comum, gatilho mais comum, local mais comum e medicamento
	 * mais comum.
	 * 
	 */
	public void atualizaDados() {
		controleDados.calcularDadosRelatorioEstudoDaDor(jlstUsuarios.getSelectedValue(),
				jlstMesesAnos.getSelectedValue());
		// ===============================================================================
		// atualiza os dados na tela
		jlabValorUsuario.setText(jlstUsuarios.getSelectedValue());
		jlabValorMesAno.setText(jlstMesesAnos.getSelectedValue());
		jlabValorQtdEpisodioMes
				.setText(String.valueOf(controleDados.getQtdEpisodiosMes()));
		jlabValorDuracaoMedia.setText(String.valueOf(controleDados.getDuracaoMedia()));
		jlabValorIntensidadeMedia
				.setText(String.valueOf(controleDados.getIntensidadeMedia()));
		jlabValorTipoDorMaisComum.setText(controleDados.getTipoDorMaisComum());
		jlabValorGatilhoMaisComum.setText(controleDados.getGatilhoMaisComum());
		jlabValorMedicMaisComum.setText(controleDados.getMedicMaisComum());
		jlabValorLocalMaisComum.setText(controleDados.getLocalMaisComum());
		jlabValorSintomaMaisComum.setText(controleDados.getSintomaMaisComum());
		jlabValorQtdTipoDorMaisComum.setText(
				"(" + String.valueOf(controleDados.getQtdTipoDorMaisComum()) + "x)");
		jlabValorQtdGatilhoMaisComum.setText(
				"(" + String.valueOf(controleDados.getQtdGatilhoMaisComum()) + "x)");
		jlabValorQtdMedicMaisComum.setText(
				"(" + String.valueOf(controleDados.getQtdMedicMaisComum()) + "x)");
		jlabValorQtdLocalMaisComum.setText(
				"(" + String.valueOf(controleDados.getQtdLocalMaisComum()) + "x)");
		jlabValorQtdSintomaMaisComum.setText(
				"(" + String.valueOf(controleDados.getQtdSintomaMaisComum()) + "x)");
	}

	// ===================================================================================
	/**
	 * Rotinas a serem executadas quando o Listener for ativado por algum evento.
	 * Sobrescrita.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// ===============================================================================
		// descobre o botao que foi clicado e armazena em jbtnFonte
		Object jbtnFonte = ae.getSource();
		// ===============================================================================
		// se clicar em atualizar filtro recalcula e atualiza tela
		if (jbtnFonte == jbtnAtualizarFiltro) {
			atualizaDados();
		}
		// ===============================================================================
		// se clicar em voltar, retorna para a tela inicial
		if (jbtnFonte == jbtnVoltar) {
			jfrmJanela.dispose();
			new TelaPrincipalResumo();
		}
	}

	// ===================================================================================

}
// =======================================================================================	}
