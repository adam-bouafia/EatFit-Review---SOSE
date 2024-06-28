# EatFit & Review SOSE Project

## About the project
This repo is for the *Service Oriented Software Engineering* course project at the University of L'Aquila.

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

private String API_KEY = "ENTER YOUR API";

#### 4. And in FoodDetailsProsumer/src/main/java/it/univaq/disim/sose/fooddetails/data/EdamamRestClient.java

private static final String APIKey = "ENTER YOUR API";


#### 5. Open Eclipse IDE, create a new Tomcat instance and run all the services:

  AuthService
  FoodDetailsProsumer
  FoodDetailsAggregator
  FoodSearchProsumer
  RatingUpdaterRESTService
  ReviewDataService
  ReviewEditorProsumer

  
#### 6. Install Android application

#### Nginx Load Balancer
To use Nginx load balancer, you have to follow several steps we summarized in the NGINX Load Balancer SOSE.pdf file.

#### Usage
Opening the Android application, you can search for food items. Clicking on a result, you will be redirected to the details page where you'll see all the food metadata, the averages of the ratings, the summary global score, and the reviews of that food item. You can also sign up and sign in to rate and write a review for a food item.


#### Project Structure

EatFit & Review SOSE Project/
├── Docs
│   ├── NGINX Load Balancer SOSE.pdf
│   └── SOSE Project Documentation.pdf
├── Frontend - Java Mobile
│   ├── .gradle
│   ├── .idea
│   ├── app
│   │   ├── src
│   │   │   ├── androidTest
│   │   │   │   └── java
│   │   │   │       └── it/univaq/disim/sose/application/ExampleInstrumentedTest.java
│   │   │   ├── main
│   │   │   │   └── java
│   │   │   │       └── it/univaq/disim/sose/application
│   │   │   │           ├── adapters
│   │   │   │           │   ├── ResultAdapter.java
│   │   │   │           │   └── ReviewAdapter.java
│   │   │   │           ├── models
│   │   │   │           │   ├── FoodDetail.java
│   │   │   │           │   ├── RatingData.java
│   │   │   │           │   ├── Result.java
│   │   │   │           │   ├── Review.java
│   │   │   │           │   ├── ReviewList.java
│   │   │   │           │   └── User.java
│   │   │   │           ├── FoodDetailActivity.java
│   │   │   │           ├── FoodSearchActivity.java
│   │   │   │           ├── LoginActivity.java
│   │   │   │           ├── MainActivity.java
│   │   │   │           ├── RestClient.java
│   │   │   │           ├── ReviewActivity.java
│   │   │   │           └── SignupActivity.java
│   │   │   ├── res
│   │   │   │   ├── drawable
│   │   │   │   ├── drawable-finger
│   │   │   │   ├── drawable-v24
│   │   │   │   ├── font
│   │   │   │   ├── layout
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── add_review.xml
│   │   │   │   │   ├── auth_login.xml
│   │   │   │   │   ├── auth_signup.xml
│   │   │   │   │   ├── foodsearch.xml
│   │   │   │   │   ├── food_detail.xml
│   │   │   │   │   ├── review_row.xml
│   │   │   │   │   └── single_row.xml
│   │   │   │   ├── mipmap-anydpi-v26
│   │   │   │   ├── mipmap-hdpi
│   │   │   │   ├── mipmap-mdpi
│   │   │   │   ├── mipmap-xhdpi
│   │   │   │   ├── mipmap-xxhdpi
│   │   │   │   ├── mipmap-xxxhdpi
│   │   │   │   ├── values
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── font_certs.xml
│   │   │   │   │   ├── preloaded_fonts.xml
│   │   │   │   │   ├── spinner.xml
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── themes.xml
│   │   │   │   ├── values-night
│   │   │   │   │   └── themes.xml
│   │   │   │   └── xml
│   │   │   │       ├── backup_rules.xml
│   │   │   │       └── data_extraction_rules.xml
│   │   │   ├── AndroidManifest.xml
│   │   │   └── home_icon-playstore.png
│   │   ├── test
│   │   │   └── java
│   │   │       └── it/univaq/disim/sose/application/ExampleUnitTest.java
│   │   ├── .gitignore
│   │   ├── build.gradle
│   │   ├── proguard-rules.pro
│   ├── gradle
│   │   └── wrapper
│   │       ├── gradle-wrapper.jar
│   │       └── gradle-wrapper.properties
│   ├── build.gradle
│   ├── gradle.properties
│   ├── gradlew
│   ├── gradlew.bat
│   ├── local.properties
│   ├── README.md
│   └── settings.gradle
├── MagicDraw Diagrams
│   ├── Diagrams PNG
│   │   ├── component__ComponentDiagram.png
│   │   ├── sd__Add_review_and_ranking__Add_review_and_ranking.png
│   │   ├── sd__Authentication__Authentication.png
│   │   ├── sd__Registration__Registration.png
│   │   ├── sd__Show_Food_information__Show_Food_information.png
│   │   ├── sd__Show_list_of_Food__Show_list_of_Food.png
│   │   └── uc__Model.png
│   └── SOSE_Project.mdzip
├── .gitignore
└── LICENSE

### Detailed Usage

After installing the app, you can start exploring the wide variety of foods by using the search functionality. Here are some steps to get you started:
- **Step 1:** Open the app and navigate to the search bar.
  
- **Step 2:** Enter the name of the food item you're interested in.
  
- **Step 3:** Browse through the search results and click on any item to view detailed nutritional information and reviews.

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
