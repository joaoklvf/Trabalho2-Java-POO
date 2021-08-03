/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import trab2.beans.Banco;
import trab2.beans.Cliente;

/**
 *
 * @author Joao
 */
public class ClienteDAO {
    public static Cliente getClienteById(int id){
        Cliente cli = new Cliente();
        for (Cliente c : Banco.getClientes()){
            if(c.getId()==id){
                cli = c;
            } 
        }
        return cli;
    }
    public String InserirCliente(String cpf, String nome){
        try{
            Cliente c = new Cliente();
            c.setNome(nome);
            c.setCpf(cpf);
            c.setId(Banco.getClientes().size());
            Banco.getClientes().add(c);
            return "Cliente inserido com sucesso!";
        }catch(Exception e){
            return e.getLocalizedMessage();
        }        
    }
}
