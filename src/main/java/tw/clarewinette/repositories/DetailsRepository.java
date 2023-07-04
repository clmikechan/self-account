package tw.clarewinette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tw.clarewinette.models.entities.transactions.Details;
import tw.clarewinette.models.entities.transactions.DetailsId;

@Repository
public interface DetailsRepository extends JpaRepository<Details, DetailsId>, JpaSpecificationExecutor<Details>{

}
