package cn.it.dao;

import java.util.List;

import cn.it.pojo.KeyWordTimes;

/***
 **
 *统计用户搜索关键字
 *
 **/
public interface KeyWordTimesDao {

	void add(KeyWordTimes key);
	List<KeyWordTimes> select(int user_id);
	KeyWordTimes selectUK(int userId, String keyWords);
	void update(KeyWordTimes ke);

}
