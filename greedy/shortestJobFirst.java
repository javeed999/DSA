import java.util.*;

public class Main {
    public static int shortestDeliveryFirst(List<Integer> deliveryTimes) {
        
        Collections.sort(deliveryTimes); // Sort the delivery times
        long total_wait_time = 0, t = 0;

        for (int time : deliveryTimes) {
            total_wait_time += t; // Add current wait time to total wait time
            t += time;          // Update the time
        }

        return (int) (total_wait_time / deliveryTimes.size()); // Calculate floor value by integer division
    }
    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> deliveryTimes = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            deliveryTimes.add(scanner.nextInt());
        }
        int result = shortestDeliveryFirst(deliveryTimes);
        System.out.println(result);
        scanner.close();
    }*/
}
