# House Price Predictor

A console-based Java application that predicts house prices using a Linear Regression model built with Python.

## About the Project

Having just completed my second semester of second year, I decided to build a project that would allow me to apply some of the knowledge and skills I have accumulated throughout my studies.

The goal was to build something that combines different programming languages and demonstrates how they can work together.

For this project, I developed a simple Linear Regression model in Python to predict house prices based on two features:
- House size
- Number of bedrooms
I then created a REST API using FastAPI to expose the model's prediction functionality. Finally, I developed a Java console application that communicates with the Python API, sends user inputs, and displays the predicted house price.

**Important:** The model is trained beforehand and does not learn or update its parameters as the application executes. It uses the previously trained model to generate predictions.



## Technologies Used

.Java: Developed the console application.
.Python: Used for data processing and building the machine learning model.
.Scikit-learn: Used to build and train the Linear Regression model.
.FastAPI: Used to create the REST API that exposes the model.
.Uvicorn: Used to run the FastAPI application.



## How It Works



1. The user enters the house size and number of bedrooms in the Java console application.
2. Java sends the input data to the Python API through an HTTP request.
3. FastAPI receives the data and passes it to the trained Linear Regression model.
4. The model generates a predicted house price.
5. The API returns the prediction to Java.
6. Java displays the predicted price to the user.



## How to run it

###Prerequisites

* Python 3.10 or later
* Java JDK

1. Open Vscode 
2. Download all dependencies needed for main.py file. They are under requirement.txt
3. Execure: uvicorn main:app --reload on terminal
4. Open your computer terminal and navigate to folder conatining Application.java file and execute: javac -d out Application.java, then java -cp out main

## What I Learned

Through this project, I gained practical experience in:

1. Building and training a machine learning model using Linear Regression.
2. Creating and running a REST API using FastAPI.
3. Integrating two different programming languages (Java and Python).
4. Sending and receiving HTTP requests and handling API responses.
5. Handling exceptions and errors when communicating between applications.
6. Understanding how a trained machine learning model can be exposed and accessed through an API.

## Project Purpose

This project was primarily an opportunity to apply my existing knowledge, explore machine learning beyond the theoretical concepts, and gain practical experience integrating different technologies.

It is a learning project and a foundation for exploring more advanced machine learning applications in the future.

