package com.cropdeal.cropservice.service;

import com.cropdeal.cropservice.dto.CropDTO;
import com.cropdeal.cropservice.entity.Crop;
import com.cropdeal.cropservice.exception.CropNotFoundException;
import com.cropdeal.cropservice.mapper.CropMapper;
import com.cropdeal.cropservice.repository.CropRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {

    private static final String CROP_NOT_FOUND = "Crop with ID %d not found";

    private final CropRepository cropRepository;

    @Override
    public CropDTO createCrop(CropDTO cropDTO) {
        Crop crop = CropMapper.mapToCrop(cropDTO);
        return CropMapper.mapToDTO(cropRepository.save(crop));
    }

    @Override
    public List<CropDTO> getAllCrops() {

        return cropRepository.findAll()
                .stream()
                .map(CropMapper::mapToDTO)
                .toList();
    }

    @Override
    public CropDTO getById(Long id) {
        Crop crop = cropRepository.findById(id).orElseThrow(() -> new CropNotFoundException(String.format(CROP_NOT_FOUND, id)));
        return CropMapper.mapToDTO(crop);
    }

    @Override
    public CropDTO updateCrops(Long id, CropDTO cropDTO) {
        Crop crop = cropRepository.findById(id).orElseThrow(() -> new CropNotFoundException(String.format(CROP_NOT_FOUND, id)));

        crop.setCropName(cropDTO.getCropName());
        crop.setCropType(cropDTO.getCropType());
        crop.setPricePerKg(cropDTO.getPricePerKg());
        crop.setQuantity(cropDTO.getQuantity());
        crop.setLocation(cropDTO.getLocation());
        crop.setFarmerId(cropDTO.getFarmerId());
        return CropMapper.mapToDTO(cropRepository.save(crop));
    }

    @Override
    public void deleteCrop(Long id) {
        Crop crop = cropRepository.findById(id).orElseThrow(() -> new CropNotFoundException(String.format(CROP_NOT_FOUND, id)));
        cropRepository.delete(crop);
    }

    public CropDTO getCropByName(String cropName) {
        if (cropName == null || cropName.trim().isEmpty()) {
            throw new IllegalArgumentException("Crop name must not be null or empty");
        }
        Crop crop = cropRepository.findByCropName(cropName).orElseThrow(() -> new CropNotFoundException("Crop not found with name: " + cropName));
        return CropMapper.mapToDTO(crop);
    }
}
