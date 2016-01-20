package com.dongyuan.figting.impl.service;

import java.util.List;

import com.dongyuan.figting.impl.dto.request.AddressModifyRequest;
import com.dongyuan.figting.impl.dto.request.AddressRequest;
import com.dongyuan.figting.impl.dto.response.AddressInfoRes;

/**
 * 类ITicketService.java的实现描述：认筹券接口
 * 
 * @author huanghf 2015年12月24日 下午5:34:46
 * @email haifeng1.huang@midea.com
 */
public interface IAddressService {

	/**
	 * 返回认筹券的送货地址列表，按修改时间倒序排列（最新为默认地址）
	 * @param ticketId
	 * @return
	 */
	List<AddressInfoRes> getAddrsByTicketId(String ticketId);
	
	/**
	 * 增加送货地址, id, createTime, updateTime 不用填写
	 * @param addrReq
	 * @return 返回新地址ID
	 */
	Long addAddress(AddressRequest addrReq);
	
	/**
	 * 更新送货地址。
	 * @param addrReq
	 * @return
	 */
	boolean updateAddress(AddressModifyRequest addrReq);
	
	/**
     * 删除送货地址
     * @param id
     * @return
     */
	boolean deleteAddress(Long id);
}
