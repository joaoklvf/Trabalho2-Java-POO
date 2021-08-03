/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab2;

import dao.ClienteDAO;
import dao.ContaDAO;
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
   
            switch (op) {
                case 1:
                    cadCliente();
                    break;
                case 2:
                    ClienteDAO.LerClientes();
                    break;
                case 3:
                    lerCliente();
                    break;
                case 4:
                    cadConta();
                    break;
                case 5:
                    ContaDAO.LerContas();
                    break;    
                default:
                    System.out.println("Foi uma honra ter você consco, até a próxima!");
                    quitar = true;
                    break;
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
    private static void cadConta()
    {
        
        Scanner scan = new Scanner(System.in); 
        System.out.println("Insira o código do cliente:");
        int cod = scan.nextInt();
        System.out.println("Insira o saldo inicial da conta:");
        int saldo = scan.nextInt();
        Conta c = new Conta(saldo, cod);
        if(c.getSaldo() == 0){
            System.out.println("Cliente não encontrado!");
            return;
        }
        System.out.println(ContaDAO.InserirConta(c));
    }
    private static void lerCliente(){
        Scanner scan = new Scanner(System.in); 
        System.out.println("Insira o nome do cliente:");
        int a = scan.nextInt();
        ClienteDAO.getClienteById(a);
    }
    
}
