package com.example.secondhomework.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PRODUCTCOMMENT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","User"})
public class ProductComment implements Serializable {
    @SequenceGenerator(name = "generator", sequenceName = "PRODUCTCOMMENT_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "COMMENT", nullable = false, length = 500)
    private String comment;

    @Column(name = "COMMENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT",
            foreignKey = @ForeignKey(name = "FK_COMMENT_PRODUCT_ID")
    )
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER",
            foreignKey = @ForeignKey(name = "FK_COMMENT_USER_ID")
    )
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
