package ui;

import data.ReleaseType;

import javax.swing.*;
import java.awt.*;

public class AlbumMetadataForm extends JPanel {
	final JLabel nameLabel = new JLabel("Album name:");
	final JTextField nameField = new JTextField(20);
	final JLabel artistLabel = new JLabel("Album artist:");
	final JTextField artistField = new JTextField(20);
	final JLabel genreLabel = new JLabel("Album genre:");
	final JTextField genreField = new JTextField(20);
	final JLabel typeLabel = new JLabel("Release type:");
	final JComboBox<ReleaseType> typeBox = new JComboBox<>(ReleaseType.values());
	final JLabel releaseDateLabel = new JLabel("Release date:");
	final JTextField releaseDateField = new JTextField(20);

	private final JPanel coverPanel = new JPanel();
	private final JButton setCoverButton = new JButton("Set cover...");
	private final JButton clearCoverButton = new JButton("Clear cover");

	public AlbumMetadataForm(LayoutManager layoutManager) {
		super(layoutManager);
		add(buildCoverPane(), BorderLayout.WEST);
		add(buildFieldsPane(), BorderLayout.CENTER);
	}

	private JPanel buildCoverPane() {
		JPanel pane = new JPanel(new BorderLayout(4, 4));
		JPanel buttons = new JPanel(new GridLayout(1, 2, 4, 4));
		buttons.add(setCoverButton);
		buttons.add(clearCoverButton);
		pane.add(coverPanel, BorderLayout.CENTER);
		pane.add(buttons, BorderLayout.SOUTH);
		return pane;
	}

	private JPanel buildFieldsPane() {
		JPanel pane = new JPanel(new GridLayout(0, 2, 4, 4));
		pane.add(nameLabel);
		pane.add(nameField);
		pane.add(artistLabel);
		pane.add(artistField);
		pane.add(genreLabel);
		pane.add(genreField);
		pane.add(typeLabel);
		pane.add(typeBox);
		pane.add(releaseDateLabel);
		pane.add(releaseDateField);

		// Keep rows at their natural height instead of stretching them.
		JPanel wrapper = new JPanel(new BorderLayout());
		wrapper.add(pane, BorderLayout.NORTH);
		return wrapper;
	}
}
