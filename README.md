# EatFit & Review SOSE Project

## About the project
This repository contains the Service Oriented Software Engineering course project "EatFit&Review" at the University of L'Aquila. 
The project focuses on building a service-oriented system for searching, reviewing, and rating food items using Edamam Food Database API.

## Getting Started
This application consists of a set of services and microservices that have to be started inside a server to run the whole system.

### Prerequisites
In order to run this project, be sure that you have installed:
- Apache Tomcat (Tested with version 8.5.81)
- Java and JAVA_HOME set
- Eclipse IDE for Enterprise Java Developers
- Nginx

### Installation

To install the application follow these steps:
#### 1. Get a free API Key for Food Database at [Edamam](https://developer.edamam.com/food-database-api)
#### 2. Clone the repo
   
   ```sh
   git clone https://github.com/adam-bouafia/EatFit_Review-SOSE.git
   ```
   
#### 3. Enter your API in FoodSearchProsumer/src/main/java/it/univaq/disim/sose/search/SearchImpl.java
   ```java
private static final String APP_ID = "ENTER YOUR APP ID";
private static final String API_KEY = "ENTER YOUR APP KEY";
```
#### 4. And in FoodDetailsProsumer/src/main/java/it/univaq/disim/sose/fooddetails/data/EdamamRestClient.java
   
   ```java
private static final String APP_ID = "ENTER YOUR APP ID";
private static final String API_KEY = "ENTER YOUR APP KEY";
```

#### 5. Open Eclipse IDE, create a new Tomcat instance and run all the services:

  **AuthService**
  **FoodDetailsProsumer**
  **FoodDetailsAggregator**
  **FoodSearchProsumer**
  **RatingUpdaterRESTService**
  **ReviewDataService**
  **ReviewEditorProsumer**

  
#### 6. Install Android application

#### Nginx Load Balancer
To use Nginx load balancer, you have to follow several steps we summarized in the NGINX Load Balancer SOSE.pdf file as the Conf file is already in the repository at the Nginx server Conf .

#### Usage
Opening the Android application, you can search for food items. Clicking on a result, you will be redirected to the details page where you'll see all the food metadata, the averages of the ratings, the summary global score, and the reviews of that food item. You can also sign up and sign in to rate and write a review for a food item.

### Detailed Usage

After installing the app, you can start exploring the wide variety of foods by using the search functionality. Here are some steps to get you started:
- **Step 1:** Open the app and navigate to the search bar.
  
- **Step 2:** Enter the name of the food item you're interested in.
  
- **Step 3:** Browse through the search results and click on any item to view detailed nutritional information and reviews.

# EatFit&Review API Testing Using Postman Documentation

This documentation contains all the test results, including screenshots and Postman collections, for the various SOAP and REST services in the project.

## SOAP Services

### Food Detail Aggregator

#### 1. Aggregate Ratings


```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://service.sose.disim.univaq.it/">
   <soapenv:Header/>
   <soapenv:Body>
      <web:aggregateRatings>
         <arg0>food_a8hs60uayl5icia1qe8qoba1kwp8</arg0>
      </web:aggregateRatings>
   </soapenv:Body>
</soapenv:Envelope>

```

![Aggregate Ratings](.Presentation/Project%20Postman%20API%20Testing/Soap%20Food%20Detail%20Aggregator/fooddetailsaggregator.png)


### Food Search Prosumer

#### 1. Search Food


```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.sose.disim.univaq.it/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:searchFood>
         <arg0>pasta</arg0>
      </ser:searchFood>
   </soapenv:Body>
</soapenv:Envelope>


```

![Aggregate Ratings](.Presentation/Project%20Postman%20API%20Testing/Soap%20Food%20Search%20Prosumer/FoodSearchProsumer.png)


## REST Services

### Authentification

#### 1. Login with User Does Not Exist

```json
{
  "method": "POST",
  "url": "http://localhost:8081/AuthService/rest/User/Login",
  "headers": {
    "Content-Type": "application/x-www-form-urlencoded",
    "Accept": "application/json"
  },
  "body": {
    "username": "test3",
    "password": "test3"
  }
}
```

![login with user does not exist](.Presentation/Project%20Postman%20API%20Testing/Rest%20Authentification/login%20with%20user%20does%20not%20exist.png)

#### 2. Login with User Exists

```json
{
  "method": "POST",
  "url": "http://localhost:8081/AuthService/rest/User/Login",
  "headers": {
    "Content-Type": "application/x-www-form-urlencoded",
    "Accept": "application/json"
  },
  "body": {
    "username": "test3",
    "password": "test3"
  }
}
```

![login with user exist](.Presentation/Project%20Postman%20API%20Testing/Rest%20Authentification/login%20with%20user%20exist.png)

#### 3. Check User

```json
{
  "method": "POST",
  "url": "http://localhost:8081/AuthService/rest/User/checkUser",
  "headers": {
    "Content-Type": "application/x-www-form-urlencoded",
    "Accept": "application/json"
  },
  "body": {
    "userID": "test3",
    "userToken": "test3"
  }
}

```

![Check user exist](.Presentation/Project%20Postman%20API%20Testing/Rest%20Authentification/Check%20user.png)

#### 4. Sign Up

```json
{
  "method": "POST",
  "url": "http://localhost:8081/AuthService/rest/User/signup",
  "headers": {
    "Content-Type": "application/x-www-form-urlencoded",
    "Accept": "application/json"
  },
  "body": {
    "username": "newuserr",
    "password": "newpasswordd"
  }
}

```

![Sign Up](.Presentation/Project%20Postman%20API%20Testing/Rest%20Authentification/Sign%20up.png)


### Rating Updater

#### 1. Add Rating

```json
{
  "method": "GET",
  "url": "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/addRatings",
  "params": {
    "userId": "1",
    "foodId": "food_a8hs60uayl5icia1qe8qoba1kwp8",
    "tasteRating": "4",
    "nutritionalvalueRating": "5",
    "overallsatisfactionRating": "4",
    "packagingRating": "3",
    "costumesRating": "4"
  }
}

```

![Add Rating](.Presentation/Project%20Postman%20API%20Testing/Rest%20Rating%20Updater/GET%20addRating.png)


#### 2. Add Rating Async

```json
{
  "method": "GET",
  "url": "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/addRatingsAsync",
  "params": {
    "userId": "2",
    "foodId": "food_a8hs60uayl5icia1qe8qoba1kwp7",
    "tasteRating": "4",
    "nutritionalvalueRating": "5",
    "overallsatisfactionRating": "4",
    "packagingRating": "3",
    "costumesRating": "4"
  }
}


```

![Add Rating Async](.Presentation/Project%20Postman%20API%20Testing/Rest%20Rating%20Updater/GET%20addRating.png)

#### 3. Get All Rating

```json
{
  "method": "GET",
  "url": "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/getAllRatings",
  "params": {
    "foodId": "food_a8hs60uayl5icia1qe8qoba1kwp8"
  }
}


```

![Get All Rating](.Presentation/Project%20Postman%20API%20Testing/Rest%20Rating%20Updater/GET%20GetAllRating.png)

#### 4. Get Global Score

```json
{
  "method": "GET",
  "url": "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/getGlobalScore",
  "params": {
    "foodId": "food_a8hs60uayl5icia1qe8qoba1kwp8"
  }
}


```

![Get Global Score](.Presentation/Project%20Postman%20API%20Testing/Rest%20Rating%20Updater/GET%20GetGlobalScore.png)

#### 5. Get Rating Averages

```json
{
  "method": "GET",
  "url": "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/getRatingAvgs",
  "params": {
    "foodId": "food_a8hs60uayl5icia1qe8qoba1kwp8"
  }
}

```

![Get Global Score](.Presentation/Project%20Postman%20API%20Testing/Rest%20Rating%20Updater/GET%20GetRatingAverages.png)

### Review Data

#### 1. Get Reviews by Food ID


```json
{
  "method": "GET",
  "url": "http://localhost:8080/ReviewDataService/rest/Review/getReviewsByFoodID",
  "params": {
    "foodID": "food_a8hs60uayl5icia1qe8qoba1kwp8"
  }
}


```

![Get Reviews by Food ID](.Presentation/Project%20Postman%20API%20Testing/Rest%20Review%20Data/GetReviewsByfoodID.png)

#### 2. Get Reviews by User ID


```json
{
  "method": "GET",
  "url": "http://localhost:8080/ReviewDataService/rest/Review/getReviewsByUserID",
  "params": {
    "userID": "1"
  }
}


```

![Get Reviews by User ID](.Presentation/Project%20Postman%20API%20Testing/Rest%20Review%20Data/GetReviewsByUserID.png)

#### 3. Get Reviews by User ID and Food ID


```json
{
  "method": "GET",
  "url": "http://localhost:8080/ReviewDataService/rest/Review/getReviewByFoodIDUserID",
  "params": {
    "foodID": "food_a8hs60uayl5icia1qe8qoba1kwp8",
    "userID": "1"
  }
}



```

![Get Reviews by User ID](.Presentation/Project%20Postman%20API%20Testing/Rest%20Review%20Data/GetReviewsByfoodIDandByUserID.png)

#### 4. Insert Review


```json
{
  "method": "GET",
  "url": "http://localhost:8080/ReviewDataService/rest/Review/insertReview",
  "params": {
    "foodID": "food_a8hs60uayl5icia1qe8qoba1kwp8",
    "title": "Great Food!",
    "text": "This food was really good and tasty.",
    "userID": "1"
  }
}



```

![Get Reviews by User ID](.Presentation/Project%20Postman%20API%20Testing/Rest%20Review%20Data/insert%20Review.png)


#### Project Structure


```
EatFit & Review SOSE Project/
├── Docs
│ ├── NGINX Load Balancer SOSE.pdf
│ └── SOSE Project Documentation.pdf
├── Frontend - Java Mobile
│ ├── .gradle
│ ├── .idea
│ ├── app
│ │ ├── src
│ │ │ ├── androidTest
│ │ │ │ └── java
│ │ │ │ └── it/univaq/disim/sose/application/ExampleInstrumentedTest.java
│ │ │ ├── main
│ │ │ │ └── java
│ │ │ │ └── it/univaq/disim/sose/application
│ │ │ │ ├── adapters
│ │ │ │ │ ├── ResultAdapter.java
│ │ │ │ │ └── ReviewAdapter.java
│ │ │ │ ├── models
│ │ │ │ │ ├── FoodDetail.java
│ │ │ │ │ ├── RatingData.java
│ │ │ │ │ ├── Result.java
│ │ │ │ │ ├── Review.java
│ │ │ │ │ ├── ReviewList.java
│ │ │ │ │ └── User.java
│ │ │ │ ├── FoodDetailActivity.java
│ │ │ │ ├── FoodSearchActivity.java
│ │ │ │ ├── LoginActivity.java
│ │ │ │ ├── MainActivity.java
│ │ │ │ ├── RestClient.java
│ │ │ │ ├── ReviewActivity.java
│ │ │ │ └── SignupActivity.java
│ │ │ ├── res
│ │ │ │ ├── drawable
│ │ │ │ ├── drawable-finger
│ │ │ │ ├── drawable-v24
│ │ │ │ ├── font
│ │ │ │ ├── layout
│ │ │ │ │ ├── activity_main.xml
│ │ │ │ │ ├── add_review.xml
│ │ │ │ │ ├── auth_login.xml
│ │ │ │ │ ├── auth_signup.xml
│ │ │ │ │ ├── foodsearch.xml
│ │ │ │ │ ├── food_detail.xml
│ │ │ │ │ ├── review_row.xml
│ │ │ │ │ └── single_row.xml
│ │ │ │ ├── mipmap-anydpi-v26
│ │ │ │ ├── mipmap-hdpi
│ │ │ │ ├── mipmap-mdpi
│ │ │ │ ├── mipmap-xhdpi
│ │ │ │ ├── mipmap-xxhdpi
│ │ │ │ ├── mipmap-xxxhdpi
│ │ │ │ ├── values
│ │ │ │ │ ├── colors.xml
│ │ │ │ │ ├── font_certs.xml
│ │ │ │ │ ├── preloaded_fonts.xml
│ │ │ │ │ ├── spinner.xml
│ │ │ │ │ ├── strings.xml
│ │ │ │ │ └── themes.xml
│ │ │ │ ├── values-night
│ │ │ │ │ └── themes.xml
│ │ │ │ └── xml
│ │ │ │ ├── backup_rules.xml
│ │ │ │ └── data_extraction_rules.xml
│ │ │ ├── AndroidManifest.xml
│ │ │ └── home_icon-playstore.png
│ │ ├── test
│ │ │ └── java
│ │ │ └── it/univaq/disim/sose/application/ExampleUnitTest.java
│ │ ├── .gitignore
│ │ ├── build.gradle
│ │ ├── proguard-rules.pro
│ ├── gradle
│ │ └── wrapper
│ │ ├── gradle-wrapper.jar
│ │ └── gradle-wrapper.properties
│ ├── build.gradle
│ ├── gradle.properties
│ ├── gradlew
│ ├── gradlew.bat
│ ├── local.properties
│ ├── README.md
│ └── settings.gradle
├── MagicDraw Diagrams
│ ├── Diagrams PNG
│ │ ├── component__ComponentDiagram.png
│ │ ├── sd__Add_review_and_ranking__Add_review_and_ranking.png
│ │ ├── sd__Authentication__Authentication.png
│ │ ├── sd__Registration__Registration.png
│ │ ├── sd__Show_Food_information__Show_Food_information.png
│ │ ├── sd__Show_list_of_Food__Show_list_of_Food.png
│ │ └── uc__Model.png
│ └── SOSE_Project.mdzip
├── Backend
│ ├── .idea
│ │ ├── libraries
│ │ │ ├── lib.xml
│ │ │ ├── lib1.xml
│ │ │ │ ├── lib2.xml
│ │ │ │ ├── lib3.xml
│ │ │ │ ├── lib4.xml
│ │ │ │ ├── lib5.xml
│ │ │ │ ├── lib6.xml
│ │ │ ├── .gitignore
│ │ │ ├── Backend.iml
│ │ │ ├── misc.xml
│ │ │ ├── modules.xml
│ │ │ ├── other.xml
│ │ │ ├── workspace.xml
│ ├── .settings
│ │ ├── .jsdtscope
│ │ ├── org.eclipse.jdt.core.prefs
│ │ ├── org.eclipse.m2e.core.prefs
│ │ ├── org.eclipse.wst.common.component
│ │ ├── org.eclipse.wst.common.project.facet.core.xml
│ │ ├── org.eclipse.wst.jsdt.ui.superType.container
│ │ ├── org.eclipse.wst.jsdt.ui.superType.name
│ │ ├── org.eclipse.wst.validation.prefs
│ ├── Generator
│ │ ├── population.py
│ ├── MicroServices
│ │ ├── FoodDetailsAggregator
│ │ │ ├── .settings
│ │ │ │ ├── .jsdtscope
│ │ │ │ ├── org.eclipse.core.resources.prefs
│ │ │ │ ├── org.eclipse.jdt.apt.core.prefs
│ │ │ │ ├── org.eclipse.jdt.core.prefs
│ │ │ │ ├── org.eclipse.m2e.core.prefs
│ │ │ │ ├── org.eclipse.wst.common.component
│ │ │ │ ├── org.eclipse.wst.common.project.facet.core.prefs.xml
│ │ │ │ ├── org.eclipse.wst.common.project.facet.core.xml
│ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.container
│ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.name
│ │ │ │ ├── org.eclipse.wst.validation.prefs
│ │ │ ├── src
│ │ │ │ ├── main
│ │ │ │ │ ├── java
│ │ │ │ │ │ ├── it
│ │ │ │ │ │ │ ├── univaq
│ │ │ │ │ │ │ │ ├── disim
│ │ │ │ │ │ │ │ │ ├── sose
│ │ │ │ │ │ │ │ │ │ ├── data
│ │ │ │ │ │ │ │ │ │ │ ├── RatingDataClient.java
│ │ │ │ │ │ │ │ │ │ ├── model
│ │ │ │ │ │ │ │ │ │ │ ├── AggregatedDataResponse.java
│ │ │ │ │ │ │ │ │ │ │ ├── AggregatedRatingData.java
│ │ │ │ │ │ │ │ │ │ │ ├── GlobalScoreData.java
│ │ │ │ │ │ │ │ │ │ │ ├── RatingData.java
│ │ │ │ │ │ │ │ │ │ ├── service
│ │ │ │ │ │ │ │ │ │ │ ├── FoodDetailsAggregator.java
│ │ │ │ │ │ │ │ │ │ │ ├── FoodDetailsAggregatorImpl.java
│ │ │ │ │ │ │ │ │ │ │ ├── SimpleCXFNonSpringServlet.java
│ │ │ │ │ │ │ │ │ │ ├── utils
│ │ │ │ │ │ │ │ │ │ │ ├── Utility.java
│ │ │ │ │ ├── resources
│ │ │ │ │ │ ├── fooddetailsaggregator.wsdl.xml
│ │ │ │ │ ├── webapp
│ │ │ │ │ │ ├── WEB-INF
│ │ │ │ │ │ │ ├── web.xml
│ │ │ ├── .classpath
│ │ │ ├── .project
│ │ │ ├── FoodDetailsAggregator.iml
│ │ │ ├── pom.xml
│ ├── Prosumers
│ │ ├── FoodSearchProsumer
│ │ │ ├── .settings
│ │ │ │ ├── .jsdtscope
│ │ │ │ ├── org.eclipse.core.resources.prefs
│ │ │ │ ├── org.eclipse.jdt.apt.core.prefs
│ │ │ │ ├── org.eclipse.jdt.core.prefs
│ │ │ │ ├── org.eclipse.m2e.core.prefs
│ │ │ │ ├── org.eclipse.wst.common.component
│ │ │ │ ├── org.eclipse.wst.common.project.facet.core.xml
│ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.container
│ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.name
│ │ │ │ ├── org.eclipse.wst.validation.prefs
│ │ │ ├── src
│ │ │ │ ├── main
│ │ │ │ │ ├── java
│ │ │ │ │ │ ├── it
│ │ │ │ │ │ │ ├── univaq
│ │ │ │ │ │ │ │ ├── disim
│ │ │ │ │ │ │ │ │ ├── sose
│ │ │ │ │ │ │ │ │ │ ├── search
│ │ │ │ │ │ │ │ │ │ │ ├── model
│ │ │ │ │ │ │ │ │ │ │ │ ├── Result.java
│ │ │ │ │ │ │ │ │ │ │ ├── FoodSearchServlet.java
│ │ │ │ │ │ │ │ │ │ │ ├── Search.java
│ │ │ │ │ │ │ │ │ │ │ ├── SearchException.java
│ │ │ │ │ │ │ │ │ │ │ ├── SearchImpl.java
│ │ │ │ │ ├── webapp
│ │ │ │ │ │ ├── WEB-INF
│ │ │ │ │ │ │ ├── web.xml
│ │ │ ├── .classpath
│ │ │ ├── .project
│ │ │ ├── FoodSearchProsumer.iml
│ │ │ ├── pom.xml
│ │ ├── FoodDetailsProsumer
│ │ │ ├── .settings
│ │ │ │ ├── .jsdtscope
│ │ │ │ ├── org.eclipse.core.resources.prefs
│ │ │ │ ├── org.eclipse.jdt.apt.core.prefs
│ │ │ │ ├── org.eclipse.jdt.core.prefs
│ │ │ │ ├── org.eclipse.m2e.core.prefs
│ │ │ │ ├── org.eclipse.wst.common.component
│ │ │ │ ├── org.eclipse.wst.common.project.facet.core.prefs.xml
│ │ │ │ ├── org.eclipse.wst.common.project.facet.core.xml
│ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.container
│ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.name
│ │ │ │ ├── org.eclipse.wst.validation.prefs
│ │ │ ├── .vscode
│ │ │ │ ├── settings.json
│ │ │ ├── bin
│ │ │ │ ├── .settings
│ │ │ │ │ ├── .jsdtscope
│ │ │ │ │ ├── org.eclipse.core.resources.prefs
│ │ │ │ │ ├── org.eclipse.jdt.apt.core.prefs
│ │ │ │ │ ├── org.eclipse.jdt.core.prefs
│ │ │ │ │ ├── org.eclipse.m2e.core.prefs
│ │ │ │ │ ├── org.eclipse.wst.common.component
│ │ │ │ │ ├── org.eclipse.wst.common.project.facet.core.prefs.xml
│ │ │ │ │ ├── org.eclipse.wst.common.project.facet.core.xml
│ │ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.container
│ │ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.name
│ │ │ │ │ ├── org.eclipse.wst.validation.prefs
│ │ │ │ ├── src
│ │ │ │ │ ├── main
│ │ │ │ │ │ ├── java
│ │ │ │ │ │ │ ├── it
│ │ │ │ │ │ │ │ ├── univaq
│ │ │ │ │ │ │ │ │ ├── disim
│ │ │ │ │ │ │ │ │ │ ├── sose
│ │ │ │ │ │ │ │ │ │ │ ├── fooddetails
│ │ │ │ │ │ │ │ │ │ │ │ ├── data
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── EdamamRestClient.class
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── RatingDataClient.class
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── ReviewDataClient.class
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── FoodDetails.class
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── FoodDetailsImpl.class
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── FoodDetailsServlet.class
│ │ │ │ │ │ │ │ │ │ │ │ ├── model
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── AggregatedRatingData.class
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── FoodData$Nutrients.class
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── FoodData$ServingSize.class
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── FoodData.class
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── RatingData.class
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── Review.class
│ │ │ │ │ │ │ │ │ │ │ │ ├── ReviewList.class
│ │ │ │ │ │ │ │ │ │ │ │ ├── util
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── MessageAsyncHandler.class
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── Utility.class
│ │ │ │ │ │ ├── resources
│ │ │ │ │ │ │ ├── async_binding.xml
│ │ │ │ │ │ │ ├── filmdetailsaggregator.wsdl.xml
│ │ │ │ │ │ ├── webapp
│ │ │ │ │ │ │ ├── WEB-INF
│ │ │ │ │ │ │ │ ├── web.xml
│ │ │ │ ├── .classpath
│ │ │ │ ├── .gitignore
│ │ │ │ ├── .project
│ │ │ │ ├── pom.xml
│ │ │ ├── src
│ │ │ │ ├── main
│ │ │ │ │ ├── java
│ │ │ │ │ │ ├── it
│ │ │ │ │ │ │ ├── univaq
│ │ │ │ │ │ │ │ ├── disim
│ │ │ │ │ │ │ │ │ ├── sose
│ │ │ │ │ │ │ │ │ │ ├── fooddetails
│ │ │ │ │ │ │ │ │ │ │ ├── data
│ │ │ │ │ │ │ │ │ │ │ │ ├── EdamamRestClient.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── RatingDataClient.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── ReviewDataClient.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── FoodDetails.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── FoodDetailsImpl.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── FoodDetailsServlet.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── model
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── AggregatedRatingData.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── FoodData.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── RatingData.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── Review.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── ReviewList.java
│ │ │ │ │ │ │ │ │ │ │ ├── util
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── MessageAsyncHandler.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── Utility.java
│ │ │ │ │ │ ├── resources
│ │ │ │ │ │ │ ├── async_binding.xml
│ │ │ │ │ │ │ ├── fooddetailsaggregator.wsdl.xml
│ │ │ │ │ │ ├── webapp
│ │ │ │ │ │ │ ├── WEB-INF
│ │ │ │ │ │ │ │ ├── web.xml
│ │ │ ├── .classpath
│ │ │ ├── .gitignore
│ │ │ ├── .project
│ │ │ ├── pom.xml
│ │ │ ├── ReviewEditorProsumer.iml
│ ├── react-webapp
│ │ ├── public
│ │ │ ├── favicon.ico
│ │ │ ├── index.html
│ │ │ ├── manifest.json
│ │ │ ├── robots.txt
│ │ ├── src
│ │ │ ├── components
│ │ │ │ ├── App.js
│ │ │ │ ├── Login.js
│ │ │ │ ├── SignUp.js
│ │ │ ├── css
│ │ │ │ ├── App.css
│ │ │ │ ├── index.css
│ │ │ ├── index.js
│ │ │ ├── reportWebVitals.js
│ │ │ ├── setupTests.js
│ │ ├── .gitignore
│ │ ├── package-lock.json
│ │ ├── package.json
│ │ ├── README.md
│ ├── Services
│ │ ├── AuthService
│ │ │ ├── .settings
│ │ │ │ ├── .jsdtscope
│ │ │ │ ├── org.eclipse.core.resources.prefs
│ │ │ │ ├── org.eclipse.jdt.apt.core.prefs
│ │ │ │ ├── org.eclipse.jdt.core.prefs
│ │ │ │ ├── org.eclipse.m2e.core.prefs
│ │ │ │ ├── org.eclipse.wst.common.component
│ │ │ │ ├── org.eclipse.wst.common.project.facet.core.prefs.xml
│ │ │ │ ├── org.eclipse.wst.common.project.facet.core.xml
│ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.container
│ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.name
│ │ │ │ ├── org.eclipse.wst.validation.prefs
│ │ │ ├── src
│ │ │ │ ├── main
│ │ │ │ │ ├── java
│ │ │ │ │ │ ├── it
│ │ │ │ │ │ │ ├── univaq
│ │ │ │ │ │ │ │ ├── disim
│ │ │ │ │ │ │ │ │ ├── sose
│ │ │ │ │ │ │ │ │ │ ├── domain
│ │ │ │ │ │ │ │ │ │ │ ├── User.java
│ │ │ │ │ │ │ │ │ │ ├── service
│ │ │ │ │ │ │ │ │ │ │ ├── Authentic
│ │ │ │ │ │ │ │ │ │ │ │ ├── AuthService.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── AuthServiceImpl.java
│ │ │ │ │ │ │ │ │ │ │ ├── DAO
│ │ │ │ │ │ │ │ │ │ │ │ ├── DAOFactory.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── SQLiteDAOFactory.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── SQLiteUserDAOImpl.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── UserDAO.java
│ │ │ │ │ │ │ │ │ │ ├── utils
│ │ │ │ │ │ │ │ │ │ │ ├── Utils.java
│ │ │ │ │ ├── resources
│ │ │ │ │ │ ├── openapi-configuration.json
│ │ │ │ │ │ ├── user.db
│ │ │ │ ├── webapp
│ │ │ │ │ ├── WEB-INF
│ │ │ │ │ │ ├── web.xml
│ │ │ ├── .classpath
│ │ │ ├── .project
│ │ │ ├── AuthService.iml
│ │ │ ├── pom.xml
│ │ ├── RatingUpdaterRESTService
│ │ │ ├── .settings
│ │ │ │ ├── .jsdtscope
│ │ │ │ ├── org.eclipse.core.resources.prefs
│ │ │ │ ├── org.eclipse.jdt.apt.core.prefs
│ │ │ │ ├── org.eclipse.jdt.core.prefs
│ │ │ │ ├── org.eclipse.m2e.core.prefs
│ │ │ │ ├── org.eclipse.wst.common.component
│ │ │ │ ├── org.eclipse.wst.common.project.facet.core.prefs.xml
│ │ │ │ ├── org.eclipse.wst.common.project.facet.core.xml
│ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.container
│ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.name
│ │ │ │ ├── org.eclipse.wst.validation.prefs
│ │ │ ├── src
│ │ │ │ ├── main
│ │ │ │ │ ├── java
│ │ │ │ │ │ ├── it
│ │ │ │ │ │ │ ├── univaq
│ │ │ │ │ │ │ │ ├── disim
│ │ │ │ │ │ │ │ │ ├── sose
│ │ │ │ │ │ │ │ │ │ ├── ratingupdater
│ │ │ │ │ │ │ │ │ │ │ ├── data
│ │ │ │ │ │ │ │ │ │ │ │ ├── GlobalScoreDAO.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── GlobalScoreDAO_SQLLite.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── RatingDataDAO.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── RatingDataDAO_SQLLite.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── RatingUpdaterDAO.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── model
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── GlobalScoreData.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── RatingData.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── RatingOperationResponse.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── service
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── RatingUpdaterService.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── utils
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── UtilityMethods.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── RatingUpdater.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── RatingUpdaterImpl.java
│ │ │ │ │ ├── resources
│ │ │ │ │ │ ├── data
│ │ │ │ │ │ │ ├── globalscore_data.csv
│ │ │ │ │ │ │ ├── rating_data.csv
│ │ │ │ │ │ │ ├── rdf
│ │ │ │ │ │ │ │ ├── rating_data.rdf
│ │ │ │ │ │ │ ├── sqllite
│ │ │ │ │ │ │ │ ├── rating_data.sql
│ │ │ │ │ │ │ ├── openapi-configuration.json
│ │ │ │ │ │ ├── webapp
│ │ │ │ │ │ │ ├── WEB-INF
│ │ │ │ │ │ │ │ ├── web.xml
│ │ │ ├── .classpath
│ │ │ ├── .gitignore
│ │ │ ├── .project
│ │ │ ├── pom.xml
│ │ │ ├── RatingUpdaterRESTService.iml
│ │ ├── ReviewDataService
│ │ │ ├── .settings
│ │ │ │ ├── .jsdtscope
│ │ │ │ ├── org.eclipse.core.resources.prefs
│ │ │ │ ├── org.eclipse.jdt.apt.core.prefs
│ │ │ │ ├── org.eclipse.jdt.core.prefs
│ │ │ │ ├── org.eclipse.m2e.core.prefs
│ │ │ │ ├── org.eclipse.wst.common.component
│ │ │ │ ├── org.eclipse.wst.common.project.facet.core.prefs.xml
│ │ │ │ ├── org.eclipse.wst.common.project.facet.core.xml
│ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.container
│ │ │ │ ├── org.eclipse.wst.jsdt.ui.superType.name
│ │ │ │ ├── org.eclipse.wst.validation.prefs
│ │ │ ├── src
│ │ │ │ ├── main
│ │ │ │ │ ├── java
│ │ │ │ │ │ ├── it
│ │ │ │ │ │ │ ├── univaq
│ │ │ │ │ │ │ │ ├── disim
│ │ │ │ │ │ │ │ │ ├── sose
│ │ │ │ │ │ │ │ │ │ ├── model
│ │ │ │ │ │ │ │ │ │ │ ├── Review.java
│ │ │ │ │ │ │ │ │ │ │ ├── service
│ │ │ │ │ │ │ │ │ │ │ │ ├── DAO
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── DAOFactory.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── ReviewDAO.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── SQLiteDAOFactory.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── SQLiteReviewDAOImpl.java
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── review
│ │ │ │ │ │ │ │ │ │ │ │ │ │ ├── ReviewService.java
│ │ │ │ │ │ │ │ │ │ │ │ │ │ ├── ReviewServiceImpl.java
│ │ │ │ │ │ │ │ │ │ │ │ ├── utils
│ │ │ │ │ │ │ │ │ │ │ │ │ ├── Utils.java
│ │ │ │ │ │ ├── resources
│ │ │ │ │ │ │ ├── openapi-configuration.json
│ │ │ │ │ │ │ ├── review.db
│ │ │ │ │ │ ├── webapp
│ │ │ │ │ │ │ ├── WEB-INF
│ │ │ │ │ │ │ │ ├── web.xml
│ │ │ ├── .classpath
│ │ │ ├── .gitignore
│ │ │ ├── .project
│ │ │ ├── pom.xml
│ │ │ ├── ReviewDataService.iml
├── .gitignore
└── LICENSE
```

### How to Contribute

To contribute to this project, you need to:
- Fork the repository.
- Clone your fork: `git clone https://github.com/your-username/EatFit_Review-SOSE.git`
- Create your feature branch: `git checkout -b my-new-feature`
- Commit your changes: `git commit -am 'Add some feature'`
- Push to the branch: `git push origin my-new-feature`
- Submit a pull request.

### Frequently Asked Questions (FAQ)

**Q: Where can I find the API key?**
A: You can register and get an API key from [Edamam's Developer Portal](https://developer.edamam.com/).

**Q: How do I report a bug?**
A: Bugs can be reported in the repository's issues section.

#### Contributing
Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.
If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement". Don't forget to give the project a star! Thanks again!


#### Contact
This project has been realized for educational purposes.


####  License
This project is licensed under the MIT License - see the LICENSE file for details.
