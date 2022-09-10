//==========================================================================
package view;

//==========================================================================
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controle.ControleDados;
import modelo.Episodio;

// =======================================================================================
/**
 * Tela de listagem dos episodios ja cadastrados. Possibilita busca de um
 * determinado episodio pelo usuario e pela data. Tambem permite a edicao de
 * episodios.
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 *
 */
public class TelaListagemEpisodios implements ActionListener {
	// ===================================================================================
	// Declara e cria um conteiner JFrame chamado jfrmJanela
	private static JFrame jfrmJanela = new JFrame("Episodios Cadastrados");
	// ===================================================================================
	// Declara e cria os rotulos contendo os textos explicativos
	private JLabel jlabUsuario = new JLabel("Usuario:");
	private JLabel jlabDataInicio = new JLabel("Data de inicio da dor (dd/mm/aaaa):");
	private JLabel jlabDataInicio1 = new JLabel("/");
	private JLabel jlabDataInicio2 = new JLabel("/");
	private JLabel jlabHoraInicio = new JLabel("Hora de inicio (hh:mm):");
	private JLabel jlabHoraInicio1 = new JLabel(":");
	private JLabel jlabDuracaoHoras = new JLabel("Duracao da dor (em horas):");
	private JLabel jlabTipoDor = new JLabel("Tipo da dor:");
	private JLabel jlabSintoma = new JLabel("Sintoma mais forte:");
	private JLabel jlabGatilho = new JLabel("Gatilho da dor:");
	private JLabel jlabLocal = new JLabel("Localizacao da dor:");
	private JLabel jlabIntensid = new JLabel("Intensidade da dor:");
	private JLabel jlabNomeMedic = new JLabel("Nome do medicamento utilizado:");
	private JLabel jlabEfic = new JLabel("O medicamento funcionou?");
	private JLabel jlabNotas = new JLabel("Observacoes:");
	private JLabel jlabFiltro = new JLabel("Escolha");
	private JLabel jlabUsuarioFiltro = new JLabel("Usuario:");
	private JLabel jlabDataBusca = new JLabel("Entre com a data que voce deseja buscar");
	private JLabel jlabDataBusca0 = new JLabel("(dd/mm/aaaa):");
	private JLabel jlabDataBusca1 = new JLabel("/");
	private JLabel jlabDataBusca2 = new JLabel("/");
	// ===================================================================================
	// Declara e cria os campos de texto para serem preenchidos
	private static JTextField jtfValorUsuario = new JTextField("teste");
	private static JTextField jtfValorDataInicioDia = new JTextField("teste");
	private static JTextField jtfValorDataInicioMes = new JTextField("teste");
	private static JTextField jtfValorDataInicioAno = new JTextField("teste");
	private static JTextField jtfValorHoraInicioHora = new JTextField("teste");
	private static JTextField jtfValorHoraInicioMin = new JTextField("teste");
	private static JTextField jtfValorDuracaoHoras = new JTextField("teste");
	private static JTextField jtfValorTipoDor = new JTextField("teste");
	private static JTextField jtfValorSintoma = new JTextField("teste");
	private static JTextField jtfValorGatilho = new JTextField("teste");
	private static JTextField jtfValorLocal = new JTextField("teste");
	private static JTextField jtfValorIntensid = new JTextField("teste");
	private static JTextField jtfValorNomeMedic = new JTextField("teste");
	private static JTextField jtfValorEfic = new JTextField("teste");
	private static JTextField jtfValorNotas = new JTextField("teste");
	private static JTextField jtfDataBuscaDia = new JTextField("14");
	private static JTextField jtfDataBuscaMes = new JTextField("08");
	private static JTextField jtfDataBuscaAno = new JTextField("2022");
	// ===================================================================================
	// Declara e cria uma mensagem para testes de localizacao
	private JLabel jlabMensagem = new JLabel(
			"****    ******    *******    *******    ***** ** *****    *******    *******    *****    ****",
			JLabel.CENTER);
	// ===================================================================================
	// Declara e cria arrays e as caixas de selecao
	private static String[] arrayUsuarios = new String[100];
	private static JList<String> jlstUsuarios;
	private static JScrollPane jscrlpUsuarios;
	// ===================================================================================
	// Declara e cria os botoes
	private static JButton jbtnAnterior = new JButton("<");
	private static JButton jbtnProximo = new JButton(">");
	private static JButton jbtnPrimeiro = new JButton("<<");
	private static JButton jbtnUltimo = new JButton(">>");
	private JButton jbtnBuscar = new JButton("Buscar");
	private JButton jbtnExcluir = new JButton("Excluir");
	private JButton jbtnEditar = new JButton("Editar");
	private JButton jbtnVoltar = new JButton("Voltar");
	// ===================================================================================
	// Declara variaveis que vao receber os valores digitados
	private static String valorDataBuscaDia;
	private static String valorDataBuscaMesAno;
	// ===================================================================================
	private static ControleDados controleDados = new ControleDados();

	// ===================================================================================
	/**
	 * Configura o frame e adiciona os componentes.
	 * 
	 */
	public TelaListagemEpisodios() {
		// ===============================================================================
		// Configura a janela
		jfrmJanela.setLayout(null); // seta layout como null para posicionar os elementos
		jfrmJanela.setBounds(200, 100, 720, 600); // local inicial do quadro e o tamanho
		// nao encerra o app so fecha a janela
		jfrmJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// ===============================================================================
		// Captura das instancias do banco de dados em array
		arrayUsuarios = controleDados.gerarArrayUsuariosUnicos();
		// Atribuicao do array ao Jlist
		jlstUsuarios = new JList<String>(arrayUsuarios);
		// Atribuicao do JList ao JScrollPane
		jscrlpUsuarios = new JScrollPane(jlstUsuarios);
		// Selecao unica para o JList
		jlstUsuarios.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		// Selecao do primeiro valor
		jlstUsuarios.setSelectedIndex(0);
		// ===============================================================================
		// Posiciona e dimensiona os componentes ao frame - x, y, largura, altura
		jlabFiltro.setBounds(30, 20, 50, 20);
		jlabUsuarioFiltro.setBounds(90, 20, 50, 20);
		jscrlpUsuarios.setBounds(160, 20, 150, 75);
		jlabDataBusca.setBounds(330, 20, 305, 20);
		jlabDataBusca0.setBounds(330, 45, 305, 20);
		jtfDataBuscaDia.setBounds(330, 70, 25, 25);
		jlabDataBusca1.setBounds(358, 70, 3, 20);
		jtfDataBuscaMes.setBounds(364, 70, 25, 25);
		jlabDataBusca2.setBounds(392, 70, 3, 20);
		jtfDataBuscaAno.setBounds(398, 70, 40, 25);
		jbtnBuscar.setBounds(512, 70, 100, 25);
		jlabUsuario.setBounds(90, 115, 200, 20);
		jtfValorUsuario.setBounds(300, 115, 315, 20);
		jlabDataInicio.setBounds(90, 140, 200, 20);
		jtfValorDataInicioDia.setBounds(300, 140, 25, 20);
		jlabDataInicio1.setBounds(327, 140, 3, 20);
		jtfValorDataInicioMes.setBounds(332, 140, 25, 20);
		jlabDataInicio2.setBounds(359, 140, 3, 20);
		jtfValorDataInicioAno.setBounds(364, 140, 40, 20);
		jlabHoraInicio.setBounds(415, 140, 135, 20);
		jtfValorHoraInicioHora.setBounds(557, 140, 25, 20);
		jlabHoraInicio1.setBounds(584, 140, 3, 20);
		jtfValorHoraInicioMin.setBounds(589, 140, 25, 20);
		jlabDuracaoHoras.setBounds(90, 165, 200, 20);
		jtfValorDuracaoHoras.setBounds(300, 165, 315, 20);
		jlabSintoma.setBounds(90, 190, 200, 20);
		jtfValorSintoma.setBounds(300, 190, 315, 20);
		jlabIntensid.setBounds(90, 215, 200, 20);
		jtfValorIntensid.setBounds(300, 215, 315, 20);
		jlabNomeMedic.setBounds(90, 240, 200, 20);
		jtfValorNomeMedic.setBounds(300, 240, 315, 20);
		jlabEfic.setBounds(90, 265, 200, 20);
		jtfValorEfic.setBounds(300, 265, 315, 20);
		jlabTipoDor.setBounds(90, 290, 200, 20);
		jtfValorTipoDor.setBounds(300, 290, 315, 20);
		jlabGatilho.setBounds(90, 315, 200, 20);
		jtfValorGatilho.setBounds(300, 315, 315, 20);
		jlabLocal.setBounds(90, 340, 200, 20);
		jtfValorLocal.setBounds(300, 340, 315, 20);
		jlabNotas.setBounds(90, 365, 200, 20);
		jtfValorNotas.setBounds(300, 365, 315, 90);
		jlabMensagem.setBounds(90, 475, 525, 20);
		jbtnAnterior.setBounds(30, 200, 50, 60);
		jbtnProximo.setBounds(627, 200, 50, 60);
		jbtnPrimeiro.setBounds(30, 275, 50, 60);
		jbtnUltimo.setBounds(627, 275, 50, 60);
		jbtnExcluir.setBounds(160, 510, 100, 25);
		jbtnEditar.setBounds(300, 510, 100, 25);
		jbtnVoltar.setBounds(440, 510, 100, 25);
		// ===============================================================================
		// Configuracao das mensagens - tipo, cor e tamanho da fonte
		jlabMensagem.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		jlabMensagem.setForeground(Color.red);
		// ===============================================================================
		// Adiciona os componentes ao frame
		jfrmJanela.add(jlabUsuario);
		jfrmJanela.add(jtfValorUsuario);
		jfrmJanela.add(jlabDataInicio);
		jfrmJanela.add(jtfValorDataInicioDia);
		jfrmJanela.add(jlabDataInicio1);
		jfrmJanela.add(jtfValorDataInicioMes);
		jfrmJanela.add(jlabDataInicio2);
		jfrmJanela.add(jtfValorDataInicioAno);
		jfrmJanela.add(jlabHoraInicio);
		jfrmJanela.add(jtfValorHoraInicioHora);
		jfrmJanela.add(jlabHoraInicio1);
		jfrmJanela.add(jtfValorHoraInicioMin);
		jfrmJanela.add(jlabDuracaoHoras);
		jfrmJanela.add(jtfValorDuracaoHoras);
		jfrmJanela.add(jlabTipoDor);
		jfrmJanela.add(jtfValorTipoDor);
		jfrmJanela.add(jlabSintoma);
		jfrmJanela.add(jtfValorSintoma);
		jfrmJanela.add(jlabGatilho);
		jfrmJanela.add(jtfValorGatilho);
		jfrmJanela.add(jlabLocal);
		jfrmJanela.add(jtfValorLocal);
		jfrmJanela.add(jlabIntensid);
		jfrmJanela.add(jtfValorIntensid);
		jfrmJanela.add(jlabNomeMedic);
		jfrmJanela.add(jtfValorNomeMedic);
		jfrmJanela.add(jlabEfic);
		jfrmJanela.add(jtfValorEfic);
		jfrmJanela.add(jlabNotas);
		jfrmJanela.add(jtfValorNotas);
		jfrmJanela.add(jbtnBuscar);
		jfrmJanela.add(jlabFiltro);
		jfrmJanela.add(jlabUsuarioFiltro);
		jfrmJanela.add(jscrlpUsuarios);
		jfrmJanela.add(jlabDataBusca);
		jfrmJanela.add(jlabDataBusca0);
		jfrmJanela.add(jtfDataBuscaDia);
		jfrmJanela.add(jlabDataBusca1);
		jfrmJanela.add(jtfDataBuscaMes);
		jfrmJanela.add(jlabDataBusca2);
		jfrmJanela.add(jtfDataBuscaAno);
		jfrmJanela.add(jbtnAnterior);
		jfrmJanela.add(jbtnProximo);
		jfrmJanela.add(jbtnPrimeiro);
		jfrmJanela.add(jbtnUltimo);
		jfrmJanela.add(jbtnExcluir);
		jfrmJanela.add(jbtnEditar);
		jfrmJanela.add(jbtnVoltar);
		jfrmJanela.add(jlabMensagem);
		// ===============================================================================
		// Torna visivel o frame configurado
		jfrmJanela.setVisible(true);
		// ===============================================================================
		// escuta os botoes
		jbtnBuscar.addActionListener(this);
		jbtnAnterior.addActionListener(this);
		jbtnProximo.addActionListener(this);
		jbtnPrimeiro.addActionListener(this);
		jbtnUltimo.addActionListener(this);
		jbtnExcluir.addActionListener(this);
		jbtnEditar.addActionListener(this);
		jbtnVoltar.addActionListener(this);
		// ===============================================================================
		// preenche os dados da tela com o episodio filtrado
		valorDataBuscaDia = jtfDataBuscaDia.getText();
		valorDataBuscaMesAno = jtfDataBuscaMes.getText() + "_"
				+ jtfDataBuscaAno.getText();
		controleDados.buscarEpisodioFiltradoPorDia(jlstUsuarios.getSelectedValue(),
				Integer.parseInt(valorDataBuscaDia), valorDataBuscaMesAno);
		preencherEpisodioCadastrado(controleDados.getEpisodioDia());
	}

	// ===================================================================================
	/**
	 * Preenche a tela com os dados do episodio que sera visualizado.
	 * 
	 * @param episodioDia instancia de episodio que sera visualizada
	 */
	public static void preencherEpisodioCadastrado(Episodio episodioDia) {
		// configura botos de navegacao conforme se esta no inicio ou no fim da lista
		if (controleDados.getIndiceEpisodioDia() == 0) {
			jbtnAnterior.setEnabled(false);
			jbtnProximo.setEnabled(true);
			jbtnPrimeiro.setEnabled(false);
			jbtnUltimo.setEnabled(true);
		} else if (controleDados
				.getIndiceEpisodioDia() == (controleDados.getQtdEpisodiosMes() - 1)) {
			jbtnAnterior.setEnabled(true);
			jbtnProximo.setEnabled(false);
			jbtnPrimeiro.setEnabled(true);
			jbtnUltimo.setEnabled(false);
		} else {
			jbtnAnterior.setEnabled(true);
			jbtnProximo.setEnabled(true);
			jbtnPrimeiro.setEnabled(true);
			jbtnUltimo.setEnabled(true);
		}
		// atualiza campos com os valores do episodio
		jlstUsuarios.setSelectedValue(episodioDia.getUsuario(), true);
		int dia = episodioDia.getDataInicioDia();
		String strDia = String.valueOf(dia);
		if (dia < 10)
			strDia = "0" + String.valueOf(dia);
		int mes = episodioDia.getDataInicioMes();
		String strMes = String.valueOf(mes);
		if (mes < 10)
			strMes = "0" + String.valueOf(mes);
		jtfDataBuscaDia.setText(strDia);
		jtfDataBuscaMes.setText(strMes);
		jtfDataBuscaAno.setText(String.valueOf(episodioDia.getDataInicioAno()));

		jtfValorUsuario.setText(episodioDia.getUsuario());
		jtfValorDataInicioDia.setText(strDia);
		jtfValorDataInicioMes.setText(strMes);
		jtfValorDataInicioAno.setText(String.valueOf(episodioDia.getDataInicioAno()));

		int hora = episodioDia.getDataInicioHora();
		String strHora = String.valueOf(hora);
		if (hora < 10)
			strHora = "0" + String.valueOf(hora);
		int min = episodioDia.getDataInicioMinuto();
		String strMin = String.valueOf(min);
		if (min < 10)
			strMin = "0" + String.valueOf(min);

		jtfValorHoraInicioHora.setText(strHora);
		jtfValorHoraInicioMin.setText(strMin);
		jtfValorDuracaoHoras.setText(String.valueOf(episodioDia.getDuracaoHoras()));
		jtfValorTipoDor.setText(episodioDia.getCaractDor().getTipoDor().getNomeTipoDor());
		jtfValorSintoma.setText(episodioDia.getCaractDor().getSintoma());
		jtfValorGatilho.setText(episodioDia.getCaractDor().getGatilho().getNomeGatilho());
		jtfValorLocal.setText(episodioDia.getCaractDor().getLocal().getNomeLocal());
		jtfValorIntensid
				.setText(String.valueOf(episodioDia.getCaractDor().getIntensidade()));
		jtfValorNomeMedic
				.setText(episodioDia.getCaractMedic().getNomeMedic().getNomeMedic());
		jtfValorEfic.setText(episodioDia.getCaractMedic().getEficiencia());
		jtfValorNotas.setText(episodioDia.getObservacao());
		// configura campos para que nao sejam editados
		jtfValorUsuario.setEditable(false);
		jtfValorDataInicioDia.setEditable(false);
		jtfValorDataInicioMes.setEditable(false);
		jtfValorDataInicioAno.setEditable(false);
		jtfValorHoraInicioHora.setEditable(false);
		jtfValorHoraInicioMin.setEditable(false);
		jtfValorDuracaoHoras.setEditable(false);
		jtfValorTipoDor.setEditable(false);
		jtfValorSintoma.setEditable(false);
		jtfValorGatilho.setEditable(false);
		jtfValorLocal.setEditable(false);
		jtfValorIntensid.setEditable(false);
		jtfValorNomeMedic.setEditable(false);
		jtfValorEfic.setEditable(false);
		jtfValorNotas.setEditable(false);
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
		// se clicar em buscar preenche dados com o episodio buscado
		if (jbtnFonte == jbtnBuscar) {
			// captura valores para o filtro
			valorDataBuscaDia = jtfDataBuscaDia.getText();
			valorDataBuscaMesAno = jtfDataBuscaMes.getText() + "_"
					+ jtfDataBuscaAno.getText();
			// rotina de busca por data e usuario
			boolean achou = controleDados.buscarEpisodioFiltradoPorDia(
					jlstUsuarios.getSelectedValue(), Integer.parseInt(valorDataBuscaDia),
					valorDataBuscaMesAno);
			// preenche com o episodio encontrado
			if (achou)
				preencherEpisodioCadastrado(controleDados.getEpisodioDia());
			else
				JOptionPane.showMessageDialog(null,
						"Nao ha episodio para esse usuario e data", null,
						JOptionPane.WARNING_MESSAGE);
		}
		// se clicar em excluir, apaga o episodio listado
		if (jbtnFonte == jbtnExcluir) {
			// captura valores para o filtro
			valorDataBuscaDia = jtfDataBuscaDia.getText();
			valorDataBuscaMesAno = jtfDataBuscaMes.getText() + "_"
					+ jtfDataBuscaAno.getText();
			// rotina de exclusao por data e usuario
			boolean apagou = controleDados.excluirEpisodioFiltradoPorDia(
					jlstUsuarios.getSelectedValue(), Integer.parseInt(valorDataBuscaDia),
					valorDataBuscaMesAno);
			// preenche com o episodio encontrado
			if (apagou)
				JOptionPane.showMessageDialog(null, "Episodio excluido", null,
						JOptionPane.WARNING_MESSAGE);
			// preenche com primeiro do banco de dados
			controleDados.buscarEpisodioFiltradoPorIndice(
					controleDados.getIndiceEpisodioDia());
			preencherEpisodioCadastrado(controleDados.getEpisodioDia());
		}
		// se clicar em editar, chama a tela de cadastro para editar dados
		if (jbtnFonte == jbtnEditar) {
			// fecha a tela e chame a tela de cadastro j
			jfrmJanela.dispose();
			new TelaCadastroEdicaoEpisodio();
			// preenche com dados a serem editados
			TelaCadastroEdicaoEpisodio
					.preencherEpisodioDia(controleDados.getEpisodioDia());
		}
		// se clicar em <, mostra episodio anterior
		if (jbtnFonte == jbtnAnterior) {
			int indice = controleDados.getIndiceEpisodioDia();
			controleDados.setIndiceEpisodioDia(indice - 1);
			controleDados.buscarEpisodioFiltradoPorIndice(
					controleDados.getIndiceEpisodioDia());
			preencherEpisodioCadastrado(controleDados.getEpisodioDia());
		}
		// se clicar em >, mostra episodio anterior
		if (jbtnFonte == jbtnProximo) {
			int indice = controleDados.getIndiceEpisodioDia();
			controleDados.setIndiceEpisodioDia(indice + 1);
			controleDados.buscarEpisodioFiltradoPorIndice(
					controleDados.getIndiceEpisodioDia());
			preencherEpisodioCadastrado(controleDados.getEpisodioDia());
		}
		// se clicar em <<, mostra primeiro episodio
		if (jbtnFonte == jbtnPrimeiro) {
			controleDados.setIndiceEpisodioDia(0);
			controleDados.buscarEpisodioFiltradoPorIndice(
					controleDados.getIndiceEpisodioDia());
			preencherEpisodioCadastrado(controleDados.getEpisodioDia());
		}
		// se clicar em >>, mostra ultimo episodio
		if (jbtnFonte == jbtnUltimo) {
			int indice = controleDados.getQtdEpisodios();
			controleDados.setIndiceEpisodioDia(indice - 1);
			controleDados.buscarEpisodioFiltradoPorIndice(
					controleDados.getIndiceEpisodioDia());
			preencherEpisodioCadastrado(controleDados.getEpisodioDia());
		}
		// se clicar em voltar, retorna a tela principal
		if (jbtnFonte == jbtnVoltar) {
			jfrmJanela.dispose();
			new TelaPrincipalResumo();
		}
	}

	// ======================================================================

}
