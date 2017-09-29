package se.kth.cnlib;

import se.kth.cnlib.examples.ExampleClient;
import se.kth.cnlib.examples.ExampleServer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        new Thread(new ExampleServer()).start();
        Thread.sleep(100L);
        new Thread(new ExampleClient()).start();
    }
}
