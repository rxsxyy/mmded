package data;

import java.util.Date;
import java.util.List;

public class Album {
	List<Song> tracks;
	String albumName;
	/**
	 * Same as the first song artist (by default, it is editable).
	 * @see Song#getArtist()
	 */
	String albumArtist;
	String albumGenre;
	Date albumReleaseDate;
	ReleaseType releaseType;
	byte[] albumCoverData;
	String albumCoverMimeType;

	public Album(List<Song> tracks, String albumName, String albumArtist, String albumGenre, Date albumReleaseDate, ReleaseType releaseType) {
		this.tracks = tracks;
		this.albumName = albumName;
		this.albumArtist = albumArtist;
		this.albumGenre = albumGenre;
		this.albumReleaseDate = albumReleaseDate;
		this.releaseType = releaseType;
	}

	public List<Song> getTracks() {
		return tracks;
	}

	public void setTracks(List<Song> tracks) {
		this.tracks = tracks;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumArtist() {
		return albumArtist;
	}

	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}

	public String getAlbumGenre() {
		return albumGenre;
	}

	public void setAlbumGenre(String albumGenre) {
		this.albumGenre = albumGenre;
	}

	public Date getAlbumReleaseDate() {
		return albumReleaseDate;
	}

	public void setAlbumReleaseDate(Date albumReleaseDate) {
		this.albumReleaseDate = albumReleaseDate;
	}

	public ReleaseType getReleaseType() {
		return releaseType;
	}

	public void setReleaseType(ReleaseType releaseType) {
		this.releaseType = releaseType;
	}

	public byte[] getAlbumCoverData() {
		return albumCoverData;
	}

	public String getAlbumCoverMimeType() {
		return albumCoverMimeType;
	}

	public void setCover(byte[] albumCoverData, String albumCoverMimeType) {
		this.albumCoverData = albumCoverData;
		this.albumCoverMimeType = albumCoverMimeType;
	}

	public void clearCover() {
		this.albumCoverData = null;
		this.albumCoverMimeType = null;
	}
}
