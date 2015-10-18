package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.Domain.Sale;

import java.util.List;

/**
 * Created by Michael on 17/10/2015.
 */
public interface SaleService {

    List<Sale> getSales();

    Sale getSale(Long id);

    Sale getSaleByOrderId(Long id);

}
