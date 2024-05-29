## Swagger
you can find APIs in {rootUrl}/

## JWT AUTH
`{
"email": "user@test.com",
"password": "user"
}`

## Gaming equipment rental price calculation API
For a gaming equipment rental service app we need an API to be able to calculate prices for rent.

### Glossary
* commitment:
    * a number of months that the user promises to rent the equipment for, e.g. none, 3 months, 6 months

### Use cases
* API users can get a list of gaming equipment for rent (consoles, VR devices etc)
* API users can choose a single product and get it's title and possible commitment options
* API users can calculate the total price for the chosen rental period, if they provide: 
    * the chosen product
    * the chosen commitment time (number)
    * optionally, the number of months after which they will return the equipment 

### Equipment types and price
Our product catalog:

| Product | Price/month EUR no commitment| Price/month EUR for 3 month commitment | Price/month EUR for 6 month commitment|Initial charge EUR| Available for rent
|---:|---:|---:|---:|---:|---
|Xbox Series X|35|30|25|35|Yes
|Xbox Series S|25|20|17|25|Yes
|Sony PS5|35|30|25|35|Yes
|Nintendo Switch Lite|17|13|10|17|Yes
|Oculus Quest 2|35|30|25|35|Yes
|Oculus Quest|30|25|20|30|No
|Oculus Rift S|35|30|25|35|Yes
|HTC Vive Cosmos|45|40|35|45|Yes

