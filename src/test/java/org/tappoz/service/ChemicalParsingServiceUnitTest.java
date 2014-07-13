package org.tappoz.service;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.tappoz.bean.BasicAmount;
import org.tappoz.bean.IngredientContent;

@RunWith(MockitoJUnitRunner.class)
public class ChemicalParsingServiceUnitTest {

    // the 2 services to be stubbed
    @Mock
    ChemicalStringProcessorService chemicalStringProcessorService;
    @Mock
    IngredientLabelCleaningService ingredientLabelCleaningService;

    @InjectMocks
    ChemicalParsingService sut; // system under test

    @Test
    public void test_processComplexIngredient() {

        // input parameter
        final String COMPLEX_INGREDIENT = "275 ml of naptha";

        // bean used in the isolation process
        BasicAmount basicAmount = new BasicAmount();
        basicAmount.setValue("275");
        basicAmount.setUnitOfMeasure("ml");

        // stubbing of the DOCs (depended on component)
        Mockito.when(chemicalStringProcessorService.parseThisIngredient(COMPLEX_INGREDIENT)).thenReturn(basicAmount);
        Mockito.when(ingredientLabelCleaningService.cleanIngredientName("  of naptha")).thenReturn("naptha");

        // given
        String expectedToBeParsed = COMPLEX_INGREDIENT;

        // when
        IngredientContent outputBean = sut.processComplexIngredient(expectedToBeParsed);

        // then
        MatcherAssert.assertThat( outputBean.getIngredientName()                 , Matchers.is("naptha") );
        MatcherAssert.assertThat( outputBean.getWrapperAmount()                  , Matchers.nullValue()  );
        MatcherAssert.assertThat( outputBean.getBasicAmount().getRangeValue()    , Matchers.nullValue()  );
        MatcherAssert.assertThat( outputBean.getBasicAmount().getValue()         , Matchers.is("275")    );
        MatcherAssert.assertThat( outputBean.getBasicAmount().getUnitOfMeasure() , Matchers.is("ml")     );
    }
}
