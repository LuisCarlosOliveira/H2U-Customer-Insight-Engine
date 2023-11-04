# H2U Hotel Customer Evaluation System

## Learning Objectives
Upon completion of this project, students should have enhanced their ability to:

- Analyze a problem and identify requirements, business rules, and use cases.
- Specify and execute a readable set of test cases.
- Distinguish between black-box and white-box testing (with identification of coverage) and choose appropriate tests for each use case.
- Use agile development methodologies and support tools in software development.
- Establish a mature development plan involving a team.
- Regularly inspect code by identifying, collecting, and analyzing a specific set of metrics related to the quality of the software product, associated with other quality factors beyond system behavior.

## Software to be Developed
The aim is to develop an application for evaluating customers based on the history of their purchases.

### Description of the Problem
The H2U Hotel has accumulated extensive information about customer behavior in terms of service acquisition practices, as well as geographic and demographic information, over three years of activity.

The Hotel Manager would like to better understand the different profiles of their customers to develop more efficient and targeted marketing strategies.

The challenge presented is to develop software capable of:

- Reading and structuring customer behavior data.
- Segmenting customers based on indicators such as regularity of purchases, total purchases, and monetization of their purchases.
- Assigning a score to each customer for each indicator.
- Producing a set of statistics on customer behavior.

### Modules
1. **Data Ingestion Module**
   - Import data according to a predefined information model using OpenCSV.
2. **Customer Segmentation Modules**
   - Calculate indicators for regularity, total purchases, and monetization.
   - Assign scores to each customer based on these factors, divided into quartiles.
3. **Statistics Module**
   - Provide analysis on the seasonality of purchases, communication channels, and payment methods.
   - Offer statistical analysis of the score indicators.

### Results
- A JSON file with the scores of each indicator and statistics.
- Verification of each result before writing to the final file.

## Development Activities
- Plan and monitor the project execution using agile methodologies, particularly SCRUM.
- Create and manage all necessary artifacts associated with agile project management.
- Establish software configuration management support mechanisms.
- Document the analysis and specification of tests.
- Collect and analyze a set of metrics related to software product quality.

## Tools
- GitLab
- Java
- Gradle
- jUnit
- Jacoco
- PMD

## Development Process
- The development was conducted using SCRUM methodologies, with the team successfully managing the development through issue tracking and agile boards. All project phases from planning to execution were completed, adhering to agile principles to ensure effective collaboration and project management.

## Team Members
- Adão Henrique Sá Araújo
- Luís Carlos Mendes de Oliveira ([GitHub](https://github.com/LuisCarlosOliveira))
- Pedro Miguel Mota Marques
- Rui Pedro Martins Teixeira

