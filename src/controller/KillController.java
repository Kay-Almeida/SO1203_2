package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class KillController {
	public KillController () {
		super(); 
	}
	
	private String os() {
		String os = System.getProperty("os.name");
	//	System.out.println(os);
		return os; 
	}
	
	public void listaProcessos() {
		if(os().contains("Windows")) {
			String process = "TASKLIST /FO TABLE"; 
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream(); 
				InputStreamReader leitor = new InputStreamReader(fluxo); 
				BufferedReader buffer = new BufferedReader(leitor);  
				String linha = buffer.readLine();
				while(linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();	
				}
				buffer.close();
				leitor.close();
				fluxo.close();	
			} catch (IOException e) {
				e.printStackTrace();
			}  	   
		}else if(os().contains("Linux")) {
			String process = "ps -ef"; 
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream(); 
				InputStreamReader leitor = new InputStreamReader(fluxo); 
				BufferedReader buffer = new BufferedReader(leitor);  
				String linha = buffer.readLine();
				while(linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();	
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}  	   
		}else{
			JOptionPane.showMessageDialog(null, "Identificação de Sistema Operacional não pode identificar o sistema atual");
		}
		}
	
	public void matarPID(int PID) {
		if(os().contains("Windows")) {
			String process = "TASKKILL /PID "; 
			StringBuffer buffer = new StringBuffer(); 
			buffer.append(process);
			buffer.append(PID);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}else if(os().contains("Linux")) {
			String process = "kill -9 "; 
			StringBuffer buffer = new StringBuffer(); 
			buffer.append(process);
			buffer.append(PID);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}else{
			JOptionPane.showMessageDialog(null, "Identificação de Sistema Operacional não pode identificar o sistema atual");
		}
		}
	
	public void matarNome(String Nome) {
		if(os().contains("Windows")) {
			String process = "TASKKILL /IM "; 
			StringBuffer buffer = new StringBuffer(); 
			buffer.append(process);
			buffer.append(Nome);
			try {
				Runtime.getRuntime().exec(buffer.toString());
				JOptionPane.showMessageDialog(null, "Processo Finalizado");
				System.out.println("Processo Finalizado");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}else if(os().contains("Linux")) {
			String process = "pkill -f "; 
			StringBuffer buffer = new StringBuffer(); 
			buffer.append(process);
			buffer.append(Nome);
			try {
				Runtime.getRuntime().exec(buffer.toString());
				JOptionPane.showMessageDialog(null, "Processo Finalizado");
				System.out.println("Processo Finalizado");
			} catch (IOException e) {
				e.printStackTrace();
			}
			

		}else{
			JOptionPane.showMessageDialog(null, "Identificação de Sistema Operacional não pode identificar o sistema atual");
		}
		}
	
	
	}
	
	



