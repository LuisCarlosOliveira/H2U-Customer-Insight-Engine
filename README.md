# H2U Hotel Customer Evaluation System

## Table of Contents
- [Overview](#overview)
- [Learning Objectives](#learning-objectives)
- [Problem Description](#problem-description)
- [System Modules](#system-modules)
  - [Data Ingestion Module](#data-ingestion-module)
  - [Customer Segmentation Module](#customer-segmentation-module)
  - [Statistics Module](#statistics-module)
  - [Results](#results)
- [Development Activities](#development-activities)
- [Tools](#tools)
- [Scrum and Agile Development](#scrum-and-agile-development)
- [Team Members](#team-members)
- [Setup and Running](#setup-and-running)
- [License](#license)

## Overview
This repository contains the implementation of the H2U Hotel's customer evaluation application. The project's goal is to analyze customer behavior based on their purchasing history, demographic, and geographic information to enhance marketing strategies.

## Learning Objectives
By the end of this project, students will have improved their ability to:

- Analyze problems to identify requirements, business rules, and use cases.
- Specify and execute a readable set of test cases.
- Differentiate between black-box and white-box testing and choose appropriate tests for each use case.
- Implement agile development methodologies and use support tools.
- Establish a mature development plan involving a teamwork approach.
- Inspect the code by identifying, collecting, and analyzing specific metrics related to the quality of the software product.

## Problem Description
The H2U Hotel has accumulated extensive data over three years of operation concerning customers' service acquisition practices, as well as geographical and demographic information. The software aims to structure this data and segment customers based on purchase regularity, total purchases, and monetization.

## System Modules

### Data Ingestion Module
The application imports CSV data into a predefined information model using OpenCSV.

### Customer Segmentation Module
Customers are segmented based on purchase regularity, total number of transactions, and monetization value, with each factor being scored on a 1-4 scale.

### Statistics Module
This module performs statistical analysis to provide insights into purchase seasonality, communication channels, and payment methods, among other metrics.

### Results
Outputs a JSON file with scores and statistics, ensuring results are verifiable before writing to the final file.

## Development Activities
- Planning and monitoring project execution with SCRUM.
- Creating and managing agile project management artifacts (backlogs, user stories, sprints, etc.).
- Establishing Software Configuration Management support mechanisms.
- Documenting test analysis and specification processes.
- Collecting and analyzing software quality metrics.

## Tools
- **Java**: Programming language for search engine development and test specification.
- **Gradle**: Build configuration and automation tool.
- **JUnit**: Framework for test coding.
- **JaCoCo**: Code coverage analysis.
- **PMD & Checkstyle**: Static code analysis.
- **GitLab**: Version control and agile development support.

## Scrum and Agile Development
The development process is based on SCRUM, with sprints reviewed and retrospectives performed during practical classes. Scrum Boards are used to organize tasks and monitor the implementation's progress.

## Team Members
- Adão Henrique Sá Araújo
- Luís Carlos Mendes de Oliveira ([GitHub](https://github.com/LuisCarlosOliveira))
- Pedro Miguel Mota Marques
- Rui Pedro Martins Teixeira


