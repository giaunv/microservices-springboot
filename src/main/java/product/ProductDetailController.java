package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductDetailController {
    private final ProductDetailRepository repository;
    private final ProductDetailValidator validator;

    @Autowired
    public ProductDetailController(ProductDetailRepository repository, ProductDetailValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable findAll(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                            @RequestParam(value = "count", defaultValue = "10", required = false) int count,
                            @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
                            @RequestParam(value = "sort", defaultValue = "productName", required = false) String sortProperty) {
        Page result = repository.findAll(new PageRequest(page, count, new Sort(direction, sortProperty)));
        return result.getContent();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProductDetail create(@RequestBody @Valid ProductDetail detail) {
        return repository.save(detail);
    }
}