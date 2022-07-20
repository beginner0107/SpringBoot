package hello.itemservice.domain.item;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    // 저장
    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }
    // 목록
    public List<Item>findAll(){
        return new ArrayList<>(store.values());
    }

    // 수정
    public void update(Long itemId, Item updateParam){
        Item item = findById(itemId);
        item.setItemName(updateParam.getItemName());
        item.setPrice(updateParam.getPrice());
        item.setQuantity(updateParam.getQuantity());
    }
    // 삭제
    public void remove(Long itemId){
        store.remove(itemId);
    }

    public void clearStore(){
        store.clear();
    }


    
}
