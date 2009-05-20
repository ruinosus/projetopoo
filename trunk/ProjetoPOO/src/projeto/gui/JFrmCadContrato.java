package projeto.gui;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel jLblNomeResponsavel;
	private JTextField jTxtValor;
	private JTextField jTxtNomeResponsavel;
	private JLabel jLblValor;

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
			pack();
			this.setSize(416, 193);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
