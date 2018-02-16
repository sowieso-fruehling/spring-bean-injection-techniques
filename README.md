Examples of different techniques for choosing spring bean to be injected

When we have more beans implementing the same interface and we use interface type as the bean type while injecting it, spring will throw NoUniqueBeanDefinitionException if we don't uniquely define which implementation of that interface should be used

Presented techniques are:

     Compile time:
        - bean name based
        - Usage of @Qualifier annotation
        - Custom qualifier usage
        - Usage of @Primary annotation
        
     runtime:
        - Usage of @Profile annotation (and it's combination with @Primary)
        