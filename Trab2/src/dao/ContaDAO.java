/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import trab2.beans.Banco;
import trab2.beans.Conta;

/**
 *
 * @author Joao
 */
public class ContaDAO {
    public static String InserirConta(Conta conta){
        try{
            Banco.getContas().add(conta);
            return "Conta inserida com sucesso!";
        }catch(Exception e){
            return e.getLocalizedMessage();
        }
    }
    public static void LerContaById(int id){
        List<Conta> contas = Banco.getContas();
        for (Conta c : contas){
            if(c.getId()==id){
                System.out.println("Código da conta: " + String.valueOf(c.getId()));
                System.out.println("Nome do cliente: " + ClienteDAO.getClienteById(c.getCliente()).getNome());
                System.out.println("CPF do cliente: " + ClienteDAO.getClienteById(c.getCliente()).getCpf());
                System.out.println("Saldo da conta: " + String.valueOf(c.getSaldo()));
                return;
            }
        }
        System.out.println("Conta não encontrada!\n");
    }
        public static void LerContas(){
        List<Conta> contas = Banco.getContas();
        for (Conta c : contas){
                System.out.println("Código da conta: " + String.valueOf(c.getId()));
                System.out.println("Nome do cliente: " + ClienteDAO.getClienteById(c.getCliente()).getNome());
                System.out.println("CPF do cliente: " + ClienteDAO.getClienteById(c.getCliente()).getCpf());
                System.out.println("Saldo da conta: R$" + String.valueOf(c.getSaldo()));
        }
        if(contas.isEmpty()) System.out.println("Nenhuma conta cadastrada!");
    }
}
