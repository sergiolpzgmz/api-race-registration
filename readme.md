
# Race registration API
Api rest to manage the registration of athletes in the different races as well as the information and availability of these.

> [!IMPORTANT]
> This project is under development.
### To do
- Add authentication.

### Usage
As administrator:
- Register a race
- Modify a race
- Delete a race

As a user:
- View available races
- View registered athletes and their basic information
- Register for a race


## Installation
The project is configured to operate on a mysql database called racemanagment.
If you want to test it locally just need to create a database with this name, 
the tables and relations will create themselves. By default, the api runs on port 8080, 
but you can make any configuration you need in src\main\resources\application.properties

## Documentation
To see the full documentation type in your browser: [localhost:8080/api/v1/api-docs](http://localhost:8080/api/v1/api-docs) 
[or click here](http://localhost:8080/api/v1/api-docs) but make sure you are compiling the api first.

### Examples

* Post:
  * /api/v1/race
    ```bash
    curl -X POST localhost:8080/api/v1/race -H 'Content-Type: application/json' -d '{"raceName":"Boston Marathon","raceDate":"20/5/2024","raceLocation":"Boston, USA","raceType":"Running"}'
    ```
* Get:
  * /api/v1/race
    ````bash
    curl localhost:8080/api/v1/races
    ````
  * /api/v1/race/1 
    ````bash
    curl localhost:8080/api/v1/races/1
    ````
* Put:
  * /api/v1/race/2 
    ````bash
    curl -X PUT localhost:8080/api/v1/race/2 -H "Content-Type: application/json" -d '{"raceName":"Boston Marathon","raceDate":"5/5/2024","raceLocation":"unknown","raceType":"Running"}'
    ````
* Delete:
  * /api/v1/race/2
    ````bash
    curl -X DELETE localhost:8080/api/v1/race/2
    ````

## Database design

<div class="container">
        <img src="https://github.com/sergiolpzgmz/api-race-registration/blob/master/docs/diagrama.png" alt="UML" width="600em">
</div>

## Architecture

<div class="container">
        <img src="https://github.com/sergiolpzgmz/api-race-registration/blob/master/docs/architecture.png" alt="UML" width="600em">
</div>

