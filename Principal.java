package desligarpc;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.io.IOException;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtfieldHoras;
	private JFormattedTextField txtfieldMinutos;
	private JFormattedTextField txtfieldSegundos;
	private String sistemaOperacional = "Windows";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal janela = new Principal();
					janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		setResizable(false);
		setVisible(true);
		setTitle("Desligar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//Abaixo, formula para a JanelaIP aparecer centralizada na tela
	    	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	    	setBounds((screenSize.width-340)/2, (screenSize.height-279)/2, 340, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDesligar = new JLabel("Desligar em:");
		lblDesligar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesligar.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesligar.setBounds(56, 66, 221, 26);
		contentPane.add(lblDesligar);
		
		try {
			javax.swing.text.MaskFormatter hms = new javax.swing.text.MaskFormatter("###");
			txtfieldHoras = new JFormattedTextField(hms);
			txtfieldHoras.setEditable(false);
		}
		catch (Exception e) {
			
		}
		txtfieldHoras.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfieldHoras.setText("001");
		txtfieldHoras.setHorizontalAlignment(SwingConstants.CENTER);
		txtfieldHoras.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtfieldHoras.setBounds(56, 118, 67, 67);
		contentPane.add(txtfieldHoras);

		try {
			javax.swing.text.MaskFormatter hms = new javax.swing.text.MaskFormatter("##");
			txtfieldMinutos = new JFormattedTextField(hms);
			txtfieldMinutos.setEditable(false);
		}
		catch (Exception e) {
			
		}
		txtfieldMinutos.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfieldMinutos.setText("00");
		txtfieldMinutos.setHorizontalAlignment(SwingConstants.CENTER);
		txtfieldMinutos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtfieldMinutos.setBounds(133, 118, 67, 67);
		contentPane.add(txtfieldMinutos);
		
		try {
			javax.swing.text.MaskFormatter hms = new javax.swing.text.MaskFormatter("##");
			txtfieldSegundos = new JFormattedTextField(hms);
			txtfieldSegundos.setEditable(false);
		}
		catch (Exception e) {
			
		}
		txtfieldSegundos.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfieldSegundos.setText("00");
		txtfieldSegundos.setToolTipText("");
		txtfieldSegundos.setHorizontalAlignment(SwingConstants.CENTER);
		txtfieldSegundos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtfieldSegundos.setBounds(210, 118, 67, 67);
		contentPane.add(txtfieldSegundos);
		
		JButton btnmaisHoras = new JButton("+");
		btnmaisHoras.setBounds(56, 103, 67, 14);
		contentPane.add(btnmaisHoras);
		btnmaisHoras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if (Integer.parseInt(txtfieldHoras.getText()) != 999){
                	int maishorasInt = Integer.parseInt(txtfieldHoras.getText())+1;
                	String maishorasString = Integer.toString(maishorasInt);
    	        		if (maishorasString.length() < 2) {
    	        			maishorasString = "00" + maishorasString;
    	        		}
    	        		else if (maishorasString.length() < 3) {
                			maishorasString = "0" + maishorasString;
                		}
                	txtfieldHoras.setText(maishorasString);
            	}
            	else if (Integer.parseInt(txtfieldHoras.getText()) == 999) {
            		txtfieldHoras.setText("000");
            	}
            }
		});
		
		JButton btnmenosHoras = new JButton("-");
		btnmenosHoras.setBounds(56, 186, 67, 14);
		contentPane.add(btnmenosHoras);
		btnmenosHoras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            	
            	if (Integer.parseInt(txtfieldHoras.getText()) != 000){
                	int maishorasInt = Integer.parseInt(txtfieldHoras.getText())-1;
                	String maishorasString = Integer.toString(maishorasInt);
    	        		if (maishorasString.length() < 2) {
    	        			maishorasString = "00" + maishorasString;
    	        		}
    	        		else if (maishorasString.length() < 3) {
                			maishorasString = "0" + maishorasString;
                		}
                	txtfieldHoras.setText(maishorasString);
            	}
            	else if (Integer.parseInt(txtfieldHoras.getText()) == 000) {
            		txtfieldHoras.setText("999");
            	}
            }
		});
		
		JButton btnmaisMinutos = new JButton("+");
		btnmaisMinutos.setBounds(133, 103, 67, 14);
		contentPane.add(btnmaisMinutos);
		btnmaisMinutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if (Integer.parseInt(txtfieldMinutos.getText()) != 59) {
	            	int maisminutosInt = Integer.parseInt(txtfieldMinutos.getText())+1;
	            	String maisminutosString = Integer.toString(maisminutosInt);
		        		if (maisminutosString.length() < 2) {
	            			maisminutosString = "0" + maisminutosString;
	            		}
	            	txtfieldMinutos.setText(maisminutosString);
            	}
            	else if (Integer.parseInt(txtfieldMinutos.getText()) == 59) {
            		txtfieldMinutos.setText("00");
            	}
            }
		});
		
		JButton btnmenosMinutos = new JButton("-");
		btnmenosMinutos.setBounds(133, 186, 67, 14);
		contentPane.add(btnmenosMinutos);
		btnmenosMinutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if (Integer.parseInt(txtfieldMinutos.getText()) != 00) {
	            	int maisminutosInt = Integer.parseInt(txtfieldMinutos.getText())-1;
	            	String maisminutosString = Integer.toString(maisminutosInt);
		        		if (maisminutosString.length() < 2) {
	            			maisminutosString = "0" + maisminutosString;
	            		}
	            	txtfieldMinutos.setText(maisminutosString);
            	}
            	else if (Integer.parseInt(txtfieldMinutos.getText()) == 00) {
            		txtfieldMinutos.setText("59");
            	}
            }
		});
		
		JButton btnmaisSegundos = new JButton("+");
		btnmaisSegundos.setBounds(210, 103, 67, 14);
		contentPane.add(btnmaisSegundos);
		btnmaisSegundos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if (Integer.parseInt(txtfieldSegundos.getText()) != 59) {
	            	int maisSegundosInt = Integer.parseInt(txtfieldSegundos.getText())+1;
	            	String maisSegundosString = Integer.toString(maisSegundosInt);
		        		if (maisSegundosString.length() < 2) {
	            			maisSegundosString = "0" + maisSegundosString;
	            		}
	            	txtfieldSegundos.setText(maisSegundosString);
            	}
            	else if (Integer.parseInt(txtfieldSegundos.getText()) == 59) {
            		txtfieldSegundos.setText("00");
            	}
            }
		});

		JButton btnmenosSegundos = new JButton("-");
		btnmenosSegundos.setBounds(210, 186, 67, 14);
		contentPane.add(btnmenosSegundos);
		btnmenosSegundos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if (Integer.parseInt(txtfieldSegundos.getText()) != 00) {
	            	int menosSegundosInt = Integer.parseInt(txtfieldSegundos.getText())-1;
	            	String menosSegundosString = Integer.toString(menosSegundosInt);
		        		if (menosSegundosString.length() < 2) {
	            			menosSegundosString = "0" + menosSegundosString;
	            		}
	            	txtfieldSegundos.setText(menosSegundosString);
            	}
            	else if (Integer.parseInt(txtfieldSegundos.getText()) == 00) {
            		txtfieldSegundos.setText("59");
            	}
            }
		});
		
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.setBounds(56, 235, 221, 23);
		contentPane.add(btnAgendar);
		btnAgendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                    Desliga();
            }
		});
		getRootPane().setDefaultButton(btnAgendar); // Faz a tecla ENTER acionar o bot�o btnAgendar
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(66, 269, 200, 23);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                    Cancela();
            }
		});
		
		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoras.setBounds(56, 206, 67, 14);
		contentPane.add(lblHoras);
		
		JLabel lblMinutos = new JLabel("Minutos");
		lblMinutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutos.setBounds(133, 206, 67, 14);
		contentPane.add(lblMinutos);
		
		JLabel lblSegundos = new JLabel("Segundos");
		lblSegundos.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundos.setBounds(210, 206, 67, 14);
		contentPane.add(lblSegundos);		
		
		JLabel lblPorVDC = new JLabel("Por Vinicius Dimo de Cristofaro");
		lblPorVDC.setForeground(Color.LIGHT_GRAY);
		lblPorVDC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPorVDC.setBounds(10, 310, 314, 14);
		contentPane.add(lblPorVDC);
		
		JLabel lblSelecioneOSistema = new JLabel("Selecione o Sistema Operacional:");
		lblSelecioneOSistema.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelecioneOSistema.setBounds(56, 11, 220, 23);
		contentPane.add(lblSelecioneOSistema);
		
		JComboBox comboSistemaOperacional = new JComboBox();
		comboSistemaOperacional.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboSistemaOperacional.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		comboSistemaOperacional.setBounds(56, 35, 100, 20);
		contentPane.add(comboSistemaOperacional);
			comboSistemaOperacional.addItem("Windows");
			comboSistemaOperacional.addItem("Linux");
			comboSistemaOperacional.addItem("Mac");
		comboSistemaOperacional.setSelectedItem("");

		
		comboSistemaOperacional.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox comboSistemaOperacional = (JComboBox) event.getSource();
                Object selected = comboSistemaOperacional.getSelectedItem();
                if(selected.toString().equals("Windows")) {
                	sistemaOperacional = "Windows";
                }
                else if (selected.toString().equals("Linux")) {
                	sistemaOperacional= "Linux";
                }
                else if (selected.toString().equals("Mac")) {
                	sistemaOperacional= "Mac";
                }
            }
        });
		
	}
	
	public void Desliga () {
		try {
			int horas = Integer.parseInt(txtfieldHoras.getText());
			int minutos = Integer.parseInt(txtfieldMinutos.getText());
			int segundos = Integer.parseInt(txtfieldSegundos.getText()); //pega os valores do textfield e converte para INTEIRO
			
			int tempoemSegundos = ((horas * 60)*60) + (minutos * 60) + segundos;
			int tempoemMinutos = (horas * 60) + minutos;
			int tempoUsado = 5;
			
			String comandoDesligar = "";
			
			if (sistemaOperacional == "Windows") {
				comandoDesligar = "shutdown -s -t ";
				tempoUsado = tempoemSegundos;
			}
			
			else if (sistemaOperacional == "Linux") {
				comandoDesligar = "sudo shutdown -h ";
				tempoUsado = tempoemMinutos;
			}
			
			else if (sistemaOperacional == "Mac") {
				comandoDesligar = "sudo shutdown -h ";
				tempoUsado = tempoemMinutos;
			}
			
				if (tempoUsado>=1){
					Process exec = Runtime.getRuntime().exec(comandoDesligar  + tempoUsado);
				}
				else {
					JOptionPane.showMessageDialog(null, "O tempo deve ser maior ou igual a um segundo!", "Erro!", 2);
				}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insira um valor num�rico!", "Erro!", 2);
		}
	}
	
	public void Cancela () {
		String comandoCancelar = "";
		
		if (sistemaOperacional == "Windows") {
			comandoCancelar = "shutdown -a";
		}
		
		else if (sistemaOperacional == "Linux") {
			comandoCancelar = "sudo shutdown -c";
		}
		
		else if (sistemaOperacional == "Mac") {
			comandoCancelar = "sudo killall shutdown";
		}
		
		try {
			Process exec = Runtime.getRuntime().exec(comandoCancelar);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}