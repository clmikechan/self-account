package tw.clarewinette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tw.clarewinette.models.entities.lists.AccountDataId;
import tw.clarewinette.models.entities.lists.AccountData;

@Repository
public interface AccountDataRepository extends JpaRepository<AccountData, AccountDataId>, JpaSpecificationExecutor<AccountData> {

}
