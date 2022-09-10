// =======================================================================================
package view;

// =======================================================================================
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

// =======================================================================================
/**
 * Tela principal do aplicativo com pequeno resumo dos episodios cadastrados e
 * botoes para adicionar novo episodio, ver mais informacoes ou sair do
 * aplicativo.
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 *
 */
public class TelaPrincipalResumo implements ActionListener {
	// ===================================================================================
	// Declara e cria um conteiner JFrame chamado jfrmJanela
	private static JFrame jfrmJanela = new JFrame("Diario de Enxaqueca");
	// ===================================================================================
	// Declara e cria os botoes de adicionar episodios e sair e outros
	private JButton jbtnAtualizarFiltro = new JButton("Atualizar filtro");
	private JButton jbtnListagemEpisodios = new JButton("Episodios cadastrados");
	private JButton jbtnListagemEstudoDaDor = new JButton("Estudo da dor");
	private JButton jbtnAdicionarEpisodio = new JButton("Adicionar novo episodio");
	private JButton jbtnSair = new JButton("Sair");
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
	// ===================================================================================
	// Declara e cria mensagens da tela
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
	public TelaPrincipalResumo() {
		// ===============================================================================
		// Configura a janela
		jfrmJanela.setLayout(null); // seta layout como null para posicionar os elementos
		jfrmJanela.setBounds(200, 100, 700, 430); // local inicial do quadro e o tamanho
		jfrmJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o programa
																	// caso o usuario
																	// feche a aplicacao
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
		jlabFiltro.setBounds(30, 20, 180, 20);
		jlabUsuarioFiltro.setBounds(30, 50, 180, 20);
		jscrlpUsuarios.setBounds(30, 80, 180, 75);
		jlabMesesAnosFiltro.setBounds(30, 165, 180, 20);
		jscrlpMesesAnos.setBounds(30, 195, 180, 75);
		jbtnAtualizarFiltro.setBounds(30, 290, 180, 25);
		jlabMsgUsuario.setBounds(320, 20, 100, 20);
		jlabValorUsuario.setBounds(320, 46, 100, 20);
		jlabMsgMesAno.setBounds(320, 76, 100, 20);
		jlabValorMesAno.setBounds(320, 102, 100, 20);
		jlabMsgQtdEpisodiosMes.setBounds(320, 132, 300, 20);
		jlabValorQtdEpisodioMes.setBounds(320, 158, 300, 20);
		jlabMsgDuracaoMedia.setBounds(320, 188, 300, 20);
		jlabValorDuracaoMedia.setBounds(320, 214, 300, 20);
		jlabMsgIntensidadeMedia.setBounds(320, 244, 300, 20);
		jlabValorIntensidadeMedia.setBounds(320, 270, 300, 20);
		jbtnAdicionarEpisodio.setBounds(30, 340, 180, 25);
		jbtnListagemEpisodios.setBounds(235, 340, 170, 25);
		jbtnListagemEstudoDaDor.setBounds(430, 340, 120, 25);
		jbtnSair.setBounds(575, 340, 80, 25);
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
		jfrmJanela.add(jbtnAdicionarEpisodio);
		jfrmJanela.add(jbtnListagemEpisodios);
		jfrmJanela.add(jbtnListagemEstudoDaDor);
		jfrmJanela.add(jbtnSair);
		// ===============================================================================
		// Torna visivel o frame configurado
		jfrmJanela.setVisible(true);
		// ===============================================================================
		// escuta os botoes
		jbtnAtualizarFiltro.addActionListener(this);
		jbtnAdicionarEpisodio.addActionListener(this);
		jbtnListagemEpisodios.addActionListener(this);
		jbtnListagemEstudoDaDor.addActionListener(this);
		jbtnSair.addActionListener(this);
		// ===============================================================================
		atualizaDados();
	}

	// ===================================================================================
	/**
	 * Metodo para calcular e atualizar os valores apresentados em tela - quantidade
	 * de episodios, duracao media, intensidade media por usuario e mes.
	 * 
	 */
	public void atualizaDados() {
		controleDados.calcularDadosResumo(jlstUsuarios.getSelectedValue(),
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
	}

	// ===================================================================================
	/**
	 * Metodo principal para chamar a primeira tela - entry point da aplicacao.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// ===============================================================================
		// instancia varios exemplos para simular um banco de dados
		controleDados.carregarBancoDeDados();
		// ===============================================================================
		// instancia a tela principal do programa
		new TelaPrincipalResumo();
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
		// se clicar em adicionar novo episodio abre a janela de cadastro
		if (jbtnFonte == jbtnAdicionarEpisodio) {
			jfrmJanela.dispose();
			new TelaCadastroEdicaoEpisodio();
		}
		// ===============================================================================
		// se clicar em episodios cadastrados abre a janela de listagem de episodios
		if (jbtnFonte == jbtnListagemEpisodios) {
			jfrmJanela.dispose();
			new TelaListagemEpisodios();
		}
		// ===============================================================================
		// se clicar em estudo da dor abre a janela de listagem de caracteristicas da
		// dor
		if (jbtnFonte == jbtnListagemEstudoDaDor) {
			jfrmJanela.dispose();
			new TelaListagemEstudoDaDor();
		}
		// ===============================================================================
		// se clicar em sair encerra a aplicacao
		if (jbtnFonte == jbtnSair)
			jfrmJanela.dispose();
	}

	// ===================================================================================

}
// Fim da classe TelaPrincipalResumo 
// =======================================================================================