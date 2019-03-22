package com.busi.domain;

import com.busi.interceptor.annotation.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author WangLei
 * on 2018/6/24
 */
@Entity
@Data
@Table(name = "order")
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String status;
    @Column(name = "date_create")
    private Date dateCreate;
}
