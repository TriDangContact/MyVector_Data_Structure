public class Main {

    public static void main(String[] args) {
	// write your code here
        MyVector<String> myVector = new MyVector<>();
        myVector.add("a");
        myVector.add("b");
        myVector.add("c");
        myVector.add("d");
        myVector.add("e");
        myVector.add("f");
        myVector.add("g");
        myVector.add("h");
        myVector.add("i");
        myVector.add("j");
        myVector.printVector();
        myVector.add(2, "z");
        myVector.printVector();
        myVector.add(11, "x");
        myVector.printVector();
        myVector.trimToSize();
        myVector.printVector();
    }
}
