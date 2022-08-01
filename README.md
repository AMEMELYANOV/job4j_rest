[![Build Status](https://app.travis-ci.com/AMEMELYANOV/job4j_rest.svg?branch=master)](https://app.travis-ci.com/AMEMELYANOV/job4j_rest)
[![codecov](https://codecov.io/gh/AMEMELYANOV/job4j_rest/branch/master/graph/badge.svg?token=R43d2k5U8Q)](https://codecov.io/gh/AMEMELYANOV/job4j_rest)
# job4j_rest

## Описание проекта
Spring Boot проект с демонстрацией работы Rest сервиса через RestTemplate.

# Функционал:
- Создание пользователей.
- Получение списка пользователей.
- Получение пользователя по id.
- Редактирование пользователя.
- Удаление пользователей.

# Применяемые технологии:
* Java 14
* Spring Boot, Spring Data, Spring Test
* PosgreSQL, Liquibase
# Применяемые инструменты:
* Maven, Checkstyle, Travis CI

## Сборка и запуск:
Для выполнения действий данного раздела необходимо установить
и настроить систему сборки проектов Maven.

По умолчании проект компилируется и собирается в директорию target.

## 1. Сборка проекта.
Команда для сборки в jar
`mvn clean package -DskipTests`

### 2. Запуск проекта.
Команда для запуска
`java -jar target/auth-1.0.jar`

## Примеры работы:
Все действия в проекте возможны с использованием PersonController
и ReportController вызывающего PersonController через RestTemplate.
### 1. Работа с PersonController.
* GET/person/ список всех пользователей.
* GET/person/{id} - пользователь с id.
* POST/person/ - создает пользователя.
* PUT/person/ - обновляет пользователя.
* DELETE/person/{id} - удаляет.

Пример:

![alt text](images/auth_img_1.jpg)


### 2. Работа с ReportController.
* GET/report/ список всех пользователей.
* GET/report/{id} - пользователь с id.
* POST/report/ - создает пользователя.
* PUT/report/ - обновляет пользователя.
* DELETE/report/{id} - удаляет.
ReportController может оборачивать отчетные данные
от PersonController в свои данные, добавлять номер
отчета и время.

Пример:

![alt text](images/auth_img_2.jpg)

## TODO list
* Реализовать EmployeeController - владельца пользователей.

## Контакты

[![alt-text](https://img.shields.io/badge/-telegram-grey?style=flat&logo=telegram&logoColor=white)](https://t.me/T_AlexME)&nbsp;&nbsp;
[![alt-text](https://img.shields.io/badge/@%20email-005FED?style=flat&logo=mail&logoColor=white)](mailto:amemelyanov@yandex.ru)&nbsp;&nbsp;

