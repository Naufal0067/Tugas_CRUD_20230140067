package com.example.praktikum2.service;

import com.example.praktikum2.dto.KtpDto;

import java.util.List;

public interface KtpService {

    KtpDto create(KtpDto dto);

    List<KtpDto> getAll();



}
