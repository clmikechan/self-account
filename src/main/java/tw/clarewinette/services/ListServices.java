package tw.clarewinette.services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tw.clarewinette.models.entities.lists.FrequentlyShop;
import tw.clarewinette.models.entities.lists.FrequentlyShopId;
import tw.clarewinette.repositories.AccountDataRepository;
import tw.clarewinette.repositories.DetailsTypeRepository;
import tw.clarewinette.repositories.FrequentlyShopRepository;
import tw.clarewinette.repositories.TransactionTypeRepository;

@Service
@RequiredArgsConstructor
public class ListServices {
	private final AccountDataRepository accountDataRepository;
	private final DetailsTypeRepository datailsTypeRepository;
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
}
