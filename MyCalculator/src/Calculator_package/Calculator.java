package Calculator_package;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Calculator extends JFrame {
	/**
	 * Code to launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Variable to initialize and set up the content pane.
	 */
	private JPanel contentPane;
	/**
	 * Textfield declared where input, output & error messages are displayed.
	 */
	private JTextField textDisplay;
	/**
	 * double: first number input by the user answer: final answer returned to the
	 * user
	 */
	double number1;
	double answer;

	/**
	 * Integer variables used for switch cases.
	 */
	int calculation;

	/**
	 * ArrayList to store error messages.
	 */
	List<String> errorMessageList = new ArrayList<String>();

	/**
	 * Method that handles all the operations(functionalities) using switch case
	 * 
	 * @param calculation: The integer value assigned to each operation.
	 * @param number1: The first number entered by the user.
	 */
	public void arithmeticOperations(int calculation, double number1) {
		switch (calculation) {
		case 1:
			// Switch case for addition operation
			if (textDisplay.getText().isEmpty()) {
				// error message stored as a string
				String error = "Please enter a number to add";
				textDisplay.setText(error);
			} else {
				answer = add(number1, Double.parseDouble(textDisplay.getText()));
				textDisplay.setText(Double.toString(answer));
			}
			break;
		case 2:
			// Switch case for subtraction operation
			if (textDisplay.getText().isEmpty()) {
				// error message stored as a string
				String error = "Please enter a number to subtract";
				textDisplay.setText(error);
			} else {
				answer = subtract(number1, Double.parseDouble(textDisplay.getText()));
				textDisplay.setText(Double.toString(answer));
			}
			break;
		case 3:
			// Switch case for multiplication operation
			if (textDisplay.getText().isEmpty()) {
				// error message stored as a string
				String error = "Please enter a number to multiply";
				textDisplay.setText(error);
			} else {
				answer = multiply(number1, Double.parseDouble(textDisplay.getText()));
				textDisplay.setText(Double.toString(answer));
			}
			break;
		case 4:
			// Switch case for division operation
			if (textDisplay.getText().isEmpty()) {
				// error message stored as a string
				String error = "Please enter a number to divide";
				textDisplay.setText(error);

			} else {
				answer = divide(number1, Double.parseDouble(textDisplay.getText()), errorMessageList);
				if (answer == 1234567) {
					textDisplay.setText("Please enter a number other than 0");
				} else {
					textDisplay.setText(Double.toString(answer));
				}
			}
			break;
		case 5:
			// Switch case for Tan operation
			answer = calculateTan(number1);
			textDisplay.setText(Double.toString(answer));
		}
	}

	/**
	 * Method to execute the divide operation
	 * 
	 * @param number2: First argument(number) for the divide operation
	 * @param parsedNumber: The second number parsed from the input text field.
	 * @param al1: ArrayList used for storing error messages.
	 * @return the final answer after performing divison.
	 */
	public double divide(double number2, double parsedNumber, List<String> al1) {
		// used as a flag variable
		double karry = 0;
		if (parsedNumber == 0) {
			String error1 = "Please enter a number other than 0";
			al1.add(error1);
			karry = 1234567;

		} else {
			karry = number2 / parsedNumber;
		}
		return karry;
	}

	/**
	 * Method to execute the multiply operation
	 * 
	 * @param numb2: First number entered by the user for multiply operation.
	 * @param parseDouble: The second number parsed from the input text field.
	 * @return the final answer after multiplying 2 numbers.
	 */
	public double multiply(double numb2, double parseDouble) {
		return numb2 * parseDouble;
	}

	/**
	 * Method to execute the subtract operation
	 * 
	 * @param numb2: First number entered by the user for subtraction operation.
	 * @param parseDouble: The second number parsed from the input text field.
	 * @return the final answer after subtracting 2 numbers.
	 */
	public double subtract(double numb2, double parseDouble) {
		return numb2 - parseDouble;
	}

	/**
	 * Method to execute the add operation
	 * 
	 * @param numb2:First number entered by the user for add operation.
	 * @param parseDouble: The second number parsed from the input text field.
	 * @return the final answer after adding 2 numbers
	 */
	public double add(double numb2, double parseDouble) {
		// TODO Auto-generated method stub
		return numb2 + parseDouble;
	}

	/**
	 * Method to calculate tan of a number
	 * 
	 * @param inputTan: the value input by the user for which tan is calculated.
	 * @return the value of tan in radians
	 */
	public static double calculateTan(double inputTan) {

		// convert x to an angle between -2 PI and 2 PI
		inputTan = inputTan % (2 * Math.PI);

		// compute the Taylor series approximation for sin(x)
		double term = 1.0; // ith term = x^i / i!
		double sum = 0.0; // sum of first i terms in taylor series

		for (int i = 1; term != 0.0; i++) {
			term *= (inputTan / i);
			if (i % 4 == 1)
				sum += term;
			if (i % 4 == 3)
				sum -= term;
		}
		// calculate the square of sin(x)
		double square = sum * sum;
		// subtract it from 1
		double diff = 1 - square;
		// calculate its square root
		double sqrtResult = sqrt(diff);

		double finalAnswer = sum / sqrtResult;
		return finalAnswer;

	}

	/**
	 * Method to calculate the square root
	 * 
	 * @param number: the number 1-sin^2(x)
	 * @return the square root of the number
	 */
	static double sqrt(double number) {
		double t;

		double squareRoot = number / 2;

		do {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
		} while ((t - squareRoot) != 0);

		return squareRoot;
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setResizable(false);
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textDisplay = new JTextField();
		textDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		textDisplay.setBounds(5, 28, 439, 46);
		contentPane.add(textDisplay);
		textDisplay.setColumns(10);

		/**
		 * Jlabel gets updated with the current values on the textfield when any
		 * operation button is pressed.
		 */

		JLabel lbl = new JLabel(" ");
		lbl.setBounds(328, 6, 99, 16);
		contentPane.add(lbl);

		/**
		 * Setting up the button for number 1
		 */

		JButton one = new JButton("1");
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDisplay.setText(textDisplay.getText() + "1");
			}
		});
		one.setBounds(5, 73, 64, 52);
		contentPane.add(one);

		/**
		 * Setting up the button for number 2
		 */

		JButton two = new JButton("2");
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDisplay.setText(textDisplay.getText() + "2");
			}
		});
		two.setBounds(105, 73, 64, 52);
		contentPane.add(two);

		/**
		 * Setting up the button for number 3
		 */

		JButton three = new JButton("3");
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDisplay.setText(textDisplay.getText() + "3");

			}
		});
		three.setBounds(201, 73, 64, 52);
		contentPane.add(three);

		/**
		 * Setting up the button for number 4
		 */

		JButton four = new JButton("4");
		four.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textDisplay.setText(textDisplay.getText() + "4");
			}
		});
		four.setBounds(5, 123, 64, 52);
		contentPane.add(four);

		/**
		 * Setting up the button for number 5
		 */

		JButton five = new JButton("5");
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDisplay.setText(textDisplay.getText() + "5");
			}
		});
		five.setBounds(105, 123, 64, 52);
		contentPane.add(five);

		/**
		 * Setting up the button for number 6
		 */

		JButton six = new JButton("6");
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDisplay.setText(textDisplay.getText() + "6");
			}
		});
		six.setBounds(201, 123, 64, 52);
		contentPane.add(six);

		/**
		 * Setting up the button for number 7
		 */

		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDisplay.setText(textDisplay.getText() + "7");
			}
		});
		seven.setBounds(5, 173, 64, 52);
		contentPane.add(seven);

		/**
		 * Setting up the button for number 8
		 */

		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDisplay.setText(textDisplay.getText() + "8");
			}
		});
		eight.setBounds(105, 173, 64, 52);
		contentPane.add(eight);

		/**
		 * Setting up the button for number 9
		 */

		JButton nine = new JButton("9");
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDisplay.setText(textDisplay.getText() + "9");
			}
		});
		nine.setBounds(201, 173, 64, 52);
		contentPane.add(nine);

		/**
		 * Setting up the button for number 0
		 */

		JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDisplay.setText(textDisplay.getText() + "0");
			}
		});
		zero.setBounds(105, 226, 64, 52);
		contentPane.add(zero);

		/**
		 * Setting up the button for add operation
		 */

		JButton add = new JButton("+");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textDisplay.getText().isEmpty()) {
					// textDisplay shows an error when it is blank and user tries to execute an
					// operation.
					textDisplay.setText("Please Enter a number first");

				} else if (textDisplay.getText().toString().contains("Please")) {
					textDisplay.setText(" Please clear your screen to continue");

					// if textDisplay contains any characters or special characters it displays an
					// error.
				} else if (textDisplay.getText().toString().matches(".*[a-zA-Z?!@#$%^&_().*{}|<>]")) {
					textDisplay.setText(" Please Enter a valid number");
				} else {
					number1 = Double.parseDouble(textDisplay.getText());
					calculation = 1;
					textDisplay.setText("");

					lbl.setText(number1 + "+");
				}
			}
		});
		add.setBounds(292, 123, 64, 52);
		contentPane.add(add);

		/**
		 * Setting up the button for subtract operation
		 */
		JButton subtract = new JButton("-");
		subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textDisplay.getText().isEmpty()) {
					textDisplay.setText(textDisplay.getText() + "-");

				} else if (textDisplay.getText().toString().contains("Please")) {
					textDisplay.setText(" Please clear your screen to continue");
					// if textDisplay contains any characters or special characters it displays an
					// error.
				} else if (textDisplay.getText().toString().matches(".*[a-zA-Z?!@#$%^&_().*{}|<>]")) {
					textDisplay.setText(" Please Enter a valid number");
				} else {

					number1 = Double.parseDouble(textDisplay.getText());
					calculation = 2;
					textDisplay.setText("");

					lbl.setText(number1 + "-");
				}
			}
		});
		subtract.setBounds(380, 123, 64, 52);
		contentPane.add(subtract);
		/**
		 * Setting up the button for multiply operation
		 */
		JButton multiply = new JButton("*");
		multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textDisplay.getText().isEmpty()) {
					// textDisplay shows an error when it is blank and user tries to execute an
					// operation.
					textDisplay.setText("Please Enter a number first");

				} else if (textDisplay.getText().toString().contains("Please")) {
					textDisplay.setText(" Please clear your screen to continue");
					// if textDisplay contains any characters or special characters it displays an
					// error.
				} else if (textDisplay.getText().toString().matches(".*[a-zA-Z?!@#$%^&_().*{}|<>]")) {
					textDisplay.setText(" Please Enter a valid number");
				}

				else {
					number1 = Double.parseDouble(textDisplay.getText());
					calculation = 3;
					textDisplay.setText("");

					lbl.setText(number1 + "*");
				}
			}
		});
		multiply.setBounds(292, 173, 64, 52);
		contentPane.add(multiply);

		/**
		 * Setting up the button for divide operation
		 */
		JButton divide = new JButton("/");
		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textDisplay.getText().isEmpty()) {
					textDisplay.setText("Please Enter a number first");

				} else if (textDisplay.getText().toString().contains("Please")) {
					textDisplay.setText(" Please clear your screen to continue");
					// if textDisplay contains any characters or special characters it displays an
					// error.
				} else if (textDisplay.getText().toString().matches(".*[a-zA-Z?!@#$%^&_().*{}|<>]")) {
					textDisplay.setText(" Please Enter a valid number");
				} else {
					number1 = Double.parseDouble(textDisplay.getText());
					calculation = 4;
					textDisplay.setText("");

					lbl.setText(number1 + "/");
				}
			}
		});
		divide.setBounds(380, 173, 64, 52);
		contentPane.add(divide);
		/**
		 * Setting up the button for tan operation
		 */
		JButton tan = new JButton("tan");
		tan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textDisplay.getText().isEmpty()) {
					textDisplay.setText("Please Enter a number first & then press Tan");
				} else if ((textDisplay.getText().toString().contains("Please"))) {
					textDisplay.setText(" Please clear your screen to continue");
					// if textDisplay contains any characters or special characters it displays an
					// error.
				} else if (textDisplay.getText().toString().matches(".*[a-zA-Z?!@#$%^&_().*{}|<>]")) {
					textDisplay.setText(" Please Enter a valid number");
				} else {
					number1 = Double.parseDouble(textDisplay.getText());
					calculation = 5;
					textDisplay.setText("");

					lbl.setText("Tan(" + number1 + ")");

				}
			}
		});
		tan.setBounds(201, 226, 64, 52);
		contentPane.add(tan);

		/**
		 * Setting up the button for decimal
		 */
		JButton dot = new JButton(".");
		dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDisplay.setText(textDisplay.getText() + ".");
			}
		});
		dot.setBounds(5, 226, 64, 52);
		contentPane.add(dot);

		/**
		 * Seeting up the button & logic for backspace
		 */
		JButton backSpace = new JButton("BackSpace");
		backSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length = textDisplay.getText().length();
				int number = textDisplay.getText().length() - 1;
				String store;

				if (length > 0) {
					StringBuilder back = new StringBuilder(textDisplay.getText());
					back.deleteCharAt(number);
					store = back.toString();
					textDisplay.setText(store);
				}
			}
		});
		backSpace.setBounds(292, 73, 152, 52);
		contentPane.add(backSpace);

		/**
		 * Setting up the button & logic for equals to button.
		 */
		JButton equalsTo = new JButton("=");
		equalsTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textDisplay.getText().toString().contains("Please")) {
					textDisplay.setText(" Please clear your screen to continue");

				} else {

					lbl.setText(" ");
// when this button is pressed, the function arithmeticOperations is called
					arithmeticOperations(calculation, number1);

				}
			}
		});
		equalsTo.setBounds(380, 226, 64, 52);
		contentPane.add(equalsTo);
		/**
		 * Setting up the clear button that clears the text field
		 */
		JButton clear = new JButton("C");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl.setText(" ");
				textDisplay.setText("");

			}
		});
		clear.setBounds(292, 226, 64, 52);
		contentPane.add(clear);

	}
}
