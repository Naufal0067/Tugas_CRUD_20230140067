package com.example.praktikum2.controller;

import com.example.praktikum2.dto.KtpDto;
import com.example.praktikum2.service.KtpService;
import com.example.praktikum2.util.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ktp")
@CrossOrigin(origins = "*")
public class KtpController {

    private final KtpService service;

    public KtpController(KtpService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<KtpDto> create(@RequestBody KtpDto dto) {

        KtpDto result = service.create(dto);

        return new ApiResponse<>(true, "Data berhasil ditambah", result);
    }

    @GetMapping
    public ApiResponse<List<KtpDto>> getAll() {

        List<KtpDto> data = service.getAll();

        return new ApiResponse<>(true, "List data KTP", data);
    }

    @GetMapping("/{id}")
    public ApiResponse<KtpDto> getById(@PathVariable Integer id) {

        KtpDto data = service.getById(id);

        return new ApiResponse<>(true, "Detail data KTP", data);
    }

    @PutMapping("/{id}")
    public ApiResponse<KtpDto> update(@PathVariable Integer id,
                                      @RequestBody KtpDto dto) {

        KtpDto updated = service.update(id, dto);

        return new ApiResponse<>(true, "Data berhasil diupdate", updated);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Integer id) {

        service.delete(id);

        return new ApiResponse<>(true, "Data berhasil dihapus", null);
    }
}