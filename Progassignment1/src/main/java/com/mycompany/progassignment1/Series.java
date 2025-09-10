/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Series {
    private List<SeriesModel> seriesList = new ArrayList<>();

    public void captureSeries(Scanner sc) {
        System.out.print("Enter Series ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Series Name: ");
        String name = sc.nextLine();

        int age = getValidAge(sc);
        System.out.print("Enter Number of Episodes: ");
        int episodes = Integer.parseInt(sc.nextLine());

        seriesList.add(new SeriesModel(id, name, age, episodes));
        System.out.println("Series saved successfully!");
    }

    private int getValidAge(Scanner sc) {
        int age = -1;
        while (true) {
            System.out.print("Enter Age Restriction (2–18): ");
            try {
                age = Integer.parseInt(sc.nextLine());
                if (age >= 2 && age <= 18) break;
                System.out.println("Invalid age restriction. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
        return age;
    }

    public SeriesModel searchSeries(String id) {
        for (SeriesModel s : seriesList) {
            if (s.seriesId.equalsIgnoreCase(id)) return s;
        }
        return null;
    }

    public void updateSeries(Scanner sc) {
        System.out.print("Enter Series ID to update: ");
        String id = sc.nextLine();
        SeriesModel s = searchSeries(id);
        if (s != null) {
            System.out.print("New Name: ");
            s.seriesName = sc.nextLine();
            s.seriesAge = getValidAge(sc);
            System.out.print("New Number of Episodes: ");
            s.seriesNumberOfEpisodes = Integer.parseInt(sc.nextLine());
            System.out.println("Series updated successfully!");
        } else {
            System.out.println("No series found with that ID.");
        }
    }

    public void deleteSeries(Scanner sc) {
        System.out.print("Enter Series ID to delete: ");
        String id = sc.nextLine();
        SeriesModel s = searchSeries(id);
        if (s != null) {
            System.out.print("Are you sure you want to delete? (Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("Y")) {
                seriesList.remove(s);
                System.out.println("Series deleted.");
            }
        } else {
            System.out.println("No series found with that ID.");
        }
    }

    public void seriesReport() {
        System.out.println("\n--- Series Report ---");
        for (SeriesModel s : seriesList) {
            System.out.printf("ID: %s | Name: %s | Age: %d | Episodes: %d\n",
                    s.seriesId, s.seriesName, s.seriesAge, s.seriesNumberOfEpisodes);
        }
    }
}
