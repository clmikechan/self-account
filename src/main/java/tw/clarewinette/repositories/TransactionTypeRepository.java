package tw.clarewinette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tw.clarewinette.models.entities.lists.TransactionType;
import tw.clarewinette.models.entities.lists.TransactionTypeId;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, TransactionTypeId>, JpaSpecificationExecutor<TransactionType> {

}
