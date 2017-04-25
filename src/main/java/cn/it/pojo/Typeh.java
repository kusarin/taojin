package cn.it.pojo;
/*
 * @author zhj;
 * 
 * 商品一阶类型 类Typeh； 
 * 
 * */
public class Typeh {
	private int typeh_id;  // 商品一阶类型编号：typeh_id(PK)，自增数据，不能手动修改;
	private String name;   // 商品一阶类型名称： name;
	
/**************************************set********get*********************************************/
	
	public int getTypeh_id() {
		return typeh_id;
	}
	public void setTypeh_id(int typeh_id) {
		this.typeh_id = typeh_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
/**************************************set********get*******end********************************/
		
}
