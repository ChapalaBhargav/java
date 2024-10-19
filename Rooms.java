import java.util.Scanner;

class Rooms {
    private int roomNo;
    private String roomType;
    private double roomArea;
    private boolean hasAC;

    public void setData(int roomNo, String roomType, double roomArea, boolean hasAC) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomArea = roomArea;
        this.hasAC = hasAC;
    }

    public void displayData() {
        System.out.println("Room Number: " + roomNo);
        System.out.println("Room Type: " + roomType);
        System.out.println("Room Area: " + roomArea + " sq. meters");
        System.out.println("AC Available: " + (hasAC ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Room Number: ");
        int roomNo = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Room Type: ");
        String roomType = scanner.nextLine();

        System.out.print("Enter Room Area (in sq. meters): ");
        double roomArea = scanner.nextDouble();

        System.out.print("Does the room have AC? (true/false): ");
        boolean hasAC = scanner.nextBoolean();

        Room room = new Room();
        room.setData(roomNo, roomType, roomArea, hasAC);
        System.out.println("\nRoom Details:");
        room.displayData();
    }
}
