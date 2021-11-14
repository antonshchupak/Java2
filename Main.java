package lesson2;

public class Main {
    public static void main(String[] args) {
    try {
    int sum = sumMyArray(new String[][] {
        {"2", "8", "1", "-2"},
        {"4", "8", "4", "1"},
        {"3", "5", "7", "0"},
        {"1", "4", "3", "-4"},
    });
        System.out.println("The result of calculation is: " + sum);
    } catch (MyArraySizeException e) {
        e.printStackTrace();
        System.out.println("array size error");
    } catch (MyArrayDataException e) {
        e.printStackTrace();
        System.out.println(e.getError());
    }
    }

    public static int sumMyArray(String [][] result) throws MyArraySizeException, MyArrayDataException {
        if(result.length != 4) {
            throw new MyArraySizeException();

        }
        for (String[] stringArray: result) {
            if(stringArray.length != 4) {
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                try {
                    sum += Integer.parseInt(result[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }


}
