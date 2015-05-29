package br.com.scaap.desktop.view;

import java.awt.Choice;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Boi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the frame.
	 */
	public Boi() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 606, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(100, 40, 132, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(21, 43, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(21, 71, 57, 14);
		contentPane.add(lblCategoria);
		
		Choice choice = new Choice();
		choice.add("Selecione");
		choice.add("Macho");
		choice.add("Fêmea");
		choice.setBounds(100, 65, 196, 20);
		contentPane.add(choice);
		
		JLabel lblNascimentoCadastro = new JLabel("Nascimento Cadastro");
		lblNascimentoCadastro.setBackground(new Color(0, 0, 0));
		lblNascimentoCadastro.setBounds(10, 0, 570, 32);
		contentPane.add(lblNascimentoCadastro);
		
		JLabel label = new JLabel("Observação");
		label.setBounds(21, 96, 82, 14);
		contentPane.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(100, 99, 272, 144);
		contentPane.add(textArea);
		
		JLabel label_1 = new JLabel("Quantidade");
		label_1.setBounds(21, 267, 82, 14);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 263, 192, 20);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Safra");
		label_2.setBounds(21, 302, 57, 14);
		contentPane.add(label_2);
		
		Choice choice_1 = new Choice();
		choice_1.add("Selecione");
		choice_1.add("Entressafra");
		choice_1.setBounds(100, 296, 192, 20);
		contentPane.add(choice_1);
		
		JButton button = new JButton("+");
		button.setBounds(302, 65, 41, 20);
		contentPane.add(button);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(186, 363, 73, 23);
		contentPane.add(btnSalvar);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setBounds(269, 363, 103, 23);
		contentPane.add(button_1);
	}
}
