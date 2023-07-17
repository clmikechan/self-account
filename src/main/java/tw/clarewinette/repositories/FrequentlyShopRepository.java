package tw.clarewinette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tw.clarewinette.models.entities.lists.FrequentlyShop;
import tw.clarewinette.models.entities.lists.FrequentlyShopId;

@Repository
public interface FrequentlyShopRepository extends JpaRepository<FrequentlyShop, FrequentlyShopId>, JpaSpecificationExecutor<FrequentlyShop> {

}
