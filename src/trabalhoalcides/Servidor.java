/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoalcides;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Servidor {

    /**
     * @param args
     */
    public static Map<String, ArrayList<String[]>> usuario = new HashMap<String, ArrayList<String[]>>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        FileReader arq = new FileReader("D:\\Java Poo\\TrabalhoAlcides\\src\\trabalhoalcides\\Usuarios.txt");
        BufferedReader lerArq = new BufferedReader(arq);

        String linha = lerArq.readLine();
        
        while (linha != null) {
            
            Servidor.usuario.put(linha, new ArrayList<String[]>());
            linha = lerArq.readLine();
            
            
            
        }
        
        lerArq.close();
        arq.close();
        for (String variableName : Servidor.usuario.keySet())
                System.out.println(variableName);
        try {
            ServerSocket ss = new ServerSocket(5000);

            while (true) {
                System.out.println("Servidor aguardando um cliente ...");
                Socket t = ss.accept(); // bloqueia até receber pedido de conexão do cliente
                System.out.println("Servidor: conexao feita");
                System.out.println(Servidor.usuario);
                Trabalhador trab = new Trabalhador(t);
                trab.start();

            }

            //ss.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
