public class NotMotivatedYesStressed extends IState
{
    private Student student = Student.getInstance();

    @Override
    public void doSchoolwork()
    {
        student.addNewIntelligenceLevel();
        System.out.println("You are still stressed but wiser");
    }

    @Override
    public void doHobby()
    {
        student.setStressed(false);
        // I removed the concatenation on the following println statement as this line does not appear
        // to overflow the max line character length. I added the missing space
        System.out.println("You are no longer stressed, but your motivation has dropped a little");
        student.setState(new NotMotivatedNotStressed());
    }

    @Override
    public void inspireSelf()
    {
        student.addNewMotivationalLevel();
        System.out.println("You are now a little more motivated");
        student.setState(new YesMotivatedYesStressed());
    }
}
