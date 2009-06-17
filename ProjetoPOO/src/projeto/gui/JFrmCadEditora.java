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
import projeto.editora.Editora;
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
public class JFrmCadEditora extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JButton jBtnAlterar;
	private JButton jBtnRelatorio;
	private JLabel jLblLogradouro;
	private JTextField jTxtLogradouro;
	private JLabel jLblBairro;
	private JTextField jTxtBairro;
	private JTextField jTxtCep;
	private JLabel jLblCep;
	private JComboBox jCmbUf;
	private JLabel jLblPais;
	private JTextField jTxtPais;
	private JTextField jTxtNumero;
	private JLabel jLblNumero;
	private JLabel jLblUf;
	private JTextField jTxtCidade;
	private JTextField jTxtComplemento;
	private JLabel jLblComplemento;
	private JLabel jLblCidade;
	private JButton jBtnInserir;
	private JButton jBtnRemover;
	private JButton jBtnConsultar;
	private JLabel jLblNome;
	private JTextField jTxtNome;
	private Fachada fachada = Fachada.obterInstancia();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrmCadEditora inst = new JFrmCadEditora();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JFrmCadEditora() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(521, 250));
			{
				jTxtNome = new JTextField();
				getContentPane().add(jTxtNome);
				jTxtNome.setBounds(104, 12, 218, 23);
			}
			{
				jLblNome = new JLabel();
				getContentPane().add(jLblNome);
				jLblNome.setText("Nome:");
				jLblNome.setBounds(12, 15, 36, 16);
			}
			{
				jBtnConsultar = new JButton();
				getContentPane().add(jBtnConsultar);
				jBtnConsultar.setText("Consultar");
				jBtnConsultar.setBounds(180, 174, 63, 23);
				jBtnConsultar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnConsultarActionPerformed(evt);
					}
				});

			}
			{
				jBtnAlterar = new JButton();
				getContentPane().add(jBtnAlterar);
				jBtnAlterar.setText("Alterar");
				jBtnAlterar.setBounds(62, 174, 47, 23);
				jBtnAlterar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnAlterarActionPerformed(evt);
					}
				});

			}
			{
				jBtnRemover = new JButton();
				getContentPane().add(jBtnRemover);
				jBtnRemover.setText("Remover");
				jBtnRemover.setBounds(116, 174, 59, 23);
				jBtnRemover.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnRemoverActionPerformed(evt);
					}
				});

			}
			{
				jBtnInserir = new JButton();
				getContentPane().add(jBtnInserir);
				jBtnInserir.setText("Inserir");
				jBtnInserir.setBounds(12, 174, 44, 23);
				jBtnInserir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnInserirActionPerformed(evt);
					}
				});

			}
			{
				jLblCidade = new JLabel();
				getContentPane().add(jLblCidade);
				jLblCidade.setText("Cidade:");
				jLblCidade.setBounds(12, 132, 40, 16);
			}
			{
				jLblComplemento = new JLabel();
				getContentPane().add(jLblComplemento);
				jLblComplemento.setText("Complemento:");
				jLblComplemento.setBounds(12, 104, 80, 16);
			}
			{
				jTxtComplemento = new JTextField();
				getContentPane().add(jTxtComplemento);
				jTxtComplemento.setBounds(104, 101, 77, 23);
			}
			{
				jTxtCidade = new JTextField();
				getContentPane().add(jTxtCidade);
				jTxtCidade.setBounds(104, 129, 102, 23);
			}
			{
				jLblUf = new JLabel();
				getContentPane().add(jLblUf);
				jLblUf.setText("Uf:");
				jLblUf.setBounds(218, 132, 15, 16);
			}
			{
				jLblNumero = new JLabel();
				getContentPane().add(jLblNumero);
				jLblNumero.setText("Número:");
				jLblNumero.setBounds(187, 104, 47, 16);
			}
			{
				jTxtNumero = new JTextField();
				getContentPane().add(jTxtNumero);
				jTxtNumero.setBounds(241, 101, 89, 23);
			}
			{
				jTxtPais = new JTextField();
				getContentPane().add(jTxtPais);
				jTxtPais.setBounds(407, 133, 76, 23);
			}
			{
				jLblPais = new JLabel();
				getContentPane().add(jLblPais);
				jLblPais.setText("País:");
				jLblPais.setBounds(377, 136, 24, 16);
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
				jCmbUf.setBounds(241, 129, 130, 23);
			}
			{
				jLblCep = new JLabel();
				getContentPane().add(jLblCep);
				jLblCep.setText("Cep:");
				jLblCep.setBounds(335, 104, 24, 16);
			}
			{
				jTxtCep = new JTextField();
				getContentPane().add(jTxtCep);
				jTxtCep.setBounds(371, 101, 112, 23);
			}
			{
				jTxtBairro = new JTextField();
				getContentPane().add(jTxtBairro);
				jTxtBairro.setBounds(328, 72, 155, 23);
			}
			{
				jLblBairro = new JLabel();
				getContentPane().add(jLblBairro);
				jLblBairro.setText("Bairro:");
				jLblBairro.setBounds(276, 75, 34, 16);
			}
			{
				jTxtLogradouro = new JTextField();
				getContentPane().add(jTxtLogradouro);
				jTxtLogradouro.setBounds(104, 72, 159, 23);
			}
			{
				jLblLogradouro = new JLabel();
				getContentPane().add(jLblLogradouro);
				jLblLogradouro.setText("Logradouro:");
				jLblLogradouro.setBounds(12, 75, 65, 16);
			}
			{
				jBtnRelatorio = new JButton();
				getContentPane().add(jBtnRelatorio);
				jBtnRelatorio.setText("Ver Relatorio");
				jBtnRelatorio.setBounds(401, 175, 79, 21);
				jBtnRelatorio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnRelatorioActionPerformed(evt);
					}
				});

			}
			pack();
			this.setSize(521, 250);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jBtnInserirActionPerformed(ActionEvent evt) {
		try {
			this.validacao();
			Editora editora = new Editora();
			editora.setNome(jTxtNome.getText());
			Endereco endereco = new Endereco();
			endereco.setLogradouro(jTxtLogradouro.getText());
			endereco.setBairro(jTxtBairro.getText());
			endereco.setCidade(jTxtCidade.getText());
			endereco.setComplemento(jTxtComplemento.getText());
			endereco.setNumero(jTxtNumero.getText());
			endereco.setCep(jTxtCep.getText());
			endereco.setPais(jTxtPais.getText());
			endereco.setUf((String)jCmbUf.getSelectedItem());
			editora.setEndereco(endereco);
			fachada.inserirEditora(editora);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O  cep deve conter um valor inteiro.");
		}
	}
	
	private void jBtnAlterarActionPerformed(ActionEvent evt) {
		try {
			int codigo;
			codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Informe o código da Editora: "
					));
			Editora editora = new Editora();
			editora.setCodigo(codigo);
			editora.setNome(jTxtNome.getText());
			Endereco endereco = new Endereco();
			endereco.setLogradouro(jTxtLogradouro.getText());
			endereco.setBairro(jTxtBairro.getText());
			endereco.setCidade(jTxtCidade.getText());
			endereco.setComplemento(jTxtComplemento.getText());
			endereco.setNumero(jTxtNumero.getText());
			endereco.setCep(jTxtCep.getText());
			endereco.setPais(jTxtPais.getText());
			endereco.setUf((String)jCmbUf.getSelectedItem());
			editora.setEndereco(endereco);
			fachada.alterarEditora(editora);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O  cep deve conter um valor inteiro.");
		}
	}
	
	private void jBtnRemoverActionPerformed(ActionEvent evt) {
		try {
			int codigo;
			codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Informe o código da Editora: "
					));		

			fachada.removerEditora(codigo);			
			
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo código deve conter um valor inteiro.");
		}
	}
	
	private void jBtnConsultarActionPerformed(ActionEvent evt) {
		try {						
			int codigo;
			codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Informe o código da Editora: "
					));
			Editora editora = fachada.consultarEditora(codigo);
			jTxtBairro.setText(editora.getEndereco().getBairro());
			jTxtCep.setText(editora.getEndereco().getCep());
			jTxtCidade.setText(editora.getEndereco().getCidade());
			jTxtComplemento.setText(editora.getEndereco().getComplemento());			
			jTxtLogradouro.setText(editora.getEndereco().getLogradouro());
			jTxtNome.setText(editora.getNome());
			jTxtNumero.setText(editora.getEndereco().getNumero());
			jTxtPais.setText(editora.getEndereco().getPais());	
			jCmbUf.setSelectedItem(editora.getEndereco().getUf());
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo cep devem conter um valor inteiro.");
		}
	}
	private void validacao() throws ExcecaoNegocio{		
		if(jTxtNome.getText().trim().equals("")){
			throw new ExcecaoNegocio("O Nome deve ser informado");
		}
	}
	
	private void jBtnRelatorioActionPerformed(ActionEvent evt) {
		JFrmRelEditora frmRelEditora = new JFrmRelEditora();
		frmRelEditora.setVisible(true);
	}
}
