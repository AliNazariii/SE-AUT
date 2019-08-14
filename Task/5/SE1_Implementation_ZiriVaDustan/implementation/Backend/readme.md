
1- Install XAMPP

2- Start Apache & MySQL modules

3- Clone project

4- Install composer

5- Run cmd

6- Go to project directory 

7- run "composer update"

8- create a database using 'phpmyadmin' named restaurant

9- run "copy .env.example .env"

10- go to .env file and replace these:
DB_DATABASE=restaurant
DB_USERNAME=root
DB_PASSWORD=

11- run "php artisan migrate"

12- run "php artisan serve"

   SERVER RUNNING NOW
   
    *use postman to make requests to server.
    *URLs style: http://localhost:8000/api/(write here)
    *first use login API to create jwt and then use this token an Bearer token in postman 'Authorization' tab for authentication.
    
