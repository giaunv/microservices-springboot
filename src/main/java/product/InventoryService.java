package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private final ProductDetailRepository productDetailRepository;

    @Autowired
    public InventoryService(ProductDetailRepository productDetailRepository){
        this.productDetailRepository = productDetailRepository;
    }

    boolean isValidInventory(String inventoryId){
        return productDetailRepository.findByInventoryId(inventoryId) == null;
    }
}
