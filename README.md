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
private static final String APP_ID = "ENTER YOUR APP ID";
private static final String API_KEY = "ENTER YOUR APP KEY";

#### 4. And in FoodDetailsProsumer/src/main/java/it/univaq/disim/sose/fooddetails/data/EdamamRestClient.java

private static final String APP_ID = "ENTER YOUR APP ID";
private static final String API_KEY = "ENTER YOUR APP KEY";


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
To use Nginx load balancer, you have to follow several steps we summarized in the NGINX Load Balancer SOSE.pdf file.

#### Usage
Opening the Android application, you can search for food items. Clicking on a result, you will be redirected to the details page where you'll see all the food metadata, the averages of the ratings, the summary global score, and the reviews of that food item. You can also sign up and sign in to rate and write a review for a food item.

### Detailed Usage

After installing the app, you can start exploring the wide variety of foods by using the search functionality. Here are some steps to get you started:
- **Step 1:** Open the app and navigate to the search bar.
  
- **Step 2:** Enter the name of the food item you're interested in.
  
- **Step 3:** Browse through the search results and click on any item to view detailed nutritional information and reviews.


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
