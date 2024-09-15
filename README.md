# Record Shop API Project
![API Version 1](https://img.shields.io/badge/API-v1.0-blue?style=flat-square)

***

![Java Badge](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven Badge](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Spring Badge](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate Badge](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![PostgreSQL Badge](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

***

A RESTful backend API designed for a record shop.
It allows a record shop employee to store, update and query 
information about albums, enabling retrieval of filtered 
album results. 

***

- [Set Up and Configuration](#set-up-and-configuration)
- [How to Use](#how-to-use)
  - [Adding Data](#adding-data)
    - [Adding an Album](#adding-an-album)
    - [Adding an Artist](#adding-an-artist)
    - [Assigning an Artist to an Album](#assigning-an-artist-to-an-album)
- [Query Endpoints](#query-endpoints)
  - [GET All Albums](#get-all-albums)
  - [GET Album by ID](#get-album-by-id)
  - [GET All Artists](#get-all-artists)
  - [GET Artist by ID](#get-artist-by-id)
  - [GET Albums with Stock](#get-albums-with-stock)
  - [GET Albums by Release Year](#get-albums-by-release-year)
  - [Get Albums by Genre](#get-albums-by-genre)
  - [Get Album by Name](#get-album-by-name)
- [Future Considerations](#future-considerations)
- [Additional Information](#additional-information)
  - [Genre ENUM Categories](#genre-enum-categories)

***

## Set Up and Configuration

To run this project you will require:
- An IDE (Integrated Development Environment), such as IntelliJ 
IDEA
- Java 21
- A RDBMS (Relational Database Management System), such as
Postgres

It is also recommended to have software such as Postman or 
pgAdmin in order to be able to check stored data, though a browser 
(such as chrome) will work.

For security there are currently no included `application.properties` files 
included in the repository, these will need to be manually created
within the resources package with the relevant RDBMS configuration 
information.

***

## How to Use

Ensure the application is open and running.
The database will create two tables:

**Albums**

| id [PK] | album_art | album_name | genre | quantity_in_stock | release_year | track_list | artist_id |
|---------|-----------|------------|-------|-------------------|--------------|------------|-----------|
|         |           |            |       |                   |              |            |           | 

**Artists**

| id [PK] | artist_name |
|---------|-------------|
|         |             |

### Adding Data

#### Adding an Album

1) Open postman and create a new POST request to the following
endpoint:

    `http://localhost:8080/api/v1/album`

2) Under "Body" Select **raw** and ensure the type is set to **JSON**. Use the following format:
    ```JSON
    {
    "albumName": "Nevermind",
    "genre": "ALT_ROCK_AND_INDIE",
    "albumArt": "PH",
    "trackList": "PH",
    "releaseYear": 1991,
    "quantityInStock": 10
    }
    ```

    >**NOTE:** 
    >  
    >The Genre field has been defined as an ENUM to restrict values 
    to a predefined set, ensuring data consistency. As such any values passed to this field must match one of these predefines
    genres exactly.The selected genres 
    have been carefully considered to represent a wide range of music styles. [See the genre list here.](#genre-enum-categories) 

3) Click **Send**. You should receive a response that looks like:

    ```JSON
    {
    "id": 1,
    "albumName": "Nevermind",
    "artist": null,
    "genre": "ALT_ROCK_AND_INDIE",
    "albumArt": "PH",
    "trackList": "PH",
    "releaseYear": 1991,
    "quantityInStock": 10
    }
    ```

#### Adding an Artist

1) Create a new POST request to the following endpoint:

    `http://localhost:8080/api/v1/artist`

2) Use the following JSON format for the body:
    ```JSON
    {
      "artistName": "Nirvana",
      "albums": []
    }
    ```
3) Click **Send**. You should receive a response that looks like:

    ```JSON
    {
    "id": 1,
    "artistName": "Nirvana"
    }
    ```

#### Assigning an Artist to an Album

1) Make a new PUT request to the following endpoint:
`http://localhost:8080/api/v1/album/{Album_ID}/artist/{Artist_ID}`
    >**NOTE:**
    >
    > Make sure to replace {Album_ID} and {Artist_ID} with actual ID's
     (These can be found in the POST request responses).

2) Repeat for other Albums and Artists. 



### Query Endpoints

>**NOTE:**
> 
> Remember to insert the correct values within `{ }`.


#### GET All Albums:
Returns all Albums <br>
`http://localhost:8080/api/v1/album/all-albums`

#### GET Album by ID:
Returns the Album with the corresponding ID number <br> 
`http://localhost:8080/api/v1/album/{Album_ID}`

#### GET All Artists:
Returns all Artists <br>
`http://localhost:8080/api/v1/artist/all-artists`

#### GET Artist by ID:
Returns the Artist with the corresponding ID number <br>
`http://localhost:8080/api/v1/artist/{Artist_ID}`

#### GET Albums with Stock:
Returns all the Albums with at least 1 Quantity In Stock <br>
`http://localhost:8080/api/v1/album/in-stock`

#### GET Albums by Release Year:
Returns all the albums released in the corresponding Year <br>
`http://localhost:8080/api/v1/album/year/{Year}`

##### GET Albums by Genre:
Returns all the Albums in the corresponding Genre <br>
`http://localhost:8080/api/v1/album/genre/{Genre}`
>Genre must exactly match one of the predefined values, found [here.](#genre-enum-categories)

#### GET Album by Name:
Returns the Album with the corresponding Title
`http://localhost:8080/api/v1/album/album-name/{Album_Name}`
>Album Name must exactly match to one within the stored data. 
>Spaces will need to be passed as `%20`
> 
>For example:<br> 
`http://localhost:8080/api/v1/album/album-name/Follow%20The%20Leader` 

***

### Future Considerations

***

### Additional Information
#### Genre ENUM Categories:

```Java
public enum SuperGenre {
    INDUSTRIAL_AND_GOTHIC, 
    HEAVY_METAL,
    ROCK_N_ROLL, 
    CLASSIC_ROCK,
    PUNK_WAVE,
    HARDCORE_PUNK,
    ALT_ROCK_AND_INDIE,
    CONTEMPORARY_ROCK,
    POP_MUSIC,
    COUNTRY,
    R_N_B,
    BLUES,
    GOSPEL,
    JAZZ,
    REGGAE,
    HIP_HOP,
    BREAKBEAT,
    DRUM_N_BASS,
    HARDCORE_TECHNO,
    TECHNO,
    HOUSE,
    TRANCE,
    AMBIENT,
    UTILITY,
    FOLK,
    CLASSICAL,
    WORLD
}
```