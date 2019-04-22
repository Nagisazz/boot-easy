package com.nagisazz.booteasy.base.vo;

import java.util.Arrays;

/**
 * @author NagisaZZ
 * @description: OrderBy
 * @date 2019/4/22  11:50
 */
public class OrderBy
{
    public void setAsc(boolean asc)
    {
        this.asc = asc;
    }

    public void setSortFileds(String[] sortFileds)
    {
        this.sortFileds = sortFileds;
    }

    public boolean equals(Object o)
    {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OrderBy)) {
            return false;
        }
        OrderBy other = (OrderBy)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (isAsc() != other.isAsc()) {
            return false;
        }
        return Arrays.deepEquals(getSortFileds(), other.getSortFileds());
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof OrderBy;
    }

    public int hashCode()
    {
        int PRIME = 59;int result = 1;result = result * 59 + (isAsc() ? 79 : 97);result = result * 59 + Arrays.deepHashCode(getSortFileds());return result;
    }

    public String toString()
    {
        return "OrderBy(asc=" + isAsc() + ", sortFileds=" + Arrays.deepToString(getSortFileds()) + ")";
    }

    public static final OrderBy DESC_ID = new OrderBy(false, new String[] { "id" });

    public OrderBy(String... sortFileds)
    {
        this.sortFileds = sortFileds;
    }

    public OrderBy(boolean asc, String... sortFileds)
    {
        this.asc = asc;
        this.sortFileds = sortFileds;
    }

    public boolean isAsc()
    {
        return this.asc;
    }

    private boolean asc = true;

    public String[] getSortFileds()
    {
        return this.sortFileds;
    }

    private String[] sortFileds = null;

    public OrderBy() {}
}

