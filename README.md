![Deployment Pipeline](https://github.com/Fermion155/imagerecognition-BE/actions/workflows/github-ci.yml/badge.svg)
![Language](https://img.shields.io/badge/language-Java-orange)
# IMAGE RECOGNITION BACKEND

## Table of Contents

- [About The Project](#about-the-project)
- [Installation](#installation)
- [Usage](#usage)
- [Future Plans](#future-plans)
- [Ownership](#ownership)

## About The Project

Image recognition backend is an application that provides a backend REST service for image recognition application. 

This service uses Amazon Rekognition service to recognize the received images and decide if it is **ALLOWED** or **NOT_ALLOWED** to be used somewhere. The option that the image was **NOT_RECOGNIZED** can also be returned by this backend service in case none of the labels returned by Amazon Rekognition match the ones saved in the database.
## Installation

1. Clone the repository:
   ``` sh
   git clone https://github.com/Fermion155/imagerecognition-BE.git
   ```
2. Navigate to the project directory:
    ```sh
    cd imagerecognition-BE
    ```
3. Define environment variables either in a .env file within the project directory or by exporting them in the shell.
   
   Environment variable list:
   
      - DB_NAME
      - DB_USER
      - AWS_REGION
      - DB_ROOT_PASSWORD
      - DB_PASSWORD
      - AWS_ACCESS_KEY
      - AWS_SECRET_KEY
3. Run application:    
   a. On docker:
    ``` sh
    docker-compose up
    ```
   b. In code editor:  
   Create database docker service:
    ``` sh  
    docker-compose up db
    ```  
   In code editor use VM options to activate a profile:
     ```sh
    -Dspring.profiles.active=local
     ```
## Usage

The application will be accessible at ``localhost:8080/``   
To recognize an image use `` POST `` request ``localhost:8080/`` with form-data request body where the key is of type **File** named `file` and value is your image file at the moment no larger than 1MB.
Result will be a response if according to the saved labels in the application's database the image is:
```sh
ALLOWED
NOT_ALLOWED
NOT_RECOGNIZED
```
You can also use a ``GET`` request at ``localhost:8080/categories`` to get a list of which image categories are allowed and which ones are not allowed.

## Future Plans

- The frontend application with functioning UI is planned.
- The ability to add new categories by simple POST request.
- The ability to delete or disable the categories which are allowed or not allowed.
- Add user authentification feature.

## Ownership

This project is maintained and owned by Paulius Drabužinskis