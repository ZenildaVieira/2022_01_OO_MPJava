// =======================================================================================
package testeJUnit5;

// =======================================================================================
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import controle.ControleCadastroEpisodio;

//========================================================================================
class TesteEntradasValidas {

	// ===================================================================================
	/**
	 * Metodo de teste unitario para verificar se a data digitada e valida
	 * 
	 */
	@Test
	void testeDataValida() {
		// Mes fevereiro de 29 dias em ano bissexto
		String mes = "02";
		String anoCerto = "2020";
		String anoErradoImpar = "2021";
		String anoErradoPar = "2022";
		String diaCerto = "29";
		String diaErrado = "30";
		// teste ano certo e dia errado
		assertTrue(ControleCadastroEpisodio.testeDataValida(diaCerto, mes, anoCerto));
		assertFalse(ControleCadastroEpisodio.testeDataValida(diaErrado, mes, anoCerto));
		// teste ano errado e dia certo
		assertFalse(
				ControleCadastroEpisodio.testeDataValida(diaCerto, mes, anoErradoImpar));
		assertFalse(
				ControleCadastroEpisodio.testeDataValida(diaCerto, mes, anoErradoPar));
		// Mes fevereiro de 28 dias
		mes = "02";
		anoCerto = "2022";
		diaCerto = "28";
		diaErrado = "29";
		// teste dia
		assertTrue(ControleCadastroEpisodio.testeDataValida(diaCerto, mes, anoCerto));
		assertFalse(ControleCadastroEpisodio.testeDataValida(diaErrado, mes, anoCerto));
		// Mes de 30 dias
		mes = "04";
		diaCerto = "30";
		diaErrado = "31";
		// teste dia
		assertTrue(ControleCadastroEpisodio.testeDataValida(diaCerto, mes, anoCerto));
		assertFalse(ControleCadastroEpisodio.testeDataValida(diaErrado, mes, anoCerto));
		// Mes de 31 dias
		mes = "08";
		diaCerto = "31";
		diaErrado = "32";
		// teste dia
		assertTrue(ControleCadastroEpisodio.testeDataValida(diaCerto, mes, anoCerto));
		assertFalse(ControleCadastroEpisodio.testeDataValida(diaErrado, mes, anoCerto));
		// Data qualquer
		mes = "01";
		diaCerto = "01";
		anoCerto = "2022";
		// teste dia
		assertTrue(ControleCadastroEpisodio.testeDataValida(diaCerto, mes, anoCerto));
	}

	// ===================================================================================
	/**
	 * Metodo de teste unitario para verificar se a hora digitada e valida
	 * 
	 */
	@Test
	void testeHoraValida() {
		String horaCerta = "14";
		String horaErrada = "26";
		String minCerto = "29";
		String minErrado = "65";
		// teste hora e minutos
		assertTrue(ControleCadastroEpisodio.testeHoraValida(horaCerta, minCerto));
		assertFalse(ControleCadastroEpisodio.testeHoraValida(horaCerta, minErrado));
		assertFalse(ControleCadastroEpisodio.testeHoraValida(horaErrada, minCerto));
		assertFalse(ControleCadastroEpisodio.testeHoraValida(horaErrada, minErrado));
	}

	// ===================================================================================
	/**
	 * Metodo de teste unitario para verificar se a duracao digitada e valida
	 * 
	 */
	@Test
	void testDuracaoHorasValida() {
		String duracaoCerta = "5";
		String duracaoErrada = "5.5";
		// teste hora e minutos
		assertTrue(ControleCadastroEpisodio.testeDuracaoHorasValida(duracaoCerta));
		assertFalse(ControleCadastroEpisodio.testeDuracaoHorasValida(duracaoErrada));
	}

	// ===================================================================================
	/**
	 * Metodo de teste unitario para verificar se a intensidade digitada e valida
	 * 
	 */
	@Test
	void testIntensidadeValida() {
		String duracaoCerta = "3";
		String duracaoErrada = "3.5";
		// teste hora e minutos
		assertTrue(ControleCadastroEpisodio.testeIntensidadeValida(duracaoCerta));
		assertFalse(ControleCadastroEpisodio.testeIntensidadeValida(duracaoErrada));
	}
	// ===================================================================================

}
//========================================================================================