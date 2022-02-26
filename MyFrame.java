import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.Font;

public class MyFrame extends JFrame implements ActionListener {

	// Variables
	private static final long serialVersionUID = 1L;
	JButton submitbutton;
	JButton display;
	JButton save;
	JButton load;
	JButton submit;
	JComboBox<Integer> quanity;
	JTextField itemname;
	JTextField price;
	JTextArea output;
	String listString;
	ArrayList<Item> cart1 = new ArrayList<Item>(); // Create a new ArrayList of my classobject Item
	Item firstitem = new Item(); 					// Creation of the first item object. used to grab info, then store it all into
													// the cart array
	int count = 0; 									// The Count of the number of objects in the cart
	double submitedMoney;
	JTextPane textPane;
	JTextArea txtHowMuchMoney;
	JTextField moneyAmount;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	private JTextArea txtZacharyHudsonPerry;

	// Constructor of my JFRAME
	// Intialize my Jpanel and all of its attributes/ sizes
	MyFrame() {
		setAlwaysOnTop(true);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		submitbutton = new JButton("Add");
		submitbutton.addActionListener(this);

		display = new JButton("Display Current List");
		display.addActionListener(this);

		save = new JButton("Save Current List");
		save.addActionListener(this);

		load = new JButton("Load Saved List");
		load.addActionListener(this);

		itemname = new JTextField("Item");
		itemname.setPreferredSize(new Dimension(100, 40));
		itemname.setToolTipText("Input your shopping item name");

		quanity = new JComboBox<Integer>();
		for (Integer i = 1; i < 50; i++) {
			quanity.addItem(i);
		}

		price = new JTextField("Price");
		price.setPreferredSize(new Dimension(70, 40));
		price.setToolTipText("Enter the price here");
		

		output = new JTextArea();
		output.setPreferredSize(new Dimension(300, 400));
		output.setEditable(false);

		JTextArea txtrItemname = new JTextArea();
		txtrItemname.setBackground(Color.LIGHT_GRAY);
		txtrItemname.setText("Item Name:");
		txtrItemname.setEditable(false);

		JTextPane txtpnQuanity = new JTextPane();
		txtpnQuanity.setBackground(Color.LIGHT_GRAY);
		txtpnQuanity.setEditable(false);
		txtpnQuanity.setText("Quanity:");

		JTextPane txtpnPrice = new JTextPane();
		txtpnPrice.setBackground(Color.LIGHT_GRAY);
		txtpnPrice.setEditable(false);
		txtpnPrice.setText("Price:");

		textPane = new JTextPane();
		textPane.setText("$");
		textPane.setBackground(Color.LIGHT_GRAY);

		submit = new JButton("Submit $ Amount");
		submit.addActionListener(this);

		txtHowMuchMoney = new JTextArea();
		txtHowMuchMoney.setForeground(Color.BLACK);
		txtHowMuchMoney.setEditable(false);
		txtHowMuchMoney.setBackground(Color.LIGHT_GRAY);
		txtHowMuchMoney.setText("How much money are you starting with?");
		txtHowMuchMoney.setColumns(10);

		moneyAmount = new JTextField();
		moneyAmount.setColumns(10);
		
		txtZacharyHudsonPerry = new JTextArea();
		txtZacharyHudsonPerry.setEditable(false);
		txtZacharyHudsonPerry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtZacharyHudsonPerry.setBackground(Color.LIGHT_GRAY);
		txtZacharyHudsonPerry.setText("Zachary Hudson Perry (2022)");
		txtZacharyHudsonPerry.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtrItemname, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(txtpnQuanity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(txtpnPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(itemname, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
								.addComponent(quanity, Alignment.LEADING, 0, 195, Short.MAX_VALUE)
								.addComponent(price, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
							.addGap(57))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(display, Alignment.LEADING)
								.addComponent(txtZacharyHudsonPerry, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(submitbutton)
							.addGap(6)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(output, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtHowMuchMoney)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(load)
									.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
									.addComponent(save))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(moneyAmount, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(submit)))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(output, 0, 0, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtZacharyHudsonPerry, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addGap(157)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(display)
										.addComponent(submitbutton)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtHowMuchMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(13)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(moneyAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(submit))
									.addGap(3))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtrItemname, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(itemname, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(price, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtpnQuanity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(quanity, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(224)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(252, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(save)
						.addComponent(load))
					.addGap(103))
		);
		getContentPane().setLayout(groupLayout);
		this.pack();
		this.setVisible(true);
		this.setTitle("Shopping Application");
		output.setText("Please start by adding how much money you have to go shopping with! \n "
				+ "This is done on the right side of the application window\n");

	}

	// All of my AcitonListeners

	public void actionPerformed(ActionEvent e) {

		// When Submit button is pressed
		if (e.getSource() == submitbutton) {

			try {

				// if submitted get all info from field and store it in the array

				Item firstitem = new Item(); 							// Create new instance of my item class
				firstitem.setItemname(itemname.getText()); 				// Set new item's name
				firstitem.setPrice(Double.parseDouble(price.getText())); // Set new item's price
				firstitem.setQuanity(quanity.getSelectedIndex() + 1); 	// Set new item's Quanity
			

				cart1.add(firstitem); // Add to ArrayList
				count++;

				// Then Display current list plus newly added item

				double total = 0;

				String str = "Current List: \n_________________\n";
				str += " " + cart1.toString(); // Create a new string, then take my arraylist of objects and invoke my
												// tostring method on it
				str = str.replaceAll("[\\[\\],]", ""); // then replace all of the characters i don't want with blank
														// space

				for (int i = 0; i < cart1.size(); i++) {
					total += cart1.get(i).price * cart1.get(i).quanity; //

				}
				
				double MoneyLeft = submitedMoney - total;

				str += "\n\n_________________\n Started with $" + df.format(submitedMoney) + "\n Total Bill: $ " + df.format(total)  + "\n_________________" + "\n Money Left:" + df.format(MoneyLeft);

				output.setText(str);

				// if any of fields are entered incorrectly
			} catch (Exception ex) {
				output.setText("One or more fields were enetered incorrecrtly! \n Please Try Again");

			}

		}
		// When display button is pressed display to my JTextArea
		if (e.getSource() == display) {

			double total = 0;

			String str = "Current List: \n";
			str += " " + cart1.toString(); // Create a new string, then take my arraylist of objects and invoke my
											// tostring method on it
			str = str.replaceAll("[\\[\\],]", ""); // then replace all of the characters i don't want with blank space

			for (int i = 0; i < cart1.size(); i++) {
				total += cart1.get(i).price * cart1.get(i).quanity; //

			}

			double MoneyLeft = submitedMoney - total;

			str += "\n\n_________________\n Started with: $" + df.format(submitedMoney) + "\n Total Bill:      $" + df.format(total)  + "\n_________________" + "\n Money Left:  $" + df.format(MoneyLeft);


			output.setText(str); // Finally display the current arraylist(turned to string) to my JTextArea
		}

		// When save button is pressed create a new file stream and write to file
		if (e.getSource() == save) {

			try {
				// Create a new string, then take my arraylist of objects and invoke my tostring
				// method on it
				// then replace all of the characters i don't want with blank space
				// Finally, write that string to the file "ShoppingList.txt"
				double total = 0;
				for (int i = 0; i < cart1.size(); i++) {
					total += cart1.get(i).price * cart1.get(i).quanity; //

				}

				String str = cart1.toString();
				double MoneyLeft = submitedMoney - total;

				str += "\n\n_________________\n Started with: $" + df.format(submitedMoney) + "\n Total Bill:      $" + df.format(total)  + "\n_________________" + "\n Money Left:  $" + df.format(MoneyLeft);
				str = str.replaceAll("[\\[\\],]", "");

				File Shoppinglist = new File("ShoppingList.txt");
				PrintStream writer = null;
				try {
					writer = new PrintStream(Shoppinglist);
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				}
				writer.println(str);
			} catch (Exception ex) {
				System.out.println("Error writting to file!");
			}
		}

		// When the load button is pressed, load contents of file
		if (e.getSource() == load) {

			try {

				File myObj = new File("ShoppingList.txt");		// Load file
				Scanner myReader = new Scanner(myObj); 			// create new reader
				String data = "Loaded file contents: \n\n "; 	// create new string and intialize it "Loaded file
																// contents"

				while (myReader.hasNextLine()) {

					data += myReader.nextLine() + "\n"; 		// read nextfile line while it exists and appended it string
																// Set JTextArea to the string i created and appended to
				}
				output.setText(data);
				myReader.close();

			} catch (FileNotFoundException ee) {

				System.out.println("An error occurred.");
				ee.printStackTrace();
			}
		}
		if (e.getSource() == submit) {

			try {

				submitedMoney = Double.parseDouble(moneyAmount.getText()); // Get the entered amount

				System.out.println("test!");							   //Disable the buttons
				System.out.println(submitedMoney);

				submit.setEnabled(false);
				moneyAmount.setEnabled(false);
				
				output.setText("You are starting shopping with $" + df.format(submitedMoney) + "\n"
				+"Please add items to the list!\n"
				+ "This can be done on the left side of the application window");
			} catch (Exception exx) {
				output.setText("One or more fields were enetered incorrecrtly! \n Please Try Again");

			}

		}

	}
}
