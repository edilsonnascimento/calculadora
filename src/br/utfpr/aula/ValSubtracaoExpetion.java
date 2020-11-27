package br.utfpr.aula;

import javax.swing.JOptionPane;

public class ValSubtracaoExpetion extends Exception{
	
	public void impMsg(){
		JOptionPane.showMessageDialog(null, "Valor não pode ser menor que uma centana negativa!", "ERRO de VALOR", 1);
	}


}
