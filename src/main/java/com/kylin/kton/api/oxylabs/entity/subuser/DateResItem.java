/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import lombok.Generated;

public class DateResItem {
    private String date;
    private double value;

    public DateResItem(String date, double value) {
        this.date = date;
        this.value = value;
    }

    @Generated
    public String getDate() {
        return this.date;
    }

    @Generated
    public double getValue() {
        return this.value;
    }

    @Generated
    public void setDate(String date) {
        this.date = date;
    }

    @Generated
    public void setValue(double value) {
        this.value = value;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DateResItem)) {
            return false;
        }
        DateResItem other = (DateResItem)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (Double.compare(this.getValue(), other.getValue()) != 0) {
            return false;
        }
        String this$date = this.getDate();
        String other$date = other.getDate();
        return !(this$date == null ? other$date != null : !this$date.equals(other$date));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DateResItem;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $value = Double.doubleToLongBits(this.getValue());
        result = result * 59 + (int)($value >>> 32 ^ $value);
        String $date = this.getDate();
        result = result * 59 + ($date == null ? 43 : $date.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "DateResItem(date=" + this.getDate() + ", value=" + this.getValue() + ")";
    }
}

