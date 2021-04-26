package firstChallenges;

public class DiagonalStar {

    public static void main(String[] args) {
        printSquareStar(5);

    }

    public static String printSquareStar(int number) {
        String star = "*";
        String finalWork = "*";


        if (number < 5) {
            return "Invalid number";
        }
        int firstRow = 0;
        int finalRow = 0;
        int firstColunm = 0;
        int lastColunm = 0;

        while (firstRow != number) {
            System.out.print(star);
            firstRow++;
            if (firstRow == number - 1) {
                while (firstColunm != number) {
                    System.out.println(star);
                    firstColunm++;
                    if (firstColunm == number) {
                        while (finalRow != number) {
                            System.out.print(star);
                            finalRow++;
                        }
                    }
                }
            }


//        for(firstRow = 1; firstRow <= number; firstRow++){
//            System.out.print(star);
//
//            //if (finalRow< firstRow){
//                for (finalRow = 1; finalRow< number; finalRow++){
//                    System.out.print(star);
//                } // if(firstColunm<firstRow) {
//                    for (firstColunm = 1; firstColunm < number; firstColunm++) {
//                        System.out.println(star);
//                    }
//               // }
//          //  }

//            if(firstRow==number){
//                for (firstColunm = 1; firstColunm<= firstRow; firstColunm++){
//                System.out.println(star);
//                if (firstColunm == number){
//
//                }
//
//
//                }
//            } // end of first Column

        } // end of first Row

//        for (firstColunm = 1; firstColunm < number; firstColunm++) {
//            System.out.println(" ");
//            System.out.print(star);
//
//            if(firstColunm==number-1){
//                for(finalRow = 1; finalRow < number; finalRow++){
//                    System.out.print(star);
//
//                }
//            }
//
//
//        }


        return finalWork;

    }
}
