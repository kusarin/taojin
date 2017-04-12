package cn.it.dao;

import cn.it.pojo.Address;

public interface AddressDao {
    public Address select(int userId);
    public void add(Address address);
}
