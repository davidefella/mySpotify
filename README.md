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
- "genres": "v1/genres"
    - params (optional): artistsNumber, timeRange
- "tracks": "v1/tracks"
    - params (optional): artistsNumber, timeRange

### Request Example

### Response

## Spotify Authentication
TO DO

## Resources 
TO- DO (?)


## Screenshots
TO DO

## Technologies/Framework used
TO DO

## Tests
TO DO

## How to use?
TO DO

## Contribute
TO DO

## License
TO DO
