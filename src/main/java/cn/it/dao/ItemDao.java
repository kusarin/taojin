package cn.it.dao;

import cn.it.pojo.Item;
/**
 * 
 * @author zhj
 * 
 *  鍟嗗搧鐨凞ao鎺ュ彛锛屽鍒犳敼鏌ワ紱
 *
 */
public interface ItemDao {
	
	/**
	 * 鍟嗗搧娣诲姞锛�
	 * @param 锛堝彉閲忎负鍟嗗搧 i锛岀被鍨嬩负Item锛夛紱
	 */
	public void ItemAdd(Item i);
	/**
	 * 鍟嗗搧鍒犻櫎锛�
	 * @param 锛堝彉閲忎负鍟嗗搧缂栧彿 id锛岀被鍨嬩负int锛夛紱
	 */
	public void ItemDelete(int id);
	/**
	 * 鍟嗗搧淇敼锛�
	 * @param 锛堝彉閲忎负鍟嗗搧缂栧彿 id锛岀被鍨嬩负int锛夛紱
	 */
	public void ItemUpdate(int id);
	/**
	 * 鍟嗗搧鏌ョ湅锛�
	 * @param 锛堝彉閲忎负鍟嗗搧缂栧彿 id锛岀被鍨嬩负int锛夛紱
	 * @return 
	 */
	public Item ItemSearch(int id);
}
