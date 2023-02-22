package customexecption;

public class InvalidChoiceExecption extends Exception {
	private String message;
	public InvalidChoiceExecption(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}

}
