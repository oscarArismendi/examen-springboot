# examen-springboot

## Bike

### create
URL: http://127.0.0.1:8080/bike/create
METHOD: POST
```
{
    "precio": 1000.00,
    "stock": 10,
    "model": {
        "id": 1
    },
    "brand": {
        "id": 1
    }
}
````

### Read
URL: http://127.0.0.1:8080/bike/list-all
METHOD: GET
```
````

### Update
URL: http://127.0.0.1:8080/bike/update/1
METHOD: PUT
```
{
    "precio": 2000.00,
    "stock": 20,
    "model": {
        "id": 2
    },
    "brand": {
        "id": 2
    }
}
````

### Delete
URL: http://127.0.0.1:8080/bike/delete/1
METHOD: DELETE
```
````
