/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab2.beans;

import dao.ClienteDAO;

/**
 *
 * @author Joao
 */
public class Conta {

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public int getCliente() {
        return Cliente;
    }

    public void setCliente(int Cliente) {
        this.Cliente = Cliente;
    }
    private int Id, Saldo, Cliente;
    
    public Conta(int saldo, int cliente){
        if(ClienteDAO.getClienteById(cliente) == null) return;
        Id = Banco.getContas().size();
        Saldo = saldo;
        Cliente = cliente;
    }
}
