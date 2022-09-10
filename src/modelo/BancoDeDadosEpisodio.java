// =======================================================================================
package modelo;

// =======================================================================================
/**
 * Essa classe gera varias instancias das classes relacionadas aos episodios de
 * enxaqueca e suas caaracterisiticas, simulando um banco de dados para que
 * testes possam ser feitos.
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 *
 */
public class BancoDeDadosEpisodio {
	// ===================================================================================
	// Atributos da classe - arrays para receber dados
	// e inteiros para tamanhos dos arrays
	// instancias da classe Episodio
	private static Episodio[] bdEpisodio = new Episodio[100];
	// instancias da classe CaracteristicaDor
	private static CaracteristicaDor[] bdCaractDor = new CaracteristicaDor[100];
	// instancias da classe CaracteristicaMedicamento
	private static CaracteristicaMedicamento[] bdCaractMedic = new CaracteristicaMedicamento[100];
	// instancias da classe NomeTipoDor
	private static NomeTipoDor[] bdNomeTipoDor = new NomeTipoDor[100];
	// instancias da classe NomeGatilho
	private static NomeGatilho[] bdNomeGatilho = new NomeGatilho[100];
	// instancias da classe NomeLocalizacao
	private static NomeLocalizacao[] bdNomeLocal = new NomeLocalizacao[100];
	// instancias da classe NomeMedicamento
	private static NomeMedicamento[] bdNomeMedic = new NomeMedicamento[100];
	private static int qtdBDEpisodio = 0; // quantidade de Episodio instanciados
	private static int qtdBDCaractDor = 0; // quantidade de CaracteristicaDor instanciados
	private static int qtdBDCaractMedic = 0; // quantidade de CaracteristicaMedicamento
												// instanciados
	private static int qtdBDNomeTipoDor = 0; // quantidade de NomeTipoDor instanciados
	private static int qtdBDNomeGatilho = 0; // quantidade de NomeGatilho instanciados
	private static int qtdBDNomeLocal = 0; // quantidade de NomeLocalizacao instanciados
	private static int qtdBDNomeMedic = 0; // quantidade de NomeMedicamento instanciados

	// ===================================================================================
	/**
	 * Carrega dados simulando um banco de dados para testar o programa.
	 * 
	 */
	public BancoDeDadosEpisodio() {
		// ===============================================================================
		bdNomeTipoDor[0] = new NomeTipoDor("Afiada");
		bdNomeTipoDor[1] = new NomeTipoDor("Constante");
		bdNomeTipoDor[2] = new NomeTipoDor("Latejante");
		bdNomeTipoDor[3] = new NomeTipoDor("Tensao");
		bdNomeTipoDor[4] = new NomeTipoDor("Pressao");
		bdNomeTipoDor[5] = new NomeTipoDor("Piercing");
		bdNomeTipoDor[6] = new NomeTipoDor("Enxaqueca");
		bdNomeTipoDor[7] = new NomeTipoDor("Grupo");
		bdNomeTipoDor[8] = new NomeTipoDor("Macante");
		// ===============================================================================
		setQtdBDNomeTipoDor(9);
		// ===============================================================================
		bdNomeGatilho[0] = new NomeGatilho("Atividade fisica intensa");
		bdNomeGatilho[1] = new NomeGatilho("Cafeina");
		bdNomeGatilho[2] = new NomeGatilho("Dormiu por um periodo muito longo");
		bdNomeGatilho[3] = new NomeGatilho("Dormiu por um periodo muito curto");
		bdNomeGatilho[4] = new NomeGatilho("Mudanca na rotina diaria");
		bdNomeGatilho[5] = new NomeGatilho("Mudanca no clima");
		bdNomeGatilho[6] = new NomeGatilho("Odores Fortes");
		bdNomeGatilho[7] = new NomeGatilho("Postura incorreta");
		bdNomeGatilho[8] = new NomeGatilho("Ingestao de alcool");
		// ===============================================================================
		setQtdBDNomeGatilho(9);
		// ===============================================================================
		bdNomeLocal[0] = new NomeLocalizacao("Em Ambos lados");
		bdNomeLocal[1] = new NomeLocalizacao("Atras dos olhos");
		bdNomeLocal[2] = new NomeLocalizacao("No pescoco");
		bdNomeLocal[3] = new NomeLocalizacao("No lado esquerdo");
		bdNomeLocal[4] = new NomeLocalizacao("No lado direito");
		bdNomeLocal[5] = new NomeLocalizacao("Atras da cabeca");
		bdNomeLocal[6] = new NomeLocalizacao("Nas temporas");
		bdNomeLocal[7] = new NomeLocalizacao("Na testa");
		bdNomeLocal[8] = new NomeLocalizacao("No topo da cabeca");
		// ===============================================================================
		setQtdBDNomeLocal(9);
		// ===============================================================================
		bdNomeMedic[0] = new NomeMedicamento("Paracetamol");
		bdNomeMedic[1] = new NomeMedicamento("Advil");
		bdNomeMedic[2] = new NomeMedicamento("Aspirina");
		bdNomeMedic[3] = new NomeMedicamento("Dipirona");
		bdNomeMedic[4] = new NomeMedicamento("Ibuprofeno");
		bdNomeMedic[5] = new NomeMedicamento("Naproxeno");
		bdNomeMedic[6] = new NomeMedicamento("Rizatriptano");
		bdNomeMedic[7] = new NomeMedicamento("Sumatriptano");
		// ===============================================================================
		setQtdBDNomeMedic(8);
		// ===============================================================================
		bdCaractDor[0] = new CaracteristicaDor(bdNomeTipoDor[0], bdNomeGatilho[3],
				bdNomeLocal[0], "Nausea", 2);
		bdCaractDor[1] = new CaracteristicaDor(bdNomeTipoDor[8], bdNomeGatilho[0],
				bdNomeLocal[6], "Aurea", 6);
		bdCaractDor[2] = new CaracteristicaDor(bdNomeTipoDor[2], bdNomeGatilho[7],
				bdNomeLocal[0], "Vomito", 9);
		bdCaractDor[3] = new CaracteristicaDor(bdNomeTipoDor[6], bdNomeGatilho[1],
				bdNomeLocal[2], "Nenhum", 3);
		bdCaractDor[4] = new CaracteristicaDor(bdNomeTipoDor[7], bdNomeGatilho[4],
				bdNomeLocal[4], "Nenhum", 5);
		bdCaractDor[5] = new CaracteristicaDor(bdNomeTipoDor[4], bdNomeGatilho[6],
				bdNomeLocal[5], "Nenhum", 1);
		bdCaractDor[6] = new CaracteristicaDor(bdNomeTipoDor[1], bdNomeGatilho[4],
				bdNomeLocal[3], "Vomito", 8);
		bdCaractDor[7] = new CaracteristicaDor(bdNomeTipoDor[5], bdNomeGatilho[5],
				bdNomeLocal[1], "Aurea", 4);
		bdCaractDor[8] = new CaracteristicaDor(bdNomeTipoDor[3], bdNomeGatilho[3],
				bdNomeLocal[3], "Nenhum", 7);
		bdCaractDor[9] = new CaracteristicaDor(bdNomeTipoDor[6], bdNomeGatilho[0],
				bdNomeLocal[4], "Nenhum", 1);
		bdCaractDor[10] = new CaracteristicaDor(bdNomeTipoDor[7], bdNomeGatilho[8],
				bdNomeLocal[1], "Nenhum", 2);
		bdCaractDor[11] = new CaracteristicaDor(bdNomeTipoDor[8], bdNomeGatilho[1],
				bdNomeLocal[5], "Nausea", 5);
		bdCaractDor[12] = new CaracteristicaDor(bdNomeTipoDor[1], bdNomeGatilho[4],
				bdNomeLocal[2], "Nenhum", 3);
		bdCaractDor[13] = new CaracteristicaDor(bdNomeTipoDor[3], bdNomeGatilho[6],
				bdNomeLocal[6], "Nausea", 9);
		bdCaractDor[14] = new CaracteristicaDor(bdNomeTipoDor[2], bdNomeGatilho[0],
				bdNomeLocal[1], "Vomito", 5);
		bdCaractDor[15] = new CaracteristicaDor(bdNomeTipoDor[0], bdNomeGatilho[7],
				bdNomeLocal[3], "Nenhum", 8);
		bdCaractDor[16] = new CaracteristicaDor(bdNomeTipoDor[5], bdNomeGatilho[8],
				bdNomeLocal[6], "Aurea", 6);
		bdCaractDor[17] = new CaracteristicaDor(bdNomeTipoDor[4], bdNomeGatilho[5],
				bdNomeLocal[4], "Nenhum", 2);
		bdCaractDor[18] = new CaracteristicaDor(bdNomeTipoDor[2], bdNomeGatilho[3],
				bdNomeLocal[6], "Nenhum", 1);
		bdCaractDor[19] = new CaracteristicaDor(bdNomeTipoDor[5], bdNomeGatilho[0],
				bdNomeLocal[1], "Nenhum", 4);
		bdCaractDor[20] = new CaracteristicaDor(bdNomeTipoDor[0], bdNomeGatilho[7],
				bdNomeLocal[8], "Aurea", 8);
		bdCaractDor[21] = new CaracteristicaDor(bdNomeTipoDor[6], bdNomeGatilho[6],
				bdNomeLocal[2], "Nenhum", 9);
		bdCaractDor[22] = new CaracteristicaDor(bdNomeTipoDor[1], bdNomeGatilho[2],
				bdNomeLocal[8], "Vomito", 3);
		bdCaractDor[23] = new CaracteristicaDor(bdNomeTipoDor[3], bdNomeGatilho[4],
				bdNomeLocal[2], "Nenhum", 5);
		bdCaractDor[24] = new CaracteristicaDor(bdNomeTipoDor[8], bdNomeGatilho[1],
				bdNomeLocal[8], "Nenhum", 9);
		bdCaractDor[25] = new CaracteristicaDor(bdNomeTipoDor[8], bdNomeGatilho[5],
				bdNomeLocal[7], "Aurea", 4);
		bdCaractDor[26] = new CaracteristicaDor(bdNomeTipoDor[5], bdNomeGatilho[8],
				bdNomeLocal[0], "Nenhum", 1);
		bdCaractDor[27] = new CaracteristicaDor(bdNomeTipoDor[7], bdNomeGatilho[6],
				bdNomeLocal[7], "Nenhum", 3);
		bdCaractDor[28] = new CaracteristicaDor(bdNomeTipoDor[4], bdNomeGatilho[7],
				bdNomeLocal[2], "Nausea", 7);
		bdCaractDor[29] = new CaracteristicaDor(bdNomeTipoDor[1], bdNomeGatilho[3],
				bdNomeLocal[7], "Nenhum", 8);
		bdCaractDor[30] = new CaracteristicaDor(bdNomeTipoDor[6], bdNomeGatilho[0],
				bdNomeLocal[0], "Nenhum", 9);
		bdCaractDor[31] = new CaracteristicaDor(bdNomeTipoDor[7], bdNomeGatilho[8],
				bdNomeLocal[2], "Nenhum", 5);
		bdCaractDor[32] = new CaracteristicaDor(bdNomeTipoDor[3], bdNomeGatilho[7],
				bdNomeLocal[2], "Nausea", 2);
		bdCaractDor[33] = new CaracteristicaDor(bdNomeTipoDor[0], bdNomeGatilho[1],
				bdNomeLocal[8], "Nenhum", 6);
		bdCaractDor[34] = new CaracteristicaDor(bdNomeTipoDor[2], bdNomeGatilho[6],
				bdNomeLocal[7], "Nenhum", 2);
		bdCaractDor[35] = new CaracteristicaDor(bdNomeTipoDor[4], bdNomeGatilho[0],
				bdNomeLocal[3], "Aurea", 4);
		bdCaractDor[36] = new CaracteristicaDor(bdNomeTipoDor[5], bdNomeGatilho[2],
				bdNomeLocal[3], "Nenhum", 8);
		bdCaractDor[37] = new CaracteristicaDor(bdNomeTipoDor[0], bdNomeGatilho[5],
				bdNomeLocal[1], "Nenhum", 7);
		bdCaractDor[38] = new CaracteristicaDor(bdNomeTipoDor[6], bdNomeGatilho[4],
				bdNomeLocal[4], "Nenhum", 4);
		bdCaractDor[39] = new CaracteristicaDor(bdNomeTipoDor[3], bdNomeGatilho[4],
				bdNomeLocal[5], "Nenhum", 3);
		bdCaractDor[40] = new CaracteristicaDor(bdNomeTipoDor[6], bdNomeGatilho[1],
				bdNomeLocal[1], "Vomito", 6);
		bdCaractDor[41] = new CaracteristicaDor(bdNomeTipoDor[7], bdNomeGatilho[7],
				bdNomeLocal[0], "Nenhum", 6);
		bdCaractDor[42] = new CaracteristicaDor(bdNomeTipoDor[6], bdNomeGatilho[4],
				bdNomeLocal[6], "Nenhum", 1);
		bdCaractDor[43] = new CaracteristicaDor(bdNomeTipoDor[1], bdNomeGatilho[6],
				bdNomeLocal[8], "Nenhum", 5);
		bdCaractDor[44] = new CaracteristicaDor(bdNomeTipoDor[3], bdNomeGatilho[8],
				bdNomeLocal[0], "Vomito", 7);
		bdCaractDor[45] = new CaracteristicaDor(bdNomeTipoDor[8], bdNomeGatilho[2],
				bdNomeLocal[6], "Nenhum", 8);
		bdCaractDor[46] = new CaracteristicaDor(bdNomeTipoDor[8], bdNomeGatilho[2],
				bdNomeLocal[6], "Nenhum", 6);
		bdCaractDor[47] = new CaracteristicaDor(bdNomeTipoDor[7], bdNomeGatilho[5],
				bdNomeLocal[2], "Nausea", 2);
		bdCaractDor[48] = new CaracteristicaDor(bdNomeTipoDor[4], bdNomeGatilho[4],
				bdNomeLocal[2], "Nenhum", 4);
		bdCaractDor[49] = new CaracteristicaDor(bdNomeTipoDor[1], bdNomeGatilho[1],
				bdNomeLocal[8], "Nenhum", 5);
		bdCaractDor[50] = new CaracteristicaDor(bdNomeTipoDor[5], bdNomeGatilho[8],
				bdNomeLocal[4], "Nenhum", 6);
		bdCaractDor[51] = new CaracteristicaDor(bdNomeTipoDor[3], bdNomeGatilho[6],
				bdNomeLocal[6], "Nenhum", 7);
		bdCaractDor[52] = new CaracteristicaDor(bdNomeTipoDor[1], bdNomeGatilho[1],
				bdNomeLocal[4], "Aurea", 1);
		bdCaractDor[53] = new CaracteristicaDor(bdNomeTipoDor[6], bdNomeGatilho[4],
				bdNomeLocal[3], "Nenhum", 8);
		bdCaractDor[54] = new CaracteristicaDor(bdNomeTipoDor[7], bdNomeGatilho[2],
				bdNomeLocal[3], "Nenhum", 5);
		bdCaractDor[55] = new CaracteristicaDor(bdNomeTipoDor[3], bdNomeGatilho[5],
				bdNomeLocal[2], "Nenhum", 1);
		bdCaractDor[56] = new CaracteristicaDor(bdNomeTipoDor[0], bdNomeGatilho[6],
				bdNomeLocal[8], "Nausea", 7);
		bdCaractDor[57] = new CaracteristicaDor(bdNomeTipoDor[2], bdNomeGatilho[7],
				bdNomeLocal[8], "Nenhum", 6);
		bdCaractDor[58] = new CaracteristicaDor(bdNomeTipoDor[7], bdNomeGatilho[8],
				bdNomeLocal[2], "Vomito", 1);
		bdCaractDor[59] = new CaracteristicaDor(bdNomeTipoDor[3], bdNomeGatilho[1],
				bdNomeLocal[6], "Nenhum", 3);
		// ===============================================================================
		setQtdBDCaractDor(60);
		// ===============================================================================
		bdCaractMedic[0] = new CaracteristicaMedicamento(bdNomeMedic[3], "Um pouco");
		bdCaractMedic[1] = new CaracteristicaMedicamento(bdNomeMedic[2], "Sim");
		bdCaractMedic[2] = new CaracteristicaMedicamento(bdNomeMedic[1], "Nao");
		bdCaractMedic[3] = new CaracteristicaMedicamento(bdNomeMedic[7], "Um pouco");
		bdCaractMedic[4] = new CaracteristicaMedicamento(bdNomeMedic[0], "Um pouco");
		bdCaractMedic[5] = new CaracteristicaMedicamento(bdNomeMedic[7], "Um pouco");
		bdCaractMedic[6] = new CaracteristicaMedicamento(bdNomeMedic[4], "Nao");
		bdCaractMedic[7] = new CaracteristicaMedicamento(bdNomeMedic[5], "Sim");
		bdCaractMedic[8] = new CaracteristicaMedicamento(bdNomeMedic[6], "Sim");
		bdCaractMedic[9] = new CaracteristicaMedicamento(bdNomeMedic[1], "Um pouco");
		bdCaractMedic[10] = new CaracteristicaMedicamento(bdNomeMedic[3], "Nao");
		bdCaractMedic[11] = new CaracteristicaMedicamento(bdNomeMedic[2], "Nao");
		bdCaractMedic[12] = new CaracteristicaMedicamento(bdNomeMedic[5], "Um pouco");
		bdCaractMedic[13] = new CaracteristicaMedicamento(bdNomeMedic[4], "Sim");
		bdCaractMedic[14] = new CaracteristicaMedicamento(bdNomeMedic[0], "Nao");
		bdCaractMedic[15] = new CaracteristicaMedicamento(bdNomeMedic[6], "Sim");
		bdCaractMedic[16] = new CaracteristicaMedicamento(bdNomeMedic[0], "Nao");
		bdCaractMedic[17] = new CaracteristicaMedicamento(bdNomeMedic[5], "Nao");
		bdCaractMedic[18] = new CaracteristicaMedicamento(bdNomeMedic[3], "Sim");
		bdCaractMedic[19] = new CaracteristicaMedicamento(bdNomeMedic[7], "Sim");
		bdCaractMedic[20] = new CaracteristicaMedicamento(bdNomeMedic[7], "Nao");
		bdCaractMedic[21] = new CaracteristicaMedicamento(bdNomeMedic[4], "Nao");
		bdCaractMedic[22] = new CaracteristicaMedicamento(bdNomeMedic[7], "Um pouco");
		bdCaractMedic[23] = new CaracteristicaMedicamento(bdNomeMedic[4], "Sim");
		bdCaractMedic[24] = new CaracteristicaMedicamento(bdNomeMedic[3], "Um pouco");
		bdCaractMedic[25] = new CaracteristicaMedicamento(bdNomeMedic[6], "Um pouco");
		bdCaractMedic[26] = new CaracteristicaMedicamento(bdNomeMedic[1], "Um pouco");
		bdCaractMedic[27] = new CaracteristicaMedicamento(bdNomeMedic[3], "Nao");
		bdCaractMedic[28] = new CaracteristicaMedicamento(bdNomeMedic[2], "Sim");
		bdCaractMedic[29] = new CaracteristicaMedicamento(bdNomeMedic[5], "Um pouco");
		bdCaractMedic[30] = new CaracteristicaMedicamento(bdNomeMedic[4], "Nao");
		bdCaractMedic[31] = new CaracteristicaMedicamento(bdNomeMedic[7], "Sim");
		bdCaractMedic[32] = new CaracteristicaMedicamento(bdNomeMedic[3], "Sim");
		bdCaractMedic[33] = new CaracteristicaMedicamento(bdNomeMedic[3], "Um pouco");
		bdCaractMedic[34] = new CaracteristicaMedicamento(bdNomeMedic[3], "Sim");
		bdCaractMedic[35] = new CaracteristicaMedicamento(bdNomeMedic[0], "Sim");
		bdCaractMedic[36] = new CaracteristicaMedicamento(bdNomeMedic[7], "Nao");
		bdCaractMedic[37] = new CaracteristicaMedicamento(bdNomeMedic[3], "Sim");
		bdCaractMedic[38] = new CaracteristicaMedicamento(bdNomeMedic[2], "Sim");
		bdCaractMedic[39] = new CaracteristicaMedicamento(bdNomeMedic[5], "Um pouco");
		bdCaractMedic[40] = new CaracteristicaMedicamento(bdNomeMedic[4], "Um pouco");
		bdCaractMedic[41] = new CaracteristicaMedicamento(bdNomeMedic[5], "Sim");
		bdCaractMedic[42] = new CaracteristicaMedicamento(bdNomeMedic[3], "Sim");
		bdCaractMedic[43] = new CaracteristicaMedicamento(bdNomeMedic[7], "Um pouco");
		bdCaractMedic[44] = new CaracteristicaMedicamento(bdNomeMedic[7], "Nao");
		bdCaractMedic[45] = new CaracteristicaMedicamento(bdNomeMedic[3], "Nao");
		bdCaractMedic[46] = new CaracteristicaMedicamento(bdNomeMedic[4], "Um pouco");
		bdCaractMedic[47] = new CaracteristicaMedicamento(bdNomeMedic[7], "Sim");
		bdCaractMedic[48] = new CaracteristicaMedicamento(bdNomeMedic[4], "Sim");
		bdCaractMedic[49] = new CaracteristicaMedicamento(bdNomeMedic[0], "Um pouco");
		bdCaractMedic[50] = new CaracteristicaMedicamento(bdNomeMedic[6], "Nao");
		bdCaractMedic[51] = new CaracteristicaMedicamento(bdNomeMedic[6], "Nao");
		bdCaractMedic[52] = new CaracteristicaMedicamento(bdNomeMedic[1], "Um pouco");
		bdCaractMedic[53] = new CaracteristicaMedicamento(bdNomeMedic[5], "Sim");
		bdCaractMedic[54] = new CaracteristicaMedicamento(bdNomeMedic[2], "Sim");
		bdCaractMedic[55] = new CaracteristicaMedicamento(bdNomeMedic[3], "Nao");
		bdCaractMedic[56] = new CaracteristicaMedicamento(bdNomeMedic[5], "Nao");
		bdCaractMedic[57] = new CaracteristicaMedicamento(bdNomeMedic[4], "Um pouco");
		bdCaractMedic[58] = new CaracteristicaMedicamento(bdNomeMedic[0], "Um pouco");
		bdCaractMedic[59] = new CaracteristicaMedicamento(bdNomeMedic[6], "Nao");
		// ===============================================================================
		setQtdBDCaractMedic(60);
		// ===============================================================================
		bdEpisodio[0] = new Episodio("Pedro", 14, 8, 2022, "08_2022", 8, 38, 9,
				bdCaractDor[0], bdCaractMedic[0],
				"Observacoes - Pedro - 14/08/2022 8:38");
		bdEpisodio[1] = new Episodio("Pedro", 5, 7, 2022, "07_2022", 16, 18, 2,
				bdCaractDor[1], bdCaractMedic[1],
				"Observacoes - Pedro - 05/07/2022 16:18");
		bdEpisodio[2] = new Episodio("Rosa", 5, 8, 2022, "08_2022", 10, 5, 5,
				bdCaractDor[2], bdCaractMedic[2], "Observacoes - Rosa - 05/08/2022 10:5");
		bdEpisodio[3] = new Episodio("Rita", 1, 7, 2022, "07_2022", 18, 46, 3,
				bdCaractDor[3], bdCaractMedic[3],
				"Observacoes - Rita - 01/07/2022 18:46");
		bdEpisodio[4] = new Episodio("Adriana", 1, 9, 2022, "09_2022", 10, 40, 18,
				bdCaractDor[4], bdCaractMedic[4],
				"Observacoes - Adriana - 01/09/2022 10:40");
		bdEpisodio[5] = new Episodio("Rosa", 17, 7, 2022, "07_2022", 12, 57, 8,
				bdCaractDor[5], bdCaractMedic[5],
				"Observacoes - Rosa - 17/07/2022 12:57");
		bdEpisodio[6] = new Episodio("Daniel", 3, 8, 2022, "08_2022", 20, 11, 11,
				bdCaractDor[6], bdCaractMedic[6],
				"Observacoes - Daniel - 03/08/2022 20:11");
		bdEpisodio[7] = new Episodio("Pedro", 4, 7, 2022, "07_2022", 19, 32, 8,
				bdCaractDor[7], bdCaractMedic[7],
				"Observacoes - Pedro - 04/07/2022 19:32");
		bdEpisodio[8] = new Episodio("Adriana", 8, 7, 2022, "07_2022", 21, 0, 19,
				bdCaractDor[8], bdCaractMedic[8],
				"Observacoes - Adriana - 08/07/2022 21:0");
		bdEpisodio[9] = new Episodio("Daniel", 16, 8, 2022, "08_2022", 12, 1, 16,
				bdCaractDor[9], bdCaractMedic[9],
				"Observacoes - Daniel - 16/08/2022 12:1");
		bdEpisodio[10] = new Episodio("Adriana", 29, 7, 2022, "07_2022", 16, 45, 13,
				bdCaractDor[10], bdCaractMedic[10],
				"Observacoes - Adriana - 29/07/2022 16:45");
		bdEpisodio[11] = new Episodio("Rita", 6, 8, 2022, "08_2022", 20, 16, 12,
				bdCaractDor[11], bdCaractMedic[11],
				"Observacoes - Rita - 06/08/2022 20:16");
		bdEpisodio[12] = new Episodio("Gabriela", 23, 8, 2022, "08_2022", 2, 46, 9,
				bdCaractDor[12], bdCaractMedic[12],
				"Observacoes - Gabriela - 23/08/2022 2:46");
		bdEpisodio[13] = new Episodio("Rosa", 2, 9, 2022, "09_2022", 20, 45, 14,
				bdCaractDor[13], bdCaractMedic[13],
				"Observacoes - Rosa - 02/09/2022 20:45");
		bdEpisodio[14] = new Episodio("Pedro", 27, 8, 2022, "08_2022", 1, 37, 3,
				bdCaractDor[14], bdCaractMedic[14],
				"Observacoes - Pedro - 27/08/2022 1:37");
		bdEpisodio[15] = new Episodio("Adriana", 9, 7, 2022, "07_2022", 20, 49, 9,
				bdCaractDor[15], bdCaractMedic[15],
				"Observacoes - Adriana - 09/07/2022 20:49");
		bdEpisodio[16] = new Episodio("Gabriela", 15, 8, 2022, "08_2022", 7, 35, 14,
				bdCaractDor[16], bdCaractMedic[16],
				"Observacoes - Gabriela - 15/08/2022 7:35");
		bdEpisodio[17] = new Episodio("Adriana", 9, 7, 2022, "07_2022", 17, 30, 18,
				bdCaractDor[17], bdCaractMedic[17],
				"Observacoes - Adriana - 09/07/2022 17:30");
		bdEpisodio[18] = new Episodio("Rita", 6, 8, 2022, "08_2022", 5, 4, 19,
				bdCaractDor[18], bdCaractMedic[18],
				"Observacoes - Rita - 06/08/2022 5:4");
		bdEpisodio[19] = new Episodio("Pedro", 5, 7, 2022, "07_2022", 2, 8, 1,
				bdCaractDor[19], bdCaractMedic[19],
				"Observacoes - Pedro - 05/07/2022 2:8");
		bdEpisodio[20] = new Episodio("Adriana", 30, 8, 2022, "08_2022", 11, 52, 3,
				bdCaractDor[20], bdCaractMedic[20],
				"Observacoes - Adriana - 30/08/2022 11:52");
		bdEpisodio[21] = new Episodio("Rita", 21, 7, 2022, "07_2022", 9, 58, 12,
				bdCaractDor[21], bdCaractMedic[21],
				"Observacoes - Rita - 21/07/2022 9:58");
		bdEpisodio[22] = new Episodio("Daniel", 28, 8, 2022, "08_2022", 12, 2, 4,
				bdCaractDor[22], bdCaractMedic[22],
				"Observacoes - Daniel - 28/08/2022 12:2");
		bdEpisodio[23] = new Episodio("Rita", 5, 9, 2022, "09_2022", 9, 1, 17,
				bdCaractDor[23], bdCaractMedic[23],
				"Observacoes - Rita - 05/09/2022 9:1");
		bdEpisodio[24] = new Episodio("Rosa", 20, 7, 2022, "07_2022", 1, 21, 3,
				bdCaractDor[24], bdCaractMedic[24],
				"Observacoes - Rosa - 20/07/2022 1:21");
		bdEpisodio[25] = new Episodio("Adriana", 20, 7, 2022, "07_2022", 19, 32, 5,
				bdCaractDor[25], bdCaractMedic[25],
				"Observacoes - Adriana - 20/07/2022 19:32");
		bdEpisodio[26] = new Episodio("Rita", 10, 7, 2022, "07_2022", 17, 20, 2,
				bdCaractDor[26], bdCaractMedic[26],
				"Observacoes - Rita - 10/07/2022 17:20");
		bdEpisodio[27] = new Episodio("Adriana", 7, 9, 2022, "09_2022", 7, 13, 16,
				bdCaractDor[27], bdCaractMedic[27],
				"Observacoes - Adriana - 07/09/2022 7:13");
		bdEpisodio[28] = new Episodio("Pedro", 15, 8, 2022, "08_2022", 2, 49, 10,
				bdCaractDor[28], bdCaractMedic[28],
				"Observacoes - Pedro - 15/08/2022 2:49");
		bdEpisodio[29] = new Episodio("Rita", 19, 7, 2022, "07_2022", 18, 4, 0,
				bdCaractDor[29], bdCaractMedic[29],
				"Observacoes - Rita - 19/07/2022 18:4");
		bdEpisodio[30] = new Episodio("Daniel", 18, 7, 2022, "07_2022", 15, 6, 15,
				bdCaractDor[30], bdCaractMedic[30],
				"Observacoes - Daniel - 18/07/2022 15:6");
		bdEpisodio[31] = new Episodio("Rosa", 22, 8, 2022, "08_2022", 23, 10, 5,
				bdCaractDor[31], bdCaractMedic[31],
				"Observacoes - Rosa - 22/08/2022 23:10");
		bdEpisodio[32] = new Episodio("Gabriela", 11, 7, 2022, "07_2022", 11, 26, 5,
				bdCaractDor[32], bdCaractMedic[32],
				"Observacoes - Gabriela - 11/07/2022 11:26");
		bdEpisodio[33] = new Episodio("Adriana", 13, 7, 2022, "07_2022", 22, 43, 7,
				bdCaractDor[33], bdCaractMedic[33],
				"Observacoes - Adriana - 13/07/2022 22:43");
		bdEpisodio[34] = new Episodio("Rita", 15, 7, 2022, "07_2022", 18, 28, 18,
				bdCaractDor[34], bdCaractMedic[34],
				"Observacoes - Rita - 15/07/2022 18:28");
		bdEpisodio[35] = new Episodio("Gabriela", 28, 7, 2022, "07_2022", 11, 1, 19,
				bdCaractDor[35], bdCaractMedic[35],
				"Observacoes - Gabriela - 28/07/2022 11:1");
		bdEpisodio[36] = new Episodio("Rita", 8, 7, 2022, "07_2022", 22, 40, 2,
				bdCaractDor[36], bdCaractMedic[36],
				"Observacoes - Rita - 08/07/2022 22:40");
		bdEpisodio[37] = new Episodio("Rosa", 23, 7, 2022, "07_2022", 14, 17, 2,
				bdCaractDor[37], bdCaractMedic[37],
				"Observacoes - Rosa - 23/07/2022 14:17");
		bdEpisodio[38] = new Episodio("Gabriela", 17, 7, 2022, "07_2022", 8, 54, 17,
				bdCaractDor[38], bdCaractMedic[38],
				"Observacoes - Gabriela - 17/07/2022 8:54");
		bdEpisodio[39] = new Episodio("Adriana", 25, 8, 2022, "08_2022", 21, 41, 9,
				bdCaractDor[39], bdCaractMedic[39],
				"Observacoes - Adriana - 25/08/2022 21:41");
		bdEpisodio[40] = new Episodio("Rita", 5, 9, 2022, "09_2022", 0, 23, 8,
				bdCaractDor[40], bdCaractMedic[40],
				"Observacoes - Rita - 05/09/2022 0:23");
		bdEpisodio[41] = new Episodio("Rosa", 27, 8, 2022, "08_2022", 22, 25, 1,
				bdCaractDor[41], bdCaractMedic[41],
				"Observacoes - Rosa - 27/08/2022 22:25");
		bdEpisodio[42] = new Episodio("Pedro", 30, 7, 2022, "07_2022", 18, 29, 10,
				bdCaractDor[42], bdCaractMedic[42],
				"Observacoes - Pedro - 30/07/2022 18:29");
		bdEpisodio[43] = new Episodio("Adriana", 9, 9, 2022, "09_2022", 13, 7, 10,
				bdCaractDor[43], bdCaractMedic[43],
				"Observacoes - Adriana - 09/09/2022 13:7");
		bdEpisodio[44] = new Episodio("Rita", 11, 7, 2022, "07_2022", 5, 24, 8,
				bdCaractDor[44], bdCaractMedic[44],
				"Observacoes - Rita - 11/07/2022 5:24");
		bdEpisodio[45] = new Episodio("Daniel", 31, 8, 2022, "08_2022", 15, 52, 9,
				bdCaractDor[45], bdCaractMedic[45],
				"Observacoes - Daniel - 31/08/2022 15:52");
		bdEpisodio[46] = new Episodio("Pedro", 8, 8, 2022, "08_2022", 8, 5, 16,
				bdCaractDor[46], bdCaractMedic[46],
				"Observacoes - Pedro - 08/08/2022 8:5");
		bdEpisodio[47] = new Episodio("Rosa", 6, 9, 2022, "09_2022", 10, 44, 6,
				bdCaractDor[47], bdCaractMedic[47],
				"Observacoes - Rosa - 06/09/2022 10:44");
		bdEpisodio[48] = new Episodio("Rita", 21, 8, 2022, "08_2022", 10, 24, 9,
				bdCaractDor[48], bdCaractMedic[48],
				"Observacoes - Rita - 21/08/2022 10:24");
		bdEpisodio[49] = new Episodio("Adriana", 9, 9, 2022, "09_2022", 15, 52, 1,
				bdCaractDor[49], bdCaractMedic[49],
				"Observacoes - Adriana - 09/09/2022 15:52");
		bdEpisodio[50] = new Episodio("Pedro", 26, 7, 2022, "07_2022", 16, 4, 15,
				bdCaractDor[50], bdCaractMedic[50],
				"Observacoes - Pedro - 26/07/2022 16:4");
		bdEpisodio[51] = new Episodio("Gabriela", 11, 7, 2022, "07_2022", 7, 3, 10,
				bdCaractDor[51], bdCaractMedic[51],
				"Observacoes - Gabriela - 11/07/2022 7:3");
		bdEpisodio[52] = new Episodio("Rosa", 12, 8, 2022, "08_2022", 12, 36, 8,
				bdCaractDor[52], bdCaractMedic[52],
				"Observacoes - Rosa - 12/08/2022 12:36");
		bdEpisodio[53] = new Episodio("Rita", 11, 7, 2022, "07_2022", 16, 49, 16,
				bdCaractDor[53], bdCaractMedic[53],
				"Observacoes - Rita - 11/07/2022 16:49");
		bdEpisodio[54] = new Episodio("Daniel", 24, 7, 2022, "07_2022", 23, 40, 20,
				bdCaractDor[54], bdCaractMedic[54],
				"Observacoes - Daniel - 24/07/2022 23:40");
		bdEpisodio[55] = new Episodio("Pedro", 11, 8, 2022, "08_2022", 6, 22, 16,
				bdCaractDor[55], bdCaractMedic[55],
				"Observacoes - Pedro - 11/08/2022 6:22");
		bdEpisodio[56] = new Episodio("Rosa", 14, 8, 2022, "08_2022", 2, 38, 7,
				bdCaractDor[56], bdCaractMedic[56],
				"Observacoes - Rosa - 14/08/2022 2:38");
		bdEpisodio[57] = new Episodio("Rita", 2, 7, 2022, "07_2022", 13, 38, 9,
				bdCaractDor[57], bdCaractMedic[57],
				"Observacoes - Rita - 02/07/2022 13:38");
		bdEpisodio[58] = new Episodio("Gabriela", 31, 8, 2022, "08_2022", 16, 48, 6,
				bdCaractDor[58], bdCaractMedic[58],
				"Observacoes - Gabriela - 31/08/2022 16:48");
		bdEpisodio[59] = new Episodio("Daniel", 30, 8, 2022, "08_2022", 6, 10, 6,
				bdCaractDor[59], bdCaractMedic[59],
				"Observacoes - Daniel - 30/08/2022 6:10");
		// ===============================================================================
		setQtdBDEpisodio(60);
		// ===============================================================================
	}

	// ===================================================================================
	public static CaracteristicaDor[] getBdCaractDor() {
		return bdCaractDor;
	}

	public static CaracteristicaDor getBdCaractDor(int indiceEpisodio) {
		return bdCaractDor[indiceEpisodio];
	}

	public void setBdCaractDor(CaracteristicaDor[] bDCaractDor) {
		bdCaractDor = bDCaractDor;
	}

	public static void setBdCaractDor(CaracteristicaDor bDCaractDor, int indiceEpisodio) {
		bdCaractDor[indiceEpisodio] = bDCaractDor;
	}

	// ===================================================================================
	public static CaracteristicaMedicamento[] getBdCaractMedic() {
		return bdCaractMedic;
	}

	public static CaracteristicaMedicamento getBdCaractMedic(int indiceEpisodio) {
		return bdCaractMedic[indiceEpisodio];
	}

	public void setBdCaractMedic(CaracteristicaMedicamento[] bDCaractMedic) {
		bdCaractMedic = bDCaractMedic;
	}

	public static void setBdCaractMedic(CaracteristicaMedicamento bDCaractMedic,
			int indiceEpisodio) {
		bdCaractMedic[indiceEpisodio] = bDCaractMedic;
	}

	// ===================================================================================
	public static Episodio[] getBdEpisodio() {
		return bdEpisodio;
	}

	public static Episodio getBdEpisodio(int indiceEpisodio) {
		return bdEpisodio[indiceEpisodio];
	}

	public void setBdEpisodio(Episodio[] bDEpisodio) {
		bdEpisodio = bDEpisodio;
	}

	public static void setBdEpisodio(Episodio bDEpisodio, int indiceEpisodio) {
		bdEpisodio[indiceEpisodio] = bDEpisodio;
	}

	// ===================================================================================
	public static NomeGatilho[] getBdNomeGatilho() {
		// usado por ControleCadastroNomeCaracteristica
		return bdNomeGatilho;
	}

	public static NomeGatilho getBdNomeGatilho(int indiceNomeTipoDor) {
		// usado por ControleCadastroEpisodio
		return bdNomeGatilho[indiceNomeTipoDor];
	}

	public void setBdNomeGatilho(NomeGatilho[] bdNomeGat) {
		bdNomeGatilho = bdNomeGat;
	}

	public static void setBdNomeGatilho(NomeGatilho bdNomeGat, int indiceNomeGatilho) {
		bdNomeGatilho[indiceNomeGatilho] = bdNomeGat;
	}

	// ===================================================================================
	public static NomeLocalizacao[] getBdNomeLocal() {
		// usado por ControleCadastroNomeCaracteristica
		return bdNomeLocal;
	}

	public static NomeLocalizacao getBdNomeLocal(int indiceNomeLocal) {
		// usado por ControleCadastroEpisodio
		return bdNomeLocal[indiceNomeLocal];
	}

	public void setBdNomeLocal(NomeLocalizacao[] bdNomeLocalizacao) {
		bdNomeLocal = bdNomeLocalizacao;
	}

	public static void setBdNomeLocal(NomeLocalizacao bdNomeLocalizacao,
			int indiceNomeLocal) {
		bdNomeLocal[indiceNomeLocal] = bdNomeLocalizacao;
	}

	// ===================================================================================
	public static NomeMedicamento[] getBdNomeMedic() {
		// usado por ControleCadastroNomeCaracteristica
		return bdNomeMedic;
	}

	public static NomeMedicamento getBdNomeMedic(int indiceNomeMedic) {
		// usado por ControleCadastroEpisodio
		return bdNomeMedic[indiceNomeMedic];
	}

	public void setBdNomeMedic(NomeMedicamento[] bdNomeMedicamento) {
		bdNomeMedic = bdNomeMedicamento;
	}

	public static void setBdNomeMedic(NomeMedicamento bdNomeMedicamento,
			int indiceNomeMedic) {
		bdNomeMedic[indiceNomeMedic] = bdNomeMedicamento;
	}

	// ===================================================================================
	public static NomeTipoDor[] getBdNomeTipoDor() {
		// usado por ControleCadastroNomeCaracteristica
		return bdNomeTipoDor;
	}

	public static NomeTipoDor getBdNomeTipoDor(int indiceNomeTipoDor) {
		// usado por ControleCadastroEpisodio
		return bdNomeTipoDor[indiceNomeTipoDor];
	}

	public void setBdNomeTipoDor(NomeTipoDor[] bdNomeTipDor) {
		bdNomeTipoDor = bdNomeTipDor;
	}

	public static void setBdNomeTipoDor(NomeTipoDor bdNomeTipDor, int indiceNomeTipoDor) {
		bdNomeTipoDor[indiceNomeTipoDor] = bdNomeTipDor;
	}

	// ===================================================================================
	public static int getQtdBDCaractDor() {
		// usado por ControleCadastroEpisodio
		return qtdBDCaractDor;
	}

	public static void setQtdBDCaractDor(int qtddBDCaractDor) {
		// esse
		qtdBDCaractDor = qtddBDCaractDor;
	}

	// ===================================================================================
	public static int getQtdBDCaractMedic() {
		// usado por ControleCadastroEpisodio
		return qtdBDCaractMedic;
	}

	public static void setQtdBDCaractMedic(int qtddBDCaractMedic) {
		// esse
		qtdBDCaractMedic = qtddBDCaractMedic;
	}

	// ===================================================================================
	public static int getQtdBDEpisodio() {
		// usado por ControleCadastroEpisodio
		return qtdBDEpisodio;
	}

	public static void setQtdBDEpisodio(int qtddBDEpisodio) {
		// esse
		qtdBDEpisodio = qtddBDEpisodio;
	}

	// ===================================================================================
	public static int getQtdBDNomeGatilho() {
		// usado aqui
		// usado por ControleCadastroNomeCaracteristica
		return qtdBDNomeGatilho;
	}

	public static void setQtdBDNomeGatilho(int qtddBDItemGatilho) {
		// usado aqui
		qtdBDNomeGatilho = qtddBDItemGatilho;
	}

	// ===================================================================================
	public static int getQtdBDNomeLocal() {
		// usado aqui
		// usado por ControleCadastroNomeCaracteristica
		return qtdBDNomeLocal;
	}

	public static void setQtdBDNomeLocal(int qtddBDItemLocal) {
		// usado aqui
		qtdBDNomeLocal = qtddBDItemLocal;
	}

	// ===================================================================================
	public static int getQtdBDNomeMedic() {
		// usado aqui
		// usado por ControleCadastroNomeCaracteristica
		return qtdBDNomeMedic;
	}

	public static void setQtdBDNomeMedic(int qtddBDItemNomeMedic) {
		// usado aqui
		qtdBDNomeMedic = qtddBDItemNomeMedic;
	}

	// ===================================================================================
	public static int getQtdBDNomeTipoDor() {
		// usado aqui
		// usado por ControleCadastroNomeCaracteristica
		return qtdBDNomeTipoDor;
	}

	public static void setQtdBDNomeTipoDor(int qtddBDItemTipoDor) {
		// usado aqui
		qtdBDNomeTipoDor = qtddBDItemTipoDor;
	}

	// ===================================================================================

}
// fim da classe BancoDeDadosEpisodio
// =======================================================================================