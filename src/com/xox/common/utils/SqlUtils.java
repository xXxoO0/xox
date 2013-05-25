package com.xox.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlUtils {
	private static final Logger log = LoggerFactory
			.getLogger(SqlUtils.class);
	/**
	 * //组织 in 中的数据 拼成sql
	 * @param inValues
	 * @return
	 */
	public static String getInSqlStr(int length){
		StringBuffer insql = new StringBuffer();
		insql.append(" (");
		int index=0;
		for(int i=0;i<length;i++){
			index++;
			if(index==length){
				insql.append("?");
			}else{
				insql.append("?,");
			}
		}
		insql.append(") ");
		log.info(insql.toString());
		return insql.toString();
	}
	/**
	 * 用于分页计算最大条数 把select * from 替换车 select count(1) from 
	 * @param presql
	 * @return
	 */
	public static String getCountSql(String presql){
		StringBuffer sql = new StringBuffer();
		int formIndex = presql.indexOf("from");
		if(formIndex==-1){
			log.error("sql语句有错误，不存在from关键字");
			return presql;
		}
		sql.append("select count(1) "+presql.substring(formIndex, presql.length()));
		log.info(sql.toString());
		return sql.toString();
	}
	/**
	 * 组织简单分页查询sql(mysql用)适用于100W数据一下的分页
	 * @param sql 原sql
	 * @param page 
	 * @return
	 */
	public static String getPageSqlMq(String presql,Page page){
		StringBuffer sql = new StringBuffer();
		sql.append(presql);
		if(page.getPageIndex()==1){
			sql.append(" limit 0,"+page.getPageSize());
		}else{
			sql.append(" limit "+(page.getPageIndex()-1)*page.getPageSize()+","+page.getPageSize());
		}
		log.info(sql.toString());
		return sql.toString();
	}
	/**
	 * 组织分页查询sql(sqlserver用)
	 * @param sql 原sql
	 * @param page 
	 * @return
	 */
	public static String getPageSqlSq(String sql,Page page){
		
		return "";
	}
	/**
	 * 组织分页查询sql(oracle用)
	 * @param sql 原sql
	 * @param page 
	 * @return
	 */
	public static String getPageSqlOq(String sql,Page page){
		
		return "";
	}
	/**
	 * 生成id
	 * 单签时间毫秒+随机数取出三位
	 * @return
	 */
	public static String getGuid(){
		GuidUtils guidUtils = new GuidUtils();
		return guidUtils.generateHex();
	}
}
