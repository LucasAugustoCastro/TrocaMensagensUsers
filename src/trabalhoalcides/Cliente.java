/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoalcides;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // abre conexão com o servido
        
        try {
           
            Scanner meu = new Scanner(System.in);
            Socket s = new Socket("127.0.0.1", 5000);
            
            System.out.println(Servidor.usuario.);


          
            DataInputStream entrada = new DataInputStream(s.getInputStream());

            double resultado = entrada.readDouble();
            //float resultado = entrada.readFloat(); // pode?
            System.out.println("resultado = " + resultado);

            //float resto = entrada.readFloat();
            //System.out.println( "resto = " + resto );
            s.close(); // encerra a conexao com o servidor
            System.out.println("Cliente: conexao encerrada");
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
