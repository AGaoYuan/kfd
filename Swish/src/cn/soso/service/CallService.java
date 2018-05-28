package cn.soso.service;

import cn.soso.entity.MobileCard;

/**
 * 通话服务接口
 * @author Mr.Gao
 *
 */
public interface CallService {
	
	public int call(int minCount,MobileCard card) throws Exception;
	
}
