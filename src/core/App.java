package core;

import javax.swing.*;

public class App extends JFrame {
	LibraryPanel panel = new LibraryPanel();

	public App() {
		super("mmded");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		setLocationRelativeTo(null);

		setContentPane(panel);
	}

	public void display() {
		setVisible(true);
	}
}