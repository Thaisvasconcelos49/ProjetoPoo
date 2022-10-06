package Bancario;
import java.util.Scanner;

import Persistencia.PersistenciaArquivo;

public class Programa{
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub

		PersistenciaArquivo pa = new PersistenciaArquivo();
		Scanner sc = new Scanner(System.in);

		boolean sair = true;
		int opcao = 0;

		while (sair) {
		System.out.println("Escolha uma opção:\n1) Cadastrar um cliente;\n2) Listar Clientes;\n3) Remover cliente ;\n4) Conta Opções;\n5)Sair");
		opcao = sc.nextInt();
		switch (opcao) {
		case 1:
		System.out.println("Insira o nome do cliente");
		String nome = sc.next();
		System.out.println("Insira o CPF do cliente");
		String cpf = sc.next();
		Cliente cliente = new Cliente(cpf, nome);
		pa.cadastrarCliente(cliente);
		cliente = null;
		break;
		case 2:
		pa.listarCliente();
		break;
		case 3:
		System.out.println("Digite o cpf do cliente");
		String removerCpf = sc.next();
		Cliente removerCliente = new Cliente(removerCpf);
		pa.removerCliente(removerCliente);
		removerCliente = null;
		break;
		case 4:
		System.out.println("Insira o CPF do cliente: ");
		String cpfConsulta = "";
		int segundaOpcao = 0;
		boolean segundoSair = true;
		cpfConsulta = sc.next();
		Cliente cliConsulta = pa.listarCliente(cpfConsulta);
		if (cliConsulta != null) {
		while (segundoSair) {
		System.out.println(
		"\n\n\n\nEscolha as opções para CONTA: \n1) Cadastrar uma conta;\n2) Remover uma conta;\n3) Listar contas;\n4) Entrar conta;\n5) Voltar");
		segundaOpcao = sc.nextInt();
		String ContaRemover;
		switch (segundaOpcao) {
		case 1:
		String numeroConta = "";
		System.out.println("Insira o número da conta");
		numeroConta = sc.next();
		Conta c1 = new Conta(numeroConta);
		cliConsulta.adicionarConta(c1);
		pa.atualizarCliente(cliConsulta);
		break;
		
		case 2:
		System.out.println("Insira o número da conta que sera removida");
		ContaRemover = sc.next();
		Conta c2= new Conta(ContaRemover);
		cliConsulta.removerConta(c2);
		pa.atualizarCliente(cliConsulta);
		break;
		case 3:
		System.out.println(cliConsulta.getContas());
		break;
		case 4:
		System.out.println("Insira o CPF do cliente: ");
		boolean voltarMenuCliente = false;
		cpfConsulta = sc.next();
		Cliente CliConsulta = pa.listarCliente(cpfConsulta);
		if (cliConsulta != null) {
		while (voltarMenuCliente == false) {
		}
		System.out.println("Conta não existente");
		break;
		}
		boolean sairMenuConta = false;
		int opcaoMenuConta = 0;
		while (sairMenuConta == false) {
		System.out.println("\n\n\n\nEscolha qual operação deseja realizar: \n1) Depositar;\n2) Sacar;\n3) Ver Saldo;\n4) Voltar");
		opcaoMenuConta = sc.nextInt();
		switch(opcaoMenuConta) {
		
		case 1:
		System.out.println("Insira  o valor para  deposito");
		
		float quantiaDeposito = sc.nextFloat();
		Consulta.realizarDeposito(quantiaDeposito);
		pa.atualizarCliente(cliConsulta);
		break;
		case 2:
		System.out.println("Insira o valor do saque");
		float quantiaSaque = sc.nextFloat();
		Consulta.realizarSaque(quantiaSaque);
		pa.atualizarCliente(cliConsulta);
		break;
		case 3:
		System.out.println(Consulta.getSaldo());
		break;
		case 4:
		sairMenuConta = true;
		break;
		}
		}
		case 5:
			voltarMenuCliente = true;
			break;
		}
		}
		} else
			System.err.println("Cliente não encontrado!");
		case 6:
		sair = false;
		break;
		}
		}
	}
}