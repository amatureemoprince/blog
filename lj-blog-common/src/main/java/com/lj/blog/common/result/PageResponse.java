package com.lj.blog.common.result;

import lombok.Builder;
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
    private Integer currentPageNum;
    private Integer pageSize;
    private Integer totalPages;
    private Integer total;
    public PageResponse() {
        this.records = Collections.emptyList();
    }
    public List<T> getRecords() {
        return this.records != null ? this.records : Collections.emptyList();
    }
    //设置在最后设置内容，在这之前需要将total、pageSize、currentPageNum设置完整
    public void setRecords(List<T> records) {
        this.records = (records != null && !records.isEmpty()) ? records : Collections.emptyList();
        compute(this.pageSize);
    }
    void compute(Integer pageSize){
        this.totalPages = this.total % pageSize == 0 ? this.total / pageSize : this.total / pageSize + 1;
    }
    //设置总数和pageSize就可以得知总的页数
}
