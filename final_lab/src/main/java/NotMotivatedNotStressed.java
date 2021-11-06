public class NotMotivatedNotStressed extends IState
{
    private Student student = Student.getInstance();

    @Override
    public void doSchoolwork()
    {
        // I added the following 1 line of code as the student needs to increase intelligence
        student.addNewIntelligenceLevel();
        student.setStressed(true);
        System.out.println("You are now stressed but wiser");
        student.setState(new NotMotivatedYesStressed());
    }

    @Override
    public void inspireSelf()
    {
        student.addNewMotivationalLevel();
        System.out.println("You are now a little more motivated");
        student.setState(new YesMotivatedNotStressed());
    }
}
