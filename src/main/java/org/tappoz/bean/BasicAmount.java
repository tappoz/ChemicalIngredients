package org.tappoz.bean;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by tappoz on 11/07/14.
 */
public class BasicAmount {

    private String value;
    private String unitOfMeasure;
    private String[] rangeValue;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String[] getRangeValue() {
        return rangeValue;
    }

    public void setRangeValue(String[] rangeValue) {
        this.rangeValue = rangeValue;
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
