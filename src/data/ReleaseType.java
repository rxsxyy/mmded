package data;

public enum ReleaseType {
	ALBUM("Album"),
	SINGLE("Single"),
	EP("EP"),
	BROADCAST("Broadcast"),
	COMPILATION("Compilation"),
	SOUNDTRACK("Soundtrack"),
	LIVE("Live"),
	REMIX("Remix"),
	DJ_MIX("DJ Mix"),
	MIXTAPE("Mixtape"),
	DEMO("Demo"),
	SPOKEN_WORD("Spoken Word"),
	INTERVIEW("Interview"),
	AUDIOBOOK("Audiobook"),
	AUDIO_DRAMA("Audio Drama"),
	FIELD_RECORDING("Field Recording");

	private final String type;

	ReleaseType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}