import java.util.Random;

class Student
{
    private static final Student ourInstance = new Student();
    static Student getInstance()
    {
        return ourInstance;
    }
    private IState currentState;
    private String name;
    private int motivationLevel = 0;
    private int intelligenceLevel = 0;
    private int completedTests = 0;
    private Boolean stressed = false;
    private Boolean passedATest = false;

    public Boolean getPassedATest()
    {
        return passedATest;
    }

    public void setPassedATest(Boolean passedATest)
    {
        this.passedATest = passedATest;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setMotivationLevel(int motivationLevel)
    {
        this.motivationLevel = motivationLevel;
    }

    public void setIntelligenceLevel(int intelligenceLevel)
    {
        this.intelligenceLevel = intelligenceLevel;
    }

    public double getCompletedTests()
    {
        return completedTests;
    }

    public int getMotivationLevel()
    {
        return motivationLevel;
    }

    public int getIntelligenceLevel()
    {
        return intelligenceLevel;
    }

    public void setStressed(Boolean stressed)
    {
        this.stressed = stressed;
    }

    public void setState(IState s)
    {
        currentState = s;
    }

    public void addNewMotivationalLevel()
    {
        int num = getRandomNumber() + motivationLevel;
        motivationLevel = Math.min(num, 10);
    }

    public void subtractMotivationLevel()
    {
        int num = getRandomNumber() - motivationLevel;
        motivationLevel = Math.max(num, 1);
    }

    public void addNewIntelligenceLevel()
    {
        int num = getRandomNumber() + intelligenceLevel;
        intelligenceLevel = Math.min(num, 10);
    }

    private int getRandomNumber()
    {
        Random rn = new Random();
        return rn.nextInt(10) + 1;
    }

    public void increaseCompletedTests()
    {
        completedTests++;
    }

    public void inspireSelf()
    {
        currentState.inspireSelf();
    }

    public void doHobby()
    {
        currentState.doHobby();
    }

    public void doSchoolwork()
    {
        currentState.doSchoolwork();
    }

    public void takeTest()
    {
        currentState.takeTest();
    }

    @Override
    public String toString()
    {
        return "Student: " + name + "\nCurrent motivation level: " + motivationLevel
                + "\nCurrent intelligence level: " + intelligenceLevel
                + "\nTests completed this semester: " + completedTests
                + "\nStressed: " + stressed.toString();
    }
}
