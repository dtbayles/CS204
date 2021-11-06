import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student student = Student.getInstance();
        String input;
        student.setState(new NotMotivatedNotStressed());

        Scanner s = new Scanner(System.in);
        System.out.println("What is your name?");
        input = promptForInput(s);
        student.setName(input);
        int semesterCount = promptForSemesterTotal(s);
        displayUseMe();

        boolean over = false;
        while(!over)
        {
            input = promptForInput(s);
            switch (input)
            {
                case "exit":
                    // The 2 commented out lines were what should happen when a user graduates
                    // the simple return statement causes the program to exit as desired
                    return;
                case "status":
                    System.out.println(student.toString());
                    break;
                case "help":
                    displayUseMe();
                    break;
                case "DS":
                    student.doSchoolwork();
                    break;
                case "IS":
                    student.inspireSelf();
                    break;
                case "DH":
                    student.doHobby();
                    break;
                case "TT":
                    student.takeTest();
                    // I added the first if statement in this if else section
                    // this will first test if a user should graduate, if so, the program will immediately
                    // break and print the correct output.
                    if (student.getCompletedTests() == semesterCount) {
                        over = true;
                        break;
                    }
                    else if(student.getPassedATest())
                    {
                        displaySuccessful();
                        student.setPassedATest(false);
                    }
                    else
                        displayUnsuccessful();
                    break;
                default:
                    System.out.println("Please enter a valid string");
                    displayUseMe();
            }
        }
        System.out.println("Congratulations! You graduated!");
    }

    public static void displayUseMe()
    {
        System.out.println("The student program takes string commands that you enter into the command line\n" +
                "DS - Do Schoolwork\nIS - Inspire Self\nDH - Do Hobby\nTT - Take Test\n" +
                "status - shows your current stats as a student\nexit - give up and quit the program" +
                "\nhelp - see these options again");
    }

    public static void displaySuccessful()
    {
        System.out.println("You passed the test, but the stress" +
                " of it all gets to you.\nNext test with new material " +
                "is coming soon,\nyour intelligence has been set to 0.");
    }

    public static void displayUnsuccessful()
    {
        System.out.println("You couldn't pass the test, the stress" +
                " of it all gets to you and you don't feel motivated" +
                " to continue.\nNext test with new material " +
                "is coming soon, your intelligence has been set to 0.");
    }

    public static String promptForInput(Scanner s)
    {
        String input = s.nextLine();
        input = input.trim();
        return input;
    }

    public static int promptForSemesterTotal(Scanner s)
    {
        System.out.println("How many tests will there be during the semester");
        String input = promptForInput(s);
        int number;

        try
        {
            number = Integer.parseInt(input);
        }
        catch (NumberFormatException e)
        {
            number = promptForSemesterTotal(s);
        }

        return number;
    }


}
