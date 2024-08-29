package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

	int contador = 0;// creo que la variable contador, para controlar las veces que se pulsa el boton
						// de decimales
						// ya que no es posible poner dos separador de decimales en una misma cantidad
	String memoria; // creo que la variable para almacenar en memoria

	/*
	 * creo las variables para almacenar las variables y para mostrar el resultado
	 * de la operacion
	 */

	double operador1 = 0, operador2 = 0, resultado = 0;// creo las variables para guardar los operadores de las
														// operaciones y mostrar el resultado final
	char operacion;// creo la variable para indicar la operacion a realizar

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoCalculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton boton1 = new JButton("1");
		boton1.setBounds(36, 55, 48, 37);
		contentPane.add(boton1);

		JButton boton2 = new JButton("2");
		boton2.setBounds(99, 55, 48, 37);
		contentPane.add(boton2);

		JButton boton3 = new JButton("3");
		boton3.setBounds(163, 55, 48, 37);
		contentPane.add(boton3);

		JButton boton4 = new JButton("4");
		boton4.setBounds(36, 101, 48, 37);
		contentPane.add(boton4);

		JButton boton5 = new JButton("5");
		boton5.setBounds(99, 101, 48, 37);
		contentPane.add(boton5);

		JButton boton6 = new JButton("6");
		boton6.setBounds(163, 101, 48, 37);
		contentPane.add(boton6);

		JButton boton7 = new JButton("7");
		boton7.setBounds(36, 146, 48, 37);
		contentPane.add(boton7);

		JButton boton8 = new JButton("8");
		boton8.setBounds(99, 146, 48, 37);
		contentPane.add(boton8);

		JButton boton9 = new JButton("9");
		boton9.setBounds(163, 146, 48, 37);
		contentPane.add(boton9);

		JButton boton0 = new JButton("0");
		boton0.setBounds(36, 191, 48, 37);
		contentPane.add(boton0);

		JButton botonDecimales = new JButton(".");
		botonDecimales.setBounds(99, 191, 48, 37);
		contentPane.add(botonDecimales);

		JButton botonResultado = new JButton("=");
		botonResultado.setBounds(163, 191, 48, 37);
		contentPane.add(botonResultado);

		JButton botonSumar = new JButton("+");
		botonSumar.setBounds(232, 55, 48, 37);
		contentPane.add(botonSumar);

		JButton botonRestar = new JButton("-");
		botonRestar.setBounds(232, 101, 48, 37);
		contentPane.add(botonRestar);

		JButton botonMultiplicar = new JButton("*");
		botonMultiplicar.setBounds(232, 146, 48, 37);
		contentPane.add(botonMultiplicar);

		JButton botonDividir = new JButton("/");
		botonDividir.setBounds(232, 191, 48, 37);
		contentPane.add(botonDividir);

		JButton botonLimpiar = new JButton("Limpiar");
		botonLimpiar.setBounds(301, 55, 107, 50);
		contentPane.add(botonLimpiar);

		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(301, 116, 107, 50);
		contentPane.add(botonGuardar);

		JButton botonRecuperar = new JButton("Recuperar");
		botonRecuperar.setBounds(301, 180, 107, 50);
		contentPane.add(botonRecuperar);

		campoCalculo = new JTextField();
		campoCalculo.setBounds(36, 11, 372, 27);
		contentPane.add(campoCalculo);
		campoCalculo.setColumns(10);

		// EVENTOS
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCalculo.setText(campoCalculo.getText() + "1"); // para que en el caso de pulsar varias veces el
																	// mismo numero no borre lo que habia en el Label
			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCalculo.setText(campoCalculo.getText() + "2"); // para que en el caso de pulsar varias veces el
																	// mismo numero no borre lo que habia en el Label
			}
		});
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCalculo.setText(campoCalculo.getText() + "3"); // para que en el caso de pulsar varias veces el
																	// mismo numero no borre lo que habia en el Label
			}
		});
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCalculo.setText(campoCalculo.getText() + "4"); // para que en el caso de pulsar varias veces el
																	// mismo numero no borre lo que habia en el Label
			}
		});
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCalculo.setText(campoCalculo.getText() + "5"); // para que en el caso de pulsar varias veces el
																	// mismo numero no borre lo que habia en el Label
			}
		});
		boton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCalculo.setText(campoCalculo.getText() + "6"); // para que en el caso de pulsar varias veces el
																	// mismo numero no borre lo que habia en el Label
			}
		});
		boton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCalculo.setText(campoCalculo.getText() + "7"); // para que en el caso de pulsar varias veces el
																	// mismo numero no borre lo que habia en el Label
			}
		});
		boton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCalculo.setText(campoCalculo.getText() + "8"); // para que en el caso de pulsar varias veces el
																	// mismo numero no borre lo que habia en el Label
			}
		});
		boton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCalculo.setText(campoCalculo.getText() + "9"); // para que en el caso de pulsar varias veces el
																	// mismo numero no borre lo que habia en el Label
			}
		});
		boton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCalculo.setText(campoCalculo.getText() + "0"); // para que en el caso de pulsar varias veces el
																	// mismo numero no borre lo que habia en el Label
			}
		});
		botonDecimales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador++;
				if (contador > 1) {
					JOptionPane.showMessageDialog(null,
							"No se puede poner mas de un separador de decimales en la misma cifra");
				} else {
					campoCalculo.setText(campoCalculo.getText() + ".");
				}
			}
		});
		botonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCalculo.setText(""); // limpia los datos que tenga el Label
			}
		});
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memoria = campoCalculo.getText();// guardo en memoria
				campoCalculo.setText("");// despues de guardar borro el Label
			}
		});
		botonRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCalculo.setText(memoria);// recupero la información guarda en memoria
			}
		});
		botonSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operador1 = Double.parseDouble(campoCalculo.getText());
				campoCalculo.setText("");
				operacion = 's';
			}
		});
		botonRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operador1 = Double.parseDouble(campoCalculo.getText());
				campoCalculo.setText("");
				operacion = 'r';

			}
		});
		botonMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operador1 = Double.parseDouble(campoCalculo.getText());
				campoCalculo.setText("");
				operacion = 'm';

			}
		});
		botonDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operador1 = Double.parseDouble(campoCalculo.getText());
				campoCalculo.setText("");
				operacion = 'd';
			}
		});
		botonResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operador2 = Double.parseDouble(campoCalculo.getText());
				campoCalculo.setText("");

				switch (operacion) { // con la variable operacion indico la operacion a seguir en el case del switch
				case 's':
					resultado = operador1 + operador2;
					break;
				case 'r':
					resultado = operador1 - operador2;
					break;
				case 'm':
					resultado = operador1 * operador2;
					break;
				case 'd':
					resultado = operador1 / operador2;
					break;
				}

				campoCalculo.setText(String.valueOf(resultado));
			}
		});
	}
}
