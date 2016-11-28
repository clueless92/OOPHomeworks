package bg.softuni.pr05;

import bg.softuni.pr05.exception.InvalidSongException;
import bg.softuni.pr05.models.Song;
import bg.softuni.pr05.models.SongDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int inputCount = Integer.parseInt(reader.readLine());
		SongDatabase database = new SongDatabase();

		for (int i = 0; i < inputCount; i++) {
			String[] inputParams = reader.readLine().split(";");
			String artistName = inputParams[0];
			String songName = inputParams[1];
			String duration = inputParams[2];
			try {
				Song song = new Song(artistName, songName, duration);
				database.addSong(song);
				System.out.println("Song added.");
			} catch (InvalidSongException ise) {
				System.out.println(ise.getMessage());
			}
		}

		System.out.println(database);
	}
}
