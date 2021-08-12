/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import trab2.beans.Banco;
import trab2.beans.Conta;
import trab2.beans.Transferencia;

/**
 *
 * @author Joao
 */
public class TransferenciaDAO {
    public String PIX(Transferencia t){
        try {
                    List<Conta> contas = Banco.getContas();
        Conta cc1 = null, cc2 = null;
        for (Conta c : contas){
            if(c.getId() == t.getConta1()) cc1 = c;
            else if(c.getId()==t.getConta2()) cc2 = c;
        }
        if(cc1 == null || cc2==null){
            return ("Alguma das contas não foram encontradas");            
        }
        else if(t.getValor() > cc1.getSaldo()){
            return ("Saldo insuficiente");
        }
        else{
            cc1.setSaldo(cc1.getSaldo() - t.getValor());
            cc2.setSaldo(cc2.getSaldo() + t.getValor());
            List<Transferencia> teds = Banco.getTransferencias();
            teds.add(t);
            Banco.setTransferencias(teds);
            return "Pix realizado com sucesso!";        
        }      
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }
    
    public static String GetExtrato(int codCc){
        Conta cc = null;
        List<Conta> lista = Banco.getContas(); 
        for (Conta c : lista){
            if(c.getId() == codCc) cc = c;          
        }
        if(cc == null){
            return ("Conta não encontrada");            
        }
        System.out.println("Transfêrencias realizadas:");
        System.out.println("Conta destino | valor");
        for (Transferencia t : Banco.getTransferencias()){
            if(t.getConta1() == cc.getId()){
                System.out.println(t.getConta2() + " | R$" + t.getValor());
            }
        }
        System.out.println("Transfêrencias recebidas:");
        System.out.println("Conta origem | valor");
        for (Transferencia t : Banco.getTransferencias()){
            if(t.getConta2()== cc.getId()){
                System.out.println(t.getConta1()+ " | R$" + t.getValor());
            }
        }
        return "Saldo atual: R$" + String.valueOf(cc.getSaldo());
    }
}
