package cn.it.dao;

import java.util.List;

import cn.it.pojo.Address;

/**
 * @author wz;
 * 
 *         地址增删改查接口
 * */

public interface AddressDao {
	public void addressAdd(Address address);

	public void addressDelete(Address address);

	public void addressUpdate(Address address);

	public List<Address> addressFind(int user_ID);

	public Address Findbyaddrid(int addressid);
}
