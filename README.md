# Kafka - Messaging Microservice Features
- KAFKA Messaging Stream
- Spring-security
- Swagger-UI 
- DB based Authentication
- Role Based Access
- Spring AOP
- HTTPS Secured - new Self-Signed Certificate Created


# Logic Implemented
- USER - ADMIN Chat : It has it's own Kafka-Topic which stores this chat
- USER - USER Chat : This has a different Kafka-Topic which stores this chat
- Identity is identified by Spring Security and assigned to Custom Chat Object
- Endpoint takes only message from user/admin.
- SSL /TSL Features Enabled

# Steps To Use

## --> Login
- go to localhost:8080/login screen
- Admin cred : username-priyanka password-pass
- User cred 1 : username-priyanka password-pass
- User cred 2 : username-test password-pass

## --> Open Swagger
- go to localhost:8080/swagger-ui.html
### Endpoint for USER - ADMIN CHAT
- go to /publish/admin - to type as ADMIN
- go to /publish/user - to type as USER
### Endpoint for USER - USER CHAT
- go to /usertouser - to type as USER
- Open another window and login and continue chat with fellow User

#Auth Rule
- if not authorised in any scope , will get 403 in response
- USER profile can use only user chay endpoints
- ADMIN profile can use onlu admin chat endpoints

