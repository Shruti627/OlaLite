package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ride 

{
    private static int counter = 1001;
    private final int rideId;
    
    private String cabType;
    private String pickup;
    private String drop;
    private double distance;
    private double fare;
    private String timestamp;
    
    private Double rating = null;
    
    private String status = "Completed"; 


    
    public Ride(String cabType, String pickup, String drop, double distance, double fare) {
        this.rideId = counter++;
        this.cabType = cabType;
        this.pickup = pickup;
        this.drop = drop;
        this.distance = distance;
        this.fare = fare;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public int getRideId() {
        return rideId;
    }

    public String getCabType() {
        return cabType;
    }

    public String getPickup() {
        return pickup;
    }

    public String getDrop() {
        return drop;
    }

    public double getDistance() {
        return distance;
    }

    public double getFare() {
        return fare;
    }

    public String getTimestamp() {
        return timestamp;
    }
   

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void displayRide() {
    	Scanner sc = new Scanner(System.in);
        System.out.println("┌────────────────────────────────────────────────┐");
        System.out.println("| 🚖             OlaLite Ride Summary            |");
        System.out.println("├────────────────────────────────────────────────┤");
        System.out.println("| 🆔 Ride ID     : " + String.format("%-30s", rideId)    + "|");
        System.out.println("| 🚗 Cab Type    : " + String.format("%-30s", cabType)   + "|");
        System.out.println("| 🛫 Pickup      : " + String.format("%-30s", pickup)    + "|");
        System.out.println("| 🛬 Drop        : " + String.format("%-30s", drop)      + "|");
        System.out.println("| 📏 Distance    : " + String.format("%-30s", distance + " km") + "|");
        System.out.println("| 💰 Fare        : ₹" + String.format("%-29s", String.format("%.2f", fare)) + "|");
        System.out.println("| ⏰ Timestamp   : " + String.format("%-30s", timestamp) + "|");
        System.out.println("| 📌 Status      : " + String.format("%-30s", status)    + "|");
        System.out.println("└────────────────────────────────────────────────┘");
//        Scanner sc = new Scanner(System.in);
        System.out.print("⭐ Rate your ride (1.0 to 5.0): ");
        double inputRating;
        while (true) {
            inputRating = sc.nextDouble();
            sc.nextLine();
            if (inputRating >= 1.0 && inputRating <= 5.0) {
                break;
            } else {
                System.out.print("❌ Invalid rating. Please enter a value between 1.0 and 5.0: ");
            }
        }
        this.setRating(inputRating);
        System.out.println("✅ Thank you for your feedback!");


    }

   

 
}
