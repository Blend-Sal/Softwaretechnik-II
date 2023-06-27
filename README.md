
The AStA-Shop is a retail establishment situated in Building 25 of TH-Lübeck, specializing in artisanal baked goods and other culinary delights. 
Our objective was to enhance convenience and innovation by providing an online platform for product creation and reservation and much more!

======================================================================================================================================================
Application Part:

To start the application, the prerequisite is to have Docker Desktop installed, which will allow us to run the application within a containerized environment, including a MySQL database. Here are the step-by-step instructions:

    Install Docker Desktop.
    Pull the MySQL image.
    Execute the following command: docker run --name SWT2 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d mysql
    And if a pop appears with "Enable Annotation Proccesing" click on enable.
    In Intellij you have to create a Database with following attributes:
        1. Open IntelliJ IDEA and go to the Database tool window.
        2. Click on the plus sign (+) or the "Add Data Source" button.
        3. Select the database type MySQL.
        4. Enter the host (127.0.0.1), username (root), and password (1234).
        5. Save the data source, be sure that the docker container runs.
        6. Right-click on the created data source and "New Database".
        7. Enter the name "asta-shop" for the database.
        8. Save the changes.
    then you have to create a database named "asta-shop".
    If necessary, manually start the container SWT2 if it doesn't start automatically.

Following these steps, the application will be ready to run.
And don't forget to change your SDK to Oracle OpenJDK version 17 or higher.

