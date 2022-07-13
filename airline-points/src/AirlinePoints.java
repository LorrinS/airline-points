/* Airline Points
* @modified 20220617
* @date 20220617
* @author Siraj Ali
* @editor Lorrin Shen
* @version 1.0
* @See ICS4U1
* 
* A program to store names and associated points to determine
* which person is available for bonus points.
**/

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class AirlinePoints extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtWeek1;
	private JTextField txtWeek2;
	private JTextField txtWeek3;
	private JTextField txtWeek4;
	private ImageIcon leftPlane = new ImageIcon("plane1.jpg");
	private ImageIcon rightPlane = new ImageIcon("plane2.jpg");
	private JTextArea textArea = new JTextArea();
	private JLabel lblError = new JLabel();
	private List<String> names = new ArrayList<>();
	private List<Integer> week1Pts = new ArrayList<>();
	private List<Integer> week2Pts = new ArrayList<>();
	private List<Integer> week3Pts = new ArrayList<>();
	private List<Integer> week4Pts = new ArrayList<>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AirlinePoints frame = new AirlinePoints();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public boolean strCheck(String test) {
		
		for(int i = 0;i < test.length(); i++) {
			if (!Character.isLetter(test.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean intCheck(String x) {
		int numCheck = 0;
		
		try {
			numCheck = Integer.parseInt(x);
		}
		
		catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public void btnAdd() {
		String output = "";
		String name = "";
		String week1 = txtWeek1.getText();
		String week2 = txtWeek2.getText();
		String week3 = txtWeek3.getText();
		String week4 = txtWeek4.getText();
		
		if (strCheck(txtFirstname.getText()) && strCheck(txtLastname.getText())) {
			name = txtFirstname.getText().replaceAll(" ", "") + " " + txtLastname.getText().replaceAll(" ", "");
			if (txtFirstname.getText().length() > 0 && txtLastname.getText().length() > 0) {
				if (!names.contains(name)) {
					if (intCheck(week1) && intCheck(week2) && intCheck(week3) && intCheck(week4)) {
						if (Integer.parseInt(txtWeek1.getText()) >= 0 || Integer.parseInt(txtWeek2.getText()) >= 0 || Integer.parseInt(txtWeek3.getText()) >= 0 || Integer.parseInt(txtWeek1.getText()) >= 0) {
							names.add(name);
							week1Pts.add(Integer.parseInt(txtWeek1.getText()));
							week2Pts.add(Integer.parseInt(txtWeek2.getText()));
							week3Pts.add(Integer.parseInt(txtWeek3.getText()));
							week4Pts.add(Integer.parseInt(txtWeek4.getText()));
						}
						else {
							lblError.setText("Error. Minimum points is 0.");
						}
					}
					
					else {
						lblError.setText("Error. Points must be integer values.");
					}
				}
				
				else {
					lblError.setText("Error. Name is already inputted.");
				}
			}
			
			else {
				lblError.setText("Error. Name field is empty.");
			}

			}
		
		else {
			lblError.setText("Error.");
		}
		
		textArea.setText("");
		
		if (names.size() > 0) {
			for (int i = 0; i < names.size(); i++) {
				output = names.get(i) + ": " + week1Pts.get(i) + " " + week2Pts.get(i) + " " +  week3Pts.get(i) + " " + week4Pts.get(i) + "\n";
				textArea.append(output);
			}
		}
		
		
	}
	
	public void btnTotalPoints() {
		String name = "";
		int index = 0;
		int totalPts = 0;
		if (strCheck(txtFirstname.getText()) && strCheck(txtLastname.getText())) {
			name = txtFirstname.getText().replaceAll(" ", "") + " " + txtLastname.getText().replaceAll(" ", "");
			if (txtFirstname.getText().length() > 0 && txtLastname.getText().length() > 0) {
				if (names.contains(name)) {
					if (names.size() > 0) {
						index = names.indexOf(name);
						totalPts = week1Pts.get(index) + week2Pts.get(index) + week3Pts.get(index) + week4Pts.get(index);
						if (totalPts >= 5000) {
							lblError.setText("This customer has: " + totalPts + " pts + bonus 1000 pts = " + (totalPts+1000) + " pts.");
						}
					
						else {
							lblError.setText("This customer has: " + totalPts + " pts.");
						}
					}
				}
				
				
				else {
					lblError.setText("Error. Name is already inputted.");
				}
			}
			
			else {
				lblError.setText("Error. Name field(s) cannot be empty.");
			}

			}
		
		else {
			lblError.setText("Error. Name contains illegal characters.");
		}
	}
	
	public AirlinePoints() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAirlinePoints = new JLabel("Airline Points");
		lblAirlinePoints.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAirlinePoints.setBounds(167, 11, 131, 32);
		contentPane.add(lblAirlinePoints);
		
		JLabel lblImg = new JLabel(leftPlane);
		lblImg.setBounds(10, 11, 147, 85);
		contentPane.add(lblImg);
		
		JLabel lblImg_1 = new JLabel(rightPlane);
		lblImg_1.setBounds(272, 11, 135, 85);
		contentPane.add(lblImg_1);
		
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setBounds(10, 107, 69, 14);
		contentPane.add(lblFirstName);
		
		txtFirstname = new JTextField();
		txtFirstname.setBounds(91, 104, 86, 20);
		contentPane.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setBounds(228, 107, 69, 14);
		contentPane.add(lblLastName);
		
		txtLastname = new JTextField();
		txtLastname.setBounds(321, 104, 86, 20);
		contentPane.add(txtLastname);
		txtLastname.setColumns(10);
		
		JLabel lblWeek1 = new JLabel("Week 1: ");
		lblWeek1.setBounds(10, 189, 69, 14);
		contentPane.add(lblWeek1);
		
		txtWeek1 = new JTextField();
		txtWeek1.setBounds(91, 186, 86, 20);
		contentPane.add(txtWeek1);
		txtWeek1.setColumns(10);
		
		JLabel lblWeek2 = new JLabel("Week 2: ");
		lblWeek2.setBounds(10, 229, 69, 14);
		contentPane.add(lblWeek2);
		
		txtWeek2 = new JTextField();
		txtWeek2.setBounds(91, 226, 86, 20);
		contentPane.add(txtWeek2);
		txtWeek2.setColumns(10);
		
		JLabel lblWeek3 = new JLabel("Week 3: ");
		lblWeek3.setBounds(10, 271, 69, 14);
		contentPane.add(lblWeek3);
		
		txtWeek3 = new JTextField();
		txtWeek3.setBounds(91, 268, 86, 20);
		contentPane.add(txtWeek3);
		txtWeek3.setColumns(10);
		
		JLabel lblWeek4 = new JLabel("Week 4: ");
		lblWeek4.setBounds(10, 310, 69, 14);
		contentPane.add(lblWeek4);
		
		txtWeek4 = new JTextField();
		txtWeek4.setBounds(91, 307, 86, 20);
		contentPane.add(txtWeek4);
		txtWeek4.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 353, 167, 23);
		contentPane.add(btnAdd);
		
		JButton btnTotalPoints = new JButton("Total Points");
		btnTotalPoints.setBounds(10, 387, 167, 23);
		contentPane.add(btnTotalPoints);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(10, 421, 167, 23);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 184, 220, 291);
		contentPane.add(scrollPane);
		textArea.setEditable(false);
	
		scrollPane.setViewportView(textArea);
		
		lblError.setBounds(10, 164, 414, 14);
		contentPane.add(lblError);
		
		btnAdd.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAdd();
			}
		});
	
		btnTotalPoints.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTotalPoints();
			}
		});
	
		btnExit.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});

	}
}
	
