package com.ProgrammersRUs.Repositories;

import com.ProgrammersRUs.Domain.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Michael on 17/10/2015.
 */
@Repository
public interface OrderRepository extends CrudRepository<Orders,Long>{
}
