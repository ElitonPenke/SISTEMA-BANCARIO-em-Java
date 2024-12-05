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
    static ArrayList<ContaMae> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("\nSelecione uma opção:");
        System.out.println("| 1 - Criar conta       |");
        System.out.println("| 2 - Consultar saldo   |");
        System.out.println("| 3 - Listar contas     |");
        System.out.println("| 4 - Sair              |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1 ->
                criarConta();
            case 2 ->
                consultarSaldo();
            case 3 ->
                listarContas();
            case 4 -> {
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
        ContaMae novaConta = new ContaMae(usuario);

        contasBancarias.add(novaConta);
        System.out.println("Conta criada com sucesso!");
        
        operacoes();

    }

    public static void consultarSaldo() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = input.nextInt();

        ContaMae conta = encontrarConta(numeroConta);

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
            for (ContaMae conta : contasBancarias) {
                System.out.println(conta);
            }
        }
                operacoes();

    }

    private static ContaMae encontrarConta(int numeroConta) {
        for (ContaMae conta : contasBancarias) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

}
