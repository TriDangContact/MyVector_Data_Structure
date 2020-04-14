import java.util.Arrays;

public class MyVector<E> extends MyAbstractList<E> {
    private E[] array;
    private int size;
    private int capacity = 10;
    private int incrementCapacity = 5;

    @SuppressWarnings("unchecked")
    public MyVector(){
        this.array = (E[]) new Object[this.capacity];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyVector(int capacity){
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
        this.size = 0;

    }

    @SuppressWarnings("unchecked")
    public MyVector(int capacity, int incrementCapacity) {
        this.capacity = capacity;
        this.incrementCapacity = incrementCapacity;
        this.array = (E[]) new Object[capacity];
        this.size = 0;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getIncrement() {
        return this.incrementCapacity;
    }

    /**
     * Appends the specified element to the end of this list,
     * The list capacity should be resized based on a capacity
     * increment variable once the current capacity is filled (capacity == size).
     * @param data
     * @return boolean
     */
    @Override
    public boolean add(E data) {
        if (isFull()) {
            incrementCapacity();
        }
        this.array[this.size] = data;
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements by adding one to their indices.
     * The list capacity should be resized based on a capacity
     * increment variable once the current capacity is filled (capacity == size).
     * @param index - index at which the specified element is to be inserted
     * @param data - element to be inserted
     * @return boolean
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
     */
    @Override
    public boolean add(int index, E data) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            System.out.println("Index must be >= 0 and <= current size.");
            throw new IndexOutOfBoundsException();
        }
        if (isFull()) {
            incrementCapacity();
        }
        // need to shift items if we're not adding to end of vector
        if (index != size) {
            for (int i = size - 1; i >= index; i--) {
                this.array[i + 1] = this.array[i];
            }
        }
        this.array[index] = data;
        size++;
        return true;
    }

    /**
     * Removes all of the elements from this list
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        for (int index = 0; index<size; index++) {
            this.array[index] = null;
        }
        this.size = 0;
    }

    /**
     * Returns the element at the specified position in this list
     * @param index
     * @return E
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException{
        if (isEmpty()) {
            System.out.println("Array is empty.");
            throw new IndexOutOfBoundsException();
        }
        if (index < 0 || index >= this.size) {
            System.out.println("Index must be >= 0 and < current size.");
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }

    /**
     * Returns true if this list contains no elements
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * Removes the  element at the specified position in this list.
     * Shifts any subsequent elements by subtracting one from their indices.
     * @param index - index of the element to be removed
     * @return E - the element that was removed from the list
     * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            throw new IndexOutOfBoundsException();
        }
        if (index < 0 || index >= this.size) {
            System.out.println("Index must be >= 0 and < current size.");
            throw new IndexOutOfBoundsException();
        }

        E removedObject = this.array[index];
        for (int i = index; i < size; i++) {
            this.array[index] = this.array[index+1];
        }
        size--;
        return removedObject;
    }

    /**
     * Trims the capacity of this MyVector instance to be the list's current size. An application
     * can use this operation to minimize the storage of a MyVector instance.
     */
    @Override
    public void trimToSize() {
        for (int index = this.size; index < this.capacity; index++) {
            this.array[index] = null;
        }
        this.capacity = this.size;
    }

    /**
     * Returns the number of elements in this list
     * @return int
     */
    @Override
    public int size() {
        return this.size;
    }

    public String toString() {
//        return Arrays.toString(this.array);
        // have to manually build the str to fit zybook's unit test
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int index = 0; index < size - 1; index++) {
            str.append(this.array[index]).append(", ");
        }
        str.append(this.array[size - 1]);
        str.append("]");
        return str.toString();
    }

    private boolean isFull() {
        return size==capacity;
    }

    @SuppressWarnings("unchecked")
    private void incrementCapacity() {
        capacity += incrementCapacity;
        E[] newArray = (E[]) new Object[capacity];
        // copy values from old array to new array
        if (size >= 0) System.arraycopy(this.array, 0, newArray, 0, size);
        this.array = newArray;
    }

    public void printVector() {
        System.out.println("");
        for (int index = 0; index < capacity; index++) {
            System.out.print(this.array[index] + " ");
        }
    }

}
