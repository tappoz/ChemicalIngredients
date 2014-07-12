package org.tappoz.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.tappoz.bean.IngredientContent;
import org.tappoz.service.ChemicalParsingService;
import org.tappoz.service.HelloService;

import java.util.ArrayList;
import java.util.List;

public class ChemicalIngredientsRunner {

    @Autowired
    private ChemicalParsingService chemicalParsingService;

    public ChemicalIngredientsRunner() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AutowireCapableBeanFactory acbFactory = context.getAutowireCapableBeanFactory();
        acbFactory.autowireBean(this);
    }

    public static void main(String[] args) {


//        HelloService helloService = context.getBean(HelloService.class);
//        System.out.println(helloService.sayHello());

        ChemicalIngredientsRunner mainRunner = new ChemicalIngredientsRunner();
        mainRunner.startProcess(args);

//        mainRunner.chemicalParsingService.processComplexIngredient("3 to 4 ml of water");
    }

    private void startProcess(String[] args) {
        List<String> chemicalIngredientsToParse = new ArrayList<>();
        chemicalIngredientsToParse.add("3 to 4 ml of water");
        chemicalIngredientsToParse.add("5 grams of Calcium Carbide");
        chemicalIngredientsToParse.add("1 1/2 grams of sodium carbonate");
        chemicalIngredientsToParse.add("50 grams of bark powder");
        chemicalIngredientsToParse.add("1/2 litres of water");
        chemicalIngredientsToParse.add("2.5 cups acidic water");
        chemicalIngredientsToParse.add("5 tablespoons (70 grams) of lye");
        chemicalIngredientsToParse.add("275 ml of naptha");
        chemicalIngredientsToParse.add("2 1/2 grams of white crystal DMT");
        chemicalIngredientsToParse.add("2 or 3 ounces of alcohol");
        chemicalIngredientsToParse.add("3.5 grams of Sodium Bisulfate");
        chemicalIngredientsToParse.add("0.1 grams of Luminol");
        chemicalIngredientsToParse.add("three parts potassium nitrate");
        chemicalIngredientsToParse.add("1 1/2 cups KNO3");
        chemicalIngredientsToParse.add("five parts of Charcoal");
        chemicalIngredientsToParse.add("5 to 10 ml of phenolphthalein");

        for(String currentStringToParse : chemicalIngredientsToParse) {

            IngredientContent currentIngredientContent = chemicalParsingService.processComplexIngredient(currentStringToParse);
            System.out.println("");
            System.out.println(currentIngredientContent.toString());
        }
    }
}
