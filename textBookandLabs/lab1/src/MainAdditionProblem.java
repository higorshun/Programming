public class MainAdditionProblem {

    public static void main(String[] args) {
        AdditionProblem AdditionProblem = new AdditionProblem();
        System.out.println(AdditionProblem.getProblem());
        System.out.println("Please type the result: ");
        String yourResult = TextIO.getln();
        int yourResultInt = Integer.parseInt(yourResult);
        if (yourResultInt == (AdditionProblem.getAnswer())) {
            System.out.println("You did it. The correct answer is " + AdditionProblem.getAnswer());

        } else
            System.out.println("NOOO... the correct answer is " + AdditionProblem.getAnswer());


    }


}
