package cn.it.pojo;
/*
 * 
 * 实体类 资源文件 ResourceFile
 * 数据库表 resourcefile
 */
public class ResourceFile {
	private int resourcefile_id;            //资源文件编号：ID(PK)
	private String name;       //文件的名字，便于识别
	private String address;    //文件的存储位置
	private String type;       //文件的类型
	
/*********************set******get***************************************/	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getResourcefile_id() {
		return resourcefile_id;
	}
	public void setResourcefile_id(int resourcefile_id) {
		this.resourcefile_id = resourcefile_id;
	}
	
}
