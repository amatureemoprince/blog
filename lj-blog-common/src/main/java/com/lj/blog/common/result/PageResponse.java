package com.lj.blog.common.result;

import lombok.Data;
import lombok.Getter;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName PageResponse
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/13 14:35
 * @Version JDK 17
 */
@Data
public class PageResponse<T> implements Serializable {
    private List<T> records;
    private Integer currentPageNum = 1;
    private Integer total = 0;
    private Integer totalPages = 0;
    private Integer pageSize = 15;
    private Integer start = 1;
    private Integer end = 0;

    public PageResponse() {
        this.records = Collections.emptyList();
    }

    public List<T> getRecords() {
        return this.records != null ? this.records : Collections.emptyList();
    }

    public void setRecords(List<T> records) {
        this.records = (records != null && !records.isEmpty()) ? records : Collections.emptyList();
    }

    public void setTotal(Integer total) {
        if (total != null && total >= 0) {
            this.total = total;
            calculateTotalPagesAndBounds();
        }
    }

    private void calculateTotalPagesAndBounds() {
        if (this.pageSize != null && this.pageSize > 0) {
            this.totalPages = (this.total / this.pageSize) + ((this.total % pageSize > 0) ? 1 : 0) ;
            if (this.currentPageNum != null && this.currentPageNum > 0) {
                this.start = (this.currentPageNum - 1) * pageSize + 1;
                this.end = Math.min(this.start + pageSize * this.currentPageNum - 1, total);
            } else {
                this.start = 1;
                this.end = 0;
            }
        } else {
            this.totalPages = 0;
            this.start = 1;
            this.end = 0;
        }
    }
    public void setCurrentPageNum(Integer currentPageNum) {
        this.currentPageNum = currentPageNum;
        calculateTotalPagesAndBounds();
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        calculateTotalPagesAndBounds();
    }

}
