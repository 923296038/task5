package com.mapper;

import com.pojo.Major;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MajorMapper {
    List<Major> findMajor();


    boolean updateLear(@Param("learning") int learning,@Param("id") int id);
}
