package cn.it.pojo;
/*
 * @author zhj;
 * 
 * 商品二阶类型 类Typel； 
 * 
 * */
public class Typel {
	private int typel_id;  // 商品二阶类型编号：typel_id(PK)，自增数据，不能手动修改;
	private String name;   // 商品一阶类型名称： name;
	private int typeh_id;  // 商品一阶类型编号：typeh_id(FK);

/**************************************set********get*********************************************/

	public int getTypel_id() {
		return typel_id;
	}
	public void setTypel_id(int typel_id) {
		this.typel_id = typel_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTypeh_id() {
		return typeh_id;
	}
	public void setTypeh_id(int typeh_id) {
		this.typeh_id = typeh_id;
	}
	
/**************************************set********get*******end********************************/

}
