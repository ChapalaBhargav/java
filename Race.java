import java.util.Scanner;
public class Race {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
double[] speeds = new double[5];
double totalSpeed = 0;
System.out.println("Enter the speed of 5 racers:");
for (int i = 0; i < 5; i++) {
speeds[i] = scanner.nextDouble();
totalSpeed += speeds[i];
}
double averageSpeed = totalSpeed / 5;
System.out.println("Average speed: " + averageSpeed);
System.out.println("Qualifying racers:");
for (int i = 0; i < 5; i++) {
if (speeds[i] > averageSpeed) {
System.out.println("Racer " + (i + 1) + ": " + speeds[i]);
}
}
}
}

