package projeto.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import projeto.Fachada;
import projeto.autor.Autor;
import projeto.contrato.Contrato;
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
public class JFrmCadContrato extends javax.swing.JFrame {

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

	private JLabel jLblNomeResponsavel;
	private JButton jBtnRemover;
	private JButton jBtnAlterar;
	private JButton jBtnInserir;
	private JButton jBtnConsultar;
	private JTextField jTxtValor;
	private JTextField jTxtNomeResponsavel;
	private JLabel jLblValor;
	private Fachada fachada = Fachada.obterInstancia();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrmCadContrato inst = new JFrmCadContrato();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JFrmCadContrato() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(416, 193));
			{
				jLblNomeResponsavel = new JLabel();
				getContentPane().add(jLblNomeResponsavel);
				jLblNomeResponsavel.setText("Nome do Responsável:");
				jLblNomeResponsavel.setBounds(12, 26, 121, 16);
			}
			{
				jLblValor = new JLabel();
				getContentPane().add(jLblValor);
				jLblValor.setText("Valor:");
				jLblValor.setBounds(12, 54, 30, 16);
			}
			{
				jTxtNomeResponsavel = new JTextField();
				getContentPane().add(jTxtNomeResponsavel);
				jTxtNomeResponsavel.setBounds(137, 22, 187, 20);
			}
			{
				jTxtValor = new JTextField();
				getContentPane().add(jTxtValor);
				jTxtValor.setBounds(137, 54, 187, 20);
				jTxtValor.setText("0");
			}
			{
				jBtnConsultar = new JButton();
				getContentPane().add(jBtnConsultar);
				jBtnConsultar.setText("Consultar");
				jBtnConsultar.setBounds(188, 94, 75, 23);
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
				jBtnRemover.setBounds(124, 94, 59, 23);
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
				jBtnAlterar.setBounds(75, 94, 47, 23);
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
				jBtnInserir.setBounds(12, 95, 60, 21);
				jBtnInserir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnInserirActionPerformed(evt);
					}
				});
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void validacao() throws ExcecaoNegocio{		
		if(jTxtNomeResponsavel.getText().trim().equals("")){
			throw new ExcecaoNegocio("O Nome deve ser informado");
		}
		if(jTxtValor.getText().trim().equals("")){
			throw new ExcecaoNegocio("O valor deve ser informado");
		}
	}
	private void jBtnInserirActionPerformed(ActionEvent evt) {
		try {
			this.validacao();
			Contrato contrato = new Contrato();
			contrato.setNome(jTxtNomeResponsavel.getText());
			double valor = Double.parseDouble(jTxtValor.getText());
			contrato.setValor(valor);
			fachada.inserirContrato(contrato);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo Valor deve conter um valor númerico");
		}
	}
	
	private void jBtnAlterarActionPerformed(ActionEvent evt) {
		try {
			this.validacao();
			int codigo;
			codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Informe o código do Contrato: "
					));
			Contrato contrato = new Contrato();
			contrato.setCodigo(codigo);
			contrato.setNome(jTxtNomeResponsavel.getText());
			double valor = Double.parseDouble(jTxtValor.getText());
			contrato.setValor(valor);
			fachada.alterarContrato(contrato);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo o código e Valor devem conter um valor númerico");
		}
	}
	
	private void jBtnRemoverActionPerformed(ActionEvent evt) {
		try {
			int codigo;
			codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Informe o código do Contrato: "
					));			
			fachada.removerContrato(codigo);
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo o código deve conter um valor inteiro");
		}
	}
	
	private void jBtnConsultarActionPerformed(ActionEvent evt) {
		try {
			int codigo;
			codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Informe o código do Contrato: "
					));
			Contrato contrato = fachada.consultarContrato(codigo);
			jTxtNomeResponsavel.setText(contrato.getNome());
			jTxtValor.setText(contrato.getValor()+"");
		} catch (ExcecaoNegocio e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O Campo o código deve conter um valor inteiro");
		}
	}

}
