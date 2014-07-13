package org.tappoz.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tappoz.bean.validated.ValidatedChemicalIngredient;
import org.tappoz.service.FlowInformationAggregationService;

import java.util.ArrayList;
import java.util.List;

/**
 * This is just the class containing the main method
 */
public class ChemicalIngredientsRunner {

    /**
     * This annotation might be highlighted as an error by some IDEs e.g. IntelliJ IDEA,
     * however there are no errors given that in the constructor method a Spring context
     * gets loaded enabling the following Spring service to be used.
     *
     * @see {the constructor @link ChemicalIngredientsRunner#ChemicalIngredientsRunner()}
     * @see {@link org.springframework.beans.factory.annotation.Autowired}
     */
    @Autowired
    private FlowInformationAggregationService flowInformationAggregationService;

    /**
     * This is the constructor that loads the Spring context enabling the autowiring capability.
     * @see {@link org.springframework.beans.factory.config.AutowireCapableBeanFactory}
     * @see {@link org.springframework.beans.factory.annotation.Autowired}
     */
    public ChemicalIngredientsRunner() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        // the following factory enables a Spring context to work embedded in a main method
        // instance of a class that gets created outside of Spring's control
        AutowireCapableBeanFactory acbFactory = context.getAutowireCapableBeanFactory();
        // the class containing the main method gets autowired to the Spring context
        acbFactory.autowireBean(this);
    }

    /**
     * This is the main method.
     * It instantiate an instance of this class by itself in order
     * to enable the loading of the Spring context.
     * Then it fires another method of this same class.
     * @see {@link #startProcess()}
     *
     * @param args
     */
    public static void main(String[] args) {

        ChemicalIngredientsRunner mainRunner = new ChemicalIngredientsRunner();
        mainRunner.startProcess();
    }

    /**
     * This is a convenience method dealing with a sample of input parameters
     * (a list of strings representing chemical ingredients).
     * This method calls a Spring service to start the parsing process.
     * @see {@link org.tappoz.service.FlowInformationAggregationService}
     * @see {@link org.springframework.stereotype.Service}
     */
    private void startProcess() {
        List<String> chemicalIngredientsToParse = new ArrayList<>();
        chemicalIngredientsToParse.add("3 to 4 ml of water");
        chemicalIngredientsToParse.add("5 grams of calcium carbide");
        chemicalIngredientsToParse.add("50 g of bark powder");
        chemicalIngredientsToParse.add("1 1/2 grams of sodium carbonate");
        chemicalIngredientsToParse.add("1/2 litres of water");
        chemicalIngredientsToParse.add("2.5 cups acidic water");
        chemicalIngredientsToParse.add("5 tablespoons (70 grams) of lye");
        chemicalIngredientsToParse.add("275 ml of naptha");
        chemicalIngredientsToParse.add("2 1/2 grams of white crystal DMT");
        chemicalIngredientsToParse.add("2 or 3 ounces of alcohol");
        chemicalIngredientsToParse.add("3.5 grams of sodium bisulfate");
        chemicalIngredientsToParse.add("0.1 grams of luminol");
        chemicalIngredientsToParse.add("1 1/2 cups KNO3");
        chemicalIngredientsToParse.add("three parts potassium nitrate");
        chemicalIngredientsToParse.add("five parts of charcoal");
        chemicalIngredientsToParse.add("5.6 to 9.3 ml of phenolphthalein");

        List<ValidatedChemicalIngredient> outputList = flowInformationAggregationService.processInputList(chemicalIngredientsToParse);

        for(ValidatedChemicalIngredient currentChemicalIngredient : outputList) {
            System.out.println(currentChemicalIngredient.toJson());
        }
    }
}
