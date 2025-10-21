# Database Schema Design (MySQL)

## 1. Overview
This database is designed for a hospital management system with three main user roles:
- **Admin**
- **Doctor**
- **Patient**

The system manages appointments, medical records, and user authentication.

---

## 2. Entity Relationship Diagram (ERD)
[Users]──<1------N>──[Doctors]
│
└──<1------N>──[Patients]

[Doctors]──<1------N>──[Appointments]──<N------1>──[Patients]
[Appointments]──<1------1>──[Medical_Records]

---

## 3. Tables Design

### 3.1. `users`
| Field | Type | Constraints | Description |
|--------|------|-------------|--------------|
| user_id | INT | PRIMARY KEY, AUTO_INCREMENT | Unique user ID |
| username | VARCHAR(50) | UNIQUE, NOT NULL | Login username |
| password | VARCHAR(255) | NOT NULL | Hashed password |
| role | ENUM('Admin','Doctor','Patient') | NOT NULL | Defines user type |

---

### 3.2. `doctors`
| Field | Type | Constraints | Description |
|--------|------|-------------|--------------|
| doctor_id | INT | PRIMARY KEY, AUTO_INCREMENT | Doctor ID |
| user_id | INT | FOREIGN KEY REFERENCES `users(user_id)` | Linked user account |
| specialty | VARCHAR(100) | NOT NULL | Doctor’s specialty |

---

### 3.3. `patients`
| Field | Type | Constraints | Description |
|--------|------|-------------|--------------|
| patient_id | INT | PRIMARY KEY, AUTO_INCREMENT | Patient ID |
| user_id | INT | FOREIGN KEY REFERENCES `users(user_id)` | Linked user account |
| date_of_birth | DATE | | Patient’s birth date |
| address | VARCHAR(255) | | Patient’s address |

---

### 3.4. `appointments`
| Field | Type | Constraints | Description |
|--------|------|-------------|--------------|
| appointment_id | INT | PRIMARY KEY, AUTO_INCREMENT | Appointment ID |
| doctor_id | INT | FOREIGN KEY REFERENCES `doctors(doctor_id)` | Assigned doctor |
| patient_id | INT | FOREIGN KEY REFERENCES `patients(patient_id)` | Assigned patient |
| appointment_date | DATETIME | NOT NULL | Appointment date/time |
| status | ENUM('Scheduled','Completed','Cancelled') | DEFAULT 'Scheduled' | Appointment status |

---

### 3.5. `medical_records`
| Field | Type | Constraints | Description |
|--------|------|-------------|--------------|
| record_id | INT | PRIMARY KEY, AUTO_INCREMENT | Medical record ID |
| appointment_id | INT | FOREIGN KEY REFERENCES `appointments(appointment_id)` | Related appointment |
| notes | TEXT | | Doctor’s notes |
| prescription | TEXT | | Medication prescribed |

---

## 4. Relationship Summary
- A **User** can be a **Doctor** or **Patient**.  
- A **Doctor** can have multiple **Appointments**.  
- A **Patient** can have multiple **Appointments**.  
- Each **Appointment** links one **Doctor** and one **Patient**.  
- Each **Appointment** can have one **Medical Record**.

---

## 5. Example SQL Schema

```sql
CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role ENUM('Admin','Doctor','Patient') NOT NULL
);

CREATE TABLE doctors (
  doctor_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  specialty VARCHAR(100) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE patients (
  patient_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  date_of_birth DATE,
  address VARCHAR(255),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE appointments (
  appointment_id INT AUTO_INCREMENT PRIMARY KEY,
  doctor_id INT,
  patient_id INT,
  appointment_date DATETIME NOT NULL,
  status ENUM('Scheduled','Completed','Cancelled') DEFAULT 'Scheduled',
  FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
  FOREIGN KEY (patient_id) REFERENCES patients(patient_id)
);

CREATE TABLE medical_records (
  record_id INT AUTO_INCREMENT PRIMARY KEY,
  appointment_id INT,
  notes TEXT,
  prescription TEXT,
  FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
);
