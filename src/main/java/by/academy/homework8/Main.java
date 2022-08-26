package by.academy.homework8;

class Main {

    public static int mValue = 0;

    static Inc inc;

    public static void main(String[] args) {
        inc = new Inc();
        System.out.println("Value = ");
        inc.start();

        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(i * 2 * 1000);
            } catch (InterruptedException ex) { }
            inc.changeAction();
        }

        inc.interrupt();
    }
}

class Inc extends Thread {

    private volatile boolean mIsInc = true;

    public void changeAction() {
        mIsInc = !mIsInc;
    }

    @Override
    public void run() {
        do {
          if (!Thread.interrupted()) {
              if (mIsInc) Main.mValue++;
              else Main.mValue--;
              System.out.println(Main.mValue + " ");
          } else
              return;
          try {
              Thread.sleep(1000);
          } catch (InterruptedException ex) { return; }
        } while (true);
    }
}