package projeto.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import projeto.endereco.Endereco;
import projeto.excecao.ExcecaoNegocio;


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
public class JFrmCadAutor extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JTextField jTxtIdentidade;
	private JLabel jLblIdentidade;
	private JLabel jLblNumero;
	private JTextField jTxtCep;
	private JLabel jLblCep;
	private JTextField jTxtComplemento;
	private JLabel jLblComplemento;
	private JTextField jTxtBairro;
	private JLabel jLblBairro;
	private JTextField jTxtLogradouro;
	private JButton jBtnRemover;
	private JButton jBtnAlterar;
	private JButton jBtnConsultar;
	private JButton jBtnInserir;
	private JTextField jTxtPais;
	private JLabel jLblPais;
	private JComboBox jCmbUf;
	private JLabel jLblUf;
	private JTextField jTxtCidade;
	private JLabel jLblCidade;
	private JTextField jTxtNumero;
	private JLabel jLblLogradouro;
	private JTextField jTxtNome;
	private JLabel jLblNome;
	private Fachada fachada = Fachada.obterInstancia();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrmCadAutor inst = new JFrmCadAutor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JFrmCadAutor() {
		super();
		initGUI();
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(517, 356));
			{
				jTxtIdentidade = new JTextField();
				getContentPane().add(jTxtIdentidade);
				jTxtIdentidade.setBounds(104, 9, 139, 23);
			}
			{
				jLblIdentidade = new JLabel();
				getContentPane().add(jLblIdentidade);
				jLblIdentidade.setText("Identidade:");
				jLblIdentidade.setBounds(12, 12, 59, 16);
			}
			{
				jLblNome = new JLabel();
				getContentPane().add(jLblNome);
				jLblNome.setText("Nome:");
				jLblNome.setBounds(12, 43, 36, 16);
			}
			{
				jTxtNome = new JTextField();
				getContentPane().add(jTxtNome);
				jTxtNome.setBounds(104, 40, 218, 23);
			}
			{
				jLblLogradouro = new JLabel();
				getContentPane().add(jLblLogradouro);
				jLblLogradouro.setText("Logradouro:");
				jLblLogradouro.setBounds(12, 103, 65, 16);
			}
			{
				jTxtLogradouro = new JTextField();
				getContentPane().add(jTxtLogradouro);
				jTxtLogradouro.setBounds(104, 100, 159, 23);
			}
			{
				jLblBairro = new JLabel();
				getContentPane().add(jLblBairro);
				jLblBairro.setText("Bairro:");
				jLblBairro.setBounds(276, 103, 34, 16);
			}
			{
				jTxtBairro = new JTextField();
				getContentPane().add(jTxtBairro);
				jTxtBairro.setBounds(328, 100, 155, 23);
			}
			{
				jLblComplemento = new JLabel();
				getContentPane().add(jLblComplemento);
				jLblComplemento.setText("Complemento:");
				jLblComplemento.setBounds(12, 132, 80, 16);
			}
			{
				jTxtComplemento = new JTextField();
				getContentPane().add(jTxtComplemento);
				jTxtComplemento.setBounds(104, 129, 77, 23);
			}
			{
				jLblCep = new JLabel();
				getContentPane().add(jLblCep);
				jLblCep.setText("Cep:");
				jLblCep.setBounds(335, 132, 24, 16);
			}
			{
				jTxtCep = new JTextField();
				getContentPane().add(jTxtCep);
				jTxtCep.setBounds(371, 129, 112, 23);
			}
			{
				jLblNumero = new JLabel();
				getContentPane().add(jLblNumero);
				jLblNumero.setText("Número:");
				jLblNumero.setBounds(187, 132, 47, 16);
			}
			{
				jTxtNumero = new JTextField();
				getContentPane().add(jTxtNumero);
				jTxtNumero.setBounds(241, 129, 89, 23);
			}
			{
				jLblCidade = new JLabel();
				getContentPane().add(jLblCidade);
				jLblCidade.setText("Cidade:");
				jLblCidade.setBounds(12, 160, 40, 16);
			}
			{
				jTxtCidade = new JTextField();
				getContentPane().add(jTxtCidade);
				jTxtCidade.setBounds(104, 157, 102, 23);
			}
			{
				jLblUf = new JLabel();
				getContentPane().add(jLblUf);
				jLblUf.setText("Uf:");
				jLblUf.setBounds(218, 160, 15, 16);
			}
			{
				ComboBoxModel jCmbUfModel = 
					new DefaultComboBoxModel(
							new String[] { 									
									"AC",
						            "AL",
						            "AP",
						            "AM",
						            "BA",
						            "CE",
						            "DF",
						            "GO",
						            "ES",
						            "MA",
						            "MT",
						            "MS",
						            "MG",
						            "PA",
						            "PB",
						            "PR",
						            "PE",
						            "PI",
						            "RJ",
						            "RN",
						            "RS",
						            "RO",
						            "RR",
						            "SP",
						            "SC",
						            "SE",
						            "TO"
									
							
							});
				jCmbUf = new JComboBox();
				getContentPane().add(jCmbUf);
				jCmbUf.setModel(jCmbUfModel);
				jCmbUf.setBounds(241, 157, 130, 23);
			}
			{
				jLblPais = new JLabel();
				getContentPane().add(jLblPais);
				jLblPais.setText("País:");
				jLblPais.setBounds(377, 164, 24, 16);
			}
			{
				jTxtPais = new JTextField();
				getContentPane().add(jTxtPais);
				jTxtPais.setBounds(407, 161, 76, 23);
			}
			{
				jBtnInserir = new JButton();
				getContentPane().add(jBtnInserir);
				jBtnInserir.setText("Inserir");
				jBtnInserir.setBounds(12, 239, 44, 23);
				jBtnInserir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnInserirActionPerformed(evt);
					}
				});
			}
			{
				jBtnRemover = new JButton();
				getContentPane().add(jBtnRemover);
				jBtnRemover.setText("Remover");
				jBtnRemover.setBounds(116, 239, 59, 23);
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
				jBtnAlterar.setBounds(62, 239, 47, 23);
				jBtnAlterar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnAlterarActionPerformed(evt);
					}
				});
			}
			{
				jBtnConsultar = new JButton();
				getContentPane().add(jBtnConsultar);
				jBtnConsultar.setText("Consultar");
				jBtnConsultar.setBounds(180, 239, 63, 23);
				jBtnConsultar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnConsultarActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(517, 356);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jBtnInserirActionPerformed(ActionEvent evt) {
		try {
			Autor autor = new Autor();
			autor.setIdentidade(Integer.parseInt(jTxtIdentidade.getText()));
			autor.setNome(jTxtNome.getText());
			Endereco endereco = new Endereco();
			endereco.setLogradouro(jTxtLogradouro.getText());
			endereco.setBairro(jTxtBairro.getText());
			endereco.setCidade(jTxtCidade.getText());
			endereco.setComplemento(jTxtComplemento.getText());
			endereco.setNumero(jTxtNumero.getText());
			endereco.setCep(jTxtCep.getText());
			endereco.setPais(jTxtPais.getText());
			endereco.setUf((String)jCmbUf.getSelectedItem());
			autor.setEndereco(endereco);
			fachada.inserirAutor(autor);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Identidade e cep devem conter um valor inteiro.");
			e.printStackTrace();
		}
	}
	
	private void jBtnAlterarActionPerformed(ActionEvent evt) {
		try {
			Autor autor = new Autor();
			autor.setIdentidade(Integer.parseInt(jTxtIdentidade.getText()));
			autor.setNome(jTxtNome.getText());
			Endereco endereco = new Endereco();
			endereco.setLogradouro(jTxtLogradouro.getText());
			endereco.setBairro(jTxtBairro.getText());
			endereco.setCidade(jTxtCidade.getText());
			endereco.setComplemento(jTxtComplemento.getText());
			endereco.setNumero(jTxtNumero.getText());
			endereco.setNumero(jTxtNumero.getText());
			endereco.setCep(jTxtCep.getText());
			endereco.setUf((String)jCmbUf.getSelectedItem());
			endereco.setPais(jTxtPais.getText());
			autor.setEndereco(endereco);
			fachada.alterarAutor(autor);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Identidade e cep devem conter um valor inteiro.");
			e.printStackTrace();
		}
	}
	
	private void jBtnRemoverActionPerformed(ActionEvent evt) {
		try {
			int identidade = (Integer.parseInt(jTxtIdentidade.getText()));

			fachada.removerAutor(identidade);			
			
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Identidade devem conter um valor inteiro.");
			e.printStackTrace();
		}
	}
	
	private void jBtnConsultarActionPerformed(ActionEvent evt) {
		try {			
			
			int identidade = Integer.parseInt(jTxtIdentidade.getText());
			Autor autor = fachada.consultarAutor(identidade);
			jTxtBairro.setText(autor.getEndereco().getBairro());
			jTxtCep.setText(autor.getEndereco().getCep());
			jTxtCidade.setText(autor.getEndereco().getCidade());
			jTxtComplemento.setText(autor.getEndereco().getComplemento());
			jTxtIdentidade.setText(autor.getIdentidade()+"");
			jTxtLogradouro.setText(autor.getEndereco().getLogradouro());
			jTxtNome.setText(autor.getNome());
			jTxtNumero.setText(autor.getEndereco().getNumero());
			jTxtPais.setText(autor.getEndereco().getPais());	
			jCmbUf.setSelectedItem(autor.getEndereco().getUf());
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Identidade e cep devem conter um valor inteiro.");
			e.printStackTrace();
		}
	}

}
