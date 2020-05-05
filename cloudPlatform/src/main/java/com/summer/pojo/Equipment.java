package com.summer.pojo;


import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
public class Equipment {

	private Integer id;//ID标识
	private Integer flag;//有效标识 0：有效  1：失效
	private Date createTime;//创建时间
	private Integer createUserId;//创建人ID
	private Date updateTime;//修改时间
	private Integer updateUserId;//修改人ID
	private String equipmentSeq;//设备序号
	private String equipmentName;//设备名称
	private String equipmentImgUrl;//设备图片
	private Integer equipmentStatus;//设备状态 10：启用  20：停用  30：故障
	private Integer factoryId;//工厂ID
	

}
