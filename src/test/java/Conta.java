
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {

	public boolean clienteEspecial = false;
	public int conta;
	public int saque;
	public int saldo;

	/**
	 * 
	 * @param conta é o valor do saldo da conta do cliente especial (-200)
	 */
	@Given("Um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer conta) {
		// Write code here that turns the phrase above into concrete actions
		this.conta = conta;

		if (conta instanceof Integer && this.clienteEspecial == true) {
		} else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * 
	 * @param saque será o valor de 100 reais do saque que o cliente especial deseja
	 *              sacar de sua conta.
	 */
	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer saque) {
		// Write code here that turns the phrase above into concrete actions
		this.saque = saque;

		if (saque instanceof Integer && this.clienteEspecial) {
		} else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * 
	 * @param saldo irá definir o saldo da conta do cliente especial para -300
	 */
	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_sque_e_atualizar_o_saldo_da_conta_para_reais(Integer saldo) {
		/*
		 * teste para ver ser saldo especial for diferente da abatimento do sado da
		 * conta devedora restante, irá dar erro
		 */

		if (saldo instanceof Integer && this.clienteEspecial == true) {
			saldo = this.conta - (this.saque);
		} else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 *
	 * @param conta saldo atual do cliente normal -300 (negativo)
	 */
	@Given("Um cliente comum com saldo atual de {int} reais")
	public void um_cliente_commum_com_saldo_atual_de_reais(Integer conta) {
		// Write code here that turns the phrase above into concrete actions
		this.conta = conta;

		if (conta instanceof Integer && this.clienteEspecial == false) {
		} else
			throw new io.cucumber.java.PendingException();

	}

	/**
	 *
	 * @param saque valor do saque que o cliente normal estará solicitado
	 */
	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer saque) {
		// Write code here that turns the phrase above into concrete actions
		this.saque = saque;

		if (saque instanceof Integer) {
		} else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * 
	 * @implNote metodo está verificando se o cliente for normal, não permitirá que
	 *           saque e apareça a mensagem de saldo insuficiente.
	 */
	@Then("nao deve efetuar o saque e deve retornar a mensagem saldo insuficiente")
	public void nao_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		// Write code here that turns the phrase above into concrete actions
		
		if (this.conta > 0 && this.saque < this.conta && this.clienteEspecial == false) {

		} else if (this.saque > this.conta) {
			System.out.print("Saldo insuficiente");
		} else {
			throw new io.cucumber.java.PendingException();
		}
	}
}
