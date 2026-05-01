class Room{
    float breadth;
    float width;
    float floorArea(){
        return breadth*width;
    }
}

public class House {
    public static void main(String args[]){
        Room bedroom1 = new Room();
        Room bedroom2 = new Room();
        Room drawingRoom = new Room();
        Room kitchen = new Room();

        bedroom1.breadth = 12; bedroom1.width = 15;
        bedroom2.breadth = 24; bedroom2.width = 20;
        drawingRoom.breadth = 20; drawingRoom.width = 25;
        kitchen.breadth = 15; kitchen.width = 10;

        float totalArea = bedroom1.floorArea() +
                             bedroom2.floorArea()+
                             drawingRoom.floorArea()+
                             kitchen.floorArea();

        System.out.println("Bedroom1 floor area:"+bedroom1.floorArea());
        System.out.println("Bedroom2 floor area:"+bedroom2.floorArea());
        System.out.println("Drawing Room floor area:"+drawingRoom.floorArea());
        System.out.println("Kitchen floor area:"+kitchen.floorArea());
        System.out.println("Total floor area:"+totalArea);
    }
}