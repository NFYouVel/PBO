import java.util.Scanner;

enum OptionGeometry {
    Sphere(0), Cylinder(1), Cuboid(2), Cube(3);

    private int code;
    OptionGeometry(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}

abstract class Object3D {
    //Abstract
    private String shapeName;
    
    double radius, height, width, length, side, volume, surface;

    public Object3D(double radius) { //Spehere
        this.radius = radius;
    }
    public Object3D(int side) { //Cube
        this.side = side;
    }
    public Object3D(double radius, double height) { //Cylinder
        this.radius = radius;
        this.height = height;
    }
    public Object3D(double width, double height, double length) { //Cuboid
        this.width = width;
        this.height = height;
        this.length = length;
    }

    // Volume
    public void Volume(){};


    // Print Data
    abstract public void Printdata();
    abstract public void SurfaceArea();
}

class Spehere extends Object3D {
    public Spehere(double radius){
        super(radius);
    }

    @Override
    public void Volume() {
        this.volume = (4/3 * 3.14 * Math.pow(radius, 3));
    }

    @Override
    public void Printdata() {
        System.out.println(volume);
        System.out.println(surface);
    }

    @Override
    public void SurfaceArea() {
        this.surface = (4 * 3.14 * Math.pow(radius, 2));
    }
}

class Cyclinder extends Object3D {
    public Cyclinder(double radius, double height){
        super(radius, height);
    }

    @Override
    public void Volume() {
        this.volume = (3.14 * Math.pow(radius, 2) * height);
    }

    @Override
    public void SurfaceArea() {
        this.surface = (2 * 3.14 * Math.pow(radius, 2) + 1 * 3.14 * radius * height);
    }

    @Override
    public void Printdata() {
        System.out.println(volume);
        System.out.println(surface);
    }

}

class Cuboid extends Object3D {
    public Cuboid(double width, double height, double length){
        super(width, height, length);
    }

    @Override
    public void Volume() {
        this.volume = (width * height * length);
    }

    @Override
    public void SurfaceArea() {
        this.surface = (2 * (width * length + width * height + height * length));
    }

    @Override
    public void Printdata() {
        System.out.println(volume);
        System.out.println(surface);
    }
}

class Cube extends Object3D {
    public Cube(int side){
        super(side);
    }

    @Override
    public void Volume() {
        this.volume = (Math.pow(side, 3));
    }

    @Override
    public void SurfaceArea() {
        this.surface = (6 * Math.pow(side, 2));
    }

    @Override
    public void Printdata() {
        System.out.println(volume);
        System.out.println(surface);
    }
}

public class Geometry {

    static Scanner sc = new Scanner(System.in);

    public static void Menu() {
        System.out.println("Menu:\n1. Add New 3D Object\n2. Print All\n0. Exit");
    }
    public static void MenuGeometry() {
        System.out.println("Menu:\n1. Sphere\n2. Cylinder\n3. Cuboid\n4. Cube");
    }

    public static void main(String[] args) {
        Menu();
        int menu = sc.nextInt();
        if (menu == 1) { // Add New
            
        } else if (menu == 2) { //Print All
            
        } else { // Menu Exit
            
        }

        Object3D spehere = new Spehere(2);
        spehere.Volume();
        spehere.SurfaceArea();
        spehere.Printdata();

        Object3D cylinder = new Cyclinder(2, 5);
        cylinder.Volume();
        cylinder.SurfaceArea();
        cylinder.Printdata();

        Object3D cuboid = new Cuboid(2, 5, 6);
        cuboid.Volume();
        cuboid.SurfaceArea();
        cuboid.Printdata();

        Object3D cube = new Cube(2);
        cube.Volume();
        cube.SurfaceArea();
        cube.Printdata();
    }
}
