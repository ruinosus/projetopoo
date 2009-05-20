package projeto.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import projeto.contrato.Contrato;


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
public class JFrmCadLoteLivro extends javax.swing.JFrame {

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

	private JComboBox jCmbLivros;
	private JButton jButton1;
	private JTextField jTxtDataEntrega;
	private JTextField jTxtNumeroCopias;
	private JComboBox jCmbGraficas;
	private JButton jButton2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrmCadLoteLivro inst = new JFrmCadLoteLivro();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JFrmCadLoteLivro() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				jComboBox1Model.setSelectedItem("");
				jCmbLivros = new JComboBox();
				getContentPane().add(jCmbLivros);
				jCmbLivros.setModel(jComboBox1Model);
				jCmbLivros.setBounds(24, 23, 194, 23);
				jCmbLivros.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jCmbLivrosActionPerformed(evt);
					}
				});
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("jButton1");
				jButton1.setBounds(238, 74, 59, 23);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("jButton2");
				jButton2.setBounds(238, 137, 59, 23);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton2ActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				jComboBox1Model.setSelectedItem("");
				jCmbGraficas = new JComboBox();
				getContentPane().add(jCmbGraficas);
				jCmbGraficas.setModel(jComboBox1Model);
				jCmbGraficas.setBounds(24, 69, 194, 23);
				jCmbGraficas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jCmbGraficasActionPerformed(evt);
					}
				});
			}
			{
				jTxtNumeroCopias = new JTextField();
				getContentPane().add(jTxtNumeroCopias);
				jTxtNumeroCopias.setBounds(24, 121, 194, 23);
			}
			{
				jTxtDataEntrega = new JTextField();
				getContentPane().add(jTxtDataEntrega);
				jTxtDataEntrega.setBounds(24, 167, 194, 23);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		Contrato c1 = new Contrato();
		c1.setNome("Jeff");
		c1.setCodigo(1);
		
		Contrato c2 = new Contrato();
		c2.setNome("Bell");
		c2.setCodigo(2);
		
		Contrato c3 = new Contrato();
		c3.setNome("Pato");
		c3.setCodigo(3);
		
		jCmbLivros.removeAllItems();
		jCmbLivros.addItem(c1);
		jCmbLivros.addItem(c2);
		jCmbLivros.addItem(c3);
		
//		ArrayList<Contrato> array = new ArrayList<Contrato>();
//		
//		array.add(c1);
//		array.add(c2);
//		array.add(c3);
//		jCmbLivros.addItem(array);
/*
 * # private ListIterator it;  
	# it = cid.getDao().getLista().listIterator();  
	#        while(it.hasNext()){  
	#             Cidade obj = (Cidade) it.next();  
	#            cbCidade.addItem(obj.getNome());  
	#        }
 * */
	}
	
	private void jCmbLivrosActionPerformed(ActionEvent evt) {
		if(jCmbLivros.getSelectedIndex()!=-1)
			{Contrato c = (Contrato)jCmbLivros.getSelectedItem();  
		 JOptionPane.showMessageDialog(null,"Código: " + c.getCodigo() + " - Nome: " + c.getNome()); 
			}
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		Contrato c = (Contrato)jCmbLivros.getSelectedItem();  
		 JOptionPane.showMessageDialog(null,"Código: " + c.getCodigo() + " - Nome: " + c.getNome()); 
	}
	
	private void jCmbGraficasActionPerformed(ActionEvent evt) {
		System.out.println("jCmbGraficas.actionPerformed, event="+evt);
		//TODO add your code for jCmbGraficas.actionPerformed
	}

}
