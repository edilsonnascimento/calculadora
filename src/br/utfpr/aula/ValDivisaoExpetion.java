package br.utfpr.aula;

import javax.swing.JOptionPane;

public class ValDivisaoExpetion extends Exception{
	
	public void impMsg(){
		JOptionPane.showMessageDialog(null, "Valor não pode ser negativo", "ERRO de VALOR", 1);
	}


}
