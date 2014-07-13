Chemical Ingredients parser
===========================

This Java project aims at parsing strings containing information related to chemical ingredients when experimenting your own recipes. Having fun!

The need is related to make sense of strings containing quantities (perhaps as ranges), units of measure, and ingredient names. There might be different scenarios when parsing these strings:

   - `5 grams of calcium carbide` we want to identify
       - `5.0` a `Double` object;
       - `grams` a validated unit of measure;
       - `calcium carbide` the name of this ingredient.
   - `5 tablespoons (70 grams) of lye` becomes:
       - `5.0` a `Double`, `tablespoon`;
       - `70.0` a `Double`, `grams`;
       - `lye`.
   - `1 1/2 cups KNO3`
       - `1.5` a `Double` object;
       - `cup` a validated unit of measure;
       - `KNO3` the name of the ingredient.
   - When a range is used e.g. `1 to 3` or `5 or 6` then a value representing the mean is provided. 

The Context Free grammar with the parsing rules is generated with **ANTLR4**, there is some usage of **regex** as well. The **Spring** framework is used for dependency injection. The **Logback** framework is used for logging purposes. For the testing part **Hamcrest** and **JUnit** are used in combination with **Spring Test** for the integration tests, with **Mockito** for the unit tests. Some utility libraries are used to deal with string manipulation and collections manipulation (lists): **Apache Commons** and **Google Guava**. The **Gson** library is used in some cases to serialise the Java beans as JSON objects for debugging/logging purposes. 

The **BigDecimal** class is used when dealing with divisions and double objects/types in order to keep the rounding precision. A Java **enum** class is used to validate the units of measure.

How to use it
-------------

The class containing the `main` method is: `org.tappoz.run.ChemicalIngredientsRunner`.

The project is built using **Maven**. 
   - In order to generate the Java source code regarding the ANTLR grammar use this command: `mvn clean source:jar -e -X`.
   - To see the dependencies among different third party jars (e.g. Hamcrest used by JUnit) run: `mvn dependency:tree -Dverbose`.


