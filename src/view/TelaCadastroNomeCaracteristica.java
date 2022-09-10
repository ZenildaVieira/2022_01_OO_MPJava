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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleCadastroNomeCaracteristica;

// =======================================================================================
/**
 * Tela de listagem, cadastro, edicao e delecao de novos nomes de medicamento,
 * tipo de dor, gatilho ou localizacao da dor para escolha do usuario.
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 *
 */
public class TelaCadastroNomeCaracteristica
		implements ActionListener, ListSelectionListener {
	// ===================================================================================
	// Declara um conteiner JFrame chamado jfrmJanela
	private JFrame jfrmJanela;
	// ===================================================================================
	// Declara e cria os botoes de cadastrar, editar, excluir e voltar
	private JButton jbtnCadastrar = new JButton("Cadastrar");
	private JButton jbtnEditar = new JButton("Editar");
	private JButton jbtnExcluir = new JButton("Excluir");
	private JButton jbtnVoltar = new JButton("Voltar");
	private String complementaString;
	// ===================================================================================
	// Declara e cria uma mensagem para testes de localizacao
	private JLabel jlabMensagem = new JLabel(
			"******   ******   ***** ** *****   ******   ******", JLabel.CENTER);
	// ===================================================================================
	// Declara uma variavel pra receber os dados do banco de dados atualizados
	private static ControleCadastroNomeCaracteristica controleCadNome;
	// ===================================================================================
	// Declara e cria arrays e as caixas de selecao
	private static JList<String> jlstNomeCaracteristica;
	private static JScrollPane jscrlpNomeCaracteristica;
	private static String[] arrayCaracteristica = new String[50];
	private static String caracteristicaAtual;
	// ===================================================================================
	// Declara e cria os rotulos contendo os textos explicativos
	private JLabel jlabNovoItem;
	private JLabel jlabNomeCaracteristica = new JLabel("Itens ja cadastrados:");
	// ===================================================================================
	// Declara e cria os campos de texto
	private JTextField jtfNovoItem = new JTextField(30);
	private JTextField jtfEditarItem = new JTextField(30);
	// ===================================================================================
	// variaveis para receber o indice e o nome editado/incluido/excluido
	private int indiceNomeCaracteristica;
	private String nomeCaractEditado;

	// ===================================================================================
	/**
	 * Configura o frame e adiciona os componentes.
	 * 
	 * @param caracteristica determina qual a caracteristica que sera manipulada:
	 *                       tipo de dor, gatilho, medicamento ou localizacao da
	 *                       dor.
	 */
	public TelaCadastroNomeCaracteristica(String caracteristica) {
		// ===============================================================================
		// Define qual caracteristica sera manipulada
		controleCadNome = new ControleCadastroNomeCaracteristica();
		if (caracteristica == "Medic") {
			complementaString = "Novo medicamento";
		}
		if (caracteristica == "Tipo") {
			complementaString = "Novo tipo de dor";
		}
		if (caracteristica == "Gatilho") {
			complementaString = "Novo gatilho";
		}
		if (caracteristica == "Local") {
			complementaString = "Nova localizacao";
		}
		// ===============================================================================
		// Configura a janela
		jfrmJanela = new JFrame(complementaString);
		jlabNovoItem = new JLabel("Entre com " + complementaString.toLowerCase() + ":");
		// Configura o layout do quadro
		jfrmJanela.setLayout(null);
		// Configura o local inicial do quadro e o tamanho
		jfrmJanela.setBounds(200, 100, 360, 445);
		// nao encerra o app so fecha a janela
		jfrmJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// ===============================================================================
		// gera um array com todos os nomes existentes no banco de dados
		arrayCaracteristica = controleCadNome
				.gerarArrayNomeCaracteristica(caracteristica);
		caracteristicaAtual = caracteristica;
		// Atribuicao dos arrays aos Jlists
		jlstNomeCaracteristica = new JList<String>(arrayCaracteristica);
		// Atribuicao dos JLists aos JScrollPanes
		jscrlpNomeCaracteristica = new JScrollPane(jlstNomeCaracteristica);
		// Selecao unica para os JLists
		jlstNomeCaracteristica
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		// ===============================================================================
		// Posiciona os componentes ao frame
		jlabNovoItem.setBounds(30, 20, 200, 20);
		jtfNovoItem.setBounds(30, 50, 180, 25);
		jbtnCadastrar.setBounds(220, 50, 100, 25);
		jlabNomeCaracteristica.setBounds(30, 85, 200, 20);
		jscrlpNomeCaracteristica.setBounds(30, 115, 290, 170);
		jbtnEditar.setBounds(30, 300, 100, 25);
		jtfEditarItem.setBounds(145, 300, 175, 25);
		jbtnExcluir.setBounds(75, 340, 100, 25);
		jbtnVoltar.setBounds(195, 340, 100, 25);
		jlabMensagem.setBounds(30, 375, 290, 25);
		// ===============================================================================
		// Configuracao das mensagens - tipo, cor e tamanho da fonte
		jlabMensagem.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		jlabMensagem.setForeground(Color.red);
		// ===============================================================================
		// Adiciona os componentes ao frame
		jfrmJanela.add(jtfNovoItem);
		jfrmJanela.add(jlabNovoItem);
		jfrmJanela.add(jlabNomeCaracteristica);
		jfrmJanela.add(jscrlpNomeCaracteristica);
		jfrmJanela.add(jlabMensagem);
		jfrmJanela.add(jbtnExcluir);
		jfrmJanela.add(jbtnEditar);
		jfrmJanela.add(jtfEditarItem);
		jfrmJanela.add(jbtnCadastrar);
		jfrmJanela.add(jbtnVoltar);
		// ===============================================================================
		// Torna visivel o frame configurado
		jfrmJanela.setVisible(true);
		// ===============================================================================
		// escuta os botoes
		jtfEditarItem.addActionListener(this);
		jbtnExcluir.addActionListener(this);
		jbtnEditar.addActionListener(this);
		jbtnCadastrar.addActionListener(this);
		jbtnVoltar.addActionListener(this);
		// escuta as listas
		jlstNomeCaracteristica.addListSelectionListener(this);
		// ===============================================================================
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
		// ===================================================================================
		// Captura os valores preenchidos nos campos de texto
		if (jbtnFonte == jbtnCadastrar) {
			String novoNome = jtfNovoItem.getText();
			// verifica se o campo nao esta vazio
			if (novoNome.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Entre com o nome a ser cadastrado",
						null, JOptionPane.ERROR_MESSAGE);
			} else {
				// campo preenchido - insere novo nome
				int indice = controleCadNome
						.inserirNomeCaracteristica(caracteristicaAtual, novoNome);
				String[] arrayNomeCaractAtualizado = controleCadNome
						.gerarArrayNomeCaracteristica(caracteristicaAtual);
				jlstNomeCaracteristica.setListData(arrayNomeCaractAtualizado);
				jlabMensagem.setText(jtfNovoItem.getText() + " cadastrado");
				jlstNomeCaracteristica.setSelectedIndex(indice);
				// atualiza campo de edicao
				jtfEditarItem.setText(jlstNomeCaracteristica.getSelectedValue());
			}
		}
		// ===================================================================================
		// Edita item selecionado na JList
		if (jbtnFonte == jbtnEditar) {
			indiceNomeCaracteristica = jlstNomeCaracteristica.getSelectedIndex();
			// captura nome para edicao
			nomeCaractEditado = jtfEditarItem.getText();
			// chama rotina de edicao
			controleCadNome.editarNomeCaracteristica(caracteristicaAtual,
					nomeCaractEditado, indiceNomeCaracteristica);
			// atualiza o array
			String[] arrayNomeCaractAtualizado = controleCadNome
					.gerarArrayNomeCaracteristica(caracteristicaAtual);
			// atualiza o JList
			jlstNomeCaracteristica.setListData(arrayNomeCaractAtualizado);
			jlabMensagem.setText(nomeCaractEditado + " editado");
			// atualiza selecao
			jlstNomeCaracteristica.setSelectedIndex(indiceNomeCaracteristica);
			// atualiza campo de edicao
			jtfEditarItem.setText(jlstNomeCaracteristica.getSelectedValue());
		}
		// ===================================================================================
		// Exclui item selecionado na JList
		if (jbtnFonte == jbtnExcluir) {
			// captura nome para exclusao
			indiceNomeCaracteristica = jlstNomeCaracteristica.getSelectedIndex();
			String nomeCaractExcluido = jlstNomeCaracteristica.getSelectedValue();
			// chama rotina de exclusao
			boolean flagExcluido = controleCadNome.excluirNomeCaracteristica(
					caracteristicaAtual, indiceNomeCaracteristica);
			// atualiza o array
			String[] arrayNomeCaractAtualizado = controleCadNome
					.gerarArrayNomeCaracteristica(caracteristicaAtual);
			// atualiza o JList
			jlstNomeCaracteristica.setListData(arrayNomeCaractAtualizado);
			if (flagExcluido)
				jlabMensagem.setText(nomeCaractExcluido + " excluido");
			// atualiza selecao para p primeiro
			jlstNomeCaracteristica.setSelectedIndex(0);
			// atualiza campo de edicao
			jtfEditarItem.setText(jlstNomeCaracteristica.getSelectedValue());
		}
		// ===================================================================================
		// Volta para a tela de cadastro
		if (jbtnFonte == jbtnVoltar) {
			jfrmJanela.dispose();
			TelaCadastroEdicaoEpisodio.jfrmJanela.setVisible(true);
			// atualiza as listas de escolha
			TelaCadastroEdicaoEpisodio.atualizarJList();
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

		if (lse.getValueIsAdjusting() && src == jlstNomeCaracteristica) {
			indiceNomeCaracteristica = jlstNomeCaracteristica.getSelectedIndex();
			jtfEditarItem.setText(jlstNomeCaracteristica.getSelectedValue());
		}

	}

}
