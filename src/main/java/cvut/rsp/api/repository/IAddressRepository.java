package cvut.rsp.api.repository;

import cvut.rsp.dao.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> { }
