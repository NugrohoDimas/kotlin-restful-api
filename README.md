#API Spesifikasi

## Authentication
Semua API harus memakai authentication

Request :
- Header :
    - Api-Key : "your api key"

## Crerate Product

Request :
- Method : POST
- Endpoint : `/api/products`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :
```json
{
  "id" : "string, unique",
  "name" : "string",
  "price" : "long",
  "quantity" : "integer"
}
```
Respond :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
     "id" : "string, unique",
      "name" : "string",
      "price" : "long",
      "quantity" : "integer",
      "createdAt" : "date",
      "updatedAt" : "date"
  }
}
```

## Get Product
Request :
- Method : GET
- Endpoint : `/api/products/{id_product}`
- Header :
    - Accept : application/json

Respond :
{
  "code" : "number",
  "status" : "string",
  "data" : {
     "id" : "string, unique",
      "name" : "string",
      "price" : "long",
      "quantity" : "integer",
      "createdAt" : "date"
  }
}

## Update Product
Request :
- Method : PUT
- Endpoint : `/api/products/{id_product}`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :
```json
{
  "id" : "string, unique",
  "name" : "string",
  "price" : "long",
  "quantity" : "integer"
}
```

Respond :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
      "id" : "string, unique",
      "name" : "string",
      "price" : "long",
      "quantity" : "integer",
      "createdAt" : "date",
      "updatedAt" : "date"
  }
}
```

## List Product
Request :
- Method : GET
- Endpoint : `/api/products`
- Header :
    - Accept : application/json
- Query Param :
    - size : number,
    - page : number

Respond :
```json
{
    "code" : "number",
    "status" : "string",
    "data" : [
    {
      "id" : "string, unique",
      "name" : "string",
      "price" : "long",
      "quantity" : "integer",
      "createdAt" : "date",
      "updatedAt" : "date"
    },
    {
      "id" : "string, unique",
      "name" : "string",
      "price" : "long",
      "quantity" : "integer",
      "createdAt" : "date",
      "updatedAt" : "date"
    }
    ]
    
}   
```

## Delete Product
Request :
- Method : DELETE
- Endpoint : `/api/products/{id_product}`
- Header :
    - Accept : application/json

Respond :
```json
{
    "code" : "number",
    "status" : "string"
}   
```