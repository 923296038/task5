package com.serviceImpl;

import com.mapper.MajorMapper;
import com.pojo.Major;
import com.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service (value = "majorService")
public class MajorServiceImpl implements MajorService {
    @Autowired
    MajorMapper majorMapper;
    @Override
    public List<Major> findMajor() {
        return majorMapper.findMajor();
    }
}
