/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoalcides;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author augusto.coelho
 */
public class ThreadEnviar extends Thread {

    private String nome;
    private Socket s;

    public ThreadEnviar(String nome, Socket s) {
        this.nome = nome;
        this.s = s;

    }

    public void run() {
        try {
            Scanner meu = new Scanner(System.in);
            System.out.println("Digite o remetente da mensagem");
            String nomeRemetente = meu.nextLine();
            System.out.println("Digite sua mensagem");
            String mensagem = meu.nextLine();
            
            DataOutputStream saida= new DataOutputStream( s.getOutputStream());
            saida.writeChars(nomeRemetente);
            saida.writeChars(mensagem);
         
            
            
        } catch (IOException ex) {
            Logger.getLogger(ThreadEnviar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
