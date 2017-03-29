package cn.it.dao;

import java.util.List;

import cn.it.pojo.ResourceFile;
/**
 * 
 * @author sunchen
 * 资源文件的Dao接口，增删改查
 *
 */
public interface ResourceFileDao {
	/**
	 * 文件资源添加；
	 * @param （变量为文件资源对象 rf，类型为ResourceFile）；
	 */
	public void add(ResourceFile rf);
	/**
	 * 文件资源删除；
	 * @param （变量为文件资源编号 id，类型为int）；
	 */
	public void delete(int num);
	/**
	 * 文件资源查看；
	 * @param （返回所有文件资源的列表）；
	 */
	public List<ResourceFile> findAll();
}
