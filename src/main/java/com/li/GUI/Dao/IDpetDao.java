package com.li.GUI.Dao;

import com.li.GUI.Entity.Dept;

import java.util.List;

public interface IDpetDao {
    /**
     * 查找全部学生信息
     * @return
     */
    List<Dept> queryAll();
}
