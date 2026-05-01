class Box {
    double height;
    double width;
    double breadth;
    Box(){
        this.height = 1.0;
        this.width = 1.0;
        this.breadth = 1.0;
    }

    Box(double height, double width, double breadth){
        this.height = height;
        this.width = width;
        this.breadth = breadth;
    }
    double getVolume(){
        return(height*width*breadth);
    }
    double getArea(){
        return(2*(height*width + width*breadth + height*breadth));
    }
}

public class BoxManager{
    public static void main(String args[]){
        Box box1 = new Box(2.5, 3.0, 4.0);
        Box box2 = new Box(5.0, 5.0, 5.0);

        System.out.println("--- Box 1 ---");
        System.out.println("Volume: " + box1.getVolume() + " cubic units");
        System.out.println("Surface Area: " + box1.getArea() + " sq units");

        System.out.println("--- Box 2 ---");
        System.out.println("Volume: " + box2.getVolume() + " cubic units");
        System.out.println("Surface Area: " + box2.getArea() + " sq units");

        
    }
}