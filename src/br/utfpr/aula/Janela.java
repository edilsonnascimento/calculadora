package br.utfpr.aula;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //actionPerformed(ActionEvent)

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Janela implements ActionListener {

	private JFrame jan = new JFrame("1º Titulo");

	private JLabel rtVal1 = new JLabel("ROT1");
	private JLabel rtVal2 = new JLabel("ROT2");
	private JLabel rtResult = new JLabel("Result");

	private JTextField cxVal1 = new JTextField(10);
	private JTextField cxVal2 = new JTextField(10);
	private JTextField cxResult = new JTextField(10);

	private JButton btLimpar = new JButton("QQLimpar");
	private JButton btSair = new JButton("QQSair");
	private JButton btSomar = new JButton("QQSomar");
	private JButton btSubtrair = new JButton("QQSubtrai");
	private JButton btMultiplicar = new JButton("QQMultiplicar");
	private JButton btDividir = new JButton("QQDividir");

	public void criaJan() {

		jan.setVisible(true);

		jan.setLayout(new FlowLayout());

		int larg = 540;
		int alt = 150;
		jan.setSize(larg, alt);

		jan.setTitle("Primeira Janela!");

		// jan.setDefaultCloseOperation(jan.EXIT_ON_CLOSE);
		jan.setDefaultCloseOperation(jan.DISPOSE_ON_CLOSE);

		// jan.setExtendedState(jan.MAXIMIZED_BOTH);
//================================================================== fim do teste da estrutura da janela

		rtVal1.setText("1º Valor");
		jan.add(rtVal1);
		jan.add(cxVal1);

		rtVal2.setText("2º Valor");
		jan.add(rtVal2);
		jan.add(cxVal2);

		rtResult.setText("Total");
		jan.add(rtResult);
		jan.add(cxResult);

		btSomar.setText("+");
		btSubtrair.setText("-");
		btMultiplicar.setText("*");
		btDividir.setText("/");
		btLimpar.setText("Limpar");
		btSair.setText("Sair");

		jan.add(btSomar);
		jan.add(btSubtrair);
		jan.add(btMultiplicar);
		jan.add(btDividir);
		jan.add(btLimpar);
		jan.add(btSair);

		btSair.addActionListener(this);

		btLimpar.addActionListener(this);

		btSomar.addActionListener(this);
		
		btSubtrair.addActionListener(this);
		
		btMultiplicar.addActionListener(this);
		
		btDividir.addActionListener(this);

	} // final do criaJan()

	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource().equals(btSair)) {

			int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Saida",
					JOptionPane.YES_NO_CANCEL_OPTION);

			if (resp == 0) {
				sair();
			}
		}

		if (evt.getSource().equals(btLimpar)) {

			clear();
		}

		if (evt.getSource().equals(btSomar)) {
			try {
				somar();
			} catch (ValSomaException ve) {
				ve.impMsg();
			}
		}
		if (evt.getSource().equals(btSubtrair)) {
			try {
				subtrai();
			} catch (ValSubtracaoExpetion ve) {
				ve.impMsg();
			}
		}
		
		if (evt.getSource().equals(btMultiplicar)) {
			try {
				multiplicar();
			} catch (ValMultiplicacaoExpetion ve) {
				ve.impMsg();
			}
		}

		if (evt.getSource().equals(btDividir)) {
			try {
				dividir();
			} catch (ValDivisaoExpetion ve) {
				ve.impMsg();
			}
		}



	}// fim do actionPerformed

	public void sair() {
		jan.dispose();
	}

	public void clear() {
		cxVal1.setText("");
		cxVal2.setText("");
		cxResult.setText("");
		cxVal1.requestFocus();
	}

	public void somar() throws ValSomaException {

		int calc_I = Integer.parseInt(cxVal1.getText()) + Integer.parseInt(cxVal2.getText());

		if (calc_I <= 100) {
			cxResult.setText(Integer.toString(calc_I));
		} else {
			throw new ValSomaException();
		}
	}
	
	public void subtrai() throws ValSubtracaoExpetion {

		int calc_I = Integer.parseInt(cxVal1.getText()) - Integer.parseInt(cxVal2.getText());

		if (calc_I >= - 100) {
			cxResult.setText(Integer.toString(calc_I));
		} else {
			throw new ValSubtracaoExpetion();
		}
	}

	public void multiplicar() throws ValMultiplicacaoExpetion {

		int calc_I = Integer.parseInt(cxVal1.getText()) * Integer.parseInt(cxVal2.getText());

		if (calc_I <=  100000) {
			cxResult.setText(Integer.toString(calc_I));
		} else {
			throw new ValMultiplicacaoExpetion();
		}
	}
	
	public void dividir() throws ValDivisaoExpetion {

		double calc_I = Double.parseDouble(cxVal1.getText()) / Double.parseDouble(cxVal2.getText());

		if (calc_I >=  0) {
			cxResult.setText(Double.toString(calc_I));
		} else {
			throw new ValDivisaoExpetion();
		}
	}


	public static void main(String arg[]) {

		Janela j = new Janela();
		j.criaJan();

		// new Janela().criaJan();

	}// final main

}