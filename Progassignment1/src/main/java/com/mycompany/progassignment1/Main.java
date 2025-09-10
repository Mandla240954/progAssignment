/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progassignment1;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class Main {
    public static void main(String[] args) {
        Series seriesManager = new Series();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- TV Series Menu ---");
            System.out.println("1. Capture Series");
            System.out.println("2. Search Series");
            System.out.println("3. Update Series");
            System.out.println("4. Delete Series");
            System.out.println("5. Series Report");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    seriesManager.captureSeries(sc);
                    break;
                case "2":
                    System.out.print("Enter Series ID: ");
                    var s = seriesManager.searchSeries(sc.nextLine());
                    if (s != null) {
                        System.out.printf("Found: %s (%d episodes)\n",
                                s.seriesName, s.seriesNumberOfEpisodes);
                    } else {
                        System.out.println("No series found.");
                    }
                    break;
                case "3":
                    seriesManager.updateSeries(sc);
                    break;
                case "4":
                    seriesManager.deleteSeries(sc);
                    break;
                case "5":
                    seriesManager.seriesReport();
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
