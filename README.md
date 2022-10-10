#Test Automation Web Challenge
###Escenarios en el Feature:
- Ir a la web: https://www.demoblaze.com/index.html
- Dar de alta un usuario.
- Login y logout con el usuario dado de alta.
- Agregar una laptop al carrito.
- Comprobar que se agregó al carrito.

###Datos Técnicos:
- Java 11
- Selenium
- TestNg
- Cucumber
- Allure (Report)

###Ejecución por Terminal:
- Test: mvn clean test / mvn test
- Reporte: mvn allure:serve (Opcional)

###Estructura:
1. Main: 

    1.1 com.challenge.config 

    1.1.1 ConfigPage: 
    - Contiene los parámetros iniciales de configuración. 
    - Se implementó la librería WebDriverManager, para automatizar el proceso de obtención del chromedriver/geckodriver, no es necesario agregarlo ni actualizarlo.
    - Manejo de métodos de selenium.

    1.2 LoggerPage:
    - Manejo de Logger (Log4j) para registrar el proceso.

    1.3 PropertiesPage:
    - Manejo de las propiedades de ejecución como Url, browser (chrome o firefox), username y password (random por ejecución).

    1.2 com.challenge.process

    //Los procesos son manejados por separados pero en ejecución son dependientes

    1.2.1 SignUpProcess: 
    - Métodos para el manejo del Registro de Usuario
    
    1.2.2 LoginProcess: 
    - Métodos para el manejo del Login del Usuario
    
    1.2.3 Logout Process: 
    - Métodos para el manejo del Logout del Usuario
    
    1.2.4 AddLaptopProcess: 
    - Métodos para el manejo del agregado del producto al carrito
    
    1.2.5 CheckCartProcess: 
    - Métodos para el manejo del chequeo del carrito de compras

2. Test:

    2.1 com.challenge.test.defs

    //Pasos en la ejecución del proceso. Asociados a los Scenarios del Feature

    2.1.1 SignUpUserTest: métodos para la ejecución del Registro de Usuario
    
    2.1.2 LoginUserTest: métodos para la ejecución del Login del Usuario
    
    2.1.3 LogoutUserTest: métodos para la ejecución del Logout del Usuario
    
    2.1.4 AddLaptopToCartTest: métodos para la ejecución del agregado del producto al carrito
    
    2.1.5 CheckCartTest: métodos para la ejecución del chequeo del carrito de compras

    2.2. RunCucumberTest.java
    Definición del ejecutable (Cucumber + TestNg)

###Escenarios
* src/test/resources/scenarios.feature contiene los Escenarios del Feature en Gherkin.
Estan ordenados debido a la dependencia de los pasos previos para su ejecución,
para evitar empezar un nuevo proceso en los casos que se requiere un usuario previamente
registrado. Para este test, cada ejecución propone un usuario/password nuevo. A pesar de esta
dependencia, los test se ejecutan por separado en cada feature, preservando en memoria
el username y password utilizados durante el registro del usuario.

###Reportes:
Se pueden obtener reportes de dos maneras:
1. Allure: mvn allure:serve una vez terminada la ejecución del test. Este reporte
muestra cada escenario ejecutado e incluye los screenshots de cada proceso.
2. Cucumber Report: reporte por defecto, es posible encontrarlo en la carpeta Target del proyecto.
No incluye screenshots.

###Screenshots:
Están configurados por defecto para incluirse en el reporte de Allure y en la carpeta
Screenshots del proyecto, a modo de backup.

###Logs:
Están configurados para registrar los procesos de la ejecución. Se registran en dos archivos,
automation.log y automation.error según el status de los que se ha registrado. Se almacenan por día
en un archivo comprimido a fin de almacenar los registros.