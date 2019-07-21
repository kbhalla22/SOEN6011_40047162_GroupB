package Calculator_package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator frame = new calculator();
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
	public calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(5, 5, 440, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton C = new JButton("1");
		C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		C.setBounds(5, 48, 64, 52);
		contentPane.add(C);
		
		JButton two = new JButton("2");
		two.setBounds(91, 48, 64, 52);
		contentPane.add(two);
		
		JButton Three = new JButton("3");
		Three.setBounds(181, 48, 64, 52);
		contentPane.add(Three);
		
		JButton add = new JButton("+");
		add.setBounds(275, 48, 64, 52);
		contentPane.add(add);
		
		JButton subtract = new JButton("-");
		subtract.setBounds(363, 48, 64, 52);
		contentPane.add(subtract);
		
		JButton four = new JButton("4");
		four.setBounds(5, 100, 64, 52);
		contentPane.add(four);
		
		JButton five = new JButton("5");
		five.setBounds(91, 100, 64, 52);
		contentPane.add(five);
		
		JButton six = new JButton("6");
		six.setBounds(181, 100, 64, 52);
		contentPane.add(six);
		
		JButton multiply = new JButton("*");
		multiply.setBounds(275, 100, 64, 52);
		contentPane.add(multiply);
		
		JButton divide = new JButton("/");
		divide.setBounds(363, 100, 64, 52);
		contentPane.add(divide);
		
		JButton seven = new JButton("7");
		seven.setBounds(5, 154, 64, 52);
		contentPane.add(seven);
		
		JButton eight = new JButton("8");
		eight.setBounds(91, 154, 64, 52);
		contentPane.add(eight);
		
		JButton nine = new JButton("9");
		nine.setBounds(181, 154, 64, 52);
		contentPane.add(nine);
		
		JButton tan = new JButton("tan");
		tan.setBounds(275, 154, 64, 52);
		contentPane.add(tan);
		
		JButton button_13 = new JButton("New button");
		button_13.setBounds(363, 154, 64, 52);
		contentPane.add(button_13);
		
		JButton button = new JButton("New button");
		button.setBounds(91, 206, 64, 52);
		contentPane.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(181, 206, 64, 52);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(275, 206, 64, 52);
		contentPane.add(button_2);
	}
}
