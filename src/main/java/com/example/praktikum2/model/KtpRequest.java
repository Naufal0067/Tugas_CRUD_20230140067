package com.example.praktikum2.model;

import lombok.Data;

import java.util.Date;

@Data
public class KtpRequest {

    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private Date tanggalLahir;
    private String jenisKelamin;

}