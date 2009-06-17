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
import projeto.editora.Editora;
import projeto.excecao.ExcecaoNegocio;
import projeto.grafica.Grafica;


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
public class JFrmRelGrafica extends javax.swing.JFrame {
	private JLabel jLblTitulo;
	private JScrollPane jScrollPane1;
	private JList jLstGrafica;
	private Fachada fachada = Fachada.obterInstancia();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrmRelGrafica inst = new JFrmRelGrafica();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JFrmRelGrafica() {
		super();
		initGUI();
		CarregarGraficas();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 300));
			{
				jLblTitulo = new JLabel();
				getContentPane().add(jLblTitulo);
				jLblTitulo.setText("Relatório das Graficas");
				jLblTitulo.setBounds(124, 33, 126, 16);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 61, 360, 191);
				jScrollPane1.setAutoscrolls(true);
				{
					ListModel jLstGraficaModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
					jLstGrafica = new JList();
					jScrollPane1.setViewportView(jLstGrafica);
					jLstGrafica.setModel(jLstGraficaModel);
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void CarregarGraficas(){
		try {
			Vector<Grafica> graficas = new Vector<Grafica>();
			graficas.addAll(fachada.consultarGrafica());
			jLstGrafica.setListData( graficas);
		} catch (ExcecaoNegocio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
