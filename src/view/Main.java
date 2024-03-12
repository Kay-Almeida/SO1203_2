package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {
	
	public static void main(String[] args) {
		KillController kl = new KillController(); 
		
		int opc = 0; 
		
		while(opc!= 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Listar Processos \n2 - Matar processo por PID \n3 - Matar processo Por nome \n9 - Finalizar Programa")); 
			
			switch(opc){
			case 1: kl.listaProcessos(); ;
				break; 
			case 2: int PID =  Integer.parseInt(JOptionPane.showInputDialog("Insira o PID do processo"));
				kl.matarPID(PID);;
				break;
			case 3: String Nome = (JOptionPane.showInputDialog("Insira o Nome do processo"));
					kl.matarNome(Nome);
				break; 
			case 9: JOptionPane.showMessageDialog(null,"Programa Finalizado.");
				break; 
				default: JOptionPane.showMessageDialog(null,"Opção Inválida!"); 
			}

		}
		
	}

}
