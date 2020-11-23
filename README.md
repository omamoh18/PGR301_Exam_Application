# Exam in DevOps PGR301 

## StatusCake

<a href="https://www.statuscake.com" title="Website Uptime Monitoring"><img src="https://app.statuscake.com/button/index.php?Track=5751113&Days=1&Design=1" /></a> 

## Travis

[![Build Status](https://travis-ci.com/omamoh18/PGR301_Exam_Application.svg?token=yMbNk68jXyaqW9Hmq6pJ&branch=master)](https://travis-ci.com/omamoh18/PGR301_Exam_Application)

## Link to infrastructure repository:

https://github.com/omamoh18/PGR301_Exam_Infrastructure 


## My understanding of the exams purpose: 

This repository contains an application that expos a REST-API creating Dragon Ball Z characters. 
In the lectures, we didn’t use advanced applications, instead we learned how good DevOps principles should be.
This application is not packed with many functionalities either, but I have been rather focusing on how I can show good DevOps guidelines.  
I have been trying to follow guidelines like the `twelve-factor app`, like multistage building done by Travis. 

## Assignment one required an explaining for to how too setup encrypt secrets with Travis:
To make Travis-CI build a Docker image and publish it to Google Container Registry is the following needed: 
 - Create a Service Account for Travis-CI 
 - Give the service account permission roles such as `Container Registry Service Agent`, `Service Account User`, `Cloud Run Admin`, `Cloud Run Service Agent`, `Storage Admin`. 
 - Create a `json-key` for the service account  
 - Give the key a name `(google-key.json)`, and place in root of your project.  
 - Now you have to encrypt the `google_key.json`, since a good DevOps guideline is to never expose secrets to the public. Run the following commands: `Travis encrypt-file --pro google_key.json --add` 
 - The project is now configured to when a push happen to master branch, will Travis build a new Docker Image and give the image a tag so push it to Google Cloud Registry. 
 - Make sure that `Cloud Run`, `Cloud Storage`, `Container Registry` API`s is enabled in the Google cloud project.
 
 ## Uncompleted tasks of the exams:
 
In assignment two I configured metrics and achieved to send data too InfluxDB. I used counter from the micrometer register. I was trying to fulfill the other criteria in this task,
but I ran out of time. This is why I will try to explain it here and give som examples and hope it counts for some points when evaluating this exam.

 - `Gauge` is a metric which represents a single numerical value that can arbitrarily go up and down. 
  They are used for measuring values like memory usage, but can also “counts” that can increment or decrement, like when a DB deleted something or add something to it.
 - `Timers` measure both the rate, distribution and duration of a particular piece of code. 
  The record is not recorded until the task is done. Useful for measuring short-duration latencies and the frequency of such events.
 - `The long task timer` is a timer that lets the user measure time while an event being measured is still up and running. 
 
 ## Assignments:
 
 -[x] Assignment 1 (Docker)
 -[ ] Assigment 2 (Metrics,InfluxDB)
 -[x] Assignment 3 (Logs)
 -[x] Assignment 4 (Infrastructure)
 -[x] Assigment 5 (StatusCake)
 -[ ] Assignment 6 (free choice of IaC)