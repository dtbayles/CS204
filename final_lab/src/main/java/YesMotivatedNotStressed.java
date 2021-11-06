public class YesMotivatedNotStressed extends IState
{
    private Student student = Student.getInstance();

    @Override
    public void doSchoolwork()
    {
        student.setStressed(true);
        student.addNewIntelligenceLevel();
        System.out.println("You are now stressed but wiser");
        student.setState(new YesMotivatedYesStressed());
    }

    @Override
    public void takeTest()
    {
        student.setStressed(true);
        student.subtractMotivationLevel();
        student.increaseCompletedTests();
        // The boolean value set in the following line is being checked in the main method to determine
        // if the student passed a test or not
        student.setPassedATest(true);
        student.setIntelligenceLevel(0);
        student.setState(new YesMotivatedYesStressed());
    }
}
