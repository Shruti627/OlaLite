# 🚖 OlaLite – Console-Based Cab Booking System

A feature-rich, **menu-driven Java console application** simulating an Ola/Uber-like cab booking experience. Users can register, log in, book rides, rate them, manage favourite locations, and view ride history — all through a clean, Unicode-enhanced console interface.

---

## 💡 Overview

- 📲 User-friendly console UI with realistic ride booking simulation  
- 🔐 Modular, object-oriented design using Java  
- ⚙️ Real-world logic like cab availability, fare calculation, and role-based access  

---

## 👨‍💻 Core Technologies Used

- **Java Core** (OOP, Collections, Exception Handling)  
- **Console UI** with Unicode icons and clean formatting  
- **Method-driven Modular Design**  
- **Realistic Logic Simulation** (ETA, availability, rating, etc.)  

---

## 📂 Main Modules

### 1. User Management
- 📝 Sign up / Log in  
- 📧 Email & password validation  
- 👤 Role-based access (Admin / User)  

### 2. Cab Booking
- 🚗 Choose cab type: Micro / Mini / Prime  
- 📏 Enter distance (km) for fare calculation  
- 🧾 Fare shown with ETA and cab info  
- 🧾 Confirmation before final booking  

### 3. Favourite Locations
- 📍 Add / Remove / View saved locations  
- ♻️ Reuse locations for pickup/drop  

### 4. Cab Availability Simulation
- 🎲 Random cab availability check per type  
- ⏱ ETA shown per cab  
- ❌ Booking blocked if unavailable  

### 5. Ride History & Ratings
- 📜 View complete past ride list  
- ⭐ Rate each ride (1.0 – 5.0)  
- 🗣 Store feedback for each ride  

### 6. Exception Handling
- ❗ Graceful input validation  
- 🔐 Custom exceptions like BookingException  

---

## 🔐 OOP Design

- `User` class: Stores user data & favourites  
- `Ride` class: Holds ride info (ID, fare, cab, rating, etc.)  
- `BookingService`: Handles all ride logic  
- `UserService`: Manages login, registration, and user-specific data  

---

## 🌟 Extra Features

- ♻️ Smart reuse of favourite locations  
- ⭐ Post-ride rating system  
- 🎲 Real-time cab availability logic  
- ⏱ ETA display based on cab type  
- ✨ Clean, professional console output with formatting/icons  

---

## 🚀 How to Run

1. Clone the repo or download the ZIP  
2. Open the project in **Eclipse**  
3. Compile and run `Main.java`  
4. Follow the console menu to interact with the system  

---

## 🧑‍🎓 Author

**Shruti Parikshit Sangvikar**  
🎓 3rd Year Engineering student


---


