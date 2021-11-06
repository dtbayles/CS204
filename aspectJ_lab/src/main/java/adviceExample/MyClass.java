
package adviceExample;
public class MyClass {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
        myClass.myMethodAround();
    }

    public void myMethod() {
        System.out.println("Executing myMethod()");
    }

    public void myMethodAround(){
        System.out.println("Executing myMethodAround()");
    }
}
