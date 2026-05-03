# Gym Membership Management System

## Team Members & Roles
**Team ID: C9**
*   **Nithilan S** (AM.SC.U4CSE25262) - [Identified the classes and helped create uml diagrams]
*   **Dharun A** (AM.SC.U4CSE25215) - [Helped in creating github repo and proof reading the code]
*   **Sujeeth S** (AM.SC.U4CSE25253) - [Helped in implementation]
*   **Nithish Kumar Saravanan** (AM.SC.U4CSE25239) - [Developed the user interaction and console interface]

## Problem Description
The Gym Membership Management System is a Java-based application designed to manage gym member and trainer information efficiently. It helps store details such as member ID, name, contact information, membership plans, and assigned trainers. The system allows the administrator to add members, assign specialized trainers, generate revenue reports, and remove expired memberships. Furthermore, the system integrates Java standard I/O libraries to enable data persistence, allowing the administrator to save and load member records to and from a local text file seamlessly. This project demonstrates the practical application of Object-Oriented Programming (OOP) concepts, including abstract classes, inheritance, composition, and file handling.

## How to Run the Code
1. Clone the repository to your local machine.
2. Open the project in a Java IDE (such as Eclipse, IntelliJ IDEA, or VS Code).
3. Ensure all Java files in the `/src` folder (`Main.java`, `Person.java`, `Member.java`, `Trainer.java`, `MembershipPlan.java`, `GymManager.java`) are placed within the same package (e.g., `package Gym_management_system;`).
4. Compile and run the `Main.java` file.
5. Follow the interactive console menu to navigate the system.

## Tools and Technologies Used

* **Programming Language:** Java (JDK)
* **Libraries:** `java.util.Scanner`, `java.util.Date`, `java.util.Calendar`, `java.io.*`
* **Development Environment:** Eclipse IDE
* **Design Tools:** UML Modeling (Mermaid for Use Case, Class, and Sequence Diagrams)
* **Version Control:** Git & GitHub

## Sample Input/Output
*(Please refer to the `/output` folder for comprehensive console screenshots. Below is a brief interactive example.)*
```text
--- GYM MANAGEMENT SYSTEM ---
1.Register Member
2.Find Member
3.Remove Expired Members
4.Revenue Report
5.Show All Members
6.Show All Trainers
7.Save to File
8.Load from File
9.Exit
Enter choice: 
1
1.Monthly 2.Quarterly 3.Yearly

1
ID: M001
Name: Nithilan S
Phone: 9876543210
Email: nithilan@amrita.edu
Successfully registered: M001
Assign Trainer? 1.Yes 2.No
1
1.FatLoss 2.Bodybuilding 3.Strength 4.General
2
Nithilan S assigned to trainer Bodybuilding Trainer
--- Schedule for Bodybuilding Trainer ---
Specialization: Bodybuilding
Currently training 1 members.

--- GYM MANAGEMENT SYSTEM ---
1.Register Member
2.Find Member
3.Remove Expired Members
4.Revenue Report
5.Show All Members
6.Show All Trainers
7.Save to File
8.Load from File
9.Exit
Enter choice: 
4
--- Gym Revenue Report ---
Total Members: 1
Total Revenue Collected: $50.0
--------------------------

--- GYM MANAGEMENT SYSTEM ---
...
Enter choice: 
7
Data successfully saved to gym_members.txt

