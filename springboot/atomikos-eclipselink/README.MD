mvn install -DskipTests

mvn spring-boot:run

```
Url : http://localhost:8082/account/101/wallet GET

Url : http://localhost:8082/account POST
Method :POST
Content-Type:application/json
Request Body :
{
"name":"Ra",
"mobileNumber":"988332"
}

Url : http://localhost:8082/account/2/transfer-to 
Method :POST
Content-Type:application/json
Request Body :
{
"toAccountId": 1,
"amount":30
}
```
