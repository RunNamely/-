package com.summer.pojo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTrack {

	private Integer id; // ID标识
	private Integer flag; // 有效标识 0:有效 1:无效
	private Date createTime; // 创建时间
	private Integer createUserid; // 创建人ID
	private Date updateTime; // 修改时间
	private Integer updateUserid; // 修改人ID
	private Integer scheduleId; // 调度id
	private Integer planId; // 计划id
	private Integer productId; // 产品id
	private Integer workingCount; // 加工数量
	private Integer qualifiedCount; // 合格数
	private Integer factoryId; // 工厂id

}
