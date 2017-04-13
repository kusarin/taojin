package cn.it.service;

import java.util.List;

import cn.it.pojo.ShopRequest;

public interface ShopRequestService {
	public List<ShopRequest> findAll();

	public void delete(int num);

	public void passSR(int num);

	public ShopRequest find(int num);

}
