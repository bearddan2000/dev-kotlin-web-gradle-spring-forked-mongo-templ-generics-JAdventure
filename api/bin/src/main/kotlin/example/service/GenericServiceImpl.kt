package example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.repository.GenericRepository;

/**
 * @author ragcrix
 */
@Service
class GenericServiceImpl<T>
: GenericService<T>{

  @Autowired
  lateinit var genericRepository: GenericRepository<T>

  override fun findAll(c: Class<T>): List<T> = genericRepository.findAll(c)

  override fun findByField(c: Class<T>, field: String, value: String): T  = genericRepository.findByField(c, field, value)
}
