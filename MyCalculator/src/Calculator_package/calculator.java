package Calculator_package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class calculator extends JFrame {

	private JPanel contentPane;
	private JTextField txt_display_1;
	double numb, answer;
	int calculation;

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

	public void arithmetic_operations() {
		switch (calculation) {
		case 1:
			answer = numb + Double.parseDouble(txt_display_1.getText());
			txt_display_1.setText(Double.toString(answer));
			break;
		case 2:
			answer = numb - Double.parseDouble(txt_display_1.getText());
			txt_display_1.setText(Double.toString(answer));
			break;
		case 3:
			answer = numb * Double.parseDouble(txt_display_1.getText());
			txt_display_1.setText(Double.toString(answer));
			break;
		case 4:
			answer = numb / Double.parseDouble(txt_display_1.getText());
			txt_display_1.setText(Double.toString(answer));
			break;
		case 5:
			answer = calculateSin(numb);
			txt_display_1.setText(Double.toString(answer));
		}

	}

	static double calculateSin(double x) {

		// convert x to an angle between -2 PI and 2 PI
		x = x % (2 * Math.PI);

		// compute the Taylor series approximation
		double term = 1.0; // ith term = x^i / i!
		double sum = 0.0; // sum of first i terms in taylor series

		for (int i = 1; term != 0.0; i++) {
			term *= (x / i);
			if (i % 4 == 1)
				sum += term;
			if (i % 4 == 3)
				sum -= term;
		}
		// return sum;
		// double deg ;
		// double deg = sum * Math.PI / 180;
		double square = sum * sum;
		double diff = 1 - square;
		double sqrt_result = sqrt(diff);
		double finalans = sum / sqrt_result;
		return finalans;

	}

	static double sqrt(double number) {
		double t;

		double squareRoot = number / 2;

		do {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
		} while ((t - squareRoot) != 0);
		// double tanx = sum / squareRoot;
		// System.out.println(tanx);
		return squareRoot;
	}

	/**
	 * Create the frame.
	 */
	public calculator() {
		setResizable(false);
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txt_display_1 = new JTextField();
		txt_display_1.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_display_1.setBounds(5, 28, 439, 46);
		contentPane.add(txt_display_1);
		txt_display_1.setColumns(10);

		JButton C = new JButton("1");
		C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_display_1.setText(txt_display_1.getText() + "1");
			}
		});
		C.setBounds(5, 73, 64, 52);
		contentPane.add(C);

		JButton two = new JButton("2");
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_display_1.setText(txt_display_1.getText() + "2");
			}
		});
		two.setBounds(105, 73, 64, 52);
		contentPane.add(two);

		JButton three = new JButton("3");
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_display_1.setText(txt_display_1.getText() + "3");

			}
		});
		three.setBounds(201, 73, 64, 52);
		contentPane.add(three);

		JButton add = new JButton("+");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numb = Double.parseDouble(txt_display_1.getText());
				calculation = 1;
				txt_display_1.setText("");
				JLabel lbl = new JLabel("calci");
				lbl.setBounds(366, 6, 61, 16);
				contentPane.add(lbl);

				lbl.setText(numb + "+");

			}
		});
		add.setBounds(292, 123, 64, 52);
		contentPane.add(add);

		JButton subtract = new JButton("-");
		subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numb = Double.parseDouble(txt_display_1.getText());
				calculation = 2;
				txt_display_1.setText("");
				JLabel lbl = new JLabel("calci");
				lbl.setBounds(366, 6, 61, 16);
				contentPane.add(lbl);

				lbl.setText(numb + "-");
			}
		});
		subtract.setBounds(380, 123, 64, 52);
		contentPane.add(subtract);

		JButton four = new JButton("4");
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_display_1.setText(txt_display_1.getText() + "4");
			}
		});
		four.setBounds(5, 123, 64, 52);
		contentPane.add(four);

		JButton five = new JButton("5");
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_display_1.setText(txt_display_1.getText() + "5");
			}
		});
		five.setBounds(105, 123, 64, 52);
		contentPane.add(five);

		JButton six = new JButton("6");
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_display_1.setText(txt_display_1.getText() + "6");
			}
		});
		six.setBounds(201, 123, 64, 52);
		contentPane.add(six);

		JButton multiply = new JButton("*");
		multiply.setBounds(292, 173, 64, 52);
		contentPane.add(multiply);

		JButton divide = new JButton("/");
		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		divide.setBounds(380, 173, 64, 52);
		contentPane.add(divide);

		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_display_1.setText(txt_display_1.getText() + "7");
			}
		});
		seven.setBounds(5, 173, 64, 52);
		contentPane.add(seven);

		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_display_1.setText(txt_display_1.getText() + "8");
			}
		});
		eight.setBounds(105, 173, 64, 52);
		contentPane.add(eight);

		JButton nine = new JButton("9");
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_display_1.setText(txt_display_1.getText() + "9");
			}
		});
		nine.setBounds(201, 173, 64, 52);
		contentPane.add(nine);

		JButton tan = new JButton("tan");
		tan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numb = Double.parseDouble(txt_display_1.getText());
				calculation = 5;
				txt_display_1.setText("");
				JLabel lbl = new JLabel("calci");
				lbl.setBounds(366, 6, 61, 16);
				contentPane.add(lbl);

				lbl.setText("tan of" + numb);

			}
		});
		tan.setBounds(201, 226, 64, 52);
		contentPane.add(tan);

		JButton button_13 = new JButton(".");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_display_1.setText(txt_display_1.getText() + ".");
			}
		});
		button_13.setBounds(5, 226, 64, 52);
		contentPane.add(button_13);

		JButton backspace = new JButton("BackSpace");
		backspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length = txt_display_1.getText().length();
				int number = txt_display_1.getText().length() - 1;
				String store;

				if (length > 0) {
					StringBuilder back = new StringBuilder(txt_display_1.getText());
					back.deleteCharAt(number);
					store = back.toString();
					txt_display_1.setText(store);
				}
			}
		});
		backspace.setBounds(292, 73, 152, 52);
		contentPane.add(backspace);

		JButton button_1 = new JButton("=");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel lbl = new JLabel("calci");
				lbl.setBounds(366, 6, 61, 16);
				contentPane.add(lbl);

				lbl.setText("");
				arithmetic_operations();

			}
		});
		button_1.setBounds(380, 226, 64, 52);
		contentPane.add(button_1);

		JButton button_2 = new JButton("C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_display_1.setText("");

			}
		});
		button_2.setBounds(292, 226, 64, 52);
		contentPane.add(button_2);

		JButton zero = new JButton("0");
		zero.setBounds(105, 226, 64, 52);
		contentPane.add(zero);

	}
}
