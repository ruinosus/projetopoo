package projeto.gui;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import projeto.Fachada;
import projeto.contrato.Contrato;
import projeto.editora.Editora;
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
public class JFrmRelEditora extends javax.swing.JFrame {
	private JLabel jLblTitulo;
	private JScrollPane jScrollPane1;
	private JList jLstEditora;
	private Fachada fachada = Fachada.obterInstancia();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrmRelEditora inst = new JFrmRelEditora();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JFrmRelEditora() {
		super();
		initGUI();
		CarregarEditoras();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 300));
			{
				jLblTitulo = new JLabel();
				getContentPane().add(jLblTitulo);
				jLblTitulo.setText("Relatório das Editoras");
				jLblTitulo.setBounds(125, 23, 126, 16);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setAutoscrolls(true);
				jScrollPane1.setBounds(12, 54, 360, 198);
				{
					ListModel jLstEditoraModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
					jLstEditora = new JList();
					jScrollPane1.setViewportView(jLstEditora);
					jLstEditora.setModel(jLstEditoraModel);
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void CarregarEditoras(){
		try {
			Vector<Editora> Editoras = new Vector<Editora>();
			Editoras.addAll(fachada.consultarEditora());
			jLstEditora.setListData( Editoras);
		} catch (ExcecaoNegocio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
