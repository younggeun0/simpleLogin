package simpleLogin.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import simpleLogin.controller.SearchAddressController;

public class SearchAddressView extends JDialog {
	
	private JTextField jtfDong;
	private DefaultTableModel dtmZip;
	private JTable jtZip;
	private JButton jbSearch, jbOk, jbCancel;
	
	public SearchAddressView(SignUpView suv) {
		super(suv, "�ּ� ã��", true);
		
		jtfDong = new JTextField(10);
		JPanel jpNorth = new JPanel();
		
		jbSearch = new JButton("�˻�");
		jbOk = new JButton("����");
		jbCancel = new JButton("���");
		
		jpNorth.add(new JLabel("�� �˻�"));
		jpNorth.add(jtfDong);
		jpNorth.add(jbSearch);
		
		String[] columnNames = { "�����ȣ", "�õ�", "����", "��", "����" };
		dtmZip = new DefaultTableModel(columnNames, 3);
		jtZip = new JTable(dtmZip) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane jsp = new JScrollPane(jtZip);
		
		JPanel jpSouth = new JPanel();
		
		jpSouth.add(jbOk);
		jpSouth.add(jbCancel);
		
		add(BorderLayout.NORTH, jpNorth);
		add(BorderLayout.CENTER, jsp);
		add(BorderLayout.SOUTH, jpSouth);
		
		SearchAddressController sac = new SearchAddressController(this,suv);
		jtZip.addMouseListener(sac);
		jtfDong.addActionListener(sac);
		jbSearch.addActionListener(sac);
		jbOk.addActionListener(sac);
		jbCancel.addActionListener(sac);
		addWindowListener(sac);
		
		setBounds(600, 200, 400, 300);
//		setBounds(suv.getX()+50, suv.getY()+50, 400, 300);
		setVisible(true);
	}
	
	/*public static void main(String[] args) {
		new SearchAddressView();
	}*/

	public JTextField getJtfDong() {
		return jtfDong;
	}

	public DefaultTableModel getDtmZip() {
		return dtmZip;
	}

	public JTable getJtZip() {
		return jtZip;
	}

	public JButton getJbSearch() {
		return jbSearch;
	}

	public JButton getJbOk() {
		return jbOk;
	}

	public JButton getJbCancel() {
		return jbCancel;
	}
	
}
