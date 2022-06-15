
# Spring Boot, MariaDB, Rest API

Build Restful CRUD API for a web using Spring Boot, MariaDB, JPA and Hibernate.

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/huynhnhan3110/api.git
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
| POST   | /api/employees/ | Add new employee to existing id team | [JSON](#createEmployeeExistingTeam) |
| GET    | /api/employees/ | Get all employees | |
| GET    | /api/employees?page=3&size=2&sort=DESC | Get all employees with pagination by pageNum (default = 0), pageSize (default = 5), sortBy(default = ASC) | |
| GET    | /api/employees/{id} | Get employee by id | |
| GET    | /api/employees/search?full_name={fullname} | Search employee by fullname | |
| PUT    | /api/employees/{id} | Update employee by id | [JSON](#updateEmployeeById) |
| DELETE    | /api/employees/{id} | Delete employee by id | |

### Team

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/teams/ | Get all teams | |
| GET    | /api/teams{id} | Get team by id | |
| GET    | /api/teams/{id}/employees | Get employee list by team |
| POST   | /api/teams/ | Add new team | [JSON](#createNewTeam) |
| PUT    | /api/teams/{id} | Update team | [JSON](#updateTeam) |
| DELETE | /api/teams/{id} | Delete team | |

### Working

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/working/ | Get all workings | |
| GET    | /api/working/{id} | Get working by id | |
| GET    | /api/working?employeeId={id} | Get working list by employee id | |
| POST   | /api/working/ | Add new working | [JSON](#createWorking) |
| PUT    | /api/working/{id} | Update working by id | [JSON](#updateWorking) |
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
| POST   | /api/advances | Create new advance | [JSON](#createAdvance) |
| PUT    | /api/advances/{id} | Update advance by id | [JSON](#updateAdvance) |
| DELETE | /api/advances/{id} | Delete advance by id | |


Test them using postman or any other rest client.

## Sample Valid JSON Request Bodys

##### <a id="createEmployeeExistingTeam">Create employee with  with existing team-> /api/employees</a>
```json
{
	"fullName": "Huynh Huu Nha3n",
    "age": 20,
    "sex": "Male",
    "address": "Vinh Long",
    "moneyPerHour": 150000,
    "phoneNumber": "0943836766",
    "startDate": "2022-06-15",
    "team":  {
        "teamId": 3
    }
}
```

##### <a id="updateEmployeeById">Update Employee by Id -> /api/employees/{id}</a>
```json
{
	"fullName": "Huynh Huu Nha7n",
    "age": 20,
    "sex": "Male",
    "address": "Vinh Long",
    "phoneNumber": "0943836766",
    "startDate": "2022-06-15",
    "position": null,
    "moneyPerHour": 150000.0,
    "team": {
        "teamId": 2
    }

```


##### <a id="createNewTeam">Add new team -> /api/teams</a>
```json
{
	"name": "Dev"
}
```

##### <a id="updateTeam">Update team -> /api/teams/{id}</a>
```json
{
	"name": "Dev2"
}
```


##### <a id="createWorking">Add new working -> /api/working</a>
```json
{
	"employee_id": 1,
    	"date_time": "2022-06-10", (YYYY-MM-dd)
    	"numberHour": 4
}
```
##### <a id="updateWorking">Update working -> /api/working/</a>
```json
{
	"employee_id": 2,
    	"date_time": "2022-06-12",  (YYYY-MM-dd)
    	"numberHour": 8
}
```
##### <a id="createAdvance">Create advance -> /api/advances/</a>
```json
{
	"employee_id": 1,
    	"date_time": "2022-1-14",
    	"money": 20000
}
```
##### <a id="updateAdvance">Update advance -> /api/advances/</a>
```json
{
	"employee_id": 2,
    	"date_time": "2022-1-17",
    	"money": 10000
}
```
![segment](https://api.segment.io/v1/pixel/track?data=ewogICJ3cml0ZUtleSI6ICJwcDJuOTU4VU1NT21NR090MWJXS0JQd0tFNkcydW51OCIsCiAgInVzZXJJZCI6ICIxMjNibG9nYXBpMTIzIiwKICAiZXZlbnQiOiAiQmxvZ0FwaSB2aXNpdGVkIiwKICAicHJvcGVydGllcyI6IHsKICAgICJzdWJqZWN0IjogIkJsb2dBcGkgdmlzaXRlZCIsCiAgICAiZW1haWwiOiAiY29tcy5zcHVyc0BnbWFpbC5jb20iCiAgfQp9)
