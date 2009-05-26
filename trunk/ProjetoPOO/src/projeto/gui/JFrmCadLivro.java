package projeto.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SpinnerListModel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;

import projeto.Fachada;
import projeto.autor.Autor;
import projeto.editora.Editora;
import projeto.excecao.ExcecaoNegocio;
import projeto.livro.Livro;
import projeto.util.Conversor;
import sun.text.resources.FormatData;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class JFrmCadLivro extends javax.swing.JFrame {
	private JLabel jLblTitulo;
	private JTextField jTxtTitulo;
	private JButton jBtnAlterar;
	private JTextField jTxtIsnb;
	private JLabel jLblIsnb;
	private JComboBox jCmbAutorLivro;
	private JButton jBtnRemoverAutor;
	private JButton jBtnAdicionarAutor;
	private JComboBox jCmbAutor;
	private JLabel jLblAutor;
	private JLabel jLblEditora;
	private JComboBox jCmbEditora;
	private JButton jBtnInserir;
	private JButton jBtnRemover;
	private JButton jBtnConsultar;
	private JTextField jTxtDataPublicacao;
	private JLabel jLblDataPublicacao;
	private Fachada fachada = Fachada.obterInstancia();
	private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy"); 
	
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrmCadLivro inst = new JFrmCadLivro();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JFrmCadLivro() {
		super();
		initGUI();
		carregarEditoras();
		carregarAutores();
		habilitarAdicionar();
		habilitarRemover();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(458, 271));
			{
				jLblTitulo = new JLabel();
				getContentPane().add(jLblTitulo);
				jLblTitulo.setText("Título:");
				jLblTitulo.setBounds(22, 34, 34, 16);
			}
			{
				jTxtTitulo = new JTextField();
				getContentPane().add(jTxtTitulo);
				jTxtTitulo.setBounds(138, 31, 219, 23);
			}
			{
				jLblDataPublicacao = new JLabel();
				getContentPane().add(jLblDataPublicacao);
				jLblDataPublicacao.setText("Data de Publicação:");
				jLblDataPublicacao.setBounds(22, 63, 104, 16);
			}
			{
				jTxtDataPublicacao = new JTextField();
				getContentPane().add(jTxtDataPublicacao);
				jTxtDataPublicacao.setBounds(138, 60, 149, 23);
			}
			{
				jBtnConsultar = new JButton();
				getContentPane().add(jBtnConsultar);
				jBtnConsultar.setText("Consultar");
				jBtnConsultar.setBounds(190, 194, 63, 23);
				jBtnConsultar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnConsultarActionPerformed(evt);
					}
				});

			}
			{
				jBtnRemover = new JButton();
				getContentPane().add(jBtnRemover);
				jBtnRemover.setText("Remover");
				jBtnRemover.setBounds(126, 194, 59, 23);
				jBtnRemover.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnRemoverActionPerformed(evt);
					}
				});

			}
			{
				jBtnAlterar = new JButton();
				getContentPane().add(jBtnAlterar);
				jBtnAlterar.setText("Alterar");
				jBtnAlterar.setBounds(72, 194, 47, 23);
				jBtnAlterar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnAlterarActionPerformed(evt);
					}
				});

			}
			{
				jBtnInserir = new JButton();
				getContentPane().add(jBtnInserir);
				jBtnInserir.setText("Inserir");
				jBtnInserir.setBounds(22, 194, 44, 23);
				jBtnInserir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnInserirActionPerformed(evt);
					}
				});

			}
			{
				ComboBoxModel jCmbEditoraModel = 
					new DefaultComboBoxModel();
				jCmbEditora = new JComboBox();
				getContentPane().add(jCmbEditora);
				jCmbEditora.setModel(jCmbEditoraModel);
				jCmbEditora.setBounds(138, 88, 149, 23);
			}
			{
				jLblEditora = new JLabel();
				getContentPane().add(jLblEditora);
				jLblEditora.setText("Editora:");
				jLblEditora.setBounds(22, 91, 40, 16);
			}
			{
				jLblAutor = new JLabel();
				getContentPane().add(jLblAutor);
				jLblAutor.setText("Autor:");
				jLblAutor.setBounds(22, 119, 33, 16);
			}
			{
				ComboBoxModel jCmbAutorModel = 
					new DefaultComboBoxModel(
							new String[] { });
				jCmbAutor = new JComboBox();
				getContentPane().add(jCmbAutor);
				jCmbAutor.setModel(jCmbAutorModel);
				jCmbAutor.setBounds(138, 123, 149, 23);
			}
			{
				jBtnAdicionarAutor = new JButton();
				getContentPane().add(jBtnAdicionarAutor);
				jBtnAdicionarAutor.setText("+");
				jBtnAdicionarAutor.setBounds(293, 123, 20, 23);
				jBtnAdicionarAutor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnAdicionarAutorActionPerformed(evt);
					}
				});
			}
			{
				jBtnRemoverAutor = new JButton();
				getContentPane().add(jBtnRemoverAutor);
				jBtnRemoverAutor.setText("-");
				jBtnRemoverAutor.setBounds(293, 152, 20, 23);
				jBtnRemoverAutor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnRemoverAutorActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel jCmbAutorLivroModel = 
					new DefaultComboBoxModel(
							new String[] { });
				jCmbAutorLivro = new JComboBox();
				getContentPane().add(jCmbAutorLivro);
				jCmbAutorLivro.setModel(jCmbAutorLivroModel);
				jCmbAutorLivro.setBounds(138, 152, 149, 22);
			}
			{
				jLblIsnb = new JLabel();
				getContentPane().add(jLblIsnb);
				jLblIsnb.setText("Isnb:");
				jLblIsnb.setBounds(22, 7, 25, 16);
			}
			{
				jTxtIsnb = new JTextField();
				getContentPane().add(jTxtIsnb);
				jTxtIsnb.setBounds(138, 4, 219, 23);
			}
			pack();
			this.setSize(458, 271);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void carregarEditoras(){
		try {
			ArrayList<Editora> editoras =  fachada.consultarEditora();
			
			for (int i = 0; i < editoras.size(); i++) {
				jCmbEditora.addItem(editoras.get(i));
			}
		} catch (ExcecaoNegocio e) {

		}
	}
	
	private void carregarAutores(){
		try {
			jCmbAutor.removeAllItems();
			ArrayList<Autor> autores =  fachada.consultarAutor();
			
			for (int i = 0; i < autores.size(); i++) {
				jCmbAutor.addItem(autores.get(i));
			}
		} catch (ExcecaoNegocio e) {

		}
	}
	
	private void habilitarAdicionar(){
		jBtnAdicionarAutor.setEnabled(jCmbAutor.getSelectedIndex() != -1);		
	}
	private void habilitarRemover(){
		jBtnRemoverAutor.setEnabled(jCmbAutorLivro.getSelectedIndex() != -1);		
	}
	
	private void jBtnAdicionarAutorActionPerformed(ActionEvent evt) {
		Autor autor = (Autor) jCmbAutor.getSelectedItem();
		jCmbAutorLivro.addItem(autor);
		jCmbAutor.removeItem(autor);
		habilitarAdicionar();
		habilitarRemover();
	}
	
	private void jBtnRemoverAutorActionPerformed(ActionEvent evt) {
		Autor autor = (Autor) jCmbAutorLivro.getSelectedItem();
		jCmbAutorLivro.removeItem(autor);
		jCmbAutor.addItem(autor);
		habilitarAdicionar();
		habilitarRemover();
	}
	
	private void jBtnInserirActionPerformed(ActionEvent evt) {		
		try {
			this.validacao();
			Livro livro = new Livro();
			ArrayList<Autor> autores = new ArrayList<Autor>();
			
			for (int i = 0; i < jCmbAutorLivro.getItemCount(); i++) {
				Autor autor = (Autor) jCmbAutorLivro.getItemAt(i);
				autores.add(autor);
			}
			livro.setAutor(autores);
			livro.setTitulo(jTxtTitulo.getText());
			livro.setEditora((Editora) jCmbEditora.getSelectedItem());
			
			livro.setDataPublicacao(Conversor.parseDateSQL(jTxtDataPublicacao.getText()));
			livro.setIsbn(Integer.parseInt(jTxtIsnb.getText()));
			fachada.inserirLivro(livro);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Isbn devem conter um valor inteiro.");
		}
	}
	
	private void jBtnAlterarActionPerformed(ActionEvent evt) {
		try {
			this.validacao();
			Livro livro = new Livro();
			ArrayList<Autor> autores = new ArrayList<Autor>();
			
			for (int i = 0; i < jCmbAutorLivro.getItemCount(); i++) {
				Autor autor = (Autor) jCmbAutorLivro.getItemAt(i);
				autores.add(autor);
			}
			livro.setAutor(autores);
			livro.setTitulo(jTxtTitulo.getText());
			livro.setEditora((Editora) jCmbEditora.getSelectedItem());
			
			livro.setDataPublicacao(Conversor.parseDateSQL(jTxtDataPublicacao.getText()));
			livro.setIsbn(Integer.parseInt(jTxtIsnb.getText()));
			fachada.alterarLivro(livro);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Isbn devem conter um valor inteiro.");
		}
	}
	
	private void jBtnRemoverActionPerformed(ActionEvent evt) {
		try {
			if(jTxtIsnb.getText().trim().equals("")){
				throw new ExcecaoNegocio("O Isbn deve ser informado");
			}
			int isbn = (Integer.parseInt(jTxtIsnb.getText()));
			fachada.removerLivro(isbn);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Isbn devem conter um valor inteiro.");
		} 
	}
	
	private void jBtnConsultarActionPerformed(ActionEvent evt) {
		try {
			if(jTxtIsnb.getText().trim().equals("")){
				throw new ExcecaoNegocio("O Isbn deve ser informado");
			}
			int isbn = (Integer.parseInt(jTxtIsnb.getText()));
			Livro livro = fachada.consultarLivro(isbn);
			jTxtIsnb.setText(livro.getIsbn()+"");
			jTxtDataPublicacao.setText(Conversor.formatDateSQL(livro.getDataPublicacao()));
			jTxtTitulo.setText(livro.getTitulo());
			jCmbEditora.setSelectedItem(livro.getEditora());
			jCmbAutorLivro.removeAllItems();
			
			this.carregarAutores();
			ArrayList<Autor> autores = livro.getAutor();
			for (int i = 0; i < autores.size(); i++) {
				jCmbAutorLivro.addItem(autores.get(i));					
			}	
			
			this.ajustarAutor();
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Isbn devem conter um valor inteiro.");
		} 
	}
	
	private void ajustarAutor(){
		for (int i = 0; i < jCmbAutorLivro.getItemCount(); i++) {
			Autor autor = (Autor) jCmbAutorLivro.getItemAt(i);
			for (int j = 0; j < jCmbAutor.getItemCount(); j++) {
				Autor autor2 = (Autor) jCmbAutor.getItemAt(j);
				if(autor.equals(autor2)){
					jCmbAutor.removeItem(autor2);
				}
			}
		}
		habilitarAdicionar();
		habilitarRemover();
	}
	private void validacao() throws ExcecaoNegocio{		
		if(jTxtIsnb.getText().trim().equals("")){
			throw new ExcecaoNegocio("O Isbn deve ser informado");
		}
		if(jTxtTitulo.getText().trim().equals("")){
			throw new ExcecaoNegocio("O título deve ser informado");
		}
		if(jTxtDataPublicacao.getText().trim().equals("")){
			throw new ExcecaoNegocio("A data de publicação deve ser informada");
		}
		if(jCmbEditora.getSelectedIndex() == -1){
			throw new ExcecaoNegocio("A editora deve ser informada");
		}
	}
}
