# My Spotify Statistics 

This is a basic project to get in deep with the study of some technologies like _Spring Boot_, combining one of my passions: **music!** :)

Some architectural choices may seem a bit forced, but the goal of this project is also academic (_as well as for fun_).

## Table of Contents

- [Big picture](#Big-picture)
- [Main Features](#Main-Features)
- [API](#API)
- [Spotify Authentication](#Spotify-Authentication)
- [Resources](#Resources)

## Big picture

The application exposes _REST services_ to the user, which in turn recall the APIs exposed by Spotify, after authentication with a personal token. 

## Main Features
The data that can be returned, based on the user profile, are:
- Musical genres
- Artists
- Album

For each of these data, we can filter by:
- Numbers of items in the response, 1 up to 50
- Time range: short, medium and large. 

Every REST call, in and out, is logged into a remote Mongodb service.

## API
### Spotify
  - "artists": "https://api.spotify.com/v1/me/top/artists",
  - "tracks": "https://api.spotify.com/v1/me/top/tracks",
  - "album": "https://api.spotify.com/v1/albums/",
  - "token": "https://accounts.spotify.com/api/token"

### My application
- "artists": "v1/artists"
    - params (optional): artistsNumber, timeRange

    - response:

    ```
    ["Amaral","System Of A Down","Plakkaggio","Black Eyed Peas","Linkin Park","NanowaR of Steel","Disturbed","Marilyn Manson","Faun","Caparezza","Eminem","Rammstein","Metallica","Imagine Dragons","AC/DC","Giancane","Il Muro Del Canto","Negrita","Five Finger Death Punch","883"]
    ```

- "genres": "v1/genres"
    - params (optional): artistsNumber, timeRange

    - response:
    
    ```
    {"rock":"20%","pop":"24%","indie":"2%","rap":"1%","other":"5%","grunge":"1%","metal":"41%","hip pop":"2%"}
    ```


- "tracks": "v1/tracks"
    - params (optional): artistsNumber, timeRange

    - response:
    ```
    ["Reggime er gioco","Nunca volverá","I Nostri Anni","Cuando Suba La Marea","Magari Muori","Run Boy Run","El universo sobre mí","Roundtable Rival","Marta, Sebas, Guille y los demás","B.Y.O.B.","MAMACITA","RITMO (Bad Boys For Life)","Warriors","Walpurgisnacht","Danza dell'autumno rosa","Bam Bam Twist (feat. Gow Tribe, Frenetik&Orang3)","Missione Disagio","Survival","MA IL CIELO E' SEMPRE BLU (ITALIANSTARS4LIFE)","Federkleid"]
    ```

## Spotify Authentication
In order to make REST calls to spotify Apis, we need an authentication TOKEN and a REFRESH TOKEN, in order to make subsequent calls. Please, refer to the ufficial guide: 

https://developer.spotify.com/documentation/general/guides/authorization-guide/

## Technologies/Framework used
- Spring boot 5 
- Java 8
- JUnit
- Remote MongoDB service (for logging calls only) 
- Heroku
- Visual Studio Code

## Tests
Tests are with JUnit, and there are tests for the spotify's APIs results 

## Contribute
Do you want join in the project and contribute? Feel free to fork the project or write me if you want some clarification :) 

## License
MIT ©