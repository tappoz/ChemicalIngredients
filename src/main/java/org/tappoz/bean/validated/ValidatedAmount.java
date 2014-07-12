package org.tappoz.bean.validated;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.tappoz.enums.UnitOfMeasure;

/**
 * Created by tappoz on 12/07/14.
 */
public class ValidatedAmount {

    private Double amount;
    private UnitOfMeasure unitOfMeasure;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
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
