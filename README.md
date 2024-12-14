# Πλατφόρμα Υιοθεσίας Κατοικίδιων



## **Χαρακτηριστικά**
- Διαχείριση ρόλων χρηστών: Διαχειριστής, Καταφύγιο, Κτηνίατρος, Πολίτης (Υιοθέτης).
- Καταχώριση κατοικίδιων και διαχείριση της κατάστασης υιοθεσίας τους.
- Υποβολή και επεξεργασία αιτήσεων υιοθεσίας.
- Ασφαλής αυθεντικοποίηση και διαχείριση πρόσβασης με χρήση **Spring Security**.
- RESTful API για απρόσκοπτη ενσωμάτωση με το frontend.

---
## **Τεχνολογίες που Χρησιμοποιούνται**
- **Java 17**
- **Spring Boot** (Web, Data JPA, Security)
- **PostgreSQL**
- **Swagger/OpenAPI** για τεκμηρίωση API
- **Maven** για διαχείριση εξαρτήσεων

---

## **Οδηγός Εγκατάστασης**

### **Απαραίτητα Προαπαιτούμενα**
1. **Java Development Kit (JDK)** 17 ή νεότερο.
2. **PostgreSQL** εγκατεστημένο και σε λειτουργία.
3. **Maven** εγκατεστημένο για διαχείριση εξαρτήσεων.
4. Ένα IDE, όπως το **IntelliJ IDEA** ή το **Eclipse** (προτείνεται).

---

### **Οδηγίες Ρύθμισης**

#### 1. Κλωνοποίηση του Αποθετηρίου
```bash
https://github.com/JimHD-ai/pet-adoption-platform.git
cd pet-adoption-platform
```

#### 2. Διαμόρφωση της Βάσης Δεδομένων
- Δημιουργήστε μια βάση δεδομένων PostgreSQL με όνομα `pet_adoption`.
- Ενημερώστε το αρχείο `application.properties` με τα στοιχεία πρόσβασης στη βάση δεδομένων σας:
  ```properties
  spring.datasource.url=jdbc:postgresql://localhost:5432/pet_adoption
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  ```

  ## **Δομή Έργου**
- **`src/main/java/com/example/petadoption`**
  - `entity`: Περιέχει τις κλάσεις μοντέλων δεδομένων (π.χ., `User`, `Pet`, `AdoptionRequest`).
  - `repository`: Διεπαφές Spring Data JPA για λειτουργίες βάσης δεδομένων.
  - `controller`: REST controllers για τη διαχείριση των API endpoints.
  - `PetAdoptionApplication.java`: Το βασικό σημείο εκκίνησης της εφαρμογής.
- **`src/main/resources/application.properties`**: Αρχείο ρυθμίσεων για τη βάση δεδομένων και την εφαρμογή.

---

## **Endpoints**
### Endpoints Χρηστών
- **GET** `/api/users`: Λήψη όλων των χρηστών.
- **POST** `/api/users`: Δημιουργία νέου χρήστη.

### Endpoints Κατοικίδιων
- (Σύντομα διαθέσιμα)

### Endpoints Αιτήσεων Υιοθεσίας
- (Σύντομα διαθέσιμα)

---
