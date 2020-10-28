package com.kyuan.hotel.service.impl;

import com.kyuan.hotel.service.BillService;
import com.kyuan.hotel.domain.Bill;
import com.kyuan.hotel.repository.BillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Bill}.
 */
@Service
@Transactional
public class BillServiceImpl implements BillService {

    private final Logger log = LoggerFactory.getLogger(BillServiceImpl.class);

    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public Bill save(Bill bill) {
        log.debug("Request to save Bill : {}", bill);
        return billRepository.save(bill);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Bill> findAll(Pageable pageable) {
        log.debug("Request to get all Bills");
        return billRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Bill> findOne(Long id) {
        log.debug("Request to get Bill : {}", id);
        return billRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Bill : {}", id);
        billRepository.deleteById(id);
    }
}
