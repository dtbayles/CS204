package pointcutExample;

public class MyPointcutClass {

    public static void main(String[] args) {
        MyPointcutClass myClass = new MyPointcutClass();
        MyOtherClass myOtherClass = new MyOtherClass();

        System.out.println();
        myClass.myMethod();

        System.out.println("");
        myClass.myMethod(5);

        System.out.println("");
        String inputParameter = "A Test String";
        System.out.println("the inputParameter = " + inputParameter);
        String returnString = myClass.myMethod(inputParameter);
        System.out.println("returnString = " + returnString);

        System.out.println("");
        myClass.myMethod2();

        System.out.println("");
        myClass.myMethod3();

        System.out.println("");
        myClass.myMethod4();

        System.out.println("");
        myOtherClass.myMethod();

        System.out.println("");
        myOtherClass.myMethod(5);

        System.out.println("");
        myOtherClass.myMethod("string");



    }

    public void myMethod() {
        System.out.println("Executing myMethod()");
    }

    private void myMethod(Integer aNumber){
        System.out.println("Executing myMethod(Integer int), the parameter given is: " + aNumber);
    }

    private String myMethod(String aString){
        System.out.println("Executing myMethod(String string), the parameter given inside the myMethod is: " + aString);
        return aString;
    }



    private void myMethod2(){
        System.out.println("method2");
    }

    private Integer myMethod3(){
        System.out.println("method3");
        return 5;
    }

    private void myMethod4(){
        System.out.println("method4");
    }

}
