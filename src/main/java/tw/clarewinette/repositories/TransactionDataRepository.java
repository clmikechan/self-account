package tw.clarewinette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tw.clarewinette.models.entities.transactions.TransactionData;
import tw.clarewinette.models.entities.transactions.TransactionDataId;

@Repository
public interface TransactionDataRepository extends JpaRepository<TransactionData, TransactionDataId>, JpaSpecificationExecutor<TransactionData>{

}
