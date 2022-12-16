# SpringBootSingersTheymeLeafCrudAppApplication

Singers CRUD Project - Spring Boot App with ThymeLeaf nad JPA

1. **Starter Files + Configuration**
2. Created Base App with Spring Boot Initializr, added dependencies for: SpringMCV, MySql, ThymeLeaf, DevTools, JPA Starter.
3. Created files and folders for: Controller, DAO, Entity, Service + Static -> index.html + singers folder.
4. Created metadata for MySql DB -> aplication.properties.

Because Spring Boot is used, there is no need to create config file, because @SpringBootApplication" replaces @Configuration, @ComponentScan etc...

5. **Entity**
6. Created Entity example, @Entity, @Table, @Id, @Columnn, @GeneraterdValue.
7. **Controller**
8. Created SingerController with basic @RequestMapping "/hello" to hello.html. Tested it with positive result.
9. Created singers-list.html with some th expressions.
10. Created @RequestMapping for getting Singers from DB. Tested id with positive result on the singers-list.html.
11. Updated all SingerServiceImpl methods connected with DB.
12. Created @RequestMapping for addSinger + created singer-form.html and updated singers-list.html.
13. Created @RequestMapping for updatingSinger + updated singer-form.html and singers-list.html.
14. Created @RequestMapping for deletingSinger + updated singer-form.html and singers-list.html.
15. Tested and fixed few bugs...
