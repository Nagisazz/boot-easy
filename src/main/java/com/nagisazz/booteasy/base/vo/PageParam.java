package com.nagisazz.booteasy.base.vo;

import lombok.NonNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @author NagisaZZ
 * @description: PageParam
 * @date 2019/4/22  11:49
 */
public class PageParam
{
    private static final int DEFAULT_PAGE_SIZE = 20;

    public void setSort(OrderBy sort)
    {
        this.sort = sort;
    }

    public boolean equals(Object o)
    {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PageParam)) {
            return false;
        }
        PageParam other = (PageParam)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$pageNo = getPageNo();Object other$pageNo = other.getPageNo();
        if (this$pageNo == null ? other$pageNo != null : !this$pageNo.equals(other$pageNo)) {
            return false;
        }
        Object this$pageSize = getPageSize();Object other$pageSize = other.getPageSize();
        if (this$pageSize == null ? other$pageSize != null : !this$pageSize.equals(other$pageSize)) {
            return false;
        }
        Object this$sort = getSort();Object other$sort = other.getSort();return this$sort == null ? other$sort == null : this$sort.equals(other$sort);
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof PageParam;
    }

    public int hashCode()
    {
        int PRIME = 59;int result = 1;Object $pageNo = getPageNo();result = result * 59 + ($pageNo == null ? 43 : $pageNo.hashCode());Object $pageSize = getPageSize();result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());Object $sort = getSort();result = result * 59 + ($sort == null ? 43 : $sort.hashCode());return result;
    }

    public String toString()
    {
        return "PageParam(pageNo=" + getPageNo() + ", pageSize=" + getPageSize() + ", sort=" + getSort() + ")";
    }

    public PageParam(Integer pageNo, Integer pageSize, OrderBy sort)
    {
        if ((pageNo != null) && (pageNo.intValue() >= 0)) {
            this.pageNo = pageNo;
        }
        if ((pageSize != null) && (pageSize.intValue() >= 1)) {
            this.pageSize = pageSize;
        }
        this.sort = sort;
    }

    @NonNull
    public Integer getPageNo()
    {
        return this.pageNo;
    }

    @NonNull
    private Integer pageNo = Integer.valueOf(0);

    public void setPageNo(Integer pageNo)
    {
        if ((pageNo == null) || (pageNo.intValue() < 0)) {
            return;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageSize()
    {
        return this.pageSize;
    }

    private Integer pageSize = Integer.valueOf(20);
    private OrderBy sort;

    public void setPageSize(Integer pageSize)
    {
        if ((pageSize == null) || (pageSize.intValue() < 1)) {
            return;
        }
        this.pageSize = pageSize;
    }

    public OrderBy getSort()
    {
        return this.sort;
    }

    public boolean hasPrevious()
    {
        return getPageNo().intValue() > 0;
    }

    public PageParam next()
    {
        return new PageParam(Integer.valueOf(getPageNo().intValue() + 1), getPageSize(), getSort());
    }

    public PageParam previousOrFirst()
    {
        return hasPrevious() ? new PageParam(Integer.valueOf(getPageNo().intValue() - 1), getPageSize(), getSort()) : this;
    }

    public PageParam first()
    {
        return new PageParam(Integer.valueOf(0), getPageSize(), getSort());
    }

    public int getOffset()
    {
        return getPageNo().intValue() * getPageSize().intValue();
    }

    public PageRequest createPageRequest()
    {
        if (this.sort == null) {
            return new PageRequest(this.pageNo.intValue(), this.pageSize.intValue());
        }
        return new PageRequest(this.pageNo.intValue(), this.pageSize.intValue(), buildSort());
    }

    public Sort buildSort()
    {
        if (this.sort == null) {
            return null;
        }
        if (this.sort.getSortFileds() == null) {
            return null;
        }
        if (this.sort.getSortFileds().length <= 0) {
            return null;
        }
        if (this.sort.isAsc()) {
            return new Sort(Sort.Direction.ASC, this.sort.getSortFileds());
        }
        return new Sort(Sort.Direction.DESC, this.sort.getSortFileds());
    }

    public PageParam() {}
}
