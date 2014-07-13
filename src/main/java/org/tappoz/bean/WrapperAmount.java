package org.tappoz.bean;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class WrapperAmount {

    private String value;
    private String unitOfMeasure;

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
