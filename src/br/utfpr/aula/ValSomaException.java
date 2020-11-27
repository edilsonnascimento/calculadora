package br.utfpr.aula;

import javax.swing.JOptionPane;

public class ValSomaException extends Exception{
	
	public void impMsg(){
		JOptionPane.showMessageDialog(null, "Valor execedeu uma centena!", "ERRO de VALOR", 1);
	}

}