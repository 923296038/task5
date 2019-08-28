package com.serviceImpl;

import com.mapper.MajorMapper;
import com.mapper.StudentMapper;
import com.pojo.Major;
import com.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service (value = "majorService")
public class MajorServiceImpl implements MajorService {
    @Autowired
    MajorMapper majorMapper;
    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<Major> findMajor() {
        return majorMapper.findMajor();
    }

    @Override
    public boolean updateLear(int id) {
        int learning = studentMapper.countByMI(id);
        System.out.println(learning);
        return majorMapper.updateLear(learning ,id);
    }
}
