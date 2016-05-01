import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConverterUI extends JFrame {
	private JButton convertButton;
	private UnitConverter unitconverter;
	private JButton clearButton;
	private JTextField inputField1;
	private JTextField inputField2;
	private JComboBox unitBox1;
	private JComboBox unitBox2;
	private Length[] lengthArr;
	private Weight[] weightArr;
	private Area[] areaArr;
	private Time[] timeArr;
	
	private JRadioButton leftRight;
	private JRadioButton rightLeft;
	private boolean isLeftToRight = true;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem lengthMenu;
	private JMenuItem weightMenu;
	private JMenuItem areaMenu;
	private JMenuItem timeMenu;
	

	public ConverterUI (UnitConverter uc) {
		this.unitconverter = uc;
		this.setTitle("Unit Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	private void initComponents() {
		inputField1 = new JTextField(10);
		lengthArr = unitconverter.getLength();
		weightArr = unitconverter.getWeight();
		areaArr = unitconverter.getArea();
		timeArr = unitconverter.getTime();
		unitBox1 = new JComboBox(lengthArr);
		unitBox2 = new JComboBox(lengthArr);
		inputField2 = new JTextField(10);
		inputField2.setEditable(false);
		convertButton = new JButton("Convert!");
		convertButton.addActionListener(new ConvertButtonListener());
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ClearButtonListener());
		leftRight = new JRadioButton("Left->Right", true);
		leftRight.addActionListener(new LeftRightListener());
		rightLeft = new JRadioButton("Right->Left", false);
		rightLeft.addActionListener(new RightLeftListener());
		menuBar = new JMenuBar();
		menu = new JMenu("Units");
		lengthMenu = new JMenuItem("Length");
		weightMenu = new JMenuItem("Weight");
		areaMenu = new JMenuItem("Area");
		timeMenu = new JMenuItem("Time");
		lengthMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				unitBox1.removeAllItems();
				unitBox2.removeAllItems();
				for(int i = 0;i<lengthArr.length;i++) {
					unitBox1.addItem(lengthArr[i]);
					unitBox2.addItem(lengthArr[i]);
				}
			}
		});
		weightMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				unitBox1.removeAllItems();
				unitBox2.removeAllItems();
				for(int i = 0;i<weightArr.length;i++) {
					unitBox1.addItem(weightArr[i]);
					unitBox2.addItem(weightArr[i]);
				}
			}
		});
		areaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				unitBox1.removeAllItems();
				unitBox2.removeAllItems();
				for(int i = 0;i<areaArr.length;i++) {
					unitBox1.addItem(areaArr[i]);
					unitBox2.addItem(areaArr[i]);
				}
			}
		});
		timeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				unitBox1.removeAllItems();
				unitBox2.removeAllItems();
				for(int i = 0;i<timeArr.length;i++) {
					unitBox1.addItem(timeArr[i]);
					unitBox2.addItem(timeArr[i]);
				}
			}
		});
		menu.add(lengthMenu);
		menu.add(weightMenu);
		menu.add(areaMenu);
		menu.add(timeMenu);
		menuBar.add(menu);
		
		//designing JFrame
		JFrame contents = new JFrame();
		contents.setDefaultCloseOperation(EXIT_ON_CLOSE);
		contents.setLayout(new FlowLayout());
		contents.setResizable(false);
		contents.setBounds(0,0,660,130);
		contents.add(inputField1);
		contents.add(unitBox1);
		contents.add(new JLabel("="));
		contents.add(inputField2);
		contents.add(unitBox2);
		contents.add(convertButton);
		contents.add(clearButton);
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(leftRight);
		radioButtonGroup.add(rightLeft);
		contents.add(leftRight);
		contents.add(rightLeft);
		contents.setJMenuBar(menuBar);
		contents.setVisible(true);
		
	}
	class ConvertButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			convert();
		}
	}
	private void convert() {
		String s;
		if (isLeftToRight)
		s = inputField1.getText().trim();
		else
			s = inputField2.getText().trim();	
		if (s.length() > 0) {
			try {
				double value = Double.valueOf(s);
				if (isLeftToRight) {
					double result = unitconverter.convert(value, (Unit)unitBox1.getSelectedItem(), (Unit)unitBox2.getSelectedItem());
					inputField2.setText(result+"");
				} else {
					double result = unitconverter.convert(value, (Unit)unitBox2.getSelectedItem(),  (Unit)unitBox1.getSelectedItem());
					inputField1.setText(result+"");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
		}
	}
	class ClearButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			inputField1.setText("");
			inputField2.setText("");
		}
	}
	class LeftRightListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			convert();
			isLeftToRight = true;
			inputField1.setEditable(true);
			inputField2.setEditable(false);
		}
	}
	class RightLeftListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			convert();
			isLeftToRight = false;
			inputField1.setEditable(false);
			inputField2.setEditable(true);
		}
	}
	
	public static void main(String[] args) {
		ConverterUI run = new ConverterUI(new UnitConverter());
	}
}
