package menu.AdminInterface;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.sql.*;

import menu.ChangePasswordForm;
import menu.Server;
public class AdminMenu extends JFrame implements ActionListener{
	JButton info;
	JButton humanManage;
	JButton courseManage;
	JButton pass;
	JPanel contentPane;
	JPanel container;
	private final JLabel lblX = new JLabel("X");
	private final JButton lblBack = new JButton("");
	  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AdminMenu(ResultSet Client, Server ServerConnection) throws SQLException {
		setUndecorated(true);
		setResizable(false);
		String ClientID = Client.getString("id");
		contentPane = new JPanel();
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLocationRelativeTo(null);
		lblBack.setIcon(new ImageIcon(AdminMenu.class.getResource("/icon/back.png")));
		lblBack.setOpaque(false);
		lblBack.setContentAreaFilled(false);
		lblBack.setBorderPainted(false);
		lblBack.setFocusable(false);
		lblBack.setBounds(5, 0, 55, 55);
		lblBack.setVisible(false);
		
		
		lblX.setForeground(new Color(240, 248, 255));
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblX.setHorizontalTextPosition(SwingConstants.CENTER);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(1150, 0, 55, 53);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to close this application?","CLOSE THE PROGRAM",JOptionPane.YES_NO_OPTION)==0) {
					AdminMenu.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.red);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblX.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.white);
			}
		});
		contentPane.add(lblX);
		contentPane.add(lblBack);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0,0,1200,150);
		panel.setLayout(new BorderLayout());
		
		container = new JPanel(new CardLayout());
		container.setBackground(SystemColor.inactiveCaption);
		container.setBounds(0,150,1200,800-150);
		
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(2,2,10,10));
		content.setBackground(SystemColor.inactiveCaption);
		content.setBounds(400,200,400,400);
		
		container.add("MainMenu", content);
		contentPane.add(panel);
		contentPane.add(container);
		
		JLabel greeting = new JLabel("Ch�o, "+ Client.getString("name"));
		panel.add(greeting);
		greeting.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		greeting.setForeground(SystemColor.textHighlightText);
		greeting.setVerticalAlignment(JLabel.BOTTOM);
		greeting.setHorizontalAlignment(JLabel.LEFT);
		
		
		
		info = new JButton("Edit Information");
		info.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		info.setIcon(new ImageIcon(AdminMenu.class.getResource("/icon/folder.png")));
		info.setHorizontalTextPosition(JLabel.CENTER);
		info.setVerticalTextPosition(JLabel.BOTTOM);
		info.setVerticalAlignment(JLabel.CENTER);
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setBounds(450,100,150,100);
		info.setBackground(new Color(191,205,219));
		info.setFocusable(false);
		info.setBorder(null);
		info.addActionListener(this);
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container InfoForm;
				try {
					InfoForm = new AdminInfo(ClientID, ServerConnection);
					container.add("Info",InfoForm);
					CardLayout cl1 = (CardLayout)(container.getLayout());
					cl1.show(container, "Info");
					lblBack.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		courseManage = new JButton("Courses Management");
		courseManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		courseManage.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		courseManage.setIcon(new ImageIcon(AdminMenu.class.getResource("/icon/tick.png")));
		courseManage.setHorizontalTextPosition(JLabel.CENTER);
		courseManage.setVerticalTextPosition(JLabel.BOTTOM);
		courseManage.setVerticalAlignment(JLabel.CENTER);
		courseManage.setHorizontalAlignment(JLabel.CENTER);
		courseManage.setBounds(600,100,150,100);
		courseManage.setBackground(new Color(191,205,219));
		courseManage.setFocusable(false);
		courseManage.setBorder(null);
		courseManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container CourseForm;
				try {
					CourseForm = new CoursesManagement(ServerConnection);
					container.add("Course", CourseForm);
					CardLayout cl1 = (CardLayout)(container.getLayout());
					cl1.show(container, "Course");
					lblBack.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		humanManage = new JButton("Human Resources Management");
		humanManage.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		humanManage.setIcon(new ImageIcon(AdminMenu.class.getResource("/icon/calendar.png")));
		humanManage.setHorizontalTextPosition(JLabel.CENTER);
		humanManage.setVerticalTextPosition(JLabel.BOTTOM);
		humanManage.setVerticalAlignment(JLabel.CENTER);
		humanManage.setHorizontalAlignment(JLabel.CENTER);
		humanManage.setBounds(450,200,150,100);
		humanManage.setBackground(new Color(191,205,219));
		humanManage.setFocusable(false);
		humanManage.setBorder(null);
		humanManage.addActionListener(this);
		humanManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container HumanForm;
				try {
					HumanForm = new HumanResourceManagement(ServerConnection);
					container.add("HumanManage", HumanForm);
					CardLayout cl1 = (CardLayout)(container.getLayout());
					cl1.show(container, "HumanManage");
					lblBack.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		pass = new JButton("Change password");
		pass.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		pass.setIcon(new ImageIcon(AdminMenu.class.getResource("/icon/cogwheel.png")));
		pass.setHorizontalTextPosition(JLabel.CENTER);
		pass.setVerticalTextPosition(JLabel.BOTTOM);
		pass.setVerticalAlignment(JLabel.CENTER);
		pass.setHorizontalAlignment(JLabel.CENTER);
		pass.setBounds(650,200,150,100);
		pass.setBackground(new Color(191,205,219));
		pass.setFocusable(false);
		pass.setBorder(null);
		pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container changePassword = new ChangePasswordForm(ClientID, ServerConnection);
				container.add("Pass",changePassword);
				CardLayout cl1 = (CardLayout)(container.getLayout());
				cl1.show(container, "Pass");
				lblBack.setVisible(true);
			}
		});
		
		lblBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl1 = (CardLayout)(container.getLayout());
				cl1.show(container, "MainMenu");
				lblBack.setVisible(false);						}		
		});
		content.add(info);
		content.add(courseManage);
		content.add(humanManage);
		content.add(pass);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
