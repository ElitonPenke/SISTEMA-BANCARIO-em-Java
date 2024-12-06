/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadobancario;

/**
 *
 * @author Elitonn
 */
public class ContaCorrente {
private static int contadorDeContas = 1;
private final int numeroConta;
private final Usuario usuario;
private final Transacao transacao;

public ContaCorrente(Usuario usuario) {
    this.numeroConta = contadorDeContas++;
    this.usuario = usuario;
    this.transacao = new Transacao();
}

public int getNumeroConta() {
    return numeroConta;
}

public Usuario getUsuario() {
    return usuario;
}

public Transacao getTransacao() {
    return transacao;
}


@Override
public String toString() {
    return "Conta Nº: " + numeroConta +
           "\nCliente: " + usuario.getName() +
           "\nCPF: " + usuario.getCpf() +
           "\nSaldo: R$" + transacao.getSaldo() + "\n";
}
}
