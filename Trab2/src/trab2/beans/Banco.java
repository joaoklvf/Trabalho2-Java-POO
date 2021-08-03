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
    public static List<Conta> Contas = new ArrayList<>();

    public List<Conta> getContas() {
        return Contas;
    }


    
    public String InserirConta(Conta conta){
        try{
            Contas.add(conta);
            return "Conta inserida com sucesso!";
        }catch(Exception e){
            return e.getLocalizedMessage();
        }
    }
}
