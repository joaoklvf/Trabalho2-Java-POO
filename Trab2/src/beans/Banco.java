/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab2.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joao
 */
public class Banco {

    public static List<Conta> getContas() {
        return Contas;
    }

    public static void setContas(List<Conta> Contas) {
        Banco.Contas = Contas;
    }

    public static List<Cliente> getClientes() {
        return Clientes;
    }

    public static void setClientes(List<Cliente> Clientes) {
        Banco.Clientes = Clientes;
    }
    private static List<Conta> Contas = new ArrayList<>();
    private static List<Cliente> Clientes = new ArrayList<>();

    public static List<Transferencia> getTransferencias() {
        return Transferencias;
    }

    public static void setTransferencias(List<Transferencia> Transferencias) {
        Banco.Transferencias = Transferencias;
    }
    private static List<Transferencia> Transferencias = new ArrayList<>();

}
