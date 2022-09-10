//==========================================================================
package controle;

//==========================================================================
import modelo.BancoDeDadosEpisodio;
import modelo.CaracteristicaDor;
import modelo.CaracteristicaMedicamento;
import modelo.Episodio;
import modelo.NomeGatilho;
import modelo.NomeLocalizacao;
import modelo.NomeMedicamento;
import modelo.NomeTipoDor;

//=======================================================================================
/**
 * Classe que contem os metodos que permitem fazer o cadastro, a edicao, a
 * delecao e a busca de episodios.
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 *
 */
public class ControleCadastroEpisodio {
	// ===================================================================================
	private static ControleDados controleDados = new ControleDados();
	// ===================================================================================

	// ===================================================================================
	/**
	 * Construtor
	 * 
	 */
	public ControleCadastroEpisodio() {
		super();
	}

	// ===================================================================================
	/**
	 * Chama o metodo para inserir nova instancia de episodio
	 * 
	 * @return String retorna uma string com valores cadastrados
	 * 
	 * @param usuario           nome do usuario que teve o episodio de enxaqueca
	 * @param dataInicioDia     dia da data e hora da ocorrencia
	 * @param dataInicioMes     mes da data e hora da ocorrencia
	 * @param dataInicioAno     ano da data e hora da ocorrencia
	 * @param dataInicioMesAno  mes e ano da data e hora da ocorrencia usado em
	 *                          filtros e buscas
	 * @param horas             hora da data e hora da ocorrencia
	 * @param minutos           minutos da data e hora da ocorrencia
	 * @param duracaoHoras      duracao da dor de cabeca em horas
	 * @param indiceNomeTipoDor indice do tipo de dor
	 * @param indiceNomeGatilho indice do gatilho
	 * @param indiceNomeLocal   indice do local da dor
	 * @param sintoma           sintoma associado
	 * @param intensidade       intensidade da dor
	 * @param indiceNomeMedic   indice do nome do medicamento
	 * @param eficiencia        eficiencia do medicamento
	 * @param observacoes       notas adicionais que o usuario quiser registrar
	 * 
	 */
	public String inserirNovoEpisodio(String usuario, int dataInicioDia,
			int dataInicioMes, int dataInicioAno, String dataInicioMesAno, int horas,
			int minutos, int duracaoHoras, int indiceNomeTipoDor, int indiceNomeGatilho,
			int indiceNomeLocal, String sintoma, int intensidade, int indiceNomeMedic,
			String eficiencia, String observacoes) {
		// usado por TelaCadastroEdicaoEpisodio
		NomeTipoDor tipoDor = BancoDeDadosEpisodio.getBdNomeTipoDor(indiceNomeTipoDor);
		NomeGatilho gatilho = BancoDeDadosEpisodio.getBdNomeGatilho(indiceNomeGatilho);
		NomeLocalizacao local = BancoDeDadosEpisodio.getBdNomeLocal(indiceNomeLocal);
		NomeMedicamento nomeMedic = BancoDeDadosEpisodio.getBdNomeMedic(indiceNomeMedic);

		CaracteristicaDor bdCaractDor = CaracteristicaDor.inserirCaractDor(
				BancoDeDadosEpisodio.getQtdBDCaractDor(),
				new CaracteristicaDor(tipoDor, gatilho, local, sintoma, intensidade));

		CaracteristicaMedicamento bdCaractMedic = CaracteristicaMedicamento
				.inserirCaractMedic(BancoDeDadosEpisodio.getQtdBDCaractMedic(),
						new CaracteristicaMedicamento(nomeMedic, eficiencia));

		Episodio bdEpisodio = Episodio.inserirEpisodio(
				BancoDeDadosEpisodio.getQtdBDEpisodio(),
				new Episodio(usuario, dataInicioDia, dataInicioMes, dataInicioAno,
						dataInicioMesAno, horas, minutos, duracaoHoras, bdCaractDor,
						bdCaractMedic, observacoes));

		controleDados.setEpisodioDia(bdEpisodio);

		return bdCaractDor.toString() + "\n" + bdCaractMedic.toString() + "\n"
				+ bdEpisodio.toString();
	}

	// ===================================================================================
	/**
	 * Chama o metodo para editar uma instancia existente de episodio
	 * 
	 * @return String retorna uma string com valores editados
	 * 
	 * @param usuario           nome do usuario que teve o episodio de enxaqueca
	 * @param dataInicioDia     dia da data e hora da ocorrencia
	 * @param dataInicioMes     mes da data e hora da ocorrencia
	 * @param dataInicioAno     ano da data e hora da ocorrencia
	 * @param dataInicioMesAno  mes e ano da data e hora da ocorrencia usado em
	 *                          filtros e buscas
	 * @param horas             hora da data e hora da ocorrencia
	 * @param minutos           minutos da data e hora da ocorrencia
	 * @param duracaoHoras      duracao da dor de cabeca em horas
	 * @param indiceNomeTipoDor indice do tipo de dor
	 * @param indiceNomeGatilho indice do gatilho
	 * @param indiceNomeLocal   indice do local da dor
	 * @param sintoma           sintoma associado
	 * @param intensidade       intensidade da dor
	 * @param indiceNomeMedic   indice do nome do medicamento
	 * @param eficiencia        eficiencia do medicamento
	 * @param observacoes       notas adicionais que o usuario quiser registrar
	 * 
	 */
	public String editarEpisodioDia(String usuario, int dataInicioDia, int dataInicioMes,
			int dataInicioAno, String dataInicioMesAno, int horas, int minutos,
			int duracaoHoras, int indiceNomeTipoDor, int indiceNomeGatilho,
			int indiceNomeLocal, String sintoma, int intensidade, int indiceNomeMedic,
			String eficiencia, String observacoes) {
		// usado por TelaCadastroEdicaoEpisodio
		int indiceEpisodioEditado = controleDados.getIndiceEpisodioDia();

		NomeTipoDor tipoDor = BancoDeDadosEpisodio.getBdNomeTipoDor(indiceNomeTipoDor);
		NomeGatilho gatilho = BancoDeDadosEpisodio.getBdNomeGatilho(indiceNomeGatilho);
		NomeLocalizacao local = BancoDeDadosEpisodio.getBdNomeLocal(indiceNomeLocal);
		NomeMedicamento nomeMedic = BancoDeDadosEpisodio.getBdNomeMedic(indiceNomeMedic);

		CaracteristicaDor bdCaractDor = CaracteristicaDor.editarCaractDor(
				indiceEpisodioEditado, tipoDor, gatilho, local, sintoma, intensidade);

		CaracteristicaMedicamento bdCaractMedic = CaracteristicaMedicamento
				.editarCaractMedic(indiceEpisodioEditado, nomeMedic, eficiencia);

		Episodio bdEpisodio = Episodio.editarEpisodioDeUmIndiceEspecifico(
				indiceEpisodioEditado, usuario, dataInicioDia, dataInicioMes,
				dataInicioAno, dataInicioMesAno, horas, minutos, duracaoHoras,
				bdCaractDor, bdCaractMedic, observacoes);

		controleDados.setEpisodioDia(bdEpisodio);

		return bdCaractDor.toString() + "\n" + bdCaractMedic.toString() + "\n"
				+ bdEpisodio.toString();
	}

	// ===================================================================================
	/**
	 * Chama o metodo para verificar se a data digitada e valida
	 * 
	 * @return resultado retorna verdadeiro se a data e valida
	 * 
	 * @param valorDataInicioDia valor de entrada do dia
	 * @param valorDataInicioMes valor de entrada do mes
	 * @param valorDataInicioAno valor de entrada do ano
	 * 
	 */
	public static boolean testeDataValida(String valorDataInicioDia,
			String valorDataInicioMes, String valorDataInicioAno) {
		// usado por TelaCadastroEdicaoEpisodio
		int dd, mm, aaaa;
		boolean resultado = false;
		// System.out.println(valorDataInicioDia + valorDataInicioMes +
		// valorDataInicioAno);
		if (valorDataInicioDia.matches("[0-9]+") && valorDataInicioMes.matches("[0-9]+")
				&& valorDataInicioAno.matches("[0-9]+")) {
			dd = Integer.parseInt(valorDataInicioDia);
			mm = Integer.parseInt(valorDataInicioMes);
			aaaa = Integer.parseInt(valorDataInicioAno);
			// System.out.printf("%d %d %d", dd, mm, aaaa);
			resultado = ((dd >= 1 && dd <= 31
					&& (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10
							|| mm == 12))
					|| (dd >= 1 && dd <= 30
							&& (mm == 4 || mm == 6 || mm == 9 || mm == 11))
					|| (dd >= 1 && dd <= 28
							&& ((mm == 2 && aaaa % 4 == 0 && aaaa % 100 == 0)
									|| (mm == 2 && aaaa % 4 != 0)))
					|| (dd >= 1 && dd <= 29
							&& (mm == 2 && aaaa % 4 == 0 && aaaa % 100 != 0)));
		}
		// System.out.println(resultado);
		return resultado;
	}

	// ===================================================================================
	/**
	 * Chama o metodo para verificar se a hora digitada e valida
	 * 
	 * @return resultado retorna verdadeiro se a hora e valida
	 * 
	 * @param valorHoraInicioHora valor de entrada da hora
	 * @param valorHoraInicioMin  valor de entrada do minuto
	 * 
	 */
	public static boolean testeHoraValida(String valorHoraInicioHora,
			String valorHoraInicioMin) {
		// usado por TelaCadastroEdicaoEpisodio
		int hh, mm;
		boolean resultado = false;
		// System.out.println(valorDataInicioDia + valorDataInicioMes +
		// valorDataInicioAno);
		if (valorHoraInicioHora.matches("[0-9]+")
				&& valorHoraInicioMin.matches("[0-9]+")) {
			hh = Integer.parseInt(valorHoraInicioHora);
			mm = Integer.parseInt(valorHoraInicioMin);
			// System.out.printf("%d %d %d", dd, mm, aaaa);
			resultado = ((hh >= 0 && hh <= 23) && (mm >= 0 && mm <= 59));
		}
		// System.out.println(resultado);
		return resultado;
	}

	// ===================================================================================
	/**
	 * Chama o metodo para verificar se a duracao do episodio de dor digitada e
	 * valida (tem que ser um valor inteiro).
	 * 
	 * @return resultado retorna verdadeiro se a duracao e valida
	 * 
	 * @param valorDuracaoHoras valor de entrada da duracao do episodio
	 * 
	 */
	public static boolean testeDuracaoHorasValida(String valorDuracaoHoras) {
		// usado por TelaCadastroEdicaoEpisodio
		int duracaoInteiro;
		double duracaoDouble;
		boolean resultado = false;
		if (valorDuracaoHoras.matches("[0-9]+")) {
			duracaoInteiro = Integer.parseInt(valorDuracaoHoras);
			duracaoDouble = Double.parseDouble(valorDuracaoHoras);
			resultado = (duracaoDouble - duracaoInteiro == 0);
		}
		return resultado;
	}

	// ===================================================================================
	/**
	 * Chama o metodo para verificar se a intensidade da dor do episodio digitada e
	 * valida (tem que ser um valor inteiro).
	 * 
	 * @return resultado retorna verdadeiro se a intensidade e valida
	 * 
	 * @param valorIntensidade valor de entrada da intensidade do episodio
	 * 
	 */
	public static boolean testeIntensidadeValida(String valorIntensidade) {
		// usado por TelaCadastroEdicaoEpisodio
		int intensidadeInteiro;
		double intensidadeDouble;
		boolean resultado = false;
		if (valorIntensidade.matches("[0-9]+")) {
			intensidadeInteiro = Integer.parseInt(valorIntensidade);
			intensidadeDouble = Double.parseDouble(valorIntensidade);
			resultado = (intensidadeDouble - intensidadeInteiro == 0);
		}
		return resultado;
	}

}
