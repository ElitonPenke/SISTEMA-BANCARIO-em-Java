/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemadobancario;


import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Elitonn
 */
public class Sistemadobancario {

    static Scanner input = new Scanner(System.in);
    static ArrayList<ContaCorrente> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("\nSelecione uma opção:");
        System.out.println("| 1 - Criar conta       |");
        System.out.println("| 2 - Depositar         |");
        System.out.println("| 3 - Sacar             |");
        System.out.println("| 4 - Transferir        |");
        System.out.println("| 5 - Consultar saldo   |");
        System.out.println("| 6 - Listar contas     |");
        System.out.println("| 7 - Investimentos     |");
        System.out.println("| 8 - Historico         |");
        System.out.println("| 9 - Sair              |");
        System.out.print("Digite sua escolha: ");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1 -> criarConta();
                
            case 2 -> depositar();

            case 3 -> sacar();

            case 4 -> transferir();

            case 5 -> consultarSaldo();
                
            case 6 -> listarContas();
            
            case 7 -> gerenciarInvestimentos();
            
            case 8 -> visualizarHistoricoTransferencias();
                
            case 9 -> {
                System.out.println("Encerrando o sistema...");
                System.exit(0);
            }
            default ->
                System.out.println("Opção inválida!");
        }
    }

    

    public static void criarConta() {
        System.out.println("Criando nova conta\n");
        

        System.out.print("Nome: ");
        String nome = input.next();

        System.out.print("CPF: ");
        String cpf = input.next();

        System.out.print("Email: ");
        String email = input.next();

        System.out.print("Endereço: ");
        String endereco = input.next();

        System.out.print("Senha: ");
        String senha = input.next();

        Usuario usuario = new Usuario(nome, cpf, email, endereco, senha);
        ContaCorrente novaConta = new ContaCorrente(usuario);

        contasBancarias.add(novaConta);
        System.out.println("Conta criada com sucesso!");
        System.out.println("Número da sua conta é: " + novaConta.getNumeroConta());
        
        
        operacoes();

    }

    public static void consultarSaldo() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = input.nextInt();

        ContaCorrente conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Saldo atual: R$" + conta.getTransacao().getSaldo());
        } else {
            System.out.println("Conta não encontrada!");
        }
                operacoes();

    }

    public static void listarContas() {
        if (contasBancarias.isEmpty()) { // se esta vazio a lista
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            System.out.println("Lista de contas bancárias:");
            for (ContaCorrente conta : contasBancarias) {
                System.out.println(conta);
            }
        }
                operacoes();

    }

    private static ContaCorrente encontrarConta(int numeroConta) {
        for (ContaCorrente conta : contasBancarias) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
    
    
    
    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();
        ContaCorrente conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();

           conta.getTransacao().depositar(valorDeposito);
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();

    }

    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        ContaCorrente conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();

        conta.getTransacao().sacar(valorSaque);
            System.out.println("--- Saque realizado com sucesso! ---");
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();

    }

    public static void transferir() {
        System.out.println("Qual numero da conta que ira realizar a transferência: ");
        int numeroContaRemetente = input.nextInt();

        ContaCorrente contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = input.nextInt();

            ContaCorrente contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();

    contaRemetente.getTransacao().transferencia(contaDestinatario.getTransacao(), valor);

            }else {
                System.out.println("--- A conta para depósito não foi encontrada ---");
            }

        }else {
            System.out.println("--- Conta para transferência não encontrada ---");
        }
        operacoes();
    }

    




public static void gerenciarInvestimentos() {
    System.out.println("Número da conta: ");
    int numeroConta = input.nextInt();

    ContaCorrente conta = encontrarConta(numeroConta);

    if (conta != null) {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Investir");
        System.out.println("2 - Sacar Investimento");
        System.out.print("Opção: ");

        int opcao = input.nextInt();

        switch (opcao) {
            case 1 -> investir(conta);
            case 2 -> sacarInvestimento(conta);
            default -> System.out.println("Opção inválida.");
        }
    } else {
        System.out.println("Conta não encontrada.");
    }

    operacoes();
}

private static void investir(ContaCorrente conta) {
    System.out.println("\nEscolha o tipo de investimento:");
    System.out.println("1 - LCI");
    System.out.println("2 - LCA");
    System.out.println("3 - CRI");
    System.out.print("Opção: ");

    int escolha = input.nextInt();
    System.out.println("Informe o valor a investir: ");
    double valor = input.nextDouble();

    String tipoInvestimento = "";
    double retorno = 0;

    switch (escolha) {
        case 1 -> {
            tipoInvestimento = "LCI";
            retorno = ContaInvestimento.LCI.calcularRetorno(valor, 1); // 1 ano
        }
        case 2 -> {
            tipoInvestimento = "LCA";
            retorno = ContaInvestimento.LCA.calcularRetorno(valor, 1); // 1 ano
        }
        case 3 -> {
            tipoInvestimento = "CRI";
            retorno = ContaInvestimento.CRI.calcularRetorno(valor, 1); // 1 ano
        }
        default -> {
            System.out.println("Opção inválida.");
            return;
        }
    }

    conta.getTransacao().transferenciaParaInvestimento(valor, tipoInvestimento);
    System.out.println("Investimento realizado! Retorno estimado após 1 ano: R$" + retorno);
    
            operacoes();

}

private static void sacarInvestimento(ContaCorrente conta) {
    System.out.println("Informe o valor a sacar do investimento: ");
    double valor = input.nextDouble();

    conta.getTransacao().sacarInvestimento(valor);

            operacoes();

}


public static void visualizarHistoricoTransferencias() {
    System.out.println("Número da conta: ");
    int numeroConta = input.nextInt();

    ContaCorrente conta = encontrarConta(numeroConta);

    if (conta != null) {
        System.out.println("\nHistórico de transferências:");
        for (String registro : conta.getTransacao().getHistoricoTransferencias()) {
            System.out.println(registro);
        }
    } else {
        System.out.println("Conta não encontrada.");
    }
            operacoes();

}



}