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
public class TransferenciaDAO {
    public String PIX(int cRemetente, int cDestinatario, int valor){
        try {
                    List<Conta> contas = Banco.getContas();
        Conta cc1 = null, cc2 = null;
        for (Conta c : contas){
            if(c.getId() == cRemetente) cc1 = c;
            else if(c.getId()==cDestinatario) cc2 = c;
        }
        if(cc1 == null || cc2==null){
            return ("Alguma das contas não foram encontradas");            
        }
        else if(valor > cc1.getSaldo()){
            return ("Saldo insuficiente");
        }
        else{
            cc1.setSaldo(cc1.getSaldo() - valor);
            cc2.setSaldo(cc2.getSaldo() + valor);
            return "Pix realizado com sucesso!";        
        }      
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }

    }
}
