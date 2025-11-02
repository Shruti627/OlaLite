# 🚖 OlaLite – Console-Based Cab Booking System

A feature-rich, **menu-driven Java console application** that simulates an Ola/Uber-like cab booking experience.  
Users can register, log in, book rides, manage favourite locations, and view ride history — all via a clean, Unicode-enhanced console UI.

---

## 💡 Overview

- 📲 User-friendly console UI with a realistic booking simulation  
- 🔐 Secure login with role-based access (Admin / User)  
- ⚙️ Realistic logic: cab availability, ETA, fare calculation, and ride ratings  
- 💻 Built using Core Java with OOP, collections, and exception handling  

---

## 👨‍💻 Core Technologies Used

- **Java Core** (OOP Principles, Collections Framework, Exception Handling)  
- **Console UI** with Unicode icons & formatted text output  
- **Modular Method-Driven Architecture**  
- **Simulated Real-World Logic** (like ETA, cab type logic, fare, ratings)  

---

## 📂 Main Modules

### 1. 🧑‍💼 User Management
- Sign up & log in with validation  
- Email/password verification  
- Role-based access: Admin / User  

### 2. 🚕 Cab Booking
- Choose cab type: Micro, Mini, Prime  
- Enter distance → get fare, cab info & ETA  
- Confirm before booking  

### 3. 📍 Favourite Locations
- Add, remove, or view saved pickup/drop points  
- Reuse saved locations for faster booking  

### 4. 📶 Cab Availability Simulation
- Simulate availability with random logic  
- ETA displayed per cab type  
- Block booking if no cabs are available  

### 5. 🧾 Ride History & Ratings
- View complete ride history  
- Rate rides (1.0 – 5.0 stars)  
- Optional feedback storage  

### 6. ❗ Exception Handling
- Input validation  
- Custom exceptions like `BookingException` for clean error management  

---

## 🔐 OOP Design Highlights

| Class           | Description                                                  |
|----------------|--------------------------------------------------------------|
| `User`          | Stores user credentials and favourite locations             |
| `Ride`          | Holds ride details: fare, cab type, distance, rating, etc.  |
| `BookingService`| Main logic for cab booking, ETA, fare, and availability     |
| `UserService`   | Manages registration, login, and user-specific data         |

---

## 🌟 Extra Features

- ♻️ Reuse favourite locations easily  
- ⭐ Post-ride star rating system  
- 🎲 Randomized real-time cab availability  
- ⏱ ETA displayed per cab type  
- ✨ Well-formatted output for great user experience  

---

## 🚀 How to Run

1. Clone the repository or download the ZIP  
2. Open in **Eclipse** or any Java IDE  
3. Run the entry file: `Main.java`  
4. Follow the interactive menu from the console  

---
## 🎤 Project Presentation

You can view or download the presentation below:  
[📑 Download OlaLite Documentaion ](./OLALiteSummary.pdf)



## 👩‍🎓 Author

**Shruti P. Sangvikar**  
🎓 3rd Year Engineering Student  

---

## 📜 License

This project is open for educational and non-commercial use.

---

