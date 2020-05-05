package com.summer.pojo;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
     * 生产调度表
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSchedule {

	private Integer id;                     //ID标识
	private Integer flag;                   //有效标识  0：有效  1：无效
	
	private Date createTime;                //创建时间
	private Integer createUserid;           //创建人ID
	
	private Date updateTime;                //修改时间
	private Integer updateUserid;           //修改人ID
	private String scheduleSeq;             //工单编号
	private Integer scheduleCount;          //工单数量
	private Integer scheduleStatus;         //工单状态 10：未开始   20：生产中  30：已完成
	private Integer planId;                 //计划ID
	private Integer productId;              //产品ID
	private Integer equipmentId;            //设备ID
	
	private Date startDate;                //开始日期

	private Date endDate;                  //结束日期
	private Integer factoryId;             //工厂ID
	
}
