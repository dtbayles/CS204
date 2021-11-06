package pointcutExample;

public class MyOtherClass {

    public void myMethod(){
        System.out.println("myOtherClass method");
    }

    public Integer myMethod(Integer a){
        System.out.println("myOtherClass method with Integer parameter");
        return 5;
    }

    public void myMethod(String a){
        System.out.println("myOtherClass method with String parameter");
    }
}
