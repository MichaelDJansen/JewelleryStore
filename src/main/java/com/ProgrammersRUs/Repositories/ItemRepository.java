package com.ProgrammersRUs.Repositories;

import com.ProgrammersRUs.Domain.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Michael on 17/10/2015.
 */
public interface ItemRepository extends CrudRepository<Item,Long> {
}
