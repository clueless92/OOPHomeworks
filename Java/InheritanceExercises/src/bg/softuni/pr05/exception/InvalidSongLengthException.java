package bg.softuni.pr05.exception;

public class InvalidSongLengthException extends InvalidSongException {

	private static final String DEFFAULT_MESSAGE =
			"Invalid song length.";

	public InvalidSongLengthException(){
		super(DEFFAULT_MESSAGE);
	}

	public InvalidSongLengthException(String message){
		super(message);
	}
}
