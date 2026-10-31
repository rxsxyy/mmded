package data;

import java.util.List;

public class Song {
	/**
	 * Track title.
	 */
	String title;
	/**
	 * List of artists, <code>artists.get(0)</code> is set as main artist while the rest are featured artists.
	 */
	List<String> artists;
	/**
	 * Track number in Album.
	 */
	int trackNum;
	/**
	 * Disc number in Album.
	 */
	int discNum;

	public Song(String title, List<String> artists, int trackNum, int discNum) {
		this.title = title;
		this.artists = artists;
		this.trackNum = trackNum;
		this.discNum = discNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		List<String> list = getArtists();
		return ((list == null) || list.isEmpty()) ? null : list.get(0);
	}

	public List<String> getArtists() {
		return artists;
	}

	public void setArtists(List<String> artists) {
		this.artists = artists;
	}

	public int getTrackNum() {
		return trackNum;
	}

	public void setTrackNum(int trackNum) {
		this.trackNum = trackNum;
	}

	public int getDiscNum() {
		return discNum;
	}

	public void setDiscNum(int discNum) {
		this.discNum = discNum;
	}
}