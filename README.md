# ecommerce

El ejercicio se desarrollo en Spring Boot y se utilizo flyway para la migracion de la base de datos h2.
La aplicacion ha sido desplegada en Heroku con la siguiente ruta https://ecommercenap.herokuapp.com/healthcheck y expone los siguientes servicios rest.
Tambien se realizaron test unitarios y de integracion donde se comprobaron los casos de prueba descritos en el ejercicio.

Servicio Find Price.

```bash
Enpoint: https://ecommercenap.herokuapp.com/api/price?dateApplied=2020-06-16-21.00.00&productId=35455&brandId=1
HTTP Method: GET
Response:
Status Code: 200
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 4,
    "startDate": "2020-06-15T16:00:00",
    "endDate": "2020-12-31T23:59:59",
    "price": 38.95
}
```
