package com.summer.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Integer id;//ID标识
	private Integer flag;//有效标识 0：有效  1:无效		默认：0
	private Date createTime;//创建时间					默认：null
	private Integer createUserid;//创建人ID				默认：null
	private Date updateTime;//修改时间					默认：null
	private Integer updateUserid;//修改人ID				默认：null
	private String productNum;//产品编号
	private String productName;//产品名称
	private String productImgUrl;//产品图片所在目录	默认：null
	private Integer factoryId;//工厂ID
	
}
