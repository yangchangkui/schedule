package com.it.ky.schedule.mapper;

import com.it.ky.schedule.entity.DutyUser;
import com.it.ky.schedule.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 用户Mapper
 * @author: yangchangkui
 * @date: 2018-11-03 10:47
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有人
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> queryAllUser();

    /**
     *查询要发送邮件账号
     * @return
     */
    @Select("SELECT u.email FROM duty d LEFT JOIN user u ON u.id = d.userId WHERE dutyDate = #{currDate}")
    List<String> queryDutyUserEmails(@Param("currDate") String currDate);


    /**
     * 查询值日生
     * @return
     */
    @Select("SELECT d.dutyDate,u.name,u.motto FROM duty d LEFT JOIN user u ON u.id = d.userId ")
    List<Map> queryAllDutyUser();

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Insert("INSERT INTO user(name,email,motto,photoPath) VALUES(#{name},#{email},#{motto},#{photoPath})")
    int insertUser(User user);


    /**
     * 查询库中数据
     * @param id
     * @param strDate
     * @return
     */
    @Select("SELECT * FROM duty WHERE dutyDate = #{strDate}")
    DutyUser queryDutyUser(int id, String strDate);

    /**
     * 新增或更新值日生
     * @param id
     * @param strDate
     * @return
     */
    @Update("UPDATE duty SET userId = #{id} WHERE dutyDate = #{strDate}")
    int updateDutyUser(int id, String strDate);

    /**
     * 新增或更新值日生
     * @param id
     * @param strDate
     * @return
     */
    @Insert("INSERT INTO duty(userId,dutyDate,createBy,createDate) VALUES(#{id},#{strDate},'系统',sysdate()) ")
    int insertDutyUser(int id, String strDate);
}
