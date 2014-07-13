package org.tappoz.bean;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class IngredientContent {
    BasicAmount basicAmount;
    WrapperAmount wrapperAmount;
    String ingredientName;

    public BasicAmount getBasicAmount() {
        return basicAmount;
    }

    public void setBasicAmount(BasicAmount basicAmount) {
        this.basicAmount = basicAmount;
    }

    public WrapperAmount getWrapperAmount() {
        return wrapperAmount;
    }

    public void setWrapperAmount(WrapperAmount wrapperAmount) {
        this.wrapperAmount = wrapperAmount;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
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
