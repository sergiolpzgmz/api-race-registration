
# Race registration API

Api rest to manage the registration of athletes in the different races as well as the information and availability of these.

## Installation

The project is configured to operate on a mysql database called racemanagment.
If you want to test it locally you can configure the
src\main\resources\application.properties

## Usage

As administrator:
- Register a career
- Modify a career
- Suspend/delete a career

As a user:
- View available races
- View registered athletes and their basic information
- Register for a race

## Database design

<div class="container">
        <img src="https://github.com/sergiolpzgmz/api-race-registration/blob/master/docs/diagrama.png" alt="UML" width="600em">
</div>

## Architecture

<div class="container">
        <img src="https://github.com/sergiolpzgmz/api-race-registration/blob/master/docs/architecture.png" alt="UML" width="600em">
</div>

