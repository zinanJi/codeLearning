package Network.InternetAddress;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zinan.ji on 2020-05-06.
 */
public class PoolWeblog {
    private final static int NUM_THREAD = 4;
    
    private static class LogEntry {
        String original;
        Future<String> future;

        public LogEntry(String original, Future<String> future) {
            this.original = original;
            this.future = future;
        }
    }
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREAD);
        Queue<LogEntry> res = new LinkedList<>();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),"UTF-8"))) {
            for (String entry = in.readLine();entry!=null;entry = in.readLine()){
                LookupTask task = new LookupTask(entry);
                Future<String> future = executor.submit(task);
                LogEntry result = new LogEntry(entry,future);
                res.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (LogEntry result : res) {
            try{
                System.out.println(result.future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } 
        }
        executor.shutdown();
    }
    
}
