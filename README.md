# 🏨 Hotel Management System

A complete **desktop-based Hotel Management System** built using **Java (Swing GUI)**, **JDBC**, and **MySQL**. This project is a self-driven simulation of real hotel operations, including real-time guest handling, room tracking, and admin-level features.

> ✨ **Project Period:** June 2024
> ☑⃣ **Developed by:** Vedant Patil
> 🔗 **GitHub:** [Hotel Management System](https://github.com/vedantmpatil/Hotel-Management-System-)

---

## ✨ Features

### 👨‍� Reception Interface

* Real-time **room availability tracking**
* Guest **Check-In** / **Check-Out** workflows
* Booking interface with customer details
* **Cab Pickup Services** management
* Room search & filter functionality

### 💼 Admin Panel

* Employee management (Add, view, assign roles)
* Manager-only feature access
* Room editing and status updates

### 🛋️ Utility Modules

* View all customers with booking records
* Manage rooms: availability, prices, types
* Dashboard panel with quick shortcuts

---

## ⚖️ Tech Stack

| Layer        | Technology       |
| ------------ | ---------------- |
| Language     | Java (JDK 17)    |
| GUI          | Swing (Java GUI) |
| Database     | MySQL            |
| Connectivity | JDBC             |
| IDE          | IntelliJ IDEA    |

---

## 📁 Folder Structure

```
Hotel-Management-System/
├── src/
│   └── Hotel/Management/System/
│       ├── Admin.java
│       ├── AdminLogin.java
│       ├── CheckIn.java
│       ├── CheckOut.java
│       ├── Connectiondb.java
│       ├── CustomerInfo.java
│       ├── Dashboard.java
│       ├── Employee.java
│       ├── Login.java
│       ├── Reception.java
│       ├── Room.java
│       ├── Splash.java
│       ├── UpdateRoom.java
│       ├── ... (more UI modules)
│
├── out/production/Hotel Management/ (compiled .class files)
├── .idea/, Hotel Management.iml (IDE configs)
```

---

## 🚀 How to Run

### ✏️ Prerequisites

* Java JDK (17 or above recommended)
* MySQL Server running
* IntelliJ IDEA or any Java IDE

### 📂 Database Setup

1. Create a MySQL database: `hotel`
2. Import the required tables and sample data from SQL dump (not included here)
3. Update DB credentials inside `Connectiondb.java`

```java
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "yourpassword");
```

### 🔧 Run the App

* Open project in IntelliJ IDEA
* Run `Splash.java` or `Login.java` as the main class
* Use dummy credentials (e.g., admin/admin) to log in



## 📚 Learning Outcomes

* Swing-based GUI design for business applications
* JDBC integration for real-time MySQL operations
* Role-based access control and data flow
* Managing multiple UI modules and state transitions

---



## 🚀 Contribution

This was a **solo project**, but contributions via forks or suggestions are always welcome!

---

## 😊 Author

**Vedant Patil**
GitHub: [@vedantmpatil](https://github.com/vedantmpatil)

---

## ✨ Star it if you found it useful!

```bash
git clone https://github.com/vedantmpatil/Hotel-Management-System-
```
