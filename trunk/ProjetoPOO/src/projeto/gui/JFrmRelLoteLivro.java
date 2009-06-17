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
import projeto.excecao.ExcecaoNegocio;
import projeto.livro.Livro;
import projeto.loteLivro.LoteLivro;


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
public class JFrmRelLoteLivro extends javax.swing.JFrame {
	private JLabel jLblTitulo;
	private JScrollPane jScrollPane1;
	private JList jLstLotLivro;
	private Fachada fachada = Fachada.obterInstancia();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrmRelLoteLivro inst = new JFrmRelLoteLivro();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JFrmRelLoteLivro() {
		super();
		initGUI();
		CarregarLoteLivros();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 300));
			{
				jLblTitulo = new JLabel();
				getContentPane().add(jLblTitulo);
				jLblTitulo.setText("Relatório dos Lotes dos Livros");
				jLblTitulo.setBounds(104, 32, 166, 16);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 67, 360, 185);
				jScrollPane1.setAutoscrolls(true);
				{
					ListModel jLstLotLivroModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
					jLstLotLivro = new JList();
					jScrollPane1.setViewportView(jLstLotLivro);
					jLstLotLivro.setModel(jLstLotLivroModel);
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void CarregarLoteLivros(){
		try {
			Vector<LoteLivro> lotLivros = new Vector<LoteLivro>();

			lotLivros.addAll(fachada.consultarLoteLivro());
			jLstLotLivro.setListData( lotLivros);
		} catch (ExcecaoNegocio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
