package data;

import java.util.List;

public class Album {

	List<Song> tracks;
	ReleaseType releaseType;
	String albumName;
	String albumArtist;
	String albumGenre;
	byte[] albumCoverData;
	String albumCoverMimeType;

	public Album() {
	}

	public Album(List<Song> tracks, ReleaseType releaseType, String albumName, String albumArtist, String albumGenre) {
		this.tracks = tracks;
		this.releaseType = releaseType;
		this.albumName = albumName;
		this.albumArtist = albumArtist;
		this.albumGenre = albumGenre;
	}

	public List<Song> getTracks() {
		return tracks;
	}

	public ReleaseType getReleaseType() {
		return releaseType;
	}

	public void setReleaseType(ReleaseType releaseType) {
		this.releaseType = releaseType;
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
