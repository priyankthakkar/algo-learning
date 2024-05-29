import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.*;

class Scratch {
    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.now();
        Fibonacci fibonacci = new Fibonacci();
        int fibonacciNumberPosition =2000;
        System.out.printf("%d th fibonacci number is %d%n", fibonacciNumberPosition, fibonacci.getNthFibonacciNumber(fibonacciNumberPosition));
        LocalDateTime endTime = LocalDateTime.now();
        Duration d = Duration.between(startTime, endTime);
        System.out.printf("It tooks %d milliseconds to calculate %dth Fibonacci number%n", d.toMillis(), fibonacciNumberPosition);

        LocalDateTime dynamicStartTime = LocalDateTime.now();
        DynamicFibonacci dynamicFibonacci = new DynamicFibonacci();
        System.out.printf("%d th fibonacci number is %d%n", fibonacciNumberPosition, dynamicFibonacci.getNthFibonacciNumber(fibonacciNumberPosition));
        LocalDateTime dynamicEndTime = LocalDateTime.now();

        Duration dynamicDuration = Duration.between(dynamicStartTime, dynamicEndTime);
        System.out.printf("It tooks %d milliseconds to calculate %dth Fibonacci number with dynamic programming%n", dynamicDuration.toMillis(), fibonacciNumberPosition);
    }
}

class Fibonacci {

    public long getNthFibonacciNumber(int n) {
        if(n <= 1) {
            return n;
        }

        return getNthFibonacciNumber(n-1) + getNthFibonacciNumber(n-2);
    }
}

class DynamicFibonacci {

    private Map resultMap;

    public DynamicFibonacci() {
        this.resultMap = new HashMap<Integer, Long>();
    }

    public Long getNthFibonacciNumber(int n) {
        if(n <= 1) {
            return (long) n;
        }

        if(this.resultMap.containsKey(n)) {
            return (Long)this.resultMap.get(n);
        }

        long result = getNthFibonacciNumber(n-1) + getNthFibonacciNumber(n-2);
        this.resultMap.put(n, result);
        return result;
    }
}
