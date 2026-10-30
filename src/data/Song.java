package data;

import java.nio.file.Path;
import java.util.List;

public class Song {
	String title;
	List<String> artists;
	int track_num;
	int disc_num;
	Path path;

	public Song() {
	}

	public Song(String title, List<String> artists, int track_num, int disc_num) {
		this.title = title;
		this.artists = artists;
		this.track_num = track_num;
		this.disc_num = disc_num;
	}

	public Song(String title, List<String> artists, int track_num, int disc_num, Path path) {
		this(title, artists, track_num, disc_num);
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getArtists() {
		return artists;
	}

	public void setArtists(List<String> artists) {
		this.artists = artists;
	}

	public int getTrack_num() {
		return track_num;
	}

	public void setTrack_num(int track_num) {
		this.track_num = track_num;
	}

	public int getDisc_num() {
		return disc_num;
	}

	public void setDisc_num(int disc_num) {
		this.disc_num = disc_num;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}
}