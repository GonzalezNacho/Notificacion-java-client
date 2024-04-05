package com.gonzalez.nacho.clientSocketIO;

import java.awt.Color;
import java.awt.Font;

/*import java.awt.FontFormatException;
import java.io.IOException;
*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana {
	private JFrame window;
	private JPanel textPanel;
	private JLabel textLabelTitle;
	private JLabel textLabelMessage;
	private Font titleFont = new Font("Arial Black", Font.BOLD, 16);
	private Font messageFont = new Font("Arial Black", Font.PLAIN, 12);
	//private Font pixelMplus;
	private String titulo;
	private String mensaje;
	
	public Ventana (String titulo, String mensaje) {
		this.mensaje = mensaje;
		this.titulo = titulo;
		
		window = new JFrame();
		window.setSize(300,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		textPanel = new JPanel();
		textPanel.setBounds(0, 0, 100, 80);
		textPanel.setBackground(Color.black);
		
		textLabelTitle = new JLabel(this.titulo);
		textLabelTitle.setBackground(Color.black);
		textLabelTitle.setForeground(Color.white);
		textLabelTitle.setFont(titleFont);
		textPanel.add(textLabelTitle);
		
		textLabelMessage = new JLabel(this.mensaje);
		textLabelMessage.setBackground(Color.black);
		textLabelMessage.setForeground(Color.white);
		textLabelMessage.setFont(messageFont);
		textPanel.add(textLabelMessage);
		
		window.add(textPanel);
	}
	
	public void mostrarVentana() {
		
		window.setVisible(true);
	}
	
	public void ocultarVentana() {
		window.setVisible(false);
	}
}
