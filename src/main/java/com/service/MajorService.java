package com.service;

import com.pojo.Major;

import java.util.List;

public interface MajorService {
    List<Major> findMajor();
    boolean updateLear(int id);
}
