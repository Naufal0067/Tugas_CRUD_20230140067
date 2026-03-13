package com.example.praktikum2.service.Impl;

import com.example.praktikum2.dto.KtpDto;
import com.example.praktikum2.entity.Ktp;
import com.example.praktikum2.mapper.KtpMapper;
import com.example.praktikum2.repository.KtpRepository;
import com.example.praktikum2.service.KtpService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    private final KtpRepository repository;

    public KtpServiceImpl(KtpRepository repository) {
        this.repository = repository;
    }

    @Override
    public KtpDto create(KtpDto dto) {

        repository.findByNomorKtp(dto.getNomorKtp())
                .ifPresent(k -> {
                    throw new RuntimeException("Nomor KTP sudah ada");
                });

        Ktp ktp = repository.save(KtpMapper.toEntity(dto));

        return KtpMapper.toDto(ktp);
    }

    @Override
    public List<KtpDto> getAll() {
        return repository.findAll()
                .stream()
                .map(KtpMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto getById(Integer id) {

        Ktp ktp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        return KtpMapper.toDto(ktp);
    }

    @Override
    public KtpDto update(Integer id, KtpDto dto) {

        Ktp ktp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        return KtpMapper.toDto(repository.save(ktp));
    }

    @Override
    public void delete(Integer id) {

        repository.deleteById(id);

    }
}
