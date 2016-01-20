package com.dongyuan.figting.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dongyuan.figting.dto.request.AddressRequest;
import com.dongyuan.figting.dto.response.AddressInfoRes;
import com.dongyuan.figting.dto.request.AddressModifyRequest;
import com.dongyuan.figting.service.IAddressService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.midea.cmo2o.ticket.api.TicketServiceFacade;
import com.midea.cmo2o.ticket.api.dto.AddressData;
import com.midea.cmo2o.ticket.api.dto.Result;

@Service(value = "addressService")
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private TicketServiceFacade ticketServiceFacade;

	@Override
	public List<AddressInfoRes> getAddrsByTicketId(String ticketId) {
		Assert.notNull(ticketId);
		List<AddressInfoRes> addressInfoRess = new ArrayList<AddressInfoRes>();
		Result<List<AddressData>> result = ticketServiceFacade.getAddresses(ticketId);
		List<AddressData> addressDatas = result.getData();
		if (CollectionUtils.isNotEmpty(addressDatas)) {
			AddressInfoRes addressInfoRes = null;
			for (AddressData item : addressDatas) {
				addressInfoRes = new AddressInfoRes();
				BeanUtils.copyProperties(item, addressInfoRes);
				addressInfoRess.add(addressInfoRes);
			}
		}
		
		return addressInfoRess;
	}

	@Override
	public Long addAddress(AddressRequest addrReq) {
		AddressData address = new AddressData();
		BeanUtils.copyProperties(addrReq, address);
		Result<Long> result = ticketServiceFacade.addAddress(address);
		if(result.isOk()){
			return result.getData();
		}
		return (long) result.getErrcode();
	}

	@Override
	public boolean updateAddress(AddressModifyRequest addrReq) {
		AddressData address = new AddressData();
		BeanUtils.copyProperties(addrReq, address);
		@SuppressWarnings("rawtypes")
		Result result = ticketServiceFacade.updateAddress(address);
		return result.isOk();
	}

	@Override
	public boolean deleteAddress(Long id) {
		@SuppressWarnings("rawtypes")
		Result result = ticketServiceFacade.deleteAddress(id);
		return result.isOk();
	}

}
