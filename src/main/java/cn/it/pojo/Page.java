package cn.it.pojo;

import java.util.List;

public class Page<T> {
	private int pagestart = 0;
	private int pagesize = 5;
	private int pageNo = 1;
	private int totalrecord = 0;
	private List<T> datas;

	
	public int getTotalpage() {
		return (totalrecord + pagesize - 1) / pagesize;
	}
	///////////////////////////
	public int getPagesize() {
		return pagesize;
	}

	public int getPagestart() {
		return pagestart;
	}


	public void setPagestart(int pagestart) {
		this.pagestart = pagestart;
	}


	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

}
