
<div id="top"></div>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://www.mobileaction.co/">
    <img src="https://github.com/basakstuff/AirPollutionProject/blob/master/AirPollutionF/src/img/maLogo.jpg" alt="Logo" width="100" height="100">
  </a>
  <a href="https://www.patika.dev/">
    <img src="https://github.com/basakstuff/AirPollutionProject/blob/master/AirPollutionF/src/img/patikaLogo.png" alt="Logo" width="100" height="100">
  </a>
  </div>
<div align="center">
  <a href="https://github.com/basakstuff/MobileAction-Patika-AirPollution">
    <img src="https://github.com/basakstuff/AirPollutionProject/blob/master/AirPollutionF/public/favicon.ico" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Air Pollution Project</h3>

  <p align="center">
    MobileAction & Patika Bootcamp Graduation Project
    <br />
    <a href="https://github.com/basakstuff/MobileAction-Patika-AirPollution/blob/master/MobileAction%20Java%20Spring%20-%20Bitirme%20Projesi.pdf"><strong>Explore the project details »</strong></a>
    <br />
    <br />
    <a href="#demo">View Demo</a>
    ·
    <a href="https://github.com/basakstuff/MobileAction-Patika-AirPollution/issues">Report Bug</a>
    ·
    <a href="https://github.com/basakstuff/MobileAction-Patika-AirPollution/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#swagger">Swagger</a></li>
        <li><a href="#file-structure">File Structure</a></li>
          <ul>
            <li><a href="#backend-structure">Backend Structure</a></li>
            <li><a href="#frontend-structure">Frontend Structure</a></li>
          </ul>
      </ul>
    </li>
    <li><a href="#demo">Demo</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

![screenshot (1)](https://user-images.githubusercontent.com/25417307/177406895-79e2bcab-93e2-4688-9227-ab9026e0178a.png)


Reading air pollution information according to City Name and Date Range using https://openweathermap.org/api and saving it to the database


<p align="right">(<a href="#top">back to top</a>)</p>


### Built With

* [Java 8+](https://www.java.com/)
* [Maven](https://maven.apache.org/)
* [Spring Boot 2.7.1+](https://spring.io/blog/2022/06/23/spring-boot-2-7-1-available-now)
* [ReactJs](https://reactjs.org/)
* [Axios](https://github.com/axios/axios)
* [npm](https://www.npmjs.com/)
* [React-Select](https://react-select.com/)
* [React-Router](https://reactrouter.com/)
* [Bootstrap](https://getbootstrap.com/)
* [MongoDB](https://www.mongodb.com/)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

MongoDB connection (requires changes to the "application.properties" file.)


### Installation

1. Get a free API Key at [openweathermap](https://openweathermap.org/api)
2. Clone the repo
   ```sh
   git clone https://github.com/basakstuff/AirPollutionProject.git
   ```
3. Install NPM packages (For frontend)
   ```sh
   npm install
   ```   
   ```sh
   npm start
   ```
      
4. Enter your API in `application.properties`
   ```js
   weather.api.key = 'ENTER YOUR API';
   ```
   
5. For backend

  ```sh
    mvn clean install
  ```
  
  ```sh
    mvn spring-boot:run 
  ```
  
 _and backend starts 'https://localhost:8080'_
 
<p align="right">(<a href="#top">back to top</a>)</p>

## Swagger

![Swagger](https://user-images.githubusercontent.com/25417307/177624957-f18af6d0-3b08-4b8f-b741-8c779144c88a.png)


<p align="right">(<a href="#top">back to top</a>)</p>

## File Structure
<details>

### Backend Structure
```
├───.mvn
│   └───wrapper
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───air
│   │   │           └───pollution
│   │   │               ├───api
│   │   │               ├───converter
│   │   │               ├───dto
│   │   │               ├───entity
│   │   │               ├───pojo
│   │   │               │   └───response
│   │   │               ├───repository
│   │   │               ├───service
│   │   │               │   └───impl
│   │   │               └───util
│   │   └───resources
│   │       ├───static
│   │       └───templates
│   └───test
│       └───java
│           └───com
│               └───air
│                   └───pollution
└───target
    ├───classes
    │   └───com
    │       └───air
    │           └───pollution
    │               ├───api
    │               ├───converter
    │               ├───dto
    │               ├───entity
    │               ├───pojo
    │               │   └───response
    │               ├───repository
    │               ├───service
    │               │   └───impl
    │               └───util
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    ├───maven-status
    │   └───maven-compiler-plugin
    │       ├───compile
    │       │   └───default-compile
    │       └───testCompile
    │           └───default-testCompile
    └───test-classes
        └───com
            └───air
                └───pollution
```

### Frontend Structure

```
├───components
├───content
├───dist
│   ├───assets
│   ├───css
│   └───js
├───img
├───pages
└───services

```
</details>
<!-- DEMO EXAMPLES -->

## Demo








https://user-images.githubusercontent.com/25417307/177622657-f8a59aa0-71b8-40b3-9822-2a16a8c3af81.mp4




https://user-images.githubusercontent.com/25417307/177622510-825df444-a0b9-4534-a74a-edd736e24d8a.mp4






<p align="right">(<a href="#top">back to top</a>)</p>




<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Başak ER - [Linkedin](https://www.linkedin.com/in/basaker/) - basaker98@gmail.com


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments


* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Malven's Flexbox Cheatsheet](https://flexbox.malven.co/)
* [Malven's Grid Cheatsheet](https://grid.malven.co/)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [React Icons](https://react-icons.github.io/react-icons/search)
* [Weather Logo](https://iconarchive.com/tag/weather)

<p align="right">(<a href="#top">back to top</a>)</p>



