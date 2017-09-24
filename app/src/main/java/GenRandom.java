import android.util.Log;

import java.util.Random;

/**
 * Created by Olyn on 9/24/2017.
 */

public class GenRandom extends Thread {
    Random r = new Random();

    @Override
    public synchronized void start() {
        while(true) {
            Log.v("Random", "Random number is " + r.nextInt(100));
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }

        }

    }
}
