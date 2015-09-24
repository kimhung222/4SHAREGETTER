import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class demo extends JFrame {
	JButton button;
	JTextField textfield;
	JTextArea textarea;
	
demo(){
	JPanel pane = new JPanel();
	pane.setSize(200,200);
	FlowLayout layout = new FlowLayout();
	layout.setAlignment(FlowLayout.CENTER);
	pane.setLayout(layout);
    textfield = new JTextField();
    textfield.setMinimumSize(new Dimension(20,20));
    System.out.println(textfield.getAlignmentX() +" " +textfield.getAlignmentY());
    pane.add(textfield);
	//Box box;
	Box box = Box.createVerticalBox();
	box.add(pane);
	button = new JButton("GENERATE");
	box.add(button);
	textarea = new JTextArea(10,15);
	box.add(new JScrollPane(textarea));
	add(box);
}
public static void main(String[] args){
	demo demo1 = new demo();
	demo1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	demo1.setVisible(true);
	demo1.setSize(200, 425);
}
}

