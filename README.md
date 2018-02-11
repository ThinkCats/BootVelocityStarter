### UPDATE(2018-02-11)
    1. Update Transaction Config
    2. Add Spring Async Event 


### UPDATE(2017-09-18)
    1. Test Spring Transaction: 
        Transaction rolled back because it has been marked as rollback-only
    2. Solved way:
        1)  remove the final method's transaction
        2)  the exception in the final transaction should be catche, throw the exception to the final method caller.  

### UPDATE(2017-07-25)
    1. Using  thymeleaf instead of velocity
    2. Add Spring Security & JPA

### UPDATE(2016-07-12)
    1.WebSocket Support

### UPDATE(2016-07-06)
    1. YAML File Parse Support

### UPDATE(2016-07-05)
    1. Add H2 Database Support

### UPDATE (2016-07-05)
    1. Add Download
        * Using HttpServletResponse (void method)
        * Using Spring HttpEntity
        * Using HttpServletResponse (return Resource)

### UPDATE
    1.Live Reload VM option:
     ```
     -javaagent:/Users/dasouche/.m2/repository/org/springframework/springloaded/1.2.3.RELEASE/springloaded-1.2.3.RELEASE.jar -noverify

     ```

### UPDATE
    1.Add custom annotation and aop process
        * Add a custom method annotation : @Loggable
        * Add a custom method param annotation : @SerialNumber



