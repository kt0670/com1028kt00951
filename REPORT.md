# COM1008 - Software Engineering

# Assignment 1 - Report

**Student Name: Khushi Thing**

**Student ID: 6861360**

## 1.1 Proto Personas

### Persona 1

 **Florence, film critique**

Florence, age 26, is a film critique who writes detailed reviews and analyses entertainment value of well-known films for the New York Times Magazine. Florence was born and raised in Los Angeles, and had a great interest in the film industry starting from a young age. She pursued her passion and obtained a degree in film studies at the University of California, Los Angeles, and moved to New York to gain more experience in journalism after her graduation. As a result, Florence already has sufficient technique and experience in research, however she believes that FlickFinder will efficiently aid her in the process, and allow her to produce higher quality and accurate reviews for the magazine.

### Persona 2

**Nathan, drama student**

Nathan, age 18, is an A-level drama student from Oxford who has great love and passion for films and books which therefore makes him confident in analysis. However, there are still many films that he has  not heard of due to his focus on only drama films, and he believes that the use of FlickFinder will help him expand his knowledge in a variety of genres. He also has a coursework that is coming up soon and he is thinking of using this application for assistance in research to develop a more well-rounded perspective on acting and storytelling.

## 1.2 Scenario

**Critique on Deadpool & Wolverine**

Florence is a film critique for the New York Times Magazine. She has just been assigned to work on reviewing Deadpool and Wolverine, however rather than only focusing on the artistic and technical aspects of the film, she has also been asked to analyse the film's financial success and audience reception. This will require thorough research on the movie's box office impact, comparison to previous films: Once Upon a Deadpool, Deadpool 2, Deadpool; and audience reviews. Florence uses FlickFinder so that she can easily acquire the information mentioned by entering the film title, or the director's name to assess previous films. She is also thinking of using a separate database containing all the information that she obtains, and then she can compare data across a variety of films on the same application.

## 1.3 User Stories

### User Story 1

**Critique**

As a critique, I want to be able to save search results into a folder so that I can easily find them if I need it again.

### User Story 2

**Film Enthusiast**

As a film enthusiast, I want to be able to be provided with links to streaming services so that I can easily find a way to watch the movies I search.

### User Story 3

**Film Historian**

As a film historian, I want to filter my searches by director and release date, so that I can track industry trends to understand how filmmaking has evolved overtime.

### User Story 4

**Drama Student**

As a drama student, I want to have autocomplete in the search bar that suggests movie titles/actors so that I can efficiently discover films that I have not known about before.

### User Story 5

**Film Watcher**

As a casual film watcher, I want to be able to bookmark movies so that I can save films that I discover into my own personal watchlist.

### User Story 6

**Casting Director**

As a casting director, I want to view detailed actor profiles so that I can evaluate their past performances when considering them for a role.

## 2 Critical Analysis and Reflection

### 2.1 Reflection

In terms of what went well, I was able to gain valuable experience in implement the core functionality and ensure valid communication between the frontend and backend. The integration tests also played a critical role in ensuring that the responses were accurate and matched expectations, leading to validation of the system's behaviour. Despite these successes, there are areas where the project could be improved. The project handles basic error cases, however, additional layers of security would greatly benefit the application, such as SQL injection prevention techniques by implementing parameterised queries, which can protect against malicious attacks, and input validation to ensure that user inputs are safe and do not introduce vulnerabilities to the application. Users are likely to have accounts, and so adopting secure authentication methods, such as hashed passwords and multi-factor authentication, would strengthen protection. The application should also implement the HTTPS protocol, so that sensitive information is encrypted and secured from interception.

### 2.2 Professional Aspects

Using the Model-View-Controller design pattern enhances maintainability via providing a modular structure, as it ensures changes to one component, such as the database schema, are isolated and has minimal impact on others, and adding new features, such as additional endpoints, are less likely to cause major disruptions (University of Surrey, 2024).
From a legal and ethical standpoint, the mobile movie application must comply to laws such as the Data Protection Act 2018, which ensures securing user data, informing users of how their data will be used, and allowing them to delete their accounts or opt out of data collection. Movie data should also be used in compliance with copyright laws or under licensing agreements. Users should also be provided with transparency and be made aware of their rights and the steps taken to protect their privacy.
Sustainability can also be maintained by ensuring clean, modular and reusable code to minimise processing overhead and makes future development more efficient. Utilising compressed assets, such as images and videos that could potentially be used in the application, can significantly reduce storage and bandwidth requirements, enhancing the app's performance and use optimised SQL queries to reduce server load and improve response times.

## 3. References

University of Surrey. (2024) 'Week 4: Architecture Design'. https://surreylearn.surrey.ac.uk/content/enforced/267649-COM1028_2024-5_SEMR2_2/week_4/lecture.pdf?isCourseFile=true&ou=267649
