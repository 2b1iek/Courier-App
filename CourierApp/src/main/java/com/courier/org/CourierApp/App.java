package com.courier.org.CourierApp;

import com.courier.dao.CourierDao;
import com.courier.model.Courier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        CourierDao dao = (CourierDao) context.getBean("courierDao");

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Courier Management System ====");
            System.out.println("1. Add Courier");
            System.out.println("2. Update Courier");
            System.out.println("3. Delete Courier");
            System.out.println("4. View All Couriers");
            System.out.println("5. View Courier by ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    Courier c = new Courier();

                    System.out.print("Name: ");
                    c.setName(sc.nextLine());

                    System.out.print("Contact: ");
                    c.setContact(sc.nextLine());

                    System.out.print("Region: ");
                    c.setRegion(sc.nextLine());

                    System.out.print("Items Delivered: ");
                    c.setItemsDelivered(sc.nextInt());

                    sc.nextLine(); // consume newline
                    System.out.print("Visit Date (yyyy-mm-dd): ");
                    c.setVisitDate(sc.nextLine());

                    System.out.print("Hours: ");
                    c.setHours(sc.nextDouble());

                    dao.saveCourier(c);
                }

                case 2 -> {
                    System.out.print("Enter Courier ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Courier c = new Courier();

                    c.setCourierId(id); // Assuming ID doesn't change
                    System.out.print("Name: ");
                    c.setName(sc.nextLine());

                    System.out.print("Contact: ");
                    c.setContact(sc.nextLine());

                    System.out.print("Region: ");
                    c.setRegion(sc.nextLine());

                    System.out.print("Items Delivered: ");
                    c.setItemsDelivered(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Visit Date (yyyy-mm-dd): ");
                    c.setVisitDate(sc.nextLine());

                    System.out.print("Hours: ");
                    c.setHours(sc.nextDouble());

                    dao.updateCourier(c, id);
                }

                case 3 -> {
                    System.out.print("Enter Courier ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteCourier(id);
                }

                case 4 -> {
                    List<Courier> list = dao.getAllCouriers();
                    list.forEach(System.out::println);
                }

                case 5 -> {
                    System.out.print("Enter Courier ID to view: ");
                    int id = sc.nextInt();
                    Courier c = dao.getCourierById(id);
                    System.out.println(c);
                }

                case 0 -> System.out.println("Exiting...");

                default -> System.out.println("Invalid choice. Try again!");
            }

        } while (choice != 0);

        sc.close();
    }
}
