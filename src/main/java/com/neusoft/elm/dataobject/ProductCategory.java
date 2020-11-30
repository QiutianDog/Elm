package com.neusoft.elm.dataobject;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 商品类目
 * @author QiutianDog
 * @Date 2020/11/26
 */
@Entity
@Data
@DynamicUpdate
public class ProductCategory {

    /**
     * 类目ID
     * 类目名
     * 类目类型
     */

    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;

    public ProductCategory() {

    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

}
