package com.example.beauty.dao;


import com.example.beauty.mapper.TypeMapper;

import com.example.beauty.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by lemon on 2020-02-19 11:50.
 */
@Repository
public class TypeDao {
    @Autowired
    private TypeMapper typeMapper;

    public List<Type> getType() {
        Example example = new Example(Type.class);
        example.createCriteria()
                .andLike("code","00_");
        return typeMapper.selectByExample(example);
    }

    public Type getTypeById(Long typeId) {
        return typeMapper.selectByPrimaryKey(typeId);
    }
    public List<Type> getItemType(String code) {
        Example example = new Example(Type.class);
        example.createCriteria()
                .andLike("code",code+"0%");
        return typeMapper.selectByExample(example);
    }

    public List<Type> getProductType(String code) {
        Example example = new Example(Type.class);
        example.createCriteria()
                .andLike("code",code+"0%");
        return typeMapper.selectByExample(example);
    }

    public Integer insert(Type type) {
        return typeMapper.insert(type);
    }

    public Integer deleteTpyeById(Long id) {
        return typeMapper.deleteByPrimaryKey(id);
    }
}
