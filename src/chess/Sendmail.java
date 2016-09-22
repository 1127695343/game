package chess;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JScrollBar;

public class Sendmail extends JFrame {
	JTextArea textArea = null;
	String r = null;

	public Sendmail() {
		getContentPane().setFont(new Font("����", Font.BOLD, 14));

		setBounds(new Rectangle(200, 200, 50, 50));
		setSize(400, 400);

		getContentPane().setBackground(SystemColor.control);
		setTitle("\u5927\u81BD\u63D0\u51FA\u4F60\u7684\u60F3\u6CD5");
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(113, 46, 213, 32);
		getContentPane().add(panel);

		JLabel label = new JLabel(
				"\u60A8\u5C0D\u672C\u6E38\u6232\u7684\u6700\u5927\u60F3\u6CD5\u662F\uFF1F\uFF1F\uFF1F");
		panel.add(label);

		/*
		 * ݔ���ı����ݣ��c���l��
		 */

		JButton btnNewButton = new JButton("����");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r = textArea.getText();
				try {
					if (r != null) {
Properties prop = new Properties();
prop.setProperty("mail.transport.protocol", "smtp");
prop.setProperty("mail.smtp.host", "smtp.qq.com");
prop.setProperty("mail.smtp.auth", "true");
prop.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

prop.setProperty("mail.smtp.port", "587");
prop.setProperty("mail.smtp.socketFactory.port", "587");

// ʹ��JavaMail�����ʼ���5������
// 1������session
Session session = Session.getInstance(prop);
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress(1169473174 + "@qq.com"));
message.setRecipient(RecipientType.TO,new InternetAddress("1169473174@qq.com"));
message.setSubject("����˾��һ����");
message.setText(r);
Transport trans = session.getTransport();
session.setDebug(true);
trans.connect("smtp.qq.com", "1169473174","dqpaktkfcgwagabe");// dqpaktkfcgwagabe//ijeocancasdxidge//kiigroypzrtuecfh
trans.sendMessage(message, message.getAllRecipients());
System.out.println("��ϲ�㣬���ͳɹ���");
JOptionPane.showMessageDialog(null,"лл�������յ����Ľ��飬���ǻ���������", "�ʼ����Ϳ�",
								JOptionPane.CLOSED_OPTION);
                           init();
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					}
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(166, 230, 93, 23);
		getContentPane().add(btnNewButton);

		textArea = new JTextArea();
		textArea.setBounds(49, 104, 313, 106);
		getContentPane().add(textArea);

		textArea.setLineWrap(true);

	}

	public void init() {
		this.setVisible(false);
	}
}
