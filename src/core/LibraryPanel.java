package core;

import data.Album;
import data.ReleaseType;
import data.Song;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryPanel extends JPanel {
	private final DefaultListModel<Album> albumModel = new DefaultListModel<>();
	private final JList<Album> albumList = new JList<>(albumModel);

	private final JTextField nameField = new JTextField(20);
	private final JTextField artistField = new JTextField(20);
	private final JTextField genreField = new JTextField(20);
	private final JComboBox<ReleaseType> typeBox = new JComboBox<>(ReleaseType.values());

	private final DefaultTableModel trackModel = new DefaultTableModel(
			new Object[]{"Disc", "Track", "Title", "Artists (comma separated)"}, 0);
	private final JTable trackTable = new JTable(trackModel);

	private Album selected;

	public LibraryPanel() {
		super(new BorderLayout(8, 8));
		setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

		albumList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		albumList.setCellRenderer((list, value, index, isSelected, hasFocus) ->
				new DefaultListCellRenderer().getListCellRendererComponent(
						list, value.getAlbumName(), index, isSelected, hasFocus));
		albumList.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				loadSelected();
			}
		});

		// Left: album list
		JPanel left = new JPanel(new BorderLayout(4, 4));
		left.add(new JScrollPane(albumList), BorderLayout.CENTER);
		JButton newAlbum = new JButton("New Album");
		newAlbum.addActionListener(e -> addAlbum());
		left.add(newAlbum, BorderLayout.SOUTH);
		left.setPreferredSize(new Dimension(220, 0));

		// Right: album metadata form
		JPanel form = new JPanel(new GridLayout(0, 2, 4, 4));
		form.add(new JLabel("Album name:"));
		form.add(nameField);
		form.add(new JLabel("Album artist:"));
		form.add(artistField);
		form.add(new JLabel("Genre:"));
		form.add(genreField);
		form.add(new JLabel("Release type:"));
		form.add(typeBox);

		// Right: track table
		JPanel tracks = new JPanel(new BorderLayout(4, 4));
		tracks.add(new JScrollPane(trackTable), BorderLayout.CENTER);

		JPanel trackButtons = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton addTrack = new JButton("Add Track");
		JButton removeTrack = new JButton("Remove Track");
		addTrack.addActionListener(e -> trackModel.addRow(new Object[]{1, trackModel.getRowCount() + 1, "New Track", ""}));
		removeTrack.addActionListener(e -> {
			int row = trackTable.getSelectedRow();
			if (row >= 0) {
				trackModel.removeRow(trackTable.convertRowIndexToModel(row));
			}
		});
		trackButtons.add(addTrack);
		trackButtons.add(removeTrack);
		tracks.add(trackButtons, BorderLayout.SOUTH);

		JPanel right = new JPanel(new BorderLayout(8, 8));
		right.add(form, BorderLayout.NORTH);
		right.add(tracks, BorderLayout.CENTER);

		JButton save = new JButton("Save Album");
		save.addActionListener(e -> saveSelected());
		right.add(save, BorderLayout.SOUTH);

		add(left, BorderLayout.WEST);
		add(right, BorderLayout.CENTER);

		setEditable(false);
	}

	private void addAlbum() {
		Album album = new Album(new ArrayList<>(), ReleaseType.ALBUM, "Untitled", "", "");
		albumModel.addElement(album);
		albumList.setSelectedValue(album, true);
	}

	private void loadSelected() {
		selected = albumList.getSelectedValue();
		trackModel.setRowCount(0);

		if (selected == null) {
			nameField.setText("");
			artistField.setText("");
			genreField.setText("");
			setEditable(false);
			return;
		}

		nameField.setText(selected.getAlbumName());
		artistField.setText(selected.getAlbumArtist());
		genreField.setText(selected.getAlbumGenre());
		typeBox.setSelectedItem(selected.getReleaseType());

		if (selected.getTracks() != null) {
			for (Song s : selected.getTracks()) {
				trackModel.addRow(new Object[]{
						s.getDisc_num(),
						s.getTrack_num(),
						s.getTitle(),
						s.getArtists() == null ? "" : String.join(", ", s.getArtists())
				});
			}
		}
		setEditable(true);
	}

	private void saveSelected() {
		if (selected == null) {
			return;
		}

		List<Song> newTracks = new ArrayList<>();
		try {
			for (int row = 0; row < trackModel.getRowCount(); row++) {
				int disc = Integer.parseInt(trackModel.getValueAt(row, 0).toString().trim());
				int track = Integer.parseInt(trackModel.getValueAt(row, 1).toString().trim());
				String title = String.valueOf(trackModel.getValueAt(row, 2)).trim();
				String artistText = String.valueOf(trackModel.getValueAt(row, 3)).trim();

				List<String> artists = artistText.isEmpty()
						? new ArrayList<>()
						: Arrays.stream(artistText.split(","))
						.map(String::trim)
						.filter(s -> !s.isEmpty())
						.collect(Collectors.toList());

				newTracks.add(new Song(title, artists, track, disc));
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,
					"Disc and track numbers must be whole numbers.",
					"Invalid input", JOptionPane.ERROR_MESSAGE);
			return;
		}

		selected.setAlbumName(nameField.getText().trim());
		selected.setAlbumArtist(artistField.getText().trim());
		selected.setAlbumGenre(genreField.getText().trim());
		selected.setReleaseType((ReleaseType) typeBox.getSelectedItem());

		// Album has no setTracks(), so update the existing list in place
		List<Song> target = selected.getTracks();
		target.clear();
		target.addAll(newTracks);

		albumList.repaint();
	}

	private void setEditable(boolean editable) {
		nameField.setEnabled(editable);
		artistField.setEnabled(editable);
		genreField.setEnabled(editable);
		typeBox.setEnabled(editable);
		trackTable.setEnabled(editable);
	}
}