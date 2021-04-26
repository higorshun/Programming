
public class AdditionProblem {

	private final int x;
	private final int y;
	private final int answer;

	public AdditionProblem() {
		x = (int) (10 + 40 * Math.random());
		y = (int) (30 * Math.random());
		answer = x + y;
	}

	public String getProblem() {
		return "Compute the sum: " + x + " + " + y;
	}

	public int getAnswer() {
		return answer;
	}


}