package org.tappoz.bean;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by tappoz on 11/07/14.
 */
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

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
