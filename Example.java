import java.util.concurrent.CompletableFuture;

// Asynchronous Code Running Without blocking code 
// We are using CompletableFuture class which is Advanced version Future interface
// future is the Old Way to run Asynchronous code 
// future was introduced in java 5
// CompletableFuture was introduced in Java 8 it also support Functional Programming
public class Example {
    public static void main(String[] args) throws Exception {
        
        // CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        //     try {
        //         Thread.sleep(2000); // simulate delay
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        //     return "Task Completed!";
        // });

        // // Non-blocking callback
        // future.thenAccept(result -> System.out.println("Result: " + result));

        // System.out.println("Main thread continues...");
        // Thread.sleep(3000); // wait to see result
        
    }
}

