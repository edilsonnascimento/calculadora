package br.utfpr.aula;

import javax.swing.JOptionPane;

public class ValMultiplicacaoExpetion extends Exception{
	
	public void impMsg(){
		JOptionPane.showMessageDialog(null, "Valor n�o pode ser maior que cem mil!", "ERRO de VALOR", 1);
	}


}
