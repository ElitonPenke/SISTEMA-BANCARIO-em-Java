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
        System.out.println("| 7 - Sair              |");
        System.out.print("Digite sua escolha: ");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1 ->
                criarConta();
                
            case 2 -> depositar();

            case 3 -> sacar();

            case 4 -> transferir();

            case 5 ->
                consultarSaldo();
                
            case 6 ->
                listarContas();
                
            case 7 -> {
                System.out.println("Encerrando o sistema...");
                System.exit(0);
            }
            default ->
                System.out.println("Opção inválida!");
        }

    }

    public static void criarConta() {
        System.out.println("Criando uma nova conta\n");

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

    

}
