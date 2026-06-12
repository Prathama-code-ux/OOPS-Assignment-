class Box {
    double height;
    double width;
    double breadth;

    Box() {
        this.height = 1.0;
        this.width = 1.0;
        this.breadth = 1.0;
    }

    Box(double height, double width, double breadth) {
        this.height = height;
        this.width = width;
        this.breadth = breadth;
    }

    double getVolume() {
        return height * width * breadth;
    }

    double getArea() {
        return 2 * (height * width + width * breadth + height * breadth);
    }
}

public class BoxManager {
    public static void main(String[] args) {
        Box box1 = new Box(2.5, 3.0, 4.0);
        Box box2 = new Box(5.0, 5.0, 5.0);

        System.out.println("Box 1 Volume: " + box1.getVolume());
        System.out.println("Box 1 Surface Area: " + box1.getArea());
        System.out.println("Box 2 Volume: " + box2.getVolume());
        System.out.println("Box 2 Surface Area: " + box2.getArea());

        Box[] boxes = {box1, box2};
        double totalVolume = 0;
        for (Box b : boxes) {
            totalVolume += b.getVolume();
        }

        double roomHeight = 10.0;
        double roomWidth = 10.0;
        double roomBreadth = 10.0;
        double roomVolume = roomHeight * roomWidth * roomBreadth;

        int roomsRequired = (int) Math.ceil(totalVolume / roomVolume);
        System.out.println("Rooms required: " + roomsRequired);
    }
}