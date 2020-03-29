package com.co.uniandes.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class InterfazCajero extends JFrame {

	private PanelMenu panelMenu;

	public InterfazCajero() {

		setTitle("Cajero Automatico");
		setSize(600, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel norte = new JPanel();
		norte.setLayout(new BorderLayout());
		add(norte, BorderLayout.NORTH);

		panelMenu = new PanelMenu(this);
		norte.add(panelMenu, BorderLayout.NORTH);

	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			InterfazCajero interfaz = new InterfazCajero();
			interfaz.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
