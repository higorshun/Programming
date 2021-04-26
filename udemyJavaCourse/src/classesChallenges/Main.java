package classesChallenges;

public class Main {

    public static void main(String[] args) {

        //create object CAR
        /*Car porsche = new Car(); // initializing a new object
        porsche.setModel("911");
        System.out.println("Model is " + porsche.getModel());*/
//        SimpleCalculator calculator = new SimpleCalculator();
//        calculator.setFirstNumber(5.0);
//        calculator.setSecondNumber(4);
//        System.out.println("add= " + calculator.getAdditionResult());
//        System.out.println("subtract= " + calculator.getSubtractionResult());
//        calculator.setFirstNumber(5.25);
//        calculator.setSecondNumber(0);
//        System.out.println("multiply= " + calculator.getMultiplicationResult());
//        System.out.println("divide= " + calculator.getDivisionResult());
//        Person person = new Person();
//        person.setFirstName("");   // firstName is set to empty string
//        person.setLastName("");    // lastName is set to empty string
//        person.setAge(10);
//        System.out.println("fullName= " + person.getFullName());
//        System.out.println("teen= " + person.isTeen());
//        person.setFirstName("John");    // firstName is set to John
//        person.setAge(18);
//        System.out.println("fullName= " + person.getFullName());
//        System.out.println("teen= " + person.isTeen());
//        person.setLastName("Smith");    // lastName is set to Smith
//        System.out.println("fullName= " + person.getFullName());
//
//        BankAccount timsAccount = new BankAccount("Tim", "emai@com", "0803939");
//
//        System.out.println(timsAccount.getAccountNumber());
//        System.out.println("Current balance is = " + timsAccount.getBalance());
//        timsAccount.withdraw(100.55);


//        VipCustomer person1 = new VipCustomer();
//        System.out.println(person1.getName());
//
//        VipCustomer person2 = new VipCustomer("Bob", 2500);
//        System.out.println(person2.getName());
//
//        VipCustomer person3 = new VipCustomer("Lil", 5600, "lil@lil.com");
//        System.out.println(person3.getName());
//        System.out.println(person3.getEmailAddress());
//
//        Wall wall = new Wall(-1.25,-1.25);
//        System.out.println("area= " + wall.getArea());
//        wall.setHeight(-1.5);
//        System.out.println("width= " + wall.getWidth());
//        System.out.println("height= " + wall.getHeight());
//        System.out.println("area= " + wall.getArea());

        Point first = new Point(6, 5);
        Point second = new Point(3, 1);
        System.out.println("distance(0,0)= " + first.distance());
        System.out.println("distance(second)= " + first.distance(second));
        System.out.println("distance(2,2)= " + first.distance(2, 2));
        Point point = new Point();
        System.out.println("distance()= " + point.distance());

    }
}
