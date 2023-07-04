package tw.clarewinette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import tw.clarewinette.models.entities.lists.DetailsType;
import tw.clarewinette.models.entities.lists.DetailsTypeId;

public interface DetailsTypeRepository extends JpaRepository<DetailsType, DetailsTypeId>, JpaSpecificationExecutor<DetailsType> {

}
