package bg.softuni.pr05.models;

import bg.softuni.pr05.exception.*;

public class Song {

	private String artistName;
	private String songName;
	private int seconds;
	private int minutes;

	public Song(String artistName, String songName, String duration) {
		this.setArtistName(artistName);
		this.setSongName(songName);
		this.setDuration(duration);
	}

	public int getSeconds() {
		return seconds;
	}

	private void setSeconds(int seconds) {
		if (seconds < 0 || seconds > 59) {
			throw new InvalidSongSecondsException();
		}

		this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	private void setMinutes(int minutes) {
		if (minutes < 0 || minutes > 14) {
			throw new InvalidSongMinutesException();
		}

		this.minutes = minutes;
	}

	private void setArtistName(String artistName) {
		if (artistName == null || artistName.length() < 3 || artistName.length() > 20) {
			throw new InvalidArtistNameException();
		}

		this.artistName = artistName;
	}

	private void setSongName(String songName) {
		if (songName == null || songName.length() < 3 || songName.length() > 30) {
			throw new InvalidSongNameException();
		}

		this.songName = songName;
	}

	private void setDuration(String duration) {
		String[] durationParams = duration.split(":");
		int minutes;
		int seconds;
		try {
			minutes = Integer.parseInt(durationParams[0]);
			seconds = Integer.parseInt(durationParams[1]);
		} catch (NumberFormatException nfe) {
			throw new InvalidSongLengthException();
		}

		this.setMinutes(minutes);
		this.setSeconds(seconds);
	}
}
