package com.prabhu.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

/**
 * Created by prabhu on 1/10/16.
 */
public class BaseModel extends BaseObject {

    @Id
    private String id;

    @CreatedDate
    private Date cdt;

    @LastModifiedDate
    private Date mdt;
}
