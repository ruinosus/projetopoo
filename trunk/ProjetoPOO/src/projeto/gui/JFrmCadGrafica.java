package projeto.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import projeto.Fachada;


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
public class JFrmCadGrafica extends javax.swing.JFrame {
	
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
	private JPanel jPanel1;
	private JRadioButton jRdGraficaTerceirizada;
	private JRadioButton jRdGraficaEmpresa;
	private ButtonGroup btnGroupGraficas;
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
				JFrmCadGrafica inst = new JFrmCadGrafica();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JFrmCadGrafica() {
		super();
		initGUI();
		getBtnGroupGraficas();
		jRdGraficaEmpresa.setSelected(true);
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
				jTxtNome.setBounds(104, 40, 204, 23);
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
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(314, 12, 169, 51);
				jPanel1.setBorder(BorderFactory.createTitledBorder("Tipos de Gráfica"));
				{
					jRdGraficaEmpresa = new JRadioButton();
					jPanel1.add(jRdGraficaEmpresa);
					jRdGraficaEmpresa.setText("Empresa");
					jRdGraficaEmpresa.setBounds(359, 20, 63, 20);
				}
				{
					jRdGraficaTerceirizada = new JRadioButton();
					jPanel1.add(jRdGraficaTerceirizada);
					jRdGraficaTerceirizada.setText("Terceirizada");
					jRdGraficaTerceirizada.setBounds(359, 49, 81, 20);
				}
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getBtnGroupGraficas() {
		if(btnGroupGraficas == null) {
			btnGroupGraficas = new ButtonGroup();
		}
		btnGroupGraficas.add(jRdGraficaEmpresa);
		btnGroupGraficas.add(jRdGraficaTerceirizada);
		return btnGroupGraficas;
	}

	

}
