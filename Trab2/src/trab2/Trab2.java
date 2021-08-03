/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab2;

import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import trab2.beans.Banco;
import trab2.beans.Conta;

/**
 *
 * @author Joao
 */
public class Trab2 {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Bem vindo ao Nubresco, o maior banco digital deste computador!");
        boolean quitar =false;

        while (!quitar){
           System.out.println("\n");
           System.out.println("Escolha uma opção:");
           System.out.println("1) Cadastrar cliente");
           System.out.println("2) Listar clientes");
           System.out.println("3) Listar cliente pelo código");
           System.out.println("4) Inserir conta bancária");
           System.out.println("5) Listar contas");
           System.out.println("6) Listar conta pelo código\n");
           Scanner scan = new Scanner(System.in); 
           int op = scan.nextInt();
   
           if(op==1){
                cadCliente();
           }
           else if(op==2){
               ClienteDAO.LerClientes();
           }
        }

    }
    
    private static void cadCliente()
    {
        Scanner scan = new Scanner(System.in); 
        System.out.println("Insira o nome do cliente:");
        String nome = scan.nextLine();
        System.out.println("Insira o cpf do cliente:");
        String cpf = scan.nextLine();
        System.out.println(ClienteDAO.InserirCliente(cpf, nome));
    }
    
}
