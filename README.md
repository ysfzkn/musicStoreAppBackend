# Music Store Backend

## Backend side for musicStore Project. You can reach out below front end side of this project
## [https://github.com/ysfzkn/musicStoreAppFrontend/](https://github.com/ysfzkn/musicStoreAppFrontend)

### Endpoints

#### Sign-Up

```
POST /auth/sign-up HTTP/1.1
Host: localhost:8080
Content-Type: application/json
{
    "name": "user",
    "username": "user",
    "password": "user"
}
```

#### Sign-In

```
POST /auth/sign-in HTTP/1.1
Host: localhost:8080
Content-Type: application/json
{
    "username": "user",
    "password": "user"
}
```

#### Change to Admin

```
PUT /internal/change-to-admin/admin HTTP/1.1
Host: localhost:8080
Authorization: Bearer InternalApiKey**
```

#### Save Instrument

```
POST /instrument HTTP/1.1
Host: localhost:8080
Authorization: Bearer ...admin
Content-Type: application/json
Content-Length: 119
{
    "name": "Guitar Yamaha",
    "model": "Model 2",
    "type": "Acoustic",
    "price": 200
}
```

#### Delete Instrument

```
DELETE /instrument/5 HTTP/1.1
Host: localhost:8080
Authorization: Bearer ...admin
```

#### Get All Instruments

```
GET /instrument HTTP/1.1
Host: localhost:8080
```

#### Save Purchase

```
POST /purchase-history HTTP/1.1
Host: localhost:8080
Authorization: Bearer ...user or admin
Content-Type: application/json
Content-Length: 53
{
    "userId": 4,
    "instrumentId": 5,
    "price": 200
}
```

#### Get User Purchases

```
GET /purchase-history HTTP/1.1
Host: localhost:8080
Authorization: Bearer ...user or admin
```
