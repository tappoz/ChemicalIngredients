package org.tappoz.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tappoz.bean.IngredientContent;
import org.tappoz.bean.validated.ValidatedChemicalIngredient;
import org.tappoz.service.FlowInformationAggregationService;

import java.util.ArrayList;
import java.util.List;

public class ChemicalIngredientsRunner {

    @Autowired
    private FlowInformationAggregationService flowInformationAggregationService;

    public ChemicalIngredientsRunner() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AutowireCapableBeanFactory acbFactory = context.getAutowireCapableBeanFactory();
        acbFactory.autowireBean(this);
    }

    public static void main(String[] args) {

        ChemicalIngredientsRunner mainRunner = new ChemicalIngredientsRunner();
        mainRunner.startProcess();
    }

    private void startProcess() {
        List<String> chemicalIngredientsToParse = new ArrayList<>();
        chemicalIngredientsToParse.add("3 to 4 ml of water");
//        chemicalIngredientsToParse.add("5 grams of calcium carbide");
//        chemicalIngredientsToParse.add("50 g of bark powder");
//        chemicalIngredientsToParse.add("1 1/2 grams of sodium carbonate");
//        chemicalIngredientsToParse.add("1/2 litres of water");
//        chemicalIngredientsToParse.add("2.5 cups acidic water");
//        chemicalIngredientsToParse.add("5 tablespoons (70 grams) of lye");
//        chemicalIngredientsToParse.add("275 ml of naptha");
//        chemicalIngredientsToParse.add("2 1/2 grams of white crystal DMT");
//        chemicalIngredientsToParse.add("2 or 3 ounces of alcohol");
//        chemicalIngredientsToParse.add("3.5 grams of sodium bisulfate");
//        chemicalIngredientsToParse.add("0.1 grams of luminol");
//        chemicalIngredientsToParse.add("1 1/2 cups KNO3");
        chemicalIngredientsToParse.add("three parts potassium nitrate");
        chemicalIngredientsToParse.add("five parts of charcoal");
//        chemicalIngredientsToParse.add("5 to 10 ml of phenolphthalein");

        List<ValidatedChemicalIngredient> outputList = flowInformationAggregationService.processInputList(chemicalIngredientsToParse);

        for(ValidatedChemicalIngredient currentChemicalIngredient : outputList) {
            System.out.println(currentChemicalIngredient.toJson());
        }
    }
}
