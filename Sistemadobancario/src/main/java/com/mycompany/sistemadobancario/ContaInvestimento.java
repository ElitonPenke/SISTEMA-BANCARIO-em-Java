/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadobancario;

/**
 *
 * @author Elitonn
 */
//(Letra de Crédito Imobiliário)

public class ContaInvestimento {
    public class LCI {
    private static final double TAXA = 8.0; // Taxa pré-definida para LCI (8% ao ano)
    
    public static double calcularRetorno(double valor, int tempo) {
        return valor * Math.pow((1 + TAXA / 100), tempo);
    }
}

// (Letra de Crédito do Agronegócio)
public class LCA {
    private static final double TAXA = 7.5; // Taxa pré-definida para LCA (7,5% ao ano)
    
    public static double calcularRetorno(double valor, int tempo) {
        return valor * Math.pow((1 + TAXA / 100), tempo);
    }
}

// (Certificado de Recebíveis Imobiliários)
public class CRI {
    private static final double TAXA = 9.0; // Taxa pré-definida para CRI (9% ao ano)
    
    public static double calcularRetorno(double valor, int tempo) {
        return valor * Math.pow((1 + TAXA / 100), tempo);
    }
}

}
