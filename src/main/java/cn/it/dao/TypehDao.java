package cn.it.dao;
import cn.it.pojo.Typeh;

/**
 * 
 * @author zhj
 * 
 *  商品一阶类型 的Dao层定义接口
 *
 */
public interface TypehDao {
	/**
	 * 按照商品一阶类型编号查看商品一阶类型
	 * 
	 * @param typeh_id 商品一阶类型编号，int
	 * 
	 * @return Typeh 返回值为一个商品一阶类型
	 */
	public Typeh FindTypehById(int typeh_id);
}
