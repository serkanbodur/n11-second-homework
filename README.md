# second-homework n11 TalentHub Java Bootcamp


### Project Description

This project is a project using Spring and Postgresql that can do basic CRUD operations such as insert,update,delete,find

### Project Structure

- Entity
- DTO
- DAO
- Service
- Controller
- Exceptions

### Basic Usage

- Run project once to create the tables.
- Run the inserts sql files under the resources folder in postgre sql to insert the data into the tables.
- Apply the operations according to appropriate endpoints using Postman or Swagger

### Project End Points

[User Paths](../main/java/com/example/secondhomework/controller/UserController.java)

| Request Method | Route                          | Request Body                                                                                                                              | Description                            |
|----------------|--------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------|
|       GET      | /api/users/                    | {  }                                                                                                                                      | Get All Users                          |
|       GET      | /api/users/username/{username} | {  }                                                                                                                                      | Get a User using username              |
|       GET      | /api/users/phone/{phone}       | {  }                                                                                                                                      | Get a User using phone                 |
|      POST      | /api/users/                    | {  "name" : "test_user", "surname" : "test_user_sur", "email" : "test@mail.com" , "phone" : "2233" , "username" : "tested"  }             | Save a User                            |
|       PUT      | /api/users/{id}                | {  "name" : "updated_user" , "surname" : "updated_sur" , "email" : "updated@mail.com" , "phone" : "6060" , "username" : "updated_usrnm" } | Update a User using id                 |
|     DELETE     | /api/users/{username}/{phone}  | {  }                                                                                                                                      | Delete a User using username and phone |


[Comment Paths](../main/java/com/example/secondhomework/controller/ProductCommentController.java)

| Request Method | Route                              | Request Body                                                                                    | Description                         |
|----------------|------------------------------------|-------------------------------------------------------------------------------------------------|-------------------------------------|
|       GET      | /api/comments/users/{userId}       | {  }                                                                                            | Get a Comment using userId          |
|       GET      | /api/comments/products/{productId} | {  }                                                                                            | Get a Comment using productId       |
|      POST      | /api/comments/                     | {  "comment" : "test_comment" , "commentDate" : "2021-10-10" , "productId" : 1 , "userId" : 2 } | Save a Comment                      |
|     DELETE     | /api/comments/{id}                 | {  }                                                                                            | Delete a Comment using comment's id |
