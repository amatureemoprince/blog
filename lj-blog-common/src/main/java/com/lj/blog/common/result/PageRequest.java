package com.lj.blog.common.result;


/**
 * @ClassName PageRequest
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/13 14:30
 * @Version JDK 17
 */
public class PageRequest {
    private Integer pageNum;

    private Integer pageSize;

    private Integer offset;


    public Integer getOffset() {
        return (getPageNum() - 1) * getPageSize();
    }

    public Integer getPageNum(){
        if(pageNum == null || pageNum < 1){
            pageNum = 1;
        }
        return pageNum;
    }
    public Integer getPageSize(){
        if(pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE - 1){
            return 10;
        }
        return pageSize;
    }
}
