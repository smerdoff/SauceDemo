Обновить версии всех библиотек в проекте и ее вывод:
[INFO] --- versions-maven-plugin:2.7:display-dependency-updates (default-cli) @ SauceDemo ---
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ...... 3.141.59 -> 4.0.0-alpha-5

1. Запустить тесты используя mvn clean test команду и ее вывод:

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 33.524 sec

2. Использовать параметры для запуска конкретных тестов и методов:
mvn clean test -Dtest=SauceDemoTest#loginTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.37 sec

mvn -Dtest=SauceDemoTest#loginTest+validateCartDetails test
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 10.421 s - in tests.SauceDemoTest

3. Создать альтернативный pom.xml и запустить из него mvn билд
mvn -f HerokuApp\pom.xml -Dtest=Tables#lastNameTest test

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 6.082 sec

4. Пробросить параметр из mvn command line внутрь теста
mvn -f SauceDemo\pom.xml -Dtest=SauceDemoTest#loginViaCLI -Duser=standard_user -Dpassword=secret_sauce test
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.78 s - in tests.SauceDemoTest

Коммент к таск№4:
Если использовать mvn -Dtest=SauceDemoTest#loginViaCLI -Duser=standard_user -Dpassword=secret_sauce test test
[ERROR] The goal you specified requires a project to execute but there is no POM in this directory (C:\Users\admin\IdeaProjects). Please verify you invoked Maven from the correct directory.
