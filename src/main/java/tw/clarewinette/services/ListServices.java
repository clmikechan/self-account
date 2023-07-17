package tw.clarewinette.services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tw.clarewinette.models.apis.list.DetailsTypeRequest;
import tw.clarewinette.models.entities.lists.AccountData;
import tw.clarewinette.models.entities.lists.AccountDataId;
import tw.clarewinette.models.entities.lists.DetailsType;
import tw.clarewinette.models.entities.lists.DetailsTypeId;
import tw.clarewinette.models.entities.lists.FrequentlyShop;
import tw.clarewinette.models.entities.lists.FrequentlyShopId;
import tw.clarewinette.models.entities.lists.TransactionType;
import tw.clarewinette.models.entities.lists.TransactionTypeId;
import tw.clarewinette.repositories.AccountDataRepository;
import tw.clarewinette.repositories.DetailsTypeRepository;
import tw.clarewinette.repositories.FrequentlyShopRepository;
import tw.clarewinette.repositories.TransactionTypeRepository;

@Service
@RequiredArgsConstructor
public class ListServices {
	private final AccountDataRepository accountDataRepository;
	private final DetailsTypeRepository detailsTypeRepository;
	private final FrequentlyShopRepository frequentlyShopRepository;
	private final TransactionTypeRepository transactioTypeRepository;

	public void addFrequentlyShop(int userId, String frequentlyShopName) {
		Specification<FrequentlyShop> spec = Specification.where(null);
		spec = spec.and(FrequentlyShop.userIdEqual(userId));

		List<FrequentlyShop> frequentlyShopList = frequentlyShopRepository.findAll(spec);
		int frequentlyShopNo = frequentlyShopList.stream().map(x -> x.getId().getFrequentlyShopNo()).mapToInt(v -> v + 1).max().orElse(0);
		FrequentlyShopId frequantlyShopId = FrequentlyShopId.builder().userId(userId).frequentlyShopNo(frequentlyShopNo).build();
		FrequentlyShop frequantlyShop = FrequentlyShop.builder().id(frequantlyShopId).frequentlyShopName(frequentlyShopName).build();
		frequentlyShopRepository.save(frequantlyShop);

	}

	public void addTransactionType(int userId, String transactionTypeName) {
		Specification<TransactionType> spec = Specification.where(null);
		spec = spec.and(TransactionType.userIdEqual(userId));

		List<TransactionType> transactionTypeList = transactioTypeRepository.findAll(spec);
		int transactionTypeNo = transactionTypeList.stream().map(x -> x.getId().getTransactionTypeNo()).mapToInt(v -> v + 1).max().orElse(0);
		TransactionTypeId transactionTypeId = TransactionTypeId.builder().userId(userId).transactionTypeNo(transactionTypeNo).build();
		TransactionType frequantlyShop = TransactionType.builder().id(transactionTypeId).transactionTypeName(transactionTypeName).build();
		transactioTypeRepository.save(frequantlyShop);

	}

	public void addAccountData(int userId, String accountName) {
		Specification<AccountData> spec = Specification.where(null);
		spec = spec.and(AccountData.userIdEqual(userId));

		List<AccountData> accountDataList = accountDataRepository.findAll(spec);
		int accountNo = accountDataList.stream().map(x -> x.getId().getAccountNo()).mapToInt(v -> v + 1).max().orElse(0);
		AccountDataId accountDataId = AccountDataId.builder().userId(userId).accountNo(accountNo).build();
		AccountData accountData = AccountData.builder().id(accountDataId).accountName(accountName).build();
		accountDataRepository.save(accountData);

	}

	public void addDetailsType(int userId, DetailsTypeRequest detailsTypeRequest) {
		Specification<DetailsType> spec = Specification.where(null);
		spec = spec.and(DetailsType.userIdEqual(userId));

		List<DetailsType> detailsTypeList = detailsTypeRepository.findAll(spec);
		int detailsTypeNo = detailsTypeList.stream().map(x -> x.getId().getDetailsTypeNo()).mapToInt(v -> v + 1).max().orElse(0);
		DetailsTypeId detailsTypeId = DetailsTypeId.builder().userId(userId).detailsTypeNo(detailsTypeNo).build();
		DetailsType detailsType = DetailsType.builder().id(detailsTypeId).detailsTypeName(detailsTypeRequest.getDetailsTypeName()).addSubtractTerm(detailsTypeRequest.getAddSubtractTerm()).build();
		detailsTypeRepository.save(detailsType);

	}

}
