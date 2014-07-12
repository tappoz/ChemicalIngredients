package org.tappoz.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tappoz on 12/07/14.
 */
public enum UnitOfMeasure {

    // only lowercase (cfr. the find method below)
    mg("mg", "milligram", "milligrams"),
    g("g", "gram", "grams"),
    kg("kg", "kilogram", "kilograms"),
    ml("ml", "millilitre", "millilitres", "milliliter", "milliliters"), // both British and American spelling
    cl("cl", "centilitre", "centilitres", "centiliter", "centiliters"), // both British and American spelling
    l("l", "litre", "litres", "liter", "liters"), // both British and American spelling
    oz("oz", "oz.", "ounce", "ounces"),
    lb("lb", "lb.", "pound", "pounds"),
    teaspoon("teaspoon", "teaspoons",
            "ts.", "tsp.", "tspn.",
            "ts", "tsp", "tspn", "tsps"),
    tablespoon("tablespoon", "tablespoons",
            "tb", "tbs", "tbsp", "tblsp", "tblspn", "tbl",
            "tb.", "tbs.", "tbsp.", "tblsp.", "tblspn.", "tbl.", "tbsps"),
    cup("cup", "cups", "c.", "c"),
    unit("part", "parts", "unit", "units"); // we are merging "parts" and "units" here...
    ;

    @Override
    public String toString() {
        return this.name();
    }

    private final List<String> values;

    private final static Logger log = LoggerFactory.getLogger(UnitOfMeasure.class);

    private UnitOfMeasure(String... values) {
        this.values = Arrays.asList(values);
    }

    public List<String> getValues() {
        return values;
    }

    public static UnitOfMeasure find(String name) {

        String lowerCaseName = name.toLowerCase();
        for (UnitOfMeasure currentEnumEvaluated : UnitOfMeasure.values()) {
            if (currentEnumEvaluated.getValues().contains(lowerCaseName)) {
                return currentEnumEvaluated;
            }
        }
        log.warn("Can not find this expected unit of measure coming as an input string: '" + name + "' returning null");
        return null;
    }
}
