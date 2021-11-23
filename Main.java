import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static float[] firstMethod() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime  = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i ++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        System.out.println("One thread time is: " + (System.currentTimeMillis() - startTime) + " ms.");
        return arr;
    }

    public static float[] secondMethod() throws InterruptedException {
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime  = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr,0,a1,0,h);
        System.arraycopy(arr,h,a2,0,h);
        long cutTime  = System.currentTimeMillis();
        System.out.println("Cutting time is: " + (cutTime - startTime) + " ms.");
        Thread t1 = new Thread(() -> {
            long fillTimeOne  = System.currentTimeMillis();
            for(int i = 0; i < a1.length; i ++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            long fillTimeOneFinish = System.currentTimeMillis();
            System.out.println("Filling first part of array time is: " + (fillTimeOneFinish - fillTimeOne) + " ms.");
        });
        Thread t2 = new Thread(() -> {
            long fillTimeTwo  = System.currentTimeMillis();
            for(int i = 0; i < a2.length; i ++) {
                int j = i + h;
                a2[i] = (float)(a2[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }
            long fillTimeTwoFinish = System.currentTimeMillis();
            System.out.println("Filling second part of array time is: " + (fillTimeTwoFinish - fillTimeTwo) + " ms.");
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long arrAgainStart = System.currentTimeMillis();
        float[] arrFilledTogether = new float[size];
        System.arraycopy(a1, 0, arrFilledTogether, 0, h);
        System.arraycopy(a2, 0, arrFilledTogether, h, h);
        long allTime = System.currentTimeMillis();
        System.out.println("Thread compile back to arrFilledTogether time is: " + (allTime - arrAgainStart) + " ms.");
        System.out.println("Execution all process time is: " + (allTime - startTime) + " ms.");
        return arrFilledTogether;
    }

    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }
}
