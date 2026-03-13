package com.example.praktikum2.mapper;

import com.example.praktikum2.dto.KtpDto;
import com.example.praktikum2.entity.Ktp;

public class KtpMapper {

    public static KtpDto toDto(Ktp ktp){

        if(ktp == null){
            return null;
        }

        KtpDto dto = new KtpDto();

        dto.setId(ktp.getId());
        dto.setNomorKtp(ktp.getNomorKtp());
        dto.setNamaLengkap(ktp.getNamaLengkap());
        dto.setAlamat(ktp.getAlamat());
        dto.setTanggalLahir(ktp.getTanggalLahir());
        dto.setJenisKelamin(ktp.getJenisKelamin());

        return dto;
    }

    public static Ktp toEntity(KtpDto dto){

        if(dto == null){
            return null;
        }

        Ktp ktp = new Ktp();

        ktp.setId(dto.getId());
        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        return ktp;
    }

}