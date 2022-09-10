// =======================================================================================
package modelo;

//=======================================================================================
/**
 * Essa interface contem metodos comuns entre as classes NomeLocalizacao,
 * NomeTipoDor, NomeLocalizacao e NomeMedicamento.
 * 
 * @author Zenilda Pedrosa Vieira
 * @since Set 2022
 * @version 1.1
 * 
 */
public interface NomeCaracteristica {

	// ===================================================================================
	/**
	 * Insere nova instancia de nome de caracteristica no banco de dados
	 * 
	 * @return indNomeCaracteristica indice do novo nome de caracteristica inserido
	 * 
	 * @param nomeCaracteristica nome do caracteristica que sera inserido
	 * 
	 */
	public int inserirNomeCaracteristica(String nomeCaracteristica);

	// ===================================================================================
	// ===================================================================================
	/**
	 * Exclui instancia existente de nome de caracteristica no banco de dados
	 * 
	 * @return boolean retorna verdadeiro se a instancia que foi excluida era a
	 *         ultima
	 * 
	 * @param indiceNomeCaracteristica indice do nome da caracteristica que sera
	 *                                 excluida
	 * 
	 */
	public boolean excluirNomeCaracteristica(int indiceNomeCaracteristica);

	// ===================================================================================
	// ===================================================================================
	/**
	 * Metodo para obter um array, com todos os nomes de caracteristicas
	 * instanciados do banco de dados.
	 * 
	 * @return strNomeNomeCaracteristica retorna um array com caracteristicas
	 */
	public String[] gerarArrayNomeCaracteristica();

}
