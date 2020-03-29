package com.co.uniandes.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelMenu extends JPanel implements ActionListener {
	
	
	public final static String SALDO = "saldo";
	public final static String RETIROS = "retiros";
	public final static String REPORTE = "reporte";
	
	private JButton btnSaldo;
	private JButton btnRetiros;
	private JButton btnReporte;
	
	
	private InterfazCajero principal;
	
	
	public PanelMenu(InterfazCajero principal) {
		this.principal = principal;
		
		setLayout( new GridLayout( 1, 3 ) );
		
		TitledBorder border = new TitledBorder( "Menu" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );
        
        btnSaldo = new JButton("Saldo");
        btnSaldo.setActionCommand(SALDO);
        btnSaldo.addActionListener(this);
        add(btnSaldo);
        
        btnRetiros = new JButton("Retiros");
        btnRetiros.setActionCommand(RETIROS);
        btnRetiros.addActionListener(this);
        add(btnRetiros);
        
        btnReporte = new JButton("Reporte");
        btnReporte.setActionCommand(REPORTE);
        btnReporte.addActionListener(this);
        add(btnReporte);
	}
	
	public void actionPerformed( ActionEvent pEvento ) {
		
		String comando = pEvento.getActionCommand( );
		
		if( comando.equals( SALDO ) ) {
			
		} else if(comando.equals( RETIROS )) {
			
			
		} else if (comando.equals( REPORTE )) {
			
		}
	}

}
