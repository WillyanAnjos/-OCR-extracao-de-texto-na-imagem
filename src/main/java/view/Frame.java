package view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import service.ReadImage;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.Scrollbar;
import javax.swing.JToggleButton;
import java.awt.List;
import java.awt.ScrollPane;

public class Frame extends JFrame {
	JLabel lblNewLabel_1 = new JLabel("");
	JTextArea textArea = new JTextArea();
	
	public Frame() {
		setTitle("Extrair textos de images");
		setResizable(false);
		setSize(556, 717);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Entrada com imagem");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 10, 343, 44);
		getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 64, 524, 399);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Selecionar imagem");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					abrirImagem();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 352, 496, 33);
		panel.add(btnNewButton);
		lblNewLabel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		lblNewLabel_1.setBounds(10, 10, 496, 329);
		panel.add(lblNewLabel_1);
		
		JLabel lblSadaComTexto = new JLabel("Sa\u00EDda com texto");
		lblSadaComTexto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSadaComTexto.setBounds(10, 473, 343, 31);
		getContentPane().add(lblSadaComTexto);
		
	
		textArea.setBounds(10, 514, 524, 159);
		getContentPane().add(textArea);
	}

	private ImageIcon resizeImage(String imageLocal) {
		ImageIcon m = new ImageIcon(imageLocal);
		Image img = m.getImage();
		ImageIcon image = new ImageIcon(img);
		return image;
	}

	private void abrirImagem() throws IOException {
		JFileChooser arquivo = new JFileChooser();
		arquivo.setCurrentDirectory(new File(System.getProperty("user.home")));

		// Filtro para tipos especificos
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.Images", "jpg", "png");
		// Seta o filtro na hora da seleção
		arquivo.addChoosableFileFilter(filtro);

		int resultado = arquivo.showSaveDialog(null);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			File arquivoSelecionado = arquivo.getSelectedFile();
			String caminho = arquivoSelecionado.getAbsolutePath();

			lblNewLabel_1.setIcon(resizeImage(caminho));
			ReadImage ri = new ReadImage();

			textArea.setText(ri.getImgText(caminho));
	

		} else if (resultado == JFileChooser.CANCEL_OPTION) {
			System.out.println("Cancelado");
		}
	}
}
