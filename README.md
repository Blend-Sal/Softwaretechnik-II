
The AStA-Shop is a retail establishment situated in Building 25 of TH-Lübeck, specializing in artisanal baked goods and other culinary delights. 
Our objective was to enhance convenience and innovation by providing an online platform for product creation and reservation and much more!

======================================================================================================================================================
Application Part:

To start the application, the prerequisite is to have Docker Desktop installed, which will allow us to run the application within a containerized environment, including a MySQL database. Here are the step-by-step instructions:

    Install Docker Desktop.
    Pull the MySQL image.
    Execute the following command: docker run --name SWT2 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d mysql
    If necessary, manually start the container SWT2 if it doesn't start automatically.

Following these steps, the application will be ready to run.
