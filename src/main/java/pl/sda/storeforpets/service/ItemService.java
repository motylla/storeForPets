package pl.sda.storeforpets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.storeforpets.model.Item;
import pl.sda.storeforpets.repository.ItemRepository;

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
}
