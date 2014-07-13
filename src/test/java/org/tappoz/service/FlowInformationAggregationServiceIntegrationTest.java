package org.tappoz.service;

import com.google.common.collect.Lists;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tappoz.bean.validated.ValidatedChemicalIngredient;
import org.tappoz.enums.UnitOfMeasure;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class FlowInformationAggregationServiceIntegrationTest {
    @Autowired
    private FlowInformationAggregationService instanceUnderTest;

    /**
     * Testing an input containing values in range
     */
    @Test
    public void test_processInputList_IngredientWithRange() {
        List<String> inputStrings = Lists.newArrayList("3 to 4 ml of water");
        List<ValidatedChemicalIngredient> outputList = instanceUnderTest.processInputList(inputStrings);

        MatcherAssert.assertThat(outputList, Matchers.hasSize(1));

        ValidatedChemicalIngredient outputBean = outputList.get(0);

        MatcherAssert.assertThat( outputBean.getDetailedAmount().getAmount()        , Matchers.is(3.5)              );
        MatcherAssert.assertThat( outputBean.getDetailedAmount().getUnitOfMeasure() , Matchers.is(UnitOfMeasure.ml) );
        MatcherAssert.assertThat( outputBean.getGenericAmount()                     , Matchers.nullValue()          );
        MatcherAssert.assertThat( outputBean.getName()                              , Matchers.is("water")          );
    }

    /**
     * Testing an input containing a complex fraction
     */
    @Test
    public void test_processInputList_IngredientWithComplexFraction() {
        List<String> inputStrings = Lists.newArrayList("1 1/2 grams of sodium carbonate");
        List<ValidatedChemicalIngredient> outputList = instanceUnderTest.processInputList(inputStrings);

        MatcherAssert.assertThat(outputList, Matchers.hasSize(1));

        ValidatedChemicalIngredient outputBean = outputList.get(0);

        MatcherAssert.assertThat( outputBean.getDetailedAmount().getAmount()        , Matchers.is(1.5)                );
        MatcherAssert.assertThat( outputBean.getDetailedAmount().getUnitOfMeasure() , Matchers.is(UnitOfMeasure.g)    );
        MatcherAssert.assertThat( outputBean.getGenericAmount()                     , Matchers.nullValue()            );
        MatcherAssert.assertThat( outputBean.getName()                              , Matchers.is("sodium carbonate") );
    }

    /**
     * Testing an input containing a detailed and a generic amount
     */
    @Test
    public void test_processInputList_IngredientWithDetailedAndGenericAmounts() {
        List<String> inputStrings = Lists.newArrayList("5 tablespoons (70 grams) of lye");
        List<ValidatedChemicalIngredient> outputList = instanceUnderTest.processInputList(inputStrings);

        MatcherAssert.assertThat(outputList, Matchers.hasSize(1));

        ValidatedChemicalIngredient outputBean = outputList.get(0);

        MatcherAssert.assertThat( outputBean.getDetailedAmount().getAmount()        , Matchers.is(70.0)                     );
        MatcherAssert.assertThat( outputBean.getDetailedAmount().getUnitOfMeasure() , Matchers.is(UnitOfMeasure.g)          );
        MatcherAssert.assertThat( outputBean.getGenericAmount().getAmount()         , Matchers.is(5.0)                      );
        MatcherAssert.assertThat( outputBean.getGenericAmount().getUnitOfMeasure()  , Matchers.is(UnitOfMeasure.tablespoon) );
        MatcherAssert.assertThat( outputBean.getName()                              , Matchers.is("lye")                    );
    }
}
