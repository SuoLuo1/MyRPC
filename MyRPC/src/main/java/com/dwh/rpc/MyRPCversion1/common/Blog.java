package com.dwh.rpc.MyRPCversion1.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 *@title Blog
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/26 下午9:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blog implements Serializable {
    private Integer id;
    private Integer useId;
    private String title;
}
