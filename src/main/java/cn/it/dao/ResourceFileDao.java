package cn.it.dao;

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
	public void ResourceFileAdd(ResourceFile rf);
	/**
	 * 文件资源删除；
	 * @param （变量为文件资源编号 id，类型为int）；
	 */
	public void ResourceFileDelete(int num);
	/**
	 * 文件资源修改；
	 * @param （变量为文件资源编号 id，类型为int）；
	 */
	public void ResourceFileUpdate(int num);
	/**
	 * 文件资源查看；
	 * @param （变量为文件资源编号 id，类型为int）；
	 */
	public void ResourceFileSearch(int num);
}
