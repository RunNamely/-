package com.summer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factory {

	private Integer id; // 工厂ID
	private Integer flag; // 有效标识 0:有效 1:无效
	private String createTime; // 创建时间
	private Integer createUserid; // 创建人ID
	private String updateTime; // 修改时间
	private Integer updateUserid; // 修改人ID
	private String bak; // 备注
	private String factoryName; // 工厂名称
	private String factoryImgUrl; // 工厂图片
	private String factoryAddr; // 工厂地址
	private String factoryUrl; // 工厂网址
	private Integer factoryWorker; // 工厂人数
	private Integer factoryStatus; // 工厂状态 0:正常 1:关闭

}
