import java.util.Scanner;

import FurnitureSystem.AbstractFurnitureFactory.FurnitureFactory;
import FurnitureSystem.OfficeFurnitureFactory.OfficeFurnitureFactory;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Furniture: (choose your style)");
        System.out.println("1. Office Style");
        System.out.println("2. Art Style");
        System.out.print("choice: ");
        int choice1 = sc.nextInt();
        sc.nextLine();

        switch (choice1) {
            case 1:

                break;

            case 2:

                break;

            default:
                break;
        }
    }

    public static void officeItemMenu() {
        Scanner sc = new Scanner(System.in);

        FurnitureFactory factory = new OfficeFurnitureFactory();

        System.out.println("Office Furniture: (choose your item)");
        System.out.println("1. Office Chair");
        System.out.println("2. Office Table");
        System.out.print("choice: ");
        int choice1 = sc.nextInt();
        sc.nextLine();

        switch (choice1) {
            case 1:
                Chair chair = fa
                break;

            case 2:

                break;

            default:
                break;
        }
    }
}
