package com.summer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentProduct {

	private Integer id;//ID标识
	private Integer equipmentId;//设备ID
	private Integer productId;//产品ID
	private Integer yield;//产能
	private Integer unit;//产能单位  10：天  20：月  30：年  40：小时
	private Integer factoryId;//工厂ID
}
