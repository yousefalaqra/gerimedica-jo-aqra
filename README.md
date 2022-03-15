# gerimedica-jo-aqra


## Architecture
Inspired by: https://beyondxscratch.com/2017/08/19/hexagonal-architecture-the-practical-guide-for-a-clean-architecture/



## Installation & Running the app

1. Make Clone of the repository in your local mahine using git
```
git clone https://github.com/yousefalaqra/gerimedica-jo-aqra.git
```

2. Navigate to the project directory and run the app with Maven:
```
 mvn spring-boot:run
```

3. Using postman or your favorite HTTPClient you can send an HTTP requests to the following endpoints


| Description   |  HTTP Verb | Request URL | Paramters | Body |
| ------------- | ------------- | ------------- | ------------- | ------------- |
| Upload exercises csv  | POST  | http://localhost:8080/api/exercises/upload | N/A | form-data `file` |
| Fetch all exercises | GET  | http://localhost:8080/api/exercises/all | N/A | N/A |
| Fetch exercise by code | GET  | http://localhost:8080/api/exercise | code e.g `code=271636001` | N/A |
| Delete all exercises  | DELETE  | http://localhost:8080/api/exercises | N/A | N/A |


## Contributions and future improvements
1. Unit tests implementation 
2. HTTP Responses handling 
3. Exception handling
