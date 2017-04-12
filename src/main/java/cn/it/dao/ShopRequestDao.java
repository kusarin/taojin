package cn.it.dao;

import java.util.List;
import cn.it.pojo.ShopRequest;

public interface ShopRequestDao {
	
	public void add(ShopRequest shopRequest);
	
	public List<ShopRequest> findAll();
	
	public void delete(int num);
	
	public ShopRequest findById(int num);
	
}
