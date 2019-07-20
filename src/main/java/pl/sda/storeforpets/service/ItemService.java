package pl.sda.storeforpets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.sda.storeforpets.model.Item;
import pl.sda.storeforpets.repository.ItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItemToDatabase(Item item) {
        itemRepository.save(item);
    }

    public List<Item> showAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> showItemByCategory(Enum category) {

        return showAllItems().stream().filter(item -> item.getCategory().equals(category)).collect(Collectors.toList());
    }

}
