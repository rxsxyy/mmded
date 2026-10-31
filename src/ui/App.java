package ui;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
	final JPanel panel = new JPanel(new BorderLayout(8, 8));

	public App() throws HeadlessException {
		super("mmded");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 800);
		setLocationRelativeTo(null);

		setJMenuBar(buildMenuBar());

		panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

		panel.add(new AlbumMetadataForm(new GridLayout(0, 2, 4, 4)), BorderLayout.NORTH);
		panel.add(new SongMetadataForm(new BorderLayout(4,4)), BorderLayout.CENTER);
		setContentPane(panel);
	}

	private JMenuBar buildMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		fileMenu.add(new JMenuItem("Open"));
		fileMenu.add(new JMenuItem("Close"));
		fileMenu.add(new JMenuItem("Save"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("Exit"));

		JMenu aboutMenu = new JMenu("About");
		aboutMenu.setMnemonic('A');

		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		return menuBar;
	}

	public void display() {
		setVisible(true);
	}
}
