package com.qh.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * travelperson
 * @author 
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Travelperson  implements Serializable {

    private String personfnumber;

    private String datestr;

    private String personfname;

    private String depname;

    private String msg;

    private String money;
    private static final long serialVersionUID = 1L;


}