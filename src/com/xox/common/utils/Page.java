package com.xox.common.utils;

import java.util.Map;

/**
 * 分页类
 * @author zhuw
 * @version 2012-12-7
 */
public class Page {
	private String url;//url路径
	private Map<String,String> paramMap;//参数 
    private int pageIndex; // 当前是第几页
    private int maxPageIndex; // 一共有多少页
    private int maxRowCount; // 一共有多少行
    private int pageSize; // 每页有多少行
    private int curRowNum; // 当前起始记录序号
    /**
     * 是否使用数据库直接分页   false表示使用结果集进行分页
     */
    private boolean useDb = true;//默认使用数据库分页
    
    public Page(){
    	this(10,true);
    }
    
    public Page(int pageSize){
    	this(pageSize,true);
    }
    
    public Page(boolean useDb){
    	this(10,useDb);
    }
    
    public Page(int pageSize,boolean useDb){
    	this.curRowNum = 1;
    	this.pageIndex = 1;
    	this.pageSize = pageSize;
    	this.useDb = useDb;
    }

    
    
	public boolean isUseDb() {
		return useDb;
	}
	public void setUseDb(boolean useDb) {
		this.useDb = useDb;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getMaxPageIndex() {
		return maxPageIndex;
	}
	public void setMaxPageIndex(int maxPageIndex) {
		this.maxPageIndex = maxPageIndex;
	}
	public int getMaxRowCount() {
		return maxRowCount;
	}
	public void setMaxRowCount(int maxRowCount) {
		this.maxRowCount = maxRowCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurRowNum() {
		return curRowNum;
	}
	public void setCurRowNum(int curRowNum) {
		this.curRowNum = curRowNum;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

}
