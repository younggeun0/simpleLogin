package simpleLogin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import simpleLogin.view.SignUpView;

public class SignUpController extends WindowAdapter implements ActionListener {

	private SignUpView suv;
	
	public SignUpController(SignUpView suv) {
		this.suv = suv;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		suv.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
