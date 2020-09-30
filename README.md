# Java Spring Boot Rest Api Couchbase Sample

## Steps to Setup

**1. Clone the application**

```bash
https://github.com/AKILLIMUSTAFA/TrendyolBootcampWeek4SpringBootCouchbaseHw.git
```

**2. Run Couchbase On Docker**
```bash
docker run -d -p 8091-8095:8091-8095 -p 11210:11210 couchbase
```

**3. Setup New Cluster**

+ open `localhost:8091` from browser

+ push button `Setup New Cluster` and set a password and admin username

**4. Create A Bucket**

+ open `Buckets` tab and add new Bucket with name `playlist`

**5. Create A Index**

+ open `Query` tab and execute `CREATE PRIMARY INDEX on playlist` query

+ now we can exucete `SELECT * FROM playlist` query and it should return empty array

**6. Change Couchbase Username and Password As Per Your Installation**

+ open `src/main/resources/application.properties`

+ change `couchbase.username` and `couchbase.password` as per your couchbase installation

**7. Open Project wit Intelliji IDEA**

+ open project with IDE and run it

+ open `localhost:8080` from browser

+ now you can try it


## Explore Rest APIs

The app defines following CRUD APIs.

![2020-09-30_04-08-11](https://user-images.githubusercontent.com/11073644/94632164-991af300-02d2-11eb-9fee-fd3cfd6a97df.png)

You can send your feedbacks... 
