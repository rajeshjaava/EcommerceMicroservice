# EcommerceMicroservice

Use case : 

1. Develop micro service for creating, updating, retriving the products ( stationaryProducts, electronic products, grocerry , others)
2. Create Micro service for Product pricing
3. Create Micro Service for product discounts
4. Create another micro service to call above services


1. http://localhost:8080/product/updateProduct/1
2. http://localhost:8080/product/getProduct/1
3.http://localhost:8080/product/createProduct

body:

{
"productId": 1,
"productName": "tv",
"productType": "grocery"
}
