package projeto.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

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
public class JFrmPrincipal extends javax.swing.JFrame {
	private JButton jBtnAutor;
	private JButton jBtnLivro;
	private JButton jBtnEditora;
	
	
	

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrmPrincipal inst = new JFrmPrincipal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JFrmPrincipal() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(160, 234));
			{
				jBtnAutor = new JButton();
				getContentPane().add(jBtnAutor);
				jBtnAutor.setText("Cadastro de Autor");
				jBtnAutor.setBounds(12, 16, 115, 23);
				jBtnAutor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnAutorActionPerformed(evt);
					}
				});
			}
			{
				jBtnEditora = new JButton();
				getContentPane().add(jBtnEditora);
				jBtnEditora.setText("Cadastro de Editora");
				jBtnEditora.setBounds(12, 50, 115, 23);
				jBtnEditora.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEditoraActionPerformed(evt);
					}
				});
			}
			{
				jBtnLivro = new JButton();
				getContentPane().add(jBtnLivro);
				jBtnLivro.setText("Cadastro de Livro");
				jBtnLivro.setBounds(12, 82, 115, 23);
				jBtnLivro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnLivroActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(160, 234);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jBtnAutorActionPerformed(ActionEvent evt) {
		JFrmCadAutor frmCadAutor = new JFrmCadAutor();
		frmCadAutor.setVisible(true);
	}
	
	private void jBtnEditoraActionPerformed(ActionEvent evt) {
		 JFrmCadEditora frmCadEditora = new JFrmCadEditora();
		frmCadEditora.setVisible(true);
	}
	
	private void jBtnLivroActionPerformed(ActionEvent evt) {
		JFrmCadLivro frmCadLivro = new JFrmCadLivro();
		frmCadLivro.setVisible(true);
	}

}