package cn.it.pojo;
/*
 * @author zhj;
 * 
 * 评论类 Discuss； 
 * 
 * */
public class Discuss {
	private int discuss_id;     //评论编号：disscuss_id(PK)，自增数据，不能手动修改
	private String content;     //评论内容：content
	
	private int item_id;        //商品编号：item_id；所评论的商品标识，外键，和店铺编号只能存在一个
	private int shop_id;        //店铺编号：shop_id；所评论店铺的表示，外键，和商品编号只能存在一个

/**************************************set********get*********************************************/
	
	public int getDiscuss_id() {
		return discuss_id;
	}
	public void setDiscuss_id(int discuss_id) {
		this.discuss_id = discuss_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	/**************************************set********get*******end********************************/
	
	/**
	 * toString方法，测试用。
	 * 目前只针对商品评论
	 * 输出商品的属性
	 */
	@Override
	public String toString(){
		return "\n 评论["+ discuss_id +"] :评论归属["+ item_id +"]" + "评论内容：[" + content + "]";
	}
	
}
