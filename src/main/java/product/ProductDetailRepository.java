package product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends CrudRepository <ProductDetail, String>{
    ProductDetail findByInventoryId(String inventoryId);
}