<h1 align="center"> Zenith </h1>

```
- DavidLakeT
```

---

## Introduction[](#introduction)

**Zenith** is an implementation of a RESTful API built under the Spring Boot framework. It was developed following industry best practices as well as SOLID principles. Zenith makes use of the Hibernate ORM to perform the database management (which is handled with containers using Docker).

---

## Table of contents[](#table-of-contents)
- [Motivation](#motivation)
- [Composition](#composition)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Cloning the repository](#cloning-the-repository)
  - [Setting up the database](#setting-up-the-database)
  - [Running the app](#running-the-app)
- [Roadmap](#roadmap)
- [License](#license)
- [Call to action](#call-to-action)
- [Contact](#contact)

---

## Motivation[](#motivation)

This project was carried out with the intention of putting into practice concepts oriented towards backend development; this is why we sought to simulate in a simple way all the components that make up an API, among these:
- _Repositories_, where to perform the management of CRUD operations with the system models.
- Services_, where the business logic is handled.
- Controllers_, responsible for the correct handling of requests and their responses.

<div align="right">[ <a href="#table-of-contents">↑ Back to top ↑</a> ]</div>

---

## Composition[](#composition)

Generally speaking, **Zenith** has as main components:
- **ORM:** Hibernate.
- **Framework:** Spring Boot.
- **Database:** PostgreSQL.
- **Libraries:** Lombok (Annotation processor), ModelMapper.

<div align="right">[ <a href="#table-of-contents">↑ Back to top ↑</a> ]</div>

---

## Getting Started[](#getting-started)

### Prerequisites[](#prerequisites)

* **Java Development Kit (JDK):** Zenith requires that you have Java 8 JDK or higher installed on your system to build and run the applications.

### Cloning the repository[](#cloning-the-repository)

First, you need to clone the repository from GitHub. To do this, you can open a terminal and run the following command:

```
git clone https://github.com/DavidLakeT/zenith.git
```

### Setting up the database[](#setting-up-the-database)

```
cd docker
./service.sh up
```

### Running the app[](#running-the-app)

```
./gradlew bootrun
```

---

## Roadmap[](#roadmap)

Zenith's goal is to simply embrace vital concepts in the world of backend development and microservices through an API that can serve a few endpoints. 

Here are some of the aspects that could be considered in the future for the implementation of the project:
- Models that can interact with each other (ex: Products + Customers).
- Authentication + User validation.
- Session management (JWT).

The development of Zenith is currently frozen so these features are open to public intention to contribute to open-source development.

<div align="right">[ <a href="#table-of-contents">↑ Back to top ↑</a> ]</div>

---

## License[](#license)

Zenith is under free open source [_MIT License_](https://github.com/DavidLakeT/zenith/blob/master/LICENSE.txt).

<div align="right">[ <a href="#table-of-contents">↑ Back to top ↑</a> ]</div>

---

## Call to action[](#call-to-action)

Join this project and provide assistance by:
* Checking out the list of [open issues](https://github.com/DavidLakeT/zenith/issues) where we need help.
* If you need new features, please open a [new issue](https://github.com/DavidLakeT/zenith/issues) or start a [discussion](https://github.com/DavidLakeT/zenith/discussions).

Feel free to contact me if you have any questions or contributions to make to the project.

<div align="right">[ <a href="#table-of-contents">↑ Back to top ↑</a> ]</div>

---

## Contact[](#contact)
 - [Instagram](https://www.instagram.com/whatdavedoes/)
 - [Linkedin](https://www.linkedin.com/in/davidlaket/)
 - djcardonan@eafit.edu.co

Project Link: [https://github.com/DavidLakeT/zenith](https://github.com/DavidLakeT/zenith)

<div align="right">[ <a href="#table-of-contents">↑ Back to top ↑</a> ]</div>
