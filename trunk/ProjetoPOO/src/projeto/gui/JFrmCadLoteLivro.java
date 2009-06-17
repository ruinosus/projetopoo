package projeto.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import projeto.Fachada;
import projeto.autor.Autor;
import projeto.editora.Editora;
import projeto.excecao.ExcecaoNegocio;
import projeto.grafica.Grafica;
import projeto.grafica.GraficaEmpresa;
import projeto.grafica.GraficaTerceirizada;
import projeto.livro.Livro;
import projeto.loteLivro.LoteLivro;
import projeto.util.Conversor;


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
public class JFrmCadLoteLivro extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JTextField jTxtDataEntrega;
	private JTextField jTxtNumeroCopias;
	private JLabel jLblGrafica;
	private JButton jBtnRemover;
	private JButton jBtnAlterar;
	private JButton jBtnRelatorio;
	private JComboBox jCmbGraficas;
	private JComboBox jCmbLivros;
	private JButton jBtnInserir;
	private JButton jBtnConsultar;
	private JLabel jLblTipoGrafica;
	private JLabel jLblDataEntrega;
	private JLabel jLblNumeroCopias;
	private JLabel jLblLivro;
	private Fachada fachada = Fachada.obterInstancia();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrmCadLoteLivro inst = new JFrmCadLoteLivro();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JFrmCadLoteLivro() {
		super();
		initGUI();
		this.carregarLivros();
		this.carregarGraficas();
		this.mostrarGrafica();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jTxtNumeroCopias = new JTextField();
				getContentPane().add(jTxtNumeroCopias);
				jTxtNumeroCopias.setBounds(129, 76, 194, 23);
			}
			{
				jTxtDataEntrega = new JTextField();
				getContentPane().add(jTxtDataEntrega);
				jTxtDataEntrega.setBounds(129, 107, 194, 23);
			}
			{
				jLblLivro = new JLabel();
				getContentPane().add(jLblLivro);
				jLblLivro.setText("Livro:");
				jLblLivro.setBounds(12, 15, 29, 16);
			}
			{
				jLblGrafica = new JLabel();
				getContentPane().add(jLblGrafica);
				jLblGrafica.setText("Gráfica:");
				jLblGrafica.setBounds(12, 44, 46, 16);
			}
			{
				jLblNumeroCopias = new JLabel();
				getContentPane().add(jLblNumeroCopias);
				jLblNumeroCopias.setText("Número de Copias:");
				jLblNumeroCopias.setBounds(12, 79, 108, 16);
			}
			{
				jLblDataEntrega = new JLabel();
				getContentPane().add(jLblDataEntrega);
				jLblDataEntrega.setText("Data de Entrega:");
				jLblDataEntrega.setBounds(12, 110, 90, 16);
			}
			{
				jLblTipoGrafica = new JLabel();
				getContentPane().add(jLblTipoGrafica);
				jLblTipoGrafica.setText("grafica");
				jLblTipoGrafica.setBounds(272, 44, 108, 16);
			}
			{
				jBtnConsultar = new JButton();
				getContentPane().add(jBtnConsultar);
				jBtnConsultar.setText("Consultar");
				jBtnConsultar.setBounds(207, 153, 65, 20);
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
				jBtnRemover.setBounds(142, 153, 60, 20);
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
				jBtnAlterar.setBounds(77, 153, 60, 20);
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
				jBtnInserir.setBounds(12, 153, 60, 20);
				jBtnInserir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnInserirActionPerformed(evt);
					}
				});

			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] {  });
				jCmbLivros = new JComboBox();
				getContentPane().add(jCmbLivros);
				jCmbLivros.setModel(jComboBox1Model);
				jCmbLivros.setBounds(68, 12, 255, 23);
			}
			{
				ComboBoxModel jCmbGraficasModel = 
					new DefaultComboBoxModel(
							new String[] {  });
				jCmbGraficas = new JComboBox();
				getContentPane().add(jCmbGraficas);
				jCmbGraficas.setModel(jCmbGraficasModel);
				jCmbGraficas.setBounds(68, 41, 204, 23);
				jCmbGraficas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jCmbGraficasActionPerformed(evt);
					}
				});
			}
			{
				jBtnRelatorio = new JButton();
				getContentPane().add(jBtnRelatorio);
				jBtnRelatorio.setText("Ver Relatorio");
				jBtnRelatorio.setBounds(294, 152, 79, 21);
				jBtnRelatorio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnRelatorioActionPerformed(evt);
					}
				});
			}
			pack();
			
			this.setSize(400, 221);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	private void validacao() throws ExcecaoNegocio{		
		if(jCmbLivros.getSelectedIndex()== - 1){
			throw new ExcecaoNegocio("O Livro deve ser informado");
		}
		if(jCmbGraficas.getSelectedIndex()== - 1){
			throw new ExcecaoNegocio("A Gráfica deve ser informada");
		}
		if(jTxtNumeroCopias.getText().trim().equals("")){
			throw new ExcecaoNegocio("O Número de Copias deve ser informado");
		}
		if(jTxtDataEntrega.getText().trim().equals("")){
			throw new ExcecaoNegocio("A data de entrega deve ser informada");
		}
	}
	private void carregarLivros(){
		try {
			jCmbLivros.removeAllItems();
			ArrayList<Livro> livros =  fachada.consultarLivro();
			
			for (int i = 0; i < livros.size(); i++) {
				jCmbLivros.addItem(livros.get(i));
			}
		} catch (ExcecaoNegocio e) {

		}
	}
	private void carregarGraficas(){
		try {
			jCmbGraficas.removeAllItems();
			ArrayList<Grafica> graficas =  fachada.consultarGrafica();
			
			for (int i = 0; i < graficas.size(); i++) {
				jCmbGraficas.addItem(graficas.get(i));
			}
		} catch (ExcecaoNegocio e) {

		}
	}
	
	private void mostrarGrafica(){
		if(jCmbGraficas.getSelectedIndex()!=-1){
			Grafica grafica = (Grafica)jCmbGraficas.getSelectedItem();
			
			if(grafica instanceof GraficaEmpresa){
				jLblTipoGrafica.setText("Gráfica da Empresa");
			}
			if(grafica instanceof GraficaTerceirizada){
				jLblTipoGrafica.setText("Gráfica Terceirizada");
			}
				
		}else{
			jLblTipoGrafica.setText("");
		}
	}
	
	
	
	private void jBtnInserirActionPerformed(ActionEvent evt) {
		try {
			this.validacao();
			LoteLivro loteLivro = new LoteLivro();

			loteLivro.setLivro((Livro) jCmbLivros.getSelectedItem());
			loteLivro.setGrafica((Grafica) jCmbGraficas.getSelectedItem());
			int numeroCopias = Integer.parseInt(jTxtNumeroCopias.getText());
			loteLivro.setNumeroCopias(numeroCopias);
			loteLivro.setDataEntrega(Conversor.parseDateSQL(jTxtDataEntrega.getText()));
			fachada.inserirLoteLivro(loteLivro);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Número de copias deve conter um valor inteiro.");
		}
	}
	
	private void jBtnAlterarActionPerformed(ActionEvent evt) {
		try {
			this.validacao();
			int codigo;
			codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Informe o código do Lote: "
					));
			LoteLivro loteLivro = new LoteLivro();
			loteLivro.setCodigo(codigo);
			
			loteLivro.setLivro((Livro) jCmbLivros.getSelectedItem());
			loteLivro.setGrafica((Grafica) jCmbGraficas.getSelectedItem());
			int numeroCopias = Integer.parseInt(jTxtNumeroCopias.getText());
			loteLivro.setNumeroCopias(numeroCopias);
			
			loteLivro.setDataEntrega(Conversor.parseDateSQL(jTxtDataEntrega.getText()));
			fachada.alterarLoteLivro(loteLivro);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Código e o número de copias devem conter um valor inteiro.");
		}
	}
	
	private void jBtnRemoverActionPerformed(ActionEvent evt) {
		try {
			this.validacao();
			int codigo;
			codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Informe o código do Lote: "
					));			
			fachada.removerLoteLivro(codigo);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Código deve conter um valor inteiro.");
		}
	}
	
	private void jBtnConsultarActionPerformed(ActionEvent evt) {
		try {
			int codigo;
			codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Informe o código do Lote: "
					));			
			LoteLivro loteLivro = fachada.consultarLoteLivro(codigo);
			jTxtNumeroCopias.setText(loteLivro.getNumeroCopias()+"");
			jTxtDataEntrega.setText(Conversor.formatDateSQL(loteLivro.getDataEntrega()));
			jCmbGraficas.setSelectedItem(loteLivro.getGrafica());
			jCmbLivros.setSelectedItem(loteLivro.getLivro());
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Código deve conter um valor inteiro.");
		}
	}
	
	private void jCmbGraficasActionPerformed(ActionEvent evt) {
		mostrarGrafica();
	}
	
	private void jBtnRelatorioActionPerformed(ActionEvent evt) {
		JFrmRelLoteLivro frmRelLoteLivro = new JFrmRelLoteLivro();
		frmRelLoteLivro.setVisible(true);
	}

}
