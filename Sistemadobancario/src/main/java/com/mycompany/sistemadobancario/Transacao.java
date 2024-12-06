/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadobancario;

/**
 *
 * @author Elitonn
 */
public class Transacao {
    private Double saldo;

    public Transacao() {
        this.saldo = 0.0;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado");
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public void sacar(Double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado ");
        } else {
            System.out.println("Saldo insuficiente ");
        }
    }
    
    public void transferencia(Transacao contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            this.saldo -= valor;

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        }else {
            System.out.println("Não foi possível realizar a tranferência");
        }
    }
}
