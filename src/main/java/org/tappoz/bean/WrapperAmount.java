package org.tappoz.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by tappoz on 11/07/14.
 */
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
}
