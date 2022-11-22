# Spring boot CRUD and caching by Redis

## Intro
In this project, I used Redis for caching with Spring Boot. An entity called Questionnaire with CRUD functionalities exist in this project. When you get an item for the first time, the application tries to fetch it from a MySQL database. After that, the entity will be cached in Redis and for the future requests, it will only check the Redis.

## Usage
You can define caching logics in your services. Put ```@CacheConfig(cacheNames = {"CLASS_THAT_YOU_WANT_TO_CACHE"})``` on top of your service class.

Then there are three useful annotations that you can use for your caching:

* ```@Cacheable(key = "#id")``` will cache the item
* ```@CachePut(key = "#id")``` will update the item in the cache
* ```@CacheEvict(key = "#id")``` will delete the item from the cache

## Configuration
After adding the ```@EnableCaching``` on top of main class, there are three parts to configure:

### Dependencies
The following dependencies need to be in ```pom.xml```:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
    <version>2.7.5</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
    <version>2.7.5</version>
</dependency>
```
### Application.properties
These are the general configurations for Redis:
```
spring.redis.database=0
spring.redis.host=localhost
spring.redis.port=6379
spring.redis.password=
spring.redis.timeout=60000
```
### Custom Redis Config
```RedisConfig.java``` is created to customize the configuration. You can define different caching behaviours for different entities. You can also disable null caching. Do not forget to put ```@Configuration``` on top of the class declaration.

