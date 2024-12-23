# employee-management
Employee Management System

1 $mvn -Djasypt.encryptor.password=secretkey spring-boot:run

2 export JASYPT_ENCRYPTOR_PASSWORD=secretkey and then run your application a simple java application.

3 (Using STS/Eclipse)Right click on main class > Run as > Run configuration and pass secret key in VM argument like below


-Djasypt.encryptor.password=secretkey