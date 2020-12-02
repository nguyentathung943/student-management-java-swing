package menu.TeacherInterface;

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

import menu.Server;

import java.sql.*;

public class TeacherMenu extends JFrame implements ActionListener{
	JButton info;
	JButton ShowCourses;
	JButton pass;
	JButton schedule;
	JPanel contentPane;
	JPanel container;
	Container mainUI;
	private final JLabel lblX = new JLabel("X");
	private final JButton lblBack = new JButton("");
	  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherMenu frame = new TeacherMenu(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TeacherMenu(ResultSet Client, Server ServerConnection) throws SQLException {
		setUndecorated(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(new CardLayout());
		setContentPane(contentPane);
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(1200, 800);
		setLocationRelativeTo(null);
		mainUI = new Container();
		mainUI.setLayout(null);
		contentPane.add("MainUI", mainUI);
		
		lblBack.setIcon(new ImageIcon(TeacherMenu.class.getResource("/icon/back.png")));
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
					TeacherMenu.this.dispose();
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
		mainUI.add(lblX);
		mainUI.add(lblBack);
		
		
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
		mainUI.add(panel);
		mainUI.add(container);
		
		JLabel greeting = new JLabel("Ch�o, "+ Client.getString("name"));
		panel.add(greeting);
		greeting.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		greeting.setForeground(SystemColor.textHighlightText);
		greeting.setVerticalAlignment(JLabel.BOTTOM);
		greeting.setHorizontalAlignment(JLabel.LEFT);
		
		
		
		info = new JButton("Edit Information");
		info.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		info.setIcon(new ImageIcon(TeacherMenu.class.getResource("/icon/folder.png")));
		info.setHorizontalTextPosition(JLabel.CENTER);
		info.setVerticalTextPosition(JLabel.BOTTOM);
		info.setVerticalAlignment(JLabel.CENTER);
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setBounds(450,100,150,100);
		info.setBackground(new Color(191,205,219));
		info.setFocusable(false);
		info.setBorder(null);
		info.addActionListener(this);
		
		ShowCourses = new JButton("Courses Management");
		ShowCourses.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		ShowCourses.setIcon(new ImageIcon(TeacherMenu.class.getResource("/icon/tick.png")));
		ShowCourses.setHorizontalTextPosition(JLabel.CENTER);
		ShowCourses.setVerticalTextPosition(JLabel.BOTTOM);
		ShowCourses.setVerticalAlignment(JLabel.CENTER);
		ShowCourses.setHorizontalAlignment(JLabel.CENTER);
		ShowCourses.setBounds(600,100,150,100);
		ShowCourses.setBackground(new Color(191,205,219));
		ShowCourses.setFocusable(false);
		ShowCourses.setBorder(null);
		ShowCourses.addActionListener(this);
		
		schedule = new JButton("Show Teaching Schedule");
		schedule.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		schedule.setIcon(new ImageIcon(TeacherMenu.class.getResource("/icon/calendar.png")));
		schedule.setHorizontalTextPosition(JLabel.CENTER);
		schedule.setVerticalTextPosition(JLabel.BOTTOM);
		schedule.setVerticalAlignment(JLabel.CENTER);
		schedule.setHorizontalAlignment(JLabel.CENTER);
		schedule.setBounds(450,200,150,100);
		schedule.setBackground(new Color(191,205,219));
		schedule.setFocusable(false);
		schedule.setBorder(null);
		schedule.addActionListener(this);
		
		pass = new JButton("Change password");
		pass.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		pass.setIcon(new ImageIcon(TeacherMenu.class.getResource("/icon/cogwheel.png")));
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
				CardLayout cl1 = (CardLayout)(container.getLayout());
				cl1.show(container, "Pass");
				lblBack.setVisible(true);
			}
		});		
		lblBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl1 = (CardLayout)(container.getLayout());
				cl1.show(container, "MainMenu");
				lblBack.setVisible(false);
			}
		});
		content.add(info);
		content.add(ShowCourses);
		content.add(schedule);
		content.add(pass);
		String ClientID = Client.getString("id");
		Container InfoForm = new TeacherInfo(Client,ServerConnection);
		Container CoursesForm = new ShowCourses(ClientID,ServerConnection);
		Container Schedule = new ShowTeachingSchedule(ClientID,contentPane,ServerConnection);
		Container ClassManage = new ClassManagement(ServerConnection);
        container.add("Info",InfoForm);
        container.add("Courses",CoursesForm);
        container.add("Schedule",Schedule);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == info) {
			CardLayout cl = (CardLayout)(container.getLayout());
			cl.show(container, "Info");
			lblBack.setVisible(true);
		}
		else if(e.getSource() == ShowCourses) {
			CardLayout cl = (CardLayout)(container.getLayout());
			cl.show(container, "Courses");
			lblBack.setVisible(true);
		}else if(e.getSource()==schedule) {
			CardLayout cl = (CardLayout)(container.getLayout());
			cl.show(container, "Schedule");
			lblBack.setVisible(true);
		}
	}
}
