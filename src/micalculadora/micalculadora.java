package micalculadora;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class micalculadora extends JFrame { //hecho por Juan Alberto

	//inicializamos todo lo que vamos a mostrar por pantalla
	static JFrame frame = new JFrame("Mi calculadora");
	static JTextField textField1, textField2, textField3;
	static JLabel label1, label2, label3; 
	static JButton bMas, bMenos, bPor, bDiv, cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, punto, borrar;
	static JButton cero1, uno1, dos1, tres1, cuatro1, cinco1, seis1, siete1, ocho1, nueve1, punto1;
	static String valor1 = "";
	static String valor2 = "";
	static JPanel pantalla = new JPanel();
	
	public static void main(String[] args) {

		micalculadora c = new micalculadora();
		c.pack();
	}

	public micalculadora() {
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		frame.setPreferredSize(new Dimension(230, 370));
		
		pantalla.setLayout(new GridLayout(0, 1));
		pantalla.setPreferredSize(new Dimension(100,200));
		pantalla.setLocation(20, 20);
		pantalla.setBackground(Color.decode("#338E33")); //usamos el decode para poner otro color de html
		
		label1 = new JLabel("       Valor 1       "); //los label tendrán lo que nosotros indiquemos al usuario
		label2 = new JLabel("      Valor 2      ");
		label3 = new JLabel("Resultado");
		
		textField1 = new JTextField(9); //los textField, indicamos el número de caracteres o números que puede haber en pantalla
		textField2 = new JTextField(9);
		textField3 = new JTextField(12);
		
		cero = new JButton("0"); //creamos cada uno de los botones
		uno = new JButton("1");
		dos = new JButton("2");
		tres = new JButton("3");
		cuatro = new JButton("4");
		cinco = new JButton("5");
		seis = new JButton("6");
		siete = new JButton("7");
		ocho = new JButton("8");
		nueve = new JButton("9");
		punto = new JButton("                         .                         ");
		cero1 = new JButton("0.");
		uno1 = new JButton("1.");
		dos1 = new JButton("2.");
		tres1 = new JButton("3.");
		cuatro1 = new JButton("4.");
		cinco1 = new JButton("5.");
		seis1 = new JButton("6.");
		siete1 = new JButton("7.");
		ocho1 = new JButton("8.");
		nueve1 = new JButton("9.");
		punto1 = new JButton("         ..         ");
		bMas = new JButton("+");
		bMenos = new JButton("- ");
		bPor = new JButton("*");
		bDiv = new JButton("/ ");
		borrar = new JButton("                 Borrar                 ");
		
		textField1.setEditable(false); //lo usamos para que el usuario no pueda editarlo por teclado
		textField2.setEditable(false);
		textField3.setEditable(false); 

		pantalla.setPreferredSize(new Dimension(230, 330)); //ponemos la dimensión de la ventana
		pantalla.setLayout(new FlowLayout());
		
		pantalla.add(label1); //añadimos todo a la pantalla
		pantalla.add(textField1);
		pantalla.add(cero);
		pantalla.add(uno);
		pantalla.add(dos);
		pantalla.add(tres);
		pantalla.add(cuatro);
		pantalla.add(cinco);
		pantalla.add(seis);
		pantalla.add(siete);
		pantalla.add(ocho);
		pantalla.add(nueve);
		pantalla.add(punto);
		pantalla.add(label2);
		pantalla.add(textField2);
		pantalla.add(cero1);
		pantalla.add(uno1);
		pantalla.add(dos1);
		pantalla.add(tres1);
		pantalla.add(cuatro1);
		pantalla.add(cinco1);
		pantalla.add(seis1);
		pantalla.add(siete1);
		pantalla.add(ocho1);
		pantalla.add(nueve1);
		pantalla.add(punto1);
		pantalla.add(bMas);
		bMas.setBackground(java.awt.Color.gray);
		bMas.setEnabled(false); //esto es para no permitir al usuario pulsar el boton
		pantalla.add(bMenos);
		bMenos.setBackground(java.awt.Color.gray); //para cambiarle el color a la celda
		bMenos.setEnabled(false);
		pantalla.add(bPor);
		bPor.setBackground(java.awt.Color.gray);
		bPor.setEnabled(false);
		pantalla.add(bDiv);
		bDiv.setBackground(java.awt.Color.gray);
		bDiv.setEnabled(false);
		pantalla.add(borrar);
		borrar.setBackground(java.awt.Color.gray);
		borrar.setEnabled(false);
		pantalla.add(label3);
		pantalla.add(textField3);
		cero.addActionListener(new evento()); //usamos el orientado a eventos en todos los botones
		uno.addActionListener(new evento());
		dos.addActionListener(new evento());
		tres.addActionListener(new evento());
		cuatro.addActionListener(new evento());
		cinco.addActionListener(new evento());
		seis.addActionListener(new evento());
		siete.addActionListener(new evento());
		ocho.addActionListener(new evento());
		nueve.addActionListener(new evento());
		punto.addActionListener(new evento());
		cero1.addActionListener(new evento());
		uno1.addActionListener(new evento());
		dos1.addActionListener(new evento());
		tres1.addActionListener(new evento());
		cuatro1.addActionListener(new evento());
		cinco1.addActionListener(new evento());
		seis1.addActionListener(new evento());
		siete1.addActionListener(new evento());
		ocho1.addActionListener(new evento());
		nueve1.addActionListener(new evento());
		punto1.addActionListener(new evento());
		bMas.addActionListener(new evento());
		bMenos.addActionListener(new evento());
		bPor.addActionListener(new evento());
		bDiv.addActionListener(new evento());
		borrar.addActionListener(new evento());
		
		frame.add(pantalla);
		frame.pack();
		frame.setVisible(true);
	}

	private class evento implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			double resultado = 0;
			
			//aquí cuando el usuario pulse un botón se le mostrara en la casilla valor 1 el número pulsado
			switch (e.getActionCommand()) {
			
			case "0":
				valor1 = valor1 + "0";
				break;
				
			case "1":
				valor1 = valor1 + "1";
				break;
				
			case "2":
				valor1 = valor1 + "2";
				break;
			
			case "3":
				valor1 = valor1 + "3";
				break;
				
			case "4":
				valor1 = valor1 + "4";
				break;
				
			case "5":
				valor1 = valor1 + "5";
				break;
				
			case "6":
				valor1 = valor1 + "6";
				break;
				
			case "7":
				valor1 = valor1 + "7";
				break;
				
			case "8":
				valor1 = valor1 + "8";
				break;
				
			case "9":
				valor1 = valor1 + "9";
				break;
				
			case "                         .                         ":
				valor1 = valor1 + ".";
				break;
				//si pulsa borrar, quitamos los números introducidos
			case "                 Borrar                 ":
				valor1 = "";
				valor2 = "";
				break;
				
			}
			
			//aquí cuando el usuario pulse un botón se le mostrara en la casilla valor 2 el número pulsado
			switch (e.getActionCommand()) {
			
			case "0.":
				valor2 = valor2 + "0";
				break;
				
			case "1.":
				valor2 = valor2 + "1";
				break;
				
			case "2.":
				valor2 = valor2 + "2";
				break;
			
			case "3.":
				valor2 = valor2 + "3";
				break;
				
			case "4.":
				valor2 = valor2 + "4";
				break;
				
			case "5.":
				valor2 = valor2 + "5";
				break;
				
			case "6.":
				valor2 = valor2 + "6";
				break;
				
			case "7.":
				valor2 = valor2 + "7";
				break;
				
			case "8.":
				valor2 = valor2 + "8";
				break;
				
			case "9.":
				valor2 = valor2 + "9";
				break;
				
			case "         ..         ":
				valor2 = valor2 + ".";
				break;
			}
			textField1.setText(valor1); //cambiamos los textField por el valor1 y valor2 que es lo que el usuario pulso
			textField2.setText(valor2);
			
			if (!textField1.equals("") && !textField2.equals("")) {
				bMas.setEnabled(true);
				bMenos.setEnabled(true);
				bDiv.setEnabled(true);
				bPor.setEnabled(true);
				borrar.setEnabled(true);
			}
			
			
			//usamos if para hacer los calculos de suma, resta, multiplicar y dividir
			if (e.getActionCommand().equals("+")) {
				double valor3 = Double.parseDouble(valor1);
				double valor4 = Double.parseDouble(valor2);
				resultado = valor3 + valor4;
				textField3.setText(Double.toString(resultado));
			}
			if (e.getActionCommand().equals("- ")) {
				double valor3 = Double.parseDouble(valor1);
				double valor4 = Double.parseDouble(valor2);
				resultado = valor3 - valor4;
				textField3.setText(Double.toString(resultado));
			}
			if (e.getActionCommand().equals("*")) {
				double valor3 = Double.parseDouble(valor1);
				double valor4 = Double.parseDouble(valor2);
				resultado = valor3 * valor4;
				textField3.setText(Double.toString(resultado));
			}
			if (e.getActionCommand().equals("/ ")) {
				double valor3 = Double.parseDouble(valor1); //lo pasamos a double
				double valor4 = Double.parseDouble(valor2);
				
				if (valor4 != 0) { //esto es para que no se divida entre 0
					resultado = valor3 / valor4;
					} else {
						JOptionPane.showMessageDialog(null, "No introduzcas en el valor2 un 0");
					}
				textField3.setText(Double.toString(resultado));
								
			}
			if (e.getActionCommand().equals("                 Borrar                 ")) {
				bMas.setEnabled(false);
				bMenos.setEnabled(false);
				bDiv.setEnabled(false);
				bPor.setEnabled(false);
				borrar.setEnabled(false);
			}


		}
	}
}
