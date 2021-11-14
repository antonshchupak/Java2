package lesson2;

public class MyArrayDataException extends Exception {
int errI;
int errJ;
public MyArrayDataException(int i, int j) {
    super();
    this.errI = i;
    this.errJ = j;
}
    String getError() {return "error in cell: [ " + errI + " ," + errJ + " ]"; }
}
