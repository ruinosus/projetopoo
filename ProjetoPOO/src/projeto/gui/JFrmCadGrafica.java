package projeto.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import projeto.Fachada;
import projeto.autor.Autor;
import projeto.contrato.Contrato;
import projeto.editora.Editora;
import projeto.endereco.Endereco;
import projeto.excecao.ExcecaoNegocio;
import projeto.grafica.Grafica;
import projeto.grafica.GraficaEmpresa;
import projeto.grafica.GraficaTerceirizada;


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
	private JButton jBtnRelatorio;
	private JLabel jLblValorContrato;
	private JLabel jLblCodigoContrato;
	private JButton jBtnConsultar;
	private JButton jBtnInserir;
	private JComboBox jCmbContrato;
	private JLabel jLblContrato;
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
		habilitarComponentes();
		this.carregarContratos();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(517, 280));
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
				getContentPane().add(getJLblContrato());
				getContentPane().add(getJCmbContrato());
				getContentPane().add(getJBtnInserir());
				getContentPane().add(getJBtnRemover());
				getContentPane().add(getJBtnAlterar());
				getContentPane().add(getJBtnConsultar());
				getContentPane().add(getJLblCodigoContrato());
				getContentPane().add(getJLblValorContrato());
				getContentPane().add(getJBtnRelatorio());
				jPanel1.setBounds(314, 12, 169, 51);
				jPanel1.setBorder(BorderFactory.createTitledBorder("Tipos de Gráfica"));
				{
					jRdGraficaEmpresa = new JRadioButton();
					jPanel1.add(jRdGraficaEmpresa);
					jRdGraficaEmpresa.setText("Empresa");
					jRdGraficaEmpresa.setBounds(359, 20, 63, 20);
					jRdGraficaEmpresa.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRdGraficaEmpresaActionPerformed(evt);
						}
					});
				}
				{
					jRdGraficaTerceirizada = new JRadioButton();
					jPanel1.add(jRdGraficaTerceirizada);
					jRdGraficaTerceirizada.setText("Terceirizada");
					jRdGraficaTerceirizada.setBounds(359, 49, 81, 20);
					jRdGraficaTerceirizada.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRdGraficaTerceirizadaActionPerformed(evt);
						}
					});
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
	
	private JLabel getJLblContrato() {
		if(jLblContrato == null) {
			jLblContrato = new JLabel();
			jLblContrato.setText("Contrato:");
			jLblContrato.setBounds(12, 76, 50, 16);
		}
		return jLblContrato;
	}
	
	private JComboBox getJCmbContrato() {
		if(jCmbContrato == null) {
			ComboBoxModel jCmbContratoModel = 
				new DefaultComboBoxModel(
						new String[] { });
			jCmbContrato = new JComboBox();
			jCmbContrato.setModel(jCmbContratoModel);
			jCmbContrato.setBounds(104, 70, 204, 23);
			jCmbContrato.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jCmbContratoActionPerformed(evt);
				}
			});
		}
		return jCmbContrato;
	}
	
	private void jRdGraficaEmpresaActionPerformed(ActionEvent evt) {
		habilitarComponentes();
	}
	
	private void jRdGraficaTerceirizadaActionPerformed(ActionEvent evt) {
		habilitarComponentes();
	}
	
	private void habilitarComponentes(){	
		jLblCodigoContrato.setVisible(jRdGraficaTerceirizada.isSelected());
		jLblValorContrato.setVisible(jRdGraficaTerceirizada.isSelected());
		jLblBairro.setVisible(jRdGraficaTerceirizada.isSelected());
		jLblCep.setVisible(jRdGraficaTerceirizada.isSelected());
		jLblCidade.setVisible(jRdGraficaTerceirizada.isSelected());
		jLblComplemento.setVisible(jRdGraficaTerceirizada.isSelected());
		jLblContrato.setVisible(jRdGraficaTerceirizada.isSelected());
		jLblLogradouro.setVisible(jRdGraficaTerceirizada.isSelected());
		jLblNumero.setVisible(jRdGraficaTerceirizada.isSelected());
		jLblPais.setVisible(jRdGraficaTerceirizada.isSelected());
		jLblUf.setVisible(jRdGraficaTerceirizada.isSelected());
		jCmbContrato.setVisible(jRdGraficaTerceirizada.isSelected());
		jCmbUf.setVisible(jRdGraficaTerceirizada.isSelected());
		jTxtBairro.setVisible(jRdGraficaTerceirizada.isSelected());
		jTxtCep.setVisible(jRdGraficaTerceirizada.isSelected());
		jTxtCidade.setVisible(jRdGraficaTerceirizada.isSelected());
		jTxtComplemento.setVisible(jRdGraficaTerceirizada.isSelected());
		jTxtLogradouro.setVisible(jRdGraficaTerceirizada.isSelected());
		jTxtNumero.setVisible(jRdGraficaTerceirizada.isSelected());
		jTxtPais.setVisible(jRdGraficaTerceirizada.isSelected());
	}
	
	private JButton getJBtnInserir() {
		if(jBtnInserir == null) {
			jBtnInserir = new JButton();
			jBtnInserir.setText("Inserir");
			jBtnInserir.setBounds(12, 201, 60, 21);
			jBtnInserir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jBtnInserirActionPerformed(evt);
				}
			});
		}		
		return jBtnInserir;
	}
	

	private JButton getJBtnRemover() {
		if(jBtnRemover == null) {
			jBtnRemover = new JButton();
			jBtnRemover.setText("Remover");
			jBtnRemover.setBounds(124, 200, 59, 23);
			jBtnRemover.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jBtnRemoverActionPerformed(evt);
				}
			});
		}
			
		return jBtnRemover;
	}
	
	private JButton getJBtnAlterar() {
		if(jBtnAlterar == null) {
			jBtnAlterar = new JButton();
			jBtnAlterar.setText("Alterar");
			jBtnAlterar.setBounds(75, 200, 47, 23);		
			jBtnAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jBtnAlterarActionPerformed(evt);
				}
			});
		}
		return jBtnAlterar;
	}
	
	private JButton getJBtnConsultar() {
		if(jBtnConsultar == null) {
			jBtnConsultar = new JButton();
			jBtnConsultar.setText("Consultar");
			jBtnConsultar.setBounds(188, 200, 75, 23);
			jBtnConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jBtnConsultarActionPerformed(evt);
				}
			});
		}
		return jBtnConsultar;
	}
	
	private JLabel getJLblCodigoContrato() {
		if(jLblCodigoContrato == null) {
			jLblCodigoContrato = new JLabel();
			jLblCodigoContrato.setText("codigo");
			jLblCodigoContrato.setBounds(314, 73, 69, 16);
		}
		return jLblCodigoContrato;
	}
	
	private JLabel getJLblValorContrato() {
		if(jLblValorContrato == null) {
			jLblValorContrato = new JLabel();
			jLblValorContrato.setText("valor");
			jLblValorContrato.setBounds(383, 73, 100, 16);
		}
		return jLblValorContrato;
	}
	
	private void jBtnInserirActionPerformed(ActionEvent evt) {
		try {
			this.validacao();
			Grafica grafica = new Grafica();

			if(jRdGraficaTerceirizada.isSelected()){
				GraficaTerceirizada gt = new GraficaTerceirizada();
				Endereco endereco = new Endereco();
				endereco.setLogradouro(jTxtLogradouro.getText());
				endereco.setBairro(jTxtBairro.getText());
				endereco.setCidade(jTxtCidade.getText());
				endereco.setComplemento(jTxtComplemento.getText());
				endereco.setNumero(jTxtNumero.getText());
				endereco.setCep(jTxtCep.getText());
				endereco.setPais(jTxtPais.getText());
				endereco.setUf((String)jCmbUf.getSelectedItem());
				gt.setEndereco(endereco);
				gt.setContrato((Contrato) jCmbContrato.getSelectedItem());
				gt.setNome(jTxtNome.getText());
				grafica = gt;
			}else{
				GraficaEmpresa ge = new GraficaEmpresa();
				ge.setNome(jTxtNome.getText());
				grafica = ge;
			}			
			fachada.inserirGrafica(grafica);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Identidade e cep devem conter um valor inteiro.");
		}
	}
	
	private void validacao() throws ExcecaoNegocio{		
		if(jTxtNome.getText().trim().equals("")){
			throw new ExcecaoNegocio("O Nome deve ser informado");
		}
		if(jRdGraficaTerceirizada.isSelected()&& jCmbContrato.getSelectedIndex() == -1){
			throw new ExcecaoNegocio("O Contrato deve ser informado");
		}
	}
	
	private void jBtnAlterarActionPerformed(ActionEvent evt) {
		try {
			this.validacao();
			int codigo;
			codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Informe o código da Gráfica: "
					));	
			Grafica grafica = new Grafica();

			if(jRdGraficaTerceirizada.isSelected()){
				GraficaTerceirizada gt = new GraficaTerceirizada();
				Endereco endereco = new Endereco();
				endereco.setLogradouro(jTxtLogradouro.getText());
				endereco.setBairro(jTxtBairro.getText());
				endereco.setCidade(jTxtCidade.getText());
				endereco.setComplemento(jTxtComplemento.getText());
				endereco.setNumero(jTxtNumero.getText());
				endereco.setCep(jTxtCep.getText());
				endereco.setPais(jTxtPais.getText());
				endereco.setUf((String)jCmbUf.getSelectedItem());
				gt.setEndereco(endereco);
				gt.setContrato((Contrato) jCmbContrato.getSelectedItem());
				gt.setNome(jTxtNome.getText());
				gt.setCodigo(codigo);
				grafica = gt;
			}else{
				GraficaEmpresa ge = new GraficaEmpresa();
				ge.setNome(jTxtNome.getText());
				ge.setCodigo(codigo);
				grafica = ge;
			}			
			fachada.alterarGrafica(grafica);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo código deve conter um valor inteiro.");
		}
	}
	
	private void jBtnRemoverActionPerformed(ActionEvent evt) {
		try {
			int codigo;
			codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Informe o código da Gráfica: "
					));					
			fachada.removerGrafica(codigo);
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
					"Informe o código da Gráfica: "
					));	
			Grafica grafica = fachada.consultarGrafica(codigo);

			if(grafica instanceof GraficaTerceirizada){
				GraficaTerceirizada gt = (GraficaTerceirizada) grafica;
				jRdGraficaTerceirizada.setSelected(true);
				this.habilitarComponentes();
				jTxtNome.setText(gt.getNome());
				jCmbContrato.setSelectedItem(gt.getContrato());
				this.mostrarContrato();
				jTxtBairro.setText(gt.getEndereco().getBairro());
				jTxtCep.setText(gt.getEndereco().getCep());
				jTxtCidade.setText(gt.getEndereco().getCidade());
				jTxtComplemento.setText(gt.getEndereco().getComplemento());			
				jTxtLogradouro.setText(gt.getEndereco().getLogradouro());
				jTxtNome.setText(gt.getNome());
				jTxtNumero.setText(gt.getEndereco().getNumero());
				jTxtPais.setText(gt.getEndereco().getPais());	
				jCmbUf.setSelectedItem(gt.getEndereco().getUf());
				
				gt.setContrato((Contrato) jCmbContrato.getSelectedItem());
				gt.setNome(jTxtNome.getText());
				gt.setCodigo(codigo);
				grafica = gt;
			}
			if(grafica instanceof GraficaEmpresa){
				GraficaEmpresa g2 = (GraficaEmpresa) grafica;
				jRdGraficaEmpresa.setSelected(true);
				this.habilitarComponentes();
				jTxtNome.setText(g2.getNome());
			}						
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());	
			e.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Código deve conter um valor inteiro.");
		}
	}
	
	private void carregarContratos(){
		try {
			ArrayList<Contrato> contratos =  fachada.consultarContrato();
			
			for (int i = 0; i < contratos.size(); i++) {
				jCmbContrato.addItem(contratos.get(i));
			}
		} catch (ExcecaoNegocio e) {

		}
	}
	
	private void mostrarContrato(){
		if(jCmbContrato.getSelectedIndex()!=-1){
			Contrato contrato = (Contrato)jCmbContrato.getSelectedItem();
			jLblCodigoContrato.setText(contrato.getCodigo()+"");
			jLblValorContrato.setText(contrato.getValor()+"");		
		}else{
			jLblCodigoContrato.setText("");
			jLblValorContrato.setText("");
		}
	}
	
	private void jCmbContratoActionPerformed(ActionEvent evt) {
		mostrarContrato();
	}
	
	private JButton getJBtnRelatorio() {
		if(jBtnRelatorio == null) {
			jBtnRelatorio = new JButton();
			jBtnRelatorio.setText("Ver Relatorio");
			jBtnRelatorio.setBounds(404, 201, 79, 21);
			jBtnRelatorio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jBtnRelatorioActionPerformed(evt);
				}
			});
		}
		return jBtnRelatorio;
	}
	
	private void jBtnRelatorioActionPerformed(ActionEvent evt) {
		JFrmRelGrafica frmRelGrafica = new JFrmRelGrafica();
		frmRelGrafica.setVisible(true);
	}

}
