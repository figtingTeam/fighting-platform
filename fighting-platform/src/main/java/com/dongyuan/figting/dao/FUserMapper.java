package com.dongyuan.figting.dao;

import com.dongyuan.figting.dao.annotations.IRepository;
import com.dongyuan.figting.entity.FUser;
import com.dongyuan.figting.entity.FUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述： 用户信息持久层
 *
 * @author huanghf
 * @email 736943550@qq.com
 * @date 2016年01月21日 10:11
 * @copyright 美的电子商务有限公司
 */
@IRepository
public interface FUserMapper {
    int countByExample(FUserExample example);

    int deleteByExample(FUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FUser record);

    int insertSelective(FUser record);

    List<FUser> selectByExample(FUserExample example);

    FUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FUser record, @Param("example") FUserExample example);

    int updateByExample(@Param("record") FUser record, @Param("example") FUserExample example);

    int updateByPrimaryKeySelective(FUser record);

    int updateByPrimaryKey(FUser record);
}