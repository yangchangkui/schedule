package com.it.ky.schedule.mapper;

import com.it.ky.schedule.entity.EmailInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author: yangchangkui
 * @date: 2018-11-03 17:24
 */
@Mapper
public interface EmailMapper {
    /**
     * 查询需要发送的邮件内容信息
     * @return
     */
    @Select("SELECT id,emailTheme,emailContent FROM email_remind WHERE isUsed = 1 LIMIT 1")
    EmailInfo queryEmailInfo();
}
