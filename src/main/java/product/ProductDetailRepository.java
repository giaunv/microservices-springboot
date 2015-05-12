package product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends PagingAndSortingRepository<ProductDetail, String> {
    ProductDetail findByInventoryId(String inventoryId);
}