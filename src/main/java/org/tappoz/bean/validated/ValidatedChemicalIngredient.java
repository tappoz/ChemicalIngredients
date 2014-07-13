package org.tappoz.bean.validated;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.tappoz.enums.UnitOfMeasure;

public class ValidatedChemicalIngredient {

    private ValidatedAmount detailedAmount;
    private ValidatedAmount genericAmount;
    private String name;

    public ValidatedAmount getDetailedAmount() {
        return detailedAmount;
    }

    public void setDetailedAmount(ValidatedAmount detailedAmount) {
        this.detailedAmount = detailedAmount;
    }

    public ValidatedAmount getGenericAmount() {
        return genericAmount;
    }

    public void setGenericAmount(ValidatedAmount genericAmount) {
        this.genericAmount = genericAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Convenience method to serialise this bean as a JSON file using the Gson library.
     * @see {@link com.google.gson.Gson#toJson(Object)}
     * @return a string representing the bean in JSON format
     */
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
