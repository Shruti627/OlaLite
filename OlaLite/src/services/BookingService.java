package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.BookingException;
import models.Ride;

public class BookingService {
    private Map<String, List<Ride>> rideHistory = new HashMap<>();

    public Ride bookRide(String userEmail, String cabType, String pickup, String drop, double distance) throws BookingException {
        if (distance <= 0) {
            throw new BookingException("Distance must be positive.");
        }

        double rate = getRatePerKm(cabType);
        if (rate == 0) {
            throw new BookingException("Invalid cab type selected.");
        }

        double fare = distance * rate;

        Ride ride = new Ride(cabType, pickup, drop, distance, fare);
        rideHistory.computeIfAbsent(userEmail, k -> new ArrayList<>()).add(ride);

        return ride;
    }


    private double getRatePerKm(String cabType) {
        switch (cabType.toLowerCase()) {
            case "micro":
                return 10;
            case "mini":
                return 15;
            case "prime":
                return 20;
            default:
                return 0; 
        }
    }

    public List<Ride> getRideHistory(String userEmail) {
        return rideHistory.getOrDefault(userEmail, new ArrayList<>());
    }
    

    
}
