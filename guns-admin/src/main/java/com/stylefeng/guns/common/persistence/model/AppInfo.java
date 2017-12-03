package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng
 * @since 2017-12-03
 */
@TableName("app_info")
public class AppInfo extends Model<AppInfo> {

    private static final long serialVersionUID = 1L;

	private String id;
	private Long version;
	@TableField("enable_flag")
	private Integer enableFlag;
	@TableField("item_order")
	private Integer itemOrder;
	@TableField("date_created")
	private Date dateCreated;
	private String code;
	@TableField("last_updated")
	private Date lastUpdated;
	private String name;
	private String extention;
	private String description;
	@TableField("create_user")
	private String createUser;
	@TableField("update_user")
	private String updateUser;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Integer getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(Integer enableFlag) {
		this.enableFlag = enableFlag;
	}

	public Integer getItemOrder() {
		return itemOrder;
	}

	public void setItemOrder(Integer itemOrder) {
		this.itemOrder = itemOrder;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "AppInfo{" +
			"id=" + id +
			", version=" + version +
			", enableFlag=" + enableFlag +
			", itemOrder=" + itemOrder +
			", dateCreated=" + dateCreated +
			", code=" + code +
			", lastUpdated=" + lastUpdated +
			", name=" + name +
			", extention=" + extention +
			", description=" + description +
			", createUser=" + createUser +
			", updateUser=" + updateUser +
			"}";
	}
}
