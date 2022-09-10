//==========================================================================
package controle;

//==========================================================================
import java.util.Arrays;

import modelo.BancoDeDadosEpisodio;
import modelo.NomeGatilho;
import modelo.NomeLocalizacao;
import modelo.NomeMedicamento;
import modelo.NomeTipoDor;

//=======================================================================================
/**
 * Classe que contem os metodos que buscam os valores de listagem, cadastro,
 * edicao e delecao de novos nomes de medicamento, tipo de dor, gatilho ou
 * localizacao da dor para escolha do usuario.
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 *
 */
public class ControleCadastroNomeCaracteristica {

	private NomeMedicamento nomeMedicamento = new NomeMedicamento();
	private NomeTipoDor nomeTipoDor = new NomeTipoDor();
	private NomeLocalizacao nomeLocalizacao = new NomeLocalizacao();
	private NomeGatilho nomeGatilho = new NomeGatilho();

	// ===================================================================================
	/**
	 * Construtor
	 * 
	 */
	public ControleCadastroNomeCaracteristica() {
		// usado por TelaCadastroNomeCaracteristica
	}

	// ===================================================================================
	/**
	 * Chama o metodo para inserir nova instancia de nome de gatilho, ou tipo de
	 * dor, ou local ou nome de medicamento no banco de dados
	 * 
	 * @return indNome indice do novo nome inserido
	 * 
	 * @param CaracteristicaAtual   qual a caracteristica a ser inserida
	 * @param strNomeCaracteristica nome da caracteristica que sera inserida
	 * 
	 */
	public int inserirNomeCaracteristica(String CaracteristicaAtual,
			String strNomeCaracteristica) {
		// usado por TelaCadastroNomeCaracteristica
		int indNome = -1;
		if (CaracteristicaAtual == "Medic") {
			indNome = nomeMedicamento.inserirNomeCaracteristica(strNomeCaracteristica);
		}
		if (CaracteristicaAtual == "Tipo") {
			indNome = nomeTipoDor.inserirNomeCaracteristica(strNomeCaracteristica);
		}
		if (CaracteristicaAtual == "Gatilho") {
			indNome = nomeGatilho.inserirNomeCaracteristica(strNomeCaracteristica);
		}
		if (CaracteristicaAtual == "Local") {
			indNome = nomeLocalizacao.inserirNomeCaracteristica(strNomeCaracteristica);
		}
		return indNome;
	}

	// ===================================================================================
	/**
	 * Chama o metodo para editar instancia existente de nome de gatilho, ou tipo de
	 * dor, ou local ou nome de medicamento no banco de dados
	 * 
	 * @param CaracteristicaAtual   qual a caracteristica a ser inserida
	 * @param strNomeCaracteristica nome da caracteristica que sera inserida
	 * @param indNomeCaracteristica indice do nome da caracteristica que sera
	 *                              editada
	 * 
	 */
	public void editarNomeCaracteristica(String CaracteristicaAtual,
			String strNomeCaracteristica, int indNomeCaracteristica) {
		// usado por TelaCadastroNomeCaracteristica
		if (CaracteristicaAtual == "Medic") {
			NomeMedicamento.editarNomeMedic(indNomeCaracteristica, strNomeCaracteristica);
		}
		if (CaracteristicaAtual == "Tipo") {
			NomeTipoDor.editarNomeTipoDor(indNomeCaracteristica, strNomeCaracteristica);
		}
		if (CaracteristicaAtual == "Gatilho") {
			NomeGatilho.editarNomeGatilho(indNomeCaracteristica, strNomeCaracteristica);
		}
		if (CaracteristicaAtual == "Local") {
			NomeLocalizacao.editarNomeLocal(indNomeCaracteristica, strNomeCaracteristica);
		}
	}

	// ===================================================================================
	/**
	 * Metodo para obter um array, com todos os nomes das caracteristicas do banco
	 * de dados
	 * 
	 * @return NomeCaracteristica retorna um array com nomes das caracteristicas
	 * 
	 * @param CaracteristicaAtual qual a caracteristica a ser inserida
	 * 
	 */
	public String[] gerarArrayNomeCaracteristica(String CaracteristicaAtual) {
		// usado por TelaCadastroEdicaoEpisodio
		String[] NomeCaracteristica = new String[50];
		if (CaracteristicaAtual == "Medic") {
			NomeCaracteristica = nomeMedicamento.gerarArrayNomeCaracteristica();
		}
		if (CaracteristicaAtual == "Tipo") {
			NomeCaracteristica = nomeTipoDor.gerarArrayNomeCaracteristica();
		}
		if (CaracteristicaAtual == "Gatilho") {
			NomeCaracteristica = nomeGatilho.gerarArrayNomeCaracteristica();
		}
		if (CaracteristicaAtual == "Local") {
			NomeCaracteristica = nomeLocalizacao.gerarArrayNomeCaracteristica();
		}

		return NomeCaracteristica;
	}

	// ===================================================================================
	/**
	 * Chama o metodo para excluir instancia existente de nome de gatilho, ou tipo
	 * de dor, ou local ou nome de medicamento no banco de dados
	 * 
	 * @return nomeExcluido retorna verdadeiro se o nome foi excluido
	 * 
	 * @param CaracteristicaAtual      qual a caracteristica a ser excluida
	 * @param indiceNomeCaracteristica indice do nome da caracteristica que sera
	 *                                 excluida
	 * 
	 */
	public boolean excluirNomeCaracteristica(String CaracteristicaAtual,
			int indiceNomeCaracteristica) {
		// usado por TelaCadastroNomeCaracteristica
		boolean nomeExcluido = false;
		if (CaracteristicaAtual == "Medic") {
			nomeExcluido = nomeMedicamento
					.excluirNomeCaracteristica(indiceNomeCaracteristica);
		}
		if (CaracteristicaAtual == "Tipo") {
			nomeExcluido = nomeTipoDor
					.excluirNomeCaracteristica(indiceNomeCaracteristica);
		}
		if (CaracteristicaAtual == "Gatilho") {
			nomeExcluido = nomeGatilho
					.excluirNomeCaracteristica(indiceNomeCaracteristica);
		}
		if (CaracteristicaAtual == "Local") {
			nomeExcluido = nomeLocalizacao
					.excluirNomeCaracteristica(indiceNomeCaracteristica);
		}
		System.out.println(toString() + "\n");
		return nomeExcluido;
	}

	// ==========================================================================

	// ===================================================================================
	/**
	 * Sobrescreve o metodo toString() da classe Object. Constroi uma String
	 * contendo o valor de todas as variaveis da classe NomeGatilho.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "ControleCadastroNome \n[NomeMedic="
				+ Arrays.toString(BancoDeDadosEpisodio.getBdNomeMedic())
				+ "\nqtdNomeMedic=" + BancoDeDadosEpisodio.getQtdBDNomeMedic()
				+ "\nNomeTipoDor="
				+ Arrays.toString(BancoDeDadosEpisodio.getBdNomeTipoDor())
				+ "\nqtdNomeTipoDor=" + BancoDeDadosEpisodio.getQtdBDNomeTipoDor()
				+ "\nNomeGatilho="
				+ Arrays.toString(BancoDeDadosEpisodio.getBdNomeGatilho())
				+ "\nqtdNomeGatilho=" + BancoDeDadosEpisodio.getQtdBDNomeGatilho()
				+ "\nNomeLocal=" + Arrays.toString(BancoDeDadosEpisodio.getBdNomeLocal())
				+ "\nqtdNomeLocal=" + BancoDeDadosEpisodio.getQtdBDNomeLocal() + "]";
	}

	// ===================================================================================
	/**
	 * Metodo para obter o indice do tipo de dor do array do banco de dados
	 * 
	 * @return indice retorna o indice no qual se encontra o nome do tipo de dor
	 * 
	 * @param tipoDor nome do tipo de dor procurado
	 * 
	 */
	public int buscarIndiceNomeTipoDor(NomeTipoDor tipoDor) {
		int indice = NomeTipoDor.buscarIndiceNomeTipoDor(tipoDor);
		return indice;
	}

	// ===================================================================================
	/**
	 * Metodo para obter o indice do gatilho do array do banco de dados
	 * 
	 * @return indice retorna o indice no qual se encontra o nome do gatilho
	 * 
	 * @param gatilho nome do gatilho procurado
	 * 
	 */
	public int buscarIndiceNomeGatilho(NomeGatilho gatilho) {
		int indice = NomeGatilho.buscarIndiceNomeGatilho(gatilho);
		return indice;
	}

	// ===================================================================================
	/**
	 * Metodo para obter o indice do nome do medicamento do array do banco de dados
	 * 
	 * @return indice retorna o indice no qual se encontra o nome do medicamento
	 * 
	 * @param medic nome do nome do medicamento procurado
	 * 
	 */
	public int buscarIndiceNomeMedic(NomeMedicamento medic) {
		int indice = NomeMedicamento.buscarIndiceNomeMedic(medic);
		return indice;
	}

	// ===================================================================================
	/**
	 * Metodo para obter o indice do local do array do banco de dados
	 * 
	 * @return indice retorna o indice no qual se encontra o nome do local
	 * 
	 * @param local nome do local procurado
	 * 
	 */
	public int buscarIndiceNomeLocal(NomeLocalizacao local) {
		int indice = NomeLocalizacao.buscarIndiceNomeLocal(local);
		return indice;
	}

}