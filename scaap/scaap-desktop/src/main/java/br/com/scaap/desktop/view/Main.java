package br.com.scaap.desktop.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("SGA");
		frame.setBounds(100, 100, 1200, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmPedro = new JMenuItem("Fazenda");
		mnNewMenu.add(mntmPedro);
		
		JMenuItem mntmRayner = new JMenuItem("Máquinas");
		mnNewMenu.add(mntmRayner);
		
		JMenu mnCadastros = new JMenu("Relatórios");
		menuBar.add(mnCadastros);
		
		JMenu sair = new JMenu("Sair");
		menuBar.add(sair);
		
		JMenuItem mntmBoi = new JMenuItem("Boi");
		mntmBoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boi boi = new Boi();
				boi.setVisible(true);
			}
		});
		mnNewMenu.add(mntmBoi);
		
		JMenuItem mntmVaca = new JMenuItem("Vacas");
		mnCadastros.add(mntmVaca);
	}

}
