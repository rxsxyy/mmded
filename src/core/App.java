package core;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
	public App() {
		super("mmded");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new BorderLayout());

		setContentPane(panel);
	}

	public void display() {
		setVisible(true);
	}
}
