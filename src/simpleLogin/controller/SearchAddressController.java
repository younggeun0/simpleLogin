package simpleLogin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import simpleLogin.dao.LoginDAO;
import simpleLogin.view.SearchAddressView;
import simpleLogin.view.SignUpView;
import simpleLogin.vo.AddressVO;

public class SearchAddressController extends WindowAdapter implements ActionListener, MouseListener  {

	private SearchAddressView sav;
	private SignUpView suv;
	
	public SearchAddressController(SearchAddressView sav, SignUpView suv) {
		this.sav = sav;
		this.suv = suv;
	}
	
	private void search(String dong) {
		try {
			List<AddressVO> list = LoginDAO.getInstance().selectAddress(dong);

			DefaultTableModel dtm = sav.getDtmZip();
			if (!list.isEmpty()) {
				dtm.setRowCount(0);
			}
			
			AddressVO avo = null;
			Object[] rowData = null;
			for(int i=0; i<list.size(); i++) {
				avo = list.get(i);
				
				rowData = new Object[5];
				rowData[0] = avo.getZipcode();
				rowData[1] = avo.getSido();
				rowData[2] = avo.getGugun();
				rowData[3] = avo.getDong();
				rowData[4] = avo.getBunji();
				
				dtm.addRow(rowData);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(sav, "주소정보를 불러올 때 DB문제 발생");
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sav.getJbSearch() || e.getSource() == sav.getJtfDong()) {
			JTextField jtf = sav.getJtfDong();
			
			String dong = jtf.getText().trim();
			
			if (dong.equals("")) {
				JOptionPane.showMessageDialog(sav, "동 이름을 입력해주세요.");
				jtf.requestFocus();
				return;
			}
			
			search(dong);
		}
		
		if (e.getSource() == sav.getJbOk()) {
			
			int selectedRow = sav.getJtZip().getSelectedRow();
			JTable jt = sav.getJtZip();
			
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(sav, "주소를 선택해주세요.");
				return;
			}
			
			suv.getJtfZipcode().setText((String)jt.getValueAt(selectedRow, 0));
			StringBuilder address1 = new StringBuilder();
			address1
			.append(jt.getValueAt(selectedRow, 1)).append(" ")
			.append(jt.getValueAt(selectedRow, 2)).append(" ")
			.append(jt.getValueAt(selectedRow, 3)).append(" ")
			.append(jt.getValueAt(selectedRow, 4));
			suv.getJtfAddress1().setText(address1.toString());
			
			sav.dispose();
		}
		
		if (e.getSource() == sav.getJbCancel()) {
			sav.dispose();
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		sav.dispose();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
