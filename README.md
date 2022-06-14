
# Spring Boot, MariaDB, Rest API

Build Restful CRUD API for a web using Spring Boot, MariaDB, JPA and Hibernate.

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/coma123/Spring-Boot-Blog-REST-API.git
```

**2. Create Maria database**

Download Docker and install it

Run command `docker run -p 3306:3306 -d --name mariadb -eMARIADB_ROOT_PASSWORD=Password123! mariadb:latest `

Access to MariaDB Server by command `mariadb --host 127.0.0.1 -P 3306 --user root -p`

`CREATE DATABASE ems;`

**3. Change Maria username and password**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Run the app using maven**

```bash
mvn clean install
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

## Explore Rest APIs

The app defines following CRUD APIs.

### Employee

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| POST    | /api/employees/ | Add new employee and create new team | |
| POST    | /api/employees/add?team={id} | Add new employee to existing id team | |
| GET    | /api/employees/ | Get all employees | |
| GET    | /api/employees/{id} | Get employee by id | |
| PUT    | /api/employees/{id} | Update employee by id | |
| DELETE    | /api/employees/{id} | Delete employee by id | |

### Team

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/teams/ | Get all teams | |
| GET    | /api/teams{id} | Get team by id | |
| POST   | /api/teams/ | Add new team | |
| PUT    | /api/teams/{id} | Update team | |
| DELETE | /api/teams/{id} | Delete team | |

### Working

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/working/ | Get all workings | |
| GET    | /api/working/{id} | Get working by id | |
| GET    | /api/working?employeeId={id} | Get list working by employee id | |
| POST   | /api/working/ | Add new working | [JSON](#commentcreate) |
| PUT    | /api/working/{id} | Update working by id | [JSON](#commentupdate) |
| DELETE | /api/working/{id} | Delete working by id | |

### Statistic

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/statistics/ | Get all statistics | |
| GET    | /api/statistics?employeeId={id} | Get statistic by employee id | |
| POST   | /api/statistics/ | Calculate statistics and save to db | |

### Advance

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/advances | Get all advances | |
| GET    | /api/advances/{id} | Get advance by id | |
| POST   | /api/advances | Create new advance | [JSON](#photocreate) |
| PUT    | /api/advances/{id} | Update advance by id | [JSON](#photoupdate) |
| DELETE | /api/advances/{id} | Delete advance by id | |


Test them using postman or any other rest client.

## Sample Valid JSON Request Bodys

##### <a id="signup">Sign Up -> /api/auth/signup</a>
```json
{
	"firstName": "Leanne",
	"lastName": "Graham",
	"username": "leanne",
	"password": "password",
	"email": "leanne.graham@gmail.com"
}
```

##### <a id="signin">Log In -> /api/auth/signin</a>
```json
{
	"usernameOrEmail": "leanne",
	"password": "password"
}
```

##### <a id="usercreate">Create User -> /api/users</a>
```json
{
	"firstName": "Ervin",
	"lastName": "Howell",
	"username": "ervin",
	"password": "password",
	"email": "ervin.howell@gmail.com",
	"address": {
		"street": "Victor Plains",
		"suite": "Suite 879",
		"city": "Wisokyburgh",
		"zipcode": "90566-7771",
		"geo": {
			"lat": "-43.9509",
			"lng": "-34.4618"
		}
	},
	"phone": "010-692-6593 x09125",
	"website": "http://erwinhowell.com",
	"company": {
		"name": "Deckow-Crist",
		"catchPhrase": "Proactive didactic contingency",
		"bs": "synergize scalable supply-chains"
	}
}
```

##### <a id="userupdate">Update User -> /api/users/{username}</a>
```json
{
	"firstName": "Ervin",
	"lastName": "Howell",
	"username": "ervin",
	"password": "updatedpassword",
	"email": "ervin.howell@gmail.com",
	"address": {
		"street": "Victor Plains",
		"suite": "Suite 879",
		"city": "Wisokyburgh",
		"zipcode": "90566-7771",
		"geo": {
			"lat": "-43.9509",
			"lng": "-34.4618"
		}
	},
	"phone": "010-692-6593 x09125",
	"website": "http://erwinhowell.com",
	"company": {
		"name": "Deckow-Crist",
		"catchPhrase": "Proactive didactic contingency",
		"bs": "synergize scalable supply-chains"
	}
}
```

##### <a id="userinfoupdate">Update User Profile -> /api/users/setOrUpdateInfo</a>
```json
{
	"street": "Douglas Extension",
	"suite": "Suite 847",
	"city": "McKenziehaven",
	"zipcode": "59590-4157",
	"companyName": "Romaguera-Jacobson",
	"catchPhrase": "Face to face bifurcated interface",
	"bs": "e-enable strategic applications",
	"website": "http://ramiro.info",
	"phone": "1-463-123-4447",
	"lat": "-68.6102",
	"lng": "-47.0653"
}
```

##### <a id="postcreate">Create Post -> /api/posts</a>
```json
{
	"title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
	"body": "quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto"
}
```

##### <a id="postupdate">Update Post -> /api/posts/{id}</a>
```json
{
	"title": "UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED",
	"body": "UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED "
}
```

##### <a id="commentcreate">Create Comment -> /api/posts/{postId}/comments</a>
```json
{
	"body": "laudantium enim quasi est quidem magnam voluptate ipsam eos tempora quo necessitatibus dolor quam autem quasi reiciendis et nam sapiente accusantium"
}
```

##### <a id="commentupdate">Update Comment -> /api/posts/{postId}/comments/{id}</a>
```json
{
	"body": "UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED "
}
```

##### <a id="albumcreate">Create Album -> /api/albums</a>
```json
{
	"title": "quidem molestiae enim"
}
```

##### <a id="albumupdate">Update Album -> /api/albums/{id}</a>
```json
{
	"title": "quidem molestiae enim UPDATED"
}
```

##### <a id="photocreate">Create Photo -> /api/photos</a>
```json
{
	"title": "accusamus beatae ad facilis cum similique qui sunt",
	"url": "https://via.placeholder.com/600/92c952",
	"thumbnailUrl": "https://via.placeholder.com/150/92c952",
	"albumId": 2
}
```

##### <a id="photoupdate">Update Photo -> /api/photos{id}</a>
```json
{
	"title": "accusamus beatae ad facilis ",
	"url": "https://via.placeholder.com/600/771796",
	"thumbnailUrl": "https://via.placeholder.com/150/771796",
	"albumId": 4
}
```

##### <a id="todocreate">Create Todo -> /api/todos</a>
```json
{
	"title": "delectus aut autem",
	"completed": false
}
```

##### <a id="todoupdate">Update Todo -> /api/todos{id}</a>
```json
{
	"title": "delectus aut autem Updated",
	"completed": true
}
```
![segment](https://api.segment.io/v1/pixel/track?data=ewogICJ3cml0ZUtleSI6ICJwcDJuOTU4VU1NT21NR090MWJXS0JQd0tFNkcydW51OCIsCiAgInVzZXJJZCI6ICIxMjNibG9nYXBpMTIzIiwKICAiZXZlbnQiOiAiQmxvZ0FwaSB2aXNpdGVkIiwKICAicHJvcGVydGllcyI6IHsKICAgICJzdWJqZWN0IjogIkJsb2dBcGkgdmlzaXRlZCIsCiAgICAiZW1haWwiOiAiY29tcy5zcHVyc0BnbWFpbC5jb20iCiAgfQp9)
