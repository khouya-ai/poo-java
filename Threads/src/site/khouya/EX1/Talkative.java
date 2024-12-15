package site.khouya.EX1;

public class Talkative implements Runnable {
    int val;

    public Talkative(int val) {
        this.val = val;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(val);
        }


    }
}