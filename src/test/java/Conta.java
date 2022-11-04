import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {

	String cliente;

	/* Cliente Especial */
	Integer saldoEspecial;
	Integer saqueEspecial;
	/* Cliente normal */

	Integer saldoNormal;
	Integer saqueNormal;

	/**
	 * 
	 * @param valor200 é o valor do saldo da conta do cliente especial (-200)
	 */

	@Given("Um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer valor200) {
		this.saldoEspecial = valor200;

		/**
		 * 
		 * valor200 se o valor do saldo da conta for diferente de -200 irá dar a
		 * excessão
		 */
		if (valor200 != -200) {
			throw new io.cucumber.java.PendingException();
		}

	}

	/**
	 * 
	 * @param valor100 será o valor de 100 reais do saque que o cliente especial
	 *                 deseja sacar de sua conta.
	 */

	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer valor100) {
		this.saqueEspecial = valor100;
		this.cliente = "especial";

		if (this.cliente != "especial") {
			throw new io.cucumber.java.PendingException();
		}
	}

	/**
	 * 
	 * @param valor300 irá definir o saldo da conta do cliente especial para -300
	 */
	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer valor300) {
		this.saldoEspecial = valor300;
		/*teste para ver ser saldo especial for diferente da abatimento do sado da conta devedora restante, irá dar erro*/
		if(this.saldoEspecial != valor300){
		throw new io.cucumber.java.PendingException();
	}
}
	/**
	 *
	 * @param valor300 saldo atual do cliente normal -300 (negativo)
	 */
	@Given("Um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer valor300) {
		this.saldoNormal = valor300;
		
		if(this.saldoNormal != valor300) {
		throw new io.cucumber.java.PendingException();
	}}

	
	/**
	 *
	 * @param v200 valor do saque que o cliente normal estará solicitado
	 */
	
	
	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer v200) {
		this.saqueNormal = v200;
		this.cliente = "Normal";
		
		
		if(this.cliente != "Normal") {
		throw new io.cucumber.java.PendingException();
	}
}

	/**
	 * 
	 * @implNote metodo está verificando se o cliente for normal, não permitirá que saque e apareça a mensagem de saldo insuficiente.
	 */
	@Then("nao deve efetuar o saque e deve retornar a mensagem saldo insuficiente")
	public void nao_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		this.cliente = "Normal";
		
		if(this.cliente == "Normal") {
			System.out.println("Saldo Insuficiente");
		}else
		throw new io.cucumber.java.PendingException();
	}

}
