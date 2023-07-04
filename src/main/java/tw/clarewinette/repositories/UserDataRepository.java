package tw.clarewinette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tw.clarewinette.models.entities.UserData;
import tw.clarewinette.models.entities.UserDataId;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, UserDataId>, JpaSpecificationExecutor<UserData> {

}
