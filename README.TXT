------------------------------------------------------------------------
Library Management System 
------------------------------------------------------------------------
 
   Overview
 
The Library Management System is a basic application designed to help manage books and users in a library. This system provides core functionalities like adding new books, managing users, and handling exceptions during operations.
 
   Components
 
    1.    Book   
   The Book class is responsible for handling book-related information such as the book's title, author, ISBN, and availability status. This class contains methods to create, modify, and retrieve book details.
 
    2.    User   
   The  User  class manages library users. This includes user details such as their name, membership status, and borrowed books. This class can handle user creation and management of borrowing or returning books.
 
    3.    UserService   
   The  UserService  class is a service layer that interacts with the  User  class. It provides additional functionalities such as user registration, updating user profiles, and tracking borrowed books. It is the interface between the application and user-related logic.
 
    4.    BookService   
   The  BookService  class handles all operations related to books. It interacts with the  Book  class to perform operations like adding new books to the library, removing books, or checking the availability of specific books. This class ensures that business logic is applied before any modification of book data.
 
    5.    LibraryController   
   The  LibraryController  class is the central point of control. It manages communication between  BookService ,  UserService , and the overall application. The controller ensures that requests are routed to the correct services and responses are processed accordingly. It manages the flow of the entire system.
 
    6.    LibraryException   
   The  LibraryException  class is used to handle any errors that might occur during the execution of library operations. This could include cases such as attempting to borrow a book that is unavailable or trying to register a user with incomplete data. This class ensures the system handles errors gracefully.
 
    7.    Application   
   The  Application  class acts as the entry point for the system. It initializes the necessary components and triggers the user interface (if any). This class contains the  main  method, which runs the application.
 
   Key Features
-    Book Management   : Add, remove, and check the availability of books.
-    User Management   : Register new users, update profiles, and track borrowed books.
-    Error Handling   : Graceful handling of common library errors such as book unavailability or invalid user operations.
 
   Usage
 
1.    Adding a Book   : Use the  BookService  to add new books into the system.
2.    Registering a User   : The  UserService  class allows for registering new library members.
3.    Borrowing a Book   : Through the  LibraryController , users can borrow or return books, provided that they are available.
 
   Future Enhancements
- Adding a graphical user interface for easier interaction.
- Enhancing search functionality for books by multiple parameters.
- Implementing a system for fines and fees for overdue books.
