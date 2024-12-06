/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadobancario;

import java.util.ArrayList;

/**
 *
 * @author Elitonn
 */
public class Transacao {
    private Double saldo;
    private final ArrayList<String> historicoTransferencias;

    public Transacao() {
        this.saldo = 0.0;
        this.historicoTransferencias = new ArrayList<>();

    }

    public Double getSaldo() {
        return saldo;
    }
    
    public ArrayList<String> getHistoricoTransferencias() {
    return historicoTransferencias;
    
        }

   public void depositar(Double valor) {
        if (valor > 0) {
            saldo += valor;
            historicoTransferencias.add("Depósito: R$" + valor);
            System.out.println("Depósito realizado");
        } else {
            System.out.println("Valor inválido.");
        }
    }

     public void sacar(Double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            historicoTransferencias.add("Saque: R$" + valor);
            System.out.println("Saque realizado ");
        } else {
            System.out.println("Saldo insuficiente ");
        }
    }
    
    public void transferencia(Transacao contaParaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            this.saldo -= valor;
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;

            historicoTransferencias.add("Transferência realizada para conta: R$" + valor);
            contaParaDeposito.historicoTransferencias.add("Recebimento de transferência: R$" + valor);

            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a transferência");
        }
    }

    public void transferenciaParaInvestimento(Double valor, String tipoInvestimento) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            historicoTransferencias.add("Transferência para investimento (" + tipoInvestimento + "): R$" + valor);
            System.out.println("Transferência para investimento realizada!");
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public void sacarInvestimento(Double valor) {
        saldo += valor;
        historicoTransferencias.add("Saque de investimento: R$" + valor);
        System.out.println("Saque de investimento realizado!");
    }

}
