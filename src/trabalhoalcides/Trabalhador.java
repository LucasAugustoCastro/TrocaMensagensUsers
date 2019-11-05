/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoalcides;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class Trabalhador extends Thread {
	
	private Socket t;
	
	public Trabalhador( Socket t )
	{
		this.t = t;
	}
	
	public void run()
	{
		try
		{
                    System.out.println(Servidor.usuario);
			DataInputStream entrada = new DataInputStream( t.getInputStream());
			DataOutputStream saida = new DataOutputStream( t.getOutputStream());
			
			String nomerecebe = entrada.readUTF();
                        String mensagem = entrada.readUTF();
                        String nome = entrada.readUTF();
			System.out.println( "Recebidos: " + nomerecebe + "Mensagens:"+ mensagem);
                        
			
			Thread.sleep( 5000 ); // dorme 5 segundos
                        
			if (Servidor.usuario.containsKey(nomerecebe)) {
                            
                            String[] envioMen = new String[2];
                            envioMen[0] = nome;
                            envioMen[1] = mensagem;
                            Servidor.usuario.get(nomerecebe).add(envioMen);
                            
                        } else {
                            System.err.println("Chave não existe");
                        }
			
			
			t.close();
			System.out.println( "Servidor: conexao encerrada");
		}
		catch( Exception e )
		{
			System.out.println( e );
		}
		
	}

}