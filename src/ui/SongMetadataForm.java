package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SongMetadataForm extends JPanel {
	private final DefaultTableModel trackModel = new DefaultTableModel(
			new Object[]{"Disc", "Track", "Title", "Artists (comma separated)"}, 0
	);
	final JTable trackTable = new JTable(trackModel);

	public SongMetadataForm(LayoutManager layoutManager) {
		super(layoutManager);
		add(new JScrollPane(trackTable), BorderLayout.CENTER);
	}
}
